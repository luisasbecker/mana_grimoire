package com.tbuonomo.viewpagerdotsindicator.compose;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tbuonomo.viewpagerdotsindicator.compose.type.BalloonIndicatorType;
import com.tbuonomo.viewpagerdotsindicator.compose.type.IndicatorType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DotsIndicator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001as\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102%\b\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001a\u001a \u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0003H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f²\u0006\n\u0010 \u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"DotsIndicator", "", "dotCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "dotSpacing", "Landroidx/compose/ui/unit/Dp;", "type", "Lcom/tbuonomo/viewpagerdotsindicator/compose/type/IndicatorType;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "DotsIndicator-TN_CM5M", "(ILandroidx/compose/ui/Modifier;FLcom/tbuonomo/viewpagerdotsindicator/compose/type/IndicatorType;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/runtime/Composer;II)V", "currentPage", "currentPageOffsetFraction", "Lkotlin/Function0;", "", "onDotClicked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "DotsIndicator-AFY4PWA", "(ILandroidx/compose/ui/Modifier;FLcom/tbuonomo/viewpagerdotsindicator/compose/type/IndicatorType;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "DotsIndicatorPreview", "(Landroidx/compose/runtime/Composer;I)V", "computeGlobalScrollOffset", "position", "positionOffset", "totalCount", "viewpagerdotsindicator_release", "globalOffset"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DotsIndicatorKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0137  */
    /* JADX INFO: renamed from: DotsIndicator-AFY4PWA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m11283DotsIndicatorAFY4PWA(final int i, Modifier modifier, float f, final IndicatorType type, final int i2, final Function0<Float> currentPageOffsetFraction, Function1<? super Integer, Unit> function1, Composer composer, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9;
        Function1<? super Integer, Unit> function12;
        boolean zChanged;
        Object objRememberedValue;
        final State state;
        boolean zChanged2;
        Object objRememberedValue2;
        final Modifier modifier3;
        final float f3;
        final Function1<? super Integer, Unit> function13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(currentPageOffsetFraction, "currentPageOffsetFraction");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1298032090);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i5 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i10 = i4 & 2;
        if (i10 != 0) {
            i5 |= 48;
        } else {
            if ((i3 & 112) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i3 & 896) == 0) {
                    f2 = f;
                    i5 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
                }
                if ((i4 & 8) != 0) {
                    i5 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    i5 |= composerStartRestartGroup.changed(type) ? 2048 : 1024;
                }
                if ((i4 & 16) != 0) {
                    i5 |= 24576;
                } else if ((i3 & 57344) == 0) {
                    i5 |= composerStartRestartGroup.changed(i2) ? 16384 : 8192;
                }
                if ((i4 & 32) == 0) {
                    if ((i3 & 458752) == 0) {
                        i7 = composerStartRestartGroup.changedInstance(currentPageOffsetFraction) ? 131072 : 65536;
                    }
                    i8 = i4 & 64;
                    if (i8 == 0) {
                        i5 |= 1572864;
                        i9 = 57344;
                        function12 = function1;
                    } else {
                        i9 = 57344;
                        function12 = function1;
                        if ((i3 & 3670016) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function12) ? 1048576 : 524288;
                        }
                    }
                    if ((i5 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        float fM9114constructorimpl = i6 == 0 ? Dp.m9114constructorimpl(12.0f) : f2;
                        Function1<? super Integer, Unit> function14 = i8 == 0 ? null : function12;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1298032090, i5, -1, "com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator (DotsIndicator.kt:45)");
                        }
                        float fFloatValue = currentPageOffsetFraction.invoke().floatValue();
                        composerStartRestartGroup.startReplaceGroup(581567513);
                        zChanged = composerStartRestartGroup.changed(fFloatValue) | ((i5 & 14) != 4) | ((i5 & i9) == 16384);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorKt$DotsIndicator$globalOffset$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(DotsIndicatorKt.computeGlobalScrollOffset(i2, currentPageOffsetFraction.invoke().floatValue(), i));
                                }
                            });
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        state = (State) objRememberedValue;
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(581574632);
                        zChanged2 = composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = (Function0) new Function0<Float>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorKt$DotsIndicator$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(DotsIndicatorKt.DotsIndicator_AFY4PWA$lambda$2(state));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        int i11 = i5 << 6;
                        modifier3 = modifier2;
                        type.mo11295IndicatorTypeComposablejt2gSs((Function0) objRememberedValue2, modifier3, i, fM9114constructorimpl, function14, composerStartRestartGroup, (i5 & 112) | (i11 & 896) | ((i5 << 3) & 7168) | ((i5 >> 6) & i9) | (i11 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f3 = fM9114constructorimpl;
                        function13 = function14;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        f3 = f2;
                        function13 = function12;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorKt$DotsIndicator$5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i12) {
                                DotsIndicatorKt.m11283DotsIndicatorAFY4PWA(i, modifier3, f3, type, i2, currentPageOffsetFraction, function13, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
                            }
                        });
                        return;
                    }
                    return;
                }
                i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i5 |= i7;
                i8 = i4 & 64;
                if (i8 == 0) {
                }
                if ((i5 & 2995931) == 599186) {
                    if (i10 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    float fFloatValue2 = currentPageOffsetFraction.invoke().floatValue();
                    composerStartRestartGroup.startReplaceGroup(581567513);
                    if ((i5 & 14) != 4) {
                    }
                    if ((i5 & i9) == 16384) {
                    }
                    zChanged = composerStartRestartGroup.changed(fFloatValue2) | ((i5 & 14) != 4) | ((i5 & i9) == 16384);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorKt$DotsIndicator$globalOffset$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                return Float.valueOf(DotsIndicatorKt.computeGlobalScrollOffset(i2, currentPageOffsetFraction.invoke().floatValue(), i));
                            }
                        });
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        state = (State) objRememberedValue;
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(581574632);
                        zChanged2 = composerStartRestartGroup.changed(state);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = (Function0) new Function0<Float>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorKt$DotsIndicator$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(DotsIndicatorKt.DotsIndicator_AFY4PWA$lambda$2(state));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            composerStartRestartGroup.endReplaceGroup();
                            int i112 = i5 << 6;
                            modifier3 = modifier2;
                            type.mo11295IndicatorTypeComposablejt2gSs((Function0) objRememberedValue2, modifier3, i, fM9114constructorimpl, function14, composerStartRestartGroup, (i5 & 112) | (i112 & 896) | ((i5 << 3) & 7168) | ((i5 >> 6) & i9) | (i112 & 458752));
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            f3 = fM9114constructorimpl;
                            function13 = function14;
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            f2 = f;
            if ((i4 & 8) != 0) {
            }
            if ((i4 & 16) != 0) {
            }
            if ((i4 & 32) == 0) {
            }
            i5 |= i7;
            i8 = i4 & 64;
            if (i8 == 0) {
            }
            if ((i5 & 2995931) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        f2 = f;
        if ((i4 & 8) != 0) {
        }
        if ((i4 & 16) != 0) {
        }
        if ((i4 & 32) == 0) {
        }
        i5 |= i7;
        i8 = i4 & 64;
        if (i8 == 0) {
        }
        if ((i5 & 2995931) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: DotsIndicator-TN_CM5M, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m11284DotsIndicatorTN_CM5M(final int i, Modifier modifier, float f, final IndicatorType type, final PagerState pagerState, Composer composer, final int i2, final int i3) {
        int i4;
        float f2;
        Object objRememberedValue;
        boolean z;
        Object objRememberedValue2;
        final float f3;
        final Modifier modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Composer composerStartRestartGroup = composer.startRestartGroup(2032190952);
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i5 = i3 & 2;
        if (i5 != 0) {
            i4 |= 48;
        } else if ((i2 & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i6 = i3 & 4;
        if (i6 == 0) {
            if ((i2 & 896) == 0) {
                f2 = f;
                i4 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
            }
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i2 & 7168) == 0) {
                i4 |= composerStartRestartGroup.changed(type) ? 2048 : 1024;
            }
            if ((i3 & 16) == 0) {
                i4 |= 24576;
            } else if ((i2 & 57344) == 0) {
                i4 |= composerStartRestartGroup.changed(pagerState) ? 16384 : 8192;
            }
            if ((46811 & i4) == 9362 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier;
                float fM9114constructorimpl = i6 == 0 ? Dp.m9114constructorimpl(12.0f) : f2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2032190952, i4, -1, "com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator (DotsIndicator.kt:22)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -954367824, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier3 = companion;
                float f4 = fM9114constructorimpl;
                int currentPage = pagerState.getCurrentPage();
                composerStartRestartGroup.startReplaceGroup(581553696);
                z = (i4 & 57344) != 16384;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function0) new Function0<Float>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorKt$DotsIndicator$1$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Float invoke() {
                            return Float.valueOf(pagerState.getCurrentPageOffsetFraction());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                m11283DotsIndicatorAFY4PWA(i, modifier3, f4, type, currentPage, (Function0) objRememberedValue2, new Function1<Integer, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorKt$DotsIndicator$2

                    /* JADX INFO: renamed from: com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorKt$DotsIndicator$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: DotsIndicator.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorKt$DotsIndicator$2$1", f = "DotsIndicator.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ int $dotIndex;
                        final /* synthetic */ PagerState $pagerState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(PagerState pagerState, int i, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$pagerState = pagerState;
                            this.$dotIndex = i;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$pagerState, this.$dotIndex, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (PagerState.animateScrollToPage$default(this.$pagerState, this.$dotIndex, 0.0f, null, this, 6, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i7) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(pagerState, i7, null), 3, null);
                    }
                }, composerStartRestartGroup, i4 & 8190, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f3 = f4;
                modifier2 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                f3 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorKt$DotsIndicator$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i7) {
                        DotsIndicatorKt.m11284DotsIndicatorTN_CM5M(i, modifier2, f3, type, pagerState, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
                return;
            }
            return;
        }
        i4 |= 384;
        f2 = f;
        if ((i3 & 8) == 0) {
        }
        if ((i3 & 16) == 0) {
        }
        if ((46811 & i4) == 9362) {
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -954367824, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier32 = companion;
            float f42 = fM9114constructorimpl;
            int currentPage2 = pagerState.getCurrentPage();
            composerStartRestartGroup.startReplaceGroup(581553696);
            if ((i4 & 57344) != 16384) {
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z) {
                objRememberedValue2 = (Function0) new Function0<Float>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorKt$DotsIndicator$1$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(pagerState.getCurrentPageOffsetFraction());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                composerStartRestartGroup.endReplaceGroup();
                m11283DotsIndicatorAFY4PWA(i, modifier32, f42, type, currentPage2, (Function0) objRememberedValue2, new Function1<Integer, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorKt$DotsIndicator$2

                    /* JADX INFO: renamed from: com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorKt$DotsIndicator$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: DotsIndicator.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorKt$DotsIndicator$2$1", f = "DotsIndicator.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ int $dotIndex;
                        final /* synthetic */ PagerState $pagerState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(PagerState pagerState, int i, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$pagerState = pagerState;
                            this.$dotIndex = i;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$pagerState, this.$dotIndex, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (PagerState.animateScrollToPage$default(this.$pagerState, this.$dotIndex, 0.0f, null, this, 6, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i7) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(pagerState, i7, null), 3, null);
                    }
                }, composerStartRestartGroup, i4 & 8190, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                f3 = f42;
                modifier2 = modifier32;
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DotsIndicatorPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2128547675);
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2128547675, i, -1, "com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorPreview (DotsIndicator.kt:72)");
            }
            m11283DotsIndicatorAFY4PWA(10, null, Dp.m9114constructorimpl(8.0f), new BalloonIndicatorType(null, 0.0f, 3, null), 0, new Function0<Float>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorKt.DotsIndicatorPreview.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(2.0f);
                }
            }, null, composerStartRestartGroup, 221574, 66);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicatorKt.DotsIndicatorPreview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    DotsIndicatorKt.DotsIndicatorPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DotsIndicator_AFY4PWA$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float computeGlobalScrollOffset(int i, float f, int i2) {
        float f2 = i + f;
        float f3 = i2 - 1;
        if (f2 == f3) {
            f2 = f3 - 1.0E-4f;
        }
        int i3 = (int) f2;
        if (i3 + 1 > f3 || i3 < 0) {
            return 0.0f;
        }
        return i3 + (f2 % 1.0f);
    }
}
