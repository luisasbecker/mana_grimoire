package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ClickableText.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001as\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ClickableTextKt {
    /* JADX WARN: Removed duplicated region for block: B:135:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fe  */
    @Deprecated(message = "Use Text or BasicText and pass an AnnotatedString that contains a LinkAnnotation. Check LinkAnnotation's documentation for more details and samples.")
    /* JADX INFO: renamed from: ClickableText-4YKlhWE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2381ClickableText4YKlhWE(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, boolean z, int i, int i2, Function1<? super TextLayoutResult, Unit> function1, final Function1<? super Integer, Unit> function12, Composer composer, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        TextStyle textStyle2;
        int i7;
        int i8;
        int iM9049getClipgIe3tQ8;
        int i9;
        int i10;
        Composer composer2;
        final boolean z2;
        final int i11;
        final TextStyle textStyle3;
        final Function1<? super TextLayoutResult, Unit> function13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i12;
        int i13;
        final Function1<? super TextLayoutResult, Unit> function14;
        Composer composerStartRestartGroup = composer.startRestartGroup(-246609449);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ClickableText)N(text,modifier,style,softWrap,overflow:c#ui.text.style.TextOverflow,maxLines,onTextLayout,onClick)77@3766L2,80@3825L52,82@3942L208,97@4371L76,90@4156L298:ClickableText.kt#423gt5");
        if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(annotatedString) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i14 = i4 & 2;
        if (i14 != 0) {
            i5 |= 48;
        } else {
            if ((i3 & 48) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i3 & 384) == 0) {
                    textStyle2 = textStyle;
                    i5 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i3 & 3072) == 0) {
                        i5 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
                    }
                    i8 = i4 & 16;
                    if (i8 != 0) {
                        if ((i3 & 24576) == 0) {
                            iM9049getClipgIe3tQ8 = i;
                            i5 |= composerStartRestartGroup.changed(iM9049getClipgIe3tQ8) ? 16384 : 8192;
                        }
                        i9 = i4 & 32;
                        if (i9 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i5 |= composerStartRestartGroup.changed(i2) ? 131072 : 65536;
                        }
                        i10 = i4 & 64;
                        if (i10 != 0) {
                            i5 |= 1572864;
                        } else if ((i3 & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function1) ? 1048576 : 524288;
                        }
                        if ((i3 & 12582912) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function12) ? 8388608 : 4194304;
                        }
                        if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            TextStyle textStyle4 = i6 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle2;
                            boolean z3 = i7 != 0 ? true : z;
                            if (i8 != 0) {
                                iM9049getClipgIe3tQ8 = TextOverflow.INSTANCE.m9049getClipgIe3tQ8();
                            }
                            if (i9 != 0) {
                                i13 = Integer.MAX_VALUE;
                                i12 = i10;
                            } else {
                                i12 = i10;
                                i13 = i2;
                            }
                            if (i12 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768470151, "CC(remember):ClickableText.kt#9igjgp");
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ClickableTextKt.ClickableText_4YKlhWE$lambda$0$0((TextLayoutResult) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function14 = (Function1) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function14 = function1;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-246609449, i5, -1, "androidx.compose.foundation.text.ClickableText (ClickableText.kt:79)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768468213, "CC(remember):ClickableText.kt#9igjgp");
                            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            final MutableState mutableState = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier.Companion companion = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768464313, "CC(remember):ClickableText.kt#9igjgp");
                            boolean z4 = (29360128 & i5) == 8388608;
                            ClickableTextKt$ClickableText$pressIndicator$1$1 clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z4 || clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue = new ClickableTextKt$ClickableText$pressIndicator$1$1(mutableState, function12);
                                composerStartRestartGroup.updateRememberedValue(clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierThen = modifier2.then(SuspendingPointerInputFilterKt.pointerInput(companion, function12, (PointerInputEventHandler) clickableTextKt$ClickableText$pressIndicator$1$1RememberedValue));
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768450717, "CC(remember):ClickableText.kt#9igjgp");
                            boolean z5 = (i5 & 3670016) == 1048576;
                            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ClickableTextKt.ClickableText_4YKlhWE$lambda$3$0(mutableState, function14, (TextLayoutResult) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            BasicTextKt.m2372BasicTextCL7eQgs(annotatedString, modifierThen, textStyle4, (Function1) objRememberedValue3, iM9049getClipgIe3tQ8, z3, i13, 0, null, null, null, composer2, (58254 & i5) | (458752 & (i5 << 6)) | ((i5 << 3) & 3670016), 0, 1920);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function13 = function14;
                            textStyle3 = textStyle4;
                            z2 = z3;
                            i11 = i13;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            z2 = z;
                            i11 = i2;
                            textStyle3 = textStyle2;
                            function13 = function1;
                        }
                        final Modifier modifier3 = modifier2;
                        final int i15 = iM9049getClipgIe3tQ8;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.ClickableTextKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ClickableTextKt.ClickableText_4YKlhWE$lambda$4(annotatedString, modifier3, textStyle3, z2, i15, i11, function13, function12, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i5 |= 24576;
                    iM9049getClipgIe3tQ8 = i;
                    i9 = i4 & 32;
                    if (i9 != 0) {
                    }
                    i10 = i4 & 64;
                    if (i10 != 0) {
                    }
                    if ((i3 & 12582912) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                    }
                    final Modifier modifier32 = modifier2;
                    final int i152 = iM9049getClipgIe3tQ8;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 != 0) {
                }
                iM9049getClipgIe3tQ8 = i;
                i9 = i4 & 32;
                if (i9 != 0) {
                }
                i10 = i4 & 64;
                if (i10 != 0) {
                }
                if ((i3 & 12582912) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
                }
                final Modifier modifier322 = modifier2;
                final int i1522 = iM9049getClipgIe3tQ8;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            textStyle2 = textStyle;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            if (i8 != 0) {
            }
            iM9049getClipgIe3tQ8 = i;
            i9 = i4 & 32;
            if (i9 != 0) {
            }
            i10 = i4 & 64;
            if (i10 != 0) {
            }
            if ((i3 & 12582912) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
            }
            final Modifier modifier3222 = modifier2;
            final int i15222 = iM9049getClipgIe3tQ8;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        textStyle2 = textStyle;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        if (i8 != 0) {
        }
        iM9049getClipgIe3tQ8 = i;
        i9 = i4 & 32;
        if (i9 != 0) {
        }
        i10 = i4 & 64;
        if (i10 != 0) {
        }
        if ((i3 & 12582912) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i5 & 4793491) != 4793490, i5 & 1)) {
        }
        final Modifier modifier32222 = modifier2;
        final int i152222 = iM9049getClipgIe3tQ8;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClickableText_4YKlhWE$lambda$0$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClickableText_4YKlhWE$lambda$3$0(MutableState mutableState, Function1 function1, TextLayoutResult textLayoutResult) {
        mutableState.setValue(textLayoutResult);
        function1.invoke(textLayoutResult);
        return Unit.INSTANCE;
    }

    static final Unit ClickableText_4YKlhWE$lambda$4(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, boolean z, int i, int i2, Function1 function1, Function1 function12, int i3, int i4, Composer composer, int i5) {
        m2381ClickableText4YKlhWE(annotatedString, modifier, textStyle, z, i, i2, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }
}
