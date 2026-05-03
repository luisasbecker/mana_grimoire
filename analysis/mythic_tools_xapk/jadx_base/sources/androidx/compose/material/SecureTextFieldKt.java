package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicSecureTextFieldKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextObfuscationMode;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: SecureTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001añ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0004\b!\u0010\"\u001añ\u0001\u0010#\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0004\b$\u0010\"\"\u000e\u0010%\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"SecureTextField", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", Constants.ScionAnalytics.PARAM_LABEL, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "textObfuscationCharacter", "", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "SecureTextField-0vce7ms", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/text/input/InputTransformation;ICLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "OutlinedSecureTextField", "OutlinedSecureTextField-0vce7ms", "SecureTextFieldKeyboardOptions", "DefaultObfuscationCharacter", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SecureTextFieldKt {
    private static final char DefaultObfuscationCharacter = 8226;
    private static final KeyboardOptions SecureTextFieldKeyboardOptions = new KeyboardOptions(0, (Boolean) false, KeyboardType.INSTANCE.m8802getPasswordPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, Imgproc.COLOR_YUV2RGBA_YVYU, (DefaultConstructorMarker) null);

    /* JADX WARN: Removed duplicated region for block: B:108:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:290:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012a  */
    /* JADX INFO: renamed from: OutlinedSecureTextField-0vce7ms, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3134OutlinedSecureTextField0vce7ms(final TextFieldState textFieldState, Modifier modifier, boolean z, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z2, InputTransformation inputTransformation, int i, char c, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Shape shape, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function28;
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
        final TextStyle textStyle2;
        final char c2;
        final KeyboardOptions keyboardOptions2;
        final TextFieldColors textFieldColors2;
        final MutableInteractionSource mutableInteractionSource2;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final boolean z4;
        final boolean z5;
        final InputTransformation inputTransformation2;
        final int i23;
        final KeyboardActionHandler keyboardActionHandler2;
        final Shape shape2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        TextStyle textStyle3;
        Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        int iM2578getRevealLastTypedvTwcZD0;
        KeyboardOptions keyboardOptions3;
        Shape outlinedTextFieldShape;
        Composer composer3;
        TextFieldColors textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
        int i24;
        MutableInteractionSource mutableInteractionSource3;
        TextFieldColors textFieldColors3;
        int i25;
        boolean z6;
        TextStyle textStyle4;
        int i26;
        boolean z7;
        InputTransformation inputTransformation3;
        int i27;
        char c3;
        KeyboardActionHandler keyboardActionHandler3;
        MutableInteractionSource mutableInteractionSource4;
        TextStyle textStyle5;
        Modifier.Companion companionM2041paddingqDBjuR0$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1856037588);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedSecureTextField)N(state,modifier,enabled,textStyle,label,placeholder,leadingIcon,trailingIcon,isError,inputTransformation,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter,keyboardOptions,onKeyboardAction,shape,colors,interactionSource)250@14549L7,267@15231L38,274@15547L20,252@14562L2138:SecureTextField.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(textFieldState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i28 = i4 & 2;
        if (i28 != 0) {
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
                if ((i2 & 3072) == 0) {
                    i5 |= ((i4 & 8) == 0 && composerStartRestartGroup.changed(textStyle)) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                int i29 = 8192;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((i2 & 24576) == 0) {
                        function25 = function2;
                        i5 |= composerStartRestartGroup.changedInstance(function25) ? 16384 : 8192;
                    }
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function26 = function22;
                    } else {
                        function26 = function22;
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function26) ? 131072 : 65536;
                        }
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                        function27 = function23;
                    } else {
                        function27 = function23;
                        if ((i2 & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function27) ? 1048576 : 524288;
                        }
                    }
                    i10 = i4 & 128;
                    if (i10 == 0) {
                        i5 |= 12582912;
                        function28 = function24;
                    } else {
                        function28 = function24;
                        if ((i2 & 12582912) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function28) ? 8388608 : 4194304;
                        }
                    }
                    i11 = i4 & 256;
                    if (i11 == 0) {
                        i5 |= 100663296;
                    } else {
                        if ((i2 & 100663296) == 0) {
                            i12 = i11;
                            i5 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
                        }
                        i13 = i4 & 512;
                        if (i13 == 0) {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= composerStartRestartGroup.changed(inputTransformation) ? 536870912 : 268435456;
                            }
                            if ((i3 & 6) != 0) {
                                i15 = i3 | (((i4 & 1024) == 0 && composerStartRestartGroup.changed(i)) ? 4 : 2);
                            } else {
                                i15 = i3;
                            }
                            i16 = i4 & 2048;
                            if (i16 == 0) {
                                i15 |= 48;
                                i17 = i16;
                            } else if ((i3 & 48) == 0) {
                                i17 = i16;
                                i15 |= composerStartRestartGroup.changed(c) ? 32 : 16;
                            } else {
                                i17 = i16;
                            }
                            int i30 = i15;
                            i18 = i4 & 4096;
                            if (i18 == 0) {
                                i19 = i30 | 384;
                            } else {
                                int i31 = i30;
                                if ((i3 & 384) == 0) {
                                    i31 |= composerStartRestartGroup.changed(keyboardOptions) ? 256 : 128;
                                }
                                i19 = i31;
                            }
                            i20 = i4 & 8192;
                            if (i20 == 0) {
                                i21 = i19 | 3072;
                            } else {
                                int i32 = i19;
                                if ((i3 & 3072) == 0) {
                                    i21 = i32 | (composerStartRestartGroup.changed(keyboardActionHandler) ? 2048 : 1024);
                                } else {
                                    i21 = i32;
                                }
                            }
                            if ((i3 & 24576) == 0) {
                                if ((i4 & 16384) == 0 && composerStartRestartGroup.changed(shape)) {
                                    i29 = 16384;
                                }
                                i21 |= i29;
                            }
                            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i21 |= ((i4 & 32768) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 131072 : 65536;
                            }
                            i22 = i4 & 65536;
                            if (i22 == 0) {
                                i21 |= 1572864;
                            } else if ((i3 & 1572864) == 0) {
                                i21 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
                            }
                            if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i21 & 599187) != 599186, i5 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                textStyle2 = textStyle;
                                c2 = c;
                                keyboardOptions2 = keyboardOptions;
                                textFieldColors2 = textFieldColors;
                                mutableInteractionSource2 = mutableInteractionSource;
                                function29 = function25;
                                function210 = function26;
                                function211 = function27;
                                modifier3 = modifier2;
                                function212 = function28;
                                z4 = z3;
                                z5 = z2;
                                inputTransformation2 = inputTransformation;
                                i23 = i;
                                keyboardActionHandler2 = keyboardActionHandler;
                                shape2 = shape;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "229@13395L7,240@13998L22,241@14070L25");
                                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    companion = i28 != 0 ? Modifier.INSTANCE : modifier2;
                                    boolean z8 = i6 != 0 ? true : z3;
                                    if ((i4 & 8) != 0) {
                                        ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        i5 &= -7169;
                                        textStyle3 = (TextStyle) objConsume;
                                    } else {
                                        textStyle3 = textStyle;
                                    }
                                    int i33 = i5;
                                    function213 = i7 != 0 ? null : function25;
                                    Function2<? super Composer, ? super Integer, Unit> function215 = i8 != 0 ? null : function26;
                                    Function2<? super Composer, ? super Integer, Unit> function216 = i9 != 0 ? null : function27;
                                    function214 = i10 != 0 ? null : function28;
                                    boolean z9 = i12 != 0 ? false : z2;
                                    InputTransformation inputTransformation4 = i14 != 0 ? null : inputTransformation;
                                    if ((i4 & 1024) != 0) {
                                        i21 &= -15;
                                        iM2578getRevealLastTypedvTwcZD0 = TextObfuscationMode.INSTANCE.m2578getRevealLastTypedvTwcZD0();
                                    } else {
                                        iM2578getRevealLastTypedvTwcZD0 = i;
                                    }
                                    char c4 = i17 != 0 ? (char) 8226 : c;
                                    keyboardOptions3 = i18 != 0 ? SecureTextFieldKeyboardOptions : keyboardOptions;
                                    KeyboardActionHandler keyboardActionHandler4 = i20 != 0 ? null : keyboardActionHandler;
                                    if ((i4 & 16384) != 0) {
                                        i21 &= -57345;
                                        outlinedTextFieldShape = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(composerStartRestartGroup, 6);
                                    } else {
                                        outlinedTextFieldShape = shape;
                                    }
                                    int i34 = i21;
                                    if ((i4 & 32768) != 0) {
                                        textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m3214outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                                        composer3 = composerStartRestartGroup;
                                        i24 = i34 & (-458753);
                                    } else {
                                        composer3 = composerStartRestartGroup;
                                        textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                        i24 = i34;
                                    }
                                    if (i22 != 0) {
                                        textFieldColors3 = textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
                                        i25 = i24;
                                        z6 = z8;
                                        textStyle4 = textStyle3;
                                        i26 = i33;
                                        function26 = function215;
                                        function27 = function216;
                                        z7 = z9;
                                        inputTransformation3 = inputTransformation4;
                                        i27 = iM2578getRevealLastTypedvTwcZD0;
                                        c3 = c4;
                                        keyboardActionHandler3 = keyboardActionHandler4;
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        textFieldColors3 = textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
                                        i25 = i24;
                                        z6 = z8;
                                        textStyle4 = textStyle3;
                                        i26 = i33;
                                        function26 = function215;
                                        function27 = function216;
                                        z7 = z9;
                                        inputTransformation3 = inputTransformation4;
                                        i27 = iM2578getRevealLastTypedvTwcZD0;
                                        c3 = c4;
                                        keyboardActionHandler3 = keyboardActionHandler4;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i4 & 8) != 0) {
                                        i5 &= -7169;
                                    }
                                    if ((i4 & 1024) != 0) {
                                        i21 &= -15;
                                    }
                                    if ((i4 & 16384) != 0) {
                                        i21 &= -57345;
                                    }
                                    if ((i4 & 32768) != 0) {
                                        i21 &= -458753;
                                    }
                                    composer3 = composerStartRestartGroup;
                                    textStyle4 = textStyle;
                                    inputTransformation3 = inputTransformation;
                                    c3 = c;
                                    keyboardOptions3 = keyboardOptions;
                                    outlinedTextFieldShape = shape;
                                    textFieldColors3 = textFieldColors;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    function213 = function25;
                                    i26 = i5;
                                    companion = modifier2;
                                    function214 = function28;
                                    z6 = z3;
                                    i25 = i21;
                                    z7 = z2;
                                    i27 = i;
                                    keyboardActionHandler3 = keyboardActionHandler;
                                }
                                composer3.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1856037588, i26, i25, "androidx.compose.material.OutlinedSecureTextField (SecureTextField.kt:243)");
                                }
                                if (mutableInteractionSource3 == null) {
                                    composer3.startReplaceGroup(194183759);
                                    ComposerKt.sourceInformation(composer3, "245@14239L39");
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1240661997, "CC(remember):SecureTextField.kt#9igjgp");
                                    Object objRememberedValue = composer3.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer3.updateRememberedValue(objRememberedValue);
                                    }
                                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceGroup();
                                } else {
                                    composer3.startReplaceGroup(-1240662648);
                                    composer3.endReplaceGroup();
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                }
                                composer3.startReplaceGroup(-1240656902);
                                ComposerKt.sourceInformation(composer3, "*247@14418L18");
                                long jM8586getColor0d7_KjU = textStyle4.m8586getColor0d7_KjU();
                                if (jM8586getColor0d7_KjU == 16) {
                                    jM8586getColor0d7_KjU = textFieldColors3.textColor(z6, composer3, ((i26 >> 6) & 14) | ((i25 >> 12) & 112)).getValue().m6335unboximpl();
                                }
                                composer3.endReplaceGroup();
                                TextStyle textStyleMerge = textStyle4.merge(new TextStyle(jM8586getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composer3.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Density density = (Density) objConsume2;
                                if (function213 != null) {
                                    composer3.startReplaceGroup(194660973);
                                    ComposerKt.sourceInformation(composer3, "261@14981L2");
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    textStyle5 = textStyle4;
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1240638290, "CC(remember):SecureTextField.kt#9igjgp");
                                    Object objRememberedValue2 = composer3.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material.SecureTextFieldKt$$ExternalSyntheticLambda1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return SecureTextFieldKt.OutlinedSecureTextField_0vce7ms$lambda$2$0((SemanticsPropertyReceiver) obj);
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue2);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    companionM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(SemanticsModifierKt.semantics(companion2, true, (Function1) objRememberedValue2), 0.0f, density.mo1619toDpGaN1DYA(OutlinedTextFieldKt.getOutlinedTextFieldTopPadding()), 0.0f, 0.0f, 13, null);
                                    composer3.endReplaceGroup();
                                } else {
                                    textStyle5 = textStyle4;
                                    composer3.startReplaceGroup(195046334);
                                    composer3.endReplaceGroup();
                                    companionM2041paddingqDBjuR0$default = Modifier.INSTANCE;
                                }
                                Modifier modifier4 = companion;
                                boolean z10 = z7;
                                Function2<? super Composer, ? super Integer, Unit> function217 = function26;
                                Function2<? super Composer, ? super Integer, Unit> function218 = function27;
                                TextFieldColors textFieldColors4 = textFieldColors3;
                                int i35 = i25 << 12;
                                TextStyle textStyle6 = textStyle5;
                                Composer composer4 = composer3;
                                KeyboardOptions keyboardOptions4 = keyboardOptions3;
                                BasicSecureTextFieldKt.m2355BasicSecureTextFieldegD4TGM(textFieldState, SizeKt.m2067defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(companion.then(companionM2041paddingqDBjuR0$default), z7, Strings_androidKt.m3171getString4foXLRw(Strings.INSTANCE.m3165getDefaultErrorMessageUdPEhr4(), composer3, 6)), TextFieldDefaults.INSTANCE.m3211getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m3210getMinHeightD9Ej5fM()), z6, false, inputTransformation3, textStyleMerge, keyboardOptions4, keyboardActionHandler3, null, mutableInteractionSource5, new SolidColor(textFieldColors3.cursorColor(z7, composer3, ((i26 >> 24) & 14) | ((i25 >> 12) & 112)).getValue().m6335unboximpl(), null), new SecureTextFieldKt$OutlinedSecureTextField$3(textFieldState, z6, mutableInteractionSource5, z10, function213, function217, function218, function214, outlinedTextFieldShape, textFieldColors4), i27, c3, composer4, (i26 & Videoio.CAP_OPENNI_ASUS) | ((i26 >> 15) & 57344) | (3670016 & i35) | (i35 & 29360128), (i25 << 6) & 8064, 264);
                                composer2 = composer4;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                keyboardOptions2 = keyboardOptions4;
                                keyboardActionHandler2 = keyboardActionHandler3;
                                i23 = i27;
                                c2 = c3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                                modifier3 = modifier4;
                                textStyle2 = textStyle6;
                                function29 = function213;
                                function211 = function218;
                                z5 = z10;
                                shape2 = outlinedTextFieldShape;
                                textFieldColors2 = textFieldColors4;
                                z4 = z6;
                                inputTransformation2 = inputTransformation3;
                                function210 = function217;
                                function212 = function214;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SecureTextFieldKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SecureTextFieldKt.OutlinedSecureTextField_0vce7ms$lambda$4(textFieldState, modifier3, z4, textStyle2, function29, function210, function211, function212, z5, inputTransformation2, i23, c2, keyboardOptions2, keyboardActionHandler2, shape2, textFieldColors2, mutableInteractionSource2, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i5 |= 805306368;
                        i14 = i13;
                        if ((i3 & 6) != 0) {
                        }
                        i16 = i4 & 2048;
                        if (i16 == 0) {
                        }
                        int i302 = i15;
                        i18 = i4 & 4096;
                        if (i18 == 0) {
                        }
                        i20 = i4 & 8192;
                        if (i20 == 0) {
                        }
                        if ((i3 & 24576) == 0) {
                        }
                        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        }
                        i22 = i4 & 65536;
                        if (i22 == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i21 & 599187) != 599186, i5 & 1)) {
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
                    if ((i3 & 6) != 0) {
                    }
                    i16 = i4 & 2048;
                    if (i16 == 0) {
                    }
                    int i3022 = i15;
                    i18 = i4 & 4096;
                    if (i18 == 0) {
                    }
                    i20 = i4 & 8192;
                    if (i20 == 0) {
                    }
                    if ((i3 & 24576) == 0) {
                    }
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    i22 = i4 & 65536;
                    if (i22 == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i21 & 599187) != 599186, i5 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function25 = function2;
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
                if ((i3 & 6) != 0) {
                }
                i16 = i4 & 2048;
                if (i16 == 0) {
                }
                int i30222 = i15;
                i18 = i4 & 4096;
                if (i18 == 0) {
                }
                i20 = i4 & 8192;
                if (i20 == 0) {
                }
                if ((i3 & 24576) == 0) {
                }
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                i22 = i4 & 65536;
                if (i22 == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i21 & 599187) != 599186, i5 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z;
            if ((i2 & 3072) == 0) {
            }
            i7 = i4 & 16;
            int i292 = 8192;
            if (i7 != 0) {
            }
            function25 = function2;
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
            if ((i3 & 6) != 0) {
            }
            i16 = i4 & 2048;
            if (i16 == 0) {
            }
            int i302222 = i15;
            i18 = i4 & 4096;
            if (i18 == 0) {
            }
            i20 = i4 & 8192;
            if (i20 == 0) {
            }
            if ((i3 & 24576) == 0) {
            }
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i22 = i4 & 65536;
            if (i22 == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i21 & 599187) != 599186, i5 & 1)) {
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
        if ((i2 & 3072) == 0) {
        }
        i7 = i4 & 16;
        int i2922 = 8192;
        if (i7 != 0) {
        }
        function25 = function2;
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
        if ((i3 & 6) != 0) {
        }
        i16 = i4 & 2048;
        if (i16 == 0) {
        }
        int i3022222 = i15;
        i18 = i4 & 4096;
        if (i18 == 0) {
        }
        i20 = i4 & 8192;
        if (i20 == 0) {
        }
        if ((i3 & 24576) == 0) {
        }
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i22 = i4 & 65536;
        if (i22 == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i21 & 599187) != 599186, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutlinedSecureTextField_0vce7ms$lambda$2$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    static final Unit OutlinedSecureTextField_0vce7ms$lambda$4(TextFieldState textFieldState, Modifier modifier, boolean z, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z2, InputTransformation inputTransformation, int i, char c, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Shape shape, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, int i2, int i3, int i4, Composer composer, int i5) {
        m3134OutlinedSecureTextField0vce7ms(textFieldState, modifier, z, textStyle, function2, function22, function23, function24, z2, inputTransformation, i, c, keyboardOptions, keyboardActionHandler, shape, textFieldColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:283:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012a  */
    /* JADX INFO: renamed from: SecureTextField-0vce7ms, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3135SecureTextField0vce7ms(final TextFieldState textFieldState, Modifier modifier, boolean z, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z2, InputTransformation inputTransformation, int i, char c, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Shape shape, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function28;
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
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final TextStyle textStyle2;
        int i23;
        final char c2;
        final KeyboardOptions keyboardOptions2;
        TextFieldColors textFieldColors2;
        final MutableInteractionSource mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final boolean z4;
        final boolean z5;
        final InputTransformation inputTransformation2;
        final KeyboardActionHandler keyboardActionHandler2;
        final Shape shape2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        TextStyle textStyle3;
        Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        boolean z6;
        int iM2578getRevealLastTypedvTwcZD0;
        KeyboardOptions keyboardOptions3;
        KeyboardActionHandler keyboardActionHandler3;
        Shape textFieldShape;
        Composer composer3;
        TextFieldColors textFieldColorsM3216textFieldColorsdx8h9Zs;
        int i24;
        MutableInteractionSource mutableInteractionSource4;
        int i25;
        boolean z7;
        TextStyle textStyle4;
        InputTransformation inputTransformation3;
        char c3;
        MutableInteractionSource mutableInteractionSource5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-308805078);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SecureTextField)N(state,modifier,enabled,textStyle,label,placeholder,leadingIcon,trailingIcon,isError,inputTransformation,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter,keyboardOptions,onKeyboardAction,shape,colors,interactionSource)133@7665L38,140@7981L20,128@7456L1524:SecureTextField.kt#jmzs0o");
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
                if ((i2 & 3072) == 0) {
                    i5 |= ((i4 & 8) == 0 && composerStartRestartGroup.changed(textStyle)) ? 2048 : 1024;
                }
                i7 = i4 & 16;
                int i27 = 8192;
                if (i7 != 0) {
                    i5 |= 24576;
                } else {
                    if ((i2 & 24576) == 0) {
                        function25 = function2;
                        i5 |= composerStartRestartGroup.changedInstance(function25) ? 16384 : 8192;
                    }
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function26 = function22;
                    } else {
                        function26 = function22;
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function26) ? 131072 : 65536;
                        }
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                        function27 = function23;
                    } else {
                        function27 = function23;
                        if ((i2 & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function27) ? 1048576 : 524288;
                        }
                    }
                    i10 = i4 & 128;
                    if (i10 == 0) {
                        i5 |= 12582912;
                        function28 = function24;
                    } else {
                        function28 = function24;
                        if ((i2 & 12582912) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function28) ? 8388608 : 4194304;
                        }
                    }
                    i11 = i4 & 256;
                    if (i11 == 0) {
                        i5 |= 100663296;
                    } else {
                        if ((i2 & 100663296) == 0) {
                            i12 = i11;
                            i5 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
                        }
                        i13 = i4 & 512;
                        if (i13 == 0) {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= composerStartRestartGroup.changed(inputTransformation) ? 536870912 : 268435456;
                            }
                            if ((i3 & 6) != 0) {
                                i15 = i3 | (((i4 & 1024) == 0 && composerStartRestartGroup.changed(i)) ? 4 : 2);
                            } else {
                                i15 = i3;
                            }
                            i16 = i4 & 2048;
                            if (i16 == 0) {
                                i15 |= 48;
                                i17 = i16;
                            } else if ((i3 & 48) == 0) {
                                i17 = i16;
                                i15 |= composerStartRestartGroup.changed(c) ? 32 : 16;
                            } else {
                                i17 = i16;
                            }
                            int i28 = i15;
                            i18 = i4 & 4096;
                            if (i18 == 0) {
                                i19 = i28 | 384;
                            } else {
                                int i29 = i28;
                                if ((i3 & 384) == 0) {
                                    i29 |= composerStartRestartGroup.changed(keyboardOptions) ? 256 : 128;
                                }
                                i19 = i29;
                            }
                            i20 = i4 & 8192;
                            if (i20 == 0) {
                                i21 = i19 | 3072;
                            } else {
                                int i30 = i19;
                                if ((i3 & 3072) == 0) {
                                    i21 = i30 | (composerStartRestartGroup.changed(keyboardActionHandler) ? 2048 : 1024);
                                } else {
                                    i21 = i30;
                                }
                            }
                            if ((i3 & 24576) == 0) {
                                if ((i4 & 16384) == 0 && composerStartRestartGroup.changed(shape)) {
                                    i27 = 16384;
                                }
                                i21 |= i27;
                            }
                            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i21 |= ((i4 & 32768) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 131072 : 65536;
                            }
                            i22 = i4 & 65536;
                            if (i22 == 0) {
                                i21 |= 1572864;
                                mutableInteractionSource2 = mutableInteractionSource;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                                if ((i3 & 1572864) == 0) {
                                    i21 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                                }
                            }
                            if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i21 & 599187) != 599186, i5 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                textStyle2 = textStyle;
                                i23 = i;
                                c2 = c;
                                keyboardOptions2 = keyboardOptions;
                                textFieldColors2 = textFieldColors;
                                mutableInteractionSource3 = mutableInteractionSource;
                                function29 = function25;
                                function210 = function26;
                                function211 = function27;
                                function212 = function28;
                                z4 = z3;
                                z5 = z2;
                                inputTransformation2 = inputTransformation;
                                keyboardActionHandler2 = keyboardActionHandler;
                                shape2 = shape;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "107@6345L7,118@6948L14,119@7012L17");
                                if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i26 != 0 ? Modifier.INSTANCE : modifier2;
                                    boolean z8 = i6 != 0 ? true : z3;
                                    if ((i4 & 8) != 0) {
                                        ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        i5 &= -7169;
                                        textStyle3 = (TextStyle) objConsume;
                                    } else {
                                        textStyle3 = textStyle;
                                    }
                                    int i31 = i5;
                                    function213 = i7 != 0 ? null : function25;
                                    Function2<? super Composer, ? super Integer, Unit> function215 = i8 != 0 ? null : function26;
                                    Function2<? super Composer, ? super Integer, Unit> function216 = i9 != 0 ? null : function27;
                                    function214 = i10 != 0 ? null : function28;
                                    z6 = i12 != 0 ? false : z2;
                                    InputTransformation inputTransformation4 = i14 != 0 ? null : inputTransformation;
                                    if ((i4 & 1024) != 0) {
                                        i21 &= -15;
                                        iM2578getRevealLastTypedvTwcZD0 = TextObfuscationMode.INSTANCE.m2578getRevealLastTypedvTwcZD0();
                                    } else {
                                        iM2578getRevealLastTypedvTwcZD0 = i;
                                    }
                                    char c4 = i17 != 0 ? (char) 8226 : c;
                                    keyboardOptions3 = i18 != 0 ? SecureTextFieldKeyboardOptions : keyboardOptions;
                                    keyboardActionHandler3 = i20 != 0 ? null : keyboardActionHandler;
                                    if ((i4 & 16384) != 0) {
                                        i21 &= -57345;
                                        textFieldShape = TextFieldDefaults.INSTANCE.getTextFieldShape(composerStartRestartGroup, 6);
                                    } else {
                                        textFieldShape = shape;
                                    }
                                    int i32 = i21;
                                    if ((i4 & 32768) != 0) {
                                        textFieldColorsM3216textFieldColorsdx8h9Zs = TextFieldDefaults.INSTANCE.m3216textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 48, 2097151);
                                        composer3 = composerStartRestartGroup;
                                        i24 = i32 & (-458753);
                                    } else {
                                        composer3 = composerStartRestartGroup;
                                        textFieldColorsM3216textFieldColorsdx8h9Zs = textFieldColors;
                                        i24 = i32;
                                    }
                                    if (i22 != 0) {
                                        modifier2 = companion;
                                        i25 = i24;
                                        z7 = z8;
                                        textStyle4 = textStyle3;
                                        i5 = i31;
                                        function26 = function215;
                                        function27 = function216;
                                        inputTransformation3 = inputTransformation4;
                                        i23 = iM2578getRevealLastTypedvTwcZD0;
                                        c3 = c4;
                                        mutableInteractionSource4 = null;
                                    } else {
                                        mutableInteractionSource4 = mutableInteractionSource;
                                        modifier2 = companion;
                                        i25 = i24;
                                        z7 = z8;
                                        textStyle4 = textStyle3;
                                        i5 = i31;
                                        function26 = function215;
                                        function27 = function216;
                                        inputTransformation3 = inputTransformation4;
                                        i23 = iM2578getRevealLastTypedvTwcZD0;
                                        c3 = c4;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i4 & 8) != 0) {
                                        i5 &= -7169;
                                    }
                                    if ((i4 & 1024) != 0) {
                                        i21 &= -15;
                                    }
                                    if ((i4 & 16384) != 0) {
                                        i21 &= -57345;
                                    }
                                    if ((i4 & 32768) != 0) {
                                        i21 &= -458753;
                                    }
                                    textStyle4 = textStyle;
                                    z6 = z2;
                                    inputTransformation3 = inputTransformation;
                                    c3 = c;
                                    keyboardOptions3 = keyboardOptions;
                                    keyboardActionHandler3 = keyboardActionHandler;
                                    textFieldShape = shape;
                                    composer3 = composerStartRestartGroup;
                                    mutableInteractionSource4 = mutableInteractionSource2;
                                    function213 = function25;
                                    function214 = function28;
                                    z7 = z3;
                                    i25 = i21;
                                    i23 = i;
                                    textFieldColorsM3216textFieldColorsdx8h9Zs = textFieldColors;
                                }
                                composer3.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-308805078, i5, i25, "androidx.compose.material.SecureTextField (SecureTextField.kt:121)");
                                }
                                if (mutableInteractionSource4 == null) {
                                    composer3.startReplaceGroup(208844689);
                                    ComposerKt.sourceInformation(composer3, "123@7173L39");
                                    ComposerKt.sourceInformationMarkerStart(composer3, -408905071, "CC(remember):SecureTextField.kt#9igjgp");
                                    Object objRememberedValue = composer3.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer3.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceGroup();
                                    mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    composer3.startReplaceGroup(-408905722);
                                    composer3.endReplaceGroup();
                                    mutableInteractionSource5 = mutableInteractionSource4;
                                }
                                composer3.startReplaceGroup(-408899976);
                                ComposerKt.sourceInformation(composer3, "*125@7352L18");
                                long jM8586getColor0d7_KjU = textStyle4.m8586getColor0d7_KjU();
                                if (jM8586getColor0d7_KjU == 16) {
                                    jM8586getColor0d7_KjU = textFieldColorsM3216textFieldColorsdx8h9Zs.textColor(z7, composer3, ((i5 >> 6) & 14) | ((i25 >> 12) & 112)).getValue().m6335unboximpl();
                                }
                                composer3.endReplaceGroup();
                                TextStyle textStyleMerge = textStyle4.merge(new TextStyle(jM8586getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                TextFieldColors textFieldColors3 = textFieldColorsM3216textFieldColorsdx8h9Zs;
                                boolean z9 = z7;
                                Modifier modifier3 = modifier2;
                                boolean z10 = z6;
                                TextStyle textStyle5 = textStyle4;
                                Function2<? super Composer, ? super Integer, Unit> function217 = function26;
                                Function2<? super Composer, ? super Integer, Unit> function218 = function27;
                                textFieldColors2 = textFieldColors3;
                                int i33 = i25 << 12;
                                Composer composer4 = composer3;
                                KeyboardOptions keyboardOptions4 = keyboardOptions3;
                                KeyboardActionHandler keyboardActionHandler4 = keyboardActionHandler3;
                                BasicSecureTextFieldKt.m2355BasicSecureTextFieldegD4TGM(textFieldState, SizeKt.m2067defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m3204indicatorLinegv0btCI$default(TextFieldDefaults.INSTANCE, modifier3, z9, z10, mutableInteractionSource5, textFieldColors3, 0.0f, 0.0f, 48, null), z10, Strings_androidKt.m3171getString4foXLRw(Strings.INSTANCE.m3165getDefaultErrorMessageUdPEhr4(), composer3, 6)), TextFieldDefaults.INSTANCE.m3211getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m3210getMinHeightD9Ej5fM()), z9, false, inputTransformation3, textStyleMerge, keyboardOptions4, keyboardActionHandler4, null, mutableInteractionSource5, new SolidColor(textFieldColors3.cursorColor(z10, composer3, ((i5 >> 24) & 14) | ((i25 >> 12) & 112)).getValue().m6335unboximpl(), null), new SecureTextFieldKt$SecureTextField$1(textFieldState, z9, mutableInteractionSource5, z10, function213, function217, function218, function214, textFieldShape, textFieldColors3), i23, c3, composer4, (i5 & Videoio.CAP_OPENNI_ASUS) | ((i5 >> 15) & 57344) | (3670016 & i33) | (i33 & 29360128), (i25 << 6) & 8064, 264);
                                composer2 = composer4;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                textStyle2 = textStyle5;
                                keyboardOptions2 = keyboardOptions4;
                                keyboardActionHandler2 = keyboardActionHandler4;
                                z4 = z9;
                                c2 = c3;
                                mutableInteractionSource3 = mutableInteractionSource4;
                                modifier2 = modifier3;
                                function29 = function213;
                                function210 = function217;
                                function211 = function218;
                                z5 = z10;
                                shape2 = textFieldShape;
                                inputTransformation2 = inputTransformation3;
                                function212 = function214;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                final Modifier modifier4 = modifier2;
                                final int i34 = i23;
                                final TextFieldColors textFieldColors4 = textFieldColors2;
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SecureTextFieldKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SecureTextFieldKt.SecureTextField_0vce7ms$lambda$2(textFieldState, modifier4, z4, textStyle2, function29, function210, function211, function212, z5, inputTransformation2, i34, c2, keyboardOptions2, keyboardActionHandler2, shape2, textFieldColors4, mutableInteractionSource3, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i5 |= 805306368;
                        i14 = i13;
                        if ((i3 & 6) != 0) {
                        }
                        i16 = i4 & 2048;
                        if (i16 == 0) {
                        }
                        int i282 = i15;
                        i18 = i4 & 4096;
                        if (i18 == 0) {
                        }
                        i20 = i4 & 8192;
                        if (i20 == 0) {
                        }
                        if ((i3 & 24576) == 0) {
                        }
                        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        }
                        i22 = i4 & 65536;
                        if (i22 == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i21 & 599187) != 599186, i5 & 1)) {
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
                    if ((i3 & 6) != 0) {
                    }
                    i16 = i4 & 2048;
                    if (i16 == 0) {
                    }
                    int i2822 = i15;
                    i18 = i4 & 4096;
                    if (i18 == 0) {
                    }
                    i20 = i4 & 8192;
                    if (i20 == 0) {
                    }
                    if ((i3 & 24576) == 0) {
                    }
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    i22 = i4 & 65536;
                    if (i22 == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i21 & 599187) != 599186, i5 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function25 = function2;
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
                if ((i3 & 6) != 0) {
                }
                i16 = i4 & 2048;
                if (i16 == 0) {
                }
                int i28222 = i15;
                i18 = i4 & 4096;
                if (i18 == 0) {
                }
                i20 = i4 & 8192;
                if (i20 == 0) {
                }
                if ((i3 & 24576) == 0) {
                }
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                i22 = i4 & 65536;
                if (i22 == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i21 & 599187) != 599186, i5 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z;
            if ((i2 & 3072) == 0) {
            }
            i7 = i4 & 16;
            int i272 = 8192;
            if (i7 != 0) {
            }
            function25 = function2;
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
            if ((i3 & 6) != 0) {
            }
            i16 = i4 & 2048;
            if (i16 == 0) {
            }
            int i282222 = i15;
            i18 = i4 & 4096;
            if (i18 == 0) {
            }
            i20 = i4 & 8192;
            if (i20 == 0) {
            }
            if ((i3 & 24576) == 0) {
            }
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i22 = i4 & 65536;
            if (i22 == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i21 & 599187) != 599186, i5 & 1)) {
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
        if ((i2 & 3072) == 0) {
        }
        i7 = i4 & 16;
        int i2722 = 8192;
        if (i7 != 0) {
        }
        function25 = function2;
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
        if ((i3 & 6) != 0) {
        }
        i16 = i4 & 2048;
        if (i16 == 0) {
        }
        int i2822222 = i15;
        i18 = i4 & 4096;
        if (i18 == 0) {
        }
        i20 = i4 & 8192;
        if (i20 == 0) {
        }
        if ((i3 & 24576) == 0) {
        }
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i22 = i4 & 65536;
        if (i22 == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i21 & 599187) != 599186, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    static final Unit SecureTextField_0vce7ms$lambda$2(TextFieldState textFieldState, Modifier modifier, boolean z, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z2, InputTransformation inputTransformation, int i, char c, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Shape shape, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, int i2, int i3, int i4, Composer composer, int i5) {
        m3135SecureTextField0vce7ms(textFieldState, modifier, z, textStyle, function2, function22, function23, function24, z2, inputTransformation, i, c, keyboardOptions, keyboardActionHandler, shape, textFieldColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }
}
