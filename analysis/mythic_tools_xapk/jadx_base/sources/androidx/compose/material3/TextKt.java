package androidx.compose.material3;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.tokens.TypographyTokensKt;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÛ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0001\u0018\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b$\u0010%\u001aï\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b*\u0010+\u001aÏ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0001\u0018\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b,\u0010-\u001aã\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b.\u0010/\u001aÃ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b0\u00101\u001aÙ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b,\u00102\u001a(\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u00020#2\u0011\u00109\u001a\r\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b;H\u0007¢\u0006\u0002\u0010<\u001a\u0018\u0010=\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020&2\u0006\u0010>\u001a\u00020?H\u0002\u001a\r\u0010@\u001a\u00020?H\u0003¢\u0006\u0002\u0010A\"\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020#04¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006B"}, d2 = {"Text", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Landroidx/compose/ui/text/TextStyle;", "Text-Nvy7gAk", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/text/TextAutoSize;JLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "Text-Z58ophY", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/text/TextAutoSize;JLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "value", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "createTextWithLinkStyles", "linkStyles", "Landroidx/compose/ui/text/TextLinkStyles;", "rememberTextLinkStyles", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextLinkStyles;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return TypographyTokensKt.getDefaultTextStyle();
        }
    });

    public static final void ProvideTextStyle(final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(15327438);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProvideTextStyle)N(value,content)460@19447L7,461@19472L80:Text.kt#uh7d8r");
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
                ComposerKt.traceEventStart(15327438, i2, -1, "androidx.compose.material3.ProvideTextStyle (Text.kt:459)");
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextKt.ProvideTextStyle$lambda$20(textStyle, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ProvideTextStyle$lambda$20(TextStyle textStyle, Function2 function2, int i, Composer composer, int i2) {
        ProvideTextStyle(textStyle, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:264:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x011c  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* JADX INFO: renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m4285Text4IGK_g(final AnnotatedString annotatedString, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, Map map, Function1 function1, TextStyle textStyle, Composer composer, final int i3, final int i4, final int i5) {
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
        TextAlign textAlign3;
        Function1 function13;
        TextAlign textAlign4;
        Function1 function14;
        TextStyle textStyle3;
        TextDecoration textDecoration3;
        long j9;
        Map map3;
        Modifier modifier3;
        int i31;
        long j10;
        boolean z4;
        int i32;
        FontFamily fontFamily4;
        FontStyle fontStyle4;
        long j11;
        FontWeight fontWeight4;
        long j12;
        Composer composerStartRestartGroup = composer.startRestartGroup(224529679);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Text)N(text,modifier,color:c#ui.graphics.Color,fontSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,textAlign:c#ui.text.style.TextAlign,lineHeight:c#ui.unit.TextUnit,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,inlineContent,onTextLayout,style)419@17929L562:Text.kt#uh7d8r");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 6) == 0) {
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
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "416@17870L2,417@17912L7");
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
                                        boolean z5 = i24 == 0 ? z2 : true;
                                        int i37 = i25 != 0 ? Integer.MAX_VALUE : i2;
                                        Map mapEmptyMap = i27 != 0 ? MapsKt.emptyMap() : map;
                                        Modifier modifier4 = companion;
                                        if (i28 != 0) {
                                            textAlign3 = textAlign5;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1024682481, "CC(remember):Text.kt#9igjgp");
                                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda12
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj) {
                                                        return Unit.INSTANCE;
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
                                            Function1 function15 = function13;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            i26 &= -3670017;
                                            textAlign4 = textAlign3;
                                            function14 = function15;
                                            textStyle3 = (TextStyle) objConsume;
                                        } else {
                                            textAlign4 = textAlign3;
                                            function14 = function13;
                                            textStyle3 = textStyle;
                                        }
                                        textDecoration3 = textDecoration4;
                                        j9 = jM9319getUnspecifiedXSAIIZE3;
                                        map3 = mapEmptyMap;
                                        modifier3 = modifier4;
                                        long j13 = jM9319getUnspecifiedXSAIIZE2;
                                        i31 = i37;
                                        j10 = jM6361getUnspecified0d7_KjU;
                                        z4 = z5;
                                        i32 = iM9049getClipgIe3tQ8;
                                        fontFamily4 = fontFamily2;
                                        long j14 = jM9319getUnspecifiedXSAIIZE;
                                        fontStyle4 = fontStyle2;
                                        j11 = j14;
                                        fontWeight4 = fontWeight2;
                                        j12 = j13;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i5 & 65536) != 0) {
                                            i26 &= -3670017;
                                        }
                                        long j15 = jM9319getUnspecifiedXSAIIZE;
                                        fontStyle4 = fontStyle2;
                                        j11 = j15;
                                        modifier3 = modifier;
                                        textDecoration3 = textDecoration;
                                        textAlign4 = textAlign;
                                        j9 = j4;
                                        i32 = i;
                                        i31 = i2;
                                        map3 = map;
                                        function14 = function1;
                                        textStyle3 = textStyle;
                                        z4 = z2;
                                        j10 = jM6361getUnspecified0d7_KjU;
                                        fontWeight4 = fontWeight2;
                                        fontFamily4 = fontFamily2;
                                        j12 = j3;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(224529679, i19, i26, "androidx.compose.material3.Text (Text.kt:418)");
                                    }
                                    int i38 = i19 << 3;
                                    int i39 = (i19 & 1022) | (57344 & i38) | (458752 & i38) | (3670016 & i38) | (29360128 & i38) | (234881024 & i38) | (i38 & 1879048192);
                                    int i40 = i26 << 3;
                                    int i41 = ((i19 >> 27) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i40 & 112) | (i40 & 896) | (i40 & 7168) | (i40 & 57344);
                                    int i42 = i26 << 6;
                                    composer2 = composerStartRestartGroup;
                                    m4289TextZ58ophY(annotatedString, modifier3, j10, null, j11, fontStyle4, fontWeight4, fontFamily4, j12, textDecoration3, textAlign4, j9, i32, z4, i31, 1, map3, function14, textStyle3, composer2, i39, i41 | (3670016 & i42) | (29360128 & i42) | (i42 & 234881024), 8);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier3;
                                    j5 = j10;
                                    j6 = j11;
                                    fontStyle3 = fontStyle4;
                                    fontWeight3 = fontWeight4;
                                    fontFamily3 = fontFamily4;
                                    j7 = j12;
                                    textDecoration2 = textDecoration3;
                                    textAlign2 = textAlign4;
                                    j8 = j9;
                                    i29 = i32;
                                    z3 = z4;
                                    i30 = i31;
                                    map2 = map3;
                                    function12 = function14;
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
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return TextKt.Text__4IGK_g$lambda$18(annotatedString, modifier2, j5, j6, fontStyle3, fontWeight3, fontFamily3, j7, textDecoration2, textAlign2, j8, i29, z3, i30, map2, function12, textStyle2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:259:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x011c  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with autoSize instead")
    /* JADX INFO: renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m4286Text4IGK_g(final String str, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Function1 function1, TextStyle textStyle, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        long jM6361getUnspecified0d7_KjU;
        int i9;
        int i10;
        long jM9319getUnspecifiedXSAIIZE;
        int i11;
        FontStyle fontStyle2;
        int i12;
        FontWeight fontWeight2;
        int i13;
        FontFamily fontFamily2;
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
        boolean z2;
        int i26;
        int i27;
        int i28;
        int i29;
        Composer composer2;
        final Modifier modifier2;
        final TextAlign textAlign2;
        final int i30;
        final int i31;
        final int i32;
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
        Function1 function13;
        Modifier modifier3;
        TextStyle textStyle3;
        long j9;
        Function1 function14;
        int i33;
        int i34;
        TextDecoration textDecoration3;
        boolean z4;
        long j10;
        int i35;
        TextAlign textAlign3;
        FontFamily fontFamily4;
        FontStyle fontStyle4;
        long j11;
        FontWeight fontWeight4;
        long j12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2055108902);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Text)N(text,modifier,color:c#ui.graphics.Color,fontSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,textAlign:c#ui.text.style.TextAlign,lineHeight:c#ui.unit.TextUnit,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,onTextLayout,style)283@13704L555:Text.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i7 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i36 = i6 & 2;
        if (i36 != 0) {
            i7 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                i7 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i8 = i6 & 4;
            if (i8 == 0) {
                i9 = i7 | 384;
                jM6361getUnspecified0d7_KjU = j;
            } else {
                int i37 = i7;
                jM6361getUnspecified0d7_KjU = j;
                if ((i4 & 384) == 0) {
                    i37 |= composerStartRestartGroup.changed(jM6361getUnspecified0d7_KjU) ? 256 : 128;
                }
                i9 = i37;
            }
            i10 = i6 & 8;
            if (i10 == 0) {
                i9 |= 3072;
                jM9319getUnspecifiedXSAIIZE = j2;
            } else {
                jM9319getUnspecifiedXSAIIZE = j2;
                if ((i4 & 3072) == 0) {
                    i9 |= composerStartRestartGroup.changed(jM9319getUnspecifiedXSAIIZE) ? 2048 : 1024;
                }
            }
            i11 = i6 & 16;
            if (i11 == 0) {
                i9 |= 24576;
            } else {
                if ((i4 & 24576) == 0) {
                    fontStyle2 = fontStyle;
                    i9 |= composerStartRestartGroup.changed(fontStyle2) ? 16384 : 8192;
                }
                i12 = i6 & 32;
                if (i12 != 0) {
                    i9 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    fontWeight2 = fontWeight;
                } else {
                    fontWeight2 = fontWeight;
                    if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i9 |= composerStartRestartGroup.changed(fontWeight2) ? 131072 : 65536;
                    }
                }
                i13 = i6 & 64;
                if (i13 != 0) {
                    i9 |= 1572864;
                    fontFamily2 = fontFamily;
                } else {
                    fontFamily2 = fontFamily;
                    if ((i4 & 1572864) == 0) {
                        i9 |= composerStartRestartGroup.changed(fontFamily2) ? 1048576 : 524288;
                    }
                }
                i14 = i6 & 128;
                if (i14 != 0) {
                    i9 |= 12582912;
                } else {
                    if ((i4 & 12582912) == 0) {
                        i15 = i9 | (composerStartRestartGroup.changed(j3) ? 8388608 : 4194304);
                    }
                    i16 = i6 & 256;
                    if (i16 == 0) {
                        i15 |= 100663296;
                    } else {
                        if ((i4 & 100663296) == 0) {
                            i17 = i16;
                            i15 |= composerStartRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
                        }
                        i18 = i6 & 512;
                        if (i18 != 0) {
                            i15 |= 805306368;
                            i19 = i18;
                        } else if ((i4 & 805306368) == 0) {
                            i19 = i18;
                            i15 |= composerStartRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                        } else {
                            i19 = i18;
                        }
                        i20 = i15;
                        i21 = i6 & 1024;
                        if (i21 != 0) {
                            i22 = i5 | 6;
                        } else if ((i5 & 6) == 0) {
                            i22 = i5 | (composerStartRestartGroup.changed(j4) ? 4 : 2);
                        } else {
                            i22 = i5;
                        }
                        i23 = i6 & 2048;
                        if (i23 != 0) {
                            i22 |= 48;
                            i24 = i23;
                        } else if ((i5 & 48) == 0) {
                            i24 = i23;
                            i22 |= composerStartRestartGroup.changed(i) ? 32 : 16;
                        } else {
                            i24 = i23;
                        }
                        int i38 = i22;
                        i25 = i6 & 4096;
                        if (i25 != 0) {
                            i38 |= 384;
                        } else {
                            if ((i5 & 384) == 0) {
                                z2 = z;
                                i38 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                            }
                            i26 = i6 & 8192;
                            if (i26 == 0) {
                                i27 = i38 | 3072;
                            } else {
                                int i39 = i38;
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
                                    i27 |= composerStartRestartGroup.changedInstance(function1) ? 131072 : 65536;
                                }
                                if ((i5 & 1572864) == 0) {
                                    i27 |= ((i6 & 65536) == 0 && composerStartRestartGroup.changed(textStyle)) ? 1048576 : 524288;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i20 & 306783379) == 306783378 && (599187 & i27) == 599186) ? false : true, i20 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "281@13687L7");
                                    if ((i4 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        Modifier.Companion companion = i36 != 0 ? Modifier.INSTANCE : modifier;
                                        if (i8 != 0) {
                                            jM6361getUnspecified0d7_KjU = Color.INSTANCE.m6361getUnspecified0d7_KjU();
                                        }
                                        if (i10 != 0) {
                                            jM9319getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE();
                                        }
                                        if (i11 != 0) {
                                            fontStyle2 = null;
                                        }
                                        if (i12 != 0) {
                                            fontWeight2 = null;
                                        }
                                        if (i13 != 0) {
                                            fontFamily2 = null;
                                        }
                                        long jM9319getUnspecifiedXSAIIZE2 = i14 != 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j3;
                                        TextDecoration textDecoration4 = i17 != 0 ? null : textDecoration;
                                        TextAlign textAlign4 = i19 != 0 ? null : textAlign;
                                        long jM9319getUnspecifiedXSAIIZE3 = i21 != 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j4;
                                        int iM9049getClipgIe3tQ8 = i24 != 0 ? TextOverflow.INSTANCE.m9049getClipgIe3tQ8() : i;
                                        if (i25 != 0) {
                                            z2 = true;
                                        }
                                        int i40 = i26 != 0 ? Integer.MAX_VALUE : i2;
                                        int i41 = i28 == 0 ? i3 : 1;
                                        Function1 function15 = i29 == 0 ? function1 : null;
                                        if ((i6 & 65536) != 0) {
                                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                            Modifier modifier4 = companion;
                                            function13 = function15;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            i27 &= -3670017;
                                            modifier3 = modifier4;
                                            textStyle3 = (TextStyle) objConsume;
                                        } else {
                                            function13 = function15;
                                            modifier3 = companion;
                                            textStyle3 = textStyle;
                                        }
                                        j9 = jM9319getUnspecifiedXSAIIZE3;
                                        function14 = function13;
                                        i33 = i41;
                                        i34 = iM9049getClipgIe3tQ8;
                                        textDecoration3 = textDecoration4;
                                        long j13 = jM9319getUnspecifiedXSAIIZE2;
                                        z4 = z2;
                                        j10 = jM6361getUnspecified0d7_KjU;
                                        i35 = i40;
                                        textAlign3 = textAlign4;
                                        fontFamily4 = fontFamily2;
                                        long j14 = jM9319getUnspecifiedXSAIIZE;
                                        fontStyle4 = fontStyle2;
                                        j11 = j14;
                                        fontWeight4 = fontWeight2;
                                        j12 = j13;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i6 & 65536) != 0) {
                                            i27 &= -3670017;
                                        }
                                        long j15 = jM9319getUnspecifiedXSAIIZE;
                                        fontStyle4 = fontStyle2;
                                        j11 = j15;
                                        modifier3 = modifier;
                                        textDecoration3 = textDecoration;
                                        textAlign3 = textAlign;
                                        j9 = j4;
                                        i34 = i;
                                        i35 = i2;
                                        i33 = i3;
                                        function14 = function1;
                                        textStyle3 = textStyle;
                                        z4 = z2;
                                        j10 = jM6361getUnspecified0d7_KjU;
                                        fontWeight4 = fontWeight2;
                                        fontFamily4 = fontFamily2;
                                        j12 = j3;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2055108902, i20, i27, "androidx.compose.material3.Text (Text.kt:283)");
                                    }
                                    int i42 = i20 << 3;
                                    int i43 = i27 << 3;
                                    composer2 = composerStartRestartGroup;
                                    m4288TextNvy7gAk(str, modifier3, j10, null, j11, fontStyle4, fontWeight4, fontFamily4, j12, textDecoration3, textAlign3, j9, i34, z4, i35, i33, function14, textStyle3, composer2, (i20 & 14) | 3072 | (i20 & 112) | (i20 & 896) | (57344 & i42) | (458752 & i42) | (3670016 & i42) | (29360128 & i42) | (234881024 & i42) | (i42 & 1879048192), ((i20 >> 27) & 14) | (i43 & 112) | (i43 & 896) | (i43 & 7168) | (57344 & i43) | (458752 & i43) | (3670016 & i43) | (i43 & 29360128), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier3;
                                    j5 = j10;
                                    j6 = j11;
                                    fontStyle3 = fontStyle4;
                                    fontWeight3 = fontWeight4;
                                    fontFamily3 = fontFamily4;
                                    j7 = j12;
                                    textDecoration2 = textDecoration3;
                                    textAlign2 = textAlign3;
                                    j8 = j9;
                                    i30 = i34;
                                    z3 = z4;
                                    i31 = i35;
                                    i32 = i33;
                                    function12 = function14;
                                    textStyle2 = textStyle3;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    modifier2 = modifier;
                                    textAlign2 = textAlign;
                                    i30 = i;
                                    i31 = i2;
                                    i32 = i3;
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
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return TextKt.Text__4IGK_g$lambda$9(str, modifier2, j5, j6, fontStyle3, fontWeight3, fontFamily3, j7, textDecoration2, textAlign2, j8, i30, z3, i31, i32, function12, textStyle2, i4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
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
                            if ((i5 & 1572864) == 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((i20 & 306783379) == 306783378 && (599187 & i27) == 599186) ? false : true, i20 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        z2 = z;
                        i26 = i6 & 8192;
                        if (i26 == 0) {
                        }
                        i28 = i6 & 16384;
                        if (i28 != 0) {
                        }
                        i29 = i6 & 32768;
                        if (i29 != 0) {
                        }
                        if ((i5 & 1572864) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i20 & 306783379) == 306783378 && (599187 & i27) == 599186) ? false : true, i20 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i17 = i16;
                    i18 = i6 & 512;
                    if (i18 != 0) {
                    }
                    i20 = i15;
                    i21 = i6 & 1024;
                    if (i21 != 0) {
                    }
                    i23 = i6 & 2048;
                    if (i23 != 0) {
                    }
                    int i382 = i22;
                    i25 = i6 & 4096;
                    if (i25 != 0) {
                    }
                    z2 = z;
                    i26 = i6 & 8192;
                    if (i26 == 0) {
                    }
                    i28 = i6 & 16384;
                    if (i28 != 0) {
                    }
                    i29 = i6 & 32768;
                    if (i29 != 0) {
                    }
                    if ((i5 & 1572864) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i20 & 306783379) == 306783378 && (599187 & i27) == 599186) ? false : true, i20 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i15 = i9;
                i16 = i6 & 256;
                if (i16 == 0) {
                }
                i17 = i16;
                i18 = i6 & 512;
                if (i18 != 0) {
                }
                i20 = i15;
                i21 = i6 & 1024;
                if (i21 != 0) {
                }
                i23 = i6 & 2048;
                if (i23 != 0) {
                }
                int i3822 = i22;
                i25 = i6 & 4096;
                if (i25 != 0) {
                }
                z2 = z;
                i26 = i6 & 8192;
                if (i26 == 0) {
                }
                i28 = i6 & 16384;
                if (i28 != 0) {
                }
                i29 = i6 & 32768;
                if (i29 != 0) {
                }
                if ((i5 & 1572864) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i20 & 306783379) == 306783378 && (599187 & i27) == 599186) ? false : true, i20 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            fontStyle2 = fontStyle;
            i12 = i6 & 32;
            if (i12 != 0) {
            }
            i13 = i6 & 64;
            if (i13 != 0) {
            }
            i14 = i6 & 128;
            if (i14 != 0) {
            }
            i15 = i9;
            i16 = i6 & 256;
            if (i16 == 0) {
            }
            i17 = i16;
            i18 = i6 & 512;
            if (i18 != 0) {
            }
            i20 = i15;
            i21 = i6 & 1024;
            if (i21 != 0) {
            }
            i23 = i6 & 2048;
            if (i23 != 0) {
            }
            int i38222 = i22;
            i25 = i6 & 4096;
            if (i25 != 0) {
            }
            z2 = z;
            i26 = i6 & 8192;
            if (i26 == 0) {
            }
            i28 = i6 & 16384;
            if (i28 != 0) {
            }
            i29 = i6 & 32768;
            if (i29 != 0) {
            }
            if ((i5 & 1572864) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i20 & 306783379) == 306783378 && (599187 & i27) == 599186) ? false : true, i20 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        i10 = i6 & 8;
        if (i10 == 0) {
        }
        i11 = i6 & 16;
        if (i11 == 0) {
        }
        fontStyle2 = fontStyle;
        i12 = i6 & 32;
        if (i12 != 0) {
        }
        i13 = i6 & 64;
        if (i13 != 0) {
        }
        i14 = i6 & 128;
        if (i14 != 0) {
        }
        i15 = i9;
        i16 = i6 & 256;
        if (i16 == 0) {
        }
        i17 = i16;
        i18 = i6 & 512;
        if (i18 != 0) {
        }
        i20 = i15;
        i21 = i6 & 1024;
        if (i21 != 0) {
        }
        i23 = i6 & 2048;
        if (i23 != 0) {
        }
        int i382222 = i22;
        i25 = i6 & 4096;
        if (i25 != 0) {
        }
        z2 = z;
        i26 = i6 & 8192;
        if (i26 == 0) {
        }
        i28 = i6 & 16384;
        if (i28 != 0) {
        }
        i29 = i6 & 32768;
        if (i29 != 0) {
        }
        if ((i5 & 1572864) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i20 & 306783379) == 306783378 && (599187 & i27) == 599186) ? false : true, i20 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:274:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012f  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with autoSize instead")
    /* JADX INFO: renamed from: Text-IbK3jfQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m4287TextIbK3jfQ(final AnnotatedString annotatedString, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Map map, Function1 function1, TextStyle textStyle, Composer composer, final int i4, final int i5, final int i6) {
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
        int i27;
        Composer composer2;
        final Modifier modifier2;
        final long j5;
        final TextDecoration textDecoration2;
        final int i28;
        final int i29;
        final int i30;
        final Map map2;
        final Function1 function12;
        final TextStyle textStyle2;
        final boolean z3;
        final FontStyle fontStyle3;
        final long j6;
        final FontWeight fontWeight3;
        final FontFamily fontFamily3;
        final long j7;
        final TextAlign textAlign2;
        final long j8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM6361getUnspecified0d7_KjU;
        int i31;
        TextAlign textAlign3;
        Function1 function13;
        FontStyle fontStyle4;
        long j9;
        TextAlign textAlign4;
        Function1 function14;
        TextStyle textStyle3;
        Map map3;
        boolean z4;
        int i32;
        int i33;
        FontWeight fontWeight4;
        FontFamily fontFamily4;
        long j10;
        int i34;
        long j11;
        Modifier modifier3;
        TextDecoration textDecoration3;
        Composer composerStartRestartGroup = composer.startRestartGroup(2027001676);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Text)N(text,modifier,color:c#ui.graphics.Color,fontSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,textAlign:c#ui.text.style.TextAlign,lineHeight:c#ui.unit.TextUnit,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,inlineContent,onTextLayout,style)329@15148L594:Text.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i7 = (composerStartRestartGroup.changed(annotatedString) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i35 = i6 & 2;
        if (i35 != 0) {
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
                    int i36 = i18;
                    i21 = i6 & 4096;
                    if (i21 == 0) {
                        i36 |= 384;
                    } else {
                        if ((i5 & 384) == 0) {
                            z2 = z;
                            i36 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
                        }
                        i22 = i6 & 8192;
                        if (i22 != 0) {
                            i23 = i36 | 3072;
                        } else {
                            int i37 = i36;
                            if ((i5 & 3072) == 0) {
                                i23 = i37 | (composerStartRestartGroup.changed(i2) ? 2048 : 1024);
                            } else {
                                i23 = i37;
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
                                i25 |= composerStartRestartGroup.changedInstance(map) ? 131072 : 65536;
                            }
                            i27 = i6 & 65536;
                            if (i27 == 0) {
                                i25 |= 1572864;
                            } else if ((i5 & 1572864) == 0) {
                                i25 |= composerStartRestartGroup.changedInstance(function1) ? 1048576 : 524288;
                            }
                            if ((i5 & 12582912) == 0) {
                                i25 |= ((i6 & 131072) == 0 && composerStartRestartGroup.changed(textStyle)) ? 8388608 : 4194304;
                            }
                            if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 4793491) != 4793490, i7 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier2 = modifier;
                                j5 = j;
                                textDecoration2 = textDecoration;
                                i28 = i;
                                i29 = i2;
                                i30 = i3;
                                map2 = map;
                                function12 = function1;
                                textStyle2 = textStyle;
                                z3 = z2;
                                fontStyle3 = fontStyle2;
                                j6 = jM9319getUnspecifiedXSAIIZE;
                                fontWeight3 = fontWeight2;
                                fontFamily3 = fontFamily2;
                                j7 = j3;
                                textAlign2 = textAlign;
                                j8 = j4;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "326@15089L2,327@15131L7");
                                if ((i4 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i35 != 0 ? Modifier.INSTANCE : modifier;
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
                                    TextAlign textAlign5 = i16 == 0 ? textAlign : null;
                                    long jM9319getUnspecifiedXSAIIZE3 = i17 != 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j4;
                                    int iM9049getClipgIe3tQ8 = i20 != 0 ? TextOverflow.INSTANCE.m9049getClipgIe3tQ8() : i;
                                    if (i21 != 0) {
                                        z2 = true;
                                    }
                                    int i38 = i22 != 0 ? Integer.MAX_VALUE : i2;
                                    i31 = i24 == 0 ? i3 : 1;
                                    Map mapEmptyMap = i26 != 0 ? MapsKt.emptyMap() : map;
                                    Modifier modifier4 = companion;
                                    if (i27 != 0) {
                                        textAlign3 = textAlign5;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1966515250, "CC(remember):Text.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda8
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj) {
                                                    return Unit.INSTANCE;
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
                                    if ((i6 & 131072) != 0) {
                                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                        Function1 function15 = function13;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        fontStyle4 = fontStyle2;
                                        j9 = jM9319getUnspecifiedXSAIIZE;
                                        textAlign4 = textAlign3;
                                        textStyle3 = (TextStyle) objConsume;
                                        map3 = mapEmptyMap;
                                        z4 = z2;
                                        i32 = iM9049getClipgIe3tQ8;
                                        i33 = i38;
                                        fontWeight4 = fontWeight2;
                                        fontFamily4 = fontFamily2;
                                        j10 = jM9319getUnspecifiedXSAIIZE2;
                                        i34 = i25 & (-29360129);
                                        j11 = jM9319getUnspecifiedXSAIIZE3;
                                        modifier3 = modifier4;
                                        function14 = function15;
                                    } else {
                                        fontStyle4 = fontStyle2;
                                        j9 = jM9319getUnspecifiedXSAIIZE;
                                        textAlign4 = textAlign3;
                                        function14 = function13;
                                        textStyle3 = textStyle;
                                        map3 = mapEmptyMap;
                                        z4 = z2;
                                        i32 = iM9049getClipgIe3tQ8;
                                        i33 = i38;
                                        fontWeight4 = fontWeight2;
                                        fontFamily4 = fontFamily2;
                                        j10 = jM9319getUnspecifiedXSAIIZE2;
                                        i34 = i25;
                                        j11 = jM9319getUnspecifiedXSAIIZE3;
                                        modifier3 = modifier4;
                                    }
                                    textDecoration3 = textDecoration4;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i6 & 131072) != 0) {
                                        i25 &= -29360129;
                                    }
                                    fontStyle4 = fontStyle2;
                                    j9 = jM9319getUnspecifiedXSAIIZE;
                                    jM6361getUnspecified0d7_KjU = j;
                                    textDecoration3 = textDecoration;
                                    textAlign4 = textAlign;
                                    i32 = i;
                                    i33 = i2;
                                    i31 = i3;
                                    map3 = map;
                                    function14 = function1;
                                    textStyle3 = textStyle;
                                    z4 = z2;
                                    fontWeight4 = fontWeight2;
                                    fontFamily4 = fontFamily2;
                                    i34 = i25;
                                    modifier3 = modifier;
                                    j10 = j3;
                                    j11 = j4;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2027001676, i7, i34, "androidx.compose.material3.Text (Text.kt:329)");
                                }
                                int i39 = i7 << 3;
                                int i40 = i34 << 3;
                                composer2 = composerStartRestartGroup;
                                long j12 = jM6361getUnspecified0d7_KjU;
                                Function1 function16 = function14;
                                TextStyle textStyle4 = textStyle3;
                                m4289TextZ58ophY(annotatedString, modifier3, j12, null, j9, fontStyle4, fontWeight4, fontFamily4, j10, textDecoration3, textAlign4, j11, i32, z4, i33, i31, map3, function16, textStyle4, composer2, (i7 & 14) | 3072 | (i7 & 112) | (i7 & 896) | (57344 & i39) | (458752 & i39) | (3670016 & i39) | (29360128 & i39) | (234881024 & i39) | (i39 & 1879048192), ((i7 >> 27) & 14) | (i40 & 112) | (i40 & 896) | (i40 & 7168) | (57344 & i40) | (458752 & i40) | (3670016 & i40) | (29360128 & i40) | (i40 & 234881024), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                j5 = j12;
                                j6 = j9;
                                fontStyle3 = fontStyle4;
                                fontWeight3 = fontWeight4;
                                fontFamily3 = fontFamily4;
                                j7 = j10;
                                textDecoration2 = textDecoration3;
                                textAlign2 = textAlign4;
                                j8 = j11;
                                i28 = i32;
                                z3 = z4;
                                i29 = i33;
                                i30 = i31;
                                map2 = map3;
                                function12 = function16;
                                textStyle2 = textStyle4;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TextKt.Text_IbK3jfQ$lambda$12(annotatedString, modifier2, j5, j6, fontStyle3, fontWeight3, fontFamily3, j7, textDecoration2, textAlign2, j8, i28, z3, i29, i30, map2, function12, textStyle2, i4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
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
                        i27 = i6 & 65536;
                        if (i27 == 0) {
                        }
                        if ((i5 & 12582912) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 4793491) != 4793490, i7 & 1)) {
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
                    i27 = i6 & 65536;
                    if (i27 == 0) {
                    }
                    if ((i5 & 12582912) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 4793491) != 4793490, i7 & 1)) {
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
                int i362 = i18;
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
                i27 = i6 & 65536;
                if (i27 == 0) {
                }
                if ((i5 & 12582912) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 4793491) != 4793490, i7 & 1)) {
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
            int i3622 = i18;
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
            i27 = i6 & 65536;
            if (i27 == 0) {
            }
            if ((i5 & 12582912) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 4793491) != 4793490, i7 & 1)) {
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
        int i36222 = i18;
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
        i27 = i6 & 65536;
        if (i27 == 0) {
        }
        if ((i5 & 12582912) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 4793491) != 4793490, i7 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:283:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0134  */
    /* JADX INFO: renamed from: Text-Nvy7gAk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4288TextNvy7gAk(final String str, Modifier modifier, long j, TextAutoSize textAutoSize, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        int i9;
        TextAutoSize textAutoSize2;
        int i10;
        long j5;
        int i11;
        FontStyle fontStyle2;
        int i12;
        FontWeight fontWeight2;
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
        int iM9049getClipgIe3tQ8;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        Composer composer2;
        final long j6;
        final boolean z2;
        final int i29;
        final int i30;
        final Function1<? super TextLayoutResult, Unit> function12;
        final TextStyle textStyle2;
        final int i31;
        final TextAutoSize textAutoSize3;
        final FontStyle fontStyle3;
        final Modifier modifier3;
        final long j7;
        final FontWeight fontWeight3;
        final FontFamily fontFamily2;
        final long j8;
        final TextDecoration textDecoration2;
        final TextAlign textAlign2;
        final long j9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM6361getUnspecified0d7_KjU;
        TextDecoration textDecoration3;
        TextAlign textAlign3;
        long j10;
        long j11;
        int i32;
        FontFamily fontFamily3;
        boolean z3;
        FontWeight fontWeight4;
        long j12;
        int i33;
        TextStyle textStyle3;
        FontStyle fontStyle4;
        Function1<? super TextLayoutResult, Unit> function13;
        int i34;
        long j13;
        long jM8586getColor0d7_KjU;
        Composer composerStartRestartGroup = composer.startRestartGroup(1809465675);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Text)N(text,modifier,color:c#ui.graphics.Color,autoSize,fontSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,textAlign:c#ui.text.style.TextAlign,lineHeight:c#ui.unit.TextUnit,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,onTextLayout,style)124@6409L698:Text.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i7 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i35 = i6 & 2;
        if (i35 != 0) {
            i7 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
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
            } else {
                if ((i4 & 3072) == 0) {
                    textAutoSize2 = textAutoSize;
                    i7 |= composerStartRestartGroup.changedInstance(textAutoSize2) ? 2048 : 1024;
                }
                i10 = i6 & 16;
                if (i10 != 0) {
                    i7 |= 24576;
                    j5 = j2;
                } else {
                    j5 = j2;
                    if ((i4 & 24576) == 0) {
                        i7 |= composerStartRestartGroup.changed(j5) ? 16384 : 8192;
                    }
                }
                i11 = i6 & 32;
                if (i11 != 0) {
                    i7 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    fontStyle2 = fontStyle;
                } else {
                    fontStyle2 = fontStyle;
                    if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i7 |= composerStartRestartGroup.changed(fontStyle2) ? 131072 : 65536;
                    }
                }
                i12 = i6 & 64;
                if (i12 != 0) {
                    i7 |= 1572864;
                    fontWeight2 = fontWeight;
                } else {
                    fontWeight2 = fontWeight;
                    if ((i4 & 1572864) == 0) {
                        i7 |= composerStartRestartGroup.changed(fontWeight2) ? 1048576 : 524288;
                    }
                }
                i13 = i6 & 128;
                if (i13 != 0) {
                    i7 |= 12582912;
                } else {
                    if ((i4 & 12582912) == 0) {
                        i14 = i13;
                        i7 |= composerStartRestartGroup.changed(fontFamily) ? 8388608 : 4194304;
                    }
                    i15 = i6 & 256;
                    if (i15 == 0) {
                        i7 |= 100663296;
                    } else if ((i4 & 100663296) == 0) {
                        i7 |= composerStartRestartGroup.changed(j3) ? 67108864 : 33554432;
                    }
                    i16 = i6 & 512;
                    if (i16 == 0) {
                        i7 |= 805306368;
                    } else {
                        if ((i4 & 805306368) == 0) {
                            i17 = i15;
                            i7 |= composerStartRestartGroup.changed(textDecoration) ? 536870912 : 268435456;
                        }
                        i18 = i6 & 1024;
                        if (i18 != 0) {
                            i20 = i5 | 6;
                            i19 = i18;
                        } else if ((i5 & 6) == 0) {
                            i19 = i18;
                            i20 = i5 | (composerStartRestartGroup.changed(textAlign) ? 4 : 2);
                        } else {
                            i19 = i18;
                            i20 = i5;
                        }
                        i21 = i6 & 2048;
                        if (i21 != 0) {
                            i20 |= 48;
                        } else if ((i5 & 48) == 0) {
                            i20 |= composerStartRestartGroup.changed(j4) ? 32 : 16;
                        }
                        int i36 = i20;
                        i22 = i6 & 4096;
                        if (i22 != 0) {
                            i36 |= 384;
                        } else {
                            if ((i5 & 384) == 0) {
                                iM9049getClipgIe3tQ8 = i;
                                i36 |= composerStartRestartGroup.changed(iM9049getClipgIe3tQ8) ? 256 : 128;
                            }
                            i23 = i6 & 8192;
                            if (i23 == 0) {
                                i24 = i36 | 3072;
                            } else {
                                int i37 = i36;
                                if ((i5 & 3072) == 0) {
                                    i24 = i37 | (composerStartRestartGroup.changed(z) ? 2048 : 1024);
                                } else {
                                    i24 = i37;
                                }
                            }
                            i25 = i6 & 16384;
                            if (i25 != 0) {
                                i26 = i24;
                                if ((i5 & 24576) == 0) {
                                    i26 |= composerStartRestartGroup.changed(i2) ? 16384 : 8192;
                                }
                                i27 = i6 & 32768;
                                if (i27 != 0) {
                                    i26 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i5 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i26 |= composerStartRestartGroup.changed(i3) ? 131072 : 65536;
                                }
                                i28 = i6 & 65536;
                                if (i28 != 0) {
                                    i26 |= 1572864;
                                } else if ((i5 & 1572864) == 0) {
                                    i26 |= composerStartRestartGroup.changedInstance(function1) ? 1048576 : 524288;
                                }
                                if ((i5 & 12582912) == 0) {
                                    i26 |= ((i6 & 131072) == 0 && composerStartRestartGroup.changed(textStyle)) ? 8388608 : 4194304;
                                }
                                if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i26 & 4793491) == 4793490) ? false : true, i7 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "119@6296L7");
                                    if ((i4 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i35 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        jM6361getUnspecified0d7_KjU = i8 != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j;
                                        if (i9 != 0) {
                                            textAutoSize2 = null;
                                        }
                                        long jM9319getUnspecifiedXSAIIZE = i10 != 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j5;
                                        if (i11 != 0) {
                                            fontStyle2 = null;
                                        }
                                        if (i12 != 0) {
                                            fontWeight2 = null;
                                        }
                                        FontFamily fontFamily4 = i14 != 0 ? null : fontFamily;
                                        long jM9319getUnspecifiedXSAIIZE2 = i17 != 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j3;
                                        TextDecoration textDecoration4 = i16 != 0 ? null : textDecoration;
                                        TextAlign textAlign4 = i19 != 0 ? null : textAlign;
                                        long jM9319getUnspecifiedXSAIIZE3 = i21 != 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j4;
                                        if (i22 != 0) {
                                            iM9049getClipgIe3tQ8 = TextOverflow.INSTANCE.m9049getClipgIe3tQ8();
                                        }
                                        boolean z4 = i23 != 0 ? true : z;
                                        int i38 = i25 != 0 ? Integer.MAX_VALUE : i2;
                                        int i39 = i27 == 0 ? i3 : 1;
                                        Function1<? super TextLayoutResult, Unit> function14 = i28 == 0 ? function1 : null;
                                        if ((i6 & 131072) != 0) {
                                            long j14 = jM6361getUnspecified0d7_KjU;
                                            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            textDecoration3 = textDecoration4;
                                            textAlign3 = textAlign4;
                                            j10 = jM9319getUnspecifiedXSAIIZE3;
                                            j11 = jM9319getUnspecifiedXSAIIZE2;
                                            i32 = i38;
                                            fontFamily3 = fontFamily4;
                                            z3 = z4;
                                            fontWeight4 = fontWeight2;
                                            j12 = jM9319getUnspecifiedXSAIIZE;
                                            i33 = i26 & (-29360129);
                                            textStyle3 = (TextStyle) objConsume;
                                            fontStyle4 = fontStyle2;
                                            jM6361getUnspecified0d7_KjU = j14;
                                        } else {
                                            textDecoration3 = textDecoration4;
                                            textAlign3 = textAlign4;
                                            j10 = jM9319getUnspecifiedXSAIIZE3;
                                            j11 = jM9319getUnspecifiedXSAIIZE2;
                                            i32 = i38;
                                            fontFamily3 = fontFamily4;
                                            z3 = z4;
                                            fontWeight4 = fontWeight2;
                                            j12 = jM9319getUnspecifiedXSAIIZE;
                                            i33 = i26;
                                            textStyle3 = textStyle;
                                            fontStyle4 = fontStyle2;
                                        }
                                        function13 = function14;
                                        i34 = i39;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i6 & 131072) != 0) {
                                            i26 &= -29360129;
                                        }
                                        jM6361getUnspecified0d7_KjU = j;
                                        fontFamily3 = fontFamily;
                                        j11 = j3;
                                        textDecoration3 = textDecoration;
                                        textAlign3 = textAlign;
                                        j10 = j4;
                                        z3 = z;
                                        i32 = i2;
                                        i34 = i3;
                                        textStyle3 = textStyle;
                                        fontWeight4 = fontWeight2;
                                        j12 = j5;
                                        i33 = i26;
                                        fontStyle4 = fontStyle2;
                                        function13 = function1;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        j13 = jM6361getUnspecified0d7_KjU;
                                        ComposerKt.traceEventStart(1809465675, i7, i33, "androidx.compose.material3.Text (Text.kt:120)");
                                    } else {
                                        j13 = jM6361getUnspecified0d7_KjU;
                                    }
                                    composerStartRestartGroup.startReplaceGroup(-565217106);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                                    if (j13 != 16) {
                                        jM8586getColor0d7_KjU = j13;
                                    } else {
                                        composerStartRestartGroup.startReplaceGroup(-565216333);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "*122@6392L7");
                                        jM8586getColor0d7_KjU = textStyle3.m8586getColor0d7_KjU();
                                        if (jM8586getColor0d7_KjU == 16) {
                                            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume2 = composerStartRestartGroup.consume(localContentColor);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            jM8586getColor0d7_KjU = ((Color) objConsume2).m6335unboximpl();
                                        }
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    long j15 = jM8586getColor0d7_KjU;
                                    int i40 = i33;
                                    int i41 = (i7 & 126) | ((i40 >> 9) & 7168);
                                    int i42 = i40 << 6;
                                    boolean z5 = z3;
                                    int i43 = i32;
                                    int i44 = i34;
                                    Function1<? super TextLayoutResult, Unit> function15 = function13;
                                    BasicTextKt.m2374BasicTextRWo7tUw(str, modifier2, TextStyle.m8576mergedA7vx0o$default(textStyle3, j15, j12, fontWeight4, fontStyle4, null, fontFamily3, null, j11, null, null, null, 0L, textDecoration3, null, null, textAlign3 != null ? textAlign3.m8991unboximpl() : TextAlign.INSTANCE.m8998getUnspecifiede0LSkKk(), 0, j10, null, null, 0, 0, null, null, 16609104, null), function15, iM9049getClipgIe3tQ8, z5, i43, i44, (ColorProducer) null, textAutoSize2, composerStartRestartGroup, (i42 & 29360128) | i41 | (57344 & i42) | (458752 & i42) | (3670016 & i42) | ((i7 << 18) & 1879048192), 256);
                                    composer2 = composerStartRestartGroup;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    FontWeight fontWeight5 = fontWeight4;
                                    i31 = iM9049getClipgIe3tQ8;
                                    textAutoSize3 = textAutoSize2;
                                    fontWeight3 = fontWeight5;
                                    textAlign2 = textAlign3;
                                    i29 = i43;
                                    function12 = function15;
                                    modifier3 = modifier2;
                                    j7 = j12;
                                    fontStyle3 = fontStyle4;
                                    fontFamily2 = fontFamily3;
                                    i30 = i44;
                                    textDecoration2 = textDecoration3;
                                    j9 = j10;
                                    j6 = j13;
                                    z2 = z5;
                                    long j16 = j11;
                                    textStyle2 = textStyle3;
                                    j8 = j16;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    j6 = j;
                                    z2 = z;
                                    i29 = i2;
                                    i30 = i3;
                                    function12 = function1;
                                    textStyle2 = textStyle;
                                    i31 = iM9049getClipgIe3tQ8;
                                    textAutoSize3 = textAutoSize2;
                                    fontStyle3 = fontStyle2;
                                    modifier3 = modifier2;
                                    j7 = j5;
                                    fontWeight3 = fontWeight2;
                                    fontFamily2 = fontFamily;
                                    j8 = j3;
                                    textDecoration2 = textDecoration;
                                    textAlign2 = textAlign;
                                    j9 = j4;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return TextKt.Text_Nvy7gAk$lambda$2(str, modifier3, j6, textAutoSize3, j7, fontStyle3, fontWeight3, fontFamily2, j8, textDecoration2, textAlign2, j9, i31, z2, i29, i30, function12, textStyle2, i4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i26 = i24 | 24576;
                            i27 = i6 & 32768;
                            if (i27 != 0) {
                            }
                            i28 = i6 & 65536;
                            if (i28 != 0) {
                            }
                            if ((i5 & 12582912) == 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i26 & 4793491) == 4793490) ? false : true, i7 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        iM9049getClipgIe3tQ8 = i;
                        i23 = i6 & 8192;
                        if (i23 == 0) {
                        }
                        i25 = i6 & 16384;
                        if (i25 != 0) {
                        }
                        i27 = i6 & 32768;
                        if (i27 != 0) {
                        }
                        i28 = i6 & 65536;
                        if (i28 != 0) {
                        }
                        if ((i5 & 12582912) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i26 & 4793491) == 4793490) ? false : true, i7 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i17 = i15;
                    i18 = i6 & 1024;
                    if (i18 != 0) {
                    }
                    i21 = i6 & 2048;
                    if (i21 != 0) {
                    }
                    int i362 = i20;
                    i22 = i6 & 4096;
                    if (i22 != 0) {
                    }
                    iM9049getClipgIe3tQ8 = i;
                    i23 = i6 & 8192;
                    if (i23 == 0) {
                    }
                    i25 = i6 & 16384;
                    if (i25 != 0) {
                    }
                    i27 = i6 & 32768;
                    if (i27 != 0) {
                    }
                    i28 = i6 & 65536;
                    if (i28 != 0) {
                    }
                    if ((i5 & 12582912) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i26 & 4793491) == 4793490) ? false : true, i7 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i14 = i13;
                i15 = i6 & 256;
                if (i15 == 0) {
                }
                i16 = i6 & 512;
                if (i16 == 0) {
                }
                i17 = i15;
                i18 = i6 & 1024;
                if (i18 != 0) {
                }
                i21 = i6 & 2048;
                if (i21 != 0) {
                }
                int i3622 = i20;
                i22 = i6 & 4096;
                if (i22 != 0) {
                }
                iM9049getClipgIe3tQ8 = i;
                i23 = i6 & 8192;
                if (i23 == 0) {
                }
                i25 = i6 & 16384;
                if (i25 != 0) {
                }
                i27 = i6 & 32768;
                if (i27 != 0) {
                }
                i28 = i6 & 65536;
                if (i28 != 0) {
                }
                if ((i5 & 12582912) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i26 & 4793491) == 4793490) ? false : true, i7 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            textAutoSize2 = textAutoSize;
            i10 = i6 & 16;
            if (i10 != 0) {
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
            i14 = i13;
            i15 = i6 & 256;
            if (i15 == 0) {
            }
            i16 = i6 & 512;
            if (i16 == 0) {
            }
            i17 = i15;
            i18 = i6 & 1024;
            if (i18 != 0) {
            }
            i21 = i6 & 2048;
            if (i21 != 0) {
            }
            int i36222 = i20;
            i22 = i6 & 4096;
            if (i22 != 0) {
            }
            iM9049getClipgIe3tQ8 = i;
            i23 = i6 & 8192;
            if (i23 == 0) {
            }
            i25 = i6 & 16384;
            if (i25 != 0) {
            }
            i27 = i6 & 32768;
            if (i27 != 0) {
            }
            i28 = i6 & 65536;
            if (i28 != 0) {
            }
            if ((i5 & 12582912) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i26 & 4793491) == 4793490) ? false : true, i7 & 1)) {
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
        textAutoSize2 = textAutoSize;
        i10 = i6 & 16;
        if (i10 != 0) {
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
        i14 = i13;
        i15 = i6 & 256;
        if (i15 == 0) {
        }
        i16 = i6 & 512;
        if (i16 == 0) {
        }
        i17 = i15;
        i18 = i6 & 1024;
        if (i18 != 0) {
        }
        i21 = i6 & 2048;
        if (i21 != 0) {
        }
        int i362222 = i20;
        i22 = i6 & 4096;
        if (i22 != 0) {
        }
        iM9049getClipgIe3tQ8 = i;
        i23 = i6 & 8192;
        if (i23 == 0) {
        }
        i25 = i6 & 16384;
        if (i25 != 0) {
        }
        i27 = i6 & 32768;
        if (i27 != 0) {
        }
        i28 = i6 & 65536;
        if (i28 != 0) {
        }
        if ((i5 & 12582912) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i26 & 4793491) == 4793490) ? false : true, i7 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:310:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0134  */
    /* JADX INFO: renamed from: Text-Z58ophY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m4289TextZ58ophY(final AnnotatedString annotatedString, Modifier modifier, long j, TextAutoSize textAutoSize, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Map<String, InlineTextContent> map, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        long jM6361getUnspecified0d7_KjU;
        int i9;
        int i10;
        long jM9319getUnspecifiedXSAIIZE;
        int i11;
        FontStyle fontStyle2;
        int i12;
        FontWeight fontWeight2;
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
        Composer composer2;
        final TextAutoSize textAutoSize2;
        final int i32;
        final boolean z2;
        final int i33;
        final int i34;
        final Map<String, InlineTextContent> map2;
        final Function1<? super TextLayoutResult, Unit> function12;
        final TextStyle textStyle2;
        final long j5;
        final Modifier modifier3;
        final FontStyle fontStyle3;
        final FontFamily fontFamily2;
        final long j6;
        final TextDecoration textDecoration2;
        final FontWeight fontWeight3;
        final long j7;
        final TextAlign textAlign2;
        final long j8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int iM9049getClipgIe3tQ8;
        boolean z3;
        int i35;
        int i36;
        Map<String, InlineTextContent> mapEmptyMap;
        TextAutoSize textAutoSize3;
        Function1<? super TextLayoutResult, Unit> function13;
        TextAlign textAlign3;
        TextAutoSize textAutoSize4;
        Function1<? super TextLayoutResult, Unit> function14;
        TextStyle textStyle3;
        FontWeight fontWeight4;
        FontFamily fontFamily3;
        TextDecoration textDecoration3;
        FontStyle fontStyle4;
        long j9;
        long j10;
        long j11;
        int i37;
        long j12;
        Composer composerStartRestartGroup = composer.startRestartGroup(292247417);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Text)N(text,modifier,color:c#ui.graphics.Color,autoSize,fontSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,textAlign:c#ui.text.style.TextAlign,lineHeight:c#ui.unit.TextUnit,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,inlineContent,onTextLayout,style)230@11970L24,232@12040L73,234@12119L759:Text.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i7 = (composerStartRestartGroup.changed(annotatedString) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i38 = i6 & 2;
        if (i38 != 0) {
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
            } else {
                if ((i4 & 3072) == 0) {
                    i7 |= composerStartRestartGroup.changedInstance(textAutoSize) ? 2048 : 1024;
                }
                i10 = i6 & 16;
                if (i10 != 0) {
                    i7 |= 24576;
                    jM9319getUnspecifiedXSAIIZE = j2;
                } else {
                    jM9319getUnspecifiedXSAIIZE = j2;
                    if ((i4 & 24576) == 0) {
                        i7 |= composerStartRestartGroup.changed(jM9319getUnspecifiedXSAIIZE) ? 16384 : 8192;
                    }
                }
                i11 = i6 & 32;
                if (i11 != 0) {
                    i7 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    fontStyle2 = fontStyle;
                } else {
                    fontStyle2 = fontStyle;
                    if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i7 |= composerStartRestartGroup.changed(fontStyle2) ? 131072 : 65536;
                    }
                }
                i12 = i6 & 64;
                if (i12 != 0) {
                    i7 |= 1572864;
                    fontWeight2 = fontWeight;
                } else {
                    fontWeight2 = fontWeight;
                    if ((i4 & 1572864) == 0) {
                        i7 |= composerStartRestartGroup.changed(fontWeight2) ? 1048576 : 524288;
                    }
                }
                i13 = i6 & 128;
                if (i13 != 0) {
                    i7 |= 12582912;
                } else {
                    if ((i4 & 12582912) == 0) {
                        i14 = i13;
                        i7 |= composerStartRestartGroup.changed(fontFamily) ? 8388608 : 4194304;
                    }
                    i15 = i6 & 256;
                    if (i15 == 0) {
                        i7 |= 100663296;
                    } else {
                        if ((i4 & 100663296) == 0) {
                            i16 = i7 | (composerStartRestartGroup.changed(j3) ? 67108864 : 33554432);
                        }
                        i17 = i6 & 512;
                        if (i17 != 0) {
                            i16 |= 805306368;
                            i18 = i17;
                        } else if ((i4 & 805306368) == 0) {
                            i18 = i17;
                            i16 |= composerStartRestartGroup.changed(textDecoration) ? 536870912 : 268435456;
                        } else {
                            i18 = i17;
                        }
                        i19 = i16;
                        i20 = i6 & 1024;
                        if (i20 != 0) {
                            i21 = i5 | 6;
                        } else if ((i5 & 6) == 0) {
                            i21 = i5 | (composerStartRestartGroup.changed(textAlign) ? 4 : 2);
                        } else {
                            i21 = i5;
                        }
                        i22 = i6 & 2048;
                        if (i22 != 0) {
                            i21 |= 48;
                            i23 = i22;
                        } else if ((i5 & 48) == 0) {
                            i23 = i22;
                            i21 |= composerStartRestartGroup.changed(j4) ? 32 : 16;
                        } else {
                            i23 = i22;
                        }
                        int i39 = i21;
                        i24 = i6 & 4096;
                        if (i24 != 0) {
                            i25 = i39 | 384;
                        } else {
                            int i40 = i39;
                            if ((i5 & 384) == 0) {
                                i40 |= composerStartRestartGroup.changed(i) ? 256 : 128;
                            }
                            i25 = i40;
                        }
                        i26 = i6 & 8192;
                        if (i26 != 0) {
                            i27 = i25 | 3072;
                        } else {
                            int i41 = i25;
                            if ((i5 & 3072) == 0) {
                                i27 = i41 | (composerStartRestartGroup.changed(z) ? 2048 : 1024);
                            } else {
                                i27 = i41;
                            }
                        }
                        i28 = i6 & 16384;
                        if (i28 == 0) {
                            if ((i5 & 24576) == 0) {
                                i27 |= composerStartRestartGroup.changed(i2) ? 16384 : 8192;
                            }
                            i29 = i6 & 32768;
                            if (i29 == 0) {
                                i27 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            } else if ((i5 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i27 |= composerStartRestartGroup.changed(i3) ? 131072 : 65536;
                            }
                            i30 = i6 & 65536;
                            if (i30 == 0) {
                                i27 |= 1572864;
                            } else if ((i5 & 1572864) == 0) {
                                i27 |= composerStartRestartGroup.changedInstance(map) ? 1048576 : 524288;
                            }
                            i31 = i6 & 131072;
                            if (i31 == 0) {
                                i27 |= 12582912;
                            } else if ((i5 & 12582912) == 0) {
                                i27 |= composerStartRestartGroup.changedInstance(function1) ? 8388608 : 4194304;
                            }
                            if ((i5 & 100663296) == 0) {
                                i27 |= ((i6 & 262144) == 0 && composerStartRestartGroup.changed(textStyle)) ? 67108864 : 33554432;
                            }
                            if (composerStartRestartGroup.shouldExecute((i19 & 306783379) == 306783378 || (38347923 & i27) != 38347922, i19 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                textAutoSize2 = textAutoSize;
                                i32 = i;
                                z2 = z;
                                i33 = i2;
                                i34 = i3;
                                map2 = map;
                                function12 = function1;
                                textStyle2 = textStyle;
                                j5 = jM6361getUnspecified0d7_KjU;
                                modifier3 = modifier2;
                                fontStyle3 = fontStyle2;
                                fontFamily2 = fontFamily;
                                j6 = j3;
                                textDecoration2 = textDecoration;
                                fontWeight3 = fontWeight2;
                                j7 = jM9319getUnspecifiedXSAIIZE;
                                textAlign2 = textAlign;
                                j8 = j4;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "226@11800L2,227@11842L7");
                                if ((i4 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i38 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i8 != 0) {
                                        jM6361getUnspecified0d7_KjU = Color.INSTANCE.m6361getUnspecified0d7_KjU();
                                    }
                                    TextAutoSize textAutoSize5 = i9 != 0 ? null : textAutoSize;
                                    if (i10 != 0) {
                                        jM9319getUnspecifiedXSAIIZE = TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE();
                                    }
                                    if (i11 != 0) {
                                        fontStyle2 = null;
                                    }
                                    if (i12 != 0) {
                                        fontWeight2 = null;
                                    }
                                    FontFamily fontFamily4 = i14 != 0 ? null : fontFamily;
                                    long jM9319getUnspecifiedXSAIIZE2 = i15 != 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j3;
                                    TextDecoration textDecoration4 = i18 != 0 ? null : textDecoration;
                                    TextAlign textAlign4 = i20 == 0 ? textAlign : null;
                                    long jM9319getUnspecifiedXSAIIZE3 = i23 != 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j4;
                                    iM9049getClipgIe3tQ8 = i24 != 0 ? TextOverflow.INSTANCE.m9049getClipgIe3tQ8() : i;
                                    z3 = i26 != 0 ? true : z;
                                    i35 = i28 != 0 ? Integer.MAX_VALUE : i2;
                                    i36 = i29 != 0 ? 1 : i3;
                                    mapEmptyMap = i30 != 0 ? MapsKt.emptyMap() : map;
                                    TextAlign textAlign5 = textAlign4;
                                    if (i31 != 0) {
                                        textAutoSize3 = textAutoSize5;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1676916987, "CC(remember):Text.kt#9igjgp");
                                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda4
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj) {
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        function13 = (Function1) objRememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    } else {
                                        textAutoSize3 = textAutoSize5;
                                        function13 = function1;
                                    }
                                    if ((i6 & 262144) != 0) {
                                        ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                                        Function1<? super TextLayoutResult, Unit> function15 = function13;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        textAlign3 = textAlign5;
                                        textStyle3 = (TextStyle) objConsume;
                                        fontWeight4 = fontWeight2;
                                        fontFamily3 = fontFamily4;
                                        textDecoration3 = textDecoration4;
                                        fontStyle4 = fontStyle2;
                                        j9 = jM9319getUnspecifiedXSAIIZE;
                                        j10 = jM9319getUnspecifiedXSAIIZE2;
                                        j11 = jM9319getUnspecifiedXSAIIZE3;
                                        textAutoSize4 = textAutoSize3;
                                        i37 = i27 & (-234881025);
                                        function14 = function15;
                                    } else {
                                        Function1<? super TextLayoutResult, Unit> function16 = function13;
                                        int i42 = i27;
                                        textAlign3 = textAlign5;
                                        textAutoSize4 = textAutoSize3;
                                        function14 = function16;
                                        textStyle3 = textStyle;
                                        fontWeight4 = fontWeight2;
                                        fontFamily3 = fontFamily4;
                                        textDecoration3 = textDecoration4;
                                        fontStyle4 = fontStyle2;
                                        j9 = jM9319getUnspecifiedXSAIIZE;
                                        j10 = jM9319getUnspecifiedXSAIIZE2;
                                        j11 = jM9319getUnspecifiedXSAIIZE3;
                                        i37 = i42;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i6 & 262144) != 0) {
                                        i27 &= -234881025;
                                    }
                                    textAutoSize4 = textAutoSize;
                                    fontFamily3 = fontFamily;
                                    j10 = j3;
                                    textDecoration3 = textDecoration;
                                    textAlign3 = textAlign;
                                    j11 = j4;
                                    iM9049getClipgIe3tQ8 = i;
                                    z3 = z;
                                    i35 = i2;
                                    i36 = i3;
                                    mapEmptyMap = map;
                                    textStyle3 = textStyle;
                                    fontWeight4 = fontWeight2;
                                    fontStyle4 = fontStyle2;
                                    j9 = jM9319getUnspecifiedXSAIIZE;
                                    i37 = i27;
                                    function14 = function1;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(292247417, i19, i37, "androidx.compose.material3.Text (Text.kt:228)");
                                }
                                composerStartRestartGroup.startReplaceGroup(1676919644);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                                if (jM6361getUnspecified0d7_KjU != 16) {
                                    j12 = jM6361getUnspecified0d7_KjU;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1676920417);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*229@11937L7");
                                    long jM8586getColor0d7_KjU = textStyle3.m8586getColor0d7_KjU();
                                    if (jM8586getColor0d7_KjU == 16) {
                                        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume2 = composerStartRestartGroup.consume(localContentColor);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        jM8586getColor0d7_KjU = ((Color) objConsume2).m6335unboximpl();
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    j12 = jM8586getColor0d7_KjU;
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                TextLinkStyles textLinkStylesRememberTextLinkStyles = rememberTextLinkStyles(composerStartRestartGroup, 0);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1676924738, "CC(remember):Text.kt#9igjgp");
                                boolean zChanged = ((i19 & 14) == 4) | composerStartRestartGroup.changed(textLinkStylesRememberTextLinkStyles);
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = createTextWithLinkStyles(annotatedString, textLinkStylesRememberTextLinkStyles);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                AnnotatedString annotatedString2 = (AnnotatedString) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                int i43 = (i19 & 112) | ((i37 >> 12) & 7168);
                                int i44 = i37 << 6;
                                TextAutoSize textAutoSize6 = textAutoSize4;
                                Function1<? super TextLayoutResult, Unit> function17 = function14;
                                BasicTextKt.m2372BasicTextCL7eQgs(annotatedString2, modifier2, TextStyle.m8576mergedA7vx0o$default(textStyle3, j12, j9, fontWeight4, fontStyle4, null, fontFamily3, null, j10, null, null, null, 0L, textDecoration3, null, null, textAlign3 != null ? textAlign3.m8991unboximpl() : TextAlign.INSTANCE.m8998getUnspecifiede0LSkKk(), 0, j11, null, null, 0, 0, null, null, 16609104, null), function17, iM9049getClipgIe3tQ8, z3, i35, i36, mapEmptyMap, null, textAutoSize6, composerStartRestartGroup, (i44 & 234881024) | i43 | (57344 & i44) | (458752 & i44) | (3670016 & i44) | (29360128 & i44), (i19 >> 9) & 14, 512);
                                composer2 = composerStartRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function12 = function17;
                                textAlign2 = textAlign3;
                                textAutoSize2 = textAutoSize6;
                                j5 = jM6361getUnspecified0d7_KjU;
                                modifier3 = modifier2;
                                i34 = i36;
                                map2 = mapEmptyMap;
                                textStyle2 = textStyle3;
                                fontWeight3 = fontWeight4;
                                fontStyle3 = fontStyle4;
                                fontFamily2 = fontFamily3;
                                j6 = j10;
                                textDecoration2 = textDecoration3;
                                i33 = i35;
                                z2 = z3;
                                j7 = j9;
                                i32 = iM9049getClipgIe3tQ8;
                                j8 = j11;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TextKt.Text_Z58ophY$lambda$8(annotatedString, modifier3, j5, textAutoSize2, j7, fontStyle3, fontWeight3, fontFamily2, j6, textDecoration2, textAlign2, j8, i32, z2, i33, i34, map2, function12, textStyle2, i4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i27 |= 24576;
                        i29 = i6 & 32768;
                        if (i29 == 0) {
                        }
                        i30 = i6 & 65536;
                        if (i30 == 0) {
                        }
                        i31 = i6 & 131072;
                        if (i31 == 0) {
                        }
                        if ((i5 & 100663296) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i19 & 306783379) == 306783378 || (38347923 & i27) != 38347922, i19 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    i16 = i7;
                    i17 = i6 & 512;
                    if (i17 != 0) {
                    }
                    i19 = i16;
                    i20 = i6 & 1024;
                    if (i20 != 0) {
                    }
                    i22 = i6 & 2048;
                    if (i22 != 0) {
                    }
                    int i392 = i21;
                    i24 = i6 & 4096;
                    if (i24 != 0) {
                    }
                    i26 = i6 & 8192;
                    if (i26 != 0) {
                    }
                    i28 = i6 & 16384;
                    if (i28 == 0) {
                    }
                    i29 = i6 & 32768;
                    if (i29 == 0) {
                    }
                    i30 = i6 & 65536;
                    if (i30 == 0) {
                    }
                    i31 = i6 & 131072;
                    if (i31 == 0) {
                    }
                    if ((i5 & 100663296) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i19 & 306783379) == 306783378 || (38347923 & i27) != 38347922, i19 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                i14 = i13;
                i15 = i6 & 256;
                if (i15 == 0) {
                }
                i16 = i7;
                i17 = i6 & 512;
                if (i17 != 0) {
                }
                i19 = i16;
                i20 = i6 & 1024;
                if (i20 != 0) {
                }
                i22 = i6 & 2048;
                if (i22 != 0) {
                }
                int i3922 = i21;
                i24 = i6 & 4096;
                if (i24 != 0) {
                }
                i26 = i6 & 8192;
                if (i26 != 0) {
                }
                i28 = i6 & 16384;
                if (i28 == 0) {
                }
                i29 = i6 & 32768;
                if (i29 == 0) {
                }
                i30 = i6 & 65536;
                if (i30 == 0) {
                }
                i31 = i6 & 131072;
                if (i31 == 0) {
                }
                if ((i5 & 100663296) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i19 & 306783379) == 306783378 || (38347923 & i27) != 38347922, i19 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i10 = i6 & 16;
            if (i10 != 0) {
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
            i14 = i13;
            i15 = i6 & 256;
            if (i15 == 0) {
            }
            i16 = i7;
            i17 = i6 & 512;
            if (i17 != 0) {
            }
            i19 = i16;
            i20 = i6 & 1024;
            if (i20 != 0) {
            }
            i22 = i6 & 2048;
            if (i22 != 0) {
            }
            int i39222 = i21;
            i24 = i6 & 4096;
            if (i24 != 0) {
            }
            i26 = i6 & 8192;
            if (i26 != 0) {
            }
            i28 = i6 & 16384;
            if (i28 == 0) {
            }
            i29 = i6 & 32768;
            if (i29 == 0) {
            }
            i30 = i6 & 65536;
            if (i30 == 0) {
            }
            i31 = i6 & 131072;
            if (i31 == 0) {
            }
            if ((i5 & 100663296) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i19 & 306783379) == 306783378 || (38347923 & i27) != 38347922, i19 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
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
        if (i10 != 0) {
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
        i14 = i13;
        i15 = i6 & 256;
        if (i15 == 0) {
        }
        i16 = i7;
        i17 = i6 & 512;
        if (i17 != 0) {
        }
        i19 = i16;
        i20 = i6 & 1024;
        if (i20 != 0) {
        }
        i22 = i6 & 2048;
        if (i22 != 0) {
        }
        int i392222 = i21;
        i24 = i6 & 4096;
        if (i24 != 0) {
        }
        i26 = i6 & 8192;
        if (i26 != 0) {
        }
        i28 = i6 & 16384;
        if (i28 == 0) {
        }
        i29 = i6 & 32768;
        if (i29 == 0) {
        }
        i30 = i6 & 65536;
        if (i30 == 0) {
        }
        i31 = i6 & 131072;
        if (i31 == 0) {
        }
        if ((i5 & 100663296) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i19 & 306783379) == 306783378 || (38347923 & i27) != 38347922, i19 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:249:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x011a  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* JADX INFO: renamed from: Text-fLXpl1I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m4290TextfLXpl1I(final String str, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, Function1 function1, TextStyle textStyle, Composer composer, final int i3, final int i4, final int i5) {
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
        Function1 function14;
        Modifier modifier4;
        TextAlign textAlign3;
        TextStyle textStyle3;
        TextDecoration textDecoration3;
        int i30;
        FontFamily fontFamily4;
        Function1 function15;
        int i31;
        long j9;
        boolean z4;
        long j10;
        FontStyle fontStyle4;
        long j11;
        FontWeight fontWeight4;
        long j12;
        Composer composerStartRestartGroup = composer.startRestartGroup(1968784669);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Text)N(text,modifier,color:c#ui.graphics.Color,fontSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,textAlign:c#ui.text.style.TextAlign,lineHeight:c#ui.unit.TextUnit,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,onTextLayout,style)374@16538L523:Text.kt#uh7d8r");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 6) == 0) {
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
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "371@16479L2,372@16521L7");
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
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2078487105, "CC(remember):Text.kt#9igjgp");
                                            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda6
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj) {
                                                        return Unit.INSTANCE;
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
                                            function14 = function13;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            i26 &= -458753;
                                            modifier4 = modifier3;
                                            textAlign3 = textAlign4;
                                            textStyle3 = (TextStyle) objConsume;
                                        } else {
                                            function14 = function13;
                                            modifier4 = modifier3;
                                            textAlign3 = textAlign4;
                                            textStyle3 = textStyle;
                                        }
                                        textDecoration3 = textDecoration4;
                                        i30 = iM9049getClipgIe3tQ8;
                                        fontFamily4 = fontFamily2;
                                        function15 = function14;
                                        long j13 = jM9319getUnspecifiedXSAIIZE2;
                                        i31 = i37;
                                        j9 = jM6361getUnspecified0d7_KjU;
                                        z4 = z5;
                                        j10 = jM9319getUnspecifiedXSAIIZE3;
                                        long j14 = jM9319getUnspecifiedXSAIIZE;
                                        fontStyle4 = fontStyle2;
                                        j11 = j14;
                                        fontWeight4 = fontWeight2;
                                        j12 = j13;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i5 & 32768) != 0) {
                                            i26 &= -458753;
                                        }
                                        long j15 = jM9319getUnspecifiedXSAIIZE;
                                        fontStyle4 = fontStyle2;
                                        j11 = j15;
                                        modifier4 = modifier;
                                        textDecoration3 = textDecoration;
                                        textAlign3 = textAlign;
                                        j10 = j4;
                                        i30 = i;
                                        i31 = i2;
                                        function15 = function1;
                                        textStyle3 = textStyle;
                                        z4 = z2;
                                        j9 = jM6361getUnspecified0d7_KjU;
                                        fontWeight4 = fontWeight2;
                                        fontFamily4 = fontFamily2;
                                        j12 = j3;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1968784669, i19, i26, "androidx.compose.material3.Text (Text.kt:373)");
                                    }
                                    int i38 = i19 << 3;
                                    int i39 = (i19 & 1022) | (57344 & i38) | (458752 & i38) | (3670016 & i38) | (29360128 & i38) | (234881024 & i38) | (i38 & 1879048192);
                                    int i40 = i26 << 3;
                                    int i41 = ((i19 >> 27) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i40 & 112) | (i40 & 896) | (i40 & 7168) | (i40 & 57344);
                                    int i42 = i26 << 6;
                                    composer2 = composerStartRestartGroup;
                                    m4288TextNvy7gAk(str, modifier4, j9, null, j11, fontStyle4, fontWeight4, fontFamily4, j12, textDecoration3, textAlign3, j10, i30, z4, i31, 1, function15, textStyle3, composer2, i39, i41 | (3670016 & i42) | (i42 & 29360128), 8);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier4;
                                    j5 = j9;
                                    j6 = j11;
                                    fontStyle3 = fontStyle4;
                                    fontWeight3 = fontWeight4;
                                    fontFamily3 = fontFamily4;
                                    j7 = j12;
                                    textDecoration2 = textDecoration3;
                                    textAlign2 = textAlign3;
                                    j8 = j10;
                                    i28 = i30;
                                    z3 = z4;
                                    i29 = i31;
                                    function12 = function15;
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
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda7
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return TextKt.Text_fLXpl1I$lambda$15(str, modifier2, j5, j6, fontStyle3, fontWeight3, fontFamily3, j7, textDecoration2, textAlign2, j8, i28, z3, i29, function12, textStyle2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
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

    static final Unit Text_IbK3jfQ$lambda$12(AnnotatedString annotatedString, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Map map, Function1 function1, TextStyle textStyle, int i4, int i5, int i6, Composer composer, int i7) {
        m4287TextIbK3jfQ(annotatedString, modifier, j, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, i3, map, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    static final Unit Text_Nvy7gAk$lambda$2(String str, Modifier modifier, long j, TextAutoSize textAutoSize, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Function1 function1, TextStyle textStyle, int i4, int i5, int i6, Composer composer, int i7) {
        m4288TextNvy7gAk(str, modifier, j, textAutoSize, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, i3, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    static final Unit Text_Z58ophY$lambda$8(AnnotatedString annotatedString, Modifier modifier, long j, TextAutoSize textAutoSize, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Map map, Function1 function1, TextStyle textStyle, int i4, int i5, int i6, Composer composer, int i7) {
        m4289TextZ58ophY(annotatedString, modifier, j, textAutoSize, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, i3, map, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    static final Unit Text__4IGK_g$lambda$18(AnnotatedString annotatedString, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, Map map, Function1 function1, TextStyle textStyle, int i3, int i4, int i5, Composer composer, int i6) {
        m4285Text4IGK_g(annotatedString, modifier, j, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, map, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    static final Unit Text__4IGK_g$lambda$9(String str, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Function1 function1, TextStyle textStyle, int i4, int i5, int i6, Composer composer, int i7) {
        m4286Text4IGK_g(str, modifier, j, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, i3, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    static final Unit Text_fLXpl1I$lambda$15(String str, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, Function1 function1, TextStyle textStyle, int i3, int i4, int i5, Composer composer, int i6) {
        m4290TextfLXpl1I(str, modifier, j, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    private static final AnnotatedString createTextWithLinkStyles(AnnotatedString annotatedString, final TextLinkStyles textLinkStyles) {
        return annotatedString.mapAnnotations(new Function1() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextKt.createTextWithLinkStyles$lambda$21(textLinkStyles, (AnnotatedString.Range) obj);
            }
        });
    }

    static final AnnotatedString.Range createTextWithLinkStyles$lambda$21(TextLinkStyles textLinkStyles, AnnotatedString.Range range) {
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
        ComposerKt.sourceInformationMarkerStart(composer, 1113329403, "C(rememberTextLinkStyles)482@20251L11,483@20282L159:Text.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1113329403, i, -1, "androidx.compose.material3.rememberTextLinkStyles (Text.kt:481)");
        }
        long primary = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getPrimary();
        ComposerKt.sourceInformationMarkerStart(composer, 462704058, "CC(remember):Text.kt#9igjgp");
        boolean zChanged = composer.changed(primary);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            TextLinkStyles textLinkStyles = new TextLinkStyles(new SpanStyle(primary, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.INSTANCE.getUnderline(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61438, (DefaultConstructorMarker) null), null, null, null, 14, null);
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
