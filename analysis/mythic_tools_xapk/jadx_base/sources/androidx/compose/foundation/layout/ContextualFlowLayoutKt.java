package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: ContextualFlowLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u008e\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f21\u0010\u0010\u001a-\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a\u008e\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u001d21\u0010\u0010\u001a-\u0012\u0004\u0012\u00020\u001e\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001f\u001a\u00ad\u0001\u0010 \u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010'\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0002\b\u00160(2;\u0010*\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010-\u001a\u00ad\u0001\u0010.\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010'\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0002\b\u00160(2;\u0010*\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010/¨\u00060"}, d2 = {"ContextualFlowRow", "", "itemCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "itemVerticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "maxItemsInEachRow", "maxLines", "overflow", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/ContextualFlowRowScope;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/ContextualFlowRowOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "ContextualFlowColumn", "itemHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "maxItemsInEachColumn", "Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", "Landroidx/compose/foundation/layout/ContextualFlowColumnScope;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/ContextualFlowColumnOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "contextualRowMeasurementHelper", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "maxItemsInMainAxis", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowComposables", "", "Lkotlin/Function0;", "getComposable", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "contextualColumnMeasureHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContextualFlowLayoutKt {
    /* JADX WARN: Removed duplicated region for block: B:138:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011f  */
    @Deprecated(message = "ContextualFlowLayouts are no longer maintained")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextualFlowColumn(final int i, Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i2, int i3, ContextualFlowColumnOverflow contextualFlowColumnOverflow, final Function4<? super ContextualFlowColumnScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        Arrangement.Vertical vertical2;
        int i8;
        int i9;
        Alignment.Horizontal start;
        int i10;
        int i11;
        int i12;
        final Arrangement.Horizontal horizontal3;
        final int i13;
        final ContextualFlowColumnOverflow contextualFlowColumnOverflow2;
        final Arrangement.Vertical vertical3;
        final int i14;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i15;
        Arrangement.Horizontal start2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1986851536);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ContextualFlowColumn)N(itemCount,modifier,verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInEachColumn,maxLines,overflow,content)155@7415L53,157@7522L209,172@8034L339,163@7764L609,183@8379L68:ContextualFlowLayout.kt#2w3rfo");
        if ((i4 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i16 = i5 & 2;
        if (i16 != 0) {
            i6 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i4 & 384) == 0) {
                    vertical2 = vertical;
                    i6 |= composerStartRestartGroup.changed(vertical2) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i4 & 3072) == 0) {
                        i6 |= composerStartRestartGroup.changed(horizontal) ? 2048 : 1024;
                    }
                    i9 = i5 & 16;
                    if (i9 != 0) {
                        if ((i4 & 24576) == 0) {
                            start = horizontal2;
                            i6 |= composerStartRestartGroup.changed(start) ? 16384 : 8192;
                        }
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i6 |= composerStartRestartGroup.changed(i2) ? 131072 : 65536;
                        }
                        i11 = i5 & 64;
                        if (i11 != 0) {
                            i6 |= 1572864;
                        } else if ((i4 & 1572864) == 0) {
                            i6 |= composerStartRestartGroup.changed(i3) ? 1048576 : 524288;
                        }
                        i12 = i5 & 128;
                        if (i12 != 0) {
                            i6 |= 12582912;
                        } else if ((i4 & 12582912) == 0) {
                            i6 |= composerStartRestartGroup.changed(contextualFlowColumnOverflow) ? 8388608 : 4194304;
                        }
                        if ((i4 & 100663296) == 0) {
                            i6 |= composerStartRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
                        }
                        if (composerStartRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            Arrangement.Vertical top = i7 != 0 ? Arrangement.INSTANCE.getTop() : vertical2;
                            if (i8 != 0) {
                                start2 = Arrangement.INSTANCE.getStart();
                                i15 = i9;
                            } else {
                                i15 = i9;
                                start2 = horizontal;
                            }
                            if (i15 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            }
                            int i17 = i10 != 0 ? Integer.MAX_VALUE : i2;
                            int i18 = i11 != 0 ? Integer.MAX_VALUE : i3;
                            ContextualFlowColumnOverflow clip = i12 != 0 ? ContextualFlowColumnOverflow.INSTANCE.getClip() : contextualFlowColumnOverflow;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1986851536, i6, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:154)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1896103003, "CC(remember):ContextualFlowLayout.kt#9igjgp");
                            int i19 = 29360128 & i6;
                            boolean z = i19 == 8388608;
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = clip.createOverflowState$foundation_layout();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1896099423, "CC(remember):ContextualFlowLayout.kt#9igjgp");
                            boolean z2 = i19 == 8388608;
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!z2) {
                                Object obj = objRememberedValue2;
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    ArrayList arrayList = new ArrayList();
                                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList);
                                    composerStartRestartGroup.updateRememberedValue(arrayList);
                                    obj = arrayList;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                int i20 = i6 >> 6;
                                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualColumnMeasureHelper(top, start2, start, i17, i18, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(620176540, true, new Function4() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function4
                                    public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                        return ContextualFlowLayoutKt.ContextualFlowColumn$lambda$2(function4, ((Integer) obj2).intValue(), (FlowLineInfo) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i20 & 57344) | (i20 & 14) | 100663296 | (i20 & 112) | (i20 & 896) | (i20 & 7168) | ((i6 << 18) & 3670016)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                contextualFlowColumnOverflow2 = clip;
                                vertical3 = top;
                                horizontal3 = start2;
                                i13 = i17;
                                i14 = i18;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            horizontal3 = horizontal;
                            i13 = i2;
                            contextualFlowColumnOverflow2 = contextualFlowColumnOverflow;
                            vertical3 = vertical2;
                            i14 = i3;
                        }
                        final Modifier modifier3 = modifier2;
                        final Alignment.Horizontal horizontal4 = start;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return ContextualFlowLayoutKt.ContextualFlowColumn$lambda$3(i, modifier3, vertical3, horizontal3, horizontal4, i13, i14, contextualFlowColumnOverflow2, function4, i4, i5, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i6 |= 24576;
                    start = horizontal2;
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 != 0) {
                    }
                    i12 = i5 & 128;
                    if (i12 != 0) {
                    }
                    if ((i4 & 100663296) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
                    }
                    final Modifier modifier32 = modifier2;
                    final Alignment.Horizontal horizontal42 = start;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i9 = i5 & 16;
                if (i9 != 0) {
                }
                start = horizontal2;
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 != 0) {
                }
                i12 = i5 & 128;
                if (i12 != 0) {
                }
                if ((i4 & 100663296) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
                }
                final Modifier modifier322 = modifier2;
                final Alignment.Horizontal horizontal422 = start;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            vertical2 = vertical;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            i9 = i5 & 16;
            if (i9 != 0) {
            }
            start = horizontal2;
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 != 0) {
            }
            i12 = i5 & 128;
            if (i12 != 0) {
            }
            if ((i4 & 100663296) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
            }
            final Modifier modifier3222 = modifier2;
            final Alignment.Horizontal horizontal4222 = start;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        vertical2 = vertical;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        i9 = i5 & 16;
        if (i9 != 0) {
        }
        start = horizontal2;
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 != 0) {
        }
        i12 = i5 & 128;
        if (i12 != 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
        }
        final Modifier modifier32222 = modifier2;
        final Alignment.Horizontal horizontal42222 = start;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit ContextualFlowColumn$lambda$2(Function4 function4, int i, FlowLineInfo flowLineInfo, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "CN(index,info)180@8349L14:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(620176540, i2, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:173)");
        }
        function4.invoke(new ContextualFlowColumnScopeImpl(flowLineInfo.getLineIndex(), flowLineInfo.getPositionInLine(), flowLineInfo.getMaxCrossAxisSize(), flowLineInfo.getMaxMainAxisSize(), null), Integer.valueOf(i), composer, Integer.valueOf((i2 << 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit ContextualFlowColumn$lambda$3(int i, Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i2, int i3, ContextualFlowColumnOverflow contextualFlowColumnOverflow, Function4 function4, int i4, int i5, Composer composer, int i6) {
        ContextualFlowColumn(i, modifier, vertical, horizontal, horizontal2, i2, i3, contextualFlowColumnOverflow, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011f  */
    @Deprecated(message = "ContextualFlowLayouts are no longer maintained")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextualFlowRow(final int i, Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i2, int i3, ContextualFlowRowOverflow contextualFlowRowOverflow, final Function4<? super ContextualFlowRowScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        Arrangement.Horizontal horizontal2;
        int i8;
        int i9;
        Alignment.Vertical top;
        int i10;
        int i11;
        int i12;
        final Arrangement.Vertical vertical3;
        final int i13;
        final ContextualFlowRowOverflow contextualFlowRowOverflow2;
        final Arrangement.Horizontal horizontal3;
        final int i14;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i15;
        Arrangement.Vertical top2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-294153140);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ContextualFlowRow)N(itemCount,modifier,horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInEachRow,maxLines,overflow,content)80@3819L53,82@3926L209,97@4434L336,88@4168L602,107@4775L68:ContextualFlowLayout.kt#2w3rfo");
        if ((i4 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i16 = i5 & 2;
        if (i16 != 0) {
            i6 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= 384;
            } else {
                if ((i4 & 384) == 0) {
                    horizontal2 = horizontal;
                    i6 |= composerStartRestartGroup.changed(horizontal2) ? 256 : 128;
                }
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else {
                    if ((i4 & 3072) == 0) {
                        i6 |= composerStartRestartGroup.changed(vertical) ? 2048 : 1024;
                    }
                    i9 = i5 & 16;
                    if (i9 != 0) {
                        if ((i4 & 24576) == 0) {
                            top = vertical2;
                            i6 |= composerStartRestartGroup.changed(top) ? 16384 : 8192;
                        }
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i6 |= composerStartRestartGroup.changed(i2) ? 131072 : 65536;
                        }
                        i11 = i5 & 64;
                        if (i11 != 0) {
                            i6 |= 1572864;
                        } else if ((i4 & 1572864) == 0) {
                            i6 |= composerStartRestartGroup.changed(i3) ? 1048576 : 524288;
                        }
                        i12 = i5 & 128;
                        if (i12 != 0) {
                            i6 |= 12582912;
                        } else if ((i4 & 12582912) == 0) {
                            i6 |= composerStartRestartGroup.changed(contextualFlowRowOverflow) ? 8388608 : 4194304;
                        }
                        if ((i4 & 100663296) == 0) {
                            i6 |= composerStartRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
                        }
                        if (composerStartRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            Arrangement.Horizontal start = i7 != 0 ? Arrangement.INSTANCE.getStart() : horizontal2;
                            if (i8 != 0) {
                                top2 = Arrangement.INSTANCE.getTop();
                                i15 = i9;
                            } else {
                                i15 = i9;
                                top2 = vertical;
                            }
                            if (i15 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            }
                            int i17 = i10 != 0 ? Integer.MAX_VALUE : i2;
                            int i18 = i11 != 0 ? Integer.MAX_VALUE : i3;
                            ContextualFlowRowOverflow clip = i12 != 0 ? ContextualFlowRowOverflow.INSTANCE.getClip() : contextualFlowRowOverflow;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-294153140, i6, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:79)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 786690945, "CC(remember):ContextualFlowLayout.kt#9igjgp");
                            int i19 = 29360128 & i6;
                            boolean z = i19 == 8388608;
                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = clip.createOverflowState$foundation_layout();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 786694525, "CC(remember):ContextualFlowLayout.kt#9igjgp");
                            boolean z2 = i19 == 8388608;
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!z2) {
                                Object obj = objRememberedValue2;
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    ArrayList arrayList = new ArrayList();
                                    clip.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList);
                                    composerStartRestartGroup.updateRememberedValue(arrayList);
                                    obj = arrayList;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                int i20 = i6 >> 6;
                                SubcomposeLayoutKt.SubcomposeLayout(modifier2, contextualRowMeasurementHelper(start, top2, top, i17, i18, flowLayoutOverflowState, i, (List) obj, ComposableLambdaKt.rememberComposableLambda(-1677845586, true, new Function4() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function4
                                    public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                                        return ContextualFlowLayoutKt.ContextualFlowRow$lambda$2(function4, ((Integer) obj2).intValue(), (FlowLineInfo) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i20 & 57344) | (i20 & 14) | 100663296 | (i20 & 112) | (i20 & 896) | (i20 & 7168) | ((i6 << 18) & 3670016)), composerStartRestartGroup, (i6 >> 3) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                contextualFlowRowOverflow2 = clip;
                                horizontal3 = start;
                                vertical3 = top2;
                                i13 = i17;
                                i14 = i18;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            vertical3 = vertical;
                            i13 = i2;
                            contextualFlowRowOverflow2 = contextualFlowRowOverflow;
                            horizontal3 = horizontal2;
                            i14 = i3;
                        }
                        final Modifier modifier3 = modifier2;
                        final Alignment.Vertical vertical4 = top;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.ContextualFlowLayoutKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return ContextualFlowLayoutKt.ContextualFlowRow$lambda$3(i, modifier3, horizontal3, vertical3, vertical4, i13, i14, contextualFlowRowOverflow2, function4, i4, i5, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i6 |= 24576;
                    top = vertical2;
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 != 0) {
                    }
                    i12 = i5 & 128;
                    if (i12 != 0) {
                    }
                    if ((i4 & 100663296) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
                    }
                    final Modifier modifier32 = modifier2;
                    final Alignment.Vertical vertical42 = top;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i9 = i5 & 16;
                if (i9 != 0) {
                }
                top = vertical2;
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 != 0) {
                }
                i12 = i5 & 128;
                if (i12 != 0) {
                }
                if ((i4 & 100663296) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
                }
                final Modifier modifier322 = modifier2;
                final Alignment.Vertical vertical422 = top;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            horizontal2 = horizontal;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            i9 = i5 & 16;
            if (i9 != 0) {
            }
            top = vertical2;
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 != 0) {
            }
            i12 = i5 & 128;
            if (i12 != 0) {
            }
            if ((i4 & 100663296) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
            }
            final Modifier modifier3222 = modifier2;
            final Alignment.Vertical vertical4222 = top;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        horizontal2 = horizontal;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        i9 = i5 & 16;
        if (i9 != 0) {
        }
        top = vertical2;
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 != 0) {
        }
        i12 = i5 & 128;
        if (i12 != 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i6 & 38347923) != 38347922, i6 & 1)) {
        }
        final Modifier modifier32222 = modifier2;
        final Alignment.Vertical vertical42222 = top;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit ContextualFlowRow$lambda$2(Function4 function4, int i, FlowLineInfo flowLineInfo, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "CN(index,info)105@4746L14:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1677845586, i2, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:98)");
        }
        function4.invoke(new ContextualFlowRowScopeImpl(flowLineInfo.getLineIndex(), flowLineInfo.getPositionInLine(), flowLineInfo.getMaxMainAxisSize(), flowLineInfo.getMaxCrossAxisSize(), null), Integer.valueOf(i), composer, Integer.valueOf((i2 << 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit ContextualFlowRow$lambda$3(int i, Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i2, int i3, ContextualFlowRowOverflow contextualFlowRowOverflow, Function4 function4, int i4, int i5, Composer composer, int i6) {
        ContextualFlowRow(i, modifier, horizontal, vertical, vertical2, i2, i3, contextualFlowRowOverflow, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007f A[PHI: r4
      0x007f: PHI (r4v18 int) = (r4v16 int), (r4v19 int) binds: [B:36:0x007d, B:32:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualColumnMeasureHelper(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, int i3, List<? extends Function2<? super Composer, ? super Integer, Unit>> list, Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i4) {
        int i5;
        boolean z;
        boolean z2;
        boolean z3;
        Object objRememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, -676633639, "C(contextualColumnMeasureHelper)N(verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInMainAxis,maxLines,overflowState,itemCount,overflowComposables,getComposable)425@18138L978:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-676633639, i4, -1, "androidx.compose.foundation.layout.contextualColumnMeasureHelper (ContextualFlowLayout.kt:424)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1704848565, "CC(remember):ContextualFlowLayout.kt#9igjgp");
        boolean z4 = ((((i4 & 14) ^ 6) > 4 && composer.changed(vertical)) || (i4 & 6) == 4) | ((((i4 & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i4 & 48) == 32) | ((((i4 & 896) ^ 384) > 256 && composer.changed(horizontal2)) || (i4 & 384) == 256);
        if (((i4 & 7168) ^ 3072) > 2048) {
            i5 = i;
            if (composer.changed(i5)) {
                z = true;
            }
            boolean zChanged = z4 | z | ((((57344 & i4) ^ 24576) <= 16384 && composer.changed(i2)) || (i4 & 24576) == 16384) | composer.changed(flowLayoutOverflowState) | ((((3670016 & i4) ^ 1572864) <= 1048576 && composer.changed(i3)) || (i4 & 1572864) == 1048576);
            if (((234881024 & i4) ^ 100663296) > 67108864 || !composer.changed(function4)) {
                z2 = (i4 & 100663296) == 67108864;
            }
            z3 = zChanged | z2;
            objRememberedValue = composer.rememberedValue();
            if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new FlowMeasureLazyPolicy(false, horizontal, vertical, vertical.getSpacing(), CrossAxisAlignment.INSTANCE.horizontal$foundation_layout(horizontal2), horizontal.getSpacing(), i3, i2, i5, flowLayoutOverflowState, list, function4, null).getMeasurePolicy();
                composer.updateRememberedValue(objRememberedValue);
            }
            Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function2 = (Function2) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return function2;
        }
        i5 = i;
        if ((i4 & 3072) != 2048) {
            z = false;
        }
        boolean zChanged2 = z4 | z | ((((57344 & i4) ^ 24576) <= 16384 && composer.changed(i2)) || (i4 & 24576) == 16384) | composer.changed(flowLayoutOverflowState) | ((((3670016 & i4) ^ 1572864) <= 1048576 && composer.changed(i3)) || (i4 & 1572864) == 1048576);
        if (((234881024 & i4) ^ 100663296) > 67108864) {
        }
        if ((i4 & 100663296) == 67108864) {
        }
        z3 = zChanged2 | z2;
        objRememberedValue = composer.rememberedValue();
        if (!z3) {
            objRememberedValue = new FlowMeasureLazyPolicy(false, horizontal, vertical, vertical.getSpacing(), CrossAxisAlignment.INSTANCE.horizontal$foundation_layout(horizontal2), horizontal.getSpacing(), i3, i2, i5, flowLayoutOverflowState, list, function4, null).getMeasurePolicy();
            composer.updateRememberedValue(objRememberedValue);
        }
        Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function22 = (Function2) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function22;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007f A[PHI: r4
      0x007f: PHI (r4v18 int) = (r4v16 int), (r4v19 int) binds: [B:36:0x007d, B:32:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualRowMeasurementHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, int i3, List<? extends Function2<? super Composer, ? super Integer, Unit>> list, Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i4) {
        int i5;
        boolean z;
        boolean z2;
        boolean z3;
        Object objRememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, 962906403, "C(contextualRowMeasurementHelper)N(horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInMainAxis,maxLines,overflowState,itemCount,overflowComposables,getComposable)385@16647L971:ContextualFlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(962906403, i4, -1, "androidx.compose.foundation.layout.contextualRowMeasurementHelper (ContextualFlowLayout.kt:384)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1935101358, "CC(remember):ContextualFlowLayout.kt#9igjgp");
        boolean z4 = ((((i4 & 14) ^ 6) > 4 && composer.changed(horizontal)) || (i4 & 6) == 4) | ((((i4 & 112) ^ 48) > 32 && composer.changed(vertical)) || (i4 & 48) == 32) | ((((i4 & 896) ^ 384) > 256 && composer.changed(vertical2)) || (i4 & 384) == 256);
        if (((i4 & 7168) ^ 3072) > 2048) {
            i5 = i;
            if (composer.changed(i5)) {
                z = true;
            }
            boolean zChanged = z4 | z | ((((57344 & i4) ^ 24576) <= 16384 && composer.changed(i2)) || (i4 & 24576) == 16384) | composer.changed(flowLayoutOverflowState) | ((((3670016 & i4) ^ 1572864) <= 1048576 && composer.changed(i3)) || (i4 & 1572864) == 1048576);
            if (((234881024 & i4) ^ 100663296) > 67108864 || !composer.changed(function4)) {
                z2 = (i4 & 100663296) == 67108864;
            }
            z3 = zChanged | z2;
            objRememberedValue = composer.rememberedValue();
            if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new FlowMeasureLazyPolicy(true, horizontal, vertical, horizontal.getSpacing(), CrossAxisAlignment.INSTANCE.vertical$foundation_layout(vertical2), vertical.getSpacing(), i3, i2, i5, flowLayoutOverflowState, list, function4, null).getMeasurePolicy();
                composer.updateRememberedValue(objRememberedValue);
            }
            Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function2 = (Function2) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return function2;
        }
        i5 = i;
        if ((i4 & 3072) != 2048) {
            z = false;
        }
        boolean zChanged2 = z4 | z | ((((57344 & i4) ^ 24576) <= 16384 && composer.changed(i2)) || (i4 & 24576) == 16384) | composer.changed(flowLayoutOverflowState) | ((((3670016 & i4) ^ 1572864) <= 1048576 && composer.changed(i3)) || (i4 & 1572864) == 1048576);
        if (((234881024 & i4) ^ 100663296) > 67108864) {
        }
        if ((i4 & 100663296) == 67108864) {
        }
        z3 = zChanged2 | z2;
        objRememberedValue = composer.rememberedValue();
        if (!z3) {
            objRememberedValue = new FlowMeasureLazyPolicy(true, horizontal, vertical, horizontal.getSpacing(), CrossAxisAlignment.INSTANCE.vertical$foundation_layout(vertical2), vertical.getSpacing(), i3, i2, i5, flowLayoutOverflowState, list, function4, null).getMeasurePolicy();
            composer.updateRememberedValue(objRememberedValue);
        }
        Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function22 = (Function2) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function22;
    }
}
