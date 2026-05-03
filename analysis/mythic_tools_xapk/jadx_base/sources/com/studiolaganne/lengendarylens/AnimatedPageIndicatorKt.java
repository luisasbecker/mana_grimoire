package com.studiolaganne.lengendarylens;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AnimatedPageIndicator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a[\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\bX\u008a\u0084\u0002"}, d2 = {"AnimatedPageIndicator", "", "pageCount", "", "currentPage", "modifier", "Landroidx/compose/ui/Modifier;", "activeColor", "Landroidx/compose/ui/graphics/Color;", "inactiveColor", "indicatorWidth", "Landroidx/compose/ui/unit/Dp;", "indicatorHeight", "spacing", "AnimatedPageIndicator-NsDo4u0", "(IILandroidx/compose/ui/Modifier;JJFFFLandroidx/compose/runtime/Composer;II)V", "app_release", "width", "color"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AnimatedPageIndicatorKt {
    /* JADX WARN: Removed duplicated region for block: B:130:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0101  */
    /* JADX INFO: renamed from: AnimatedPageIndicator-NsDo4u0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10914AnimatedPageIndicatorNsDo4u0(final int i, final int i2, Modifier modifier, long j, long j2, float f, float f2, float f3, Composer composer, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        long j3;
        int i7;
        long j4;
        int i8;
        int i9;
        int i10;
        int i11;
        final float f4;
        Modifier modifier3;
        final long j5;
        final long j6;
        final float f5;
        final float f6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float f7;
        int i12 = i;
        Composer composerStartRestartGroup = composer.startRestartGroup(1257679767);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedPageIndicator)N(pageCount,currentPage,modifier,activeColor:c#ui.graphics.Color,inactiveColor:c#ui.graphics.Color,indicatorWidth:c#ui.unit.Dp,indicatorHeight:c#ui.unit.Dp,spacing:c#ui.unit.Dp)33@1209L1072:AnimatedPageIndicator.kt#r9tj48");
        if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(i12) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(i2) ? 32 : 16;
        }
        int i13 = i4 & 4;
        if (i13 != 0) {
            i5 |= 384;
        } else {
            if ((i3 & 384) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else {
                if ((i3 & 3072) == 0) {
                    j3 = j;
                    i5 |= composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((i3 & 24576) == 0) {
                        j4 = j2;
                        i5 |= composerStartRestartGroup.changed(j4) ? 16384 : 8192;
                    }
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i5 |= composerStartRestartGroup.changed(f) ? 131072 : 65536;
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        i5 |= composerStartRestartGroup.changed(f2) ? 1048576 : 524288;
                    }
                    i10 = i4 & 128;
                    if (i10 != 0) {
                        if ((i3 & 12582912) == 0) {
                            i11 = i10;
                            i5 |= composerStartRestartGroup.changed(f3) ? 8388608 : 4194304;
                        }
                        if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            long jColor = i6 != 0 ? ColorKt.Color(4292115280L) : j3;
                            long jColor2 = i7 != 0 ? ColorKt.Color(4284900966L) : j4;
                            float fM9114constructorimpl = i8 != 0 ? Dp.m9114constructorimpl(32.0f) : f;
                            float fM9114constructorimpl2 = i9 != 0 ? Dp.m9114constructorimpl(8.0f) : f2;
                            float fM9114constructorimpl3 = i11 != 0 ? Dp.m9114constructorimpl(8.0f) : f3;
                            if (ComposerKt.isTraceInProgress()) {
                                f7 = fM9114constructorimpl;
                                ComposerKt.traceEventStart(1257679767, i5, -1, "com.studiolaganne.lengendarylens.AnimatedPageIndicator (AnimatedPageIndicator.kt:32)");
                            } else {
                                f7 = fM9114constructorimpl;
                            }
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(fM9114constructorimpl3);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            float f8 = fM9114constructorimpl3;
                            modifier3 = modifier2;
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
                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m5599initimpl(composerM5595constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m5601reconcileimpl(composerM5595constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 312905582, "C:AnimatedPageIndicator.kt#r9tj48");
                            composerStartRestartGroup.startReplaceGroup(702830389);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*39@1428L305,48@1801L182,54@2026L239");
                            int i14 = 0;
                            while (i14 < i12) {
                                BoxKt.Box(BackgroundKt.m1483backgroundbw27NRU$default(ClipKt.clip(SizeKt.m2088width3ABfNKs(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, fM9114constructorimpl2), AnimatedPageIndicator_NsDo4u0$lambda$0$0$0(AnimateAsStateKt.m1380animateDpAsStateAjpBEmI(i14 == i2 ? f7 : fM9114constructorimpl2, AnimationSpecKt.spring$default(0.5f, 1500.0f, null, 4, null), null, null, composerStartRestartGroup, 48, 12))), RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(fM9114constructorimpl2 / 2.0f))), AnimatedPageIndicator_NsDo4u0$lambda$0$0$1(SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(i14 == i2 ? jColor : jColor2, AnimationSpecKt.tween$default(300, 0, null, 6, null), null, null, composerStartRestartGroup, 48, 12)), null, 2, null), composerStartRestartGroup, 0);
                                i14++;
                                i12 = i;
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j5 = jColor;
                            f5 = fM9114constructorimpl2;
                            j6 = jColor2;
                            f4 = f7;
                            f6 = f8;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            f4 = f;
                            modifier3 = modifier2;
                            j5 = j3;
                            j6 = j4;
                            f5 = f2;
                            f6 = f3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final Modifier modifier4 = modifier3;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.studiolaganne.lengendarylens.AnimatedPageIndicatorKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AnimatedPageIndicatorKt.AnimatedPageIndicator_NsDo4u0$lambda$1(i, i2, modifier4, j5, j6, f4, f5, f6, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i5 |= 12582912;
                    i11 = i10;
                    if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                j4 = j2;
                i8 = i4 & 32;
                if (i8 == 0) {
                }
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                i10 = i4 & 128;
                if (i10 != 0) {
                }
                i11 = i10;
                if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            j3 = j;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            j4 = j2;
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            i9 = i4 & 64;
            if (i9 == 0) {
            }
            i10 = i4 & 128;
            if (i10 != 0) {
            }
            i11 = i10;
            if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        j3 = j;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        j4 = j2;
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        i9 = i4 & 64;
        if (i9 == 0) {
        }
        i10 = i4 & 128;
        if (i10 != 0) {
        }
        i11 = i10;
        if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    private static final float AnimatedPageIndicator_NsDo4u0$lambda$0$0$0(State<Dp> state) {
        return state.getValue().m9128unboximpl();
    }

    private static final long AnimatedPageIndicator_NsDo4u0$lambda$0$0$1(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }

    static final Unit AnimatedPageIndicator_NsDo4u0$lambda$1(int i, int i2, Modifier modifier, long j, long j2, float f, float f2, float f3, int i3, int i4, Composer composer, int i5) {
        m10914AnimatedPageIndicatorNsDo4u0(i, i2, modifier, j, j2, f, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }
}
