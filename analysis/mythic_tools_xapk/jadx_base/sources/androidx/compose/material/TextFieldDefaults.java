package androidx.compose.material;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.messaging.Constants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: TextFieldDefaults.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0019\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u0005¢\u0006\u0004\b$\u0010%JM\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\u0005H\u0007¢\u0006\u0004\b+\u0010,J5\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u0005¢\u0006\u0004\b3\u00104J5\u00105\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u0005¢\u0006\u0004\b6\u00104J5\u00107\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u0005¢\u0006\u0004\b8\u00104Já\u0001\u00109\u001a\u00020!2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010@\u001a\u00020;2\b\b\u0002\u0010A\u001a\u00020;2\b\b\u0002\u0010B\u001a\u00020;2\b\b\u0002\u0010C\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007¢\u0006\u0004\bP\u0010QJá\u0001\u0010R\u001a\u00020!2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010S\u001a\u00020;2\b\b\u0002\u0010T\u001a\u00020;2\b\b\u0002\u0010U\u001a\u00020;2\b\b\u0002\u0010V\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007¢\u0006\u0004\bW\u0010QJÌ\u0001\u0010X\u001a\u00020'2\u0006\u0010Y\u001a\u00020Z2\u0011\u0010[\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020`2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010d\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010e\u001a\u00020.H\u0007¢\u0006\u0002\u0010fJá\u0001\u0010g\u001a\u00020'2\u0006\u0010Y\u001a\u00020Z2\u0011\u0010[\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020`2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010d\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010e\u001a\u00020.2\u0013\b\u0002\u0010h\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]H\u0007¢\u0006\u0002\u0010iJÂ\u0001\u0010X\u001a\u00020'2\u0006\u0010Y\u001a\u00020Z2\u0011\u0010[\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020`2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010d\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010e\u001a\u00020.H\u0007¢\u0006\u0002\u0010jJ×\u0001\u0010g\u001a\u00020'2\u0006\u0010Y\u001a\u00020Z2\u0011\u0010[\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020`2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010d\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010e\u001a\u00020.2\u0013\b\u0002\u0010h\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]H\u0007¢\u0006\u0002\u0010kR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u000e\u0010\u0017\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Landroidx/compose/material/TextFieldDefaults;", "", "<init>", "()V", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "getMinHeight-D9Ej5fM", "()F", "F", "MinWidth", "getMinWidth-D9Ej5fM", "IconOpacity", "", "TextFieldShape", "Landroidx/compose/ui/graphics/Shape;", "getTextFieldShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "OutlinedTextFieldShape", "getOutlinedTextFieldShape", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "FocusedBorderThickness", "getFocusedBorderThickness-D9Ej5fM", "BackgroundOpacity", "UnfocusedIndicatorLineOpacity", "indicatorLine", "Landroidx/compose/ui/Modifier;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material/TextFieldColors;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "BorderBox", "", "shape", "focusedBorderThickness", "unfocusedBorderThickness", "BorderBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "textFieldWithLabelPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "start", "end", ViewHierarchyConstants.DIMENSION_TOP_KEY, "bottom", "textFieldWithLabelPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "outlinedTextFieldPadding", "outlinedTextFieldPadding-a9UjIt4", "textFieldColors", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "textFieldColors-dx8h9Zs", "(JJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "outlinedTextFieldColors", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "outlinedTextFieldColors-dx8h9Zs", "TextFieldDecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", Constants.ScionAnalytics.PARAM_LABEL, "placeholder", "leadingIcon", "trailingIcon", "contentPadding", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldDecorationBox", OutlinedTextFieldKt.BorderId, "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldDefaults {
    public static final int $stable = 0;
    public static final float BackgroundOpacity = 0.12f;
    public static final float IconOpacity = 0.54f;
    public static final float UnfocusedIndicatorLineOpacity = 0.42f;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = Dp.m9114constructorimpl(56.0f);
    private static final float MinWidth = Dp.m9114constructorimpl(280.0f);
    private static final float UnfocusedBorderThickness = Dp.m9114constructorimpl(1.0f);
    private static final float FocusedBorderThickness = Dp.m9114constructorimpl(2.0f);

    private TextFieldDefaults() {
    }

    static final Unit BorderBox_nbWgWpA$lambda$0(TextFieldDefaults textFieldDefaults, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f, float f2, int i, int i2, Composer composer, int i3) {
        textFieldDefaults.m3208BorderBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit OutlinedTextFieldDecorationBox$lambda$0(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C644@31420L61:TextFieldDefaults.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1212923596, i, -1, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:644)");
            }
            INSTANCE.m3208BorderBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape, 0.0f, 0.0f, composer, 12582912, 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit OutlinedTextFieldDecorationBox$lambda$1(TextFieldDefaults textFieldDefaults, String str, Function2 function2, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2 function26, int i, int i2, int i3, Composer composer, int i4) {
        textFieldDefaults.OutlinedTextFieldDecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z3, function22, function23, function24, function25, shape, textFieldColors, paddingValues, function26, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit OutlinedTextFieldDecorationBox$lambda$2(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C730@34582L54:TextFieldDefaults.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1922186815, i, -1, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:730)");
            }
            INSTANCE.m3208BorderBoxnbWgWpA(z, z2, interactionSource, textFieldColors, null, 0.0f, 0.0f, composer, 12582912, 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit OutlinedTextFieldDecorationBox$lambda$3(TextFieldDefaults textFieldDefaults, String str, Function2 function2, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, Function2 function22, Function2 function23, Function2 function24, Function2 function25, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2 function26, int i, int i2, int i3, Composer composer, int i4) {
        textFieldDefaults.OutlinedTextFieldDecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z3, function22, function23, function24, function25, textFieldColors, paddingValues, function26, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit TextFieldDecorationBox$lambda$0(TextFieldDefaults textFieldDefaults, String str, Function2 function2, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, int i, int i2, int i3, Composer composer, int i4) {
        textFieldDefaults.TextFieldDecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z3, function22, function23, function24, function25, shape, textFieldColors, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit TextFieldDecorationBox$lambda$1(TextFieldDefaults textFieldDefaults, String str, Function2 function2, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, Function2 function22, Function2 function23, Function2 function24, Function2 function25, TextFieldColors textFieldColors, PaddingValues paddingValues, int i, int i2, int i3, Composer composer, int i4) {
        textFieldDefaults.TextFieldDecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z3, function22, function23, function24, function25, textFieldColors, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: indicatorLine-gv0btCI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3204indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, int i, Object obj) {
        if ((i & 16) != 0) {
            f = FocusedBorderThickness;
        }
        return textFieldDefaults.m3213indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f, (i & 32) != 0 ? UnfocusedBorderThickness : f2);
    }

    static final Modifier indicatorLine_gv0btCI$lambda$1(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(1398930845);
        ComposerKt.sourceInformation(composer, "C289@11188L375:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1398930845, i, -1, "androidx.compose.material.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:288)");
        }
        Modifier modifierDrawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.INSTANCE, (BorderStroke) TextFieldDefaultsKt.m3220animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, textFieldColors, f, f2, composer, 0).getValue());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierDrawIndicatorLine;
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3205outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m3215outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3206textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getFirstBaselineOffset();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldBottomPadding();
        }
        return textFieldDefaults.m3217textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3207textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m3218textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x015d  */
    /* JADX INFO: renamed from: BorderBox-nbWgWpA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3208BorderBoxnbWgWpA(final boolean z, final boolean z2, final InteractionSource interactionSource, final TextFieldColors textFieldColors, Shape shape, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Shape outlinedTextFieldShape;
        float f3;
        float f4;
        final float f5;
        final float f6;
        Composer composerStartRestartGroup = composer.startRestartGroup(943754022);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BorderBox)N(enabled,isError,interactionSource,colors,shape,focusedBorderThickness:c#ui.unit.Dp,unfocusedBorderThickness:c#ui.unit.Dp)326@12897L333,334@13239L47:TextFieldDefaults.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(interactionSource) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(textFieldColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                outlinedTextFieldShape = shape;
                int i4 = composerStartRestartGroup.changed(outlinedTextFieldShape) ? 16384 : 8192;
                i3 |= i4;
            } else {
                outlinedTextFieldShape = shape;
            }
            i3 |= i4;
        } else {
            outlinedTextFieldShape = shape;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                f3 = f;
                int i5 = composerStartRestartGroup.changed(f3) ? 131072 : 65536;
                i3 |= i5;
            } else {
                f3 = f;
            }
            i3 |= i5;
        } else {
            f3 = f;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                f4 = f2;
                int i6 = composerStartRestartGroup.changed(f4) ? 1048576 : 524288;
                i3 |= i6;
            } else {
                f4 = f2;
            }
            i3 |= i6;
        } else {
            f4 = f2;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(this) ? 8388608 : 4194304;
        }
        if (composerStartRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "321@12700L22");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 16) != 0) {
                    outlinedTextFieldShape = getOutlinedTextFieldShape(composerStartRestartGroup, (i3 >> 21) & 14);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    f3 = FocusedBorderThickness;
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    f4 = UnfocusedBorderThickness;
                    i3 &= -3670017;
                }
                float f7 = f3;
                float f8 = f4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(943754022, i3, -1, "androidx.compose.material.TextFieldDefaults.BorderBox (TextFieldDefaults.kt:324)");
                }
                int i7 = i3 & 8190;
                int i8 = i3 >> 3;
                BoxKt.Box(BorderKt.border(Modifier.INSTANCE, (BorderStroke) TextFieldDefaultsKt.m3220animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, textFieldColors, f7, f8, composerStartRestartGroup, i7 | (57344 & i8) | (i8 & 458752)).getValue(), outlinedTextFieldShape), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f6 = f7;
                f5 = f8;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                }
                float f72 = f3;
                float f82 = f4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i72 = i3 & 8190;
                int i82 = i3 >> 3;
                BoxKt.Box(BorderKt.border(Modifier.INSTANCE, (BorderStroke) TextFieldDefaultsKt.m3220animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, textFieldColors, f72, f82, composerStartRestartGroup, i72 | (57344 & i82) | (i82 & 458752)).getValue(), outlinedTextFieldShape), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                f6 = f72;
                f5 = f82;
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            f5 = f4;
            f6 = f3;
        }
        final Shape shape2 = outlinedTextFieldShape;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldDefaults.BorderBox_nbWgWpA$lambda$0(this.f$0, z, z2, interactionSource, textFieldColors, shape2, f6, f5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0126  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with `shape` parameter.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void OutlinedTextFieldDecorationBox(final String str, final Function2 function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2 function22, Function2 function23, Function2 function24, Function2 function25, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2 function26, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        final boolean z4;
        Function2 function27;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final Function2 function28;
        final Function2 function29;
        final Function2 function210;
        final PaddingValues paddingValues2;
        final Function2 function211;
        final boolean z5;
        final Function2 function212;
        final TextFieldColors textFieldColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2 function213;
        boolean z6;
        int i12;
        Composer composer3;
        int i13;
        int i14;
        final TextFieldColors textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
        int i15;
        TextFieldDefaults textFieldDefaults;
        PaddingValues paddingValuesM3205outlinedTextFieldPaddinga9UjIt4$default;
        final boolean z7;
        Function2 function214;
        Function2 function215;
        Function2 function216;
        int i16;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2141154809);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextFieldDecorationBox)N(value,innerTextField,enabled,singleLine,visualTransformation,interactionSource,isError,label,placeholder,leadingIcon,trailingIcon,colors,contentPadding,border)744@35133L22,732@34656L613:TextFieldDefaults.kt#jmzs0o");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        int i17 = i3 & 64;
        if (i17 != 0) {
            i4 |= 1572864;
            z4 = z3;
        } else {
            z4 = z3;
            if ((i & 1572864) == 0) {
                i4 |= composerStartRestartGroup.changed(z4) ? 1048576 : 524288;
            }
        }
        int i18 = i3 & 128;
        if (i18 != 0) {
            i4 |= 12582912;
            function27 = function22;
        } else {
            function27 = function22;
            if ((i & 12582912) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function27) ? 8388608 : 4194304;
            }
        }
        int i19 = i3 & 256;
        if (i19 != 0) {
            i4 |= 100663296;
        } else if ((i & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
        }
        int i20 = i3 & 512;
        if (i20 != 0) {
            i4 |= 805306368;
        } else {
            if ((i & 805306368) == 0) {
                i5 = i20;
                i4 |= composerStartRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
            }
            i6 = i3 & 1024;
            if (i6 == 0) {
                i8 = i2 | 6;
                i7 = i6;
            } else if ((i2 & 6) == 0) {
                i7 = i6;
                i8 = i2 | (composerStartRestartGroup.changedInstance(function25) ? 4 : 2);
            } else {
                i7 = i6;
                i8 = i2;
            }
            if ((i2 & 48) == 0) {
                i8 |= ((i3 & 2048) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                i8 |= ((i3 & 4096) == 0 && composerStartRestartGroup.changed(paddingValues)) ? 256 : 128;
            }
            int i21 = i8;
            i9 = i3 & 8192;
            if (i9 != 0) {
                i10 = i21;
                if ((i2 & 3072) == 0) {
                    i10 |= composerStartRestartGroup.changedInstance(function26) ? 2048 : 1024;
                }
                if ((i2 & 24576) == 0) {
                    i10 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                }
                i11 = i10;
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 9363) == 9362) ? false : true, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "728@34444L25,730@34580L58");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        boolean z8 = i17 != 0 ? false : z4;
                        Function2 function217 = i18 != 0 ? null : function27;
                        function213 = i19 != 0 ? null : function23;
                        Function2 function218 = i5 != 0 ? null : function24;
                        Function2 function219 = i7 != 0 ? null : function25;
                        if ((i3 & 2048) != 0) {
                            i14 = i9;
                            i12 = i3;
                            z6 = z8;
                            i13 = i4;
                            textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = m3214outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i11 >> 9) & 112, 2097151);
                            composer3 = composerStartRestartGroup;
                            i15 = i11 & (-113);
                        } else {
                            z6 = z8;
                            i12 = i3;
                            composer3 = composerStartRestartGroup;
                            i13 = i4;
                            i14 = i9;
                            textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            i15 = i11;
                        }
                        if ((i12 & 4096) != 0) {
                            paddingValuesM3205outlinedTextFieldPaddinga9UjIt4$default = m3205outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            textFieldDefaults = this;
                            i15 &= -897;
                        } else {
                            textFieldDefaults = this;
                            paddingValuesM3205outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i14 != 0) {
                            z7 = z;
                            z4 = z6;
                            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1922186815, true, new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$2(z7, z4, interactionSource, textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                            textFieldColors2 = textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
                            i11 = i15;
                            paddingValues2 = paddingValuesM3205outlinedTextFieldPaddinga9UjIt4$default;
                            function211 = composableLambdaRememberComposableLambda;
                        } else {
                            z7 = z;
                            z4 = z6;
                            function211 = function26;
                            textFieldColors2 = textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
                            i11 = i15;
                            paddingValues2 = paddingValuesM3205outlinedTextFieldPaddinga9UjIt4$default;
                        }
                        function214 = function217;
                        function215 = function218;
                        function216 = function219;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 2048) != 0) {
                            i11 &= -113;
                        }
                        if ((i3 & 4096) != 0) {
                            i11 &= -897;
                        }
                        function213 = function23;
                        function215 = function24;
                        paddingValues2 = paddingValues;
                        function211 = function26;
                        composer3 = composerStartRestartGroup;
                        i13 = i4;
                        function214 = function27;
                        function216 = function25;
                        textFieldColors2 = textFieldColors;
                        z7 = z;
                        textFieldDefaults = this;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        i16 = i13;
                        ComposerKt.traceEventStart(-2141154809, i16, i11, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:732)");
                    } else {
                        i16 = i13;
                    }
                    int i22 = i11 & 14;
                    int i23 = i11 << 3;
                    int i24 = i22 | (i23 & 896) | (i23 & 7168) | (57344 & i23) | (i23 & 458752);
                    Composer composer4 = composer3;
                    boolean z9 = z7;
                    boolean z10 = z4;
                    Function2 function220 = function213;
                    textFieldDefaults.OutlinedTextFieldDecorationBox(str, function2, z9, z2, visualTransformation, interactionSource, z10, function214, function220, function215, function216, textFieldDefaults.getOutlinedTextFieldShape(composer3, (i11 >> 12) & 14), textFieldColors2, paddingValues2, function211, composer4, i16 & 2147483646, i24, 0);
                    composer2 = composer4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function210 = function216;
                    function29 = function215;
                    function28 = function220;
                    function212 = function214;
                    z5 = z10;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function28 = function23;
                    function29 = function24;
                    function210 = function25;
                    paddingValues2 = paddingValues;
                    function211 = function26;
                    z5 = z4;
                    function212 = function27;
                    textFieldColors2 = textFieldColors;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$3(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z5, function212, function28, function29, function210, textFieldColors2, paddingValues2, function211, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i10 = i21 | 3072;
            if ((i2 & 24576) == 0) {
            }
            i11 = i10;
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 9363) == 9362) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i5 = i20;
        i6 = i3 & 1024;
        if (i6 == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        if ((i2 & 384) == 0) {
        }
        int i212 = i8;
        i9 = i3 & 8192;
        if (i9 != 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        i11 = i10;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i11 & 9363) == 9362) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OutlinedTextFieldDecorationBox(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function26, Composer composer, final int i, final int i2, int i3) {
        int i4;
        final boolean z4;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape shape3;
        boolean z5;
        Composer composer3;
        int i11;
        int i12;
        int i13;
        TextFieldColors textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
        PaddingValues paddingValuesM3205outlinedTextFieldPaddinga9UjIt4$default;
        boolean z6;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        TextFieldColors textFieldColors3;
        PaddingValues paddingValues3;
        Shape shape4;
        boolean z7;
        int i14;
        int i15 = i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1154925202);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextFieldDecorationBox)N(value,innerTextField,enabled,singleLine,visualTransformation,interactionSource,isError,label,placeholder,leadingIcon,trailingIcon,shape,colors,contentPadding,border)647@31509L628:TextFieldDefaults.kt#jmzs0o");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        int i16 = 1024;
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        int i17 = i15 & 64;
        if (i17 != 0) {
            i4 |= 1572864;
            z4 = z3;
        } else {
            z4 = z3;
            if ((i & 1572864) == 0) {
                i4 |= composerStartRestartGroup.changed(z4) ? 1048576 : 524288;
            }
        }
        int i18 = i15 & 128;
        if (i18 != 0) {
            i4 |= 12582912;
            function27 = function22;
        } else {
            function27 = function22;
            if ((i & 12582912) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function27) ? 8388608 : 4194304;
            }
        }
        int i19 = i15 & 256;
        if (i19 != 0) {
            i4 |= 100663296;
            function28 = function23;
        } else {
            function28 = function23;
            if ((i & 100663296) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function28) ? 67108864 : 33554432;
            }
        }
        int i20 = i15 & 512;
        if (i20 != 0) {
            i4 |= 805306368;
        } else {
            if ((i & 805306368) == 0) {
                i5 = i20;
                i4 |= composerStartRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
            }
            i6 = i15 & 1024;
            if (i6 == 0) {
                i8 = i2 | 6;
                i7 = i6;
            } else if ((i2 & 6) == 0) {
                i7 = i6;
                i8 = i2 | (composerStartRestartGroup.changedInstance(function25) ? 4 : 2);
            } else {
                i7 = i6;
                i8 = i2;
            }
            if ((i2 & 48) == 0) {
                i8 |= ((i15 & 2048) == 0 && composerStartRestartGroup.changed(shape)) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                i8 |= ((i15 & 4096) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 256 : 128;
            }
            if ((i2 & 3072) == 0) {
                if ((i15 & 8192) == 0 && composerStartRestartGroup.changed(paddingValues)) {
                    i16 = 2048;
                }
                i8 |= i16;
            }
            int i21 = i8;
            i9 = i15 & 16384;
            if (i9 != 0) {
                i10 = i21;
                if ((i2 & 24576) == 0) {
                    i10 |= composerStartRestartGroup.changedInstance(function26) ? 16384 : 8192;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i10 |= composerStartRestartGroup.changed(this) ? 131072 : 65536;
                }
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 74899) == 74898) ? false : true, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "640@31212L22,641@31270L25,643@31406L85");
                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        boolean z8 = i17 != 0 ? false : z4;
                        Function2<? super Composer, ? super Integer, Unit> function214 = i18 != 0 ? null : function27;
                        Function2<? super Composer, ? super Integer, Unit> function215 = i19 != 0 ? null : function28;
                        Function2<? super Composer, ? super Integer, Unit> function216 = i5 != 0 ? null : function24;
                        Function2<? super Composer, ? super Integer, Unit> function217 = i7 != 0 ? null : function25;
                        if ((i15 & 2048) != 0) {
                            Shape outlinedTextFieldShape = getOutlinedTextFieldShape(composerStartRestartGroup, (i10 >> 15) & 14);
                            i10 &= -113;
                            shape3 = outlinedTextFieldShape;
                        } else {
                            shape3 = shape;
                        }
                        if ((i15 & 4096) != 0) {
                            i13 = i9;
                            z5 = z8;
                            i11 = i4;
                            textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = m3214outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i10 >> 12) & 112, 2097151);
                            composer3 = composerStartRestartGroup;
                            i12 = i10 & (-897);
                        } else {
                            z5 = z8;
                            composer3 = composerStartRestartGroup;
                            i11 = i4;
                            i12 = i10;
                            i13 = i9;
                            textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        i15 = i3;
                        if ((i15 & 8192) != 0) {
                            paddingValuesM3205outlinedTextFieldPaddinga9UjIt4$default = m3205outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i12 &= -7169;
                        } else {
                            paddingValuesM3205outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i13 != 0) {
                            final boolean z9 = z5;
                            final TextFieldColors textFieldColors4 = textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
                            final Shape shape5 = shape3;
                            z6 = z9;
                            textFieldColors3 = textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
                            paddingValues3 = paddingValuesM3205outlinedTextFieldPaddinga9UjIt4$default;
                            shape4 = shape5;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1212923596, true, new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$0(z, z9, interactionSource, textFieldColors4, shape5, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54);
                        } else {
                            z6 = z5;
                            function2RememberComposableLambda = function26;
                            textFieldColors3 = textFieldColorsM3214outlinedTextFieldColorsdx8h9Zs;
                            paddingValues3 = paddingValuesM3205outlinedTextFieldPaddinga9UjIt4$default;
                            shape4 = shape3;
                        }
                        z7 = z6;
                        function211 = function214;
                        function212 = function215;
                        function29 = function216;
                        function213 = function217;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i15 & 2048) != 0) {
                            i10 &= -113;
                        }
                        i12 = i10;
                        if ((i15 & 4096) != 0) {
                            i12 &= -897;
                        }
                        if ((i15 & 8192) != 0) {
                            i12 &= -7169;
                        }
                        function29 = function24;
                        shape4 = shape;
                        textFieldColors3 = textFieldColors;
                        paddingValues3 = paddingValues;
                        function2RememberComposableLambda = function26;
                        composer3 = composerStartRestartGroup;
                        i11 = i4;
                        function211 = function27;
                        function212 = function28;
                        function213 = function25;
                        z7 = z4;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        i14 = i11;
                        ComposerKt.traceEventStart(1154925202, i14, i12, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:646)");
                    } else {
                        i14 = i11;
                    }
                    int i22 = i14 << 3;
                    int i23 = i14 >> 9;
                    int i24 = i12 << 6;
                    Composer composer4 = composer3;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function211, function212, function29, function213, z2, z, z7, interactionSource, paddingValues3, shape4, textFieldColors3, function2RememberComposableLambda, composer4, (i22 & 896) | (i22 & 112) | 6 | ((i14 >> 3) & 7168) | (57344 & i23) | (458752 & i23) | (i23 & 3670016) | ((i12 << 21) & 29360128) | ((i14 << 15) & 234881024) | ((i14 << 21) & 1879048192), ((i14 >> 18) & 14) | ((i14 >> 12) & 112) | ((i12 >> 3) & 896) | (i24 & 7168) | (i24 & 57344) | ((i12 << 3) & 458752));
                    composer2 = composer4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z7;
                    paddingValues2 = paddingValues3;
                    shape2 = shape4;
                    textFieldColors2 = textFieldColors3;
                    function210 = function2RememberComposableLambda;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function29 = function24;
                    shape2 = shape;
                    textFieldColors2 = textFieldColors;
                    function210 = function26;
                    function211 = function27;
                    function212 = function28;
                    function213 = function25;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i25 = i15;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TextFieldDefaults.OutlinedTextFieldDecorationBox$lambda$1(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z4, function211, function212, function29, function213, shape2, textFieldColors2, paddingValues2, function210, i, i2, i25, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i10 = i21 | 24576;
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 74899) == 74898) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i5 = i20;
        i6 = i15 & 1024;
        if (i6 == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        if ((i2 & 384) == 0) {
        }
        if ((i2 & 3072) == 0) {
        }
        int i212 = i8;
        i9 = i15 & 16384;
        if (i9 != 0) {
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i10 & 74899) == 74898) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0122  */
    /* JADX WARN: Type update failed for variable: r57v0 'this'  ??, new type: androidx.compose.material.TextFieldDefaults
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 8461. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:37)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:224)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
     */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with `shape` parameter.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void TextFieldDecorationBox(final String str, final Function2 function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2 function22, Function2 function23, Function2 function24, Function2 function25, TextFieldColors textFieldColors, PaddingValues paddingValues, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        boolean z4;
        Function2 function26;
        Function2 function27;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        final Function2 function28;
        final TextFieldColors textFieldColors2;
        final Function2 function29;
        final Function2 function210;
        final Function2 function211;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        int i11;
        TextFieldColors textFieldColorsM3216textFieldColorsdx8h9Zs;
        int i12;
        TextFieldDefaults textFieldDefaults;
        Function2 function212;
        Function2 function213;
        Function2 function214;
        Function2 function215;
        PaddingValues paddingValuesM3206textFieldWithLabelPaddinga9UjIt4$default;
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(-380568);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldDecorationBox)N(value,innerTextField,enabled,singleLine,visualTransformation,interactionSource,isError,label,placeholder,leadingIcon,trailingIcon,colors,contentPadding)705@33592L14,693@33123L568:TextFieldDefaults.kt#jmzs0o");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        int i14 = i3 & 64;
        if (i14 != 0) {
            i4 |= 1572864;
            z4 = z3;
        } else {
            z4 = z3;
            if ((i & 1572864) == 0) {
                i4 |= composerStartRestartGroup.changed(z4) ? 1048576 : 524288;
            }
        }
        int i15 = i3 & 128;
        if (i15 != 0) {
            i4 |= 12582912;
            function26 = function22;
        } else {
            function26 = function22;
            if ((i & 12582912) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
            }
        }
        int i16 = i3 & 256;
        if (i16 != 0) {
            i4 |= 100663296;
            function27 = function23;
        } else {
            function27 = function23;
            if ((i & 100663296) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function27) ? 67108864 : 33554432;
            }
        }
        int i17 = i3 & 512;
        if (i17 == 0) {
            if ((i & 805306368) == 0) {
                i5 = i17;
                i4 |= composerStartRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
            }
            i6 = i3 & 1024;
            if (i6 == 0) {
                i8 = i2 | 6;
                i7 = i6;
            } else if ((i2 & 6) == 0) {
                i7 = i6;
                i8 = i2 | (composerStartRestartGroup.changedInstance(function25) ? 4 : 2);
            } else {
                i7 = i6;
                i8 = i2;
            }
            if ((i2 & 48) == 0) {
                i8 |= ((i3 & 2048) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                i8 |= ((i3 & 4096) == 0 && composerStartRestartGroup.changed(paddingValues)) ? 256 : 128;
            }
            if ((i2 & 3072) == 0) {
                i8 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
            }
            i9 = i8;
            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i9 & 1171) != 1170, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function28 = function25;
                textFieldColors2 = textFieldColors;
                function29 = function26;
                function210 = function27;
                function211 = function24;
                paddingValues2 = paddingValues;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "685@32888L17");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    boolean z5 = i14 != 0 ? false : z4;
                    Function2 function216 = i15 != 0 ? null : function26;
                    Function2 function217 = i16 != 0 ? null : function27;
                    Function2 function218 = i5 != 0 ? null : function24;
                    Function2 function219 = i7 != 0 ? null : function25;
                    if ((i3 & 2048) != 0) {
                        int i18 = (i9 >> 6) & 112;
                        i11 = i4;
                        i10 = i3;
                        textFieldColorsM3216textFieldColorsdx8h9Zs = m3216textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, i18, 2097151);
                        composerStartRestartGroup = composerStartRestartGroup;
                        i12 = i9 & (-113);
                    } else {
                        i10 = i3;
                        i11 = i4;
                        textFieldColorsM3216textFieldColorsdx8h9Zs = textFieldColors;
                        i12 = i9;
                    }
                    if ((i10 & 4096) != 0) {
                        if (function216 == null) {
                            paddingValuesM3206textFieldWithLabelPaddinga9UjIt4$default = m3207textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            textFieldDefaults = this;
                        } else {
                            paddingValuesM3206textFieldWithLabelPaddinga9UjIt4$default = m3206textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            textFieldDefaults = this;
                        }
                        i12 &= -897;
                        textFieldColors2 = textFieldColorsM3216textFieldColorsdx8h9Zs;
                        paddingValues2 = paddingValuesM3206textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        textFieldDefaults = this;
                        paddingValues2 = paddingValues;
                        textFieldColors2 = textFieldColorsM3216textFieldColorsdx8h9Zs;
                    }
                    z4 = z5;
                    function212 = function216;
                    function213 = function217;
                    function214 = function218;
                    function215 = function219;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 2048) != 0) {
                        i9 &= -113;
                    }
                    if ((i3 & 4096) != 0) {
                        i9 &= -897;
                    }
                    textFieldDefaults = this;
                    function214 = function24;
                    textFieldColors2 = textFieldColors;
                    i12 = i9;
                    i11 = i4;
                    function212 = function26;
                    function213 = function27;
                    function215 = function25;
                    paddingValues2 = paddingValues;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    i13 = i11;
                    ComposerKt.traceEventStart(-380568, i13, i12, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:693)");
                } else {
                    i13 = i11;
                }
                int i19 = i12 & 14;
                int i20 = i12 << 3;
                textFieldDefaults.TextFieldDecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function212, function213, function214, function215, textFieldDefaults.getTextFieldShape(composerStartRestartGroup, (i12 >> 9) & 14), textFieldColors2, paddingValues2, composerStartRestartGroup, i13 & 2147483646, i19 | (i20 & 896) | (i20 & 7168) | (i20 & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function28 = function215;
                function211 = function214;
                function210 = function213;
                function29 = function212;
            }
            final boolean z6 = z4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldDefaults.TextFieldDecorationBox$lambda$1(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z6, function29, function210, function211, function28, textFieldColors2, paddingValues2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i4 |= 805306368;
        i5 = i17;
        i6 = i3 & 1024;
        if (i6 == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        if ((i2 & 384) == 0) {
        }
        if ((i2 & 3072) == 0) {
        }
        i9 = i8;
        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i9 & 1171) != 1170, i4 & 1)) {
        }
        final boolean z62 = z4;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:209:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void TextFieldDecorationBox(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Shape shape, TextFieldColors textFieldColors, PaddingValues paddingValues, Composer composer, final int i, final int i2, int i3) {
        int i4;
        final boolean z4;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        Shape textFieldShape;
        Shape shape3;
        int i11;
        TextFieldColors textFieldColorsM3216textFieldColorsdx8h9Zs;
        PaddingValues paddingValuesM3207textFieldWithoutLabelPaddinga9UjIt4$default;
        Shape shape4;
        TextFieldColors textFieldColors3;
        boolean z5;
        int i12;
        int i13 = i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(2088762355);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldDecorationBox)N(value,innerTextField,enabled,singleLine,visualTransformation,interactionSource,isError,label,placeholder,leadingIcon,trailingIcon,shape,colors,contentPadding)551@25856L624:TextFieldDefaults.kt#jmzs0o");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        int i14 = 1024;
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(visualTransformation) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        int i15 = i13 & 64;
        if (i15 != 0) {
            i4 |= 1572864;
            z4 = z3;
        } else {
            z4 = z3;
            if ((i & 1572864) == 0) {
                i4 |= composerStartRestartGroup.changed(z4) ? 1048576 : 524288;
            }
        }
        int i16 = i13 & 128;
        if (i16 != 0) {
            i4 |= 12582912;
            function26 = function22;
        } else {
            function26 = function22;
            if ((i & 12582912) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
            }
        }
        int i17 = i13 & 256;
        if (i17 != 0) {
            i4 |= 100663296;
            function27 = function23;
        } else {
            function27 = function23;
            if ((i & 100663296) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function27) ? 67108864 : 33554432;
            }
        }
        int i18 = i13 & 512;
        if (i18 == 0) {
            if ((i & 805306368) == 0) {
                i5 = i18;
                i4 |= composerStartRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
            }
            i6 = i13 & 1024;
            if (i6 == 0) {
                i8 = i2 | 6;
                i7 = i6;
            } else if ((i2 & 6) == 0) {
                i7 = i6;
                i8 = i2 | (composerStartRestartGroup.changedInstance(function25) ? 4 : 2);
            } else {
                i7 = i6;
                i8 = i2;
            }
            if ((i2 & 48) == 0) {
                i8 |= ((i13 & 2048) == 0 && composerStartRestartGroup.changed(shape)) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                i8 |= ((i13 & 4096) == 0 && composerStartRestartGroup.changed(textFieldColors)) ? 256 : 128;
            }
            if ((i2 & 3072) == 0) {
                if ((i13 & 8192) == 0 && composerStartRestartGroup.changed(paddingValues)) {
                    i14 = 2048;
                }
                i8 |= i14;
            }
            if ((i2 & 24576) == 0) {
                i8 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
            }
            i9 = i8;
            if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i9 & 9363) != 9362, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function28 = function24;
                shape2 = shape;
                textFieldColors2 = textFieldColors;
                function29 = function26;
                function210 = function27;
                function211 = function25;
                paddingValues2 = paddingValues;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "542@25571L14,543@25621L17");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    boolean z6 = i15 != 0 ? false : z4;
                    Function2<? super Composer, ? super Integer, Unit> function212 = i16 != 0 ? null : function26;
                    Function2<? super Composer, ? super Integer, Unit> function213 = i17 != 0 ? null : function27;
                    Function2<? super Composer, ? super Integer, Unit> function214 = i5 != 0 ? null : function24;
                    Function2<? super Composer, ? super Integer, Unit> function215 = i7 != 0 ? null : function25;
                    if ((i13 & 2048) != 0) {
                        i10 = i9 & (-113);
                        textFieldShape = getTextFieldShape(composerStartRestartGroup, (i9 >> 12) & 14);
                    } else {
                        i10 = i9;
                        textFieldShape = shape;
                    }
                    if ((i13 & 4096) != 0) {
                        int i19 = i10;
                        shape3 = textFieldShape;
                        i11 = i4;
                        textFieldColorsM3216textFieldColorsdx8h9Zs = m3216textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i10 >> 9) & 112, 2097151);
                        composer2 = composerStartRestartGroup;
                        i9 = i19 & (-897);
                    } else {
                        shape3 = textFieldShape;
                        i9 = i10;
                        composer2 = composerStartRestartGroup;
                        i11 = i4;
                        textFieldColorsM3216textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    i13 = i3;
                    if ((i13 & 8192) != 0) {
                        i9 &= -7169;
                        shape4 = shape3;
                        paddingValuesM3207textFieldWithoutLabelPaddinga9UjIt4$default = function212 == null ? m3207textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null) : m3206textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    } else {
                        paddingValuesM3207textFieldWithoutLabelPaddinga9UjIt4$default = paddingValues;
                        shape4 = shape3;
                    }
                    textFieldColors3 = textFieldColorsM3216textFieldColorsdx8h9Zs;
                    z5 = z6;
                    function29 = function212;
                    function210 = function213;
                    function28 = function214;
                    function211 = function215;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i13 & 2048) != 0) {
                        i9 &= -113;
                    }
                    if ((i13 & 4096) != 0) {
                        i9 &= -897;
                    }
                    if ((i13 & 8192) != 0) {
                        i9 &= -7169;
                    }
                    function28 = function24;
                    shape4 = shape;
                    textFieldColors3 = textFieldColors;
                    paddingValuesM3207textFieldWithoutLabelPaddinga9UjIt4$default = paddingValues;
                    composer2 = composerStartRestartGroup;
                    i11 = i4;
                    function29 = function26;
                    function210 = function27;
                    function211 = function25;
                    z5 = z4;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    i12 = i11;
                    ComposerKt.traceEventStart(2088762355, i12, i9, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:550)");
                } else {
                    i12 = i11;
                }
                TextFieldType textFieldType = TextFieldType.Filled;
                int i20 = i12 << 3;
                int i21 = i12 >> 9;
                int i22 = (i20 & 896) | (i20 & 112) | 6 | ((i12 >> 3) & 7168) | (57344 & i21) | (458752 & i21) | (i21 & 3670016) | ((i9 << 21) & 29360128) | ((i12 << 15) & 234881024) | ((i12 << 21) & 1879048192);
                int i23 = ((i12 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i12 >> 12) & 112) | ((i9 >> 3) & 896);
                int i24 = i9 << 6;
                TextFieldImplKt.CommonDecorationBox(textFieldType, str, function2, visualTransformation, function29, function210, function28, function211, z2, z, z5, interactionSource, paddingValuesM3207textFieldWithoutLabelPaddinga9UjIt4$default, shape4, textFieldColors3, null, composer2, i22, i23 | (i24 & 7168) | (i24 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z5;
                paddingValues2 = paddingValuesM3207textFieldWithoutLabelPaddinga9UjIt4$default;
                shape2 = shape4;
                textFieldColors2 = textFieldColors3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final int i25 = i13;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TextFieldDefaults.TextFieldDecorationBox$lambda$0(this.f$0, str, function2, z, z2, visualTransformation, interactionSource, z4, function29, function210, function28, function211, shape2, textFieldColors2, paddingValues2, i, i2, i25, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i4 |= 805306368;
        i5 = i18;
        i6 = i13 & 1024;
        if (i6 == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        if ((i2 & 384) == 0) {
        }
        if ((i2 & 3072) == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        i9 = i8;
        if (composerStartRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i9 & 9363) != 9362, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m3209getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m3210getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m3211getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    public final Shape getOutlinedTextFieldShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1899109048, "C(<get-OutlinedTextFieldShape>)228@8634L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1899109048, i, -1, "androidx.compose.material.TextFieldDefaults.<get-OutlinedTextFieldShape> (TextFieldDefaults.kt:228)");
        }
        CornerBasedShape small = MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return small;
    }

    public final Shape getTextFieldShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1117199624, "C(<get-TextFieldShape>)221@8326L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1117199624, i, -1, "androidx.compose.material.TextFieldDefaults.<get-TextFieldShape> (TextFieldDefaults.kt:221)");
        }
        CornerBasedShape cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return cornerBasedShapeCopy$default;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m3212getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* JADX INFO: renamed from: indicatorLine-gv0btCI, reason: not valid java name */
    public final Modifier m3213indicatorLinegv0btCI(Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2) {
        final boolean z3;
        final boolean z4;
        final InteractionSource interactionSource2;
        final TextFieldColors textFieldColors2;
        final float f3;
        final float f4;
        Function1<InspectorInfo, Unit> noInspectorInfo;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            z3 = z;
            z4 = z2;
            interactionSource2 = interactionSource;
            textFieldColors2 = textFieldColors;
            f3 = f;
            f4 = f2;
            noInspectorInfo = new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    invoke2(inspectorInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("indicatorLine");
                    inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z3));
                    inspectorInfo.getProperties().set("isError", Boolean.valueOf(z4));
                    inspectorInfo.getProperties().set("interactionSource", interactionSource2);
                    inspectorInfo.getProperties().set("colors", textFieldColors2);
                    inspectorInfo.getProperties().set("focusedIndicatorLineThickness", Dp.m9112boximpl(f3));
                    inspectorInfo.getProperties().set("unfocusedIndicatorLineThickness", Dp.m9112boximpl(f4));
                }
            };
        } else {
            z3 = z;
            z4 = z2;
            interactionSource2 = interactionSource;
            textFieldColors2 = textFieldColors;
            f3 = f;
            f4 = f2;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final float f5 = f4;
        final float f6 = f3;
        final TextFieldColors textFieldColors3 = textFieldColors2;
        final InteractionSource interactionSource3 = interactionSource2;
        final boolean z5 = z4;
        final boolean z6 = z3;
        return ComposedModifierKt.composed(modifier, noInspectorInfo, new Function3() { // from class: androidx.compose.material.TextFieldDefaults$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldDefaults.indicatorLine_gv0btCI$lambda$1(z6, z5, interactionSource3, textFieldColors3, f6, f5, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        });
    }

    /* JADX INFO: renamed from: outlinedTextFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m3214outlinedTextFieldColorsdx8h9Zs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, Composer composer, int i, int i2, int i3, int i4) {
        long jM6324copywmQWz5c$default;
        long j22;
        long jM6324copywmQWz5c$default2;
        long j23;
        long jM6324copywmQWz5c$default3;
        long j24;
        long jM6324copywmQWz5c$default4;
        long j25;
        long jM6324copywmQWz5c$default5;
        ComposerKt.sourceInformationMarkerStart(composer, 1762667317, "C(outlinedTextFieldColors)N(textColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,backgroundColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,focusedBorderColor:c#ui.graphics.Color,unfocusedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,errorBorderColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,placeholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color)428@18205L7,428@18236L7,429@18309L8,431@18415L6,432@18479L6,433@18543L6,433@18584L4,435@18655L6,435@18698L8,436@18793L8,437@18852L6,438@18914L6,439@19043L8,441@19160L6,442@19291L8,443@19356L6,444@19419L6,444@19460L4,445@19518L6,445@19553L6,446@19636L8,447@19694L6,448@19756L6,448@19791L6,449@19877L8:TextFieldDefaults.kt#jmzs0o");
        if ((i4 & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long jM6335unboximpl = ((Color) objConsume).m6335unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM6324copywmQWz5c$default = Color.m6324copywmQWz5c$default(jM6335unboximpl, ((Number) objConsume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6324copywmQWz5c$default = j;
        }
        long jM6324copywmQWz5c$default6 = (i4 & 2) != 0 ? Color.m6324copywmQWz5c$default(jM6324copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM6360getTransparent0d7_KjU = (i4 & 4) != 0 ? Color.INSTANCE.m6360getTransparent0d7_KjU() : j3;
        long jM2983getPrimary0d7_KjU = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2983getPrimary0d7_KjU() : j4;
        long jM2977getError0d7_KjU = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2977getError0d7_KjU() : j5;
        long jM6324copywmQWz5c$default7 = (i4 & 32) != 0 ? Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2983getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM6324copywmQWz5c$default8 = (i4 & 64) != 0 ? Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2982getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if ((i4 & 128) != 0) {
            long j26 = jM6324copywmQWz5c$default8;
            j22 = j26;
            jM6324copywmQWz5c$default2 = Color.m6324copywmQWz5c$default(j26, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j22 = jM6324copywmQWz5c$default8;
            jM6324copywmQWz5c$default2 = j8;
        }
        long jM2977getError0d7_KjU2 = (i4 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2977getError0d7_KjU() : j9;
        long jM6324copywmQWz5c$default9 = (i4 & 512) != 0 ? Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2982getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if ((i4 & 1024) != 0) {
            long j27 = jM6324copywmQWz5c$default9;
            jM6324copywmQWz5c$default3 = Color.m6324copywmQWz5c$default(j27, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j23 = j27;
        } else {
            j23 = jM6324copywmQWz5c$default9;
            jM6324copywmQWz5c$default3 = j11;
        }
        long j28 = (i4 & 2048) != 0 ? j23 : j12;
        long jM6324copywmQWz5c$default10 = (i4 & 4096) != 0 ? Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2982getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        if ((i4 & 8192) != 0) {
            long j29 = jM6324copywmQWz5c$default10;
            jM6324copywmQWz5c$default4 = Color.m6324copywmQWz5c$default(j29, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j24 = j29;
        } else {
            j24 = jM6324copywmQWz5c$default10;
            jM6324copywmQWz5c$default4 = j14;
        }
        long jM2977getError0d7_KjU3 = (i4 & 16384) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2977getError0d7_KjU() : j15;
        long jM6324copywmQWz5c$default11 = (32768 & i4) != 0 ? Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2983getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long jM6324copywmQWz5c$default12 = (65536 & i4) != 0 ? Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2982getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        if ((131072 & i4) != 0) {
            long j30 = jM6324copywmQWz5c$default12;
            jM6324copywmQWz5c$default5 = Color.m6324copywmQWz5c$default(j30, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j25 = j30;
        } else {
            j25 = jM6324copywmQWz5c$default12;
            jM6324copywmQWz5c$default5 = j18;
        }
        long jM2977getError0d7_KjU4 = (262144 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2977getError0d7_KjU() : j19;
        long jM6324copywmQWz5c$default13 = (524288 & i4) != 0 ? Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2982getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j20;
        long jM6324copywmQWz5c$default14 = (i4 & 1048576) != 0 ? Color.m6324copywmQWz5c$default(jM6324copywmQWz5c$default13, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1762667317, i, i2, "androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:451)");
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(jM6324copywmQWz5c$default, jM6324copywmQWz5c$default6, jM2983getPrimary0d7_KjU, jM2977getError0d7_KjU, jM6324copywmQWz5c$default7, j22, jM2977getError0d7_KjU2, jM6324copywmQWz5c$default2, j23, jM6324copywmQWz5c$default3, j28, j24, jM6324copywmQWz5c$default4, jM2977getError0d7_KjU3, jM6360getTransparent0d7_KjU, jM6324copywmQWz5c$default11, j25, jM6324copywmQWz5c$default5, jM2977getError0d7_KjU4, jM6324copywmQWz5c$default13, jM6324copywmQWz5c$default14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTextFieldColors;
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m3215outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m2033PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: textFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m3216textFieldColorsdx8h9Zs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, Composer composer, int i, int i2, int i3, int i4) {
        long jM6324copywmQWz5c$default;
        long j22;
        long jM6324copywmQWz5c$default2;
        long j23;
        long jM6324copywmQWz5c$default3;
        long j24;
        long jM6324copywmQWz5c$default4;
        long j25;
        long jM6324copywmQWz5c$default5;
        ComposerKt.sourceInformationMarkerStart(composer, 231892599, "C(textFieldColors)N(textColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,backgroundColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,focusedIndicatorColor:c#ui.graphics.Color,unfocusedIndicatorColor:c#ui.graphics.Color,disabledIndicatorColor:c#ui.graphics.Color,errorIndicatorColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,placeholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color)374@14935L7,374@14966L7,375@15039L8,376@15097L6,377@15190L6,378@15254L6,379@15321L6,379@15362L4,381@15436L6,382@15588L8,383@15650L6,384@15712L6,385@15841L8,387@15958L6,388@16089L8,389@16154L6,390@16217L6,390@16258L4,391@16316L6,391@16351L6,392@16434L8,393@16492L6,394@16554L6,394@16589L6,395@16675L8:TextFieldDefaults.kt#jmzs0o");
        if ((i4 & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long jM6335unboximpl = ((Color) objConsume).m6335unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM6324copywmQWz5c$default = Color.m6324copywmQWz5c$default(jM6335unboximpl, ((Number) objConsume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM6324copywmQWz5c$default = j;
        }
        long jM6324copywmQWz5c$default6 = (i4 & 2) != 0 ? Color.m6324copywmQWz5c$default(jM6324copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM6324copywmQWz5c$default7 = (i4 & 4) != 0 ? Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2982getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM2983getPrimary0d7_KjU = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2983getPrimary0d7_KjU() : j4;
        long jM2977getError0d7_KjU = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2977getError0d7_KjU() : j5;
        long jM6324copywmQWz5c$default8 = (i4 & 32) != 0 ? Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2983getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM6324copywmQWz5c$default9 = (i4 & 64) != 0 ? Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2982getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if ((i4 & 128) != 0) {
            long j26 = jM6324copywmQWz5c$default9;
            j22 = j26;
            jM6324copywmQWz5c$default2 = Color.m6324copywmQWz5c$default(j26, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j22 = jM6324copywmQWz5c$default9;
            jM6324copywmQWz5c$default2 = j8;
        }
        long jM2977getError0d7_KjU2 = (i4 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2977getError0d7_KjU() : j9;
        long jM6324copywmQWz5c$default10 = (i4 & 512) != 0 ? Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2982getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if ((i4 & 1024) != 0) {
            long j27 = jM6324copywmQWz5c$default10;
            jM6324copywmQWz5c$default3 = Color.m6324copywmQWz5c$default(j27, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j23 = j27;
        } else {
            j23 = jM6324copywmQWz5c$default10;
            jM6324copywmQWz5c$default3 = j11;
        }
        long j28 = (i4 & 2048) != 0 ? j23 : j12;
        long jM6324copywmQWz5c$default11 = (i4 & 4096) != 0 ? Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2982getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        if ((i4 & 8192) != 0) {
            long j29 = jM6324copywmQWz5c$default11;
            jM6324copywmQWz5c$default4 = Color.m6324copywmQWz5c$default(j29, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j24 = j29;
        } else {
            j24 = jM6324copywmQWz5c$default11;
            jM6324copywmQWz5c$default4 = j14;
        }
        long jM2977getError0d7_KjU3 = (i4 & 16384) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2977getError0d7_KjU() : j15;
        long jM6324copywmQWz5c$default12 = (32768 & i4) != 0 ? Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2983getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long jM6324copywmQWz5c$default13 = (65536 & i4) != 0 ? Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2982getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        if ((131072 & i4) != 0) {
            long j30 = jM6324copywmQWz5c$default13;
            jM6324copywmQWz5c$default5 = Color.m6324copywmQWz5c$default(j30, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j25 = j30;
        } else {
            j25 = jM6324copywmQWz5c$default13;
            jM6324copywmQWz5c$default5 = j18;
        }
        long jM2977getError0d7_KjU4 = (262144 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2977getError0d7_KjU() : j19;
        long jM6324copywmQWz5c$default14 = (524288 & i4) != 0 ? Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2982getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j20;
        long jM6324copywmQWz5c$default15 = (i4 & 1048576) != 0 ? Color.m6324copywmQWz5c$default(jM6324copywmQWz5c$default14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(231892599, i, i2, "androidx.compose.material.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:397)");
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(jM6324copywmQWz5c$default, jM6324copywmQWz5c$default6, jM2983getPrimary0d7_KjU, jM2977getError0d7_KjU, jM6324copywmQWz5c$default8, j22, jM2977getError0d7_KjU2, jM6324copywmQWz5c$default2, j23, jM6324copywmQWz5c$default3, j28, j24, jM6324copywmQWz5c$default4, jM2977getError0d7_KjU3, jM6324copywmQWz5c$default7, jM6324copywmQWz5c$default12, j25, jM6324copywmQWz5c$default5, jM2977getError0d7_KjU4, jM6324copywmQWz5c$default14, jM6324copywmQWz5c$default15, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTextFieldColors;
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m3217textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m2033PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m3218textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m2033PaddingValuesa9UjIt4(start, top, end, bottom);
    }
}
