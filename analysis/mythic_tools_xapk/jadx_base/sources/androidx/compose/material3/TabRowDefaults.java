package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TabRowDefaults;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.material3.tokens.SecondaryNavigationTabTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\fH\u0007¢\u0006\u0004\b!\u0010\"JA\u0010#\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0004\b'\u0010(J-\u0010)\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\fH\u0007¢\u0006\u0004\b*\u0010\"J\u0014\u0010+\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010,\u001a\u00020-H\u0007R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0017\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u0019\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000f¨\u0006.²\u0006\n\u0010/\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u00100\u001a\u00020\u0005X\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/TabRowDefaults;", "", "<init>", "()V", "ScrollableTabRowMinTabWidth", "Landroidx/compose/ui/unit/Dp;", "getScrollableTabRowMinTabWidth-D9Ej5fM", "()F", "F", "ScrollableTabRowEdgeStartPadding", "getScrollableTabRowEdgeStartPadding-D9Ej5fM", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor$annotations", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "primaryContainerColor", "getPrimaryContainerColor", "secondaryContainerColor", "getSecondaryContainerColor", "contentColor", "getContentColor$annotations", "getContentColor", "primaryContentColor", "getPrimaryContentColor", "secondaryContentColor", "getSecondaryContentColor", "Indicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "height", "color", "Indicator-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "PrimaryIndicator", "width", "shape", "Landroidx/compose/ui/graphics/Shape;", "PrimaryIndicator-10LGxhE", "(Landroidx/compose/ui/Modifier;FFJLandroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "SecondaryIndicator", "SecondaryIndicator-9IZ8Weo", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material3/TabPosition;", "material3", "currentTabWidth", "indicatorOffset"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TabRowDefaults {
    public static final int $stable = 0;
    public static final TabRowDefaults INSTANCE = new TabRowDefaults();
    private static final float ScrollableTabRowMinTabWidth = Dp.m9114constructorimpl(90.0f);
    private static final float ScrollableTabRowEdgeStartPadding = Dp.m9114constructorimpl(52.0f);

    /* JADX INFO: renamed from: androidx.compose.material3.TabRowDefaults$tabIndicatorOffset$2, reason: invalid class name */
    /* JADX INFO: compiled from: TabRow.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass2 implements Function3<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ TabPosition $currentTabPosition;

        AnonymousClass2(TabPosition tabPosition) {
            this.$currentTabPosition = tabPosition;
        }

        private static final float invoke$lambda$0(State<Dp> state) {
            return state.getValue().m9128unboximpl();
        }

        private static final float invoke$lambda$1(State<Dp> state) {
            return state.getValue().m9128unboximpl();
        }

        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            composer.startReplaceGroup(-1541271084);
            ComposerKt.sourceInformation(composer, "C1111@47460L7,1109@47309L177,1116@47688L7,1114@47538L176,1120@47822L53:TabRow.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1541271084, i, -1, "androidx.compose.material3.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:1108)");
            }
            State<Dp> stateM1380animateDpAsStateAjpBEmI = AnimateAsStateKt.m1380animateDpAsStateAjpBEmI(this.$currentTabPosition.getWidth(), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6), null, null, composer, 0, 12);
            final State<Dp> stateM1380animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m1380animateDpAsStateAjpBEmI(this.$currentTabPosition.getLeft(), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6), null, null, composer, 0, 12);
            Modifier modifierWrapContentSize$default = SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), Alignment.INSTANCE.getBottomStart(), false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 602226121, "CC(remember):TabRow.kt#9igjgp");
            boolean zChanged = composer.changed(stateM1380animateDpAsStateAjpBEmI2);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TabRowDefaults$tabIndicatorOffset$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IntOffset.m9233boximpl(IntOffset.m9236constructorimpl(((long) ((Density) obj).mo1618roundToPx0680j_4(TabRowDefaults.AnonymousClass2.invoke$lambda$1(stateM1380animateDpAsStateAjpBEmI2))) << 32));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM2088width3ABfNKs = SizeKt.m2088width3ABfNKs(OffsetKt.offset(modifierWrapContentSize$default, (Function1) objRememberedValue), invoke$lambda$0(stateM1380animateDpAsStateAjpBEmI));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return modifierM2088width3ABfNKs;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }
    }

    private TabRowDefaults() {
    }

    static final Unit Indicator_9IZ8Weo$lambda$0(TabRowDefaults tabRowDefaults, Modifier modifier, float f, long j, int i, int i2, Composer composer, int i3) {
        tabRowDefaults.m4185Indicator9IZ8Weo(modifier, f, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit PrimaryIndicator_10LGxhE$lambda$1(TabRowDefaults tabRowDefaults, Modifier modifier, float f, float f2, long j, Shape shape, int i, int i2, Composer composer, int i3) {
        tabRowDefaults.m4186PrimaryIndicator10LGxhE(modifier, f, f2, j, shape, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit SecondaryIndicator_9IZ8Weo$lambda$2(TabRowDefaults tabRowDefaults, Modifier modifier, float f, long j, int i, int i2, Composer composer, int i3) {
        tabRowDefaults.m4187SecondaryIndicator9IZ8Weo(modifier, f, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Deprecated(message = "Use TabRowDefaults.primaryContainerColor instead", replaceWith = @ReplaceWith(expression = "primaryContainerColor", imports = {}))
    public static /* synthetic */ void getContainerColor$annotations() {
    }

    @Deprecated(message = "Use TabRowDefaults.primaryContentColor instead", replaceWith = @ReplaceWith(expression = "primaryContentColor", imports = {}))
    public static /* synthetic */ void getContentColor$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    @Deprecated(message = "Use SecondaryIndicator instead.", replaceWith = @ReplaceWith(expression = "SecondaryIndicator(modifier, height, color)", imports = {}))
    /* JADX INFO: renamed from: Indicator-9IZ8Weo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4185Indicator9IZ8Weo(Modifier modifier, float f, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        float f2;
        long j2;
        final Modifier.Companion companion;
        final float fM5283getActiveIndicatorHeightD9Ej5fM;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jFromToken;
        Composer composerStartRestartGroup = composer.startRestartGroup(1454716052);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Indicator)N(modifier,height:c#ui.unit.Dp,color:c#ui.graphics.Color)1039@44576L69:TabRow.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                f2 = f;
                i3 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    j2 = j;
                    int i6 = composerStartRestartGroup.changed(j2) ? 256 : 128;
                    i3 |= i6;
                } else {
                    j2 = j;
                }
                i3 |= i6;
            } else {
                j2 = j;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                fM5283getActiveIndicatorHeightD9Ej5fM = f2;
                j3 = j2;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1037@44488L11");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                    fM5283getActiveIndicatorHeightD9Ej5fM = i5 != 0 ? PrimaryNavigationTabTokens.INSTANCE.m5283getActiveIndicatorHeightD9Ej5fM() : f2;
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        jFromToken = ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor());
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1454716052, i3, -1, "androidx.compose.material3.TabRowDefaults.Indicator (TabRow.kt:1038)");
                    }
                    BoxKt.Box(BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), fM5283getActiveIndicatorHeightD9Ej5fM), jFromToken, null, 2, null), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jFromToken;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    companion = modifier2;
                    fM5283getActiveIndicatorHeightD9Ej5fM = f2;
                }
                jFromToken = j2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                BoxKt.Box(BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), fM5283getActiveIndicatorHeightD9Ej5fM), jFromToken, null, 2, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                j3 = jFromToken;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowDefaults.Indicator_9IZ8Weo$lambda$0(this.f$0, companion, fM5283getActiveIndicatorHeightD9Ej5fM, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        f2 = f;
        if ((i & 384) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: PrimaryIndicator-10LGxhE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4186PrimaryIndicator10LGxhE(Modifier modifier, float f, float f2, long j, Shape shape, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        float fM9114constructorimpl;
        int i4;
        float fM5283getActiveIndicatorHeightD9Ej5fM;
        long value;
        int i5;
        Shape activeIndicatorShape;
        final Modifier.Companion companion;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1895596205);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PrimaryIndicator)N(modifier,width:c#ui.unit.Dp,height:c#ui.unit.Dp,color:c#ui.graphics.Color,shape)1060@45366L174:TabRow.kt#uh7d8r");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                fM9114constructorimpl = f;
                i3 |= composerStartRestartGroup.changed(fM9114constructorimpl) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    fM5283getActiveIndicatorHeightD9Ej5fM = f2;
                    i3 |= composerStartRestartGroup.changed(fM5283getActiveIndicatorHeightD9Ej5fM) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        value = j;
                        int i8 = composerStartRestartGroup.changed(value) ? 2048 : 1024;
                        i3 |= i8;
                    } else {
                        value = j;
                    }
                    i3 |= i8;
                } else {
                    value = j;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        activeIndicatorShape = shape;
                        i3 |= composerStartRestartGroup.changed(activeIndicatorShape) ? 16384 : 8192;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        companion = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "1057@45271L5");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i7 != 0) {
                                fM9114constructorimpl = Dp.m9114constructorimpl(24.0f);
                            }
                            if (i4 != 0) {
                                fM5283getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5283getActiveIndicatorHeightD9Ej5fM();
                            }
                            if ((i2 & 8) != 0) {
                                value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                                i3 &= -7169;
                            }
                            if (i5 != 0) {
                                activeIndicatorShape = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            companion = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1895596205, i3, -1, "androidx.compose.material3.TabRowDefaults.PrimaryIndicator (TabRow.kt:1059)");
                        }
                        SpacerKt.Spacer(BackgroundKt.m1482backgroundbw27NRU(SizeKt.m2080requiredWidth3ABfNKs(SizeKt.m2072requiredHeight3ABfNKs(companion, fM5283getActiveIndicatorHeightD9Ej5fM), fM9114constructorimpl), value, activeIndicatorShape), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    final float f3 = fM9114constructorimpl;
                    final float f4 = fM5283getActiveIndicatorHeightD9Ej5fM;
                    final long j2 = value;
                    final Shape shape2 = activeIndicatorShape;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowDefaults.PrimaryIndicator_10LGxhE$lambda$1(this.f$0, companion, f3, f4, j2, shape2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                activeIndicatorShape = shape;
                if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                }
                final float f32 = fM9114constructorimpl;
                final float f42 = fM5283getActiveIndicatorHeightD9Ej5fM;
                final long j22 = value;
                final Shape shape22 = activeIndicatorShape;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            fM5283getActiveIndicatorHeightD9Ej5fM = f2;
            if ((i & 3072) == 0) {
            }
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            activeIndicatorShape = shape;
            if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
            }
            final float f322 = fM9114constructorimpl;
            final float f422 = fM5283getActiveIndicatorHeightD9Ej5fM;
            final long j222 = value;
            final Shape shape222 = activeIndicatorShape;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        fM9114constructorimpl = f;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        fM5283getActiveIndicatorHeightD9Ej5fM = f2;
        if ((i & 3072) == 0) {
        }
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        activeIndicatorShape = shape;
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        final float f3222 = fM9114constructorimpl;
        final float f4222 = fM5283getActiveIndicatorHeightD9Ej5fM;
        final long j2222 = value;
        final Shape shape2222 = activeIndicatorShape;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: SecondaryIndicator-9IZ8Weo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4187SecondaryIndicator9IZ8Weo(Modifier modifier, float f, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        float f2;
        long j2;
        final Modifier.Companion companion;
        final float fM5283getActiveIndicatorHeightD9Ej5fM;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long value;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1498258020);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SecondaryIndicator)N(modifier,height:c#ui.unit.Dp,color:c#ui.graphics.Color)1082@46080L69:TabRow.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                f2 = f;
                i3 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    j2 = j;
                    int i6 = composerStartRestartGroup.changed(j2) ? 256 : 128;
                    i3 |= i6;
                } else {
                    j2 = j;
                }
                i3 |= i6;
            } else {
                j2 = j;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                fM5283getActiveIndicatorHeightD9Ej5fM = f2;
                j3 = j2;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1080@46057L5");
                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                    fM5283getActiveIndicatorHeightD9Ej5fM = i5 != 0 ? PrimaryNavigationTabTokens.INSTANCE.m5283getActiveIndicatorHeightD9Ej5fM() : f2;
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1498258020, i3, -1, "androidx.compose.material3.TabRowDefaults.SecondaryIndicator (TabRow.kt:1081)");
                    }
                    BoxKt.Box(BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), fM5283getActiveIndicatorHeightD9Ej5fM), value, null, 2, null), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = value;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    companion = modifier2;
                    fM5283getActiveIndicatorHeightD9Ej5fM = f2;
                }
                value = j2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                BoxKt.Box(BackgroundKt.m1483backgroundbw27NRU$default(SizeKt.m2069height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), fM5283getActiveIndicatorHeightD9Ej5fM), value, null, 2, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                j3 = value;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowDefaults.SecondaryIndicator_9IZ8Weo$lambda$2(this.f$0, companion, fM5283getActiveIndicatorHeightD9Ej5fM, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        f2 = f;
        if ((i & 384) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2026555673, "C(<get-containerColor>)994@42840L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2026555673, i, -1, "androidx.compose.material3.TabRowDefaults.<get-containerColor> (TabRow.kt:994)");
        }
        long value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContentColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1163072359, "C(<get-contentColor>)1010@43495L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1163072359, i, -1, "androidx.compose.material3.TabRowDefaults.<get-contentColor> (TabRow.kt:1010)");
        }
        long value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getPrimaryContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2069154037, "C(<get-primaryContainerColor>)998@43011L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2069154037, i, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContainerColor> (TabRow.kt:998)");
        }
        long value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getPrimaryContentColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1410362619, "C(<get-primaryContentColor>)1014@43668L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1410362619, i, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContentColor> (TabRow.kt:1014)");
        }
        long value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getScrollableTabRowEdgeStartPadding-D9Ej5fM, reason: not valid java name */
    public final float m4188getScrollableTabRowEdgeStartPaddingD9Ej5fM() {
        return ScrollableTabRowEdgeStartPadding;
    }

    /* JADX INFO: renamed from: getScrollableTabRowMinTabWidth-D9Ej5fM, reason: not valid java name */
    public final float m4189getScrollableTabRowMinTabWidthD9Ej5fM() {
        return ScrollableTabRowMinTabWidth;
    }

    public final long getSecondaryContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1938007129, "C(<get-secondaryContainerColor>)1002@43188L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1938007129, i, -1, "androidx.compose.material3.TabRowDefaults.<get-secondaryContainerColor> (TabRow.kt:1002)");
        }
        long value = ColorSchemeKt.getValue(SecondaryNavigationTabTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getSecondaryContentColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1166419479, "C(<get-secondaryContentColor>)1018@43847L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1166419479, i, -1, "androidx.compose.material3.TabRowDefaults.<get-secondaryContentColor> (TabRow.kt:1018)");
        }
        long value = ColorSchemeKt.getValue(SecondaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Solely for use alongside deprecated TabRowDefaults.Indicator method. For recommended PrimaryIndicator and SecondaryIndicator methods, please use TabIndicatorScope.tabIndicatorOffset method.")
    public final Modifier tabIndicatorOffset(Modifier modifier, final TabPosition tabPosition) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("tabIndicatorOffset");
                inspectorInfo.setValue(tabPosition);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(tabPosition));
    }
}
