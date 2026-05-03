package androidx.compose.material;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Text.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÏ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0004\b\"\u0010#\u001aÃ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0004\b$\u0010%\u001aã\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0004\b*\u0010+\u001aÙ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0004\b\"\u0010,\u001a(\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020!2\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u000104¢\u0006\u0002\b5H\u0007¢\u0006\u0002\u00106\u001a\u0018\u00107\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020&2\u0006\u00108\u001a\u000209H\u0002\u001a\r\u0010:\u001a\u000209H\u0003¢\u0006\u0002\u0010;\"\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020!0.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006<"}, d2 = {"Text", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Landroidx/compose/ui/text/TextStyle;", "Text--4IGK_g", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "value", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "createTextWithLinkStyles", "linkStyles", "Landroidx/compose/ui/text/TextLinkStyles;", "rememberTextLinkStyles", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextLinkStyles;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.material.TextKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return TypographyKt.getDefaultTextStyle();
        }
    });

    public static final void ProvideTextStyle(final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-13499697);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProvideTextStyle)N(value,content)410@18449L7,411@18474L80:Text.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(textStyle) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-13499697, i2, -1, "androidx.compose.material.ProvideTextStyle (Text.kt:409)");
            }
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(((TextStyle) objConsume).merge(textStyle)), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextKt.ProvideTextStyle$lambda$0(textStyle, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ProvideTextStyle$lambda$0(TextStyle textStyle, Function2 function2, int i, Composer composer, int i2) {
        ProvideTextStyle(textStyle, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:261:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0137  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* JADX INFO: renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3230Text4IGK_g(final AnnotatedString annotatedString, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, Map map, Function1 function1, TextStyle textStyle, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        int i7;
        long jM6361getUnspecified0d7_KjU;
        int i8;
        int i9;
        long jM9319getUnspecifiedXSAIIZE;
        int i10;
        FontStyle fontStyle2;
        int i11;
        FontWeight fontWeight2;
        int i12;
        FontFamily fontFamily2;
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
        boolean z2;
        int i25;
        int i26;
        int i27;
        int i28;
        Composer composer2;
        final Modifier modifier2;
        final TextAlign textAlign2;
        final int i29;
        final int i30;
        final Map map2;
        final Function1 function12;
        final TextStyle textStyle2;
        final boolean z3;
        final long j5;
        final FontStyle fontStyle3;
        final long j6;
        final FontWeight fontWeight3;
        final FontFamily fontFamily3;
        final long j7;
        final TextDecoration textDecoration2;
        final long j8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z4;
        TextAlign textAlign3;
        Function1 function13;
        Function1 function14;
        TextAlign textAlign4;
        TextStyle textStyle3;
        int i31;
        long j9;
        Function1 function15;
        Map map3;
        Modifier modifier3;
        int i32;
        long j10;
        TextDecoration textDecoration3;
        long j11;
        FontWeight fontWeight4;
        FontFamily fontFamily4;
        long j12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-422393234);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Text)N(text,modifier,color:c#ui.graphics.Color,fontSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,textAlign:c#ui.text.style.TextAlign,lineHeight:c#ui.unit.TextUnit,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,inlineContent,onTextLayout,style)369@17148L346:Text.kt#jmzs0o");
        if ((i3 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(annotatedString) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        int i33 = i5 & 2;
        if (i33 != 0) {
            i6 |= 48;
        } else {
            if ((i3 & 48) == 0) {
                i6 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i8 = i6 | 384;
                jM6361getUnspecified0d7_KjU = j;
            } else {
                int i34 = i6;
                jM6361getUnspecified0d7_KjU = j;
                if ((i3 & 384) == 0) {
                    i34 |= composerStartRestartGroup.changed(jM6361getUnspecified0d7_KjU) ? 256 : 128;
                }
                i8 = i34;
            }
            i9 = i5 & 8;
            if (i9 == 0) {
                i8 |= 3072;
                jM9319getUnspecifiedXSAIIZE = j2;
            } else {
                jM9319getUnspecifiedXSAIIZE = j2;
                if ((i3 & 3072) == 0) {
                    i8 |= composerStartRestartGroup.changed(jM9319getUnspecifiedXSAIIZE) ? 2048 : 1024;
                }
            }
            i10 = i5 & 16;
            if (i10 == 0) {
                i8 |= 24576;
            } else {
                if ((i3 & 24576) == 0) {
                    fontStyle2 = fontStyle;
                    i8 |= composerStartRestartGroup.changed(fontStyle2) ? 16384 : 8192;
                }
                i11 = i5 & 32;
                if (i11 != 0) {
                    i8 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    fontWeight2 = fontWeight;
                } else {
                    fontWeight2 = fontWeight;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i8 |= composerStartRestartGroup.changed(fontWeight2) ? 131072 : 65536;
                    }
                }
                i12 = i5 & 64;
                if (i12 != 0) {
                    i8 |= 1572864;
                    fontFamily2 = fontFamily;
                } else {
                    fontFamily2 = fontFamily;
                    if ((i3 & 1572864) == 0) {
                        i8 |= composerStartRestartGroup.changed(fontFamily2) ? 1048576 : 524288;
                    }
                }
                i13 = i5 & 128;
                if (i13 != 0) {
                    i8 |= 12582912;
                } else {
                    if ((i3 & 12582912) == 0) {
                        i14 = i8 | (composerStartRestartGroup.changed(j3) ? 8388608 : 4194304);
                    }
                    i15 = i5 & 256;
                    if (i15 == 0) {
                        i14 |= 100663296;
                    } else {
                        if ((i3 & 100663296) == 0) {
                            i16 = i15;
                            i14 |= composerStartRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
                        }
                        i17 = i5 & 512;
                        if (i17 != 0) {
                            i14 |= 805306368;
                            i18 = i17;
                        } else if ((i3 & 805306368) == 0) {
                            i18 = i17;
                            i14 |= composerStartRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                        } else {
                            i18 = i17;
                        }
                        i19 = i14;
                        i20 = i5 & 1024;
                        if (i20 != 0) {
                            i21 = i4 | 6;
                        } else if ((i4 & 6) == 0) {
                            i21 = i4 | (composerStartRestartGroup.changed(j4) ? 4 : 2);
                        } else {
                            i21 = i4;
                        }
                        i22 = i5 & 2048;
                        if (i22 != 0) {
                            i21 |= 48;
                            i23 = i22;
                        } else if ((i4 & 48) == 0) {
                            i23 = i22;
                            i21 |= composerStartRestartGroup.changed(i) ? 32 : 16;
                        } else {
                            i23 = i22;
                        }
                        int i35 = i21;
                        i24 = i5 & 4096;
                        if (i24 != 0) {
                            i35 |= 384;
                        } else {
                            if ((i4 & 384) == 0) {
                                z2 = z;
                                i35 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                            }
                            i25 = i5 & 8192;
                            if (i25 == 0) {
                                i26 = i35 | 3072;
                            } else {
                                int i36 = i35;
                                if ((i4 & 3072) == 0) {
                                    i26 = i36 | (composerStartRestartGroup.changed(i2) ? 2048 : 1024);
                                } else {
                                    i26 = i36;
                                }
                            }
                            i27 = i5 & 16384;
                            if (i27 != 0) {
                                if ((i4 & 24576) == 0) {
                                    i26 |= composerStartRestartGroup.changedInstance(map) ? 16384 : 8192;
                                }
                                i28 = i5 & 32768;
                                if (i28 != 0) {
                                    i26 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i26 |= composerStartRestartGroup.changedInstance(function1) ? 131072 : 65536;
                                }
                                if ((i4 & 1572864) == 0) {
                                    i26 |= ((i5 & 65536) == 0 && composerStartRestartGroup.changed(textStyle)) ? 1048576 : 524288;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (599187 & i26) == 599186) ? false : true, i19 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "366@17089L2,367@17131L7");
                                    if ((i3 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        Modifier.Companion companion = i33 != 0 ? Modifier.INSTANCE : modifier;
                                        if (i7 != 0) {
                                            jM6361getUnspecified0d7_KjU = Color.INSTANCE.m6361getUnspecified0d7_KjU();
                                        }
                                        if (i9 != 0) {
                                            jM9319getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE();
                                        }
                                        if (i10 != 0) {
                                            fontStyle2 = null;
                                        }
                                        if (i11 != 0) {
                                            fontWeight2 = null;
                                        }
                                        if (i12 != 0) {
                                            fontFamily2 = null;
                                        }
                                        long jM9319getUnspecifiedXSAIIZE2 = i13 != 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j3;
                                        TextDecoration textDecoration4 = i16 != 0 ? null : textDecoration;
                                        TextAlign textAlign5 = i18 == 0 ? textAlign : null;
                                        long jM9319getUnspecifiedXSAIIZE3 = i20 != 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j4;
                                        int iM9049getClipgIe3tQ8 = i23 != 0 ? TextOverflow.INSTANCE.m9049getClipgIe3tQ8() : i;
                                        z4 = i24 == 0 ? z2 : true;
                                        int i37 = i25 != 0 ? Integer.MAX_VALUE : i2;
                                        Map mapEmptyMap = i27 != 0 ? MapsKt.emptyMap() : map;
                                        Modifier modifier4 = companion;
                                        if (i28 != 0) {
                                            textAlign3 = textAlign5;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2102016464, "CC(remember):Text.kt#9igjgp");
                                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue = new Function1() { // from class: androidx.compose.material.TextKt$$ExternalSyntheticLambda6
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj) {
                                                        return TextKt.Text__4IGK_g$lambda$2$0((TextLayoutResult) obj);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            function13 = (Function1) objRememberedValue;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        } else {
                                            textAlign3 = textAlign5;
                                            function13 = function1;
                                        }
                                        if ((i5 & 65536) != 0) {
                                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                            function14 = function13;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            i26 &= -3670017;
                                            textAlign4 = textAlign3;
                                            textStyle3 = (TextStyle) objConsume;
                                        } else {
                                            function14 = function13;
                                            textAlign4 = textAlign3;
                                            textStyle3 = textStyle;
                                        }
                                        i31 = iM9049getClipgIe3tQ8;
                                        j9 = jM9319getUnspecifiedXSAIIZE3;
                                        function15 = function14;
                                        map3 = mapEmptyMap;
                                        modifier3 = modifier4;
                                        long j13 = jM9319getUnspecifiedXSAIIZE2;
                                        i32 = i37;
                                        j10 = jM6361getUnspecified0d7_KjU;
                                        FontFamily fontFamily5 = fontFamily2;
                                        textDecoration3 = textDecoration4;
                                        j11 = jM9319getUnspecifiedXSAIIZE;
                                        fontWeight4 = fontWeight2;
                                        fontFamily4 = fontFamily5;
                                        j12 = j13;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i5 & 65536) != 0) {
                                            i26 &= -3670017;
                                        }
                                        modifier3 = modifier;
                                        textAlign4 = textAlign;
                                        j9 = j4;
                                        i31 = i;
                                        i32 = i2;
                                        map3 = map;
                                        function15 = function1;
                                        textStyle3 = textStyle;
                                        z4 = z2;
                                        j10 = jM6361getUnspecified0d7_KjU;
                                        j11 = jM9319getUnspecifiedXSAIIZE;
                                        fontWeight4 = fontWeight2;
                                        fontFamily4 = fontFamily2;
                                        j12 = j3;
                                        textDecoration3 = textDecoration;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-422393234, i19, i26, "androidx.compose.material.Text (Text.kt:368)");
                                    }
                                    int i38 = i26 << 3;
                                    composer2 = composerStartRestartGroup;
                                    m3232TextIbK3jfQ(annotatedString, modifier3, j10, j11, fontStyle2, fontWeight4, fontFamily4, j12, textDecoration3, textAlign4, j9, i31, z4, i32, 1, map3, function15, textStyle3, composer2, i19 & 2147483646, (i26 & 14) | 24576 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (458752 & i38) | (3670016 & i38) | (i38 & 29360128), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier3;
                                    j5 = j10;
                                    j6 = j11;
                                    fontStyle3 = fontStyle2;
                                    fontWeight3 = fontWeight4;
                                    fontFamily3 = fontFamily4;
                                    j7 = j12;
                                    textDecoration2 = textDecoration3;
                                    textAlign2 = textAlign4;
                                    j8 = j9;
                                    i29 = i31;
                                    z3 = z4;
                                    i30 = i32;
                                    map2 = map3;
                                    function12 = function15;
                                    textStyle2 = textStyle3;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    modifier2 = modifier;
                                    textAlign2 = textAlign;
                                    i29 = i;
                                    i30 = i2;
                                    map2 = map;
                                    function12 = function1;
                                    textStyle2 = textStyle;
                                    z3 = z2;
                                    j5 = jM6361getUnspecified0d7_KjU;
                                    fontStyle3 = fontStyle2;
                                    j6 = jM9319getUnspecifiedXSAIIZE;
                                    fontWeight3 = fontWeight2;
                                    fontFamily3 = fontFamily2;
                                    j7 = j3;
                                    textDecoration2 = textDecoration;
                                    j8 = j4;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextKt$$ExternalSyntheticLambda7
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return TextKt.Text__4IGK_g$lambda$3(annotatedString, modifier2, j5, j6, fontStyle3, fontWeight3, fontFamily3, j7, textDecoration2, textAlign2, j8, i29, z3, i30, map2, function12, textStyle2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i26 |= 24576;
                            i28 = i5 & 32768;
                            if (i28 != 0) {
                            }
                            if ((i4 & 1572864) == 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (599187 & i26) == 599186) ? false : true, i19 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        z2 = z;
                        i25 = i5 & 8192;
                        if (i25 == 0) {
                        }
                        i27 = i5 & 16384;
                        if (i27 != 0) {
                        }
                        i28 = i5 & 32768;
                        if (i28 != 0) {
                        }
                        if ((i4 & 1572864) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (599187 & i26) == 599186) ? false : true, i19 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i16 = i15;
                    i17 = i5 & 512;
                    if (i17 != 0) {
                    }
                    i19 = i14;
                    i20 = i5 & 1024;
                    if (i20 != 0) {
                    }
                    i22 = i5 & 2048;
                    if (i22 != 0) {
                    }
                    int i352 = i21;
                    i24 = i5 & 4096;
                    if (i24 != 0) {
                    }
                    z2 = z;
                    i25 = i5 & 8192;
                    if (i25 == 0) {
                    }
                    i27 = i5 & 16384;
                    if (i27 != 0) {
                    }
                    i28 = i5 & 32768;
                    if (i28 != 0) {
                    }
                    if ((i4 & 1572864) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (599187 & i26) == 599186) ? false : true, i19 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i14 = i8;
                i15 = i5 & 256;
                if (i15 == 0) {
                }
                i16 = i15;
                i17 = i5 & 512;
                if (i17 != 0) {
                }
                i19 = i14;
                i20 = i5 & 1024;
                if (i20 != 0) {
                }
                i22 = i5 & 2048;
                if (i22 != 0) {
                }
                int i3522 = i21;
                i24 = i5 & 4096;
                if (i24 != 0) {
                }
                z2 = z;
                i25 = i5 & 8192;
                if (i25 == 0) {
                }
                i27 = i5 & 16384;
                if (i27 != 0) {
                }
                i28 = i5 & 32768;
                if (i28 != 0) {
                }
                if ((i4 & 1572864) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (599187 & i26) == 599186) ? false : true, i19 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            fontStyle2 = fontStyle;
            i11 = i5 & 32;
            if (i11 != 0) {
            }
            i12 = i5 & 64;
            if (i12 != 0) {
            }
            i13 = i5 & 128;
            if (i13 != 0) {
            }
            i14 = i8;
            i15 = i5 & 256;
            if (i15 == 0) {
            }
            i16 = i15;
            i17 = i5 & 512;
            if (i17 != 0) {
            }
            i19 = i14;
            i20 = i5 & 1024;
            if (i20 != 0) {
            }
            i22 = i5 & 2048;
            if (i22 != 0) {
            }
            int i35222 = i21;
            i24 = i5 & 4096;
            if (i24 != 0) {
            }
            z2 = z;
            i25 = i5 & 8192;
            if (i25 == 0) {
            }
            i27 = i5 & 16384;
            if (i27 != 0) {
            }
            i28 = i5 & 32768;
            if (i28 != 0) {
            }
            if ((i4 & 1572864) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (599187 & i26) == 599186) ? false : true, i19 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        i9 = i5 & 8;
        if (i9 == 0) {
        }
        i10 = i5 & 16;
        if (i10 == 0) {
        }
        fontStyle2 = fontStyle;
        i11 = i5 & 32;
        if (i11 != 0) {
        }
        i12 = i5 & 64;
        if (i12 != 0) {
        }
        i13 = i5 & 128;
        if (i13 != 0) {
        }
        i14 = i8;
        i15 = i5 & 256;
        if (i15 == 0) {
        }
        i16 = i15;
        i17 = i5 & 512;
        if (i17 != 0) {
        }
        i19 = i14;
        i20 = i5 & 1024;
        if (i20 != 0) {
        }
        i22 = i5 & 2048;
        if (i22 != 0) {
        }
        int i352222 = i21;
        i24 = i5 & 4096;
        if (i24 != 0) {
        }
        z2 = z;
        i25 = i5 & 8192;
        if (i25 == 0) {
        }
        i27 = i5 & 16384;
        if (i27 != 0) {
        }
        i28 = i5 & 32768;
        if (i28 != 0) {
        }
        if ((i4 & 1572864) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (599187 & i26) == 599186) ? false : true, i19 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:269:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0123  */
    /* JADX INFO: renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3231Text4IGK_g(final String str, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        long jM9319getUnspecifiedXSAIIZE;
        int i10;
        FontStyle fontStyle2;
        int i11;
        FontWeight fontWeight2;
        int i12;
        FontFamily fontFamily2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z2;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        Composer composer2;
        Modifier.Companion companion;
        final long j5;
        final TextDecoration textDecoration2;
        TextAlign textAlign2;
        final int i27;
        final int i28;
        final int i29;
        Function1<? super TextLayoutResult, Unit> function12;
        final TextStyle textStyle2;
        final boolean z3;
        final FontStyle fontStyle3;
        final long j6;
        final FontFamily fontFamily3;
        final long j7;
        final long j8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM6361getUnspecified0d7_KjU;
        int iM9049getClipgIe3tQ8;
        int i30;
        int i31;
        Function1<? super TextLayoutResult, Unit> function13;
        TextStyle textStyle3;
        TextDecoration textDecoration3;
        FontStyle fontStyle4;
        long j9;
        FontWeight fontWeight3;
        FontFamily fontFamily4;
        long j10;
        int i32;
        long j11;
        Composer composerStartRestartGroup = composer.startRestartGroup(1028090691);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Text)N(text,modifier,color:c#ui.graphics.Color,fontSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,textAlign:c#ui.text.style.TextAlign,lineHeight:c#ui.unit.TextUnit,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,onTextLayout,style)133@7187L7,134@7241L7,163@8145L30,144@7500L682:Text.kt#jmzs0o");
        if ((i4 & 6) == 0) {
            i7 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i33 = i6 & 2;
        if (i33 != 0) {
            i7 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                i7 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i4 & 384) == 0) {
                i7 |= composerStartRestartGroup.changed(j) ? 256 : 128;
            }
            i9 = i6 & 8;
            if (i9 == 0) {
                i7 |= 3072;
                jM9319getUnspecifiedXSAIIZE = j2;
            } else {
                jM9319getUnspecifiedXSAIIZE = j2;
                if ((i4 & 3072) == 0) {
                    i7 |= composerStartRestartGroup.changed(jM9319getUnspecifiedXSAIIZE) ? 2048 : 1024;
                }
            }
            i10 = i6 & 16;
            if (i10 == 0) {
                i7 |= 24576;
            } else {
                if ((i4 & 24576) == 0) {
                    fontStyle2 = fontStyle;
                    i7 |= composerStartRestartGroup.changed(fontStyle2) ? 16384 : 8192;
                }
                i11 = i6 & 32;
                if (i11 != 0) {
                    i7 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    fontWeight2 = fontWeight;
                } else {
                    fontWeight2 = fontWeight;
                    if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i7 |= composerStartRestartGroup.changed(fontWeight2) ? 131072 : 65536;
                    }
                }
                i12 = i6 & 64;
                if (i12 != 0) {
                    i7 |= 1572864;
                    fontFamily2 = fontFamily;
                } else {
                    fontFamily2 = fontFamily;
                    if ((i4 & 1572864) == 0) {
                        i7 |= composerStartRestartGroup.changed(fontFamily2) ? 1048576 : 524288;
                    }
                }
                i13 = i6 & 128;
                if (i13 != 0) {
                    i7 |= 12582912;
                } else if ((i4 & 12582912) == 0) {
                    i7 |= composerStartRestartGroup.changed(j3) ? 8388608 : 4194304;
                }
                i14 = i6 & 256;
                if (i14 != 0) {
                    i7 |= 100663296;
                } else if ((i4 & 100663296) == 0) {
                    i7 |= composerStartRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
                }
                i15 = i6 & 512;
                if (i15 != 0) {
                    i7 |= 805306368;
                } else {
                    if ((i4 & 805306368) == 0) {
                        i16 = i15;
                        i7 |= composerStartRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                    }
                    i17 = i6 & 1024;
                    if (i17 == 0) {
                        i18 = i5 | 6;
                    } else if ((i5 & 6) == 0) {
                        i18 = i5 | (composerStartRestartGroup.changed(j4) ? 4 : 2);
                    } else {
                        i18 = i5;
                    }
                    i19 = i6 & 2048;
                    if (i19 == 0) {
                        i18 |= 48;
                        i20 = i19;
                    } else if ((i5 & 48) == 0) {
                        i20 = i19;
                        i18 |= composerStartRestartGroup.changed(i) ? 32 : 16;
                    } else {
                        i20 = i19;
                    }
                    int i34 = i18;
                    i21 = i6 & 4096;
                    if (i21 == 0) {
                        i34 |= 384;
                    } else {
                        if ((i5 & 384) == 0) {
                            z2 = z;
                            i34 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                        }
                        i22 = i6 & 8192;
                        if (i22 != 0) {
                            i23 = i34 | 3072;
                        } else {
                            int i35 = i34;
                            if ((i5 & 3072) == 0) {
                                i23 = i35 | (composerStartRestartGroup.changed(i2) ? 2048 : 1024);
                            } else {
                                i23 = i35;
                            }
                        }
                        i24 = i6 & 16384;
                        if (i24 == 0) {
                            i25 = i23;
                            if ((i5 & 24576) == 0) {
                                i25 |= composerStartRestartGroup.changed(i3) ? 16384 : 8192;
                            }
                            i26 = i6 & 32768;
                            if (i26 == 0) {
                                i25 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            } else if ((i5 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i25 |= composerStartRestartGroup.changedInstance(function1) ? 131072 : 65536;
                            }
                            if ((i5 & 1572864) == 0) {
                                i25 |= ((i6 & 65536) == 0 && composerStartRestartGroup.changed(textStyle)) ? 1048576 : 524288;
                            }
                            if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 599187) != 599186, i7 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                companion = modifier;
                                j5 = j;
                                textDecoration2 = textDecoration;
                                textAlign2 = textAlign;
                                i27 = i;
                                i28 = i2;
                                i29 = i3;
                                function12 = function1;
                                textStyle2 = textStyle;
                                z3 = z2;
                                fontStyle3 = fontStyle2;
                                j6 = jM9319getUnspecifiedXSAIIZE;
                                fontFamily3 = fontFamily2;
                                j7 = j3;
                                j8 = j4;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "114@5974L7");
                                if ((i4 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    companion = i33 != 0 ? Modifier.INSTANCE : modifier;
                                    jM6361getUnspecified0d7_KjU = i8 != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j;
                                    if (i9 != 0) {
                                        jM9319getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE();
                                    }
                                    if (i10 != 0) {
                                        fontStyle2 = null;
                                    }
                                    if (i11 != 0) {
                                        fontWeight2 = null;
                                    }
                                    if (i12 != 0) {
                                        fontFamily2 = null;
                                    }
                                    long jM9319getUnspecifiedXSAIIZE2 = i13 != 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j3;
                                    TextDecoration textDecoration4 = i14 != 0 ? null : textDecoration;
                                    textAlign2 = i16 != 0 ? null : textAlign;
                                    long jM9319getUnspecifiedXSAIIZE3 = i17 != 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j4;
                                    iM9049getClipgIe3tQ8 = i20 != 0 ? TextOverflow.INSTANCE.m9049getClipgIe3tQ8() : i;
                                    if (i21 != 0) {
                                        z2 = true;
                                    }
                                    i30 = i22 != 0 ? Integer.MAX_VALUE : i2;
                                    i31 = i24 == 0 ? i3 : 1;
                                    function13 = i26 == 0 ? function1 : null;
                                    if ((i6 & 65536) != 0) {
                                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        i25 &= -3670017;
                                        textStyle3 = (TextStyle) objConsume;
                                    } else {
                                        textStyle3 = textStyle;
                                    }
                                    textDecoration3 = textDecoration4;
                                    fontStyle4 = fontStyle2;
                                    j9 = jM9319getUnspecifiedXSAIIZE;
                                    fontWeight3 = fontWeight2;
                                    fontFamily4 = fontFamily2;
                                    j10 = jM9319getUnspecifiedXSAIIZE2;
                                    i32 = i25;
                                    j11 = jM9319getUnspecifiedXSAIIZE3;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i6 & 65536) != 0) {
                                        i25 &= -3670017;
                                    }
                                    companion = modifier;
                                    jM6361getUnspecified0d7_KjU = j;
                                    j10 = j3;
                                    textDecoration3 = textDecoration;
                                    textAlign2 = textAlign;
                                    j11 = j4;
                                    iM9049getClipgIe3tQ8 = i;
                                    i30 = i2;
                                    i31 = i3;
                                    function13 = function1;
                                    textStyle3 = textStyle;
                                    fontStyle4 = fontStyle2;
                                    j9 = jM9319getUnspecifiedXSAIIZE;
                                    fontWeight3 = fontWeight2;
                                    fontFamily4 = fontFamily2;
                                    i32 = i25;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1028090691, i7, i32, "androidx.compose.material.Text (Text.kt:115)");
                                }
                                ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composerStartRestartGroup.consume(localContentColor);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                long jM6335unboximpl = ((Color) objConsume2).m6335unboximpl();
                                ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composerStartRestartGroup.consume(localContentAlpha);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                final long jM8586getColor0d7_KjU = jM6361getUnspecified0d7_KjU != 16 ? jM6361getUnspecified0d7_KjU : textStyle3.m8586getColor0d7_KjU() != 16 ? textStyle3.m8586getColor0d7_KjU() : Color.m6324copywmQWz5c$default(jM6335unboximpl, ((Number) objConsume3).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                                TextStyle textStyleM8576mergedA7vx0o$default = TextStyle.m8576mergedA7vx0o$default(textStyle3, 0L, j9, fontWeight3, fontStyle4, null, fontFamily4, null, j10, null, null, null, 0L, textDecoration3, null, null, textAlign2 != null ? textAlign2.m8991unboximpl() : TextAlign.INSTANCE.m8998getUnspecifiede0LSkKk(), 0, j11, null, null, 0, 0, null, null, 16609105, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 152766689, "CC(remember):Text.kt#9igjgp");
                                boolean zChanged = composerStartRestartGroup.changed(jM8586getColor0d7_KjU);
                                ColorProducer colorProducerRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (zChanged || colorProducerRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    colorProducerRememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$1$1
                                        @Override // androidx.compose.ui.graphics.ColorProducer
                                        /* JADX INFO: renamed from: invoke-0d7_KjU */
                                        public final long mo3015invoke0d7_KjU() {
                                            return jM8586getColor0d7_KjU;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(colorProducerRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                int i36 = i32 << 9;
                                BasicTextKt.m2374BasicTextRWo7tUw(str, companion, textStyleM8576mergedA7vx0o$default, function13, iM9049getClipgIe3tQ8, z2, i30, i31, (ColorProducer) colorProducerRememberedValue, (TextAutoSize) null, composerStartRestartGroup, (i7 & 126) | ((i32 >> 6) & 7168) | (57344 & i36) | (458752 & i36) | (3670016 & i36) | (i36 & 29360128), 512);
                                composer2 = composerStartRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function12 = function13;
                                i28 = i30;
                                i29 = i31;
                                i27 = iM9049getClipgIe3tQ8;
                                j5 = jM6361getUnspecified0d7_KjU;
                                textStyle2 = textStyle3;
                                fontWeight2 = fontWeight3;
                                fontStyle3 = fontStyle4;
                                fontFamily3 = fontFamily4;
                                j7 = j10;
                                textDecoration2 = textDecoration3;
                                j8 = j11;
                                z3 = z2;
                                j6 = j9;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                final Modifier modifier2 = companion;
                                final FontWeight fontWeight4 = fontWeight2;
                                final TextAlign textAlign3 = textAlign2;
                                final Function1<? super TextLayoutResult, Unit> function14 = function12;
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TextKt.Text__4IGK_g$lambda$1(str, modifier2, j5, j6, fontStyle3, fontWeight4, fontFamily3, j7, textDecoration2, textAlign3, j8, i27, z3, i28, i29, function14, textStyle2, i4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i25 = i23 | 24576;
                        i26 = i6 & 32768;
                        if (i26 == 0) {
                        }
                        if ((i5 & 1572864) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 599187) != 599186, i7 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    z2 = z;
                    i22 = i6 & 8192;
                    if (i22 != 0) {
                    }
                    i24 = i6 & 16384;
                    if (i24 == 0) {
                    }
                    i26 = i6 & 32768;
                    if (i26 == 0) {
                    }
                    if ((i5 & 1572864) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 599187) != 599186, i7 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i16 = i15;
                i17 = i6 & 1024;
                if (i17 == 0) {
                }
                i19 = i6 & 2048;
                if (i19 == 0) {
                }
                int i342 = i18;
                i21 = i6 & 4096;
                if (i21 == 0) {
                }
                z2 = z;
                i22 = i6 & 8192;
                if (i22 != 0) {
                }
                i24 = i6 & 16384;
                if (i24 == 0) {
                }
                i26 = i6 & 32768;
                if (i26 == 0) {
                }
                if ((i5 & 1572864) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 599187) != 599186, i7 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            fontStyle2 = fontStyle;
            i11 = i6 & 32;
            if (i11 != 0) {
            }
            i12 = i6 & 64;
            if (i12 != 0) {
            }
            i13 = i6 & 128;
            if (i13 != 0) {
            }
            i14 = i6 & 256;
            if (i14 != 0) {
            }
            i15 = i6 & 512;
            if (i15 != 0) {
            }
            i16 = i15;
            i17 = i6 & 1024;
            if (i17 == 0) {
            }
            i19 = i6 & 2048;
            if (i19 == 0) {
            }
            int i3422 = i18;
            i21 = i6 & 4096;
            if (i21 == 0) {
            }
            z2 = z;
            i22 = i6 & 8192;
            if (i22 != 0) {
            }
            i24 = i6 & 16384;
            if (i24 == 0) {
            }
            i26 = i6 & 32768;
            if (i26 == 0) {
            }
            if ((i5 & 1572864) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 599187) != 599186, i7 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        i9 = i6 & 8;
        if (i9 == 0) {
        }
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        fontStyle2 = fontStyle;
        i11 = i6 & 32;
        if (i11 != 0) {
        }
        i12 = i6 & 64;
        if (i12 != 0) {
        }
        i13 = i6 & 128;
        if (i13 != 0) {
        }
        i14 = i6 & 256;
        if (i14 != 0) {
        }
        i15 = i6 & 512;
        if (i15 != 0) {
        }
        i16 = i15;
        i17 = i6 & 1024;
        if (i17 == 0) {
        }
        i19 = i6 & 2048;
        if (i19 == 0) {
        }
        int i34222 = i18;
        i21 = i6 & 4096;
        if (i21 == 0) {
        }
        z2 = z;
        i22 = i6 & 8192;
        if (i22 != 0) {
        }
        i24 = i6 & 16384;
        if (i24 == 0) {
        }
        i26 = i6 & 32768;
        if (i26 == 0) {
        }
        if ((i5 & 1572864) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 599187) != 599186, i7 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:298:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0132  */
    /* JADX INFO: renamed from: Text-IbK3jfQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3232TextIbK3jfQ(final AnnotatedString annotatedString, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Map<String, InlineTextContent> map, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        long jM6361getUnspecified0d7_KjU;
        int i9;
        long jM9319getUnspecifiedXSAIIZE;
        int i10;
        int i11;
        FontWeight fontWeight2;
        int i12;
        FontFamily fontFamily2;
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
        Composer composer2;
        final TextDecoration textDecoration2;
        final int i31;
        final boolean z2;
        final int i32;
        final int i33;
        final Map<String, InlineTextContent> map2;
        final Function1<? super TextLayoutResult, Unit> function12;
        final TextStyle textStyle2;
        final long j5;
        final Modifier modifier3;
        final long j6;
        final FontWeight fontWeight3;
        final long j7;
        final TextAlign textAlign2;
        final long j8;
        final FontFamily fontFamily3;
        final FontStyle fontStyle2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int iM9049getClipgIe3tQ8;
        boolean z3;
        int i34;
        int i35;
        Map<String, InlineTextContent> mapEmptyMap;
        FontStyle fontStyle3;
        Function1<? super TextLayoutResult, Unit> function13;
        TextAlign textAlign3;
        FontStyle fontStyle4;
        Function1<? super TextLayoutResult, Unit> function14;
        TextStyle textStyle3;
        FontFamily fontFamily4;
        TextDecoration textDecoration3;
        long j9;
        FontWeight fontWeight4;
        long j10;
        long j11;
        Composer composerStartRestartGroup = composer.startRestartGroup(744129681);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Text)N(text,modifier,color:c#ui.graphics.Color,fontSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,textAlign:c#ui.text.style.TextAlign,lineHeight:c#ui.unit.TextUnit,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,inlineContent,onTextLayout,style)306@15065L7,307@15119L7,317@15388L24,319@15458L73,341@16243L30,321@15537L743:Text.kt#jmzs0o");
        if ((i4 & 6) == 0) {
            i7 = (composerStartRestartGroup.changed(annotatedString) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i36 = i6 & 2;
        if (i36 != 0) {
            i7 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
                jM6361getUnspecified0d7_KjU = j;
            } else {
                jM6361getUnspecified0d7_KjU = j;
                if ((i4 & 384) == 0) {
                    i7 |= composerStartRestartGroup.changed(jM6361getUnspecified0d7_KjU) ? 256 : 128;
                }
            }
            i9 = i6 & 8;
            if (i9 == 0) {
                i7 |= 3072;
                jM9319getUnspecifiedXSAIIZE = j2;
            } else {
                jM9319getUnspecifiedXSAIIZE = j2;
                if ((i4 & 3072) == 0) {
                    i7 |= composerStartRestartGroup.changed(jM9319getUnspecifiedXSAIIZE) ? 2048 : 1024;
                }
            }
            i10 = i6 & 16;
            if (i10 == 0) {
                i7 |= 24576;
            } else {
                if ((i4 & 24576) == 0) {
                    i7 |= composerStartRestartGroup.changed(fontStyle) ? 16384 : 8192;
                }
                i11 = i6 & 32;
                if (i11 != 0) {
                    i7 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    fontWeight2 = fontWeight;
                } else {
                    fontWeight2 = fontWeight;
                    if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i7 |= composerStartRestartGroup.changed(fontWeight2) ? 131072 : 65536;
                    }
                }
                i12 = i6 & 64;
                if (i12 != 0) {
                    i7 |= 1572864;
                    fontFamily2 = fontFamily;
                } else {
                    fontFamily2 = fontFamily;
                    if ((i4 & 1572864) == 0) {
                        i7 |= composerStartRestartGroup.changed(fontFamily2) ? 1048576 : 524288;
                    }
                }
                i13 = i6 & 128;
                if (i13 != 0) {
                    i7 |= 12582912;
                } else {
                    if ((i4 & 12582912) == 0) {
                        i14 = i7 | (composerStartRestartGroup.changed(j3) ? 8388608 : 4194304);
                    }
                    i15 = i6 & 256;
                    if (i15 == 0) {
                        i14 |= 100663296;
                    } else {
                        if ((i4 & 100663296) == 0) {
                            i16 = i15;
                            i14 |= composerStartRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
                        }
                        i17 = i6 & 512;
                        if (i17 != 0) {
                            i14 |= 805306368;
                            i18 = i17;
                        } else if ((i4 & 805306368) == 0) {
                            i18 = i17;
                            i14 |= composerStartRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                        } else {
                            i18 = i17;
                        }
                        i19 = i14;
                        i20 = i6 & 1024;
                        if (i20 != 0) {
                            i21 = i20;
                            i22 = i5 | 6;
                        } else {
                            i21 = i20;
                            if ((i5 & 6) == 0) {
                                i22 = i5 | (composerStartRestartGroup.changed(j4) ? 4 : 2);
                            } else {
                                i22 = i5;
                            }
                        }
                        i23 = i6 & 2048;
                        if (i23 != 0) {
                            i22 |= 48;
                        } else {
                            if ((i5 & 48) == 0) {
                                i22 |= composerStartRestartGroup.changed(i) ? 32 : 16;
                            }
                            int i37 = i22;
                            i24 = i6 & 4096;
                            if (i24 == 0) {
                                i25 = i37 | 384;
                            } else {
                                int i38 = i37;
                                if ((i5 & 384) == 0) {
                                    i38 |= composerStartRestartGroup.changed(z) ? 256 : 128;
                                }
                                i25 = i38;
                            }
                            i26 = i6 & 8192;
                            if (i26 == 0) {
                                i27 = i25 | 3072;
                            } else {
                                int i39 = i25;
                                if ((i5 & 3072) == 0) {
                                    i27 = i39 | (composerStartRestartGroup.changed(i2) ? 2048 : 1024);
                                } else {
                                    i27 = i39;
                                }
                            }
                            i28 = i6 & 16384;
                            if (i28 != 0) {
                                if ((i5 & 24576) == 0) {
                                    i27 |= composerStartRestartGroup.changed(i3) ? 16384 : 8192;
                                }
                                i29 = i6 & 32768;
                                if (i29 != 0) {
                                    i27 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i5 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i27 |= composerStartRestartGroup.changedInstance(map) ? 131072 : 65536;
                                }
                                i30 = i6 & 65536;
                                if (i30 != 0) {
                                    i27 |= 1572864;
                                } else if ((i5 & 1572864) == 0) {
                                    i27 |= composerStartRestartGroup.changedInstance(function1) ? 1048576 : 524288;
                                }
                                if ((i5 & 12582912) == 0) {
                                    i27 |= ((i6 & 131072) == 0 && composerStartRestartGroup.changed(textStyle)) ? 8388608 : 4194304;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (4793491 & i27) == 4793490) ? false : true, i19 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "286@13810L2,287@13852L7");
                                    if ((i4 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i36 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i8 != 0) {
                                            jM6361getUnspecified0d7_KjU = Color.INSTANCE.m6361getUnspecified0d7_KjU();
                                        }
                                        if (i9 != 0) {
                                            jM9319getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE();
                                        }
                                        FontStyle fontStyle5 = i10 != 0 ? null : fontStyle;
                                        if (i11 != 0) {
                                            fontWeight2 = null;
                                        }
                                        if (i12 != 0) {
                                            fontFamily2 = null;
                                        }
                                        long jM9319getUnspecifiedXSAIIZE2 = i13 != 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j3;
                                        TextDecoration textDecoration4 = i16 != 0 ? null : textDecoration;
                                        TextAlign textAlign4 = i18 == 0 ? textAlign : null;
                                        long jM9319getUnspecifiedXSAIIZE3 = i21 != 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j4;
                                        iM9049getClipgIe3tQ8 = i23 != 0 ? TextOverflow.INSTANCE.m9049getClipgIe3tQ8() : i;
                                        z3 = i24 != 0 ? true : z;
                                        i34 = i26 != 0 ? Integer.MAX_VALUE : i2;
                                        i35 = i28 != 0 ? 1 : i3;
                                        mapEmptyMap = i29 != 0 ? MapsKt.emptyMap() : map;
                                        TextAlign textAlign5 = textAlign4;
                                        if (i30 != 0) {
                                            fontStyle3 = fontStyle5;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2144074259, "CC(remember):Text.kt#9igjgp");
                                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue = new Function1() { // from class: androidx.compose.material.TextKt$$ExternalSyntheticLambda4
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj) {
                                                        return TextKt.Text_IbK3jfQ$lambda$0$0((TextLayoutResult) obj);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            function13 = (Function1) objRememberedValue;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        } else {
                                            fontStyle3 = fontStyle5;
                                            function13 = function1;
                                        }
                                        if ((i6 & 131072) != 0) {
                                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                            Function1<? super TextLayoutResult, Unit> function15 = function13;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            i27 &= -29360129;
                                            fontStyle4 = fontStyle3;
                                            function14 = function15;
                                            textStyle3 = (TextStyle) objConsume;
                                            fontFamily4 = fontFamily2;
                                            textDecoration3 = textDecoration4;
                                            j9 = jM9319getUnspecifiedXSAIIZE;
                                            fontWeight4 = fontWeight2;
                                            j10 = jM9319getUnspecifiedXSAIIZE2;
                                            j11 = jM9319getUnspecifiedXSAIIZE3;
                                            textAlign3 = textAlign5;
                                        } else {
                                            Function1<? super TextLayoutResult, Unit> function16 = function13;
                                            textAlign3 = textAlign5;
                                            fontStyle4 = fontStyle3;
                                            function14 = function16;
                                            textStyle3 = textStyle;
                                            fontFamily4 = fontFamily2;
                                            textDecoration3 = textDecoration4;
                                            j9 = jM9319getUnspecifiedXSAIIZE;
                                            fontWeight4 = fontWeight2;
                                            j10 = jM9319getUnspecifiedXSAIIZE2;
                                            j11 = jM9319getUnspecifiedXSAIIZE3;
                                        }
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i6 & 131072) != 0) {
                                            i27 &= -29360129;
                                        }
                                        fontStyle4 = fontStyle;
                                        j10 = j3;
                                        textDecoration3 = textDecoration;
                                        textAlign3 = textAlign;
                                        j11 = j4;
                                        iM9049getClipgIe3tQ8 = i;
                                        z3 = z;
                                        i34 = i2;
                                        i35 = i3;
                                        mapEmptyMap = map;
                                        function14 = function1;
                                        textStyle3 = textStyle;
                                        fontFamily4 = fontFamily2;
                                        j9 = jM9319getUnspecifiedXSAIIZE;
                                        fontWeight4 = fontWeight2;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(744129681, i19, i27, "androidx.compose.material.Text (Text.kt:288)");
                                    }
                                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composerStartRestartGroup.consume(localContentColor);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    long jM6335unboximpl = ((Color) objConsume2).m6335unboximpl();
                                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume3 = composerStartRestartGroup.consume(localContentAlpha);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    final long jM8586getColor0d7_KjU = jM6361getUnspecified0d7_KjU != 16 ? jM6361getUnspecified0d7_KjU : textStyle3.m8586getColor0d7_KjU() != 16 ? textStyle3.m8586getColor0d7_KjU() : Color.m6324copywmQWz5c$default(jM6335unboximpl, ((Number) objConsume3).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                                    TextLinkStyles textLinkStylesRememberTextLinkStyles = rememberTextLinkStyles(composerStartRestartGroup, 0);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2144127066, "CC(remember):Text.kt#9igjgp");
                                    boolean zChanged = ((i19 & 14) == 4) | composerStartRestartGroup.changed(textLinkStylesRememberTextLinkStyles);
                                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = createTextWithLinkStyles(annotatedString, textLinkStylesRememberTextLinkStyles);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    AnnotatedString annotatedString2 = (AnnotatedString) objRememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    TextStyle textStyleM8576mergedA7vx0o$default = TextStyle.m8576mergedA7vx0o$default(textStyle3, 0L, j9, fontWeight4, fontStyle4, null, fontFamily4, null, j10, null, null, null, 0L, textDecoration3, null, null, textAlign3 != null ? textAlign3.m8991unboximpl() : TextAlign.INSTANCE.m8998getUnspecifiede0LSkKk(), 0, j11, null, null, 0, 0, null, null, 16609105, null);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2144152143, "CC(remember):Text.kt#9igjgp");
                                    boolean zChanged2 = composerStartRestartGroup.changed(jM8586getColor0d7_KjU);
                                    ColorProducer colorProducerRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (zChanged2 || colorProducerRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        colorProducerRememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$6$1
                                            @Override // androidx.compose.ui.graphics.ColorProducer
                                            /* JADX INFO: renamed from: invoke-0d7_KjU */
                                            public final long mo3015invoke0d7_KjU() {
                                                return jM8586getColor0d7_KjU;
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(colorProducerRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    int i40 = (i19 & 112) | ((i27 >> 9) & 7168);
                                    int i41 = i27 << 9;
                                    BasicTextKt.m2372BasicTextCL7eQgs(annotatedString2, modifier2, textStyleM8576mergedA7vx0o$default, function14, iM9049getClipgIe3tQ8, z3, i34, i35, mapEmptyMap, (ColorProducer) colorProducerRememberedValue, null, composerStartRestartGroup, i40 | (57344 & i41) | (458752 & i41) | (3670016 & i41) | (29360128 & i41) | (i41 & 234881024), 0, 1024);
                                    composer2 = composerStartRestartGroup;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    textAlign2 = textAlign3;
                                    function12 = function14;
                                    i33 = i35;
                                    j5 = jM6361getUnspecified0d7_KjU;
                                    modifier3 = modifier2;
                                    map2 = mapEmptyMap;
                                    textStyle2 = textStyle3;
                                    j6 = j9;
                                    fontWeight3 = fontWeight4;
                                    fontStyle2 = fontStyle4;
                                    fontFamily3 = fontFamily4;
                                    j7 = j10;
                                    j8 = j11;
                                    i32 = i34;
                                    z2 = z3;
                                    i31 = iM9049getClipgIe3tQ8;
                                    textDecoration2 = textDecoration3;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    textDecoration2 = textDecoration;
                                    i31 = i;
                                    z2 = z;
                                    i32 = i2;
                                    i33 = i3;
                                    map2 = map;
                                    function12 = function1;
                                    textStyle2 = textStyle;
                                    j5 = jM6361getUnspecified0d7_KjU;
                                    modifier3 = modifier2;
                                    j6 = jM9319getUnspecifiedXSAIIZE;
                                    fontWeight3 = fontWeight2;
                                    j7 = j3;
                                    textAlign2 = textAlign;
                                    j8 = j4;
                                    fontFamily3 = fontFamily2;
                                    fontStyle2 = fontStyle;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return TextKt.Text_IbK3jfQ$lambda$3(annotatedString, modifier3, j5, j6, fontStyle2, fontWeight3, fontFamily3, j7, textDecoration2, textAlign2, j8, i31, z2, i32, i33, map2, function12, textStyle2, i4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i27 |= 24576;
                            i29 = i6 & 32768;
                            if (i29 != 0) {
                            }
                            i30 = i6 & 65536;
                            if (i30 != 0) {
                            }
                            if ((i5 & 12582912) == 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (4793491 & i27) == 4793490) ? false : true, i19 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        int i372 = i22;
                        i24 = i6 & 4096;
                        if (i24 == 0) {
                        }
                        i26 = i6 & 8192;
                        if (i26 == 0) {
                        }
                        i28 = i6 & 16384;
                        if (i28 != 0) {
                        }
                        i29 = i6 & 32768;
                        if (i29 != 0) {
                        }
                        i30 = i6 & 65536;
                        if (i30 != 0) {
                        }
                        if ((i5 & 12582912) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (4793491 & i27) == 4793490) ? false : true, i19 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i16 = i15;
                    i17 = i6 & 512;
                    if (i17 != 0) {
                    }
                    i19 = i14;
                    i20 = i6 & 1024;
                    if (i20 != 0) {
                    }
                    i23 = i6 & 2048;
                    if (i23 != 0) {
                    }
                    int i3722 = i22;
                    i24 = i6 & 4096;
                    if (i24 == 0) {
                    }
                    i26 = i6 & 8192;
                    if (i26 == 0) {
                    }
                    i28 = i6 & 16384;
                    if (i28 != 0) {
                    }
                    i29 = i6 & 32768;
                    if (i29 != 0) {
                    }
                    i30 = i6 & 65536;
                    if (i30 != 0) {
                    }
                    if ((i5 & 12582912) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (4793491 & i27) == 4793490) ? false : true, i19 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i14 = i7;
                i15 = i6 & 256;
                if (i15 == 0) {
                }
                i16 = i15;
                i17 = i6 & 512;
                if (i17 != 0) {
                }
                i19 = i14;
                i20 = i6 & 1024;
                if (i20 != 0) {
                }
                i23 = i6 & 2048;
                if (i23 != 0) {
                }
                int i37222 = i22;
                i24 = i6 & 4096;
                if (i24 == 0) {
                }
                i26 = i6 & 8192;
                if (i26 == 0) {
                }
                i28 = i6 & 16384;
                if (i28 != 0) {
                }
                i29 = i6 & 32768;
                if (i29 != 0) {
                }
                i30 = i6 & 65536;
                if (i30 != 0) {
                }
                if ((i5 & 12582912) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (4793491 & i27) == 4793490) ? false : true, i19 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            i11 = i6 & 32;
            if (i11 != 0) {
            }
            i12 = i6 & 64;
            if (i12 != 0) {
            }
            i13 = i6 & 128;
            if (i13 != 0) {
            }
            i14 = i7;
            i15 = i6 & 256;
            if (i15 == 0) {
            }
            i16 = i15;
            i17 = i6 & 512;
            if (i17 != 0) {
            }
            i19 = i14;
            i20 = i6 & 1024;
            if (i20 != 0) {
            }
            i23 = i6 & 2048;
            if (i23 != 0) {
            }
            int i372222 = i22;
            i24 = i6 & 4096;
            if (i24 == 0) {
            }
            i26 = i6 & 8192;
            if (i26 == 0) {
            }
            i28 = i6 & 16384;
            if (i28 != 0) {
            }
            i29 = i6 & 32768;
            if (i29 != 0) {
            }
            i30 = i6 & 65536;
            if (i30 != 0) {
            }
            if ((i5 & 12582912) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (4793491 & i27) == 4793490) ? false : true, i19 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        i9 = i6 & 8;
        if (i9 == 0) {
        }
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        i11 = i6 & 32;
        if (i11 != 0) {
        }
        i12 = i6 & 64;
        if (i12 != 0) {
        }
        i13 = i6 & 128;
        if (i13 != 0) {
        }
        i14 = i7;
        i15 = i6 & 256;
        if (i15 == 0) {
        }
        i16 = i15;
        i17 = i6 & 512;
        if (i17 != 0) {
        }
        i19 = i14;
        i20 = i6 & 1024;
        if (i20 != 0) {
        }
        i23 = i6 & 2048;
        if (i23 != 0) {
        }
        int i3722222 = i22;
        i24 = i6 & 4096;
        if (i24 == 0) {
        }
        i26 = i6 & 8192;
        if (i26 == 0) {
        }
        i28 = i6 & 16384;
        if (i28 != 0) {
        }
        i29 = i6 & 32768;
        if (i29 != 0) {
        }
        i30 = i6 & 65536;
        if (i30 != 0) {
        }
        if ((i5 & 12582912) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (4793491 & i27) == 4793490) ? false : true, i19 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:246:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0135  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* JADX INFO: renamed from: Text-fLXpl1I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m3233TextfLXpl1I(final String str, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, Function1 function1, TextStyle textStyle, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        int i7;
        long jM6361getUnspecified0d7_KjU;
        int i8;
        int i9;
        long jM9319getUnspecifiedXSAIIZE;
        int i10;
        FontStyle fontStyle2;
        int i11;
        FontWeight fontWeight2;
        int i12;
        FontFamily fontFamily2;
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
        boolean z2;
        int i25;
        int i26;
        int i27;
        Composer composer2;
        final Modifier modifier2;
        final TextAlign textAlign2;
        final int i28;
        final int i29;
        final Function1 function12;
        final TextStyle textStyle2;
        final boolean z3;
        final long j5;
        final FontStyle fontStyle3;
        final long j6;
        final FontWeight fontWeight3;
        final FontFamily fontFamily3;
        final long j7;
        final TextDecoration textDecoration2;
        final long j8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        Function1 function13;
        Modifier modifier4;
        TextAlign textAlign3;
        boolean z4;
        long j9;
        Function1 function14;
        TextStyle textStyle3;
        int i30;
        int i31;
        long j10;
        TextDecoration textDecoration3;
        long j11;
        FontWeight fontWeight4;
        FontFamily fontFamily4;
        long j12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-366126944);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Text)N(text,modifier,color:c#ui.graphics.Color,fontSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,textAlign:c#ui.text.style.TextAlign,lineHeight:c#ui.unit.TextUnit,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,onTextLayout,style)190@8980L323:Text.kt#jmzs0o");
        if ((i3 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        int i32 = i5 & 2;
        if (i32 != 0) {
            i6 |= 48;
        } else {
            if ((i3 & 48) == 0) {
                i6 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i7 = i5 & 4;
            if (i7 == 0) {
                i8 = i6 | 384;
                jM6361getUnspecified0d7_KjU = j;
            } else {
                int i33 = i6;
                jM6361getUnspecified0d7_KjU = j;
                if ((i3 & 384) == 0) {
                    i33 |= composerStartRestartGroup.changed(jM6361getUnspecified0d7_KjU) ? 256 : 128;
                }
                i8 = i33;
            }
            i9 = i5 & 8;
            if (i9 == 0) {
                i8 |= 3072;
                jM9319getUnspecifiedXSAIIZE = j2;
            } else {
                jM9319getUnspecifiedXSAIIZE = j2;
                if ((i3 & 3072) == 0) {
                    i8 |= composerStartRestartGroup.changed(jM9319getUnspecifiedXSAIIZE) ? 2048 : 1024;
                }
            }
            i10 = i5 & 16;
            if (i10 == 0) {
                i8 |= 24576;
            } else {
                if ((i3 & 24576) == 0) {
                    fontStyle2 = fontStyle;
                    i8 |= composerStartRestartGroup.changed(fontStyle2) ? 16384 : 8192;
                }
                i11 = i5 & 32;
                int i34 = 65536;
                if (i11 != 0) {
                    i8 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    fontWeight2 = fontWeight;
                } else {
                    fontWeight2 = fontWeight;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i8 |= composerStartRestartGroup.changed(fontWeight2) ? 131072 : 65536;
                    }
                }
                i12 = i5 & 64;
                if (i12 != 0) {
                    i8 |= 1572864;
                    fontFamily2 = fontFamily;
                } else {
                    fontFamily2 = fontFamily;
                    if ((i3 & 1572864) == 0) {
                        i8 |= composerStartRestartGroup.changed(fontFamily2) ? 1048576 : 524288;
                    }
                }
                i13 = i5 & 128;
                if (i13 != 0) {
                    i8 |= 12582912;
                } else {
                    if ((i3 & 12582912) == 0) {
                        i14 = i8 | (composerStartRestartGroup.changed(j3) ? 8388608 : 4194304);
                    }
                    i15 = i5 & 256;
                    if (i15 == 0) {
                        i14 |= 100663296;
                    } else {
                        if ((i3 & 100663296) == 0) {
                            i16 = i15;
                            i14 |= composerStartRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
                        }
                        i17 = i5 & 512;
                        if (i17 != 0) {
                            i14 |= 805306368;
                            i18 = i17;
                        } else if ((i3 & 805306368) == 0) {
                            i18 = i17;
                            i14 |= composerStartRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                        } else {
                            i18 = i17;
                        }
                        i19 = i14;
                        i20 = i5 & 1024;
                        if (i20 != 0) {
                            i21 = i4 | 6;
                        } else if ((i4 & 6) == 0) {
                            i21 = i4 | (composerStartRestartGroup.changed(j4) ? 4 : 2);
                        } else {
                            i21 = i4;
                        }
                        i22 = i5 & 2048;
                        if (i22 != 0) {
                            i21 |= 48;
                            i23 = i22;
                        } else if ((i4 & 48) == 0) {
                            i23 = i22;
                            i21 |= composerStartRestartGroup.changed(i) ? 32 : 16;
                        } else {
                            i23 = i22;
                        }
                        int i35 = i21;
                        i24 = i5 & 4096;
                        if (i24 != 0) {
                            i35 |= 384;
                        } else {
                            if ((i4 & 384) == 0) {
                                z2 = z;
                                i35 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                            }
                            i25 = i5 & 8192;
                            if (i25 == 0) {
                                i26 = i35 | 3072;
                            } else {
                                int i36 = i35;
                                if ((i4 & 3072) == 0) {
                                    i26 = i36 | (composerStartRestartGroup.changed(i2) ? 2048 : 1024);
                                } else {
                                    i26 = i36;
                                }
                            }
                            i27 = i5 & 16384;
                            if (i27 != 0) {
                                if ((i4 & 24576) == 0) {
                                    i26 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
                                }
                                if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    if ((i5 & 32768) == 0 && composerStartRestartGroup.changed(textStyle)) {
                                        i34 = 131072;
                                    }
                                    i26 |= i34;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (74899 & i26) == 74898) ? false : true, i19 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "187@8921L2,188@8963L7");
                                    if ((i3 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        Modifier.Companion companion = i32 != 0 ? Modifier.INSTANCE : modifier;
                                        if (i7 != 0) {
                                            jM6361getUnspecified0d7_KjU = Color.INSTANCE.m6361getUnspecified0d7_KjU();
                                        }
                                        if (i9 != 0) {
                                            jM9319getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE();
                                        }
                                        if (i10 != 0) {
                                            fontStyle2 = null;
                                        }
                                        if (i11 != 0) {
                                            fontWeight2 = null;
                                        }
                                        if (i12 != 0) {
                                            fontFamily2 = null;
                                        }
                                        long jM9319getUnspecifiedXSAIIZE2 = i13 != 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j3;
                                        TextDecoration textDecoration4 = i16 != 0 ? null : textDecoration;
                                        TextAlign textAlign4 = i18 == 0 ? textAlign : null;
                                        long jM9319getUnspecifiedXSAIIZE3 = i20 != 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j4;
                                        int iM9049getClipgIe3tQ8 = i23 != 0 ? TextOverflow.INSTANCE.m9049getClipgIe3tQ8() : i;
                                        boolean z5 = i24 == 0 ? z2 : true;
                                        int i37 = i25 != 0 ? Integer.MAX_VALUE : i2;
                                        if (i27 != 0) {
                                            modifier3 = companion;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 339344066, "CC(remember):Text.kt#9igjgp");
                                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue = new Function1() { // from class: androidx.compose.material.TextKt$$ExternalSyntheticLambda1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj) {
                                                        return TextKt.Text_fLXpl1I$lambda$0$0((TextLayoutResult) obj);
                                                    }
                                                };
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            function13 = (Function1) objRememberedValue;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        } else {
                                            modifier3 = companion;
                                            function13 = function1;
                                        }
                                        if ((i5 & 32768) != 0) {
                                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                            Function1 function15 = function13;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            i26 &= -458753;
                                            modifier4 = modifier3;
                                            textAlign3 = textAlign4;
                                            z4 = z5;
                                            j9 = jM9319getUnspecifiedXSAIIZE3;
                                            function14 = function15;
                                            textStyle3 = (TextStyle) objConsume;
                                        } else {
                                            modifier4 = modifier3;
                                            textAlign3 = textAlign4;
                                            z4 = z5;
                                            j9 = jM9319getUnspecifiedXSAIIZE3;
                                            function14 = function13;
                                            textStyle3 = textStyle;
                                        }
                                        i30 = iM9049getClipgIe3tQ8;
                                        long j13 = jM9319getUnspecifiedXSAIIZE2;
                                        i31 = i37;
                                        j10 = jM6361getUnspecified0d7_KjU;
                                        FontFamily fontFamily5 = fontFamily2;
                                        textDecoration3 = textDecoration4;
                                        j11 = jM9319getUnspecifiedXSAIIZE;
                                        fontWeight4 = fontWeight2;
                                        fontFamily4 = fontFamily5;
                                        j12 = j13;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i5 & 32768) != 0) {
                                            i26 &= -458753;
                                        }
                                        modifier4 = modifier;
                                        textAlign3 = textAlign;
                                        j9 = j4;
                                        i30 = i;
                                        i31 = i2;
                                        function14 = function1;
                                        textStyle3 = textStyle;
                                        z4 = z2;
                                        j10 = jM6361getUnspecified0d7_KjU;
                                        j11 = jM9319getUnspecifiedXSAIIZE;
                                        fontWeight4 = fontWeight2;
                                        fontFamily4 = fontFamily2;
                                        j12 = j3;
                                        textDecoration3 = textDecoration;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-366126944, i19, i26, "androidx.compose.material.Text (Text.kt:189)");
                                    }
                                    int i38 = i26 << 3;
                                    composer2 = composerStartRestartGroup;
                                    m3231Text4IGK_g(str, modifier4, j10, j11, fontStyle2, fontWeight4, fontFamily4, j12, textDecoration3, textAlign3, j9, i30, z4, i31, 1, (Function1<? super TextLayoutResult, Unit>) function14, textStyle3, composer2, i19 & 2147483646, (i26 & 14) | 24576 | (i26 & 112) | (i26 & 896) | (i26 & 7168) | (458752 & i38) | (i38 & 3670016), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier4;
                                    j5 = j10;
                                    j6 = j11;
                                    fontStyle3 = fontStyle2;
                                    fontWeight3 = fontWeight4;
                                    fontFamily3 = fontFamily4;
                                    j7 = j12;
                                    textDecoration2 = textDecoration3;
                                    textAlign2 = textAlign3;
                                    j8 = j9;
                                    i28 = i30;
                                    z3 = z4;
                                    i29 = i31;
                                    function12 = function14;
                                    textStyle2 = textStyle3;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    modifier2 = modifier;
                                    textAlign2 = textAlign;
                                    i28 = i;
                                    i29 = i2;
                                    function12 = function1;
                                    textStyle2 = textStyle;
                                    z3 = z2;
                                    j5 = jM6361getUnspecified0d7_KjU;
                                    fontStyle3 = fontStyle2;
                                    j6 = jM9319getUnspecifiedXSAIIZE;
                                    fontWeight3 = fontWeight2;
                                    fontFamily3 = fontFamily2;
                                    j7 = j3;
                                    textDecoration2 = textDecoration;
                                    j8 = j4;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return TextKt.Text_fLXpl1I$lambda$1(str, modifier2, j5, j6, fontStyle3, fontWeight3, fontFamily3, j7, textDecoration2, textAlign2, j8, i28, z3, i29, function12, textStyle2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i26 |= 24576;
                            if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (74899 & i26) == 74898) ? false : true, i19 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        z2 = z;
                        i25 = i5 & 8192;
                        if (i25 == 0) {
                        }
                        i27 = i5 & 16384;
                        if (i27 != 0) {
                        }
                        if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (74899 & i26) == 74898) ? false : true, i19 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i16 = i15;
                    i17 = i5 & 512;
                    if (i17 != 0) {
                    }
                    i19 = i14;
                    i20 = i5 & 1024;
                    if (i20 != 0) {
                    }
                    i22 = i5 & 2048;
                    if (i22 != 0) {
                    }
                    int i352 = i21;
                    i24 = i5 & 4096;
                    if (i24 != 0) {
                    }
                    z2 = z;
                    i25 = i5 & 8192;
                    if (i25 == 0) {
                    }
                    i27 = i5 & 16384;
                    if (i27 != 0) {
                    }
                    if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (74899 & i26) == 74898) ? false : true, i19 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i14 = i8;
                i15 = i5 & 256;
                if (i15 == 0) {
                }
                i16 = i15;
                i17 = i5 & 512;
                if (i17 != 0) {
                }
                i19 = i14;
                i20 = i5 & 1024;
                if (i20 != 0) {
                }
                i22 = i5 & 2048;
                if (i22 != 0) {
                }
                int i3522 = i21;
                i24 = i5 & 4096;
                if (i24 != 0) {
                }
                z2 = z;
                i25 = i5 & 8192;
                if (i25 == 0) {
                }
                i27 = i5 & 16384;
                if (i27 != 0) {
                }
                if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (74899 & i26) == 74898) ? false : true, i19 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            fontStyle2 = fontStyle;
            i11 = i5 & 32;
            int i342 = 65536;
            if (i11 != 0) {
            }
            i12 = i5 & 64;
            if (i12 != 0) {
            }
            i13 = i5 & 128;
            if (i13 != 0) {
            }
            i14 = i8;
            i15 = i5 & 256;
            if (i15 == 0) {
            }
            i16 = i15;
            i17 = i5 & 512;
            if (i17 != 0) {
            }
            i19 = i14;
            i20 = i5 & 1024;
            if (i20 != 0) {
            }
            i22 = i5 & 2048;
            if (i22 != 0) {
            }
            int i35222 = i21;
            i24 = i5 & 4096;
            if (i24 != 0) {
            }
            z2 = z;
            i25 = i5 & 8192;
            if (i25 == 0) {
            }
            i27 = i5 & 16384;
            if (i27 != 0) {
            }
            if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (74899 & i26) == 74898) ? false : true, i19 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        i9 = i5 & 8;
        if (i9 == 0) {
        }
        i10 = i5 & 16;
        if (i10 == 0) {
        }
        fontStyle2 = fontStyle;
        i11 = i5 & 32;
        int i3422 = 65536;
        if (i11 != 0) {
        }
        i12 = i5 & 64;
        if (i12 != 0) {
        }
        i13 = i5 & 128;
        if (i13 != 0) {
        }
        i14 = i8;
        i15 = i5 & 256;
        if (i15 == 0) {
        }
        i16 = i15;
        i17 = i5 & 512;
        if (i17 != 0) {
        }
        i19 = i14;
        i20 = i5 & 1024;
        if (i20 != 0) {
        }
        i22 = i5 & 2048;
        if (i22 != 0) {
        }
        int i352222 = i21;
        i24 = i5 & 4096;
        if (i24 != 0) {
        }
        z2 = z;
        i25 = i5 & 8192;
        if (i25 == 0) {
        }
        i27 = i5 & 16384;
        if (i27 != 0) {
        }
        if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i19 & 306783379) == 306783378 && (74899 & i26) == 74898) ? false : true, i19 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Text_IbK3jfQ$lambda$0$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    static final Unit Text_IbK3jfQ$lambda$3(AnnotatedString annotatedString, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Map map, Function1 function1, TextStyle textStyle, int i4, int i5, int i6, Composer composer, int i7) {
        m3232TextIbK3jfQ(annotatedString, modifier, j, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, i3, map, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    static final Unit Text__4IGK_g$lambda$1(String str, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Function1 function1, TextStyle textStyle, int i4, int i5, int i6, Composer composer, int i7) {
        m3231Text4IGK_g(str, modifier, j, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, i3, (Function1<? super TextLayoutResult, Unit>) function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Text__4IGK_g$lambda$2$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    static final Unit Text__4IGK_g$lambda$3(AnnotatedString annotatedString, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, Map map, Function1 function1, TextStyle textStyle, int i3, int i4, int i5, Composer composer, int i6) {
        m3230Text4IGK_g(annotatedString, modifier, j, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, map, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Text_fLXpl1I$lambda$0$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    static final Unit Text_fLXpl1I$lambda$1(String str, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, Function1 function1, TextStyle textStyle, int i3, int i4, int i5, Composer composer, int i6) {
        m3233TextfLXpl1I(str, modifier, j, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    private static final AnnotatedString createTextWithLinkStyles(AnnotatedString annotatedString, final TextLinkStyles textLinkStyles) {
        return annotatedString.mapAnnotations(new Function1() { // from class: androidx.compose.material.TextKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextKt.createTextWithLinkStyles$lambda$0(textLinkStyles, (AnnotatedString.Range) obj);
            }
        });
    }

    static final AnnotatedString.Range createTextWithLinkStyles$lambda$0(TextLinkStyles textLinkStyles, AnnotatedString.Range range) {
        AnnotatedString.Annotation annotation = (AnnotatedString.Annotation) range.getItem();
        if (annotation instanceof LinkAnnotation.Url) {
            LinkAnnotation.Url url = (LinkAnnotation.Url) annotation;
            if (url.getStyles() == null) {
                Intrinsics.checkNotNull(range, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation.Url>");
                return AnnotatedString.Range.copy$default(range, LinkAnnotation.Url.copy$default(url, null, textLinkStyles, null, 5, null), 0, 0, null, 14, null);
            }
        }
        if (annotation instanceof LinkAnnotation.Clickable) {
            LinkAnnotation.Clickable clickable = (LinkAnnotation.Clickable) annotation;
            if (clickable.getStyles() == null) {
                Intrinsics.checkNotNull(range, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation.Clickable>");
                return AnnotatedString.Range.copy$default(range, LinkAnnotation.Clickable.copy$default(clickable, null, textLinkStyles, null, 5, null), 0, 0, null, 14, null);
            }
        }
        return range;
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    private static final TextLinkStyles rememberTextLinkStyles(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 853203714, "C(rememberTextLinkStyles)432@19253L6,433@19279L159:Text.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(853203714, i, -1, "androidx.compose.material.rememberTextLinkStyles (Text.kt:431)");
        }
        long jM2983getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composer, 6).m2983getPrimary0d7_KjU();
        ComposerKt.sourceInformationMarkerStart(composer, -409980703, "CC(remember):Text.kt#9igjgp");
        boolean zChanged = composer.changed(jM2983getPrimary0d7_KjU);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            TextLinkStyles textLinkStyles = new TextLinkStyles(new SpanStyle(jM2983getPrimary0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.INSTANCE.getUnderline(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61438, (DefaultConstructorMarker) null), null, null, null, 14, null);
            composer.updateRememberedValue(textLinkStyles);
            objRememberedValue = textLinkStyles;
        }
        TextLinkStyles textLinkStyles2 = (TextLinkStyles) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textLinkStyles2;
    }
}
