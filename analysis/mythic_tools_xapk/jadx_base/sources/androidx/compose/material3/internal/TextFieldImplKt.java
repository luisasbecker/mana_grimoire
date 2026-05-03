package androidx.compose.material3.internal;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MotionSchemeKt;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldKt;
import androidx.compose.material3.TextFieldLabelPosition;
import androidx.compose.material3.TextFieldLabelScope;
import androidx.compose.material3.Typography;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.material3.tokens.TypeScaleTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.media3.muxer.MuxerUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b&\u001a\u0099\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001a\u00020\n2\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\b¢\u0006\u0002\b\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010 \u001a2\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0003¢\u0006\u0004\b0\u00101\u001a*\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0003¢\u0006\u0004\b2\u00103\u001a\u001c\u00104\u001a\u000205*\u0002052\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u00106\u001a\u000207H\u0000\u001a\u001c\u00108\u001a\u000205*\u0002052\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0000\u001a\u001a\u0010=\u001a\u000205*\u0002052\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0007H\u0000\u001aÔ\u0001\u0010@\u001a\u00020\u00012\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020,2\u0006\u0010!\u001a\u00020\u00162\u0099\u0001\u0010/\u001a\u0094\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020H0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020,0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(L\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020,0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(M\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020H0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(N\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020H0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u00010F¢\u0006\u0002\b\bH\u0083\b¢\u0006\u0004\bP\u0010Q\u001aE\u0010R\u001a\b\u0012\u0004\u0012\u00020S0G2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010T\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010U\u001a\u00020?2\u0006\u0010V\u001a\u00020?H\u0001¢\u0006\u0004\bW\u0010X\u001a\r\u0010b\u001a\u00020?H\u0001¢\u0006\u0002\u0010c\u001a\r\u0010d\u001a\u00020?H\u0001¢\u0006\u0002\u0010c\"\u0018\u0010!\u001a\u00020\u0016*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0018\u0010$\u001a\u00020%*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'\"\u0018\u0010(\u001a\u00020%*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'\"\u000e\u0010Y\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010Z\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010[\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\\\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010]\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010^\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010_\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010`\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010a\u001a\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010e\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bf\u0010g\"\u0016\u0010i\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bj\u0010g\"\u0016\u0010k\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bl\u0010g\"\u0016\u0010m\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bn\u0010g\"\u0016\u0010o\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bp\u0010g\"\u0016\u0010q\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\br\u0010g\"\u0016\u0010s\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bt\u0010g\"\u0016\u0010u\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bv\u0010g¨\u0006w²\u0006\n\u0010x\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\n\u0010y\u001a\u00020\u0016X\u008a\u0084\u0002"}, d2 = {"CommonDecorationBox", "", "type", "Landroidx/compose/material3/internal/TextFieldType;", "visualText", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", Constants.ScionAnalytics.PARAM_LABEL, "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "Lkotlin/ExtensionFunctionType;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/TextFieldColors;", "container", "(Landroidx/compose/material3/internal/TextFieldType;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "showExpandedLabel", "getShowExpandedLabel", "(Landroidx/compose/material3/TextFieldLabelPosition;)Z", "minimizedAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "getMinimizedAlignment", "(Landroidx/compose/material3/TextFieldLabelPosition;)Landroidx/compose/ui/Alignment$Horizontal;", "expandedAlignment", "getExpandedAlignment", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", FirebaseAnalytics.Param.CONTENT, "Decoration-3J-VO9M", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Decoration-Iv8Zu3U", "(JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "defaultErrorSemantics", "Landroidx/compose/ui/Modifier;", "defaultErrorMessage", "", "textFieldBackground", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "shape", "Landroidx/compose/ui/graphics/Shape;", "textFieldLabelMinHeight", "minHeight", "Landroidx/compose/ui/unit/Dp;", "TextFieldTransitionScope", "inputState", "Landroidx/compose/material3/internal/InputPhase;", "focusedLabelTextStyleColor", "unfocusedLabelTextStyleColor", "labelColor", "Lkotlin/Function5;", "Landroidx/compose/runtime/State;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "prefixSuffixOpacity", "TextFieldTransitionScope-Jy8F4Js", "(Landroidx/compose/material3/internal/InputPhase;JJJZLkotlin/jvm/functions/Function7;Landroidx/compose/runtime/Composer;I)V", "animateBorderStrokeAsState", "Landroidx/compose/foundation/BorderStroke;", "focused", "focusedBorderThickness", "unfocusedBorderThickness", "animateBorderStrokeAsState-NuRrP5Q", "(ZZZLandroidx/compose/material3/TextFieldColors;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "TextFieldId", "PlaceholderId", "LabelId", "LeadingId", "TrailingId", "PrefixId", "SuffixId", "SupportingId", "ContainerId", "textFieldHorizontalIconPadding", "(Landroidx/compose/runtime/Composer;I)F", "minimizedLabelHalfHeight", "TextFieldPadding", "getTextFieldPadding", "()F", "F", "AboveLabelHorizontalPadding", "getAboveLabelHorizontalPadding", "AboveLabelBottomPadding", "getAboveLabelBottomPadding", "SupportingTopPadding", "getSupportingTopPadding", "PrefixSuffixTextPadding", "getPrefixSuffixTextPadding", "MinTextLineHeight", "getMinTextLineHeight", "MinFocusedLabelLineHeight", "getMinFocusedLabelLineHeight", "MinSupportingTextLineHeight", "getMinSupportingTextLineHeight", "material3", "showPlaceholder", "showPrefixSuffix"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldImplKt {
    public static final String ContainerId = "Container";
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    public static final String PlaceholderId = "Hint";
    public static final String PrefixId = "Prefix";
    public static final String SuffixId = "Suffix";
    public static final String SupportingId = "Supporting";
    public static final String TextFieldId = "TextField";
    public static final String TrailingId = "Trailing";
    private static final float TextFieldPadding = Dp.m9114constructorimpl(16.0f);
    private static final float AboveLabelHorizontalPadding = Dp.m9114constructorimpl(4.0f);
    private static final float AboveLabelBottomPadding = Dp.m9114constructorimpl(4.0f);
    private static final float SupportingTopPadding = Dp.m9114constructorimpl(4.0f);
    private static final float PrefixSuffixTextPadding = Dp.m9114constructorimpl(2.0f);
    private static final float MinTextLineHeight = Dp.m9114constructorimpl(24.0f);
    private static final float MinFocusedLabelLineHeight = Dp.m9114constructorimpl(16.0f);
    private static final float MinSupportingTextLineHeight = Dp.m9114constructorimpl(16.0f);

    /* JADX INFO: compiled from: TextFieldImpl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TextFieldType.values().length];
            try {
                iArr[TextFieldType.Filled.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextFieldType.Outlined.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[InputPhase.values().length];
            try {
                iArr2[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:196:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x05d2  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x05f9  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0603  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0673  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0697  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x06c6  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x06ef  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x06f7  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x06fe  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0744  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0757  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x077b  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x07d3  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x07e6  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x081f  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0840  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0853  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0887  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x08c0  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x08d0  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x08dd  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0911  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x093c  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x094a  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0975  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0a61  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0add  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CommonDecorationBox(final TextFieldType textFieldType, final CharSequence charSequence, final Function2<? super Composer, ? super Integer, Unit> function2, final TextFieldLabelPosition textFieldLabelPosition, final Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, final Function2<? super Composer, ? super Integer, Unit> function26, final Function2<? super Composer, ? super Integer, Unit> function27, final boolean z, final boolean z2, final boolean z3, final InteractionSource interactionSource, final PaddingValues paddingValues, final TextFieldColors textFieldColors, final Function2<? super Composer, ? super Integer, Unit> function28, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        TextFieldColors textFieldColors2;
        Composer composer2;
        boolean z4;
        int i6;
        float f;
        InputPhase inputPhase;
        int i7;
        float f2;
        InputPhase inputPhase2;
        long j;
        int i8;
        float f3;
        int i9;
        float f4;
        int i10;
        float f5;
        int i11;
        InputPhase inputPhase3;
        TextStyle textStyle;
        ColorSpace colorSpaceM6329getColorSpaceimpl;
        boolean zChanged;
        Object objRememberedValue;
        InputPhase inputPhase4;
        InputPhase inputPhase5;
        ColorSpace colorSpaceM6329getColorSpaceimpl2;
        boolean zChanged2;
        Object objRememberedValue2;
        int i12;
        Object objRememberedValue3;
        boolean z5;
        boolean z6;
        TextFieldColors textFieldColors3;
        State state;
        State state2;
        Composer composer3;
        boolean z7;
        int i13;
        String str;
        int i14;
        TextStyle textStyle2;
        final TextStyle textStyle3;
        final State state3;
        Object objRememberedValue4;
        final State state4;
        ComposableLambda composableLambda;
        Object objRememberedValue5;
        final State state5;
        State state6;
        ComposableLambda composableLambda2;
        ComposableLambda composableLambdaRememberComposableLambda;
        ComposableLambda composableLambdaRememberComposableLambda2;
        ComposableLambda composableLambda3;
        ComposableLambda composableLambda4;
        int i15;
        ComposableLambda composableLambdaRememberComposableLambda3;
        int i16;
        Composer composerStartRestartGroup = composer.startRestartGroup(546805032);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CommonDecorationBox)N(type,visualText,innerTextField,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,singleLine,enabled,isError,interactionSource,contentPadding,colors,container)99@4125L25,109@4463L10,116@4780L8045:TextFieldImpl.kt#mqatfk");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(textFieldType.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i4 = i3 | (composerStartRestartGroup.changedInstance(charSequence) ? 32 : 16);
        } else {
            i4 = i3;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(textFieldLabelPosition) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function23) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function25) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function26) ? 536870912 : 268435456;
        }
        int i17 = i4;
        if ((i2 & 6) == 0) {
            i5 = i2 | (composerStartRestartGroup.changedInstance(function27) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i5 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(interactionSource) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i5 |= composerStartRestartGroup.changed(paddingValues) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            textFieldColors2 = textFieldColors;
            i5 |= composerStartRestartGroup.changed(textFieldColors2) ? 1048576 : 524288;
        } else {
            textFieldColors2 = textFieldColors;
        }
        if ((i2 & 12582912) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function28) ? 8388608 : 4194304;
        }
        int i18 = i5;
        if (composerStartRestartGroup.shouldExecute(((i17 & 306783379) == 306783378 && (4793491 & i18) == 4793490) ? false : true, i17 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(546805032, i17, i18, "androidx.compose.material3.internal.CommonDecorationBox (TextFieldImpl.kt:98)");
            }
            boolean zBooleanValue = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i18 >> 12) & 14).getValue().booleanValue();
            InputPhase inputPhase6 = zBooleanValue ? InputPhase.Focused : charSequence.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            long jM4249labelColorXeAY9LY$material3 = textFieldColors2.m4249labelColorXeAY9LY$material3(z2, z3, zBooleanValue);
            Typography typography = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
            final TextStyle bodyLarge = typography.getBodyLarge();
            TextStyle bodySmall = typography.getBodySmall();
            boolean z8 = (Color.m6326equalsimpl0(bodyLarge.m8586getColor0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU()) && !Color.m6326equalsimpl0(bodySmall.m8586getColor0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU())) || (!Color.m6326equalsimpl0(bodyLarge.m8586getColor0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU()) && Color.m6326equalsimpl0(bodySmall.m8586getColor0d7_KjU(), Color.INSTANCE.m6361getUnspecified0d7_KjU()));
            long jM8586getColor0d7_KjU = bodySmall.m8586getColor0d7_KjU();
            if (z8 && jM8586getColor0d7_KjU == 16) {
                jM8586getColor0d7_KjU = jM4249labelColorXeAY9LY$material3;
            }
            long jM8586getColor0d7_KjU2 = bodyLarge.m8586getColor0d7_KjU();
            if (z8 && jM8586getColor0d7_KjU2 == 16) {
                jM8586getColor0d7_KjU2 = jM4249labelColorXeAY9LY$material3;
            }
            boolean z9 = function3 != null && getShowExpandedLabel(textFieldLabelPosition);
            long j2 = jM8586getColor0d7_KjU;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2132505973, "CC(TextFieldTransitionScope)N(inputState,focusedLabelTextStyleColor:c#ui.graphics.Color,unfocusedLabelTextStyleColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,showExpandedLabel,content)385@16247L59,388@16444L14,390@16502L300,398@16874L14,399@16959L14,401@17022L830,424@17903L347,435@18316L14,437@18380L288,449@18771L167,455@18944L150:TextFieldImpl.kt#mqatfk");
            Transition transitionUpdateTransition = TransitionKt.updateTransition(inputPhase6, "TextFieldInputState", composerStartRestartGroup, 48, 0);
            TextFieldImplKt$TextFieldTransitionScope$labelProgress$1 textFieldImplKt$TextFieldTransitionScope$labelProgress$1 = new TextFieldImplKt$TextFieldTransitionScope$labelProgress$1(MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            InputPhase inputPhase7 = (InputPhase) transitionUpdateTransition.getCurrentState();
            composerStartRestartGroup.startReplaceGroup(-1436405362);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
                z4 = z8;
                i6 = i17;
                ComposerKt.traceEventStart(-1436405362, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:391)");
            } else {
                z4 = z8;
                i6 = i17;
            }
            int i19 = WhenMappings.$EnumSwitchMapping$1[inputPhase7.ordinal()];
            float f6 = 1.0f;
            if (i19 == 1) {
                f = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                Float fValueOf = Float.valueOf(f);
                InputPhase inputPhase8 = (InputPhase) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceGroup(-1436405362);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    inputPhase = inputPhase8;
                    ComposerKt.traceEventStart(-1436405362, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:391)");
                } else {
                    inputPhase = inputPhase8;
                }
                i7 = WhenMappings.$EnumSwitchMapping$1[inputPhase.ordinal()];
                if (i7 == 1) {
                    f2 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    final State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f2), textFieldImplKt$TextFieldTransitionScope$labelProgress$1.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "LabelProgress", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                    TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 = new TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1(finiteAnimationSpecValue, MotionSchemeKt.value(MotionSchemeKeyTokens.SlowEffects, composerStartRestartGroup, 6));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                    InputPhase inputPhase9 = (InputPhase) transitionUpdateTransition.getCurrentState();
                    composerStartRestartGroup.startReplaceGroup(-1093194547);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                    if (ComposerKt.isTraceInProgress()) {
                        inputPhase2 = inputPhase9;
                        j = jM8586getColor0d7_KjU2;
                        ComposerKt.traceEventStart(-1093194547, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:416)");
                    } else {
                        inputPhase2 = inputPhase9;
                        j = jM8586getColor0d7_KjU2;
                    }
                    i8 = WhenMappings.$EnumSwitchMapping$1[inputPhase2.ordinal()];
                    if (i8 == 1) {
                        f3 = 1.0f;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Float fValueOf2 = Float.valueOf(f3);
                        InputPhase inputPhase10 = (InputPhase) transitionUpdateTransition.getTargetState();
                        composerStartRestartGroup.startReplaceGroup(-1093194547);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1093194547, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:416)");
                        }
                        i9 = WhenMappings.$EnumSwitchMapping$1[inputPhase10.ordinal()];
                        if (i9 == 1) {
                            f4 = 1.0f;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f4), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "PlaceholderOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 = new TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1(finiteAnimationSpecValue);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                            TwoWayConverter<Float, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                            InputPhase inputPhase11 = (InputPhase) transitionUpdateTransition.getCurrentState();
                            composerStartRestartGroup.startReplaceGroup(-1258455321);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1258455321, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:428)");
                            }
                            i10 = WhenMappings.$EnumSwitchMapping$1[inputPhase11.ordinal()];
                            if (i10 == 1) {
                                f5 = 1.0f;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                Float fValueOf3 = Float.valueOf(f5);
                                InputPhase inputPhase12 = (InputPhase) transitionUpdateTransition.getTargetState();
                                composerStartRestartGroup.startReplaceGroup(-1258455321);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1258455321, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:428)");
                                }
                                i11 = WhenMappings.$EnumSwitchMapping$1[inputPhase12.ordinal()];
                                if (i11 != 1) {
                                    if (i11 != 2) {
                                        if (i11 != 3) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                    } else if (z9) {
                                        f6 = 0.0f;
                                    }
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                State stateCreateTransitionAnimation3 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf3, Float.valueOf(f6), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter3, "PrefixSuffixOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                                TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 = new TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1(finiteAnimationSpecValue2);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
                                InputPhase inputPhase13 = (InputPhase) transitionUpdateTransition.getTargetState();
                                composerStartRestartGroup.startReplaceGroup(-12973394);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                if (ComposerKt.isTraceInProgress()) {
                                    inputPhase3 = inputPhase13;
                                    textStyle = bodySmall;
                                    ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
                                } else {
                                    inputPhase3 = inputPhase13;
                                    textStyle = bodySmall;
                                }
                                long j3 = WhenMappings.$EnumSwitchMapping$1[inputPhase3.ordinal()] == 1 ? j2 : j;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                colorSpaceM6329getColorSpaceimpl = Color.m6329getColorSpaceimpl(j3);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1918408359, "CC(remember):Transition.kt#9igjgp");
                                zChanged = composerStartRestartGroup.changed(colorSpaceM6329getColorSpaceimpl);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6329getColorSpaceimpl);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                TwoWayConverter twoWayConverter = (TwoWayConverter) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                                InputPhase inputPhase14 = (InputPhase) transitionUpdateTransition.getCurrentState();
                                composerStartRestartGroup.startReplaceGroup(-12973394);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                if (ComposerKt.isTraceInProgress()) {
                                    inputPhase4 = inputPhase14;
                                } else {
                                    inputPhase4 = inputPhase14;
                                    ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
                                }
                                long j4 = WhenMappings.$EnumSwitchMapping$1[inputPhase4.ordinal()] != 1 ? j2 : j;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                Color colorM6315boximpl = Color.m6315boximpl(j4);
                                InputPhase inputPhase15 = (InputPhase) transitionUpdateTransition.getTargetState();
                                composerStartRestartGroup.startReplaceGroup(-12973394);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                if (ComposerKt.isTraceInProgress()) {
                                    inputPhase5 = inputPhase15;
                                } else {
                                    inputPhase5 = inputPhase15;
                                    ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
                                }
                                if (WhenMappings.$EnumSwitchMapping$1[inputPhase5.ordinal()] == 1) {
                                    j = j2;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                final State stateCreateTransitionAnimation4 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6315boximpl, Color.m6315boximpl(j), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), twoWayConverter, "LabelTextStyleColor", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$1 = new TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1(finiteAnimationSpecValue2);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
                                composerStartRestartGroup.startReplaceGroup(-464752477);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                colorSpaceM6329getColorSpaceimpl2 = Color.m6329getColorSpaceimpl(jM4249labelColorXeAY9LY$material3);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1918408359, "CC(remember):Transition.kt#9igjgp");
                                zChanged2 = composerStartRestartGroup.changed(colorSpaceM6329getColorSpaceimpl2);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6329getColorSpaceimpl2);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                TwoWayConverter twoWayConverter2 = (TwoWayConverter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                                composerStartRestartGroup.startReplaceGroup(-464752477);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                Color colorM6315boximpl2 = Color.m6315boximpl(jM4249labelColorXeAY9LY$material3);
                                composerStartRestartGroup.startReplaceGroup(-464752477);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                if (ComposerKt.isTraceInProgress()) {
                                    i12 = 0;
                                } else {
                                    i12 = 0;
                                    ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                final State stateCreateTransitionAnimation5 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6315boximpl2, Color.m6315boximpl(jM4249labelColorXeAY9LY$material3), textFieldImplKt$TextFieldTransitionScope$labelContentColor$1.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, Integer.valueOf(i12)), twoWayConverter2, "LabelContentColor", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1891788529, "CN(labelProgress,labelTextStyleColor,labelContentColor,placeholderAlpha,prefixSuffixAlpha)130@5443L184,155@6570L107,172@7353L108:TextFieldImpl.kt#mqatfk");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 493157227, "CC(remember):TextFieldImpl.kt#9igjgp");
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new TextFieldLabelScope() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$labelScope$1$1
                                        @Override // androidx.compose.material3.TextFieldLabelScope
                                        public float getLabelMinimizedProgress() {
                                            return stateCreateTransitionAnimation.getValue().floatValue();
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                final TextFieldImplKt$CommonDecorationBox$3$labelScope$1$1 textFieldImplKt$CommonDecorationBox$3$labelScope$1$1 = (TextFieldImplKt$CommonDecorationBox$3$labelScope$1$1) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposableLambda composableLambdaRememberComposableLambda4 = null;
                                if (function3 != null) {
                                    composerStartRestartGroup.startReplaceGroup(-1891724857);
                                    composerStartRestartGroup.endReplaceGroup();
                                    z5 = z2;
                                    z6 = z3;
                                    textFieldColors3 = textFieldColors;
                                    composer3 = composerStartRestartGroup;
                                    state3 = stateCreateTransitionAnimation;
                                    state = stateCreateTransitionAnimation2;
                                    state2 = stateCreateTransitionAnimation3;
                                    textStyle2 = bodyLarge;
                                    textStyle3 = textStyle;
                                    z7 = zBooleanValue;
                                    i13 = i6;
                                    str = "CC(remember):TextFieldImpl.kt#9igjgp";
                                    i14 = 54;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-1891724856);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*138@5746L526");
                                    z5 = z2;
                                    z6 = z3;
                                    textFieldColors3 = textFieldColors;
                                    state = stateCreateTransitionAnimation2;
                                    state2 = stateCreateTransitionAnimation3;
                                    composer3 = composerStartRestartGroup;
                                    z7 = zBooleanValue;
                                    i13 = i6;
                                    str = "CC(remember):TextFieldImpl.kt#9igjgp";
                                    i14 = 54;
                                    final TextStyle textStyle4 = textStyle;
                                    final boolean z10 = z4;
                                    Function2<Composer, Integer, Unit> function29 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i20) {
                                            ComposerKt.sourceInformation(composer4, "C147@6232L22,147@6180L74:TextFieldImpl.kt#mqatfk");
                                            if (!composer4.shouldExecute((i20 & 3) != 2, i20 & 1)) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1076580032, i20, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:139)");
                                            }
                                            TextStyle textStyleLerp = TextStyleKt.lerp(bodyLarge, textStyle4, stateCreateTransitionAnimation.getValue().floatValue());
                                            boolean z11 = z10;
                                            State<Color> state7 = stateCreateTransitionAnimation4;
                                            if (z11) {
                                                textStyleLerp = TextStyle.m8569copyp1EtxEg$default(textStyleLerp, state7.getValue().m6335unboximpl(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                                            }
                                            TextStyle textStyle5 = textStyleLerp;
                                            long jM6335unboximpl = stateCreateTransitionAnimation5.getValue().m6335unboximpl();
                                            final Function3<TextFieldLabelScope, Composer, Integer, Unit> function32 = function3;
                                            final TextFieldImplKt$CommonDecorationBox$3$labelScope$1$1 textFieldImplKt$CommonDecorationBox$3$labelScope$1$12 = textFieldImplKt$CommonDecorationBox$3$labelScope$1$1;
                                            TextFieldImplKt.m4678Decoration3JVO9M(jM6335unboximpl, textStyle5, ComposableLambdaKt.rememberComposableLambda(1157484991, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1.1
                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i21) {
                                                    ComposerKt.sourceInformation(composer5, "C147@6245L7:TextFieldImpl.kt#mqatfk");
                                                    if (!composer5.shouldExecute((i21 & 3) != 2, i21 & 1)) {
                                                        composer5.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1157484991, i21, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:147)");
                                                    }
                                                    function32.invoke(textFieldImplKt$CommonDecorationBox$3$labelScope$1$12, composer5, 6);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composer4, 54), composer4, 384);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    };
                                    textStyle2 = bodyLarge;
                                    textStyle3 = textStyle4;
                                    state3 = stateCreateTransitionAnimation;
                                    composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-1076580032, true, function29, composer3, 54);
                                    composer3.endReplaceGroup();
                                }
                                ComposableLambda composableLambda5 = composableLambdaRememberComposableLambda4;
                                long jM4251placeholderColorXeAY9LY$material3 = textFieldColors3.m4251placeholderColorXeAY9LY$material3(z5, z6, z7);
                                ComposerKt.sourceInformationMarkerStart(composer3, 493193214, str);
                                objRememberedValue4 = composer3.rememberedValue();
                                if (objRememberedValue4 != Composer.INSTANCE.getEmpty()) {
                                    state4 = state;
                                    objRememberedValue4 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Boolean.valueOf(TextFieldImplKt.CommonDecorationBox$lambda$18$lambda$7$lambda$6(state4));
                                        }
                                    });
                                    composer3.updateRememberedValue(objRememberedValue4);
                                } else {
                                    state4 = state;
                                }
                                State state7 = (State) objRememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                if (function22 == null && charSequence.length() == 0 && CommonDecorationBox$lambda$18$lambda$8(state7)) {
                                    composer3.startReplaceGroup(-1890614312);
                                    ComposerKt.sourceInformation(composer3, "160@6858L363");
                                    ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(1405547205, true, new TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1(state4, jM4251placeholderColorXeAY9LY$material3, textStyle2, function22), composer3, i14);
                                    composer3.endReplaceGroup();
                                    composableLambda = composableLambdaRememberComposableLambda5;
                                } else {
                                    composer3.startReplaceGroup(-1890217110);
                                    composer3.endReplaceGroup();
                                    composableLambda = null;
                                }
                                long jM4252prefixColorXeAY9LY$material3 = textFieldColors3.m4252prefixColorXeAY9LY$material3(z5, z6, z7);
                                ComposerKt.sourceInformationMarkerStart(composer3, 493218271, str);
                                objRememberedValue5 = composer3.rememberedValue();
                                if (objRememberedValue5 != Composer.INSTANCE.getEmpty()) {
                                    state5 = state2;
                                    objRememberedValue5 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Boolean.valueOf(TextFieldImplKt.CommonDecorationBox$lambda$18$lambda$10$lambda$9(state5));
                                        }
                                    });
                                    composer3.updateRememberedValue(objRememberedValue5);
                                } else {
                                    state5 = state2;
                                }
                                State state8 = (State) objRememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                if (function25 == null && CommonDecorationBox$lambda$18$lambda$11(state8)) {
                                    composer3.startReplaceGroup(-1889877907);
                                    ComposerKt.sourceInformation(composer3, "177@7601L342");
                                    state6 = state5;
                                    ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(606594655, true, new TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1(state6, jM4252prefixColorXeAY9LY$material3, textStyle2, function25), composer3, i14);
                                    composer3.endReplaceGroup();
                                    composableLambda2 = composableLambdaRememberComposableLambda6;
                                } else {
                                    state6 = state5;
                                    composer3.startReplaceGroup(-1889500886);
                                    composer3.endReplaceGroup();
                                    composableLambda2 = null;
                                }
                                long jM4253suffixColorXeAY9LY$material3 = textFieldColors3.m4253suffixColorXeAY9LY$material3(z5, z6, z7);
                                if (function26 == null && CommonDecorationBox$lambda$18$lambda$11(state8)) {
                                    composer3.startReplaceGroup(-1889301555);
                                    ComposerKt.sourceInformation(composer3, "191@8182L342");
                                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-45078754, true, new TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1(state6, jM4253suffixColorXeAY9LY$material3, textStyle2, function26), composer3, i14);
                                    composer3.endReplaceGroup();
                                } else {
                                    composer3.startReplaceGroup(-1888924534);
                                    composer3.endReplaceGroup();
                                    composableLambdaRememberComposableLambda = null;
                                }
                                final long jM4250leadingIconColorXeAY9LY$material3 = textFieldColors3.m4250leadingIconColorXeAY9LY$material3(z5, z6, z7);
                                if (function23 != null) {
                                    composer3.startReplaceGroup(-1888749663);
                                    composer3.endReplaceGroup();
                                    composableLambdaRememberComposableLambda2 = null;
                                } else {
                                    composer3.startReplaceGroup(-1888749662);
                                    ComposerKt.sourceInformation(composer3, "*205@8751L61");
                                    composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1736293487, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i20) {
                                            ComposerKt.sourceInformation(composer4, "C205@8753L57:TextFieldImpl.kt#mqatfk");
                                            if (!composer4.shouldExecute((i20 & 3) != 2, i20 & 1)) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1736293487, i20, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:205)");
                                            }
                                            TextFieldImplKt.m4679DecorationIv8Zu3U(jM4250leadingIconColorXeAY9LY$material3, function23, composer4, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer3, i14);
                                    composer3.endReplaceGroup();
                                }
                                final long jM4256trailingIconColorXeAY9LY$material3 = textFieldColors3.m4256trailingIconColorXeAY9LY$material3(z5, z6, z7);
                                if (function24 != null) {
                                    composer3.startReplaceGroup(-1888469888);
                                    composer3.endReplaceGroup();
                                    composableLambda3 = composableLambdaRememberComposableLambda2;
                                    composableLambda4 = null;
                                } else {
                                    composer3.startReplaceGroup(-1888469887);
                                    ComposerKt.sourceInformation(composer3, "*211@9033L62");
                                    composableLambda3 = composableLambdaRememberComposableLambda2;
                                    ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(1334518521, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i20) {
                                            ComposerKt.sourceInformation(composer4, "C211@9035L58:TextFieldImpl.kt#mqatfk");
                                            if (!composer4.shouldExecute((i20 & 3) != 2, i20 & 1)) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1334518521, i20, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:211)");
                                            }
                                            TextFieldImplKt.m4679DecorationIv8Zu3U(jM4256trailingIconColorXeAY9LY$material3, function24, composer4, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer3, 54);
                                    composer3.endReplaceGroup();
                                    composableLambda4 = composableLambdaRememberComposableLambda7;
                                }
                                final long jM4254supportingTextColorXeAY9LY$material3 = textFieldColors3.m4254supportingTextColorXeAY9LY$material3(z5, z6, z7);
                                if (function27 != null) {
                                    composer3.startReplaceGroup(-1888176380);
                                    composer3.endReplaceGroup();
                                    composableLambdaRememberComposableLambda3 = null;
                                    i15 = 1;
                                } else {
                                    composer3.startReplaceGroup(-1888176379);
                                    ComposerKt.sourceInformation(composer3, "*217@9324L218");
                                    Function2<Composer, Integer, Unit> function210 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i20) {
                                            ComposerKt.sourceInformation(composer4, "C218@9346L178:TextFieldImpl.kt#mqatfk");
                                            if (!composer4.shouldExecute((i20 & 3) != 2, i20 & 1)) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(837168720, i20, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:218)");
                                            }
                                            TextFieldImplKt.m4678Decoration3JVO9M(jM4254supportingTextColorXeAY9LY$material3, textStyle3, function27, composer4, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    };
                                    i15 = 1;
                                    composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(837168720, true, function210, composer3, 54);
                                    composer3.endReplaceGroup();
                                }
                                i16 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                                if (i16 != i15) {
                                    Composer composer4 = composer3;
                                    composer4.startReplaceGroup(-1887830698);
                                    ComposerKt.sourceInformation(composer4, "228@9680L167,234@9865L722");
                                    TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function2, composableLambda5, composableLambda, composableLambda3, composableLambda4, composableLambda2, composableLambdaRememberComposableLambda, z, textFieldLabelPosition, new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(new PropertyReference0Impl(state3) { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$1
                                        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                                        public Object get() {
                                            return ((State) this.receiver).getValue();
                                        }
                                    }), ComposableLambdaKt.rememberComposableLambda(-1729858187, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                            invoke(composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer5, int i20) {
                                            ComposerKt.sourceInformation(composer5, "C229@9702L127:TextFieldImpl.kt#mqatfk");
                                            if (!composer5.shouldExecute((i20 & 3) != 2, i20 & 1)) {
                                                composer5.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1729858187, i20, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:229)");
                                            }
                                            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId);
                                            Function2<Composer, Integer, Unit> function211 = function28;
                                            ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                            ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, modifierLayoutId);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer5.startReusableNode();
                                            if (composer5.getInserting()) {
                                                composer5.createNode(constructor);
                                            } else {
                                                composer5.useNode();
                                            }
                                            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer5);
                                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer5, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer5, 2113149629, "C230@9796L11:TextFieldImpl.kt#mqatfk");
                                            function211.invoke(composer5, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            composer5.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer4, 54), composableLambdaRememberComposableLambda3, paddingValues, composer4, ((i13 >> 3) & 112) | 6 | ((i18 << 21) & 234881024) | ((i13 << 18) & 1879048192), ((i18 >> 6) & 7168) | 48);
                                    composer2 = composer4;
                                    composer2.endReplaceGroup();
                                    Unit unit = Unit.INSTANCE;
                                } else {
                                    if (i16 != 2) {
                                        Composer composer5 = composer3;
                                        composer5.startReplaceGroup(493292232);
                                        composer5.endReplaceGroup();
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    composer3.startReplaceGroup(-1886778186);
                                    ComposerKt.sourceInformation(composer3, "253@10710L38,254@10817L517,279@11893L667,268@11352L1443");
                                    ComposerKt.sourceInformationMarkerStart(composer3, 493325625, str);
                                    Object objRememberedValue6 = composer3.rememberedValue();
                                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m6137boximpl(Size.INSTANCE.m6158getZeroNHjbRc()), null, 2, null);
                                        composer3.updateRememberedValue(objRememberedValue6);
                                    }
                                    final MutableState mutableState = (MutableState) objRememberedValue6;
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposableLambda composableLambda6 = composableLambdaRememberComposableLambda3;
                                    ComposableLambda composableLambda7 = composableLambdaRememberComposableLambda;
                                    ComposableLambda composableLambdaRememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(528115858, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                            invoke(composer6, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer6, int i20) {
                                            ComposerKt.sourceInformation(composer6, "C255@10839L477:TextFieldImpl.kt#mqatfk");
                                            if (!composer6.shouldExecute((i20 & 3) != 2, i20 & 1)) {
                                                composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(528115858, i20, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:255)");
                                            }
                                            Modifier modifierOutlineCutout = OutlinedTextFieldKt.outlineCutout(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId), new MutablePropertyReference0Impl(mutableState) { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1.1
                                                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                                                public Object get() {
                                                    return ((MutableState) this.receiver).getValue();
                                                }

                                                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                                                public void set(Object obj) {
                                                    ((MutableState) this.receiver).setValue(obj);
                                                }
                                            }, TextFieldImplKt.getMinimizedAlignment(textFieldLabelPosition), paddingValues);
                                            Function2<Composer, Integer, Unit> function211 = function28;
                                            ComposerKt.sourceInformationMarkerStart(composer6, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                            ComposerKt.sourceInformationMarkerStart(composer6, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer6, modifierOutlineCutout);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer6, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                            if (!(composer6.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer6.startReusableNode();
                                            if (composer6.getInserting()) {
                                                composer6.createNode(constructor);
                                            } else {
                                                composer6.useNode();
                                            }
                                            Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composer6);
                                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer6, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer6, 1233755264, "C264@11283L11:TextFieldImpl.kt#mqatfk");
                                            function211.invoke(composer6, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            composer6.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer3, 54);
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 = new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(new PropertyReference0Impl(state3) { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$2
                                        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                                        public Object get() {
                                            return ((State) this.receiver).getValue();
                                        }
                                    });
                                    Modifier.Companion companion2 = companion;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 493364110, str);
                                    int i20 = i13;
                                    boolean zChanged3 = ((i20 & 7168) == 2048) | composer3.changed(state3);
                                    Object objRememberedValue7 = composer3.rememberedValue();
                                    if (zChanged3 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue7 = new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda4
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return TextFieldImplKt.CommonDecorationBox$lambda$18$lambda$17$lambda$16(textFieldLabelPosition, state3, mutableState, (Size) obj);
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue7);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    OutlinedTextFieldKt.OutlinedTextFieldLayout(companion2, function2, composableLambda, composableLambda5, composableLambda3, composableLambda4, composableLambda2, composableLambda7, z, textFieldLabelPosition, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, (Function1) objRememberedValue7, composableLambdaRememberComposableLambda8, composableLambda6, paddingValues, composer3, ((i20 >> 3) & 112) | 6 | ((i18 << 21) & 234881024) | ((i20 << 18) & 1879048192), (57344 & (i18 >> 3)) | 384);
                                    Composer composer6 = composer3;
                                    composer6.endReplaceGroup();
                                    Unit unit2 = Unit.INSTANCE;
                                    composer2 = composer6;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            } else {
                                if (i10 == 2) {
                                    if (z9) {
                                        f5 = 0.0f;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    Float fValueOf32 = Float.valueOf(f5);
                                    InputPhase inputPhase122 = (InputPhase) transitionUpdateTransition.getTargetState();
                                    composerStartRestartGroup.startReplaceGroup(-1258455321);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    i11 = WhenMappings.$EnumSwitchMapping$1[inputPhase122.ordinal()];
                                    if (i11 != 1) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    State stateCreateTransitionAnimation32 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf32, Float.valueOf(f6), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter3, "PrefixSuffixOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    FiniteAnimationSpec finiteAnimationSpecValue22 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                                    TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$12 = new TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1(finiteAnimationSpecValue22);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
                                    InputPhase inputPhase132 = (InputPhase) transitionUpdateTransition.getTargetState();
                                    composerStartRestartGroup.startReplaceGroup(-12973394);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    if (WhenMappings.$EnumSwitchMapping$1[inputPhase3.ordinal()] == 1) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    colorSpaceM6329getColorSpaceimpl = Color.m6329getColorSpaceimpl(j3);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1918408359, "CC(remember):Transition.kt#9igjgp");
                                    zChanged = composerStartRestartGroup.changed(colorSpaceM6329getColorSpaceimpl);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (zChanged) {
                                        objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6329getColorSpaceimpl);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        TwoWayConverter twoWayConverter3 = (TwoWayConverter) objRememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                                        InputPhase inputPhase142 = (InputPhase) transitionUpdateTransition.getCurrentState();
                                        composerStartRestartGroup.startReplaceGroup(-12973394);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        if (WhenMappings.$EnumSwitchMapping$1[inputPhase4.ordinal()] != 1) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        composerStartRestartGroup.endReplaceGroup();
                                        Color colorM6315boximpl3 = Color.m6315boximpl(j4);
                                        InputPhase inputPhase152 = (InputPhase) transitionUpdateTransition.getTargetState();
                                        composerStartRestartGroup.startReplaceGroup(-12973394);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        if (WhenMappings.$EnumSwitchMapping$1[inputPhase5.ordinal()] == 1) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        composerStartRestartGroup.endReplaceGroup();
                                        final State<Color> stateCreateTransitionAnimation42 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6315boximpl3, Color.m6315boximpl(j), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$12.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), twoWayConverter3, "LabelTextStyleColor", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$12 = new TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1(finiteAnimationSpecValue22);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
                                        composerStartRestartGroup.startReplaceGroup(-464752477);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        composerStartRestartGroup.endReplaceGroup();
                                        colorSpaceM6329getColorSpaceimpl2 = Color.m6329getColorSpaceimpl(jM4249labelColorXeAY9LY$material3);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1918408359, "CC(remember):Transition.kt#9igjgp");
                                        zChanged2 = composerStartRestartGroup.changed(colorSpaceM6329getColorSpaceimpl2);
                                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                        if (!zChanged2) {
                                            objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6329getColorSpaceimpl2);
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                            TwoWayConverter twoWayConverter22 = (TwoWayConverter) objRememberedValue2;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                                            composerStartRestartGroup.startReplaceGroup(-464752477);
                                            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            composerStartRestartGroup.endReplaceGroup();
                                            Color colorM6315boximpl22 = Color.m6315boximpl(jM4249labelColorXeAY9LY$material3);
                                            composerStartRestartGroup.startReplaceGroup(-464752477);
                                            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            composerStartRestartGroup.endReplaceGroup();
                                            final State<Color> stateCreateTransitionAnimation52 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6315boximpl22, Color.m6315boximpl(jM4249labelColorXeAY9LY$material3), textFieldImplKt$TextFieldTransitionScope$labelContentColor$12.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, Integer.valueOf(i12)), twoWayConverter22, "LabelContentColor", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1891788529, "CN(labelProgress,labelTextStyleColor,labelContentColor,placeholderAlpha,prefixSuffixAlpha)130@5443L184,155@6570L107,172@7353L108:TextFieldImpl.kt#mqatfk");
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 493157227, "CC(remember):TextFieldImpl.kt#9igjgp");
                                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            }
                                            final TextFieldImplKt$CommonDecorationBox$3$labelScope$1$1 textFieldImplKt$CommonDecorationBox$3$labelScope$1$12 = (TextFieldImplKt$CommonDecorationBox$3$labelScope$1$1) objRememberedValue3;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            ComposableLambda composableLambdaRememberComposableLambda42 = null;
                                            if (function3 != null) {
                                            }
                                            ComposableLambda composableLambda52 = composableLambdaRememberComposableLambda42;
                                            long jM4251placeholderColorXeAY9LY$material32 = textFieldColors3.m4251placeholderColorXeAY9LY$material3(z5, z6, z7);
                                            ComposerKt.sourceInformationMarkerStart(composer3, 493193214, str);
                                            objRememberedValue4 = composer3.rememberedValue();
                                            if (objRememberedValue4 != Composer.INSTANCE.getEmpty()) {
                                            }
                                            State state72 = (State) objRememberedValue4;
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            if (function22 == null) {
                                                composer3.startReplaceGroup(-1890217110);
                                                composer3.endReplaceGroup();
                                                composableLambda = null;
                                                long jM4252prefixColorXeAY9LY$material32 = textFieldColors3.m4252prefixColorXeAY9LY$material3(z5, z6, z7);
                                                ComposerKt.sourceInformationMarkerStart(composer3, 493218271, str);
                                                objRememberedValue5 = composer3.rememberedValue();
                                                if (objRememberedValue5 != Composer.INSTANCE.getEmpty()) {
                                                }
                                                State state82 = (State) objRememberedValue5;
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                if (function25 == null) {
                                                    state6 = state5;
                                                    composer3.startReplaceGroup(-1889500886);
                                                    composer3.endReplaceGroup();
                                                    composableLambda2 = null;
                                                    long jM4253suffixColorXeAY9LY$material32 = textFieldColors3.m4253suffixColorXeAY9LY$material3(z5, z6, z7);
                                                    if (function26 == null) {
                                                        composer3.startReplaceGroup(-1888924534);
                                                        composer3.endReplaceGroup();
                                                        composableLambdaRememberComposableLambda = null;
                                                        final long jM4250leadingIconColorXeAY9LY$material32 = textFieldColors3.m4250leadingIconColorXeAY9LY$material3(z5, z6, z7);
                                                        if (function23 != null) {
                                                        }
                                                        final long jM4256trailingIconColorXeAY9LY$material32 = textFieldColors3.m4256trailingIconColorXeAY9LY$material3(z5, z6, z7);
                                                        if (function24 != null) {
                                                        }
                                                        final long jM4254supportingTextColorXeAY9LY$material32 = textFieldColors3.m4254supportingTextColorXeAY9LY$material3(z5, z6, z7);
                                                        if (function27 != null) {
                                                        }
                                                        i16 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                                                        if (i16 != i15) {
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else if (i10 != 3) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                f5 = 1.0f;
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                Float fValueOf322 = Float.valueOf(f5);
                                InputPhase inputPhase1222 = (InputPhase) transitionUpdateTransition.getTargetState();
                                composerStartRestartGroup.startReplaceGroup(-1258455321);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                i11 = WhenMappings.$EnumSwitchMapping$1[inputPhase1222.ordinal()];
                                if (i11 != 1) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                State stateCreateTransitionAnimation322 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf322, Float.valueOf(f6), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter3, "PrefixSuffixOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                FiniteAnimationSpec finiteAnimationSpecValue222 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                                TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$122 = new TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1(finiteAnimationSpecValue222);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
                                InputPhase inputPhase1322 = (InputPhase) transitionUpdateTransition.getTargetState();
                                composerStartRestartGroup.startReplaceGroup(-12973394);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                if (WhenMappings.$EnumSwitchMapping$1[inputPhase3.ordinal()] == 1) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                colorSpaceM6329getColorSpaceimpl = Color.m6329getColorSpaceimpl(j3);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1918408359, "CC(remember):Transition.kt#9igjgp");
                                zChanged = composerStartRestartGroup.changed(colorSpaceM6329getColorSpaceimpl);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (zChanged) {
                                }
                            }
                        } else {
                            if (i9 == 2) {
                                if (z9) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                State stateCreateTransitionAnimation22 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f4), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "PlaceholderOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$12 = new TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1(finiteAnimationSpecValue);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                                TwoWayConverter<Float, AnimationVector1D> vectorConverter32 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                                InputPhase inputPhase112 = (InputPhase) transitionUpdateTransition.getCurrentState();
                                composerStartRestartGroup.startReplaceGroup(-1258455321);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                i10 = WhenMappings.$EnumSwitchMapping$1[inputPhase112.ordinal()];
                                if (i10 == 1) {
                                }
                            } else if (i9 != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            f4 = 0.0f;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            State stateCreateTransitionAnimation222 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f4), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "PlaceholderOpacity", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$122 = new TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1(finiteAnimationSpecValue);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                            TwoWayConverter<Float, AnimationVector1D> vectorConverter322 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                            InputPhase inputPhase1122 = (InputPhase) transitionUpdateTransition.getCurrentState();
                            composerStartRestartGroup.startReplaceGroup(-1258455321);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            i10 = WhenMappings.$EnumSwitchMapping$1[inputPhase1122.ordinal()];
                            if (i10 == 1) {
                            }
                        }
                    } else {
                        if (i8 == 2) {
                            if (z9) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            Float fValueOf22 = Float.valueOf(f3);
                            InputPhase inputPhase102 = (InputPhase) transitionUpdateTransition.getTargetState();
                            composerStartRestartGroup.startReplaceGroup(-1093194547);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            i9 = WhenMappings.$EnumSwitchMapping$1[inputPhase102.ordinal()];
                            if (i9 == 1) {
                            }
                        } else if (i8 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        f3 = 0.0f;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Float fValueOf222 = Float.valueOf(f3);
                        InputPhase inputPhase1022 = (InputPhase) transitionUpdateTransition.getTargetState();
                        composerStartRestartGroup.startReplaceGroup(-1093194547);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        i9 = WhenMappings.$EnumSwitchMapping$1[inputPhase1022.ordinal()];
                        if (i9 == 1) {
                        }
                    }
                } else {
                    if (i7 == 2) {
                        if (z9) {
                            f2 = 0.0f;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        final State<Float> stateCreateTransitionAnimation6 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f2), textFieldImplKt$TextFieldTransitionScope$labelProgress$1.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "LabelProgress", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        FiniteAnimationSpec finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                        TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$12 = new TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1(finiteAnimationSpecValue3, MotionSchemeKt.value(MotionSchemeKeyTokens.SlowEffects, composerStartRestartGroup, 6));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                        TwoWayConverter<Float, AnimationVector1D> vectorConverter22 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                        InputPhase inputPhase92 = (InputPhase) transitionUpdateTransition.getCurrentState();
                        composerStartRestartGroup.startReplaceGroup(-1093194547);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        i8 = WhenMappings.$EnumSwitchMapping$1[inputPhase2.ordinal()];
                        if (i8 == 1) {
                        }
                    } else if (i7 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    f2 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    final State<Float> stateCreateTransitionAnimation62 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f2), textFieldImplKt$TextFieldTransitionScope$labelProgress$1.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "LabelProgress", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FiniteAnimationSpec finiteAnimationSpecValue32 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                    TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$122 = new TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1(finiteAnimationSpecValue32, MotionSchemeKt.value(MotionSchemeKeyTokens.SlowEffects, composerStartRestartGroup, 6));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter222 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                    InputPhase inputPhase922 = (InputPhase) transitionUpdateTransition.getCurrentState();
                    composerStartRestartGroup.startReplaceGroup(-1093194547);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i8 = WhenMappings.$EnumSwitchMapping$1[inputPhase2.ordinal()];
                    if (i8 == 1) {
                    }
                }
            } else {
                if (i19 == 2) {
                    if (z9) {
                        f = 0.0f;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Float fValueOf4 = Float.valueOf(f);
                    InputPhase inputPhase82 = (InputPhase) transitionUpdateTransition.getTargetState();
                    composerStartRestartGroup.startReplaceGroup(-1436405362);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i7 = WhenMappings.$EnumSwitchMapping$1[inputPhase.ordinal()];
                    if (i7 == 1) {
                    }
                } else if (i19 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f = 1.0f;
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.endReplaceGroup();
                Float fValueOf42 = Float.valueOf(f);
                InputPhase inputPhase822 = (InputPhase) transitionUpdateTransition.getTargetState();
                composerStartRestartGroup.startReplaceGroup(-1436405362);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                }
                i7 = WhenMappings.$EnumSwitchMapping$1[inputPhase.ordinal()];
                if (i7 == 1) {
                }
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.CommonDecorationBox$lambda$19(textFieldType, charSequence, function2, textFieldLabelPosition, function3, function22, function23, function24, function25, function26, function27, z, z2, z3, interactionSource, paddingValues, textFieldColors, function28, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final boolean CommonDecorationBox$lambda$18$lambda$10$lambda$9(State state) {
        return ((Number) state.getValue()).floatValue() > 0.0f;
    }

    private static final boolean CommonDecorationBox$lambda$18$lambda$11(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    static final Unit CommonDecorationBox$lambda$18$lambda$17$lambda$16(TextFieldLabelPosition textFieldLabelPosition, State state, MutableState mutableState, Size size) {
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Above) {
            return Unit.INSTANCE;
        }
        float fFloatValue = ((Number) state.getValue()).floatValue();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (size.m6154unboximpl() >> 32)) * fFloatValue;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (size.m6154unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) * fFloatValue;
        if (Float.intBitsToFloat((int) (((Size) mutableState.getValue()).m6154unboximpl() >> 32)) != fIntBitsToFloat || Float.intBitsToFloat((int) (((Size) mutableState.getValue()).m6154unboximpl() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) != fIntBitsToFloat2) {
            mutableState.setValue(Size.m6137boximpl(Size.m6140constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE))));
        }
        return Unit.INSTANCE;
    }

    static final boolean CommonDecorationBox$lambda$18$lambda$7$lambda$6(State state) {
        return ((Number) state.getValue()).floatValue() > 0.0f;
    }

    private static final boolean CommonDecorationBox$lambda$18$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    static final Unit CommonDecorationBox$lambda$19(TextFieldType textFieldType, CharSequence charSequence, Function2 function2, TextFieldLabelPosition textFieldLabelPosition, Function3 function3, Function2 function22, Function2 function23, Function2 function24, Function2 function25, Function2 function26, Function2 function27, boolean z, boolean z2, boolean z3, InteractionSource interactionSource, PaddingValues paddingValues, TextFieldColors textFieldColors, Function2 function28, int i, int i2, Composer composer, int i3) {
        CommonDecorationBox(textFieldType, charSequence, function2, textFieldLabelPosition, function3, function22, function23, function24, function25, function26, function27, z, z2, z3, interactionSource, paddingValues, textFieldColors, function28, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Decoration-3J-VO9M, reason: not valid java name */
    public static final void m4678Decoration3JVO9M(long j, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        final TextStyle textStyle2;
        final long j2;
        Composer composerStartRestartGroup = composer.startRestartGroup(396611577);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Decoration)N(contentColor:c#ui.graphics.Color,textStyle,content)325@13794L62:TextFieldImpl.kt#mqatfk");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(396611577, i2, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:325)");
            }
            ProvideContentColorTextStyleKt.m4595ProvideContentColorTextStyle3JVO9M(j, textStyle, function2, composerStartRestartGroup, i2 & 1022);
            j2 = j;
            textStyle2 = textStyle;
            function22 = function2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function22 = function2;
            textStyle2 = textStyle;
            j2 = j;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.Decoration_3J_VO9M$lambda$20(j2, textStyle2, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Decoration-Iv8Zu3U, reason: not valid java name */
    public static final void m4679DecorationIv8Zu3U(final long j, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(590397809);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Decoration)N(contentColor:c#ui.graphics.Color,content)330@14001L84:TextFieldImpl.kt#mqatfk");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(590397809, i2, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:330)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6315boximpl(j)), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextFieldImplKt.Decoration_Iv8Zu3U$lambda$21(j, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit Decoration_3J_VO9M$lambda$20(long j, TextStyle textStyle, Function2 function2, int i, Composer composer, int i2) {
        m4678Decoration3JVO9M(j, textStyle, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit Decoration_Iv8Zu3U$lambda$21(long j, Function2 function2, int i, Composer composer, int i2) {
        m4679DecorationIv8Zu3U(j, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0240  */
    /* JADX INFO: renamed from: TextFieldTransitionScope-Jy8F4Js, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m4680TextFieldTransitionScopeJy8F4Js(InputPhase inputPhase, long j, long j2, long j3, boolean z, Function7<? super State<Float>, ? super State<Color>, ? super State<Color>, ? super State<Float>, ? super State<Float>, ? super Composer, ? super Integer, Unit> function7, Composer composer, int i) {
        float f;
        float f2;
        int i2;
        float f3;
        int i3;
        float f4;
        int i4;
        float f5;
        int i5;
        ColorSpace colorSpaceM6329getColorSpaceimpl;
        boolean zChanged;
        Object objRememberedValue;
        ColorSpace colorSpaceM6329getColorSpaceimpl2;
        boolean zChanged2;
        Object objRememberedValue2;
        ComposerKt.sourceInformationMarkerStart(composer, -2132505973, "CC(TextFieldTransitionScope)N(inputState,focusedLabelTextStyleColor:c#ui.graphics.Color,unfocusedLabelTextStyleColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,showExpandedLabel,content)385@16247L59,388@16444L14,390@16502L300,398@16874L14,399@16959L14,401@17022L830,424@17903L347,435@18316L14,437@18380L288,449@18771L167,455@18944L150:TextFieldImpl.kt#mqatfk");
        Transition transitionUpdateTransition = TransitionKt.updateTransition(inputPhase, "TextFieldInputState", composer, (i & 14) | 48, 0);
        TextFieldImplKt$TextFieldTransitionScope$labelProgress$1 textFieldImplKt$TextFieldTransitionScope$labelProgress$1 = new TextFieldImplKt$TextFieldTransitionScope$labelProgress$1(MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer, 6));
        ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
        InputPhase inputPhase2 = (InputPhase) transitionUpdateTransition.getCurrentState();
        composer.startReplaceGroup(-1436405362);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1436405362, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:391)");
        }
        int i6 = WhenMappings.$EnumSwitchMapping$1[inputPhase2.ordinal()];
        float f6 = 0.0f;
        if (i6 == 1) {
            f = 1.0f;
        } else {
            if (i6 != 2) {
                if (i6 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (z) {
                f = 0.0f;
            }
            f = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf = Float.valueOf(f);
        InputPhase inputPhase3 = (InputPhase) transitionUpdateTransition.getTargetState();
        composer.startReplaceGroup(-1436405362);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1436405362, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:391)");
        }
        int i7 = WhenMappings.$EnumSwitchMapping$1[inputPhase3.ordinal()];
        if (i7 == 1) {
            f2 = 1.0f;
        } else {
            if (i7 != 2) {
                if (i7 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (z) {
                f2 = 0.0f;
            }
            f2 = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f2), textFieldImplKt$TextFieldTransitionScope$labelProgress$1.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter, "LabelProgress", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
        TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 = new TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1(finiteAnimationSpecValue, MotionSchemeKt.value(MotionSchemeKeyTokens.SlowEffects, composer, 6));
        ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
        InputPhase inputPhase4 = (InputPhase) transitionUpdateTransition.getCurrentState();
        composer.startReplaceGroup(-1093194547);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1093194547, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:416)");
        }
        int i8 = WhenMappings.$EnumSwitchMapping$1[inputPhase4.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                i2 = 3;
                if (z) {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                Float fValueOf2 = Float.valueOf(f3);
                InputPhase inputPhase5 = (InputPhase) transitionUpdateTransition.getTargetState();
                composer.startReplaceGroup(-1093194547);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1093194547, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:416)");
                }
                i3 = WhenMappings.$EnumSwitchMapping$1[inputPhase5.ordinal()];
                if (i3 == 1) {
                    f4 = 1.0f;
                } else {
                    if (i3 != 2) {
                        if (i3 != i2) {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else if (z) {
                    }
                    f4 = 0.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f4), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter2, "PlaceholderOpacity", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 = new TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1(finiteAnimationSpecValue);
                ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                InputPhase inputPhase6 = (InputPhase) transitionUpdateTransition.getCurrentState();
                composer.startReplaceGroup(-1258455321);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1258455321, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:428)");
                }
                i4 = WhenMappings.$EnumSwitchMapping$1[inputPhase6.ordinal()];
                if (i4 == 1) {
                    f5 = 1.0f;
                } else {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else if (z) {
                        f5 = 0.0f;
                    }
                    f5 = 1.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                Float fValueOf3 = Float.valueOf(f5);
                InputPhase inputPhase7 = (InputPhase) transitionUpdateTransition.getTargetState();
                composer.startReplaceGroup(-1258455321);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1258455321, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:428)");
                }
                i5 = WhenMappings.$EnumSwitchMapping$1[inputPhase7.ordinal()];
                if (i5 == 1) {
                    f6 = 1.0f;
                } else {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else if (!z) {
                    }
                    f6 = 1.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                State stateCreateTransitionAnimation3 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf3, Float.valueOf(f6), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter3, "PrefixSuffixOpacity", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
                TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 = new TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1(finiteAnimationSpecValue2);
                ComposerKt.sourceInformationMarkerStart(composer, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
                InputPhase inputPhase8 = (InputPhase) transitionUpdateTransition.getTargetState();
                composer.startReplaceGroup(-12973394);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
                }
                long j4 = WhenMappings.$EnumSwitchMapping$1[inputPhase8.ordinal()] == 1 ? j : j2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                colorSpaceM6329getColorSpaceimpl = Color.m6329getColorSpaceimpl(j4);
                ComposerKt.sourceInformationMarkerStart(composer, 1918408359, "CC(remember):Transition.kt#9igjgp");
                zChanged = composer.changed(colorSpaceM6329getColorSpaceimpl);
                objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6329getColorSpaceimpl);
                    composer.updateRememberedValue(objRememberedValue);
                }
                TwoWayConverter twoWayConverter = (TwoWayConverter) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                InputPhase inputPhase9 = (InputPhase) transitionUpdateTransition.getCurrentState();
                composer.startReplaceGroup(-12973394);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
                }
                long j5 = WhenMappings.$EnumSwitchMapping$1[inputPhase9.ordinal()] == 1 ? j : j2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                Color colorM6315boximpl = Color.m6315boximpl(j5);
                InputPhase inputPhase10 = (InputPhase) transitionUpdateTransition.getTargetState();
                composer.startReplaceGroup(-12973394);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-12973394, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
                }
                long j6 = WhenMappings.$EnumSwitchMapping$1[inputPhase10.ordinal()] == 1 ? j : j2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                State stateCreateTransitionAnimation4 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6315boximpl, Color.m6315boximpl(j6), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1.invoke(transitionUpdateTransition.getSegment(), composer, 0), twoWayConverter, "LabelTextStyleColor", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$1 = new TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1(finiteAnimationSpecValue2);
                ComposerKt.sourceInformationMarkerStart(composer, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
                composer.startReplaceGroup(-464752477);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                colorSpaceM6329getColorSpaceimpl2 = Color.m6329getColorSpaceimpl(j3);
                ComposerKt.sourceInformationMarkerStart(composer, 1918408359, "CC(remember):Transition.kt#9igjgp");
                zChanged2 = composer.changed(colorSpaceM6329getColorSpaceimpl2);
                objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6329getColorSpaceimpl2);
                    composer.updateRememberedValue(objRememberedValue2);
                }
                TwoWayConverter twoWayConverter2 = (TwoWayConverter) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
                composer.startReplaceGroup(-464752477);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                Color colorM6315boximpl2 = Color.m6315boximpl(j3);
                composer.startReplaceGroup(-464752477);
                ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-464752477, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                State stateCreateTransitionAnimation5 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6315boximpl2, Color.m6315boximpl(j3), textFieldImplKt$TextFieldTransitionScope$labelContentColor$1.invoke(transitionUpdateTransition.getSegment(), composer, 0), twoWayConverter2, "LabelContentColor", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                function7.invoke(stateCreateTransitionAnimation, stateCreateTransitionAnimation4, stateCreateTransitionAnimation5, stateCreateTransitionAnimation2, stateCreateTransitionAnimation3, composer, Integer.valueOf(i & 458752));
                ComposerKt.sourceInformationMarkerEnd(composer);
            }
            i2 = 3;
            if (i8 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            f3 = 0.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            composer.endReplaceGroup();
            Float fValueOf22 = Float.valueOf(f3);
            InputPhase inputPhase52 = (InputPhase) transitionUpdateTransition.getTargetState();
            composer.startReplaceGroup(-1093194547);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
            }
            i3 = WhenMappings.$EnumSwitchMapping$1[inputPhase52.ordinal()];
            if (i3 == 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composer.endReplaceGroup();
            State stateCreateTransitionAnimation22 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf22, Float.valueOf(f4), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter2, "PlaceholderOpacity", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$12 = new TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1(finiteAnimationSpecValue);
            ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter32 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            InputPhase inputPhase62 = (InputPhase) transitionUpdateTransition.getCurrentState();
            composer.startReplaceGroup(-1258455321);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
            }
            i4 = WhenMappings.$EnumSwitchMapping$1[inputPhase62.ordinal()];
            if (i4 == 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composer.endReplaceGroup();
            Float fValueOf32 = Float.valueOf(f5);
            InputPhase inputPhase72 = (InputPhase) transitionUpdateTransition.getTargetState();
            composer.startReplaceGroup(-1258455321);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
            }
            i5 = WhenMappings.$EnumSwitchMapping$1[inputPhase72.ordinal()];
            if (i5 == 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composer.endReplaceGroup();
            State stateCreateTransitionAnimation32 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf32, Float.valueOf(f6), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$12.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter32, "PrefixSuffixOpacity", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            FiniteAnimationSpec finiteAnimationSpecValue22 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
            TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$12 = new TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1(finiteAnimationSpecValue22);
            ComposerKt.sourceInformationMarkerStart(composer, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
            InputPhase inputPhase82 = (InputPhase) transitionUpdateTransition.getTargetState();
            composer.startReplaceGroup(-12973394);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
            }
            if (WhenMappings.$EnumSwitchMapping$1[inputPhase82.ordinal()] == 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composer.endReplaceGroup();
            colorSpaceM6329getColorSpaceimpl = Color.m6329getColorSpaceimpl(j4);
            ComposerKt.sourceInformationMarkerStart(composer, 1918408359, "CC(remember):Transition.kt#9igjgp");
            zChanged = composer.changed(colorSpaceM6329getColorSpaceimpl);
            objRememberedValue = composer.rememberedValue();
            if (zChanged) {
                objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6329getColorSpaceimpl);
                composer.updateRememberedValue(objRememberedValue);
            }
            TwoWayConverter twoWayConverter3 = (TwoWayConverter) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            InputPhase inputPhase92 = (InputPhase) transitionUpdateTransition.getCurrentState();
            composer.startReplaceGroup(-12973394);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
            }
            if (WhenMappings.$EnumSwitchMapping$1[inputPhase92.ordinal()] == 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composer.endReplaceGroup();
            Color colorM6315boximpl3 = Color.m6315boximpl(j5);
            InputPhase inputPhase102 = (InputPhase) transitionUpdateTransition.getTargetState();
            composer.startReplaceGroup(-12973394);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
            }
            if (WhenMappings.$EnumSwitchMapping$1[inputPhase102.ordinal()] == 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composer.endReplaceGroup();
            State stateCreateTransitionAnimation42 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6315boximpl3, Color.m6315boximpl(j6), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$12.invoke(transitionUpdateTransition.getSegment(), composer, 0), twoWayConverter3, "LabelTextStyleColor", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$12 = new TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1(finiteAnimationSpecValue22);
            ComposerKt.sourceInformationMarkerStart(composer, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
            composer.startReplaceGroup(-464752477);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composer.endReplaceGroup();
            colorSpaceM6329getColorSpaceimpl2 = Color.m6329getColorSpaceimpl(j3);
            ComposerKt.sourceInformationMarkerStart(composer, 1918408359, "CC(remember):Transition.kt#9igjgp");
            zChanged2 = composer.changed(colorSpaceM6329getColorSpaceimpl2);
            objRememberedValue2 = composer.rememberedValue();
            if (zChanged2) {
                objRememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6329getColorSpaceimpl2);
                composer.updateRememberedValue(objRememberedValue2);
            }
            TwoWayConverter twoWayConverter22 = (TwoWayConverter) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            composer.startReplaceGroup(-464752477);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composer.endReplaceGroup();
            Color colorM6315boximpl22 = Color.m6315boximpl(j3);
            composer.startReplaceGroup(-464752477);
            ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
            if (ComposerKt.isTraceInProgress()) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composer.endReplaceGroup();
            State stateCreateTransitionAnimation52 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6315boximpl22, Color.m6315boximpl(j3), textFieldImplKt$TextFieldTransitionScope$labelContentColor$12.invoke(transitionUpdateTransition.getSegment(), composer, 0), twoWayConverter22, "LabelContentColor", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            function7.invoke(stateCreateTransitionAnimation, stateCreateTransitionAnimation42, stateCreateTransitionAnimation52, stateCreateTransitionAnimation22, stateCreateTransitionAnimation32, composer, Integer.valueOf(i & 458752));
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        i2 = 3;
        f3 = 1.0f;
        if (ComposerKt.isTraceInProgress()) {
        }
        composer.endReplaceGroup();
        Float fValueOf222 = Float.valueOf(f3);
        InputPhase inputPhase522 = (InputPhase) transitionUpdateTransition.getTargetState();
        composer.startReplaceGroup(-1093194547);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
        }
        i3 = WhenMappings.$EnumSwitchMapping$1[inputPhase522.ordinal()];
        if (i3 == 1) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        composer.endReplaceGroup();
        State stateCreateTransitionAnimation222 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf222, Float.valueOf(f4), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter2, "PlaceholderOpacity", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$122 = new TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1(finiteAnimationSpecValue);
        ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter322 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
        InputPhase inputPhase622 = (InputPhase) transitionUpdateTransition.getCurrentState();
        composer.startReplaceGroup(-1258455321);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
        }
        i4 = WhenMappings.$EnumSwitchMapping$1[inputPhase622.ordinal()];
        if (i4 == 1) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        composer.endReplaceGroup();
        Float fValueOf322 = Float.valueOf(f5);
        InputPhase inputPhase722 = (InputPhase) transitionUpdateTransition.getTargetState();
        composer.startReplaceGroup(-1258455321);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
        }
        i5 = WhenMappings.$EnumSwitchMapping$1[inputPhase722.ordinal()];
        if (i5 == 1) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        composer.endReplaceGroup();
        State stateCreateTransitionAnimation322 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf322, Float.valueOf(f6), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$122.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter322, "PrefixSuffixOpacity", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        FiniteAnimationSpec finiteAnimationSpecValue222 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
        TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$122 = new TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1(finiteAnimationSpecValue222);
        ComposerKt.sourceInformationMarkerStart(composer, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
        InputPhase inputPhase822 = (InputPhase) transitionUpdateTransition.getTargetState();
        composer.startReplaceGroup(-12973394);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
        }
        if (WhenMappings.$EnumSwitchMapping$1[inputPhase822.ordinal()] == 1) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        composer.endReplaceGroup();
        colorSpaceM6329getColorSpaceimpl = Color.m6329getColorSpaceimpl(j4);
        ComposerKt.sourceInformationMarkerStart(composer, 1918408359, "CC(remember):Transition.kt#9igjgp");
        zChanged = composer.changed(colorSpaceM6329getColorSpaceimpl);
        objRememberedValue = composer.rememberedValue();
        if (zChanged) {
        }
        TwoWayConverter twoWayConverter32 = (TwoWayConverter) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
        InputPhase inputPhase922 = (InputPhase) transitionUpdateTransition.getCurrentState();
        composer.startReplaceGroup(-12973394);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
        }
        if (WhenMappings.$EnumSwitchMapping$1[inputPhase922.ordinal()] == 1) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        composer.endReplaceGroup();
        Color colorM6315boximpl32 = Color.m6315boximpl(j5);
        InputPhase inputPhase1022 = (InputPhase) transitionUpdateTransition.getTargetState();
        composer.startReplaceGroup(-12973394);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
        }
        if (WhenMappings.$EnumSwitchMapping$1[inputPhase1022.ordinal()] == 1) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        composer.endReplaceGroup();
        State stateCreateTransitionAnimation422 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6315boximpl32, Color.m6315boximpl(j6), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$122.invoke(transitionUpdateTransition.getSegment(), composer, 0), twoWayConverter32, "LabelTextStyleColor", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$122 = new TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1(finiteAnimationSpecValue222);
        ComposerKt.sourceInformationMarkerStart(composer, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
        composer.startReplaceGroup(-464752477);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        composer.endReplaceGroup();
        colorSpaceM6329getColorSpaceimpl2 = Color.m6329getColorSpaceimpl(j3);
        ComposerKt.sourceInformationMarkerStart(composer, 1918408359, "CC(remember):Transition.kt#9igjgp");
        zChanged2 = composer.changed(colorSpaceM6329getColorSpaceimpl2);
        objRememberedValue2 = composer.rememberedValue();
        if (zChanged2) {
        }
        TwoWayConverter twoWayConverter222 = (TwoWayConverter) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
        composer.startReplaceGroup(-464752477);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        composer.endReplaceGroup();
        Color colorM6315boximpl222 = Color.m6315boximpl(j3);
        composer.startReplaceGroup(-464752477);
        ComposerKt.sourceInformation(composer, "CN(it):TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        composer.endReplaceGroup();
        State stateCreateTransitionAnimation522 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6315boximpl222, Color.m6315boximpl(j3), textFieldImplKt$TextFieldTransitionScope$labelContentColor$122.invoke(transitionUpdateTransition.getSegment(), composer, 0), twoWayConverter222, "LabelContentColor", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        function7.invoke(stateCreateTransitionAnimation, stateCreateTransitionAnimation422, stateCreateTransitionAnimation522, stateCreateTransitionAnimation222, stateCreateTransitionAnimation322, composer, Integer.valueOf(i & 458752));
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: renamed from: animateBorderStrokeAsState-NuRrP5Q, reason: not valid java name */
    public static final State<BorderStroke> m4683animateBorderStrokeAsStateNuRrP5Q(boolean z, boolean z2, boolean z3, TextFieldColors textFieldColors, float f, float f2, Composer composer, int i) {
        State<Color> stateRememberUpdatedState;
        State<Dp> stateRememberUpdatedState2;
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, 2047013045, "C(animateBorderStrokeAsState)N(enabled,isError,focused,colors,focusedBorderThickness:c#ui.unit.Dp,unfocusedBorderThickness:c#ui.unit.Dp)475@19543L14,483@19812L11,492@20135L73:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2047013045, i, -1, "androidx.compose.material3.internal.animateBorderStrokeAsState (TextFieldImpl.kt:472)");
        }
        long jM4248indicatorColorXeAY9LY$material3 = textFieldColors.m4248indicatorColorXeAY9LY$material3(z, z2, z3);
        FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer2, 6);
        if (z) {
            composer2.startReplaceGroup(-1674507999);
            ComposerKt.sourceInformation(composer2, "478@19618L52");
            stateRememberUpdatedState = SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(jM4248indicatorColorXeAY9LY$material3, finiteAnimationSpecValue, null, null, composer, 0, 12);
            composer2 = composer;
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(-1674427244);
            ComposerKt.sourceInformation(composer2, "480@19700L33");
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m6315boximpl(jM4248indicatorColorXeAY9LY$material3), composer2, 0);
            composer2.endReplaceGroup();
        }
        FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer2, 6);
        if (z) {
            composer2.startReplaceGroup(-1674245832);
            ComposerKt.sourceInformation(composer2, "487@19979L57");
            stateRememberUpdatedState2 = AnimateAsStateKt.m1380animateDpAsStateAjpBEmI(z3 ? f : f2, finiteAnimationSpecValue2, null, null, composer2, 0, 12);
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(-1674063769);
            ComposerKt.sourceInformation(composer2, "489@20066L46");
            stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Dp.m9112boximpl(f2), composer2, (i >> 15) & 14);
            composer2.endReplaceGroup();
        }
        State<BorderStroke> stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(BorderStrokeKt.m1509BorderStrokecXLIe8U(stateRememberUpdatedState2.getValue().m9128unboximpl(), stateRememberUpdatedState.getValue().m6335unboximpl()), composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return stateRememberUpdatedState3;
    }

    public static final Modifier defaultErrorSemantics(Modifier modifier, boolean z, final String str) {
        return z ? SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldImplKt.defaultErrorSemantics$lambda$22(str, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null) : modifier;
    }

    static final Unit defaultErrorSemantics$lambda$22(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.error(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    public static final float getAboveLabelBottomPadding() {
        return AboveLabelBottomPadding;
    }

    public static final float getAboveLabelHorizontalPadding() {
        return AboveLabelHorizontalPadding;
    }

    public static final Alignment.Horizontal getExpandedAlignment(TextFieldLabelPosition textFieldLabelPosition) {
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Above) {
            return ((TextFieldLabelPosition.Above) textFieldLabelPosition).getAlignment();
        }
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Attached) {
            return ((TextFieldLabelPosition.Attached) textFieldLabelPosition).getExpandedAlignment();
        }
        throw new IllegalArgumentException("Unknown position: " + textFieldLabelPosition);
    }

    public static final float getMinFocusedLabelLineHeight() {
        return MinFocusedLabelLineHeight;
    }

    public static final float getMinSupportingTextLineHeight() {
        return MinSupportingTextLineHeight;
    }

    public static final float getMinTextLineHeight() {
        return MinTextLineHeight;
    }

    public static final Alignment.Horizontal getMinimizedAlignment(TextFieldLabelPosition textFieldLabelPosition) {
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Above) {
            return ((TextFieldLabelPosition.Above) textFieldLabelPosition).getAlignment();
        }
        if (textFieldLabelPosition instanceof TextFieldLabelPosition.Attached) {
            return ((TextFieldLabelPosition.Attached) textFieldLabelPosition).getMinimizedAlignment();
        }
        throw new IllegalArgumentException("Unknown position: " + textFieldLabelPosition);
    }

    public static final float getPrefixSuffixTextPadding() {
        return PrefixSuffixTextPadding;
    }

    private static final boolean getShowExpandedLabel(TextFieldLabelPosition textFieldLabelPosition) {
        return (textFieldLabelPosition instanceof TextFieldLabelPosition.Attached) && !((TextFieldLabelPosition.Attached) textFieldLabelPosition).getAlwaysMinimize();
    }

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float minimizedLabelHalfHeight(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1251545215, "C(minimizedLabelHalfHeight)528@21499L10,531@21709L7:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1251545215, i, -1, "androidx.compose.material3.internal.minimizedLabelHalfHeight (TextFieldImpl.kt:527)");
        }
        long jM8595getLineHeightXSAIIZE = MaterialTheme.INSTANCE.getTypography(composer, 6).getBodySmall().m8595getLineHeightXSAIIZE();
        long jM5433getBodySmallLineHeightXSAIIZE = TypeScaleTokens.INSTANCE.m5433getBodySmallLineHeightXSAIIZE();
        if (!TextUnit.m9311isSpimpl(jM8595getLineHeightXSAIIZE)) {
            jM8595getLineHeightXSAIIZE = jM5433getBodySmallLineHeightXSAIIZE;
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fM9114constructorimpl = Dp.m9114constructorimpl(((Density) objConsume).mo1619toDpGaN1DYA(jM8595getLineHeightXSAIIZE) / 2.0f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fM9114constructorimpl;
    }

    public static final Modifier textFieldBackground(Modifier modifier, final ColorProducer colorProducer, final Shape shape) {
        return DrawModifierKt.drawWithCache(modifier, new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldImplKt.textFieldBackground$lambda$24(shape, colorProducer, (CacheDrawScope) obj);
            }
        });
    }

    static final DrawResult textFieldBackground$lambda$24(Shape shape, final ColorProducer colorProducer, CacheDrawScope cacheDrawScope) {
        final Outline outlineMo1539createOutlinePq9zytI = shape.mo1539createOutlinePq9zytI(cacheDrawScope.m5860getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
        return cacheDrawScope.onDrawBehind(new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldImplKt.textFieldBackground$lambda$24$lambda$23(outlineMo1539createOutlinePq9zytI, colorProducer, (DrawScope) obj);
            }
        });
    }

    static final Unit textFieldBackground$lambda$24$lambda$23(Outline outline, ColorProducer colorProducer, DrawScope drawScope) {
        OutlineKt.m6598drawOutlinewDX37Ww$default(drawScope, outline, colorProducer.mo3015invoke0d7_KjU(), 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    public static final float textFieldHorizontalIconPadding(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1986450462, "C(textFieldHorizontalIconPadding)521@21199L7:TextFieldImpl.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1986450462, i, -1, "androidx.compose.material3.internal.textFieldHorizontalIconPadding (TextFieldImpl.kt:520)");
        }
        ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localMinimumInteractiveComponentSize);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fM9128unboximpl = ((Dp) objConsume).m9128unboximpl();
        if (Float.isNaN(fM9128unboximpl)) {
            fM9128unboximpl = Dp.m9114constructorimpl(0.0f);
        }
        float fM9114constructorimpl = Dp.m9114constructorimpl(RangesKt.coerceAtLeast(Dp.m9114constructorimpl(Dp.m9114constructorimpl(fM9128unboximpl - SmallIconButtonTokens.INSTANCE.m5324getIconSizeD9Ej5fM()) / 2.0f), Dp.m9114constructorimpl(0.0f)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fM9114constructorimpl;
    }

    public static final Modifier textFieldLabelMinHeight(Modifier modifier, final Function0<Dp> function0) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TextFieldImplKt.textFieldLabelMinHeight$lambda$26(function0, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        });
    }

    static final MeasureResult textFieldLabelMinHeight$lambda$26(Function0 function0, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        float fM9128unboximpl = ((Dp) function0.invoke()).m9128unboximpl();
        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(Constraints.m9057copyZbe2FdA$default(constraints.getValue(), 0, 0, ConstraintsKt.m9083constrainHeightK40F9xA(constraints.getValue(), !Dp.m9119equalsimpl0(fM9128unboximpl, Dp.INSTANCE.m9134getUnspecifiedD9Ej5fM()) ? measureScope.mo1618roundToPx0680j_4(fM9128unboximpl) : 0), 0, 11, null));
        return MeasureScope.layout$default(measureScope, placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldImplKt.textFieldLabelMinHeight$lambda$26$lambda$25(placeableMo7769measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit textFieldLabelMinHeight$lambda$26$lambda$25(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
