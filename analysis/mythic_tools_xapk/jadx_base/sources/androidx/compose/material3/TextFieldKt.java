package androidx.compose.material3;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.TextFieldLabelPosition;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TextField.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a£\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2 \b\u0002\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#28\b\u0002\u0010$\u001a2\u0012\u0004\u0012\u00020&\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010'0\u0013¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0001\u0018\u00010%¢\u0006\u0002\b\u00112\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u000104H\u0007¢\u0006\u0002\u00105\u001aØ\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020\u00072\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u0010A\u001aØ\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u00106\u001a\u00020B2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020\u00072\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u0010C\u001aô\u0001\u0010D\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010E\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0019\u0010\u0012\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u00102\u0013\u0010F\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010G\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0006\u0010=\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010H\u001a\u00020I2\u0011\u0010J\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010K\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0006\u0010L\u001a\u000202H\u0001¢\u0006\u0002\u0010M\"\u0016\u0010N\u001a\u00020OX\u0080\u0004¢\u0006\n\n\u0002\u0010R\u001a\u0004\bP\u0010Q¨\u0006S"}, d2 = {"TextField", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", Constants.ScionAnalytics.PARAM_LABEL, "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "placeholder", "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;IIII)V", "value", "", "onValueChange", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "TextFieldLayout", "textField", "leading", "trailing", "labelProgress", "Landroidx/compose/material3/internal/FloatProducer;", "container", "supporting", "paddingValues", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/TextFieldLabelPosition;Landroidx/compose/material3/internal/FloatProducer;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "TextFieldWithLabelVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTextFieldWithLabelVerticalPadding", "()F", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldKt {
    private static final float TextFieldWithLabelVerticalPadding = Dp.m9114constructorimpl(8.0f);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0673  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:398:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextField(final TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, TextFieldLabelPosition textFieldLabelPosition, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, boolean z3, InputTransformation inputTransformation, OutputTransformation outputTransformation, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, TextFieldLineLimits textFieldLineLimits, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function27, ScrollState scrollState, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3, final int i4) {
        final TextFieldState textFieldState2;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z4;
        int i7;
        boolean z5;
        TextStyle textStyle2;
        TextFieldLabelPosition attached;
        int i8;
        Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function32;
        int i9;
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
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final InputTransformation inputTransformation2;
        final OutputTransformation outputTransformation2;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActionHandler keyboardActionHandler2;
        final TextFieldLineLimits textFieldLineLimits2;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function211;
        final ScrollState scrollState2;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final PaddingValues paddingValues2;
        final MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final boolean z6;
        final boolean z7;
        final TextStyle textStyle3;
        final TextFieldLabelPosition textFieldLabelPosition2;
        final Modifier modifier3;
        final Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function33;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final boolean z8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        TextFieldLineLimits textFieldLineLimits3;
        final TextFieldColors textFieldColors3;
        TextStyle textStyle4;
        final Modifier modifier4;
        final Shape shape3;
        final PaddingValues paddingValues3;
        final InputTransformation inputTransformation3;
        final boolean z9;
        final TextFieldLabelPosition textFieldLabelPosition3;
        final boolean z10;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActionHandler keyboardActionHandler3;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function215;
        final ScrollState scrollState3;
        int i33;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        final Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function34;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        final OutputTransformation outputTransformation3;
        final TextFieldLineLimits textFieldLineLimits4;
        int i34;
        final Function2<? super Composer, ? super Integer, Unit> function220;
        final Function2<? super Composer, ? super Integer, Unit> function221;
        MutableInteractionSource mutableInteractionSource3;
        final boolean z11;
        final MutableInteractionSource mutableInteractionSource4;
        int i35;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1717599650);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextField)N(state,modifier,enabled,readOnly,textStyle,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,inputTransformation,outputTransformation,keyboardOptions,onKeyboardAction,lineLimits,onTextLayout,scrollState,shape,colors,contentPadding,interactionSource)298@16411L2145,298@16324L2232:TextField.kt#uh7d8r");
        if ((i4 & 1) != 0) {
            i5 = i | 6;
            textFieldState2 = textFieldState;
        } else {
            textFieldState2 = textFieldState;
            if ((i & 6) == 0) {
                i5 = (composerStartRestartGroup.changed(textFieldState2) ? 4 : 2) | i;
            } else {
                i5 = i;
            }
        }
        int i36 = i4 & 2;
        if (i36 != 0) {
            i5 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else {
                if ((i & 384) == 0) {
                    z4 = z;
                    i5 |= composerStartRestartGroup.changed(z4) ? 256 : 128;
                }
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        z5 = z2;
                        i5 |= composerStartRestartGroup.changed(z5) ? 2048 : 1024;
                    }
                    if ((i & 24576) != 0) {
                        if ((i4 & 16) == 0) {
                            textStyle2 = textStyle;
                            if (composerStartRestartGroup.changed(textStyle2)) {
                                i35 = 16384;
                            }
                            i5 |= i35;
                        } else {
                            textStyle2 = textStyle;
                        }
                        i35 = 8192;
                        i5 |= i35;
                    } else {
                        textStyle2 = textStyle;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        attached = textFieldLabelPosition;
                        i5 |= ((i4 & 32) == 0 && composerStartRestartGroup.changed(attached)) ? 131072 : 65536;
                    } else {
                        attached = textFieldLabelPosition;
                    }
                    i8 = i4 & 64;
                    if (i8 == 0) {
                        i5 |= 1572864;
                        function32 = function3;
                    } else {
                        function32 = function3;
                        if ((i & 1572864) == 0) {
                            i5 |= composerStartRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                        }
                    }
                    i9 = i4 & 128;
                    if (i9 == 0) {
                        i5 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i5 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    i10 = i4 & 256;
                    if (i10 == 0) {
                        i5 |= 100663296;
                    } else {
                        if ((i & 100663296) == 0) {
                            i11 = i10;
                            i5 |= composerStartRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
                        }
                        i12 = i4 & 512;
                        if (i12 != 0) {
                            i5 |= 805306368;
                        } else {
                            if ((i & 805306368) == 0) {
                                i13 = i12;
                                i5 |= composerStartRestartGroup.changedInstance(function23) ? 536870912 : 268435456;
                            }
                            i14 = i4 & 1024;
                            if (i14 == 0) {
                                i16 = i2 | 6;
                                i15 = i14;
                            } else if ((i2 & 6) == 0) {
                                i15 = i14;
                                i16 = i2 | (composerStartRestartGroup.changedInstance(function24) ? 4 : 2);
                            } else {
                                i15 = i14;
                                i16 = i2;
                            }
                            i17 = i4 & 2048;
                            if (i17 == 0) {
                                i16 |= 48;
                                i18 = i17;
                            } else if ((i2 & 48) == 0) {
                                i18 = i17;
                                i16 |= composerStartRestartGroup.changedInstance(function25) ? 32 : 16;
                            } else {
                                i18 = i17;
                            }
                            int i37 = i16;
                            i19 = i5;
                            i20 = i4 & 4096;
                            if (i20 == 0) {
                                i21 = i37 | 384;
                            } else {
                                int i38 = i37;
                                if ((i2 & 384) == 0) {
                                    i38 |= composerStartRestartGroup.changedInstance(function26) ? 256 : 128;
                                }
                                i21 = i38;
                            }
                            i22 = i4 & 8192;
                            if (i22 == 0) {
                                i23 = i21 | 3072;
                            } else {
                                int i39 = i21;
                                if ((i2 & 3072) == 0) {
                                    i39 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                                }
                                i23 = i39;
                            }
                            i24 = i4 & 16384;
                            if (i24 != 0) {
                                i25 = i23;
                                if ((i2 & 24576) == 0) {
                                    i25 |= composerStartRestartGroup.changed(inputTransformation) ? 16384 : 8192;
                                }
                                i26 = i4 & 32768;
                                if (i26 != 0) {
                                    i25 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i25 |= composerStartRestartGroup.changed(outputTransformation) ? 131072 : 65536;
                                }
                                i27 = i4 & 65536;
                                if (i27 != 0) {
                                    i25 |= 1572864;
                                } else if ((i2 & 1572864) == 0) {
                                    i25 |= composerStartRestartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                                }
                                i28 = i4 & 131072;
                                if (i28 != 0) {
                                    i25 |= 12582912;
                                } else if ((i2 & 12582912) == 0) {
                                    i25 |= composerStartRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                                }
                                if ((i2 & 100663296) == 0) {
                                    i25 |= ((i4 & 262144) == 0 && composerStartRestartGroup.changed(textFieldLineLimits)) ? 67108864 : 33554432;
                                }
                                i29 = i4 & 524288;
                                if (i29 != 0) {
                                    i25 |= 805306368;
                                } else if ((i2 & 805306368) == 0) {
                                    i25 |= composerStartRestartGroup.changedInstance(function27) ? 536870912 : 268435456;
                                }
                                if ((i3 & 6) == 0) {
                                    i30 = i3 | (((i4 & 1048576) == 0 && composerStartRestartGroup.changed(scrollState)) ? 4 : 2);
                                } else {
                                    i30 = i3;
                                }
                                if ((i3 & 48) == 0) {
                                    i30 |= ((i4 & 2097152) == 0 && composerStartRestartGroup.changed(shape)) ? 32 : 16;
                                }
                                if ((i3 & 384) == 0) {
                                    i30 |= ((i4 & 4194304) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 256 : 128;
                                }
                                if ((i3 & 3072) == 0) {
                                    i30 |= ((8388608 & i4) == 0 && composerStartRestartGroup.changed(paddingValues)) ? 2048 : 1024;
                                }
                                int i40 = i30;
                                i31 = i4 & 16777216;
                                if (i31 != 0) {
                                    i32 = i40 | 24576;
                                } else {
                                    int i41 = i40;
                                    if ((i3 & 24576) == 0) {
                                        i41 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 16384 : 8192;
                                    }
                                    i32 = i41;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (i25 & 306783379) == 306783378 && (i32 & 9363) == 9362) ? false : true, i19 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "261@14511L7,277@15401L21,278@15461L5,279@15516L8");
                                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i36 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i6 != 0) {
                                            z4 = true;
                                        }
                                        if (i7 != 0) {
                                            z5 = false;
                                        }
                                        if ((i4 & 16) != 0) {
                                            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            textStyle2 = (TextStyle) objConsume;
                                            i19 &= -57345;
                                        }
                                        if ((i4 & 32) != 0) {
                                            attached = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
                                            i19 &= -458753;
                                        }
                                        if (i8 != 0) {
                                            function32 = null;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function222 = i9 != 0 ? null : function2;
                                        Function2<? super Composer, ? super Integer, Unit> function223 = i11 != 0 ? null : function22;
                                        Function2<? super Composer, ? super Integer, Unit> function224 = i13 != 0 ? null : function23;
                                        Function2<? super Composer, ? super Integer, Unit> function225 = i15 != 0 ? null : function24;
                                        Function2<? super Composer, ? super Integer, Unit> function226 = i18 != 0 ? null : function25;
                                        Function2<? super Composer, ? super Integer, Unit> function227 = i20 != 0 ? null : function26;
                                        boolean z12 = i22 != 0 ? false : z3;
                                        InputTransformation inputTransformation4 = i24 != 0 ? null : inputTransformation;
                                        OutputTransformation outputTransformation4 = i26 != 0 ? null : outputTransformation;
                                        KeyboardOptions keyboardOptions4 = i27 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        KeyboardActionHandler keyboardActionHandler4 = i28 != 0 ? null : keyboardActionHandler;
                                        if ((i4 & 262144) != 0) {
                                            textFieldLineLimits3 = TextFieldLineLimits.INSTANCE.getDefault();
                                            i25 &= -234881025;
                                        } else {
                                            textFieldLineLimits3 = textFieldLineLimits;
                                        }
                                        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function228 = i29 != 0 ? null : function27;
                                        ScrollState scrollStateRememberScrollState = (i4 & 1048576) != 0 ? ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1) : scrollState;
                                        Shape shape4 = (i4 & 2097152) != 0 ? TextFieldDefaults.INSTANCE.getShape(composerStartRestartGroup, 6) : shape;
                                        TextFieldColors textFieldColorsColors = (i4 & 4194304) != 0 ? TextFieldDefaults.INSTANCE.colors(composerStartRestartGroup, 6) : textFieldColors;
                                        PaddingValues paddingValuesM4258contentPaddingWithoutLabela9UjIt4$default = (i4 & 8388608) != 0 ? (function32 == null || (attached instanceof TextFieldLabelPosition.Above)) ? TextFieldDefaults.m4258contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null) : TextFieldDefaults.m4257contentPaddingWithLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null) : paddingValues;
                                        if (i31 != 0) {
                                            Modifier modifier5 = modifier2;
                                            textFieldColors3 = textFieldColorsColors;
                                            textStyle4 = textStyle2;
                                            modifier4 = modifier5;
                                            shape3 = shape4;
                                            paddingValues3 = paddingValuesM4258contentPaddingWithoutLabela9UjIt4$default;
                                            inputTransformation3 = inputTransformation4;
                                            z9 = z5;
                                            textFieldLabelPosition3 = attached;
                                            z10 = z12;
                                            keyboardOptions3 = keyboardOptions4;
                                            keyboardActionHandler3 = keyboardActionHandler4;
                                            function215 = function228;
                                            scrollState3 = scrollStateRememberScrollState;
                                            i33 = i19;
                                            function216 = function223;
                                            function217 = function224;
                                            function34 = function32;
                                            function218 = function226;
                                            function219 = function227;
                                            outputTransformation3 = outputTransformation4;
                                            textFieldLineLimits4 = textFieldLineLimits3;
                                            i34 = i25;
                                            function220 = function222;
                                            function221 = function225;
                                            mutableInteractionSource3 = null;
                                        } else {
                                            Modifier modifier6 = modifier2;
                                            textFieldColors3 = textFieldColorsColors;
                                            textStyle4 = textStyle2;
                                            modifier4 = modifier6;
                                            shape3 = shape4;
                                            paddingValues3 = paddingValuesM4258contentPaddingWithoutLabela9UjIt4$default;
                                            inputTransformation3 = inputTransformation4;
                                            z9 = z5;
                                            textFieldLabelPosition3 = attached;
                                            z10 = z12;
                                            keyboardOptions3 = keyboardOptions4;
                                            keyboardActionHandler3 = keyboardActionHandler4;
                                            function215 = function228;
                                            scrollState3 = scrollStateRememberScrollState;
                                            i33 = i19;
                                            function216 = function223;
                                            function217 = function224;
                                            function34 = function32;
                                            function218 = function226;
                                            function219 = function227;
                                            outputTransformation3 = outputTransformation4;
                                            textFieldLineLimits4 = textFieldLineLimits3;
                                            i34 = i25;
                                            function220 = function222;
                                            function221 = function225;
                                            mutableInteractionSource3 = mutableInteractionSource;
                                        }
                                        z11 = z4;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        i33 = (i4 & 16) != 0 ? i19 & (-57345) : i19;
                                        if ((i4 & 32) != 0) {
                                            i33 &= -458753;
                                        }
                                        if ((i4 & 262144) != 0) {
                                            i25 &= -234881025;
                                        }
                                        function220 = function2;
                                        function216 = function22;
                                        function217 = function23;
                                        function221 = function24;
                                        function218 = function25;
                                        function219 = function26;
                                        inputTransformation3 = inputTransformation;
                                        outputTransformation3 = outputTransformation;
                                        keyboardOptions3 = keyboardOptions;
                                        keyboardActionHandler3 = keyboardActionHandler;
                                        function215 = function27;
                                        scrollState3 = scrollState;
                                        shape3 = shape;
                                        paddingValues3 = paddingValues;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        z11 = z4;
                                        z9 = z5;
                                        textStyle4 = textStyle2;
                                        textFieldLabelPosition3 = attached;
                                        modifier4 = modifier2;
                                        function34 = function32;
                                        i34 = i25;
                                        z10 = z3;
                                        textFieldLineLimits4 = textFieldLineLimits;
                                        textFieldColors3 = textFieldColors;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1717599650, i33, i34, "androidx.compose.material3.TextField (TextField.kt:287)");
                                    }
                                    if (mutableInteractionSource3 == null) {
                                        composerStartRestartGroup.startReplaceGroup(1230824445);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "289@15925L39");
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345769307, "CC(remember):TextField.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-1345769958);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    composerStartRestartGroup.startReplaceGroup(-1345763848);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*293@16149L25");
                                    long jM8586getColor0d7_KjU = textStyle4.m8586getColor0d7_KjU();
                                    if (jM8586getColor0d7_KjU == 16) {
                                        jM8586getColor0d7_KjU = textFieldColors3.m4255textColorXeAY9LY$material3(z11, z10, FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource4, composerStartRestartGroup, 0).getValue().booleanValue());
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    final TextStyle textStyleMerge = textStyle4.merge(new TextStyle(jM8586getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                    CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors3.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(484558238, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i42) {
                                            ComposerKt.sourceInformation(composer3, "C303@16564L38,338@18169L351,321@17398L1141,299@16421L2129:TextField.kt#uh7d8r");
                                            if (!composer3.shouldExecute((i42 & 3) != 2, i42 & 1)) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(484558238, i42, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:299)");
                                            }
                                            Modifier modifier7 = modifier4;
                                            boolean z13 = z10;
                                            Strings.Companion companion = Strings.INSTANCE;
                                            Modifier modifierM2067defaultMinSizeVpY3zN4 = SizeKt.m2067defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier7, z13, Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(androidx.compose.ui.R.string.default_error_message), composer3, 0)), TextFieldDefaults.INSTANCE.m4274getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m4273getMinHeightD9Ej5fM());
                                            SolidColor solidColor = new SolidColor(textFieldColors3.m4205cursorColorvNxB06k$material3(z10), null);
                                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                            TextFieldState textFieldState3 = textFieldState2;
                                            boolean z14 = z11;
                                            TextFieldLineLimits textFieldLineLimits5 = textFieldLineLimits4;
                                            OutputTransformation outputTransformation5 = outputTransformation3;
                                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                            TextFieldLabelPosition textFieldLabelPosition4 = textFieldLabelPosition3;
                                            Function3<TextFieldLabelScope, Composer, Integer, Unit> function35 = function34;
                                            Function2<Composer, Integer, Unit> function229 = function220;
                                            Function2<Composer, Integer, Unit> function230 = function216;
                                            Function2<Composer, Integer, Unit> function231 = function217;
                                            Function2<Composer, Integer, Unit> function232 = function221;
                                            Function2<Composer, Integer, Unit> function233 = function218;
                                            Function2<Composer, Integer, Unit> function234 = function219;
                                            boolean z15 = z10;
                                            TextFieldColors textFieldColors4 = textFieldColors3;
                                            PaddingValues paddingValues4 = paddingValues3;
                                            final boolean z16 = z11;
                                            final boolean z17 = z10;
                                            final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                            final TextFieldColors textFieldColors5 = textFieldColors3;
                                            final Shape shape5 = shape3;
                                            BasicTextFieldKt.BasicTextField(textFieldState2, modifierM2067defaultMinSizeVpY3zN4, z11, z9, inputTransformation3, textStyleMerge, keyboardOptions3, keyboardActionHandler3, textFieldLineLimits4, function215, mutableInteractionSource4, solidColor, outputTransformation3, textFieldDefaults.decorator(textFieldState3, z14, textFieldLineLimits5, outputTransformation5, mutableInteractionSource5, textFieldLabelPosition4, function35, function229, function230, function231, function232, function233, function234, z15, textFieldColors4, paddingValues4, ComposableLambdaKt.rememberComposableLambda(-2009308227, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.1.1
                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                    invoke(composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i43) {
                                                    ComposerKt.sourceInformation(composer4, "C339@18213L285:TextField.kt#uh7d8r");
                                                    if (!composer4.shouldExecute((i43 & 3) != 2, i43 & 1)) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-2009308227, i43, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:339)");
                                                    }
                                                    TextFieldDefaults.INSTANCE.m4267Container4EFweAY(z16, z17, mutableInteractionSource6, null, textFieldColors5, shape5, 0.0f, 0.0f, composer4, 100663296, 200);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composer3, 54), composer3, 0, 14155776, 0), scrollState3, composer3, 0, 0, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    textStyle3 = textStyle4;
                                    composer2 = composerStartRestartGroup;
                                    modifier3 = modifier4;
                                    z6 = z11;
                                    outputTransformation2 = outputTransformation3;
                                    textFieldLabelPosition2 = textFieldLabelPosition3;
                                    function33 = function34;
                                    function28 = function220;
                                    function212 = function216;
                                    function29 = function218;
                                    function210 = function219;
                                    paddingValues2 = paddingValues3;
                                    z7 = z9;
                                    inputTransformation2 = inputTransformation3;
                                    keyboardOptions2 = keyboardOptions3;
                                    keyboardActionHandler2 = keyboardActionHandler3;
                                    function211 = function215;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    textFieldColors2 = textFieldColors3;
                                    textFieldLineLimits2 = textFieldLineLimits4;
                                    function214 = function221;
                                    shape2 = shape3;
                                    z8 = z10;
                                    function213 = function217;
                                    scrollState2 = scrollState3;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    function28 = function2;
                                    function29 = function25;
                                    function210 = function26;
                                    inputTransformation2 = inputTransformation;
                                    outputTransformation2 = outputTransformation;
                                    keyboardOptions2 = keyboardOptions;
                                    keyboardActionHandler2 = keyboardActionHandler;
                                    textFieldLineLimits2 = textFieldLineLimits;
                                    function211 = function27;
                                    scrollState2 = scrollState;
                                    shape2 = shape;
                                    textFieldColors2 = textFieldColors;
                                    paddingValues2 = paddingValues;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    composer2 = composerStartRestartGroup;
                                    z6 = z4;
                                    z7 = z5;
                                    textStyle3 = textStyle2;
                                    textFieldLabelPosition2 = attached;
                                    modifier3 = modifier2;
                                    function33 = function32;
                                    function212 = function22;
                                    function213 = function23;
                                    function214 = function24;
                                    z8 = z3;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return TextFieldKt.TextField$lambda$2(textFieldState, modifier3, z6, z7, textStyle3, textFieldLabelPosition2, function33, function28, function212, function213, function214, function29, function210, z8, inputTransformation2, outputTransformation2, keyboardOptions2, keyboardActionHandler2, textFieldLineLimits2, function211, scrollState2, shape2, textFieldColors2, paddingValues2, mutableInteractionSource2, i, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i25 = i23 | 24576;
                            i26 = i4 & 32768;
                            if (i26 != 0) {
                            }
                            i27 = i4 & 65536;
                            if (i27 != 0) {
                            }
                            i28 = i4 & 131072;
                            if (i28 != 0) {
                            }
                            if ((i2 & 100663296) == 0) {
                            }
                            i29 = i4 & 524288;
                            if (i29 != 0) {
                            }
                            if ((i3 & 6) == 0) {
                            }
                            if ((i3 & 48) == 0) {
                            }
                            if ((i3 & 384) == 0) {
                            }
                            if ((i3 & 3072) == 0) {
                            }
                            int i402 = i30;
                            i31 = i4 & 16777216;
                            if (i31 != 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (i25 & 306783379) == 306783378 && (i32 & 9363) == 9362) ? false : true, i19 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i13 = i12;
                        i14 = i4 & 1024;
                        if (i14 == 0) {
                        }
                        i17 = i4 & 2048;
                        if (i17 == 0) {
                        }
                        int i372 = i16;
                        i19 = i5;
                        i20 = i4 & 4096;
                        if (i20 == 0) {
                        }
                        i22 = i4 & 8192;
                        if (i22 == 0) {
                        }
                        i24 = i4 & 16384;
                        if (i24 != 0) {
                        }
                        i26 = i4 & 32768;
                        if (i26 != 0) {
                        }
                        i27 = i4 & 65536;
                        if (i27 != 0) {
                        }
                        i28 = i4 & 131072;
                        if (i28 != 0) {
                        }
                        if ((i2 & 100663296) == 0) {
                        }
                        i29 = i4 & 524288;
                        if (i29 != 0) {
                        }
                        if ((i3 & 6) == 0) {
                        }
                        if ((i3 & 48) == 0) {
                        }
                        if ((i3 & 384) == 0) {
                        }
                        if ((i3 & 3072) == 0) {
                        }
                        int i4022 = i30;
                        i31 = i4 & 16777216;
                        if (i31 != 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (i25 & 306783379) == 306783378 && (i32 & 9363) == 9362) ? false : true, i19 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i11 = i10;
                    i12 = i4 & 512;
                    if (i12 != 0) {
                    }
                    i13 = i12;
                    i14 = i4 & 1024;
                    if (i14 == 0) {
                    }
                    i17 = i4 & 2048;
                    if (i17 == 0) {
                    }
                    int i3722 = i16;
                    i19 = i5;
                    i20 = i4 & 4096;
                    if (i20 == 0) {
                    }
                    i22 = i4 & 8192;
                    if (i22 == 0) {
                    }
                    i24 = i4 & 16384;
                    if (i24 != 0) {
                    }
                    i26 = i4 & 32768;
                    if (i26 != 0) {
                    }
                    i27 = i4 & 65536;
                    if (i27 != 0) {
                    }
                    i28 = i4 & 131072;
                    if (i28 != 0) {
                    }
                    if ((i2 & 100663296) == 0) {
                    }
                    i29 = i4 & 524288;
                    if (i29 != 0) {
                    }
                    if ((i3 & 6) == 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    if ((i3 & 384) == 0) {
                    }
                    if ((i3 & 3072) == 0) {
                    }
                    int i40222 = i30;
                    i31 = i4 & 16777216;
                    if (i31 != 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (i25 & 306783379) == 306783378 && (i32 & 9363) == 9362) ? false : true, i19 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z5 = z2;
                if ((i & 24576) != 0) {
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                i8 = i4 & 64;
                if (i8 == 0) {
                }
                i9 = i4 & 128;
                if (i9 == 0) {
                }
                i10 = i4 & 256;
                if (i10 == 0) {
                }
                i11 = i10;
                i12 = i4 & 512;
                if (i12 != 0) {
                }
                i13 = i12;
                i14 = i4 & 1024;
                if (i14 == 0) {
                }
                i17 = i4 & 2048;
                if (i17 == 0) {
                }
                int i37222 = i16;
                i19 = i5;
                i20 = i4 & 4096;
                if (i20 == 0) {
                }
                i22 = i4 & 8192;
                if (i22 == 0) {
                }
                i24 = i4 & 16384;
                if (i24 != 0) {
                }
                i26 = i4 & 32768;
                if (i26 != 0) {
                }
                i27 = i4 & 65536;
                if (i27 != 0) {
                }
                i28 = i4 & 131072;
                if (i28 != 0) {
                }
                if ((i2 & 100663296) == 0) {
                }
                i29 = i4 & 524288;
                if (i29 != 0) {
                }
                if ((i3 & 6) == 0) {
                }
                if ((i3 & 48) == 0) {
                }
                if ((i3 & 384) == 0) {
                }
                if ((i3 & 3072) == 0) {
                }
                int i402222 = i30;
                i31 = i4 & 16777216;
                if (i31 != 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (i25 & 306783379) == 306783378 && (i32 & 9363) == 9362) ? false : true, i19 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z4 = z;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            z5 = z2;
            if ((i & 24576) != 0) {
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            i8 = i4 & 64;
            if (i8 == 0) {
            }
            i9 = i4 & 128;
            if (i9 == 0) {
            }
            i10 = i4 & 256;
            if (i10 == 0) {
            }
            i11 = i10;
            i12 = i4 & 512;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i4 & 1024;
            if (i14 == 0) {
            }
            i17 = i4 & 2048;
            if (i17 == 0) {
            }
            int i372222 = i16;
            i19 = i5;
            i20 = i4 & 4096;
            if (i20 == 0) {
            }
            i22 = i4 & 8192;
            if (i22 == 0) {
            }
            i24 = i4 & 16384;
            if (i24 != 0) {
            }
            i26 = i4 & 32768;
            if (i26 != 0) {
            }
            i27 = i4 & 65536;
            if (i27 != 0) {
            }
            i28 = i4 & 131072;
            if (i28 != 0) {
            }
            if ((i2 & 100663296) == 0) {
            }
            i29 = i4 & 524288;
            if (i29 != 0) {
            }
            if ((i3 & 6) == 0) {
            }
            if ((i3 & 48) == 0) {
            }
            if ((i3 & 384) == 0) {
            }
            if ((i3 & 3072) == 0) {
            }
            int i4022222 = i30;
            i31 = i4 & 16777216;
            if (i31 != 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (i25 & 306783379) == 306783378 && (i32 & 9363) == 9362) ? false : true, i19 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        z4 = z;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        z5 = z2;
        if ((i & 24576) != 0) {
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        i8 = i4 & 64;
        if (i8 == 0) {
        }
        i9 = i4 & 128;
        if (i9 == 0) {
        }
        i10 = i4 & 256;
        if (i10 == 0) {
        }
        i11 = i10;
        i12 = i4 & 512;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i4 & 1024;
        if (i14 == 0) {
        }
        i17 = i4 & 2048;
        if (i17 == 0) {
        }
        int i3722222 = i16;
        i19 = i5;
        i20 = i4 & 4096;
        if (i20 == 0) {
        }
        i22 = i4 & 8192;
        if (i22 == 0) {
        }
        i24 = i4 & 16384;
        if (i24 != 0) {
        }
        i26 = i4 & 32768;
        if (i26 != 0) {
        }
        i27 = i4 & 65536;
        if (i27 != 0) {
        }
        i28 = i4 & 131072;
        if (i28 != 0) {
        }
        if ((i2 & 100663296) == 0) {
        }
        i29 = i4 & 524288;
        if (i29 != 0) {
        }
        if ((i3 & 6) == 0) {
        }
        if ((i3 & 48) == 0) {
        }
        if ((i3 & 384) == 0) {
        }
        if ((i3 & 3072) == 0) {
        }
        int i40222222 = i30;
        i31 = i4 & 16777216;
        if (i31 != 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (i25 & 306783379) == 306783378 && (i32 & 9363) == 9362) ? false : true, i19 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0596  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x05c4  */
    /* JADX WARN: Removed duplicated region for block: B:358:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5, final int i6) {
        final TextFieldValue textFieldValue2;
        int i7;
        final Function1<? super TextFieldValue, Unit> function12;
        Modifier modifier2;
        int i8;
        boolean z5;
        int i9;
        boolean z6;
        TextStyle textStyle2;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function29;
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
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActions keyboardActions2;
        final boolean z7;
        final int i34;
        final int i35;
        final MutableInteractionSource mutableInteractionSource2;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        Composer composer2;
        final boolean z8;
        final boolean z9;
        final TextStyle textStyle3;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        final boolean z10;
        final VisualTransformation visualTransformation2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i36;
        int i37;
        final Shape shape3;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        TextStyle textStyle4;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        final Function2<? super Composer, ? super Integer, Unit> function220;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function221;
        int i38;
        final Function2<? super Composer, ? super Integer, Unit> function222;
        final KeyboardActions keyboardActions3;
        final boolean z11;
        final int i39;
        final TextFieldColors textFieldColorsColors;
        final VisualTransformation visualTransformation3;
        final boolean z12;
        final boolean z13;
        final Function2<? super Composer, ? super Integer, Unit> function223;
        final boolean z14;
        final KeyboardOptions keyboardOptions3;
        final int i40;
        int i41;
        MutableInteractionSource mutableInteractionSource3;
        final MutableInteractionSource mutableInteractionSource4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1126989771);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,visualTransformation,keyboardOptions,keyboardActions,singleLine,maxLines,minLines,interactionSource,shape,colors)603@33216L1964,603@33129L2051:TextField.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i3 | 6;
            textFieldValue2 = textFieldValue;
        } else {
            textFieldValue2 = textFieldValue;
            if ((i3 & 6) == 0) {
                i7 = (composerStartRestartGroup.changed(textFieldValue2) ? 4 : 2) | i3;
            } else {
                i7 = i3;
            }
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i3 & 48) == 0) {
                i7 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i42 = i6 & 4;
        if (i42 != 0) {
            i7 |= 384;
        } else {
            if ((i3 & 384) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else {
                if ((i3 & 3072) == 0) {
                    z5 = z;
                    i7 |= composerStartRestartGroup.changed(z5) ? 2048 : 1024;
                }
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else {
                    if ((i3 & 24576) == 0) {
                        z6 = z2;
                        i7 |= composerStartRestartGroup.changed(z6) ? 16384 : 8192;
                    }
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        textStyle2 = textStyle;
                        i7 |= ((i6 & 32) == 0 && composerStartRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                        function28 = function2;
                    } else {
                        function28 = function2;
                        if ((i3 & 1572864) == 0) {
                            i7 |= composerStartRestartGroup.changedInstance(function28) ? 1048576 : 524288;
                        }
                    }
                    i11 = i6 & 128;
                    if (i11 == 0) {
                        i7 |= 12582912;
                        function29 = function22;
                    } else {
                        function29 = function22;
                        if ((i3 & 12582912) == 0) {
                            i7 |= composerStartRestartGroup.changedInstance(function29) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i6 & 256;
                    if (i12 == 0) {
                        i7 |= 100663296;
                    } else {
                        if ((i3 & 100663296) == 0) {
                            i13 = i12;
                            i7 |= composerStartRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        }
                        i14 = i6 & 512;
                        if (i14 != 0) {
                            i7 |= 805306368;
                        } else {
                            if ((i3 & 805306368) == 0) {
                                i15 = i14;
                                i7 |= composerStartRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                            }
                            i16 = i6 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 6) == 0) {
                                i17 = i16;
                                i18 = i4 | (composerStartRestartGroup.changedInstance(function25) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            i19 = i6 & 2048;
                            if (i19 == 0) {
                                i18 |= 48;
                                i20 = i19;
                            } else if ((i4 & 48) == 0) {
                                i20 = i19;
                                i18 |= composerStartRestartGroup.changedInstance(function26) ? 32 : 16;
                            } else {
                                i20 = i19;
                            }
                            int i43 = i18;
                            i21 = i7;
                            i22 = i6 & 4096;
                            if (i22 == 0) {
                                i23 = i43 | 384;
                            } else {
                                int i44 = i43;
                                if ((i4 & 384) == 0) {
                                    i44 |= composerStartRestartGroup.changedInstance(function27) ? 256 : 128;
                                }
                                i23 = i44;
                            }
                            i24 = i6 & 8192;
                            if (i24 == 0) {
                                i25 = i23 | 3072;
                            } else {
                                int i45 = i23;
                                if ((i4 & 3072) == 0) {
                                    i25 = i45 | (composerStartRestartGroup.changed(z3) ? 2048 : 1024);
                                } else {
                                    i25 = i45;
                                }
                            }
                            i26 = i6 & 16384;
                            if (i26 != 0) {
                                i27 = i25;
                                if ((i4 & 24576) == 0) {
                                    i27 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                                }
                                i28 = i6 & 32768;
                                if (i28 != 0) {
                                    i27 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i27 |= composerStartRestartGroup.changed(keyboardOptions) ? 131072 : 65536;
                                }
                                i29 = i6 & 65536;
                                if (i29 != 0) {
                                    i27 |= 1572864;
                                } else if ((i4 & 1572864) == 0) {
                                    i27 |= composerStartRestartGroup.changed(keyboardActions) ? 1048576 : 524288;
                                }
                                i30 = i6 & 131072;
                                if (i30 != 0) {
                                    i27 |= 12582912;
                                } else if ((i4 & 12582912) == 0) {
                                    i27 |= composerStartRestartGroup.changed(z4) ? 8388608 : 4194304;
                                }
                                if ((i4 & 100663296) == 0) {
                                    i27 |= ((i6 & 262144) == 0 && composerStartRestartGroup.changed(i)) ? 67108864 : 33554432;
                                }
                                i31 = i6 & 524288;
                                if (i31 != 0) {
                                    i27 |= 805306368;
                                } else if ((i4 & 805306368) == 0) {
                                    i27 |= composerStartRestartGroup.changed(i2) ? 536870912 : 268435456;
                                }
                                i32 = i6 & 1048576;
                                if (i32 != 0) {
                                    i33 = i5 | 6;
                                } else if ((i5 & 6) == 0) {
                                    i33 = i5 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                } else {
                                    i33 = i5;
                                }
                                if ((i5 & 48) == 0) {
                                    i33 |= ((i6 & 2097152) == 0 && composerStartRestartGroup.changed(shape)) ? 32 : 16;
                                }
                                if ((i5 & 384) == 0) {
                                    i33 |= ((i6 & 4194304) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 256 : 128;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "574@31784L7,590@32580L5,591@32635L8");
                                    if ((i3 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i42 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i8 != 0) {
                                            z5 = true;
                                        }
                                        if (i9 != 0) {
                                            z6 = false;
                                        }
                                        if ((i6 & 32) != 0) {
                                            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            i36 = i21 & (-458753);
                                            textStyle2 = (TextStyle) objConsume;
                                        } else {
                                            i36 = i21;
                                        }
                                        if (i10 != 0) {
                                            function28 = null;
                                        }
                                        if (i11 != 0) {
                                            function29 = null;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function224 = i13 != 0 ? null : function23;
                                        Function2<? super Composer, ? super Integer, Unit> function225 = i15 != 0 ? null : function24;
                                        Function2<? super Composer, ? super Integer, Unit> function226 = i17 != 0 ? null : function25;
                                        Function2<? super Composer, ? super Integer, Unit> function227 = i20 != 0 ? null : function26;
                                        Function2<? super Composer, ? super Integer, Unit> function228 = i22 != 0 ? null : function27;
                                        boolean z15 = i24 != 0 ? false : z3;
                                        VisualTransformation none = i26 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                        KeyboardOptions keyboardOptions4 = i28 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        KeyboardActions keyboardActions4 = i29 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                        boolean z16 = i30 != 0 ? false : z4;
                                        if ((i6 & 262144) != 0) {
                                            i37 = z16 ? 1 : Integer.MAX_VALUE;
                                            i27 &= -234881025;
                                        } else {
                                            i37 = i;
                                        }
                                        int i46 = i31 != 0 ? 1 : i2;
                                        MutableInteractionSource mutableInteractionSource5 = i32 == 0 ? mutableInteractionSource : null;
                                        Shape shape4 = (i6 & 2097152) != 0 ? TextFieldDefaults.INSTANCE.getShape(composerStartRestartGroup, 6) : shape;
                                        if ((i6 & 4194304) != 0) {
                                            shape3 = shape4;
                                            function217 = function224;
                                            function218 = function225;
                                            function219 = function226;
                                            function220 = function29;
                                            function221 = function227;
                                            i38 = i27;
                                            function222 = function228;
                                            keyboardActions3 = keyboardActions4;
                                            z11 = z16;
                                            i39 = i46;
                                            textFieldColorsColors = TextFieldDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                            visualTransformation3 = none;
                                            z12 = z5;
                                            textStyle4 = textStyle2;
                                            function223 = function28;
                                            modifier4 = modifier2;
                                            z14 = z15;
                                            keyboardOptions3 = keyboardOptions4;
                                            i40 = i37;
                                            i41 = i36;
                                            z13 = z6;
                                        } else {
                                            shape3 = shape4;
                                            function217 = function224;
                                            function218 = function225;
                                            textStyle4 = textStyle2;
                                            function219 = function226;
                                            function220 = function29;
                                            modifier4 = modifier2;
                                            function221 = function227;
                                            i38 = i27;
                                            function222 = function228;
                                            keyboardActions3 = keyboardActions4;
                                            z11 = z16;
                                            i39 = i46;
                                            textFieldColorsColors = textFieldColors;
                                            visualTransformation3 = none;
                                            z12 = z5;
                                            z13 = z6;
                                            function223 = function28;
                                            z14 = z15;
                                            keyboardOptions3 = keyboardOptions4;
                                            i40 = i37;
                                            i41 = i36;
                                        }
                                        mutableInteractionSource3 = mutableInteractionSource5;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        i41 = (i6 & 32) != 0 ? i21 & (-458753) : i21;
                                        if ((i6 & 262144) != 0) {
                                            i27 &= -234881025;
                                        }
                                        function217 = function23;
                                        function218 = function24;
                                        function219 = function25;
                                        function221 = function26;
                                        function222 = function27;
                                        visualTransformation3 = visualTransformation;
                                        keyboardOptions3 = keyboardOptions;
                                        z11 = z4;
                                        i40 = i;
                                        i39 = i2;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        shape3 = shape;
                                        textFieldColorsColors = textFieldColors;
                                        textStyle4 = textStyle2;
                                        function223 = function28;
                                        function220 = function29;
                                        modifier4 = modifier2;
                                        i38 = i27;
                                        z14 = z3;
                                        keyboardActions3 = keyboardActions;
                                        z12 = z5;
                                        z13 = z6;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1126989771, i41, i38, "androidx.compose.material3.TextField (TextField.kt:592)");
                                    }
                                    if (mutableInteractionSource3 == null) {
                                        composerStartRestartGroup.startReplaceGroup(-391701594);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "594@32730L39");
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -705372196, "CC(remember):TextField.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-705372847);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    composerStartRestartGroup.startReplaceGroup(-705366737);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*598@32954L25");
                                    long jM8586getColor0d7_KjU = textStyle4.m8586getColor0d7_KjU();
                                    if (jM8586getColor0d7_KjU == 16) {
                                        jM8586getColor0d7_KjU = textFieldColorsColors.m4255textColorXeAY9LY$material3(z12, z14, FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource4, composerStartRestartGroup, 0).getValue().booleanValue());
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    final TextStyle textStyleMerge = textStyle4.merge(new TextStyle(jM8586getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                    CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColorsColors.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(-306109195, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.5
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i47) {
                                            ComposerKt.sourceInformation(composer3, "C608@33369L38,626@34173L990,604@33226L1948:TextField.kt#uh7d8r");
                                            if (!composer3.shouldExecute((i47 & 3) != 2, i47 & 1)) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-306109195, i47, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:604)");
                                            }
                                            Modifier modifier5 = modifier4;
                                            boolean z17 = z14;
                                            Strings.Companion companion = Strings.INSTANCE;
                                            Modifier modifierM2067defaultMinSizeVpY3zN4 = SizeKt.m2067defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier5, z17, Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(androidx.compose.ui.R.string.default_error_message), composer3, 0)), TextFieldDefaults.INSTANCE.m4274getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m4273getMinHeightD9Ej5fM());
                                            SolidColor solidColor = new SolidColor(textFieldColorsColors.m4205cursorColorvNxB06k$material3(z14), null);
                                            final TextFieldValue textFieldValue3 = textFieldValue2;
                                            final boolean z18 = z12;
                                            final boolean z19 = z11;
                                            final VisualTransformation visualTransformation4 = visualTransformation3;
                                            final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                            final boolean z20 = z14;
                                            final Function2<Composer, Integer, Unit> function229 = function223;
                                            final Function2<Composer, Integer, Unit> function230 = function220;
                                            final Function2<Composer, Integer, Unit> function231 = function217;
                                            final Function2<Composer, Integer, Unit> function232 = function218;
                                            final Function2<Composer, Integer, Unit> function233 = function219;
                                            final Function2<Composer, Integer, Unit> function234 = function221;
                                            final Function2<Composer, Integer, Unit> function235 = function222;
                                            final Shape shape5 = shape3;
                                            final TextFieldColors textFieldColors3 = textFieldColorsColors;
                                            BasicTextFieldKt.BasicTextField(textFieldValue2, function12, modifierM2067defaultMinSizeVpY3zN4, z12, z13, textStyleMerge, keyboardOptions3, keyboardActions3, z11, i40, i39, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource4, solidColor, ComposableLambdaKt.rememberComposableLambda(-609710734, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.5.1
                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function236, Composer composer4, Integer num) {
                                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function236, composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function236, Composer composer4, int i48) {
                                                    Function2<? super Composer, ? super Integer, Unit> function237;
                                                    int i49;
                                                    ComposerKt.sourceInformation(composer4, "CN(innerTextField)628@34328L817:TextField.kt#uh7d8r");
                                                    if ((i48 & 6) == 0) {
                                                        function237 = function236;
                                                        i49 = i48 | (composer4.changedInstance(function237) ? 4 : 2);
                                                    } else {
                                                        function237 = function236;
                                                        i49 = i48;
                                                    }
                                                    if (!composer4.shouldExecute((i49 & 19) != 18, i49 & 1)) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-609710734, i49, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:628)");
                                                    }
                                                    TextFieldDefaults.INSTANCE.DecorationBox(textFieldValue3.getText(), function237, z18, z19, visualTransformation4, mutableInteractionSource6, z20, function229, function230, function231, function232, function233, function234, function235, shape5, textFieldColors3, null, null, composer4, (i49 << 3) & 112, 100663296, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composer3, 54), composer3, 0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    textStyle3 = textStyle4;
                                    composer2 = composerStartRestartGroup;
                                    modifier3 = modifier4;
                                    textFieldColors2 = textFieldColorsColors;
                                    z8 = z12;
                                    z9 = z13;
                                    keyboardOptions2 = keyboardOptions3;
                                    keyboardActions2 = keyboardActions3;
                                    z7 = z11;
                                    i34 = i40;
                                    i35 = i39;
                                    visualTransformation2 = visualTransformation3;
                                    function213 = function223;
                                    function214 = function220;
                                    function215 = function217;
                                    function210 = function219;
                                    function211 = function221;
                                    function212 = function222;
                                    shape2 = shape3;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    z10 = z14;
                                    function216 = function218;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    function210 = function25;
                                    function211 = function26;
                                    function212 = function27;
                                    keyboardOptions2 = keyboardOptions;
                                    keyboardActions2 = keyboardActions;
                                    z7 = z4;
                                    i34 = i;
                                    i35 = i2;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    shape2 = shape;
                                    textFieldColors2 = textFieldColors;
                                    composer2 = composerStartRestartGroup;
                                    z8 = z5;
                                    z9 = z6;
                                    textStyle3 = textStyle2;
                                    function213 = function28;
                                    function214 = function29;
                                    modifier3 = modifier2;
                                    function215 = function23;
                                    function216 = function24;
                                    z10 = z3;
                                    visualTransformation2 = visualTransformation;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return TextFieldKt.TextField$lambda$8(textFieldValue, function1, modifier3, z8, z9, textStyle3, function213, function214, function215, function216, function210, function211, function212, z10, visualTransformation2, keyboardOptions2, keyboardActions2, z7, i34, i35, mutableInteractionSource2, shape2, textFieldColors2, i3, i4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i27 = i25 | 24576;
                            i28 = i6 & 32768;
                            if (i28 != 0) {
                            }
                            i29 = i6 & 65536;
                            if (i29 != 0) {
                            }
                            i30 = i6 & 131072;
                            if (i30 != 0) {
                            }
                            if ((i4 & 100663296) == 0) {
                            }
                            i31 = i6 & 524288;
                            if (i31 != 0) {
                            }
                            i32 = i6 & 1048576;
                            if (i32 != 0) {
                            }
                            if ((i5 & 48) == 0) {
                            }
                            if ((i5 & 384) == 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i15 = i14;
                        i16 = i6 & 1024;
                        if (i16 == 0) {
                        }
                        i19 = i6 & 2048;
                        if (i19 == 0) {
                        }
                        int i432 = i18;
                        i21 = i7;
                        i22 = i6 & 4096;
                        if (i22 == 0) {
                        }
                        i24 = i6 & 8192;
                        if (i24 == 0) {
                        }
                        i26 = i6 & 16384;
                        if (i26 != 0) {
                        }
                        i28 = i6 & 32768;
                        if (i28 != 0) {
                        }
                        i29 = i6 & 65536;
                        if (i29 != 0) {
                        }
                        i30 = i6 & 131072;
                        if (i30 != 0) {
                        }
                        if ((i4 & 100663296) == 0) {
                        }
                        i31 = i6 & 524288;
                        if (i31 != 0) {
                        }
                        i32 = i6 & 1048576;
                        if (i32 != 0) {
                        }
                        if ((i5 & 48) == 0) {
                        }
                        if ((i5 & 384) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i13 = i12;
                    i14 = i6 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i6 & 1024;
                    if (i16 == 0) {
                    }
                    i19 = i6 & 2048;
                    if (i19 == 0) {
                    }
                    int i4322 = i18;
                    i21 = i7;
                    i22 = i6 & 4096;
                    if (i22 == 0) {
                    }
                    i24 = i6 & 8192;
                    if (i24 == 0) {
                    }
                    i26 = i6 & 16384;
                    if (i26 != 0) {
                    }
                    i28 = i6 & 32768;
                    if (i28 != 0) {
                    }
                    i29 = i6 & 65536;
                    if (i29 != 0) {
                    }
                    i30 = i6 & 131072;
                    if (i30 != 0) {
                    }
                    if ((i4 & 100663296) == 0) {
                    }
                    i31 = i6 & 524288;
                    if (i31 != 0) {
                    }
                    i32 = i6 & 1048576;
                    if (i32 != 0) {
                    }
                    if ((i5 & 48) == 0) {
                    }
                    if ((i5 & 384) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z6 = z2;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                i11 = i6 & 128;
                if (i11 == 0) {
                }
                i12 = i6 & 256;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i6 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i6 & 1024;
                if (i16 == 0) {
                }
                i19 = i6 & 2048;
                if (i19 == 0) {
                }
                int i43222 = i18;
                i21 = i7;
                i22 = i6 & 4096;
                if (i22 == 0) {
                }
                i24 = i6 & 8192;
                if (i24 == 0) {
                }
                i26 = i6 & 16384;
                if (i26 != 0) {
                }
                i28 = i6 & 32768;
                if (i28 != 0) {
                }
                i29 = i6 & 65536;
                if (i29 != 0) {
                }
                i30 = i6 & 131072;
                if (i30 != 0) {
                }
                if ((i4 & 100663296) == 0) {
                }
                i31 = i6 & 524288;
                if (i31 != 0) {
                }
                i32 = i6 & 1048576;
                if (i32 != 0) {
                }
                if ((i5 & 48) == 0) {
                }
                if ((i5 & 384) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z5 = z;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            z6 = z2;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            i11 = i6 & 128;
            if (i11 == 0) {
            }
            i12 = i6 & 256;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i6 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i6 & 1024;
            if (i16 == 0) {
            }
            i19 = i6 & 2048;
            if (i19 == 0) {
            }
            int i432222 = i18;
            i21 = i7;
            i22 = i6 & 4096;
            if (i22 == 0) {
            }
            i24 = i6 & 8192;
            if (i24 == 0) {
            }
            i26 = i6 & 16384;
            if (i26 != 0) {
            }
            i28 = i6 & 32768;
            if (i28 != 0) {
            }
            i29 = i6 & 65536;
            if (i29 != 0) {
            }
            i30 = i6 & 131072;
            if (i30 != 0) {
            }
            if ((i4 & 100663296) == 0) {
            }
            i31 = i6 & 524288;
            if (i31 != 0) {
            }
            i32 = i6 & 1048576;
            if (i32 != 0) {
            }
            if ((i5 & 48) == 0) {
            }
            if ((i5 & 384) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z5 = z;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        z6 = z2;
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        i11 = i6 & 128;
        if (i11 == 0) {
        }
        i12 = i6 & 256;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i6 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i6 & 1024;
        if (i16 == 0) {
        }
        i19 = i6 & 2048;
        if (i19 == 0) {
        }
        int i4322222 = i18;
        i21 = i7;
        i22 = i6 & 4096;
        if (i22 == 0) {
        }
        i24 = i6 & 8192;
        if (i24 == 0) {
        }
        i26 = i6 & 16384;
        if (i26 != 0) {
        }
        i28 = i6 & 32768;
        if (i28 != 0) {
        }
        i29 = i6 & 65536;
        if (i29 != 0) {
        }
        i30 = i6 & 131072;
        if (i30 != 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        i31 = i6 & 524288;
        if (i31 != 0) {
        }
        i32 = i6 & 1048576;
        if (i32 != 0) {
        }
        if ((i5 & 48) == 0) {
        }
        if ((i5 & 384) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0596  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x05c4  */
    /* JADX WARN: Removed duplicated region for block: B:358:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextField(final String str, final Function1<? super String, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5, final int i6) {
        final String str2;
        int i7;
        final Function1<? super String, Unit> function12;
        Modifier modifier2;
        int i8;
        boolean z5;
        int i9;
        boolean z6;
        TextStyle textStyle2;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function29;
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
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActions keyboardActions2;
        final boolean z7;
        final int i34;
        final int i35;
        final MutableInteractionSource mutableInteractionSource2;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        Composer composer2;
        final boolean z8;
        final boolean z9;
        final TextStyle textStyle3;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        final boolean z10;
        final VisualTransformation visualTransformation2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i36;
        int i37;
        final Shape shape3;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        TextStyle textStyle4;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        final Function2<? super Composer, ? super Integer, Unit> function220;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function221;
        int i38;
        final Function2<? super Composer, ? super Integer, Unit> function222;
        final KeyboardActions keyboardActions3;
        final boolean z11;
        final int i39;
        final TextFieldColors textFieldColorsColors;
        final VisualTransformation visualTransformation3;
        final boolean z12;
        final boolean z13;
        final Function2<? super Composer, ? super Integer, Unit> function223;
        final boolean z14;
        final KeyboardOptions keyboardOptions3;
        final int i40;
        int i41;
        MutableInteractionSource mutableInteractionSource3;
        final MutableInteractionSource mutableInteractionSource4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-154966360);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,visualTransformation,keyboardOptions,keyboardActions,singleLine,maxLines,minLines,interactionSource,shape,colors)453@24857L1959,453@24770L2046:TextField.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i3 | 6;
            str2 = str;
        } else {
            str2 = str;
            if ((i3 & 6) == 0) {
                i7 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i3;
            } else {
                i7 = i3;
            }
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i3 & 48) == 0) {
                i7 |= composerStartRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i42 = i6 & 4;
        if (i42 != 0) {
            i7 |= 384;
        } else {
            if ((i3 & 384) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else {
                if ((i3 & 3072) == 0) {
                    z5 = z;
                    i7 |= composerStartRestartGroup.changed(z5) ? 2048 : 1024;
                }
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else {
                    if ((i3 & 24576) == 0) {
                        z6 = z2;
                        i7 |= composerStartRestartGroup.changed(z6) ? 16384 : 8192;
                    }
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        textStyle2 = textStyle;
                        i7 |= ((i6 & 32) == 0 && composerStartRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                        function28 = function2;
                    } else {
                        function28 = function2;
                        if ((i3 & 1572864) == 0) {
                            i7 |= composerStartRestartGroup.changedInstance(function28) ? 1048576 : 524288;
                        }
                    }
                    i11 = i6 & 128;
                    if (i11 == 0) {
                        i7 |= 12582912;
                        function29 = function22;
                    } else {
                        function29 = function22;
                        if ((i3 & 12582912) == 0) {
                            i7 |= composerStartRestartGroup.changedInstance(function29) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i6 & 256;
                    if (i12 == 0) {
                        i7 |= 100663296;
                    } else {
                        if ((i3 & 100663296) == 0) {
                            i13 = i12;
                            i7 |= composerStartRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        }
                        i14 = i6 & 512;
                        if (i14 != 0) {
                            i7 |= 805306368;
                        } else {
                            if ((i3 & 805306368) == 0) {
                                i15 = i14;
                                i7 |= composerStartRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                            }
                            i16 = i6 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 6) == 0) {
                                i17 = i16;
                                i18 = i4 | (composerStartRestartGroup.changedInstance(function25) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            i19 = i6 & 2048;
                            if (i19 == 0) {
                                i18 |= 48;
                                i20 = i19;
                            } else if ((i4 & 48) == 0) {
                                i20 = i19;
                                i18 |= composerStartRestartGroup.changedInstance(function26) ? 32 : 16;
                            } else {
                                i20 = i19;
                            }
                            int i43 = i18;
                            i21 = i7;
                            i22 = i6 & 4096;
                            if (i22 == 0) {
                                i23 = i43 | 384;
                            } else {
                                int i44 = i43;
                                if ((i4 & 384) == 0) {
                                    i44 |= composerStartRestartGroup.changedInstance(function27) ? 256 : 128;
                                }
                                i23 = i44;
                            }
                            i24 = i6 & 8192;
                            if (i24 == 0) {
                                i25 = i23 | 3072;
                            } else {
                                int i45 = i23;
                                if ((i4 & 3072) == 0) {
                                    i25 = i45 | (composerStartRestartGroup.changed(z3) ? 2048 : 1024);
                                } else {
                                    i25 = i45;
                                }
                            }
                            i26 = i6 & 16384;
                            if (i26 != 0) {
                                i27 = i25;
                                if ((i4 & 24576) == 0) {
                                    i27 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                                }
                                i28 = i6 & 32768;
                                if (i28 != 0) {
                                    i27 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i27 |= composerStartRestartGroup.changed(keyboardOptions) ? 131072 : 65536;
                                }
                                i29 = i6 & 65536;
                                if (i29 != 0) {
                                    i27 |= 1572864;
                                } else if ((i4 & 1572864) == 0) {
                                    i27 |= composerStartRestartGroup.changed(keyboardActions) ? 1048576 : 524288;
                                }
                                i30 = i6 & 131072;
                                if (i30 != 0) {
                                    i27 |= 12582912;
                                } else if ((i4 & 12582912) == 0) {
                                    i27 |= composerStartRestartGroup.changed(z4) ? 8388608 : 4194304;
                                }
                                if ((i4 & 100663296) == 0) {
                                    i27 |= ((i6 & 262144) == 0 && composerStartRestartGroup.changed(i)) ? 67108864 : 33554432;
                                }
                                i31 = i6 & 524288;
                                if (i31 != 0) {
                                    i27 |= 805306368;
                                } else if ((i4 & 805306368) == 0) {
                                    i27 |= composerStartRestartGroup.changed(i2) ? 536870912 : 268435456;
                                }
                                i32 = i6 & 1048576;
                                if (i32 != 0) {
                                    i33 = i5 | 6;
                                } else if ((i5 & 6) == 0) {
                                    i33 = i5 | (composerStartRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                } else {
                                    i33 = i5;
                                }
                                if ((i5 & 48) == 0) {
                                    i33 |= ((i6 & 2097152) == 0 && composerStartRestartGroup.changed(shape)) ? 32 : 16;
                                }
                                if ((i5 & 384) == 0) {
                                    i33 |= ((i6 & 4194304) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 256 : 128;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "424@23425L7,440@24221L5,441@24276L8");
                                    if ((i3 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i42 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i8 != 0) {
                                            z5 = true;
                                        }
                                        if (i9 != 0) {
                                            z6 = false;
                                        }
                                        if ((i6 & 32) != 0) {
                                            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            i36 = i21 & (-458753);
                                            textStyle2 = (TextStyle) objConsume;
                                        } else {
                                            i36 = i21;
                                        }
                                        if (i10 != 0) {
                                            function28 = null;
                                        }
                                        if (i11 != 0) {
                                            function29 = null;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function224 = i13 != 0 ? null : function23;
                                        Function2<? super Composer, ? super Integer, Unit> function225 = i15 != 0 ? null : function24;
                                        Function2<? super Composer, ? super Integer, Unit> function226 = i17 != 0 ? null : function25;
                                        Function2<? super Composer, ? super Integer, Unit> function227 = i20 != 0 ? null : function26;
                                        Function2<? super Composer, ? super Integer, Unit> function228 = i22 != 0 ? null : function27;
                                        boolean z15 = i24 != 0 ? false : z3;
                                        VisualTransformation none = i26 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                        KeyboardOptions keyboardOptions4 = i28 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        KeyboardActions keyboardActions4 = i29 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                        boolean z16 = i30 != 0 ? false : z4;
                                        if ((i6 & 262144) != 0) {
                                            i37 = z16 ? 1 : Integer.MAX_VALUE;
                                            i27 &= -234881025;
                                        } else {
                                            i37 = i;
                                        }
                                        int i46 = i31 != 0 ? 1 : i2;
                                        MutableInteractionSource mutableInteractionSource5 = i32 == 0 ? mutableInteractionSource : null;
                                        Shape shape4 = (i6 & 2097152) != 0 ? TextFieldDefaults.INSTANCE.getShape(composerStartRestartGroup, 6) : shape;
                                        if ((i6 & 4194304) != 0) {
                                            shape3 = shape4;
                                            function217 = function224;
                                            function218 = function225;
                                            function219 = function226;
                                            function220 = function29;
                                            function221 = function227;
                                            i38 = i27;
                                            function222 = function228;
                                            keyboardActions3 = keyboardActions4;
                                            z11 = z16;
                                            i39 = i46;
                                            textFieldColorsColors = TextFieldDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                            visualTransformation3 = none;
                                            z12 = z5;
                                            textStyle4 = textStyle2;
                                            function223 = function28;
                                            modifier4 = modifier2;
                                            z14 = z15;
                                            keyboardOptions3 = keyboardOptions4;
                                            i40 = i37;
                                            i41 = i36;
                                            z13 = z6;
                                        } else {
                                            shape3 = shape4;
                                            function217 = function224;
                                            function218 = function225;
                                            textStyle4 = textStyle2;
                                            function219 = function226;
                                            function220 = function29;
                                            modifier4 = modifier2;
                                            function221 = function227;
                                            i38 = i27;
                                            function222 = function228;
                                            keyboardActions3 = keyboardActions4;
                                            z11 = z16;
                                            i39 = i46;
                                            textFieldColorsColors = textFieldColors;
                                            visualTransformation3 = none;
                                            z12 = z5;
                                            z13 = z6;
                                            function223 = function28;
                                            z14 = z15;
                                            keyboardOptions3 = keyboardOptions4;
                                            i40 = i37;
                                            i41 = i36;
                                        }
                                        mutableInteractionSource3 = mutableInteractionSource5;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        i41 = (i6 & 32) != 0 ? i21 & (-458753) : i21;
                                        if ((i6 & 262144) != 0) {
                                            i27 &= -234881025;
                                        }
                                        function217 = function23;
                                        function218 = function24;
                                        function219 = function25;
                                        function221 = function26;
                                        function222 = function27;
                                        visualTransformation3 = visualTransformation;
                                        keyboardOptions3 = keyboardOptions;
                                        z11 = z4;
                                        i40 = i;
                                        i39 = i2;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        shape3 = shape;
                                        textFieldColorsColors = textFieldColors;
                                        textStyle4 = textStyle2;
                                        function223 = function28;
                                        function220 = function29;
                                        modifier4 = modifier2;
                                        i38 = i27;
                                        z14 = z3;
                                        keyboardActions3 = keyboardActions;
                                        z12 = z5;
                                        z13 = z6;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-154966360, i41, i38, "androidx.compose.material3.TextField (TextField.kt:442)");
                                    }
                                    if (mutableInteractionSource3 == null) {
                                        composerStartRestartGroup.startReplaceGroup(488210003);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "444@24371L39");
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1401222031, "CC(remember):TextField.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(1401221380);
                                        composerStartRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    composerStartRestartGroup.startReplaceGroup(1401227490);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*448@24595L25");
                                    long jM8586getColor0d7_KjU = textStyle4.m8586getColor0d7_KjU();
                                    if (jM8586getColor0d7_KjU == 16) {
                                        jM8586getColor0d7_KjU = textFieldColorsColors.m4255textColorXeAY9LY$material3(z12, z14, FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource4, composerStartRestartGroup, 0).getValue().booleanValue());
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    final TextStyle textStyleMerge = textStyle4.merge(new TextStyle(jM8586getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                    CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColorsColors.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1459735400, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.3
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i47) {
                                            ComposerKt.sourceInformation(composer3, "C458@25010L38,476@25814L985,454@24867L1943:TextField.kt#uh7d8r");
                                            if (!composer3.shouldExecute((i47 & 3) != 2, i47 & 1)) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1459735400, i47, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:454)");
                                            }
                                            Modifier modifier5 = modifier4;
                                            boolean z17 = z14;
                                            Strings.Companion companion = Strings.INSTANCE;
                                            Modifier modifierM2067defaultMinSizeVpY3zN4 = SizeKt.m2067defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier5, z17, Strings_androidKt.m4676getString2EP1pXo(Strings.m4597constructorimpl(androidx.compose.ui.R.string.default_error_message), composer3, 0)), TextFieldDefaults.INSTANCE.m4274getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m4273getMinHeightD9Ej5fM());
                                            SolidColor solidColor = new SolidColor(textFieldColorsColors.m4205cursorColorvNxB06k$material3(z14), null);
                                            final String str3 = str2;
                                            final boolean z18 = z12;
                                            final boolean z19 = z11;
                                            final VisualTransformation visualTransformation4 = visualTransformation3;
                                            final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                            final boolean z20 = z14;
                                            final Function2<Composer, Integer, Unit> function229 = function223;
                                            final Function2<Composer, Integer, Unit> function230 = function220;
                                            final Function2<Composer, Integer, Unit> function231 = function217;
                                            final Function2<Composer, Integer, Unit> function232 = function218;
                                            final Function2<Composer, Integer, Unit> function233 = function219;
                                            final Function2<Composer, Integer, Unit> function234 = function221;
                                            final Function2<Composer, Integer, Unit> function235 = function222;
                                            final Shape shape5 = shape3;
                                            final TextFieldColors textFieldColors3 = textFieldColorsColors;
                                            BasicTextFieldKt.BasicTextField(str2, function12, modifierM2067defaultMinSizeVpY3zN4, z12, z13, textStyleMerge, keyboardOptions3, keyboardActions3, z11, i40, i39, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource4, solidColor, ComposableLambdaKt.rememberComposableLambda(1451491557, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt.TextField.3.1
                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function236, Composer composer4, Integer num) {
                                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function236, composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function236, Composer composer4, int i48) {
                                                    Function2<? super Composer, ? super Integer, Unit> function237;
                                                    int i49;
                                                    ComposerKt.sourceInformation(composer4, "CN(innerTextField)478@25969L812:TextField.kt#uh7d8r");
                                                    if ((i48 & 6) == 0) {
                                                        function237 = function236;
                                                        i49 = i48 | (composer4.changedInstance(function237) ? 4 : 2);
                                                    } else {
                                                        function237 = function236;
                                                        i49 = i48;
                                                    }
                                                    if (!composer4.shouldExecute((i49 & 19) != 18, i49 & 1)) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1451491557, i49, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:478)");
                                                    }
                                                    TextFieldDefaults.INSTANCE.DecorationBox(str3, function237, z18, z19, visualTransformation4, mutableInteractionSource6, z20, function229, function230, function231, function232, function233, function234, function235, shape5, textFieldColors3, null, null, composer4, (i49 << 3) & 112, 100663296, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composer3, 54), composer3, 0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    textStyle3 = textStyle4;
                                    composer2 = composerStartRestartGroup;
                                    modifier3 = modifier4;
                                    textFieldColors2 = textFieldColorsColors;
                                    z8 = z12;
                                    z9 = z13;
                                    keyboardOptions2 = keyboardOptions3;
                                    keyboardActions2 = keyboardActions3;
                                    z7 = z11;
                                    i34 = i40;
                                    i35 = i39;
                                    visualTransformation2 = visualTransformation3;
                                    function213 = function223;
                                    function214 = function220;
                                    function215 = function217;
                                    function210 = function219;
                                    function211 = function221;
                                    function212 = function222;
                                    shape2 = shape3;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    z10 = z14;
                                    function216 = function218;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    function210 = function25;
                                    function211 = function26;
                                    function212 = function27;
                                    keyboardOptions2 = keyboardOptions;
                                    keyboardActions2 = keyboardActions;
                                    z7 = z4;
                                    i34 = i;
                                    i35 = i2;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    shape2 = shape;
                                    textFieldColors2 = textFieldColors;
                                    composer2 = composerStartRestartGroup;
                                    z8 = z5;
                                    z9 = z6;
                                    textStyle3 = textStyle2;
                                    function213 = function28;
                                    function214 = function29;
                                    modifier3 = modifier2;
                                    function215 = function23;
                                    function216 = function24;
                                    z10 = z3;
                                    visualTransformation2 = visualTransformation;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return TextFieldKt.TextField$lambda$5(str, function1, modifier3, z8, z9, textStyle3, function213, function214, function215, function216, function210, function211, function212, z10, visualTransformation2, keyboardOptions2, keyboardActions2, z7, i34, i35, mutableInteractionSource2, shape2, textFieldColors2, i3, i4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i27 = i25 | 24576;
                            i28 = i6 & 32768;
                            if (i28 != 0) {
                            }
                            i29 = i6 & 65536;
                            if (i29 != 0) {
                            }
                            i30 = i6 & 131072;
                            if (i30 != 0) {
                            }
                            if ((i4 & 100663296) == 0) {
                            }
                            i31 = i6 & 524288;
                            if (i31 != 0) {
                            }
                            i32 = i6 & 1048576;
                            if (i32 != 0) {
                            }
                            if ((i5 & 48) == 0) {
                            }
                            if ((i5 & 384) == 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i15 = i14;
                        i16 = i6 & 1024;
                        if (i16 == 0) {
                        }
                        i19 = i6 & 2048;
                        if (i19 == 0) {
                        }
                        int i432 = i18;
                        i21 = i7;
                        i22 = i6 & 4096;
                        if (i22 == 0) {
                        }
                        i24 = i6 & 8192;
                        if (i24 == 0) {
                        }
                        i26 = i6 & 16384;
                        if (i26 != 0) {
                        }
                        i28 = i6 & 32768;
                        if (i28 != 0) {
                        }
                        i29 = i6 & 65536;
                        if (i29 != 0) {
                        }
                        i30 = i6 & 131072;
                        if (i30 != 0) {
                        }
                        if ((i4 & 100663296) == 0) {
                        }
                        i31 = i6 & 524288;
                        if (i31 != 0) {
                        }
                        i32 = i6 & 1048576;
                        if (i32 != 0) {
                        }
                        if ((i5 & 48) == 0) {
                        }
                        if ((i5 & 384) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i13 = i12;
                    i14 = i6 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i6 & 1024;
                    if (i16 == 0) {
                    }
                    i19 = i6 & 2048;
                    if (i19 == 0) {
                    }
                    int i4322 = i18;
                    i21 = i7;
                    i22 = i6 & 4096;
                    if (i22 == 0) {
                    }
                    i24 = i6 & 8192;
                    if (i24 == 0) {
                    }
                    i26 = i6 & 16384;
                    if (i26 != 0) {
                    }
                    i28 = i6 & 32768;
                    if (i28 != 0) {
                    }
                    i29 = i6 & 65536;
                    if (i29 != 0) {
                    }
                    i30 = i6 & 131072;
                    if (i30 != 0) {
                    }
                    if ((i4 & 100663296) == 0) {
                    }
                    i31 = i6 & 524288;
                    if (i31 != 0) {
                    }
                    i32 = i6 & 1048576;
                    if (i32 != 0) {
                    }
                    if ((i5 & 48) == 0) {
                    }
                    if ((i5 & 384) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z6 = z2;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                i11 = i6 & 128;
                if (i11 == 0) {
                }
                i12 = i6 & 256;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i6 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i6 & 1024;
                if (i16 == 0) {
                }
                i19 = i6 & 2048;
                if (i19 == 0) {
                }
                int i43222 = i18;
                i21 = i7;
                i22 = i6 & 4096;
                if (i22 == 0) {
                }
                i24 = i6 & 8192;
                if (i24 == 0) {
                }
                i26 = i6 & 16384;
                if (i26 != 0) {
                }
                i28 = i6 & 32768;
                if (i28 != 0) {
                }
                i29 = i6 & 65536;
                if (i29 != 0) {
                }
                i30 = i6 & 131072;
                if (i30 != 0) {
                }
                if ((i4 & 100663296) == 0) {
                }
                i31 = i6 & 524288;
                if (i31 != 0) {
                }
                i32 = i6 & 1048576;
                if (i32 != 0) {
                }
                if ((i5 & 48) == 0) {
                }
                if ((i5 & 384) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z5 = z;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            z6 = z2;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            i11 = i6 & 128;
            if (i11 == 0) {
            }
            i12 = i6 & 256;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i6 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i6 & 1024;
            if (i16 == 0) {
            }
            i19 = i6 & 2048;
            if (i19 == 0) {
            }
            int i432222 = i18;
            i21 = i7;
            i22 = i6 & 4096;
            if (i22 == 0) {
            }
            i24 = i6 & 8192;
            if (i24 == 0) {
            }
            i26 = i6 & 16384;
            if (i26 != 0) {
            }
            i28 = i6 & 32768;
            if (i28 != 0) {
            }
            i29 = i6 & 65536;
            if (i29 != 0) {
            }
            i30 = i6 & 131072;
            if (i30 != 0) {
            }
            if ((i4 & 100663296) == 0) {
            }
            i31 = i6 & 524288;
            if (i31 != 0) {
            }
            i32 = i6 & 1048576;
            if (i32 != 0) {
            }
            if ((i5 & 48) == 0) {
            }
            if ((i5 & 384) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z5 = z;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        z6 = z2;
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        i11 = i6 & 128;
        if (i11 == 0) {
        }
        i12 = i6 & 256;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i6 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i6 & 1024;
        if (i16 == 0) {
        }
        i19 = i6 & 2048;
        if (i19 == 0) {
        }
        int i4322222 = i18;
        i21 = i7;
        i22 = i6 & 4096;
        if (i22 == 0) {
        }
        i24 = i6 & 8192;
        if (i24 == 0) {
        }
        i26 = i6 & 16384;
        if (i26 != 0) {
        }
        i28 = i6 & 32768;
        if (i28 != 0) {
        }
        i29 = i6 & 65536;
        if (i29 != 0) {
        }
        i30 = i6 & 131072;
        if (i30 != 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        i31 = i6 & 524288;
        if (i31 != 0) {
        }
        i32 = i6 & 1048576;
        if (i32 != 0) {
        }
        if ((i5 & 48) == 0) {
        }
        if ((i5 & 384) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i21 & 306783379) == 306783378 && (i27 & 306783379) == 306783378 && (i33 & 147) == 146) ? false : true, i21 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    static final Unit TextField$lambda$2(TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, TextFieldLabelPosition textFieldLabelPosition, Function3 function3, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function2 function26, boolean z3, InputTransformation inputTransformation, OutputTransformation outputTransformation, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, TextFieldLineLimits textFieldLineLimits, Function2 function27, ScrollState scrollState, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, int i4, Composer composer, int i5) {
        TextField(textFieldState, modifier, z, z2, textStyle, textFieldLabelPosition, function3, function2, function22, function23, function24, function25, function26, z3, inputTransformation, outputTransformation, keyboardOptions, keyboardActionHandler, textFieldLineLimits, function27, scrollState, shape, textFieldColors, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    static final Unit TextField$lambda$5(String str, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function2 function26, Function2 function27, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i3, int i4, int i5, int i6, Composer composer, int i7) {
        TextField(str, (Function1<? super String, Unit>) function1, modifier, z, z2, textStyle, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function22, (Function2<? super Composer, ? super Integer, Unit>) function23, (Function2<? super Composer, ? super Integer, Unit>) function24, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function26, (Function2<? super Composer, ? super Integer, Unit>) function27, z3, visualTransformation, keyboardOptions, keyboardActions, z4, i, i2, mutableInteractionSource, shape, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    static final Unit TextField$lambda$8(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function2 function26, Function2 function27, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i3, int i4, int i5, int i6, Composer composer, int i7) {
        TextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier, z, z2, textStyle, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function22, (Function2<? super Composer, ? super Integer, Unit>) function23, (Function2<? super Composer, ? super Integer, Unit>) function24, (Function2<? super Composer, ? super Integer, Unit>) function25, (Function2<? super Composer, ? super Integer, Unit>) function26, (Function2<? super Composer, ? super Integer, Unit>) function27, z3, visualTransformation, keyboardOptions, keyboardActions, z4, i, i2, mutableInteractionSource, shape, textFieldColors, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:246:0x0731  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0785  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0791  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x07c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, final Function2<? super Composer, ? super Integer, Unit> function26, final boolean z, TextFieldLabelPosition textFieldLabelPosition, FloatProducer floatProducer, final Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function32;
        final TextFieldLabelPosition textFieldLabelPosition2;
        Function2<? super Composer, ? super Integer, Unit> function29;
        final FloatProducer floatProducer2;
        Composer composer2;
        PaddingValues paddingValues2;
        int i5;
        Object textFieldMeasurePolicy;
        int i6;
        float f;
        Modifier modifierM2041paddingqDBjuR0$default;
        boolean z2;
        Object objRememberedValue;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1086465551);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldLayout)N(modifier,textField,label,placeholder,leading,trailing,prefix,suffix,singleLine,labelPosition,labelProgress,container,supporting,paddingValues)672@35929L26,674@35988L475,689@36511L7,690@36523L4465:TextField.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = i | (composerStartRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function25) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(textFieldLabelPosition) ? 536870912 : 268435456;
        }
        int i7 = i3;
        if ((i2 & 6) == 0) {
            i4 = i2 | ((i2 & 8) == 0 ? composerStartRestartGroup.changed(floatProducer) : composerStartRestartGroup.changedInstance(floatProducer) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function27) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function28) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(paddingValues) ? 2048 : 1024;
        }
        int i8 = i4;
        if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i8 & 1171) == 1170) ? false : true, i7 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1086465551, i7, i8, "androidx.compose.material3.TextFieldLayout (TextField.kt:671)");
            }
            float fMinimizedLabelHalfHeight = TextFieldImplKt.minimizedLabelHalfHeight(composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -416319668, "CC(remember):TextField.kt#9igjgp");
            int i9 = i8 & 14;
            boolean zChanged = ((i8 & 7168) == 2048) | ((1879048192 & i7) == 536870912) | ((234881024 & i7) == 67108864) | (i9 == 4 || ((i8 & 8) != 0 && composerStartRestartGroup.changed(floatProducer))) | composerStartRestartGroup.changed(fMinimizedLabelHalfHeight);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                i5 = i9;
                i6 = i7;
                composer2 = composerStartRestartGroup;
                paddingValues2 = paddingValues;
                textFieldMeasurePolicy = new TextFieldMeasurePolicy(z, textFieldLabelPosition, floatProducer, paddingValues2, fMinimizedLabelHalfHeight, null);
                composer2.updateRememberedValue(textFieldMeasurePolicy);
            } else {
                i5 = i9;
                i6 = i7;
                textFieldMeasurePolicy = objRememberedValue2;
                composer2 = composerStartRestartGroup;
                paddingValues2 = paddingValues;
            }
            TextFieldMeasurePolicy textFieldMeasurePolicy2 = (TextFieldMeasurePolicy) textFieldMeasurePolicy;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume;
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composer2);
            int i10 = i5;
            Updater.m5603setimpl(composerM5595constructorimpl2, textFieldMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl2, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5595constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5595constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5603setimpl(composerM5595constructorimpl2, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -1445107871, "C696@36842L11,718@37662L32,787@40302L187:TextField.kt#uh7d8r");
            function27.invoke(composer2, Integer.valueOf((i8 >> 3) & 14));
            if (function23 != null) {
                composer2.startReplaceGroup(-1445181094);
                ComposerKt.sourceInformation(composer2, "699@36906L224");
                Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(LayoutIdKt.layoutId(Modifier.INSTANCE, "Leading"));
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierMinimumInteractiveComponentSize);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composerM5595constructorimpl3 = Updater.m5595constructorimpl(composer2);
                Updater.m5603setimpl(composerM5595constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl3, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM5595constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM5595constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m5603setimpl(composerM5595constructorimpl3, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -130017935, "C703@37103L9:TextField.kt#uh7d8r");
                function23.invoke(composer2, Integer.valueOf((i6 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1444935078);
                composer2.endReplaceGroup();
            }
            if (function24 != null) {
                composer2.startReplaceGroup(-1444892360);
                ComposerKt.sourceInformation(composer2, "707@37197L226");
                Modifier modifierMinimumInteractiveComponentSize2 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(LayoutIdKt.layoutId(Modifier.INSTANCE, "Trailing"));
                Alignment center2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierMinimumInteractiveComponentSize2);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                Composer composerM5595constructorimpl4 = Updater.m5595constructorimpl(composer2);
                Updater.m5603setimpl(composerM5595constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl4, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    composerM5595constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM5595constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m5603setimpl(composerM5595constructorimpl4, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 385425337, "C711@37395L10:TextField.kt#uh7d8r");
                function24.invoke(composer2, Integer.valueOf((i6 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1444644422);
                composer2.endReplaceGroup();
            }
            float fCalculateStartPadding = PaddingKt.calculateStartPadding(paddingValues2, layoutDirection);
            float fCalculateEndPadding = PaddingKt.calculateEndPadding(paddingValues2, layoutDirection);
            float fTextFieldHorizontalIconPadding = TextFieldImplKt.textFieldHorizontalIconPadding(composer2, 0);
            if (function23 != null) {
                fCalculateStartPadding = Dp.m9114constructorimpl(RangesKt.coerceAtLeast(Dp.m9114constructorimpl(fCalculateStartPadding - fTextFieldHorizontalIconPadding), Dp.m9114constructorimpl(0.0f)));
            }
            float fM9114constructorimpl = fCalculateStartPadding;
            if (function24 != null) {
                fCalculateEndPadding = Dp.m9114constructorimpl(RangesKt.coerceAtLeast(Dp.m9114constructorimpl(fCalculateEndPadding - fTextFieldHorizontalIconPadding), Dp.m9114constructorimpl(0.0f)));
            }
            if (function25 != null) {
                composer2.startReplaceGroup(-1443868027);
                ComposerKt.sourceInformation(composer2, "733@38227L309");
                Modifier modifierM2041paddingqDBjuR0$default2 = PaddingKt.m2041paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m2071heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.PrefixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), fM9114constructorimpl, 0.0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, 10, null);
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierM2041paddingqDBjuR0$default2);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor4);
                } else {
                    composer2.useNode();
                }
                Composer composerM5595constructorimpl5 = Updater.m5595constructorimpl(composer2);
                Updater.m5603setimpl(composerM5595constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl5, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    composerM5595constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    composerM5595constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                }
                Updater.m5603setimpl(composerM5595constructorimpl5, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1325247206, "C739@38510L8:TextField.kt#uh7d8r");
                function25.invoke(composer2, Integer.valueOf((i6 >> 18) & 14));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1443540326);
                composer2.endReplaceGroup();
            }
            if (function26 != null) {
                composer2.startReplaceGroup(-1443497081);
                ComposerKt.sourceInformation(composer2, "743@38601L307");
                f = fCalculateEndPadding;
                Modifier modifierM2041paddingqDBjuR0$default3 = PaddingKt.m2041paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m2071heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.SuffixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, f, 0.0f, 10, null);
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, modifierM2041paddingqDBjuR0$default3);
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor5);
                } else {
                    composer2.useNode();
                }
                Composer composerM5595constructorimpl6 = Updater.m5595constructorimpl(composer2);
                Updater.m5603setimpl(composerM5595constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl6, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl6.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                    composerM5595constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                    composerM5595constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                }
                Updater.m5603setimpl(composerM5595constructorimpl6, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1259047609, "C749@38882L8:TextField.kt#uh7d8r");
                function26.invoke(composer2, Integer.valueOf((i6 >> 21) & 14));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                f = fCalculateEndPadding;
                composer2.startReplaceGroup(-1443171302);
                composer2.endReplaceGroup();
            }
            textFieldLabelPosition2 = textFieldLabelPosition;
            if (textFieldLabelPosition2 instanceof TextFieldLabelPosition.Above) {
                modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, TextFieldImplKt.getAboveLabelHorizontalPadding(), 0.0f, TextFieldImplKt.getAboveLabelHorizontalPadding(), TextFieldImplKt.getAboveLabelBottomPadding(), 2, null);
            } else {
                float f2 = f;
                modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(Modifier.INSTANCE, fM9114constructorimpl, 0.0f, f2, 0.0f, 10, null);
                f = f2;
            }
            if (function22 != null) {
                composer2.startReplaceGroup(-1442671489);
                ComposerKt.sourceInformation(composer2, "766@39532L123,764@39431L379");
                Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "Label");
                ComposerKt.sourceInformationMarkerStart(composer2, 1061844387, "CC(remember):TextField.kt#9igjgp");
                if (i10 != 4) {
                    floatProducer2 = floatProducer;
                    z2 = (i8 & 8) != 0 && composer2.changedInstance(floatProducer2);
                    objRememberedValue = composer2.rememberedValue();
                    if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Dp.m9112boximpl(DpKt.m9157lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), floatProducer2.invoke()));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierThen = SizeKt.wrapContentHeight$default(TextFieldImplKt.textFieldLabelMinHeight(modifierLayoutId, (Function0) objRememberedValue), null, false, 3, null).then(modifierM2041paddingqDBjuR0$default);
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer2, modifierThen);
                    Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.useNode();
                    } else {
                        composer2.createNode(constructor6);
                    }
                    composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -451624903, "C772@39785L7:TextField.kt#uh7d8r");
                    function22.invoke(composer2, Integer.valueOf((i6 >> 6) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceGroup();
                } else {
                    floatProducer2 = floatProducer;
                }
                objRememberedValue = composer2.rememberedValue();
                if (!z2) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Dp.m9112boximpl(DpKt.m9157lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), floatProducer2.invoke()));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierThen2 = SizeKt.wrapContentHeight$default(TextFieldImplKt.textFieldLabelMinHeight(modifierLayoutId, (Function0) objRememberedValue), null, false, 3, null).then(modifierM2041paddingqDBjuR0$default);
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy52 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap62 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier62 = ComposedModifierKt.materializeModifier(composer2, modifierThen2);
                    Function0<ComposeUiNode> constructor62 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                    }
                    composerM5595constructorimpl = Updater.m5595constructorimpl(composer2);
                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy52, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap62, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5595constructorimpl.getInserting()) {
                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier62, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance52 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -451624903, "C772@39785L7:TextField.kt#uh7d8r");
                        function22.invoke(composer2, Integer.valueOf((i6 >> 6) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceGroup();
                    }
                }
            } else {
                floatProducer2 = floatProducer;
                composer2.startReplaceGroup(-1442276518);
                composer2.endReplaceGroup();
            }
            Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.m2071heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null);
            if (function25 != null) {
                fM9114constructorimpl = Dp.m9114constructorimpl(0.0f);
            }
            Modifier modifierM2041paddingqDBjuR0$default4 = PaddingKt.m2041paddingqDBjuR0$default(modifierWrapContentHeight$default, fM9114constructorimpl, 0.0f, function26 == null ? f : Dp.m9114constructorimpl(0.0f), 0.0f, 10, null);
            if (function3 != null) {
                composer2.startReplaceGroup(-1441906533);
                ComposerKt.sourceInformation(composer2, "785@40212L63");
                function32 = function3;
                function32.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, "Hint").then(modifierM2041paddingqDBjuR0$default4), composer2, Integer.valueOf((i6 >> 6) & 112));
                composer2.endReplaceGroup();
            } else {
                function32 = function3;
                composer2.startReplaceGroup(-1441815238);
                composer2.endReplaceGroup();
            }
            Modifier modifierThen3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "TextField").then(modifierM2041paddingqDBjuR0$default4);
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer2, modifierThen3);
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor7);
            } else {
                composer2.useNode();
            }
            Composer composerM5595constructorimpl7 = Updater.m5595constructorimpl(composer2);
            Updater.m5603setimpl(composerM5595constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl7.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                composerM5595constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                composerM5595constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
            }
            Updater.m5603setimpl(composerM5595constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -275388054, "C791@40464L11:TextField.kt#uh7d8r");
            function2.invoke(composer2, Integer.valueOf((i6 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (function28 != null) {
                composer2.startReplaceGroup(-1441566587);
                ComposerKt.sourceInformation(composer2, "796@40601L317");
                Modifier modifierPadding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m2071heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.SupportingId), TextFieldImplKt.getMinSupportingTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldDefaults.m4264supportingTextPaddinga9UjIt4$material3$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null));
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap8 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer2, modifierPadding);
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor8);
                } else {
                    composer2.useNode();
                }
                Composer composerM5595constructorimpl8 = Updater.m5595constructorimpl(composer2);
                Updater.m5603setimpl(composerM5595constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5595constructorimpl8.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                    composerM5595constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                    composerM5595constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                }
                Updater.m5603setimpl(composerM5595constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 421997586, "C802@40888L12:TextField.kt#uh7d8r");
                function29 = function28;
                function29.invoke(composer2, Integer.valueOf((i8 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                function29 = function28;
                composer2.startReplaceGroup(-1441177382);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function32 = function3;
            textFieldLabelPosition2 = textFieldLabelPosition;
            function29 = function28;
            floatProducer2 = floatProducer;
            composer2 = composerStartRestartGroup;
            paddingValues2 = paddingValues;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function33 = function32;
            final FloatProducer floatProducer3 = floatProducer2;
            final PaddingValues paddingValues3 = paddingValues2;
            final Function2<? super Composer, ? super Integer, Unit> function210 = function29;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldKt.TextFieldLayout$lambda$20(modifier, function2, function22, function33, function23, function24, function25, function26, z, textFieldLabelPosition2, floatProducer3, function27, function210, paddingValues3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit TextFieldLayout$lambda$20(Modifier modifier, Function2 function2, Function2 function22, Function3 function3, Function2 function23, Function2 function24, Function2 function25, Function2 function26, boolean z, TextFieldLabelPosition textFieldLabelPosition, FloatProducer floatProducer, Function2 function27, Function2 function28, PaddingValues paddingValues, int i, int i2, Composer composer, int i3) {
        TextFieldLayout(modifier, function2, function22, function3, function23, function24, function25, function26, z, textFieldLabelPosition, floatProducer, function27, function28, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    public static final float getTextFieldWithLabelVerticalPadding() {
        return TextFieldWithLabelVerticalPadding;
    }
}
