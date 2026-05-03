package androidx.compose.foundation.text;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.InputTransformationKt;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextObfuscationMode;
import androidx.compose.foundation.text.input.TextObfuscationMode_androidKt;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BasicSecureTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aÛ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u001028\b\u0002\u0010\u0011\u001a2\u0012\u0004\u0012\u00020\u0013\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0004\b&\u0010'\u001a\u001a\u0010(\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010\n2\b\u0010)\u001a\u0004\u0018\u00010\nH\u0002\u001a \u0010-\u001a\u00020\u00012\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b/H\u0003¢\u0006\u0002\u00100\u001aÇ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u001028\b\u0002\u0010\u0011\u001a2\u0012\u0004\u0012\u00020\u0013\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b1\u00102\u001aÑ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u001028\b\u0002\u0010\u0011\u001a2\u0012\u0004\u0012\u00020\u0013\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b3\u00104\"\u000e\u0010*\u001a\u00020+X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020#X\u0082T¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"BasicSecureTextField", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "textObfuscationCharacter", "", "scrollState", "Landroidx/compose/foundation/ScrollState;", "BasicSecureTextField-ltb6GB4", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "then", "next", "LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS", "", "DefaultObfuscationCharacter", "DisableCutCopy", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BasicSecureTextField-Jb9bMDk", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "BasicSecureTextField-egD4TGM", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicSecureTextFieldKt {
    private static final char DefaultObfuscationCharacter = 8226;
    private static final long LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS = 1500;

    /* JADX WARN: Removed duplicated region for block: B:109:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:202:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012a  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the overload that takes in readOnly parameter.")
    /* JADX INFO: renamed from: BasicSecureTextField-Jb9bMDk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2354BasicSecureTextFieldJb9bMDk(final TextFieldState textFieldState, Modifier modifier, boolean z, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, Composer composer, final int i2, final int i3, final int i4) {
        TextFieldState textFieldState2;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z2;
        int i7;
        InputTransformation inputTransformation2;
        int i8;
        TextStyle textStyle2;
        int i9;
        KeyboardOptions keyboardOptions2;
        int i10;
        KeyboardActionHandler keyboardActionHandler2;
        int i11;
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
        int i22;
        Composer composer2;
        final Function2 function22;
        final int i23;
        final boolean z3;
        final InputTransformation inputTransformation3;
        final TextStyle textStyle3;
        final KeyboardOptions keyboardOptions3;
        final Modifier modifier3;
        final KeyboardActionHandler keyboardActionHandler3;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final TextFieldDecorator textFieldDecorator2;
        final char c2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i24;
        Modifier modifier4;
        int i25;
        TextStyle textStyle4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1399310985);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicSecureTextField)N(state,modifier,enabled,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,onTextLayout,interactionSource,cursorBrush,decorator,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter)364@17059L564:BasicSecureTextField.kt#423gt5");
        if ((i2 & 6) == 0) {
            textFieldState2 = textFieldState;
            i5 = (composerStartRestartGroup.changed(textFieldState2) ? 4 : 2) | i2;
        } else {
            textFieldState2 = textFieldState;
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
                    z2 = z;
                    i5 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                }
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i2 & 3072) == 0) {
                        inputTransformation2 = inputTransformation;
                        i5 |= composerStartRestartGroup.changed(inputTransformation2) ? 2048 : 1024;
                    }
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else {
                        if ((i2 & 24576) == 0) {
                            textStyle2 = textStyle;
                            i5 |= composerStartRestartGroup.changed(textStyle2) ? 16384 : 8192;
                        }
                        i9 = i4 & 32;
                        if (i9 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            keyboardOptions2 = keyboardOptions;
                        } else {
                            keyboardOptions2 = keyboardOptions;
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i5 |= composerStartRestartGroup.changed(keyboardOptions2) ? 131072 : 65536;
                            }
                        }
                        i10 = i4 & 64;
                        if (i10 != 0) {
                            i5 |= 1572864;
                            keyboardActionHandler2 = keyboardActionHandler;
                        } else {
                            keyboardActionHandler2 = keyboardActionHandler;
                            if ((i2 & 1572864) == 0) {
                                i5 |= composerStartRestartGroup.changed(keyboardActionHandler2) ? 1048576 : 524288;
                            }
                        }
                        i11 = i4 & 128;
                        if (i11 != 0) {
                            i5 |= 12582912;
                        } else {
                            if ((i2 & 12582912) == 0) {
                                i12 = i11;
                                i5 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                            }
                            i13 = i4 & 256;
                            if (i13 == 0) {
                                i5 |= 100663296;
                            } else {
                                if ((i2 & 100663296) == 0) {
                                    i14 = i13;
                                    i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                                }
                                i15 = i4 & 512;
                                if (i15 == 0) {
                                    if ((i2 & 805306368) == 0) {
                                        i16 = i15;
                                        i5 |= composerStartRestartGroup.changed(brush) ? 536870912 : 268435456;
                                    }
                                    i17 = i4 & 1024;
                                    if (i17 == 0) {
                                        i18 = i3 | 6;
                                    } else if ((i3 & 6) == 0) {
                                        i18 = i3 | ((i3 & 8) == 0 ? composerStartRestartGroup.changed(textFieldDecorator) : composerStartRestartGroup.changedInstance(textFieldDecorator) ? 4 : 2);
                                    } else {
                                        i18 = i3;
                                    }
                                    i19 = i4 & 2048;
                                    if (i19 == 0) {
                                        i18 |= 48;
                                        i20 = i19;
                                    } else if ((i3 & 48) == 0) {
                                        i20 = i19;
                                        i18 |= composerStartRestartGroup.changed(i) ? 32 : 16;
                                    } else {
                                        i20 = i19;
                                    }
                                    int i27 = i18;
                                    i21 = i4 & 4096;
                                    if (i21 == 0) {
                                        i22 = i27 | 384;
                                    } else if ((i3 & 384) == 0) {
                                        i22 = i27 | (composerStartRestartGroup.changed(c) ? 256 : 128);
                                    } else {
                                        i22 = i27;
                                    }
                                    if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
                                        composer2 = composerStartRestartGroup;
                                        composer2.skipToGroupEnd();
                                        function22 = function2;
                                        i23 = i;
                                        z3 = z2;
                                        inputTransformation3 = inputTransformation2;
                                        textStyle3 = textStyle2;
                                        keyboardOptions3 = keyboardOptions2;
                                        modifier3 = modifier2;
                                        keyboardActionHandler3 = keyboardActionHandler2;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        brush2 = brush;
                                        textFieldDecorator2 = textFieldDecorator;
                                        c2 = c;
                                    } else {
                                        if (i26 != 0) {
                                            modifier4 = Modifier.INSTANCE;
                                            i24 = i7;
                                        } else {
                                            i24 = i7;
                                            modifier4 = modifier2;
                                        }
                                        boolean z4 = i6 != 0 ? true : z2;
                                        InputTransformation inputTransformation4 = i24 != 0 ? null : inputTransformation2;
                                        if (i8 != 0) {
                                            textStyle4 = TextStyle.INSTANCE.getDefault();
                                            i25 = i9;
                                        } else {
                                            i25 = i9;
                                            textStyle4 = textStyle2;
                                        }
                                        KeyboardOptions secureTextField$foundation = i25 != 0 ? KeyboardOptions.INSTANCE.getSecureTextField$foundation() : keyboardOptions2;
                                        KeyboardActionHandler keyboardActionHandler4 = i10 != 0 ? null : keyboardActionHandler2;
                                        Function2 function23 = i12 != 0 ? null : function2;
                                        MutableInteractionSource mutableInteractionSource3 = i14 != 0 ? null : mutableInteractionSource;
                                        Brush solidColor = i16 != 0 ? new SolidColor(Color.INSTANCE.m6351getBlack0d7_KjU(), null) : brush;
                                        TextFieldDecorator textFieldDecorator3 = i17 != 0 ? null : textFieldDecorator;
                                        int iM2578getRevealLastTypedvTwcZD0 = i20 != 0 ? TextObfuscationMode.INSTANCE.m2578getRevealLastTypedvTwcZD0() : i;
                                        char c3 = i21 != 0 ? (char) 8226 : c;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1399310985, i5, i22, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:363)");
                                        }
                                        int i28 = i5 << 3;
                                        int i29 = i22 << 3;
                                        composer2 = composerStartRestartGroup;
                                        m2356BasicSecureTextFieldltb6GB4(textFieldState2, modifier4, z4, false, inputTransformation4, textStyle4, secureTextField$foundation, keyboardActionHandler4, function23, mutableInteractionSource3, solidColor, textFieldDecorator3, iM2578getRevealLastTypedvTwcZD0, c3, null, composer2, (i5 & 14) | 3072 | (i5 & 112) | (i5 & 896) | (57344 & i28) | (458752 & i28) | (3670016 & i28) | (29360128 & i28) | (234881024 & i28) | (i28 & 1879048192), ((i5 >> 27) & 14) | (i29 & 112) | (i29 & 896) | (i29 & 7168), 16384);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier3 = modifier4;
                                        z3 = z4;
                                        inputTransformation3 = inputTransformation4;
                                        textStyle3 = textStyle4;
                                        keyboardOptions3 = secureTextField$foundation;
                                        keyboardActionHandler3 = keyboardActionHandler4;
                                        function22 = function23;
                                        mutableInteractionSource2 = mutableInteractionSource3;
                                        brush2 = solidColor;
                                        textFieldDecorator2 = textFieldDecorator3;
                                        i23 = iM2578getRevealLastTypedvTwcZD0;
                                        c2 = c3;
                                    }
                                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup == null) {
                                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda2
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj, Object obj2) {
                                                return BasicSecureTextFieldKt.BasicSecureTextField_Jb9bMDk$lambda$0(textFieldState, modifier3, z3, inputTransformation3, textStyle3, keyboardOptions3, keyboardActionHandler3, function22, mutableInteractionSource2, brush2, textFieldDecorator2, i23, c2, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i5 |= 805306368;
                                i16 = i15;
                                i17 = i4 & 1024;
                                if (i17 == 0) {
                                }
                                i19 = i4 & 2048;
                                if (i19 == 0) {
                                }
                                int i272 = i18;
                                i21 = i4 & 4096;
                                if (i21 == 0) {
                                }
                                if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                }
                            }
                            i14 = i13;
                            i15 = i4 & 512;
                            if (i15 == 0) {
                            }
                            i16 = i15;
                            i17 = i4 & 1024;
                            if (i17 == 0) {
                            }
                            i19 = i4 & 2048;
                            if (i19 == 0) {
                            }
                            int i2722 = i18;
                            i21 = i4 & 4096;
                            if (i21 == 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        i12 = i11;
                        i13 = i4 & 256;
                        if (i13 == 0) {
                        }
                        i14 = i13;
                        i15 = i4 & 512;
                        if (i15 == 0) {
                        }
                        i16 = i15;
                        i17 = i4 & 1024;
                        if (i17 == 0) {
                        }
                        i19 = i4 & 2048;
                        if (i19 == 0) {
                        }
                        int i27222 = i18;
                        i21 = i4 & 4096;
                        if (i21 == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    textStyle2 = textStyle;
                    i9 = i4 & 32;
                    if (i9 != 0) {
                    }
                    i10 = i4 & 64;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 128;
                    if (i11 != 0) {
                    }
                    i12 = i11;
                    i13 = i4 & 256;
                    if (i13 == 0) {
                    }
                    i14 = i13;
                    i15 = i4 & 512;
                    if (i15 == 0) {
                    }
                    i16 = i15;
                    i17 = i4 & 1024;
                    if (i17 == 0) {
                    }
                    i19 = i4 & 2048;
                    if (i19 == 0) {
                    }
                    int i272222 = i18;
                    i21 = i4 & 4096;
                    if (i21 == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                inputTransformation2 = inputTransformation;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                textStyle2 = textStyle;
                i9 = i4 & 32;
                if (i9 != 0) {
                }
                i10 = i4 & 64;
                if (i10 != 0) {
                }
                i11 = i4 & 128;
                if (i11 != 0) {
                }
                i12 = i11;
                i13 = i4 & 256;
                if (i13 == 0) {
                }
                i14 = i13;
                i15 = i4 & 512;
                if (i15 == 0) {
                }
                i16 = i15;
                i17 = i4 & 1024;
                if (i17 == 0) {
                }
                i19 = i4 & 2048;
                if (i19 == 0) {
                }
                int i2722222 = i18;
                i21 = i4 & 4096;
                if (i21 == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z2 = z;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            inputTransformation2 = inputTransformation;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            textStyle2 = textStyle;
            i9 = i4 & 32;
            if (i9 != 0) {
            }
            i10 = i4 & 64;
            if (i10 != 0) {
            }
            i11 = i4 & 128;
            if (i11 != 0) {
            }
            i12 = i11;
            i13 = i4 & 256;
            if (i13 == 0) {
            }
            i14 = i13;
            i15 = i4 & 512;
            if (i15 == 0) {
            }
            i16 = i15;
            i17 = i4 & 1024;
            if (i17 == 0) {
            }
            i19 = i4 & 2048;
            if (i19 == 0) {
            }
            int i27222222 = i18;
            i21 = i4 & 4096;
            if (i21 == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        z2 = z;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        inputTransformation2 = inputTransformation;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        textStyle2 = textStyle;
        i9 = i4 & 32;
        if (i9 != 0) {
        }
        i10 = i4 & 64;
        if (i10 != 0) {
        }
        i11 = i4 & 128;
        if (i11 != 0) {
        }
        i12 = i11;
        i13 = i4 & 256;
        if (i13 == 0) {
        }
        i14 = i13;
        i15 = i4 & 512;
        if (i15 == 0) {
        }
        i16 = i15;
        i17 = i4 & 1024;
        if (i17 == 0) {
        }
        i19 = i4 & 2048;
        if (i19 == 0) {
        }
        int i272222222 = i18;
        i21 = i4 & 4096;
        if (i21 == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i22 & 147) != 146, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:205:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012d  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the overload that takes in scrollState parameter.")
    /* JADX INFO: renamed from: BasicSecureTextField-egD4TGM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2355BasicSecureTextFieldegD4TGM(final TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, Composer composer, final int i2, final int i3, final int i4) {
        TextFieldState textFieldState2;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        int i7;
        InputTransformation inputTransformation2;
        int i8;
        TextStyle textStyle2;
        int i9;
        KeyboardOptions keyboardOptions2;
        int i10;
        int i11;
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
        int i22;
        Composer composer2;
        final boolean z4;
        final KeyboardActionHandler keyboardActionHandler2;
        final Function2 function22;
        final int i23;
        final char c2;
        final boolean z5;
        final InputTransformation inputTransformation3;
        final TextStyle textStyle3;
        final KeyboardOptions keyboardOptions3;
        final Modifier modifier3;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final TextFieldDecorator textFieldDecorator2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i24;
        Modifier modifier4;
        int i25;
        InputTransformation inputTransformation4;
        int i26;
        TextStyle textStyle4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-817513499);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicSecureTextField)N(state,modifier,enabled,readOnly,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,onTextLayout,interactionSource,cursorBrush,decorator,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter)421@19275L21,406@18694L609:BasicSecureTextField.kt#423gt5");
        if ((i2 & 6) == 0) {
            textFieldState2 = textFieldState;
            i5 = (composerStartRestartGroup.changed(textFieldState2) ? 4 : 2) | i2;
        } else {
            textFieldState2 = textFieldState;
            i5 = i2;
        }
        int i27 = i4 & 2;
        if (i27 != 0) {
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
                    z3 = z;
                    i5 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
                }
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((i2 & 24576) == 0) {
                        inputTransformation2 = inputTransformation;
                        i5 |= composerStartRestartGroup.changed(inputTransformation2) ? 16384 : 8192;
                    }
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        textStyle2 = textStyle;
                    } else {
                        textStyle2 = textStyle;
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i5 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                        }
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                        keyboardOptions2 = keyboardOptions;
                    } else {
                        keyboardOptions2 = keyboardOptions;
                        if ((i2 & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changed(keyboardOptions2) ? 1048576 : 524288;
                        }
                    }
                    i10 = i4 & 128;
                    if (i10 == 0) {
                        i5 |= 12582912;
                    } else if ((i2 & 12582912) == 0) {
                        i5 |= composerStartRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                    }
                    i11 = i4 & 256;
                    if (i11 == 0) {
                        i5 |= 100663296;
                    } else {
                        if ((i2 & 100663296) == 0) {
                            i12 = i11;
                            i5 |= composerStartRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
                        }
                        i13 = i4 & 512;
                        if (i13 == 0) {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                            }
                            i15 = i4 & 1024;
                            if (i15 == 0) {
                                i17 = i3 | 6;
                                i16 = i15;
                            } else if ((i3 & 6) == 0) {
                                i16 = i15;
                                i17 = i3 | (composerStartRestartGroup.changed(brush) ? 4 : 2);
                            } else {
                                i16 = i15;
                                i17 = i3;
                            }
                            i18 = i4 & 2048;
                            if (i18 == 0) {
                                i17 |= 48;
                            } else if ((i3 & 48) == 0) {
                                i17 |= (i3 & 64) == 0 ? composerStartRestartGroup.changed(textFieldDecorator) : composerStartRestartGroup.changedInstance(textFieldDecorator) ? 32 : 16;
                            }
                            int i28 = i17;
                            i19 = i4 & 4096;
                            if (i19 == 0) {
                                i20 = i28 | 384;
                            } else if ((i3 & 384) == 0) {
                                i20 = i28 | (composerStartRestartGroup.changed(i) ? 256 : 128);
                            } else {
                                i20 = i28;
                            }
                            i21 = i4 & 8192;
                            if (i21 == 0) {
                                i22 = i20 | 3072;
                            } else {
                                int i29 = i20;
                                if ((i3 & 3072) == 0) {
                                    i29 |= composerStartRestartGroup.changed(c) ? 2048 : 1024;
                                }
                                i22 = i29;
                            }
                            if (composerStartRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i22 & 1171) != 1170, i5 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                z4 = z2;
                                keyboardActionHandler2 = keyboardActionHandler;
                                function22 = function2;
                                i23 = i;
                                c2 = c;
                                z5 = z3;
                                inputTransformation3 = inputTransformation2;
                                textStyle3 = textStyle2;
                                keyboardOptions3 = keyboardOptions2;
                                modifier3 = modifier2;
                                mutableInteractionSource2 = mutableInteractionSource;
                                brush2 = brush;
                                textFieldDecorator2 = textFieldDecorator;
                            } else {
                                if (i27 != 0) {
                                    modifier4 = Modifier.INSTANCE;
                                    i24 = i7;
                                } else {
                                    i24 = i7;
                                    modifier4 = modifier2;
                                }
                                boolean z6 = i6 != 0 ? true : z3;
                                boolean z7 = (i4 & 8) != 0 ? false : z2;
                                if (i24 != 0) {
                                    i25 = i21;
                                    inputTransformation4 = null;
                                } else {
                                    i25 = i21;
                                    inputTransformation4 = inputTransformation2;
                                }
                                if (i8 != 0) {
                                    textStyle4 = TextStyle.INSTANCE.getDefault();
                                    i26 = i9;
                                } else {
                                    i26 = i9;
                                    textStyle4 = textStyle2;
                                }
                                KeyboardOptions secureTextField$foundation = i26 != 0 ? KeyboardOptions.INSTANCE.getSecureTextField$foundation() : keyboardOptions2;
                                KeyboardActionHandler keyboardActionHandler3 = i10 != 0 ? null : keyboardActionHandler;
                                Function2 function23 = i12 != 0 ? null : function2;
                                MutableInteractionSource mutableInteractionSource3 = i14 != 0 ? null : mutableInteractionSource;
                                Brush solidColor = i16 != 0 ? new SolidColor(Color.INSTANCE.m6351getBlack0d7_KjU(), null) : brush;
                                TextFieldDecorator textFieldDecorator3 = i18 != 0 ? null : textFieldDecorator;
                                int iM2578getRevealLastTypedvTwcZD0 = i19 != 0 ? TextObfuscationMode.INSTANCE.m2578getRevealLastTypedvTwcZD0() : i;
                                char c3 = i25 != 0 ? (char) 8226 : c;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-817513499, i5, i22, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:405)");
                                }
                                composer2 = composerStartRestartGroup;
                                m2356BasicSecureTextFieldltb6GB4(textFieldState2, modifier4, z6, false, inputTransformation4, textStyle4, secureTextField$foundation, keyboardActionHandler3, function23, mutableInteractionSource3, solidColor, textFieldDecorator3, iM2578getRevealLastTypedvTwcZD0, c3, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), composer2, (i5 & 14) | 3072 | (i5 & 112) | (i5 & 896) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (234881024 & i5) | (1879048192 & i5), i22 & 8190, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z4 = z7;
                                modifier3 = modifier4;
                                z5 = z6;
                                inputTransformation3 = inputTransformation4;
                                textStyle3 = textStyle4;
                                keyboardOptions3 = secureTextField$foundation;
                                keyboardActionHandler2 = keyboardActionHandler3;
                                function22 = function23;
                                mutableInteractionSource2 = mutableInteractionSource3;
                                brush2 = solidColor;
                                textFieldDecorator2 = textFieldDecorator3;
                                i23 = iM2578getRevealLastTypedvTwcZD0;
                                c2 = c3;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BasicSecureTextFieldKt.BasicSecureTextField_egD4TGM$lambda$0(textFieldState, modifier3, z5, z4, inputTransformation3, textStyle3, keyboardOptions3, keyboardActionHandler2, function22, mutableInteractionSource2, brush2, textFieldDecorator2, i23, c2, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i5 |= 805306368;
                        i14 = i13;
                        i15 = i4 & 1024;
                        if (i15 == 0) {
                        }
                        i18 = i4 & 2048;
                        if (i18 == 0) {
                        }
                        int i282 = i17;
                        i19 = i4 & 4096;
                        if (i19 == 0) {
                        }
                        i21 = i4 & 8192;
                        if (i21 == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i22 & 1171) != 1170, i5 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i12 = i11;
                    i13 = i4 & 512;
                    if (i13 == 0) {
                    }
                    i14 = i13;
                    i15 = i4 & 1024;
                    if (i15 == 0) {
                    }
                    i18 = i4 & 2048;
                    if (i18 == 0) {
                    }
                    int i2822 = i17;
                    i19 = i4 & 4096;
                    if (i19 == 0) {
                    }
                    i21 = i4 & 8192;
                    if (i21 == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i22 & 1171) != 1170, i5 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                inputTransformation2 = inputTransformation;
                i8 = i4 & 32;
                if (i8 == 0) {
                }
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                i10 = i4 & 128;
                if (i10 == 0) {
                }
                i11 = i4 & 256;
                if (i11 == 0) {
                }
                i12 = i11;
                i13 = i4 & 512;
                if (i13 == 0) {
                }
                i14 = i13;
                i15 = i4 & 1024;
                if (i15 == 0) {
                }
                i18 = i4 & 2048;
                if (i18 == 0) {
                }
                int i28222 = i17;
                i19 = i4 & 4096;
                if (i19 == 0) {
                }
                i21 = i4 & 8192;
                if (i21 == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i22 & 1171) != 1170, i5 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            inputTransformation2 = inputTransformation;
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            i9 = i4 & 64;
            if (i9 == 0) {
            }
            i10 = i4 & 128;
            if (i10 == 0) {
            }
            i11 = i4 & 256;
            if (i11 == 0) {
            }
            i12 = i11;
            i13 = i4 & 512;
            if (i13 == 0) {
            }
            i14 = i13;
            i15 = i4 & 1024;
            if (i15 == 0) {
            }
            i18 = i4 & 2048;
            if (i18 == 0) {
            }
            int i282222 = i17;
            i19 = i4 & 4096;
            if (i19 == 0) {
            }
            i21 = i4 & 8192;
            if (i21 == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i22 & 1171) != 1170, i5 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        z3 = z;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        inputTransformation2 = inputTransformation;
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        i9 = i4 & 64;
        if (i9 == 0) {
        }
        i10 = i4 & 128;
        if (i10 == 0) {
        }
        i11 = i4 & 256;
        if (i11 == 0) {
        }
        i12 = i11;
        i13 = i4 & 512;
        if (i13 == 0) {
        }
        i14 = i13;
        i15 = i4 & 1024;
        if (i15 == 0) {
        }
        i18 = i4 & 2048;
        if (i18 == 0) {
        }
        int i2822222 = i17;
        i19 = i4 & 4096;
        if (i19 == 0) {
        }
        i21 = i4 & 8192;
        if (i21 == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i22 & 1171) != 1170, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:283:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0129  */
    /* JADX INFO: renamed from: BasicSecureTextField-ltb6GB4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2356BasicSecureTextFieldltb6GB4(final TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, ScrollState scrollState, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        int i7;
        boolean z4;
        int i8;
        final InputTransformation inputTransformation2;
        int i9;
        TextStyle textStyle2;
        int i10;
        final KeyboardOptions secureTextField$foundation;
        int i11;
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
        int i22;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function22;
        final int i23;
        final char c2;
        Composer composer2;
        final boolean z5;
        final boolean z6;
        final InputTransformation inputTransformation3;
        final Modifier modifier3;
        final TextStyle textStyle3;
        final KeyboardActionHandler keyboardActionHandler2;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final TextFieldDecorator textFieldDecorator2;
        final ScrollState scrollState2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        KeyboardOptions keyboardOptions2;
        boolean z7;
        SolidColor solidColor;
        int i24;
        final ScrollState scrollStateRememberScrollState;
        final Brush brush3;
        final TextFieldDecorator textFieldDecorator3;
        final KeyboardActionHandler keyboardActionHandler3;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function23;
        final MutableInteractionSource mutableInteractionSource3;
        TextStyle textStyle4;
        char c3;
        final boolean z8;
        int i25;
        final boolean z9;
        boolean zPlatformAllowsRevealLastTyped;
        char c4;
        boolean z10;
        Object objRememberedValue;
        Object objRememberedValue2;
        BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1 basicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1RememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(1568790509);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicSecureTextField)N(state,modifier,enabled,readOnly,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,onTextLayout,interactionSource,cursorBrush,decorator,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter,scrollState)140@8345L46,141@8428L60,142@8535L130,142@8493L172,155@9098L129,155@9059L168,162@9271L424,176@9771L38,177@9841L288,191@10367L891,191@10352L906:BasicSecureTextField.kt#423gt5");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(textFieldState) ? 4 : 2) | i2;
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
                    z3 = z;
                    i5 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
                }
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i2 & 3072) == 0) {
                        z4 = z2;
                        i5 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                    }
                    i8 = i4 & 16;
                    int i27 = 8192;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else {
                        if ((i2 & 24576) == 0) {
                            inputTransformation2 = inputTransformation;
                            i5 |= composerStartRestartGroup.changed(inputTransformation2) ? 16384 : 8192;
                        }
                        i9 = i4 & 32;
                        if (i9 != 0) {
                            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            textStyle2 = textStyle;
                        } else {
                            textStyle2 = textStyle;
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i5 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                            }
                        }
                        i10 = i4 & 64;
                        if (i10 != 0) {
                            i5 |= 1572864;
                            secureTextField$foundation = keyboardOptions;
                        } else {
                            secureTextField$foundation = keyboardOptions;
                            if ((i2 & 1572864) == 0) {
                                i5 |= composerStartRestartGroup.changed(secureTextField$foundation) ? 1048576 : 524288;
                            }
                        }
                        i11 = i4 & 128;
                        if (i11 != 0) {
                            i5 |= 12582912;
                        } else if ((i2 & 12582912) == 0) {
                            i5 |= composerStartRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                        }
                        i12 = i4 & 256;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else {
                            if ((i2 & 100663296) == 0) {
                                i13 = i12;
                                i5 |= composerStartRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
                            }
                            i14 = i4 & 512;
                            if (i14 != 0) {
                                if ((i2 & 805306368) == 0) {
                                    i15 = i14;
                                    i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                                }
                                i16 = i4 & 1024;
                                if (i16 != 0) {
                                    i18 = i3 | 6;
                                    i17 = i16;
                                } else if ((i3 & 6) == 0) {
                                    i17 = i16;
                                    i18 = i3 | (composerStartRestartGroup.changed(brush) ? 4 : 2);
                                } else {
                                    i17 = i16;
                                    i18 = i3;
                                }
                                i19 = i4 & 2048;
                                if (i19 != 0) {
                                    i18 |= 48;
                                } else if ((i3 & 48) == 0) {
                                    i18 |= (i3 & 64) == 0 ? composerStartRestartGroup.changed(textFieldDecorator) : composerStartRestartGroup.changedInstance(textFieldDecorator) ? 32 : 16;
                                }
                                if ((i3 & 384) == 0) {
                                    i18 |= ((i4 & 4096) == 0 && composerStartRestartGroup.changed(i)) ? 256 : 128;
                                }
                                int i28 = i18;
                                i20 = i4 & 8192;
                                if (i20 != 0) {
                                    i21 = i28 | 3072;
                                } else if ((i3 & 3072) == 0) {
                                    i21 = i28 | (composerStartRestartGroup.changed(c) ? 2048 : 1024);
                                } else {
                                    i21 = i28;
                                }
                                if ((i3 & 24576) == 0) {
                                    if ((i4 & 16384) == 0 && composerStartRestartGroup.changed(scrollState)) {
                                        i27 = 16384;
                                    }
                                    i21 |= i27;
                                }
                                i22 = i21;
                                if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i22 & 9363) == 9362) ? false : true, i5 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "138@8287L21");
                                    if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        companion = i26 != 0 ? Modifier.INSTANCE : modifier2;
                                        if (i6 != 0) {
                                            z3 = true;
                                        }
                                        if (i7 != 0) {
                                            z4 = false;
                                        }
                                        if (i8 != 0) {
                                            inputTransformation2 = null;
                                        }
                                        if (i9 != 0) {
                                            textStyle2 = TextStyle.INSTANCE.getDefault();
                                        }
                                        if (i10 != 0) {
                                            secureTextField$foundation = KeyboardOptions.INSTANCE.getSecureTextField$foundation();
                                        }
                                        KeyboardActionHandler keyboardActionHandler4 = i11 != 0 ? null : keyboardActionHandler;
                                        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function24 = i13 != 0 ? null : function2;
                                        MutableInteractionSource mutableInteractionSource4 = i15 != 0 ? null : mutableInteractionSource;
                                        if (i17 != 0) {
                                            keyboardOptions2 = secureTextField$foundation;
                                            z7 = z3;
                                            solidColor = new SolidColor(Color.INSTANCE.m6351getBlack0d7_KjU(), null);
                                        } else {
                                            keyboardOptions2 = secureTextField$foundation;
                                            z7 = z3;
                                            solidColor = brush;
                                        }
                                        TextFieldDecorator textFieldDecorator4 = i19 != 0 ? null : textFieldDecorator;
                                        if ((i4 & 4096) != 0) {
                                            i24 = TextObfuscationMode_androidKt.getDefault(TextObfuscationMode.INSTANCE);
                                            i22 &= -897;
                                        } else {
                                            i24 = i;
                                        }
                                        char c5 = i20 != 0 ? (char) 8226 : c;
                                        int i29 = i22;
                                        if ((i4 & 16384) != 0) {
                                            brush3 = solidColor;
                                            textFieldDecorator3 = textFieldDecorator4;
                                            function23 = function24;
                                            mutableInteractionSource3 = mutableInteractionSource4;
                                            c3 = c5;
                                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                            secureTextField$foundation = keyboardOptions2;
                                            i25 = i29 & (-57345);
                                            keyboardActionHandler3 = keyboardActionHandler4;
                                            z9 = z4;
                                            textStyle4 = textStyle2;
                                            z8 = z7;
                                        } else {
                                            scrollStateRememberScrollState = scrollState;
                                            brush3 = solidColor;
                                            textFieldDecorator3 = textFieldDecorator4;
                                            keyboardActionHandler3 = keyboardActionHandler4;
                                            function23 = function24;
                                            mutableInteractionSource3 = mutableInteractionSource4;
                                            textStyle4 = textStyle2;
                                            c3 = c5;
                                            z8 = z7;
                                            secureTextField$foundation = keyboardOptions2;
                                            i25 = i29;
                                            z9 = z4;
                                        }
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i4 & 4096) != 0) {
                                            i22 &= -897;
                                        }
                                        if ((i4 & 16384) != 0) {
                                            i22 &= -57345;
                                        }
                                        keyboardActionHandler3 = keyboardActionHandler;
                                        function23 = function2;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        brush3 = brush;
                                        textFieldDecorator3 = textFieldDecorator;
                                        c3 = c;
                                        scrollStateRememberScrollState = scrollState;
                                        i25 = i22;
                                        z9 = z4;
                                        companion = modifier2;
                                        textStyle4 = textStyle2;
                                        z8 = z3;
                                        i24 = i;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1568790509, i5, i25, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:139)");
                                    }
                                    final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Character.valueOf(c3), composerStartRestartGroup, (i25 >> 9) & 14);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 74191401, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = new SecureTextFieldController(stateRememberUpdatedState);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    }
                                    final SecureTextFieldController secureTextFieldController = (SecureTextFieldController) objRememberedValue3;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 74194895, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(secureTextFieldController);
                                    BasicSecureTextFieldKt$BasicSecureTextField$1$1 basicSecureTextFieldKt$BasicSecureTextField$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (zChangedInstance || basicSecureTextFieldKt$BasicSecureTextField$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        basicSecureTextFieldKt$BasicSecureTextField$1$1RememberedValue = new BasicSecureTextFieldKt$BasicSecureTextField$1$1(secureTextFieldController, null);
                                        composerStartRestartGroup.updateRememberedValue(basicSecureTextFieldKt$BasicSecureTextField$1$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    EffectsKt.LaunchedEffect(secureTextFieldController, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) basicSecureTextFieldKt$BasicSecureTextField$1$1RememberedValue, composerStartRestartGroup, 0);
                                    if (TextObfuscationMode.m2573equalsimpl0(i24, TextObfuscationMode.INSTANCE.m2578getRevealLastTypedvTwcZD0())) {
                                        composerStartRestartGroup.startReplaceGroup(74207180);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "152@8922L31");
                                        zPlatformAllowsRevealLastTyped = BasicSecureTextField_androidKt.platformAllowsRevealLastTyped(composerStartRestartGroup, 0);
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-1994543479);
                                        composerStartRestartGroup.endReplaceGroup();
                                        zPlatformAllowsRevealLastTyped = false;
                                    }
                                    Boolean boolValueOf = Boolean.valueOf(zPlatformAllowsRevealLastTyped);
                                    final TextStyle textStyle5 = textStyle4;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 74212910, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                    boolean zChanged = composerStartRestartGroup.changed(zPlatformAllowsRevealLastTyped) | composerStartRestartGroup.changedInstance(secureTextFieldController);
                                    BasicSecureTextFieldKt$BasicSecureTextField$2$1 basicSecureTextFieldKt$BasicSecureTextField$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (zChanged) {
                                        c4 = c3;
                                    } else {
                                        c4 = c3;
                                        if (basicSecureTextFieldKt$BasicSecureTextField$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) basicSecureTextFieldKt$BasicSecureTextField$2$1RememberedValue, composerStartRestartGroup, 0);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 74218741, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                        z10 = (((i25 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(i24)) || (i25 & 384) == 256;
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            CodepointTransformation codepointTransformation = !TextObfuscationMode.m2573equalsimpl0(i24, TextObfuscationMode.INSTANCE.m2578getRevealLastTypedvTwcZD0()) ? secureTextFieldController.getCodepointTransformation() : TextObfuscationMode.m2573equalsimpl0(i24, TextObfuscationMode.INSTANCE.m2577getHiddenvTwcZD0()) ? new CodepointTransformation() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda3
                                                @Override // androidx.compose.foundation.text.input.internal.CodepointTransformation
                                                public final int transform(int i30, int i31) {
                                                    return BasicSecureTextFieldKt.BasicSecureTextField_ltb6GB4$lambda$3$0(stateRememberUpdatedState, i30, i31);
                                                }
                                            } : null;
                                            composerStartRestartGroup.updateRememberedValue(codepointTransformation);
                                            objRememberedValue = codepointTransformation;
                                        }
                                        final CodepointTransformation codepointTransformation2 = (CodepointTransformation) objRememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 74234355, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda4
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj) {
                                                    return BasicSecureTextFieldKt.BasicSecureTextField_ltb6GB4$lambda$4$0((SemanticsPropertyReceiver) obj);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue2, 1, null);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 74236845, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                        basicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (basicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                            basicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1RememberedValue = new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1
                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                                    return m2357invokeZmokQxo(keyEvent.m7470unboximpl());
                                                }

                                                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                                                public final Boolean m2357invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                                    KeyCommand keyCommandMo2419mapZmokQxo = KeyMapping_androidKt.getPlatformDefaultKeyMapping().mo2419mapZmokQxo(keyEvent);
                                                    return Boolean.valueOf(keyCommandMo2419mapZmokQxo == KeyCommand.COPY || keyCommandMo2419mapZmokQxo == KeyCommand.CUT);
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(basicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1RememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        final Modifier modifierThen = KeyInputModifierKt.onPreviewKeyEvent(modifierSemantics$default, (Function1) basicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1RememberedValue).then(!zPlatformAllowsRevealLastTyped ? secureTextFieldController.getFocusChangeModifier() : Modifier.INSTANCE);
                                        final KeyboardOptions keyboardOptions3 = secureTextField$foundation;
                                        final boolean z11 = zPlatformAllowsRevealLastTyped;
                                        DisableCutCopy(ComposableLambdaKt.rememberComposableLambda(135148049, true, new Function2() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda5
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj, Object obj2) {
                                                return BasicSecureTextFieldKt.BasicSecureTextField_ltb6GB4$lambda$6(z11, inputTransformation2, secureTextFieldController, textFieldState, modifierThen, z8, z9, textStyle5, keyboardOptions3, keyboardActionHandler3, function23, mutableInteractionSource3, brush3, codepointTransformation2, textFieldDecorator3, scrollStateRememberScrollState, (Composer) obj, ((Integer) obj2).intValue());
                                            }
                                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        c2 = c4;
                                        modifier3 = companion;
                                        composer2 = composerStartRestartGroup;
                                        i23 = i24;
                                        inputTransformation3 = inputTransformation2;
                                        z5 = z8;
                                        z6 = z9;
                                        textStyle3 = textStyle5;
                                        secureTextField$foundation = keyboardOptions3;
                                        keyboardActionHandler2 = keyboardActionHandler3;
                                        function22 = function23;
                                        mutableInteractionSource2 = mutableInteractionSource3;
                                        brush2 = brush3;
                                        textFieldDecorator2 = textFieldDecorator3;
                                        scrollState2 = scrollStateRememberScrollState;
                                    }
                                    basicSecureTextFieldKt$BasicSecureTextField$2$1RememberedValue = new BasicSecureTextFieldKt$BasicSecureTextField$2$1(zPlatformAllowsRevealLastTyped, secureTextFieldController, null);
                                    composerStartRestartGroup.updateRememberedValue(basicSecureTextFieldKt$BasicSecureTextField$2$1RememberedValue);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) basicSecureTextFieldKt$BasicSecureTextField$2$1RememberedValue, composerStartRestartGroup, 0);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 74218741, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                    if (((i25 & 896) ^ 384) <= 256) {
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (z10) {
                                            if (!TextObfuscationMode.m2573equalsimpl0(i24, TextObfuscationMode.INSTANCE.m2578getRevealLastTypedvTwcZD0())) {
                                            }
                                            composerStartRestartGroup.updateRememberedValue(codepointTransformation);
                                            objRememberedValue = codepointTransformation;
                                            final CodepointTransformation codepointTransformation22 = (CodepointTransformation) objRememberedValue;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 74234355, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue2, 1, null);
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 74236845, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                            basicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (basicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            final Modifier modifierThen2 = KeyInputModifierKt.onPreviewKeyEvent(modifierSemantics$default2, (Function1) basicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1RememberedValue).then(!zPlatformAllowsRevealLastTyped ? secureTextFieldController.getFocusChangeModifier() : Modifier.INSTANCE);
                                            final KeyboardOptions keyboardOptions32 = secureTextField$foundation;
                                            final boolean z112 = zPlatformAllowsRevealLastTyped;
                                            DisableCutCopy(ComposableLambdaKt.rememberComposableLambda(135148049, true, new Function2() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda5
                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(Object obj, Object obj2) {
                                                    return BasicSecureTextFieldKt.BasicSecureTextField_ltb6GB4$lambda$6(z112, inputTransformation2, secureTextFieldController, textFieldState, modifierThen2, z8, z9, textStyle5, keyboardOptions32, keyboardActionHandler3, function23, mutableInteractionSource3, brush3, codepointTransformation22, textFieldDecorator3, scrollStateRememberScrollState, (Composer) obj, ((Integer) obj2).intValue());
                                                }
                                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            c2 = c4;
                                            modifier3 = companion;
                                            composer2 = composerStartRestartGroup;
                                            i23 = i24;
                                            inputTransformation3 = inputTransformation2;
                                            z5 = z8;
                                            z6 = z9;
                                            textStyle3 = textStyle5;
                                            secureTextField$foundation = keyboardOptions32;
                                            keyboardActionHandler2 = keyboardActionHandler3;
                                            function22 = function23;
                                            mutableInteractionSource2 = mutableInteractionSource3;
                                            brush2 = brush3;
                                            textFieldDecorator2 = textFieldDecorator3;
                                            scrollState2 = scrollStateRememberScrollState;
                                        }
                                    } else {
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (z10) {
                                        }
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    function22 = function2;
                                    i23 = i;
                                    c2 = c;
                                    composer2 = composerStartRestartGroup;
                                    z5 = z3;
                                    z6 = z4;
                                    inputTransformation3 = inputTransformation2;
                                    modifier3 = modifier2;
                                    textStyle3 = textStyle2;
                                    keyboardActionHandler2 = keyboardActionHandler;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    brush2 = brush;
                                    textFieldDecorator2 = textFieldDecorator;
                                    scrollState2 = scrollState;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda6
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return BasicSecureTextFieldKt.BasicSecureTextField_ltb6GB4$lambda$7(textFieldState, modifier3, z5, z6, inputTransformation3, textStyle3, secureTextField$foundation, keyboardActionHandler2, function22, mutableInteractionSource2, brush2, textFieldDecorator2, i23, c2, scrollState2, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i5 |= 805306368;
                            i15 = i14;
                            i16 = i4 & 1024;
                            if (i16 != 0) {
                            }
                            i19 = i4 & 2048;
                            if (i19 != 0) {
                            }
                            if ((i3 & 384) == 0) {
                            }
                            int i282 = i18;
                            i20 = i4 & 8192;
                            if (i20 != 0) {
                            }
                            if ((i3 & 24576) == 0) {
                            }
                            i22 = i21;
                            if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i22 & 9363) == 9362) ? false : true, i5 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i13 = i12;
                        i14 = i4 & 512;
                        if (i14 != 0) {
                        }
                        i15 = i14;
                        i16 = i4 & 1024;
                        if (i16 != 0) {
                        }
                        i19 = i4 & 2048;
                        if (i19 != 0) {
                        }
                        if ((i3 & 384) == 0) {
                        }
                        int i2822 = i18;
                        i20 = i4 & 8192;
                        if (i20 != 0) {
                        }
                        if ((i3 & 24576) == 0) {
                        }
                        i22 = i21;
                        if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i22 & 9363) == 9362) ? false : true, i5 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    inputTransformation2 = inputTransformation;
                    i9 = i4 & 32;
                    if (i9 != 0) {
                    }
                    i10 = i4 & 64;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 128;
                    if (i11 != 0) {
                    }
                    i12 = i4 & 256;
                    if (i12 != 0) {
                    }
                    i13 = i12;
                    i14 = i4 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i4 & 1024;
                    if (i16 != 0) {
                    }
                    i19 = i4 & 2048;
                    if (i19 != 0) {
                    }
                    if ((i3 & 384) == 0) {
                    }
                    int i28222 = i18;
                    i20 = i4 & 8192;
                    if (i20 != 0) {
                    }
                    if ((i3 & 24576) == 0) {
                    }
                    i22 = i21;
                    if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i22 & 9363) == 9362) ? false : true, i5 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z4 = z2;
                i8 = i4 & 16;
                int i272 = 8192;
                if (i8 == 0) {
                }
                inputTransformation2 = inputTransformation;
                i9 = i4 & 32;
                if (i9 != 0) {
                }
                i10 = i4 & 64;
                if (i10 != 0) {
                }
                i11 = i4 & 128;
                if (i11 != 0) {
                }
                i12 = i4 & 256;
                if (i12 != 0) {
                }
                i13 = i12;
                i14 = i4 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i4 & 1024;
                if (i16 != 0) {
                }
                i19 = i4 & 2048;
                if (i19 != 0) {
                }
                if ((i3 & 384) == 0) {
                }
                int i282222 = i18;
                i20 = i4 & 8192;
                if (i20 != 0) {
                }
                if ((i3 & 24576) == 0) {
                }
                i22 = i21;
                if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i22 & 9363) == 9362) ? false : true, i5 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z3 = z;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            z4 = z2;
            i8 = i4 & 16;
            int i2722 = 8192;
            if (i8 == 0) {
            }
            inputTransformation2 = inputTransformation;
            i9 = i4 & 32;
            if (i9 != 0) {
            }
            i10 = i4 & 64;
            if (i10 != 0) {
            }
            i11 = i4 & 128;
            if (i11 != 0) {
            }
            i12 = i4 & 256;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i4 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i4 & 1024;
            if (i16 != 0) {
            }
            i19 = i4 & 2048;
            if (i19 != 0) {
            }
            if ((i3 & 384) == 0) {
            }
            int i2822222 = i18;
            i20 = i4 & 8192;
            if (i20 != 0) {
            }
            if ((i3 & 24576) == 0) {
            }
            i22 = i21;
            if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i22 & 9363) == 9362) ? false : true, i5 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        z3 = z;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        z4 = z2;
        i8 = i4 & 16;
        int i27222 = 8192;
        if (i8 == 0) {
        }
        inputTransformation2 = inputTransformation;
        i9 = i4 & 32;
        if (i9 != 0) {
        }
        i10 = i4 & 64;
        if (i10 != 0) {
        }
        i11 = i4 & 128;
        if (i11 != 0) {
        }
        i12 = i4 & 256;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i4 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i4 & 1024;
        if (i16 != 0) {
        }
        i19 = i4 & 2048;
        if (i19 != 0) {
        }
        if ((i3 & 384) == 0) {
        }
        int i28222222 = i18;
        i20 = i4 & 8192;
        if (i20 != 0) {
        }
        if ((i3 & 24576) == 0) {
        }
        i22 = i21;
        if (composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i22 & 9363) == 9362) ? false : true, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit BasicSecureTextField_Jb9bMDk$lambda$0(TextFieldState textFieldState, Modifier modifier, boolean z, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, int i2, int i3, int i4, Composer composer, int i5) {
        m2354BasicSecureTextFieldJb9bMDk(textFieldState, modifier, z, inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, function2, mutableInteractionSource, brush, textFieldDecorator, i, c, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    static final Unit BasicSecureTextField_egD4TGM$lambda$0(TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, int i2, int i3, int i4, Composer composer, int i5) {
        m2355BasicSecureTextFieldegD4TGM(textFieldState, modifier, z, z2, inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, function2, mutableInteractionSource, brush, textFieldDecorator, i, c, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int BasicSecureTextField_ltb6GB4$lambda$3$0(State state, int i, int i2) {
        return ((Character) state.getValue()).charValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicSecureTextField_ltb6GB4$lambda$4$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentType(semanticsPropertyReceiver, ContentType.INSTANCE.getPassword());
        return Unit.INSTANCE;
    }

    static final Unit BasicSecureTextField_ltb6GB4$lambda$6(boolean z, InputTransformation inputTransformation, SecureTextFieldController secureTextFieldController, TextFieldState textFieldState, Modifier modifier, boolean z2, boolean z3, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, CodepointTransformation codepointTransformation, TextFieldDecorator textFieldDecorator, ScrollState scrollState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C192@10377L875:BasicSecureTextField.kt#423gt5");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(135148049, i, -1, "androidx.compose.foundation.text.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:192)");
            }
            BasicTextFieldKt.BasicTextField(textFieldState, modifier, z2, z3, z ? then(inputTransformation, secureTextFieldController.getPasswordInputTransformation()) : inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, TextFieldLineLimits.SingleLine.INSTANCE, function2, mutableInteractionSource, brush, codepointTransformation, null, textFieldDecorator, scrollState, true, composer, 100663296, 1572864, 8192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit BasicSecureTextField_ltb6GB4$lambda$7(TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, ScrollState scrollState, int i2, int i3, int i4, Composer composer, int i5) {
        m2356BasicSecureTextFieldltb6GB4(textFieldState, modifier, z, z2, inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, function2, mutableInteractionSource, brush, textFieldDecorator, i, c, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    private static final void DisableCutCopy(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1141174275);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DisableCutCopy)N(content)312@14862L7,314@14908L877,335@15790L80:BasicSecureTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1141174275, i2, -1, "androidx.compose.foundation.text.DisableCutCopy (BasicSecureTextField.kt:311)");
            }
            ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localTextToolbar);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final TextToolbar textToolbar = (TextToolbar) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1451823216, "CC(remember):BasicSecureTextField.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(textToolbar);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new TextToolbar() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1
                    private final /* synthetic */ TextToolbar $$delegate_0;

                    {
                        this.$$delegate_0 = this.$currentToolbar;
                    }

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public TextToolbarStatus getStatus() {
                        return this.$$delegate_0.getStatus();
                    }

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public void hide() {
                        this.$$delegate_0.hide();
                    }

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public void showMenu(Rect rect, Function0<Unit> onCopyRequested, Function0<Unit> onPasteRequested, Function0<Unit> onCutRequested, Function0<Unit> onSelectAllRequested) {
                        this.$$delegate_0.showMenu(rect, onCopyRequested, onPasteRequested, onCutRequested, onSelectAllRequested);
                    }

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public void showMenu(Rect rect, Function0<Unit> onCopyRequested, Function0<Unit> onPasteRequested, Function0<Unit> onCutRequested, Function0<Unit> onSelectAllRequested, Function0<Unit> onAutofillRequested) {
                        this.$currentToolbar.showMenu(rect, null, onPasteRequested, null, onSelectAllRequested, onAutofillRequested);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalTextToolbar().provides((BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1) objRememberedValue), function2, composerStartRestartGroup, ((i2 << 3) & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicSecureTextFieldKt.DisableCutCopy$lambda$1(function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit DisableCutCopy$lambda$1(Function2 function2, int i, Composer composer, int i2) {
        DisableCutCopy(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final InputTransformation then(InputTransformation inputTransformation, InputTransformation inputTransformation2) {
        return inputTransformation == null ? inputTransformation2 : inputTransformation2 == null ? inputTransformation : InputTransformationKt.then(inputTransformation, inputTransformation2);
    }
}
