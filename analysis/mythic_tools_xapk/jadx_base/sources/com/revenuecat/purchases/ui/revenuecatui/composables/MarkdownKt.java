package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.Link;
import org.commonmark.node.ListBlock;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.parser.Parser;

/* JADX INFO: compiled from: Markdown.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ah\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a>\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a`\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001ah\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u001f\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0003¢\u0006\u0002\u0010.\u001ar\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u0002012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0003ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a\u0092\u0001\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u0002062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2&\u00107\u001a\"\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u000408¢\u0006\u0002\b<H\u0003ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a`\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001ah\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020F2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\bG\u0010H\u001a\u008e\u0001\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020K2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010L\u001a\u00020M2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0014H\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010O\u001a/\u0010P\u001a\u00020\u00042\u0006\u0010J\u001a\u00020Q2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0003¢\u0006\u0002\u0010R\u001a\u0018\u0010S\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010T\u001a\u00020\nH\u0002\u001a8\u0010U\u001a\u00020\u0004*\u00020V2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\bW\u0010X\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Y"}, d2 = {"parser", "Lorg/commonmark/parser/Parser;", "kotlin.jvm.PlatformType", "MDBlockChildren", "", "parent", "Lorg/commonmark/node/Node;", "color", "Landroidx/compose/ui/graphics/Color;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Landroidx/compose/ui/text/TextStyle;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "allowLinks", "", "textFillMaxWidth", "applyFontSizeToParagraph", "MDBlockChildren-d8Fo1UA", "(Lorg/commonmark/node/Node;JLandroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/style/TextAlign;ZZZLandroidx/compose/runtime/Composer;I)V", "MDBlockQuote", "blockQuote", "Lorg/commonmark/node/BlockQuote;", "baseFontWeight", "modifier", "Landroidx/compose/ui/Modifier;", "MDBlockQuote-8V94_ZQ", "(Lorg/commonmark/node/BlockQuote;JZLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "MDBulletList", "bulletList", "Lorg/commonmark/node/BulletList;", "MDBulletList-lzeOXFE", "(Lorg/commonmark/node/BulletList;JLandroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/style/TextAlign;ZZLandroidx/compose/runtime/Composer;I)V", "MDDocument", "document", "Lorg/commonmark/node/Document;", "MDDocument-d8Fo1UA", "(Lorg/commonmark/node/Document;JLandroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/style/TextAlign;ZZZLandroidx/compose/runtime/Composer;I)V", "MDFencedCodeBlock", "fencedCodeBlock", "Lorg/commonmark/node/FencedCodeBlock;", "(Lorg/commonmark/node/FencedCodeBlock;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "MDHeading", "heading", "Lorg/commonmark/node/Heading;", "MDHeading-JFVkrdg", "(Lorg/commonmark/node/Heading;JLandroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/style/TextAlign;ZZZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;III)V", "MDListItems", "listBlock", "Lorg/commonmark/node/ListBlock;", "item", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "node", "Landroidx/compose/runtime/Composable;", "MDListItems-JFVkrdg", "(Lorg/commonmark/node/ListBlock;JLandroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/style/TextAlign;ZZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "MDOrderedList", "orderedList", "Lorg/commonmark/node/OrderedList;", "MDOrderedList-lzeOXFE", "(Lorg/commonmark/node/OrderedList;JLandroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/style/TextAlign;ZZLandroidx/compose/runtime/Composer;I)V", "MDParagraph", "paragraph", "Lorg/commonmark/node/Paragraph;", "MDParagraph-d8Fo1UA", "(Lorg/commonmark/node/Paragraph;JLandroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/style/TextAlign;ZZZLandroidx/compose/runtime/Composer;I)V", "Markdown", "text", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "Markdown-DkhmgE0", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/text/style/TextAlign;ZZZLandroidx/compose/runtime/Composer;III)V", "MarkdownText", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "resolveMarkdownTextStyle", "overrides", "appendMarkdownChildren", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "appendMarkdownChildren-XO-JAsU", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Lorg/commonmark/node/Node;JZLandroidx/compose/ui/text/font/FontWeight;)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MarkdownKt {
    private static final Parser parser = Parser.builder().extensions(CollectionsKt.listOf(StrikethroughExtension.create())).build();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: MDBlockChildren-d8Fo1UA, reason: not valid java name */
    public static final void m10634MDBlockChildrend8Fo1UA(final Node node, final long j, final TextStyle textStyle, final long j2, final FontWeight fontWeight, final FontFamily fontFamily, final TextAlign textAlign, final boolean z, final boolean z2, final boolean z3, Composer composer, final int i) {
        int i2;
        boolean z4;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(2035102511);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MDBlockChildren)P(6,2:c#ui.graphics.Color,7,4:c#ui.unit.TextUnit,5,3,8:c#ui.text.style.TextAlign!1,9):Markdown.kt#51odh9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(node) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        TextStyle textStyle2 = textStyle;
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 2048 : 1024;
        }
        FontWeight fontWeight2 = fontWeight;
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(fontWeight2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(fontFamily) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(textAlign) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            z4 = z;
            i2 |= composerStartRestartGroup.changed(z4) ? 8388608 : 4194304;
        } else {
            z4 = z;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
        }
        boolean z5 = z3;
        if ((i & 805306368) == 0) {
            i2 |= composerStartRestartGroup.changed(z5) ? 536870912 : 268435456;
        }
        if ((i2 & 306783379) == 306783378 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2035102511, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MDBlockChildren (Markdown.kt:457)");
            }
            Node firstChild = node.getFirstChild();
            while (firstChild != null) {
                if (firstChild instanceof BlockQuote) {
                    composerStartRestartGroup.startReplaceGroup(-1935094073);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "461@14519L67");
                    int i4 = i2;
                    i3 = i4;
                    m10635MDBlockQuote8V94_ZQ((BlockQuote) firstChild, j, z4, fontWeight2, null, composerStartRestartGroup, ((i4 >> 15) & 896) | (i4 & 112) | ((i4 >> 3) & 7168), 16);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    i3 = i2;
                    if (firstChild instanceof Heading) {
                        composerStartRestartGroup.startReplaceGroup(-1935090826);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "462@14613L306");
                        m10638MDHeadingJFVkrdg((Heading) firstChild, j, textStyle2, j2, fontWeight, fontFamily, textAlign, z, z2, z5, null, composerStartRestartGroup, i3 & 2147483632, 0, 1024);
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (firstChild instanceof Paragraph) {
                        composerStartRestartGroup.startReplaceGroup(-1935080104);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "474@14948L308");
                        m10641MDParagraphd8Fo1UA((Paragraph) firstChild, j, textStyle, j2, fontWeight, fontFamily, textAlign, z, z2, z3, composerStartRestartGroup, i3 & 2147483632);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        if (firstChild instanceof FencedCodeBlock) {
                            composerStartRestartGroup.startReplaceGroup(-1935069412);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "486@15291L24");
                            MDFencedCodeBlock((FencedCodeBlock) firstChild, null, composerStartRestartGroup, 0, 2);
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (firstChild instanceof BulletList) {
                            composerStartRestartGroup.startReplaceGroup(-1935067441);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "487@15345L267");
                            m10636MDBulletListlzeOXFE((BulletList) firstChild, j, textStyle, j2, fontWeight, fontFamily, textAlign, z, z2, composerStartRestartGroup, i3 & 268435440);
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (firstChild instanceof OrderedList) {
                            composerStartRestartGroup.startReplaceGroup(-1935057904);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "498@15643L268");
                            m10640MDOrderedListlzeOXFE((OrderedList) firstChild, j, textStyle, j2, fontWeight, fontFamily, textAlign, z, z2, composerStartRestartGroup, i3 & 268435440);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(143014590);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        firstChild = firstChild.getNext();
                        textStyle2 = textStyle;
                        fontWeight2 = fontWeight;
                        z4 = z;
                        z5 = z3;
                        i2 = i3;
                    }
                }
                firstChild = firstChild.getNext();
                textStyle2 = textStyle;
                fontWeight2 = fontWeight;
                z4 = z;
                z5 = z3;
                i2 = i3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDBlockChildren$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    MarkdownKt.m10634MDBlockChildrend8Fo1UA(node, j, textStyle, j2, fontWeight, fontFamily, textAlign, z, z2, z3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: MDBlockQuote-8V94_ZQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10635MDBlockQuote8V94_ZQ(final BlockQuote blockQuote, final long j, final boolean z, final FontWeight fontWeight, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        FontWeight fontWeight2;
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        Object objRememberedValue;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(628112800);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MDBlockQuote)P(2,3:c#ui.graphics.Color)410@12952L245,408@12895L731:Markdown.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(blockQuote) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    fontWeight2 = fontWeight;
                    i3 |= composerStartRestartGroup.changed(fontWeight2) ? 2048 : 1024;
                }
                i4 = i2 & 16;
                if (i4 == 0) {
                    if ((i & 24576) == 0) {
                        modifier2 = modifier;
                        i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
                    }
                    i5 = i3;
                    if ((i5 & 9363) == 9362 || !composerStartRestartGroup.getSkipping()) {
                        if (i4 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(628112800, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MDBlockQuote (Markdown.kt:407)");
                        }
                        composerStartRestartGroup.startReplaceGroup(1137412140);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Markdown.kt#9igjgp");
                        z3 = (i5 & 112) != 32;
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDBlockQuote$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                    invoke2(drawScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(DrawScope drawBehind) {
                                    Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                                    DrawScope.m6885drawLineNGM6Ib0$default(drawBehind, j, OffsetKt.Offset(Dp.m9114constructorimpl(12.0f), 0.0f), OffsetKt.Offset(Dp.m9114constructorimpl(12.0f), Size.m6146getHeightimpl(drawBehind.mo6899getSizeNHjbRc())), 2.0f, 0, null, 0.0f, null, 0, 496, null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(DrawModifierKt.drawBehind(modifier2, (Function1) objRememberedValue), Dp.m9114constructorimpl(16.0f), Dp.m9114constructorimpl(4.0f), 0.0f, Dp.m9114constructorimpl(4.0f), 4, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2041paddingqDBjuR0$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.useNode();
                        } else {
                            composerStartRestartGroup.createNode(constructor);
                        }
                        composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1342324553, "C428@13600L20:Markdown.kt#51odh9");
                        composerStartRestartGroup.startReplaceGroup(95246852);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*422@13365L10");
                        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                        builder.pushStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge().toSpanStyle().plus(new SpanStyle(0L, 0L, (FontWeight) null, FontStyle.m8665boximpl(FontStyle.INSTANCE.m8674getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65527, (DefaultConstructorMarker) null)));
                        m10652appendMarkdownChildrenXOJAsU(builder, blockQuote, j, z2, fontWeight2);
                        builder.pop();
                        AnnotatedString annotatedString = builder.toAnnotatedString();
                        composerStartRestartGroup.endReplaceGroup();
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier2;
                        TextKt.m4287TextIbK3jfQ(annotatedString, modifier3, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, null, composer2, (i5 >> 9) & 112, 0, 262140);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDBlockQuote$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i6) {
                                MarkdownKt.m10635MDBlockQuote8V94_ZQ(blockQuote, j, z, fontWeight, modifier3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                modifier2 = modifier;
                i5 = i3;
                if ((i5 & 9363) == 9362) {
                    if (i4 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composerStartRestartGroup.startReplaceGroup(1137412140);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Markdown.kt#9igjgp");
                    if ((i5 & 112) != 32) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        objRememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDBlockQuote$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                invoke2(drawScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DrawScope drawBehind) {
                                Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                                DrawScope.m6885drawLineNGM6Ib0$default(drawBehind, j, OffsetKt.Offset(Dp.m9114constructorimpl(12.0f), 0.0f), OffsetKt.Offset(Dp.m9114constructorimpl(12.0f), Size.m6146getHeightimpl(drawBehind.mo6899getSizeNHjbRc())), 2.0f, 0, null, 0.0f, null, 0, 496, null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifierM2041paddingqDBjuR0$default2 = PaddingKt.m2041paddingqDBjuR0$default(DrawModifierKt.drawBehind(modifier2, (Function1) objRememberedValue), Dp.m9114constructorimpl(16.0f), Dp.m9114constructorimpl(4.0f), 0.0f, Dp.m9114constructorimpl(4.0f), 4, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2041paddingqDBjuR0$default2);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                        }
                        composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5595constructorimpl.getInserting()) {
                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1342324553, "C428@13600L20:Markdown.kt#51odh9");
                            composerStartRestartGroup.startReplaceGroup(95246852);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*422@13365L10");
                            AnnotatedString.Builder builder2 = new AnnotatedString.Builder(0, 1, null);
                            builder2.pushStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge().toSpanStyle().plus(new SpanStyle(0L, 0L, (FontWeight) null, FontStyle.m8665boximpl(FontStyle.INSTANCE.m8674getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65527, (DefaultConstructorMarker) null)));
                            m10652appendMarkdownChildrenXOJAsU(builder2, blockQuote, j, z2, fontWeight2);
                            builder2.pop();
                            AnnotatedString annotatedString2 = builder2.toAnnotatedString();
                            composerStartRestartGroup.endReplaceGroup();
                            composer2 = composerStartRestartGroup;
                            modifier3 = modifier2;
                            TextKt.m4287TextIbK3jfQ(annotatedString2, modifier3, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, null, composer2, (i5 >> 9) & 112, 0, 262140);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            fontWeight2 = fontWeight;
            i4 = i2 & 16;
            if (i4 == 0) {
            }
            modifier2 = modifier;
            i5 = i3;
            if ((i5 & 9363) == 9362) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        z2 = z;
        if ((i2 & 8) == 0) {
        }
        fontWeight2 = fontWeight;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i3;
        if ((i5 & 9363) == 9362) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: MDBulletList-lzeOXFE, reason: not valid java name */
    public static final void m10636MDBulletListlzeOXFE(final BulletList bulletList, final long j, final TextStyle textStyle, final long j2, final FontWeight fontWeight, final FontFamily fontFamily, final TextAlign textAlign, final boolean z, final boolean z2, Composer composer, final int i) {
        int i2;
        long j3;
        long j4;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        boolean z3;
        boolean z4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1037984523);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MDBulletList)P(1,2:c#ui.graphics.Color,6,4:c#ui.unit.TextUnit,5,3,7:c#ui.text.style.TextAlign)279@9037L395,269@8748L684:Markdown.kt#51odh9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(bulletList) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            j3 = j;
            i2 |= composerStartRestartGroup.changed(j3) ? 32 : 16;
        } else {
            j3 = j;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            j4 = j2;
            i2 |= composerStartRestartGroup.changed(j4) ? 2048 : 1024;
        } else {
            j4 = j2;
        }
        if ((i & 24576) == 0) {
            fontWeight2 = fontWeight;
            i2 |= composerStartRestartGroup.changed(fontWeight2) ? 16384 : 8192;
        } else {
            fontWeight2 = fontWeight;
        }
        if ((196608 & i) == 0) {
            fontFamily2 = fontFamily;
            i2 |= composerStartRestartGroup.changed(fontFamily2) ? 131072 : 65536;
        } else {
            fontFamily2 = fontFamily;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(textAlign) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            z3 = z;
            i2 |= composerStartRestartGroup.changed(z3) ? 8388608 : 4194304;
        } else {
            z3 = z;
        }
        if ((100663296 & i) == 0) {
            z4 = z2;
            i2 |= composerStartRestartGroup.changed(z4) ? 67108864 : 33554432;
        } else {
            z4 = z2;
        }
        if ((38347923 & i2) == 38347922 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1037984523, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MDBulletList (Markdown.kt:257)");
            }
            final char bulletMarker = bulletList.getBulletMarker();
            final TextStyle textStyleResolveMarkdownTextStyle = resolveMarkdownTextStyle(textStyle, new TextStyle(j3, j4, fontWeight2, (FontStyle) null, (FontSynthesis) null, fontFamily2, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, textAlign != null ? textAlign.m8991unboximpl() : TextAlign.INSTANCE.m8998getUnspecifiede0LSkKk(), 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16744408, (DefaultConstructorMarker) null));
            final boolean z5 = z3;
            final boolean z6 = z4;
            m10639MDListItemsJFVkrdg(bulletList, j, textStyle, j2, fontWeight, fontFamily, textAlign, z, z2, null, ComposableLambdaKt.rememberComposableLambda(1682895250, true, new Function3<Node, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDBulletList$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Node node, Composer composer2, Integer num) {
                    invoke(node, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Node it, Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation(composer2, "C286@9290L136:Markdown.kt#51odh9");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1682895250, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MDBulletList.<anonymous> (Markdown.kt:280)");
                    }
                    TextStyle textStyle2 = textStyleResolveMarkdownTextStyle;
                    char c = bulletMarker;
                    long j5 = j;
                    boolean z7 = z5;
                    FontWeight fontWeight3 = fontWeight;
                    AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                    builder.pushStyle(textStyle2.toSpanStyle());
                    builder.append(new StringBuilder().append(c).append(' ').toString());
                    MarkdownKt.m10652appendMarkdownChildrenXOJAsU(builder, it, j5, z7, fontWeight3);
                    builder.pop();
                    MarkdownKt.MarkdownText(builder.toAnnotatedString(), textStyleResolveMarkdownTextStyle, z6, null, composer2, 0, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, i2 & 268435454, 6, 512);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDBulletList$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    MarkdownKt.m10636MDBulletListlzeOXFE(bulletList, j, textStyle, j2, fontWeight, fontFamily, textAlign, z, z2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: MDDocument-d8Fo1UA, reason: not valid java name */
    public static final void m10637MDDocumentd8Fo1UA(final Document document, final long j, final TextStyle textStyle, final long j2, final FontWeight fontWeight, final FontFamily fontFamily, final TextAlign textAlign, final boolean z, final boolean z2, final boolean z3, Composer composer, final int i) {
        int i2;
        long j3;
        TextStyle textStyle2;
        long j4;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        TextAlign textAlign2;
        boolean z4;
        boolean z5;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-196481521);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MDDocument)P(3,2:c#ui.graphics.Color,7,5:c#ui.unit.TextUnit,6,4,8:c#ui.text.style.TextAlign!1,9)130@4708L227:Markdown.kt#51odh9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(document) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            j3 = j;
            i2 |= composerStartRestartGroup.changed(j3) ? 32 : 16;
        } else {
            j3 = j;
        }
        if ((i & 384) == 0) {
            textStyle2 = textStyle;
            i2 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
        } else {
            textStyle2 = textStyle;
        }
        if ((i & 3072) == 0) {
            j4 = j2;
            i2 |= composerStartRestartGroup.changed(j4) ? 2048 : 1024;
        } else {
            j4 = j2;
        }
        if ((i & 24576) == 0) {
            fontWeight2 = fontWeight;
            i2 |= composerStartRestartGroup.changed(fontWeight2) ? 16384 : 8192;
        } else {
            fontWeight2 = fontWeight;
        }
        if ((196608 & i) == 0) {
            fontFamily2 = fontFamily;
            i2 |= composerStartRestartGroup.changed(fontFamily2) ? 131072 : 65536;
        } else {
            fontFamily2 = fontFamily;
        }
        if ((1572864 & i) == 0) {
            textAlign2 = textAlign;
            i2 |= composerStartRestartGroup.changed(textAlign2) ? 1048576 : 524288;
        } else {
            textAlign2 = textAlign;
        }
        if ((12582912 & i) == 0) {
            z4 = z;
            i2 |= composerStartRestartGroup.changed(z4) ? 8388608 : 4194304;
        } else {
            z4 = z;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            z5 = z3;
            i2 |= composerStartRestartGroup.changed(z5) ? 536870912 : 268435456;
        } else {
            z5 = z3;
        }
        if ((i2 & 306783379) == 306783378 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                composer2 = composerStartRestartGroup;
                ComposerKt.traceEventStart(-196481521, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MDDocument (Markdown.kt:129)");
            } else {
                composer2 = composerStartRestartGroup;
            }
            boolean z6 = z5;
            m10634MDBlockChildrend8Fo1UA(document, j3, textStyle2, j4, fontWeight2, fontFamily2, textAlign2, z4, z2, z6, composer2, i2 & 2147483646);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDDocument$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    MarkdownKt.m10637MDDocumentd8Fo1UA(document, j, textStyle, j2, fontWeight, fontFamily, textAlign, z, z2, z3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MDFencedCodeBlock(final FencedCodeBlock fencedCodeBlock, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-731493168);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MDFencedCodeBlock)435@13816L239:Markdown.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(fencedCodeBlock) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i3 & 19) == 18 || !composerStartRestartGroup.getSkipping()) {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-731493168, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MDFencedCodeBlock (Markdown.kt:433)");
                }
                Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(modifier2, Dp.m9114constructorimpl(8.0f), 0.0f, 0.0f, !(fencedCodeBlock.getParent() instanceof Document) ? Dp.m9114constructorimpl(8.0f) : Dp.m9114constructorimpl(0.0f), 6, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2041paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.useNode();
                } else {
                    composerStartRestartGroup.createNode(constructor);
                }
                composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 622282625, "C436@13891L158:Markdown.kt#51odh9");
                composer2 = composerStartRestartGroup;
                String literal = fencedCodeBlock.getLiteral();
                TextStyle textStyle = new TextStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullExpressionValue(literal, "literal");
                int i5 = i3 & 112;
                modifier3 = modifier2;
                TextKt.m4286Text4IGK_g(literal, modifier3, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, textStyle, composer2, i5, 0, 65532);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                composer2 = composerStartRestartGroup;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt.MDFencedCodeBlock.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i6) {
                        MarkdownKt.MDFencedCodeBlock(fencedCodeBlock, modifier3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i3 & 19) == 18) {
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (!(fencedCodeBlock.getParent() instanceof Document)) {
            }
            Modifier modifierM2041paddingqDBjuR0$default2 = PaddingKt.m2041paddingqDBjuR0$default(modifier2, Dp.m9114constructorimpl(8.0f), 0.0f, 0.0f, !(fencedCodeBlock.getParent() instanceof Document) ? Dp.m9114constructorimpl(8.0f) : Dp.m9114constructorimpl(0.0f), 6, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2041paddingqDBjuR0$default2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
            }
            composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5595constructorimpl.getInserting()) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 622282625, "C436@13891L158:Markdown.kt#51odh9");
                composer2 = composerStartRestartGroup;
                String literal2 = fencedCodeBlock.getLiteral();
                TextStyle textStyle2 = new TextStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullExpressionValue(literal2, "literal");
                int i52 = i3 & 112;
                modifier3 = modifier2;
                TextKt.m4286Text4IGK_g(literal2, modifier3, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, textStyle2, composer2, i52, 0, 65532);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fe  */
    /* JADX INFO: renamed from: MDHeading-JFVkrdg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10638MDHeadingJFVkrdg(final Heading heading, final long j, final TextStyle textStyle, final long j2, final FontWeight fontWeight, final FontFamily fontFamily, final TextAlign textAlign, final boolean z, final boolean z2, final boolean z3, Modifier modifier, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        TextStyle textStyle2;
        long j3;
        FontWeight fontWeight2;
        int i5;
        int i6;
        int i7;
        TextStyle headlineLarge;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final Modifier modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-553094650);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MDHeading)P(6,2:c#ui.graphics.Color,8,4:c#ui.unit.TextUnit,5,3,9:c#ui.text.style.TextAlign!1,10)185@6170L728:Markdown.kt#51odh9");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(heading) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(j) ? 32 : 16;
            }
            if ((i3 & 4) == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    textStyle2 = textStyle;
                    i4 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                if ((i3 & 8) != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        j3 = j2;
                        i4 |= composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                    }
                    if ((i3 & 16) == 0) {
                        i4 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            fontWeight2 = fontWeight;
                            i4 |= composerStartRestartGroup.changed(fontWeight2) ? 16384 : 8192;
                        }
                        if ((i3 & 32) != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else {
                            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i4 |= composerStartRestartGroup.changed(fontFamily) ? 131072 : 65536;
                            }
                            if ((i3 & 64) == 0) {
                                i4 |= 1572864;
                            } else if ((i & 1572864) == 0) {
                                i4 |= composerStartRestartGroup.changed(textAlign) ? 1048576 : 524288;
                            }
                            if ((i3 & 128) == 0) {
                                i4 |= 12582912;
                            } else {
                                if ((i & 12582912) == 0) {
                                    i4 |= composerStartRestartGroup.changed(z) ? 8388608 : 4194304;
                                }
                                if ((i3 & 256) != 0) {
                                    i4 |= 100663296;
                                } else {
                                    if ((i & 100663296) == 0) {
                                        i4 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
                                    }
                                    if ((i3 & 512) == 0) {
                                        i4 |= 805306368;
                                    } else {
                                        if ((i & 805306368) == 0) {
                                            i4 |= composerStartRestartGroup.changed(z3) ? 536870912 : 268435456;
                                        }
                                        i5 = i3 & 1024;
                                        if (i5 != 0) {
                                            i7 = i2 | 6;
                                        } else {
                                            if ((i2 & 6) != 0) {
                                                i6 = i2;
                                                if ((i4 & 306783379) != 306783378 && (i6 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
                                                    composerStartRestartGroup.skipToGroupEnd();
                                                    modifier2 = modifier;
                                                } else {
                                                    Modifier modifier3 = i5 == 0 ? Modifier.INSTANCE : modifier;
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-553094650, i4, i6, "com.revenuecat.purchases.ui.revenuecatui.composables.MDHeading (Markdown.kt:158)");
                                                    }
                                                    switch (heading.getLevel()) {
                                                        case 1:
                                                            composerStartRestartGroup.startReplaceGroup(-1496936953);
                                                            ComposerKt.sourceInformation(composerStartRestartGroup, "160@5409L10");
                                                            headlineLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineLarge();
                                                            composerStartRestartGroup.endReplaceGroup();
                                                            break;
                                                        case 2:
                                                            composerStartRestartGroup.startReplaceGroup(-1496935288);
                                                            ComposerKt.sourceInformation(composerStartRestartGroup, "161@5461L10");
                                                            headlineLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium();
                                                            composerStartRestartGroup.endReplaceGroup();
                                                            break;
                                                        case 3:
                                                            composerStartRestartGroup.startReplaceGroup(-1496933593);
                                                            ComposerKt.sourceInformation(composerStartRestartGroup, "162@5514L10");
                                                            headlineLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineSmall();
                                                            composerStartRestartGroup.endReplaceGroup();
                                                            break;
                                                        case 4:
                                                            composerStartRestartGroup.startReplaceGroup(-1496931932);
                                                            ComposerKt.sourceInformation(composerStartRestartGroup, "163@5566L10");
                                                            headlineLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge();
                                                            composerStartRestartGroup.endReplaceGroup();
                                                            break;
                                                        case 5:
                                                            composerStartRestartGroup.startReplaceGroup(-1496930363);
                                                            ComposerKt.sourceInformation(composerStartRestartGroup, "164@5615L10");
                                                            headlineLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium();
                                                            composerStartRestartGroup.endReplaceGroup();
                                                            break;
                                                        case 6:
                                                            composerStartRestartGroup.startReplaceGroup(-1496928764);
                                                            ComposerKt.sourceInformation(composerStartRestartGroup, "165@5665L10");
                                                            headlineLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleSmall();
                                                            composerStartRestartGroup.endReplaceGroup();
                                                            break;
                                                        default:
                                                            final Modifier modifier4 = modifier3;
                                                            composerStartRestartGroup.startReplaceGroup(839887138);
                                                            ComposerKt.sourceInformation(composerStartRestartGroup, "168@5750L314");
                                                            m10634MDBlockChildrend8Fo1UA(heading, j, textStyle, j2, fontWeight, fontFamily, textAlign, z, z2, z3, composerStartRestartGroup, i4 & 2147483646);
                                                            composerStartRestartGroup.endReplaceGroup();
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                            ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                                                            if (scopeUpdateScopeEndRestartGroup2 != null) {
                                                                scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDHeading$overriddenStyle$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(2);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                                        invoke(composer2, num.intValue());
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    public final void invoke(Composer composer2, int i8) {
                                                                        MarkdownKt.m10638MDHeadingJFVkrdg(heading, j, textStyle, j2, fontWeight, fontFamily, textAlign, z, z2, z3, modifier4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                                                    }
                                                                });
                                                                return;
                                                            }
                                                            return;
                                                    }
                                                    Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(modifier3, 0.0f, 0.0f, 0.0f, Dp.m9114constructorimpl(!(heading.getParent() instanceof Document) ? 8.0f : 0.0f), 7, null);
                                                    Modifier modifier5 = modifier3;
                                                    int i8 = i4;
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2041paddingqDBjuR0$default);
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composerStartRestartGroup.startReusableNode();
                                                    if (composerStartRestartGroup.getInserting()) {
                                                        composerStartRestartGroup.useNode();
                                                    } else {
                                                        composerStartRestartGroup.createNode(constructor);
                                                    }
                                                    composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                                                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1473983275, "C199@6756L136:Markdown.kt#51odh9");
                                                    AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                                                    m10652appendMarkdownChildrenXOJAsU(builder, heading, j, z, fontWeight2);
                                                    MarkdownText(builder.toAnnotatedString(), resolveMarkdownTextStyle(headlineLarge, new TextStyle(j, TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE(), fontWeight, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, textAlign == null ? textAlign.m8991unboximpl() : TextAlign.INSTANCE.m8998getUnspecifiede0LSkKk(), 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16744408, (DefaultConstructorMarker) null)), z2, null, composerStartRestartGroup, (i8 >> 18) & 896, 8);
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    composerStartRestartGroup.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                    modifier2 = modifier5;
                                                }
                                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                                if (scopeUpdateScopeEndRestartGroup == null) {
                                                    final TextStyle textStyle3 = textStyle2;
                                                    final long j4 = j3;
                                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDHeading$2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                            invoke(composer2, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer2, int i9) {
                                                            MarkdownKt.m10638MDHeadingJFVkrdg(heading, j, textStyle3, j4, fontWeight, fontFamily, textAlign, z, z2, z3, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                                        }
                                                    });
                                                    return;
                                                }
                                                return;
                                            }
                                            i7 = i2 | (composerStartRestartGroup.changed(modifier) ? 4 : 2);
                                        }
                                        i6 = i7;
                                        if ((i4 & 306783379) != 306783378) {
                                            if (i5 == 0) {
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            switch (heading.getLevel()) {
                                            }
                                            Modifier modifierM2041paddingqDBjuR0$default2 = PaddingKt.m2041paddingqDBjuR0$default(modifier3, 0.0f, 0.0f, 0.0f, Dp.m9114constructorimpl(!(heading.getParent() instanceof Document) ? 8.0f : 0.0f), 7, null);
                                            Modifier modifier52 = modifier3;
                                            int i82 = i4;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2041paddingqDBjuR0$default2);
                                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                            }
                                            composerStartRestartGroup.startReusableNode();
                                            if (composerStartRestartGroup.getInserting()) {
                                            }
                                            composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (!composerM5595constructorimpl.getInserting()) {
                                                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1473983275, "C199@6756L136:Markdown.kt#51odh9");
                                                AnnotatedString.Builder builder2 = new AnnotatedString.Builder(0, 1, null);
                                                m10652appendMarkdownChildrenXOJAsU(builder2, heading, j, z, fontWeight2);
                                                MarkdownText(builder2.toAnnotatedString(), resolveMarkdownTextStyle(headlineLarge, new TextStyle(j, TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE(), fontWeight, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, textAlign == null ? textAlign.m8991unboximpl() : TextAlign.INSTANCE.m8998getUnspecifiede0LSkKk(), 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16744408, (DefaultConstructorMarker) null)), z2, null, composerStartRestartGroup, (i82 >> 18) & 896, 8);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                composerStartRestartGroup.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                if (ComposerKt.isTraceInProgress()) {
                                                }
                                                modifier2 = modifier52;
                                            }
                                        }
                                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                        if (scopeUpdateScopeEndRestartGroup == null) {
                                        }
                                    }
                                    i5 = i3 & 1024;
                                    if (i5 != 0) {
                                    }
                                    i6 = i7;
                                    if ((i4 & 306783379) != 306783378) {
                                    }
                                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup == null) {
                                    }
                                }
                                if ((i3 & 512) == 0) {
                                }
                                i5 = i3 & 1024;
                                if (i5 != 0) {
                                }
                                i6 = i7;
                                if ((i4 & 306783379) != 306783378) {
                                }
                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                }
                            }
                            if ((i3 & 256) != 0) {
                            }
                            if ((i3 & 512) == 0) {
                            }
                            i5 = i3 & 1024;
                            if (i5 != 0) {
                            }
                            i6 = i7;
                            if ((i4 & 306783379) != 306783378) {
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        if ((i3 & 64) == 0) {
                        }
                        if ((i3 & 128) == 0) {
                        }
                        if ((i3 & 256) != 0) {
                        }
                        if ((i3 & 512) == 0) {
                        }
                        i5 = i3 & 1024;
                        if (i5 != 0) {
                        }
                        i6 = i7;
                        if ((i4 & 306783379) != 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    fontWeight2 = fontWeight;
                    if ((i3 & 32) != 0) {
                    }
                    if ((i3 & 64) == 0) {
                    }
                    if ((i3 & 128) == 0) {
                    }
                    if ((i3 & 256) != 0) {
                    }
                    if ((i3 & 512) == 0) {
                    }
                    i5 = i3 & 1024;
                    if (i5 != 0) {
                    }
                    i6 = i7;
                    if ((i4 & 306783379) != 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                j3 = j2;
                if ((i3 & 16) == 0) {
                }
                fontWeight2 = fontWeight;
                if ((i3 & 32) != 0) {
                }
                if ((i3 & 64) == 0) {
                }
                if ((i3 & 128) == 0) {
                }
                if ((i3 & 256) != 0) {
                }
                if ((i3 & 512) == 0) {
                }
                i5 = i3 & 1024;
                if (i5 != 0) {
                }
                i6 = i7;
                if ((i4 & 306783379) != 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            textStyle2 = textStyle;
            if ((i3 & 8) != 0) {
            }
            j3 = j2;
            if ((i3 & 16) == 0) {
            }
            fontWeight2 = fontWeight;
            if ((i3 & 32) != 0) {
            }
            if ((i3 & 64) == 0) {
            }
            if ((i3 & 128) == 0) {
            }
            if ((i3 & 256) != 0) {
            }
            if ((i3 & 512) == 0) {
            }
            i5 = i3 & 1024;
            if (i5 != 0) {
            }
            i6 = i7;
            if ((i4 & 306783379) != 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        textStyle2 = textStyle;
        if ((i3 & 8) != 0) {
        }
        j3 = j2;
        if ((i3 & 16) == 0) {
        }
        fontWeight2 = fontWeight;
        if ((i3 & 32) != 0) {
        }
        if ((i3 & 64) == 0) {
        }
        if ((i3 & 128) == 0) {
        }
        if ((i3 & 256) != 0) {
        }
        if ((i3 & 512) == 0) {
        }
        i5 = i3 & 1024;
        if (i5 != 0) {
        }
        i6 = i7;
        if ((i4 & 306783379) != 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0107  */
    /* JADX INFO: renamed from: MDListItems-JFVkrdg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10639MDListItemsJFVkrdg(final ListBlock listBlock, final long j, final TextStyle textStyle, final long j2, final FontWeight fontWeight, final FontFamily fontFamily, final TextAlign textAlign, final boolean z, final boolean z2, Modifier modifier, final Function3<? super Node, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        long j3;
        TextStyle textStyle2;
        long j4;
        FontWeight fontWeight2;
        int i5;
        int i6;
        int i7;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Node firstChild;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1016703760);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MDListItems)P(6,1:c#ui.graphics.Color,8,3:c#ui.unit.TextUnit,4,2,9:c#ui.text.style.TextAlign!1,10,7)361@11387L1319:Markdown.kt#51odh9");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(listBlock) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                j3 = j;
                i4 |= composerStartRestartGroup.changed(j3) ? 32 : 16;
            }
            if ((i3 & 4) == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    textStyle2 = textStyle;
                    i4 |= composerStartRestartGroup.changed(textStyle2) ? 256 : 128;
                }
                if ((i3 & 8) != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        j4 = j2;
                        i4 |= composerStartRestartGroup.changed(j4) ? 2048 : 1024;
                    }
                    if ((i3 & 16) == 0) {
                        i4 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            fontWeight2 = fontWeight;
                            i4 |= composerStartRestartGroup.changed(fontWeight2) ? 16384 : 8192;
                        }
                        if ((i3 & 32) != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else {
                            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i4 |= composerStartRestartGroup.changed(fontFamily) ? 131072 : 65536;
                            }
                            if ((i3 & 64) == 0) {
                                i4 |= 1572864;
                            } else if ((i & 1572864) == 0) {
                                i4 |= composerStartRestartGroup.changed(textAlign) ? 1048576 : 524288;
                            }
                            if ((i3 & 128) == 0) {
                                i4 |= 12582912;
                            } else {
                                if ((i & 12582912) == 0) {
                                    i4 |= composerStartRestartGroup.changed(z) ? 8388608 : 4194304;
                                }
                                if ((i3 & 256) != 0) {
                                    i4 |= 100663296;
                                } else {
                                    if ((i & 100663296) == 0) {
                                        i4 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
                                    }
                                    i5 = i3 & 512;
                                    if (i5 != 0) {
                                        if ((i & 805306368) == 0) {
                                            i6 = i5;
                                            i4 |= composerStartRestartGroup.changed(modifier) ? 536870912 : 268435456;
                                        }
                                        if ((i3 & 1024) != 0) {
                                            i7 = i2 | 6;
                                        } else if ((i2 & 6) == 0) {
                                            i7 = i2 | (composerStartRestartGroup.changedInstance(function3) ? 4 : 2);
                                        } else {
                                            i7 = i2;
                                        }
                                        if ((i4 & 306783379) == 306783378 && (i7 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
                                            composerStartRestartGroup.skipToGroupEnd();
                                        } else {
                                            Modifier modifier2 = i6 == 0 ? Modifier.INSTANCE : modifier;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1016703760, i4, i7, "com.revenuecat.purchases.ui.revenuecatui.composables.MDListItems (Markdown.kt:358)");
                                            }
                                            Modifier modifierM2041paddingqDBjuR0$default = PaddingKt.m2041paddingqDBjuR0$default(modifier2, !(listBlock.getParent() instanceof Document) ? Dp.m9114constructorimpl(0.0f) : Dp.m9114constructorimpl(8.0f), 0.0f, 0.0f, !(listBlock.getParent() instanceof Document) ? Dp.m9114constructorimpl(8.0f) : Dp.m9114constructorimpl(0.0f), 6, null);
                                            int i8 = i7;
                                            modifier = modifier2;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2041paddingqDBjuR0$default);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            int i9 = i4;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composerStartRestartGroup.startReusableNode();
                                            if (composerStartRestartGroup.getInserting()) {
                                                composerStartRestartGroup.useNode();
                                            } else {
                                                composerStartRestartGroup.createNode(constructor);
                                            }
                                            composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                                            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -56822185, "C:Markdown.kt#51odh9");
                                            firstChild = listBlock.getFirstChild();
                                            composerStartRestartGroup.startReplaceGroup(1937831040);
                                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                                            while (firstChild != null) {
                                                Node firstChild2 = firstChild.getFirstChild();
                                                composerStartRestartGroup.startReplaceGroup(1937833566);
                                                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                                                while (firstChild2 != null) {
                                                    if (firstChild2 instanceof BulletList) {
                                                        composerStartRestartGroup.startReplaceGroup(1937836604);
                                                        ComposerKt.sourceInformation(composerStartRestartGroup, "368@11708L387");
                                                        m10636MDBulletListlzeOXFE((BulletList) firstChild2, j3, textStyle2, j4, fontWeight2, fontFamily, textAlign, z, z2, composerStartRestartGroup, i9 & 268435440);
                                                        composerStartRestartGroup.endReplaceGroup();
                                                    } else if (firstChild2 instanceof OrderedList) {
                                                        composerStartRestartGroup.startReplaceGroup(1937851005);
                                                        ComposerKt.sourceInformation(composerStartRestartGroup, "380@12158L388");
                                                        m10640MDOrderedListlzeOXFE((OrderedList) firstChild2, j, textStyle, j2, fontWeight, fontFamily, textAlign, z, z2, composerStartRestartGroup, i9 & 268435440);
                                                        composerStartRestartGroup.endReplaceGroup();
                                                    } else {
                                                        composerStartRestartGroup.startReplaceGroup(1937863972);
                                                        ComposerKt.sourceInformation(composerStartRestartGroup, "391@12575L11");
                                                        function3.invoke(firstChild2, composerStartRestartGroup, Integer.valueOf((i8 << 3) & 112));
                                                        composerStartRestartGroup.endReplaceGroup();
                                                    }
                                                    firstChild2 = firstChild2.getNext();
                                                    j3 = j;
                                                    textStyle2 = textStyle;
                                                    j4 = j2;
                                                    fontWeight2 = fontWeight;
                                                }
                                                composerStartRestartGroup.endReplaceGroup();
                                                firstChild = firstChild.getNext();
                                                j3 = j;
                                                textStyle2 = textStyle;
                                                j4 = j2;
                                                fontWeight2 = fontWeight;
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
                                        }
                                        final Modifier modifier3 = modifier;
                                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                        if (scopeUpdateScopeEndRestartGroup != null) {
                                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDListItems$2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                    invoke(composer2, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer2, int i10) {
                                                    MarkdownKt.m10639MDListItemsJFVkrdg(listBlock, j, textStyle, j2, fontWeight, fontFamily, textAlign, z, z2, modifier3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                    i4 |= 805306368;
                                    i6 = i5;
                                    if ((i3 & 1024) != 0) {
                                    }
                                    if ((i4 & 306783379) == 306783378) {
                                        if (i6 == 0) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        Modifier modifierM2041paddingqDBjuR0$default2 = PaddingKt.m2041paddingqDBjuR0$default(modifier2, !(listBlock.getParent() instanceof Document) ? Dp.m9114constructorimpl(0.0f) : Dp.m9114constructorimpl(8.0f), 0.0f, 0.0f, !(listBlock.getParent() instanceof Document) ? Dp.m9114constructorimpl(8.0f) : Dp.m9114constructorimpl(0.0f), 6, null);
                                        int i82 = i7;
                                        modifier = modifier2;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2041paddingqDBjuR0$default2);
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        int i92 = i4;
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                        }
                                        composerStartRestartGroup.startReusableNode();
                                        if (composerStartRestartGroup.getInserting()) {
                                        }
                                        composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                                        Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (!composerM5595constructorimpl.getInserting()) {
                                            composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -56822185, "C:Markdown.kt#51odh9");
                                            firstChild = listBlock.getFirstChild();
                                            composerStartRestartGroup.startReplaceGroup(1937831040);
                                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                                            while (firstChild != null) {
                                            }
                                            composerStartRestartGroup.endReplaceGroup();
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            composerStartRestartGroup.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                        }
                                    }
                                    final Modifier modifier32 = modifier;
                                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup != null) {
                                    }
                                }
                                i5 = i3 & 512;
                                if (i5 != 0) {
                                }
                                i6 = i5;
                                if ((i3 & 1024) != 0) {
                                }
                                if ((i4 & 306783379) == 306783378) {
                                }
                                final Modifier modifier322 = modifier;
                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                }
                            }
                            if ((i3 & 256) != 0) {
                            }
                            i5 = i3 & 512;
                            if (i5 != 0) {
                            }
                            i6 = i5;
                            if ((i3 & 1024) != 0) {
                            }
                            if ((i4 & 306783379) == 306783378) {
                            }
                            final Modifier modifier3222 = modifier;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        if ((i3 & 64) == 0) {
                        }
                        if ((i3 & 128) == 0) {
                        }
                        if ((i3 & 256) != 0) {
                        }
                        i5 = i3 & 512;
                        if (i5 != 0) {
                        }
                        i6 = i5;
                        if ((i3 & 1024) != 0) {
                        }
                        if ((i4 & 306783379) == 306783378) {
                        }
                        final Modifier modifier32222 = modifier;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    fontWeight2 = fontWeight;
                    if ((i3 & 32) != 0) {
                    }
                    if ((i3 & 64) == 0) {
                    }
                    if ((i3 & 128) == 0) {
                    }
                    if ((i3 & 256) != 0) {
                    }
                    i5 = i3 & 512;
                    if (i5 != 0) {
                    }
                    i6 = i5;
                    if ((i3 & 1024) != 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    final Modifier modifier322222 = modifier;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                j4 = j2;
                if ((i3 & 16) == 0) {
                }
                fontWeight2 = fontWeight;
                if ((i3 & 32) != 0) {
                }
                if ((i3 & 64) == 0) {
                }
                if ((i3 & 128) == 0) {
                }
                if ((i3 & 256) != 0) {
                }
                i5 = i3 & 512;
                if (i5 != 0) {
                }
                i6 = i5;
                if ((i3 & 1024) != 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                final Modifier modifier3222222 = modifier;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            textStyle2 = textStyle;
            if ((i3 & 8) != 0) {
            }
            j4 = j2;
            if ((i3 & 16) == 0) {
            }
            fontWeight2 = fontWeight;
            if ((i3 & 32) != 0) {
            }
            if ((i3 & 64) == 0) {
            }
            if ((i3 & 128) == 0) {
            }
            if ((i3 & 256) != 0) {
            }
            i5 = i3 & 512;
            if (i5 != 0) {
            }
            i6 = i5;
            if ((i3 & 1024) != 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            final Modifier modifier32222222 = modifier;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        j3 = j;
        if ((i3 & 4) == 0) {
        }
        textStyle2 = textStyle;
        if ((i3 & 8) != 0) {
        }
        j4 = j2;
        if ((i3 & 16) == 0) {
        }
        fontWeight2 = fontWeight;
        if ((i3 & 32) != 0) {
        }
        if ((i3 & 64) == 0) {
        }
        if ((i3 & 128) == 0) {
        }
        if ((i3 & 256) != 0) {
        }
        i5 = i3 & 512;
        if (i5 != 0) {
        }
        i6 = i5;
        if ((i3 & 1024) != 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        final Modifier modifier322222222 = modifier;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: MDOrderedList-lzeOXFE, reason: not valid java name */
    public static final void m10640MDOrderedListlzeOXFE(final OrderedList orderedList, final long j, final TextStyle textStyle, final long j2, final FontWeight fontWeight, final FontFamily fontFamily, final TextAlign textAlign, final boolean z, final boolean z2, Composer composer, final int i) {
        int i2;
        long j3;
        long j4;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        boolean z3;
        boolean z4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1401481105);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MDOrderedList)P(5,1:c#ui.graphics.Color,6,3:c#ui.unit.TextUnit,4,2,7:c#ui.text.style.TextAlign)329@10449L409,319@10159L699:Markdown.kt#51odh9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(orderedList) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            j3 = j;
            i2 |= composerStartRestartGroup.changed(j3) ? 32 : 16;
        } else {
            j3 = j;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            j4 = j2;
            i2 |= composerStartRestartGroup.changed(j4) ? 2048 : 1024;
        } else {
            j4 = j2;
        }
        if ((i & 24576) == 0) {
            fontWeight2 = fontWeight;
            i2 |= composerStartRestartGroup.changed(fontWeight2) ? 16384 : 8192;
        } else {
            fontWeight2 = fontWeight;
        }
        if ((196608 & i) == 0) {
            fontFamily2 = fontFamily;
            i2 |= composerStartRestartGroup.changed(fontFamily2) ? 131072 : 65536;
        } else {
            fontFamily2 = fontFamily;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(textAlign) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            z3 = z;
            i2 |= composerStartRestartGroup.changed(z3) ? 8388608 : 4194304;
        } else {
            z3 = z;
        }
        if ((100663296 & i) == 0) {
            z4 = z2;
            i2 |= composerStartRestartGroup.changed(z4) ? 67108864 : 33554432;
        } else {
            z4 = z2;
        }
        if ((38347923 & i2) == 38347922 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1401481105, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MDOrderedList (Markdown.kt:306)");
            }
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = orderedList.getStartNumber();
            final char delimiter = orderedList.getDelimiter();
            final TextStyle textStyleResolveMarkdownTextStyle = resolveMarkdownTextStyle(textStyle, new TextStyle(j3, j4, fontWeight2, (FontStyle) null, (FontSynthesis) null, fontFamily2, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, textAlign != null ? textAlign.m8991unboximpl() : TextAlign.INSTANCE.m8998getUnspecifiede0LSkKk(), 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16744408, (DefaultConstructorMarker) null));
            final boolean z5 = z3;
            final boolean z6 = z4;
            m10639MDListItemsJFVkrdg(orderedList, j, textStyle, j2, fontWeight, fontFamily, textAlign, z, z2, null, ComposableLambdaKt.rememberComposableLambda(-1609568168, true, new Function3<Node, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDOrderedList$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Node node, Composer composer2, Integer num) {
                    invoke(node, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Node it, Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation(composer2, "C336@10716L136:Markdown.kt#51odh9");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1609568168, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MDOrderedList.<anonymous> (Markdown.kt:330)");
                    }
                    TextStyle textStyle2 = textStyleResolveMarkdownTextStyle;
                    Ref.IntRef intRef2 = intRef;
                    char c = delimiter;
                    long j5 = j;
                    boolean z7 = z5;
                    FontWeight fontWeight3 = fontWeight;
                    AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                    builder.pushStyle(textStyle2.toSpanStyle());
                    StringBuilder sb = new StringBuilder();
                    int i4 = intRef2.element;
                    intRef2.element = i4 + 1;
                    builder.append(sb.append(i4).append(c).append(' ').toString());
                    MarkdownKt.m10652appendMarkdownChildrenXOJAsU(builder, it, j5, z7, fontWeight3);
                    builder.pop();
                    MarkdownKt.MarkdownText(builder.toAnnotatedString(), textStyleResolveMarkdownTextStyle, z6, null, composer2, 0, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, i2 & 268435454, 6, 512);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDOrderedList$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    MarkdownKt.m10640MDOrderedListlzeOXFE(orderedList, j, textStyle, j2, fontWeight, fontFamily, textAlign, z, z2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: MDParagraph-d8Fo1UA, reason: not valid java name */
    public static final void m10641MDParagraphd8Fo1UA(final Paragraph paragraph, final long j, final TextStyle textStyle, final long j2, final FontWeight fontWeight, final FontFamily fontFamily, final TextAlign textAlign, final boolean z, final boolean z2, final boolean z3, Composer composer, final int i) {
        int i2;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-581921093);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MDParagraph)P(6,2:c#ui.graphics.Color,7,4:c#ui.unit.TextUnit,5,3,8:c#ui.text.style.TextAlign!1,9)221@7256L810:Markdown.kt#51odh9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(paragraph) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            fontWeight2 = fontWeight;
            i2 |= composerStartRestartGroup.changed(fontWeight2) ? 16384 : 8192;
        } else {
            fontWeight2 = fontWeight;
        }
        if ((196608 & i) == 0) {
            fontFamily2 = fontFamily;
            i2 |= composerStartRestartGroup.changed(fontFamily2) ? 131072 : 65536;
        } else {
            fontFamily2 = fontFamily;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(textAlign) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i2 |= composerStartRestartGroup.changed(z3) ? 536870912 : 268435456;
        }
        if ((i2 & 306783379) == 306783378 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-581921093, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MDParagraph (Markdown.kt:220)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int i3 = i2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -586505304, "C237@7918L142:Markdown.kt#51odh9");
            TextStyle textStyleResolveMarkdownTextStyle = resolveMarkdownTextStyle(textStyle, new TextStyle(j, z3 ? j2 : TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE(), fontWeight2, (FontStyle) null, (FontSynthesis) null, fontFamily2, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, textAlign != null ? textAlign.m8991unboximpl() : TextAlign.INSTANCE.m8998getUnspecifiede0LSkKk(), 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16744408, (DefaultConstructorMarker) null));
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            builder.pushStyle(textStyleResolveMarkdownTextStyle.toSpanStyle());
            Intrinsics.checkNotNull(paragraph, "null cannot be cast to non-null type org.commonmark.node.Node");
            m10652appendMarkdownChildrenXOJAsU(builder, paragraph, j, z, fontWeight);
            builder.pop();
            composer2 = composerStartRestartGroup;
            MarkdownText(builder.toAnnotatedString(), textStyleResolveMarkdownTextStyle, z2, null, composer2, (i3 >> 18) & 896, 8);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDParagraph$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    MarkdownKt.m10641MDParagraphd8Fo1UA(paragraph, j, textStyle, j2, fontWeight, fontFamily, textAlign, z, z2, z3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010a  */
    /* JADX INFO: renamed from: Markdown-DkhmgE0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10642MarkdownDkhmgE0(final String text, Modifier modifier, long j, TextStyle textStyle, long j2, FontWeight fontWeight, FontFamily fontFamily, Alignment.Horizontal horizontal, TextAlign textAlign, boolean z, boolean z2, boolean z3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        long j3;
        int i6;
        int i7;
        long j4;
        int i8;
        FontWeight fontWeight2;
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
        final Modifier.Companion companion;
        TextStyle textStyle2;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final TextStyle textStyle3;
        final FontFamily fontFamily2;
        Composer composer2;
        final FontWeight fontWeight3;
        final long j5;
        final boolean z4;
        final boolean z5;
        final TextAlign textAlign2;
        final Alignment.Horizontal horizontal2;
        final boolean z6;
        final long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(1306831337);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Markdown)P(9,7,2:c#ui.graphics.Color,8,4:c#ui.unit.TextUnit,5,3,6,10:c#ui.text.style.TextAlign!1,11)87@3713L7,96@3911L442:Markdown.kt#51odh9");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i21 = i3 & 2;
        if (i21 != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    j3 = j;
                    i4 |= composerStartRestartGroup.changed(j3) ? 256 : 128;
                }
                i6 = i3 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        i4 |= composerStartRestartGroup.changed(textStyle) ? 2048 : 1024;
                    }
                    i7 = i3 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                        j4 = j2;
                    } else {
                        j4 = j2;
                        if ((i & 24576) == 0) {
                            i4 |= composerStartRestartGroup.changed(j4) ? 16384 : 8192;
                        }
                    }
                    i8 = i3 & 32;
                    if (i8 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        fontWeight2 = fontWeight;
                    } else {
                        fontWeight2 = fontWeight;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= composerStartRestartGroup.changed(fontWeight2) ? 131072 : 65536;
                        }
                    }
                    i9 = i3 & 64;
                    if (i9 == 0) {
                        i4 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i4 |= composerStartRestartGroup.changed(fontFamily) ? 1048576 : 524288;
                    }
                    i10 = i3 & 128;
                    if (i10 == 0) {
                        i4 |= 12582912;
                    } else {
                        if ((i & 12582912) == 0) {
                            i11 = i10;
                            i4 |= composerStartRestartGroup.changed(horizontal) ? 8388608 : 4194304;
                        }
                        i12 = i3 & 256;
                        if (i12 != 0) {
                            i4 |= 100663296;
                        } else {
                            if ((i & 100663296) == 0) {
                                i13 = i12;
                                i4 |= composerStartRestartGroup.changed(textAlign) ? 67108864 : 33554432;
                            }
                            i14 = i3 & 512;
                            if (i14 != 0) {
                                if ((i & 805306368) == 0) {
                                    i15 = i14;
                                    i4 |= composerStartRestartGroup.changed(z) ? 536870912 : 268435456;
                                }
                                i16 = i3 & 1024;
                                if (i16 != 0) {
                                    i18 = i2 | 6;
                                    i17 = i16;
                                } else if ((i2 & 6) == 0) {
                                    i17 = i16;
                                    i18 = i2 | (composerStartRestartGroup.changed(z2) ? 4 : 2);
                                } else {
                                    i17 = i16;
                                    i18 = i2;
                                }
                                i19 = i3 & 2048;
                                if (i19 != 0) {
                                    i18 |= 48;
                                } else if ((i2 & 48) == 0) {
                                    i18 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
                                }
                                i20 = i18;
                                if ((i4 & 306783379) == 306783378 && (i20 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    long j7 = j4;
                                    fontWeight3 = fontWeight2;
                                    j5 = j7;
                                    textStyle3 = textStyle;
                                    fontFamily2 = fontFamily;
                                    textAlign2 = textAlign;
                                    z5 = z3;
                                    composer2 = composerStartRestartGroup;
                                    companion = modifier2;
                                    j6 = j3;
                                    horizontal2 = horizontal;
                                    z4 = z;
                                    z6 = z2;
                                } else {
                                    companion = i21 == 0 ? Modifier.INSTANCE : modifier2;
                                    long jM6361getUnspecified0d7_KjU = i5 == 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j3;
                                    TextStyle textStyle4 = i6 == 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
                                    long jM9319getUnspecifiedXSAIIZE = i7 == 0 ? TextUnit.INSTANCE.m9319getUnspecifiedXSAIIZE() : j4;
                                    if (i8 != 0) {
                                        fontWeight2 = null;
                                    }
                                    FontFamily fontFamily3 = i9 == 0 ? null : fontFamily;
                                    Alignment.Horizontal start = i11 == 0 ? Alignment.INSTANCE.getStart() : horizontal;
                                    TextAlign textAlign3 = i13 == 0 ? textAlign : null;
                                    boolean z7 = i15 == 0 ? true : z;
                                    boolean z8 = i17 == 0 ? false : z2;
                                    boolean z9 = i19 == 0 ? true : z3;
                                    if (ComposerKt.isTraceInProgress()) {
                                        textStyle2 = textStyle4;
                                    } else {
                                        textStyle2 = textStyle4;
                                        ComposerKt.traceEventStart(1306831337, i4, i20, "com.revenuecat.purchases.ui.revenuecatui.composables.Markdown (Markdown.kt:84)");
                                    }
                                    Node node = parser.parse(text);
                                    Intrinsics.checkNotNull(node, "null cannot be cast to non-null type org.commonmark.node.Document");
                                    Document document = (Document) node;
                                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object objConsume = composerStartRestartGroup.consume(localDensity);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    int i22 = i4;
                                    FontWeight fontWeight4 = fontWeight2;
                                    long j8 = jM9319getUnspecifiedXSAIIZE;
                                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_4 = Arrangement.INSTANCE.m1907spacedBy0680j_4(!TextUnitType.m9336equalsimpl0(TextUnit.m9307getTypeUIouoOA(textStyle2.m8595getLineHeightXSAIIZE()), TextUnitType.INSTANCE.m9341getSpUIouoOA()) ? ((Density) objConsume).mo1619toDpGaN1DYA(textStyle2.m8595getLineHeightXSAIIZE()) : Dp.m9114constructorimpl(0.0f));
                                    int i23 = i22 >> 3;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_4, start, composerStartRestartGroup, (((i23 & 14) | ((i22 >> 15) & 896)) >> 3) & 112);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composerStartRestartGroup.startReusableNode();
                                    if (composerStartRestartGroup.getInserting()) {
                                        composerStartRestartGroup.useNode();
                                    } else {
                                        composerStartRestartGroup.createNode(constructor);
                                    }
                                    composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                                    Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (!composerM5595constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5595constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 862299742, "C101@4085L262:Markdown.kt#51odh9");
                                    int i24 = i22 >> 6;
                                    int i25 = (524272 & i23) | (3670016 & i24) | (i24 & 29360128);
                                    int i26 = i20 << 24;
                                    TextAlign textAlign4 = textAlign3;
                                    FontFamily fontFamily4 = fontFamily3;
                                    boolean z10 = z7;
                                    boolean z11 = z8;
                                    boolean z12 = z9;
                                    m10637MDDocumentd8Fo1UA(document, jM6361getUnspecified0d7_KjU, textStyle2, j8, fontWeight4, fontFamily4, textAlign4, z10, z11, z12, composerStartRestartGroup, i25 | (234881024 & i26) | (i26 & 1879048192));
                                    textStyle3 = textStyle2;
                                    fontFamily2 = fontFamily4;
                                    composer2 = composerStartRestartGroup;
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    composer2.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    fontWeight3 = fontWeight4;
                                    j5 = j8;
                                    z4 = z10;
                                    z5 = z12;
                                    long j9 = jM6361getUnspecified0d7_KjU;
                                    textAlign2 = textAlign4;
                                    horizontal2 = start;
                                    z6 = z11;
                                    j6 = j9;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$Markdown$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i27) {
                                            MarkdownKt.m10642MarkdownDkhmgE0(text, companion, j6, textStyle3, j5, fontWeight3, fontFamily2, horizontal2, textAlign2, z4, z6, z5, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i4 |= 805306368;
                            i15 = i14;
                            i16 = i3 & 1024;
                            if (i16 != 0) {
                            }
                            i19 = i3 & 2048;
                            if (i19 != 0) {
                            }
                            i20 = i18;
                            if ((i4 & 306783379) == 306783378) {
                                if (i21 == 0) {
                                }
                                if (i5 == 0) {
                                }
                                if (i6 == 0) {
                                }
                                if (i7 == 0) {
                                }
                                if (i8 != 0) {
                                }
                                if (i9 == 0) {
                                }
                                if (i11 == 0) {
                                }
                                if (i13 == 0) {
                                }
                                if (i15 == 0) {
                                }
                                if (i17 == 0) {
                                }
                                if (i19 == 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                Node node2 = parser.parse(text);
                                Intrinsics.checkNotNull(node2, "null cannot be cast to non-null type org.commonmark.node.Document");
                                Document document2 = (Document) node2;
                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                int i222 = i4;
                                FontWeight fontWeight42 = fontWeight2;
                                long j82 = jM9319getUnspecifiedXSAIIZE;
                                Arrangement.HorizontalOrVertical horizontalOrVerticalM1907spacedBy0680j_42 = Arrangement.INSTANCE.m1907spacedBy0680j_4(!TextUnitType.m9336equalsimpl0(TextUnit.m9307getTypeUIouoOA(textStyle2.m8595getLineHeightXSAIIZE()), TextUnitType.INSTANCE.m9341getSpUIouoOA()) ? ((Density) objConsume2).mo1619toDpGaN1DYA(textStyle2.m8595getLineHeightXSAIIZE()) : Dp.m9114constructorimpl(0.0f));
                                int i232 = i222 >> 3;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1907spacedBy0680j_42, start, composerStartRestartGroup, (((i232 & 14) | ((i222 >> 15) & 896)) >> 3) & 112);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                }
                                composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                                Updater.m5603setimpl(composerM5595constructorimpl, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5603setimpl(composerM5595constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!composerM5595constructorimpl.getInserting()) {
                                    composerM5595constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM5595constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    Updater.m5603setimpl(composerM5595constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 862299742, "C101@4085L262:Markdown.kt#51odh9");
                                    int i242 = i222 >> 6;
                                    int i252 = (524272 & i232) | (3670016 & i242) | (i242 & 29360128);
                                    int i262 = i20 << 24;
                                    TextAlign textAlign42 = textAlign3;
                                    FontFamily fontFamily42 = fontFamily3;
                                    boolean z102 = z7;
                                    boolean z112 = z8;
                                    boolean z122 = z9;
                                    m10637MDDocumentd8Fo1UA(document2, jM6361getUnspecified0d7_KjU, textStyle2, j82, fontWeight42, fontFamily42, textAlign42, z102, z112, z122, composerStartRestartGroup, i252 | (234881024 & i262) | (i262 & 1879048192));
                                    textStyle3 = textStyle2;
                                    fontFamily2 = fontFamily42;
                                    composer2 = composerStartRestartGroup;
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    composer2.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    fontWeight3 = fontWeight42;
                                    j5 = j82;
                                    z4 = z102;
                                    z5 = z122;
                                    long j92 = jM6361getUnspecified0d7_KjU;
                                    textAlign2 = textAlign42;
                                    horizontal2 = start;
                                    z6 = z112;
                                    j6 = j92;
                                }
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i13 = i12;
                        i14 = i3 & 512;
                        if (i14 != 0) {
                        }
                        i15 = i14;
                        i16 = i3 & 1024;
                        if (i16 != 0) {
                        }
                        i19 = i3 & 2048;
                        if (i19 != 0) {
                        }
                        i20 = i18;
                        if ((i4 & 306783379) == 306783378) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i11 = i10;
                    i12 = i3 & 256;
                    if (i12 != 0) {
                    }
                    i13 = i12;
                    i14 = i3 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i3 & 1024;
                    if (i16 != 0) {
                    }
                    i19 = i3 & 2048;
                    if (i19 != 0) {
                    }
                    i20 = i18;
                    if ((i4 & 306783379) == 306783378) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                i8 = i3 & 32;
                if (i8 == 0) {
                }
                i9 = i3 & 64;
                if (i9 == 0) {
                }
                i10 = i3 & 128;
                if (i10 == 0) {
                }
                i11 = i10;
                i12 = i3 & 256;
                if (i12 != 0) {
                }
                i13 = i12;
                i14 = i3 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i3 & 1024;
                if (i16 != 0) {
                }
                i19 = i3 & 2048;
                if (i19 != 0) {
                }
                i20 = i18;
                if ((i4 & 306783379) == 306783378) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            j3 = j;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            i7 = i3 & 16;
            if (i7 == 0) {
            }
            i8 = i3 & 32;
            if (i8 == 0) {
            }
            i9 = i3 & 64;
            if (i9 == 0) {
            }
            i10 = i3 & 128;
            if (i10 == 0) {
            }
            i11 = i10;
            i12 = i3 & 256;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i3 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i3 & 1024;
            if (i16 != 0) {
            }
            i19 = i3 & 2048;
            if (i19 != 0) {
            }
            i20 = i18;
            if ((i4 & 306783379) == 306783378) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        j3 = j;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        i7 = i3 & 16;
        if (i7 == 0) {
        }
        i8 = i3 & 32;
        if (i8 == 0) {
        }
        i9 = i3 & 64;
        if (i9 == 0) {
        }
        i10 = i3 & 128;
        if (i10 == 0) {
        }
        i11 = i10;
        i12 = i3 & 256;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i3 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i3 & 1024;
        if (i16 != 0) {
        }
        i19 = i3 & 2048;
        if (i19 != 0) {
        }
        i20 = i18;
        if ((i4 & 306783379) == 306783378) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MarkdownText(final AnnotatedString annotatedString, final TextStyle textStyle, final boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        AnnotatedString annotatedString2;
        int i3;
        TextStyle textStyle2;
        int i4;
        Modifier modifier2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1557573026);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MarkdownText)P(2,1,3)576@18321L174:Markdown.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            annotatedString2 = annotatedString;
        } else {
            annotatedString2 = annotatedString;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(annotatedString2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                textStyle2 = textStyle;
                i3 |= composerStartRestartGroup.changed(textStyle2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    modifier2 = modifier;
                    i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
                }
                if ((i3 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier2;
                } else {
                    Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1557573026, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownText (Markdown.kt:575)");
                    }
                    Modifier modifier4 = companion;
                    composer2 = composerStartRestartGroup;
                    TextKt.m4287TextIbK3jfQ(annotatedString2, ModifierExtensionsKt.conditional(companion, z, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt.MarkdownText.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Modifier invoke(Modifier conditional) {
                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                            return SizeKt.fillMaxWidth$default(conditional, 0.0f, 1, null);
                        }
                    }), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, textStyle2, composer2, i3 & 14, (i3 << 18) & 29360128, 131068);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt.MarkdownText.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i5) {
                            MarkdownKt.MarkdownText(annotatedString, textStyle, z, modifier3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 3072;
            modifier2 = modifier;
            if ((i3 & 1171) == 1170) {
                if (i4 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier modifier42 = companion;
                composer2 = composerStartRestartGroup;
                TextKt.m4287TextIbK3jfQ(annotatedString2, ModifierExtensionsKt.conditional(companion, z, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt.MarkdownText.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Modifier invoke(Modifier conditional) {
                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                        return SizeKt.fillMaxWidth$default(conditional, 0.0f, 1, null);
                    }
                }), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, textStyle2, composer2, i3 & 14, (i3 << 18) & 29360128, 131068);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier42;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        textStyle2 = textStyle;
        if ((i2 & 4) == 0) {
        }
        i4 = i2 & 8;
        if (i4 != 0) {
        }
        modifier2 = modifier;
        if ((i3 & 1171) == 1170) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: appendMarkdownChildren-XO-JAsU, reason: not valid java name */
    public static final void m10652appendMarkdownChildrenXOJAsU(AnnotatedString.Builder builder, Node node, long j, boolean z, FontWeight fontWeight) {
        Node firstChild = node.getFirstChild();
        while (firstChild != null) {
            if (firstChild instanceof Paragraph) {
                m10652appendMarkdownChildrenXOJAsU(builder, firstChild, j, z, fontWeight);
            } else if (firstChild instanceof Text) {
                String literal = ((Text) firstChild).getLiteral();
                Intrinsics.checkNotNullExpressionValue(literal, "child.literal");
                builder.append(literal);
            } else if (firstChild instanceof Emphasis) {
                builder.pushStyle(new SpanStyle(0L, 0L, (FontWeight) null, FontStyle.m8665boximpl(FontStyle.INSTANCE.m8674getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65527, (DefaultConstructorMarker) null));
                m10652appendMarkdownChildrenXOJAsU(builder, firstChild, j, z, fontWeight);
                builder.pop();
            } else if (firstChild instanceof StrongEmphasis) {
                FontWeight bold = (fontWeight != null ? fontWeight.getWeight() : 0) > FontWeight.INSTANCE.getBold().getWeight() ? fontWeight : FontWeight.INSTANCE.getBold();
                builder.pushStyle(new SpanStyle(0L, 0L, bold, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65531, (DefaultConstructorMarker) null));
                m10652appendMarkdownChildrenXOJAsU(builder, firstChild, j, z, bold);
                builder.pop();
            } else {
                Node node2 = firstChild;
                if (node2 instanceof Code) {
                    builder.pushStyle(new TextStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.INSTANCE.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (DefaultConstructorMarker) null).toSpanStyle());
                    String literal2 = ((Code) node2).getLiteral();
                    Intrinsics.checkNotNullExpressionValue(literal2, "child.literal");
                    builder.append(literal2);
                    builder.pop();
                } else {
                    if (node2 instanceof HardLineBreak ? true : node2 instanceof SoftLineBreak) {
                        Intrinsics.checkNotNullExpressionValue(builder.append('\n'), "append(...)");
                    } else if (!(node2 instanceof Link)) {
                        firstChild = node2;
                        if (firstChild instanceof Strikethrough) {
                            builder.pushStyle(new TextStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.INSTANCE.getLineThrough(), (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16773119, (DefaultConstructorMarker) null).toSpanStyle());
                            m10652appendMarkdownChildrenXOJAsU(builder, firstChild, j, z, fontWeight);
                            builder.pop();
                        }
                    } else if (z) {
                        SpanStyle spanStyle = new SpanStyle(j, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.INSTANCE.getUnderline(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61438, (DefaultConstructorMarker) null);
                        String destination = ((Link) node2).getDestination();
                        Intrinsics.checkNotNullExpressionValue(destination, "child.destination");
                        int iPushLink = builder.pushLink(new LinkAnnotation.Url(destination, new TextLinkStyles(spanStyle, null, null, null, 14, null), null, 4, null));
                        firstChild = node2;
                        try {
                            m10652appendMarkdownChildrenXOJAsU(builder, firstChild, j, true, fontWeight);
                            Unit unit = Unit.INSTANCE;
                        } finally {
                            builder.pop(iPushLink);
                        }
                    } else {
                        firstChild = node2;
                        m10652appendMarkdownChildrenXOJAsU(builder, firstChild, j, false, fontWeight);
                    }
                }
                firstChild = node2;
            }
            firstChild = firstChild.getNext();
        }
    }

    private static final TextStyle resolveMarkdownTextStyle(TextStyle textStyle, TextStyle textStyle2) {
        return textStyle.merge(textStyle2);
    }
}
