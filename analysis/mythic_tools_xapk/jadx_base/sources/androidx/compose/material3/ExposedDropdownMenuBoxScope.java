package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\tH&J\u0095\u0001\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0004\b*\u0010+J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0005H\u0007J\u009f\u0001\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010,\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0004\b.\u0010/JU\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0002\u00100R\u0012\u0010\u000e\u001a\u00020\u0007X \u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\tX \u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u00011¨\u00062"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "", "<init>", "()V", "menuAnchor", "Landroidx/compose/ui/Modifier;", "type", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "enabled", "", "menuAnchor-2Hz36ac", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Z)Landroidx/compose/ui/Modifier;", "exposedDropdownSize", "matchAnchorWidth", "anchorType", "getAnchorType-oYjWRB4$material3", "()Ljava/lang/String;", "alwaysFocusable", "getAlwaysFocusable$material3", "()Z", "ExposedDropdownMenu", "", "expanded", "onDismissRequest", "Lkotlin/Function0;", "modifier", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "ExposedDropdownMenu-vNxi1II", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "focusable", "matchTextFieldWidth", "ExposedDropdownMenu-kbRbctU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/material3/ExposedDropdownMenuBoxScopeImpl;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ExposedDropdownMenuBoxScope {
    public static final int $stable = 0;

    private ExposedDropdownMenuBoxScope() {
    }

    public /* synthetic */ ExposedDropdownMenuBoxScope(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    static final Unit ExposedDropdownMenu$lambda$9(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z, Function0 function0, Modifier modifier, ScrollState scrollState, Function3 function3, int i, int i2, Composer composer, int i3) {
        exposedDropdownMenuBoxScope.ExposedDropdownMenu(z, function0, modifier, scrollState, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit ExposedDropdownMenu_kbRbctU$lambda$8(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z, Function0 function0, Modifier modifier, ScrollState scrollState, boolean z2, boolean z3, Shape shape, long j, float f, float f2, BorderStroke borderStroke, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        exposedDropdownMenuBoxScope.m3641ExposedDropdownMenukbRbctU(z, function0, modifier, scrollState, z2, z3, shape, j, f, f2, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit ExposedDropdownMenu_vNxi1II$lambda$2$lambda$1(MutableState mutableState) {
        mutableState.setValue(Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    static final Unit ExposedDropdownMenu_vNxi1II$lambda$6$lambda$5(MutableState mutableState, IntRect intRect, IntRect intRect2) {
        mutableState.setValue(TransformOrigin.m6725boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
        return Unit.INSTANCE;
    }

    static final Unit ExposedDropdownMenu_vNxi1II$lambda$7(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z, Function0 function0, Modifier modifier, ScrollState scrollState, boolean z2, Shape shape, long j, float f, float f2, BorderStroke borderStroke, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        exposedDropdownMenuBoxScope.m3642ExposedDropdownMenuvNxi1II(z, function0, modifier, scrollState, z2, shape, j, f, f2, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
    }

    /* JADX INFO: renamed from: menuAnchor-2Hz36ac$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3640menuAnchor2Hz36ac$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: menuAnchor-2Hz36ac");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return exposedDropdownMenuBoxScope.mo3644menuAnchor2Hz36ac(modifier, str, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x015a  */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v7, types: [androidx.compose.material3.ExposedDropdownMenuBoxScope] */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with customization options parameters.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void ExposedDropdownMenu(final boolean z, final Function0 function0, Modifier modifier, ScrollState scrollState, final Function3 function3, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        Function0 function02;
        final Modifier modifier2;
        final ScrollState scrollState2;
        Function3 function32;
        ?? r8;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        ScrollState scrollStateRememberScrollState;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1501437777);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExposedDropdownMenu)N(expanded,onDismissRequest,modifier,scrollState,content)436@19905L5,437@19954L14,430@19657L498:ExposedDropdownMenu.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    scrollState2 = scrollState;
                    int i5 = composerStartRestartGroup.changed(scrollState2) ? 2048 : 1024;
                    i3 |= i5;
                } else {
                    scrollState2 = scrollState;
                }
                i3 |= i5;
            } else {
                scrollState2 = scrollState;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    function32 = function3;
                    i3 |= composerStartRestartGroup.changedInstance(function32) ? 16384 : 8192;
                }
                if ((i2 & 32) == 0) {
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        Object obj = this;
                        i3 |= composerStartRestartGroup.changed(obj) ? 131072 : 65536;
                        r8 = obj;
                    }
                    if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                        Composer composer3 = composerStartRestartGroup;
                        composer3.skipToGroupEnd();
                        composer2 = composer3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "427@19565L21");
                        if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                modifier3 = companion;
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1501437777, i3, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:430)");
                                }
                                int i6 = i3 >> 9;
                                Composer composer4 = composerStartRestartGroup;
                                r8.m3641ExposedDropdownMenukbRbctU(z2, function02, modifier3, scrollStateRememberScrollState, false, true, MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.m3811getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m3810getShadowElevationD9Ej5fM(), null, function32, composer4, (i3 & 14) | 906166272 | (i3 & 112) | (i3 & 896) | (i3 & 7168), (i6 & 112) | 6 | (i6 & 896), 16);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                scrollState2 = scrollStateRememberScrollState;
                                composer2 = composer4;
                            } else {
                                modifier3 = companion;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            modifier3 = modifier2;
                        }
                        scrollStateRememberScrollState = scrollState2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i62 = i3 >> 9;
                        Composer composer42 = composerStartRestartGroup;
                        r8.m3641ExposedDropdownMenukbRbctU(z2, function02, modifier3, scrollStateRememberScrollState, false, true, MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.m3811getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m3810getShadowElevationD9Ej5fM(), null, function32, composer42, (i3 & 14) | 906166272 | (i3 & 112) | (i3 & 896) | (i3 & 7168), (i62 & 112) | 6 | (i62 & 896), 16);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier2 = modifier3;
                        scrollState2 = scrollStateRememberScrollState;
                        composer2 = composer42;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return ExposedDropdownMenuBoxScope.ExposedDropdownMenu$lambda$9(this.f$0, z, function0, modifier2, scrollState2, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                r8 = this;
                if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function32 = function3;
            if ((i2 & 32) == 0) {
            }
            r8 = this;
            if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 3072) != 0) {
        }
        if ((i2 & 16) == 0) {
        }
        function32 = function3;
        if ((i2 & 32) == 0) {
        }
        r8 = this;
        if (composerStartRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:196:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0122  */
    @Deprecated(level = DeprecationLevel.WARNING, message = "The `focusable` parameter is unused. Pass the proper ExposedDropdownMenuAnchorType to Modifier.menuAnchor instead, which will handle focusability automatically.")
    /* JADX INFO: renamed from: ExposedDropdownMenu-kbRbctU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3641ExposedDropdownMenukbRbctU(final boolean z, final Function0<Unit> function0, Modifier modifier, ScrollState scrollState, boolean z2, boolean z3, Shape shape, long j, float f, float f2, BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function0<Unit> function02;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z4;
        Shape shape2;
        long containerColor;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Composer composer2;
        final ScrollState scrollState2;
        final float f3;
        final boolean z5;
        final Shape shape3;
        final long j2;
        final Modifier modifier3;
        final boolean z6;
        final float f4;
        final BorderStroke borderStroke2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ScrollState scrollStateRememberScrollState;
        boolean z7;
        Shape shape4;
        BorderStroke borderStroke3;
        ScrollState scrollState3;
        float f5;
        boolean z8;
        Shape shape5;
        float f6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1772805535);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExposedDropdownMenu)N(expanded,onDismissRequest,modifier,scrollState,focusable,matchTextFieldWidth,shape,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,content)401@18683L460:ExposedDropdownMenu.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                function02 = function0;
                i4 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    modifier2 = modifier;
                    i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    i4 |= ((i3 & 8) == 0 && composerStartRestartGroup.changed(scrollState)) ? 2048 : 1024;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    z4 = z3;
                } else {
                    z4 = z3;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
                    }
                }
                if ((i & 1572864) == 0) {
                    shape2 = shape;
                    i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(shape2)) ? 1048576 : 524288;
                } else {
                    shape2 = shape;
                }
                if ((i & 12582912) == 0) {
                    containerColor = j;
                    i4 |= ((i3 & 128) == 0 && composerStartRestartGroup.changed(containerColor)) ? 8388608 : 4194304;
                } else {
                    containerColor = j;
                }
                i7 = i3 & 256;
                if (i7 != 0) {
                    i4 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i4 |= composerStartRestartGroup.changed(f) ? 67108864 : 33554432;
                }
                i8 = i3 & 512;
                if (i8 != 0) {
                    i4 |= 805306368;
                } else {
                    if ((i & 805306368) == 0) {
                        i9 = i8;
                        i4 |= composerStartRestartGroup.changed(f2) ? 536870912 : 268435456;
                    }
                    i10 = i3 & 1024;
                    if (i10 == 0) {
                        i12 = i2 | 6;
                        i11 = i10;
                    } else if ((i2 & 6) == 0) {
                        i11 = i10;
                        i12 = i2 | (composerStartRestartGroup.changed(borderStroke) ? 4 : 2);
                    } else {
                        i11 = i10;
                        i12 = i2;
                    }
                    if ((i3 & 2048) == 0) {
                        i12 |= 48;
                    } else if ((i2 & 48) == 0) {
                        i12 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
                    }
                    i13 = i12;
                    if ((i3 & 4096) != 0) {
                        if ((i2 & 384) == 0) {
                            i13 |= composerStartRestartGroup.changed(this) ? 256 : 128;
                        }
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306775187) == 306775186 && (i13 & 147) == 146) ? false : true, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "391@18251L21,394@18390L5,395@18442L14");
                            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i5 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i3 & 8) != 0) {
                                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                    i4 &= -7169;
                                } else {
                                    scrollStateRememberScrollState = scrollState;
                                }
                                z7 = (i3 & 16) != 0 ? true : z2;
                                boolean z9 = i6 == 0 ? z4 : true;
                                if ((i3 & 64) != 0) {
                                    shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                    i4 &= -3670017;
                                } else {
                                    shape4 = shape2;
                                }
                                if ((i3 & 128) != 0) {
                                    containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -29360129;
                                }
                                float fM3811getTonalElevationD9Ej5fM = i7 != 0 ? MenuDefaults.INSTANCE.m3811getTonalElevationD9Ej5fM() : f;
                                float fM3810getShadowElevationD9Ej5fM = i9 != 0 ? MenuDefaults.INSTANCE.m3810getShadowElevationD9Ej5fM() : f2;
                                if (i11 != 0) {
                                    scrollState3 = scrollStateRememberScrollState;
                                    f5 = fM3811getTonalElevationD9Ej5fM;
                                    z8 = z9;
                                    shape5 = shape4;
                                    f6 = fM3810getShadowElevationD9Ej5fM;
                                    borderStroke3 = null;
                                } else {
                                    borderStroke3 = borderStroke;
                                    scrollState3 = scrollStateRememberScrollState;
                                    f5 = fM3811getTonalElevationD9Ej5fM;
                                    z8 = z9;
                                    shape5 = shape4;
                                    f6 = fM3810getShadowElevationD9Ej5fM;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                scrollState3 = scrollState;
                                z7 = z2;
                                f5 = f;
                                f6 = f2;
                                borderStroke3 = borderStroke;
                                z8 = z4;
                                shape5 = shape2;
                            }
                            long j3 = containerColor;
                            Modifier modifier4 = modifier2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1772805535, i4, i13, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:401)");
                            }
                            int i14 = i4 >> 3;
                            composer2 = composerStartRestartGroup;
                            m3642ExposedDropdownMenuvNxi1II(z, function02, modifier4, scrollState3, z8, shape5, j3, f5, f6, borderStroke3, function3, composer2, (i4 & 8190) | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (29360128 & i14) | (i14 & 234881024) | ((i13 << 27) & 1879048192), (i13 >> 3) & 126, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z7;
                            modifier3 = modifier4;
                            scrollState2 = scrollState3;
                            z5 = z8;
                            shape3 = shape5;
                            j2 = j3;
                            f3 = f5;
                            f4 = f6;
                            borderStroke2 = borderStroke3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            scrollState2 = scrollState;
                            f3 = f;
                            z5 = z4;
                            shape3 = shape2;
                            j2 = containerColor;
                            modifier3 = modifier2;
                            z6 = z2;
                            f4 = f2;
                            borderStroke2 = borderStroke;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_kbRbctU$lambda$8(this.f$0, z, function0, modifier3, scrollState2, z6, z5, shape3, j2, f3, f4, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i13 |= 384;
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306775187) == 306775186 && (i13 & 147) == 146) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i9 = i8;
                i10 = i3 & 1024;
                if (i10 == 0) {
                }
                if ((i3 & 2048) == 0) {
                }
                i13 = i12;
                if ((i3 & 4096) != 0) {
                }
                if (composerStartRestartGroup.shouldExecute(((i4 & 306775187) == 306775186 && (i13 & 147) == 146) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            if ((i & 3072) == 0) {
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i7 = i3 & 256;
            if (i7 != 0) {
            }
            i8 = i3 & 512;
            if (i8 != 0) {
            }
            i9 = i8;
            i10 = i3 & 1024;
            if (i10 == 0) {
            }
            if ((i3 & 2048) == 0) {
            }
            i13 = i12;
            if ((i3 & 4096) != 0) {
            }
            if (composerStartRestartGroup.shouldExecute(((i4 & 306775187) == 306775186 && (i13 & 147) == 146) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        function02 = function0;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        modifier2 = modifier;
        if ((i & 3072) == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i7 = i3 & 256;
        if (i7 != 0) {
        }
        i8 = i3 & 512;
        if (i8 != 0) {
        }
        i9 = i8;
        i10 = i3 & 1024;
        if (i10 == 0) {
        }
        if ((i3 & 2048) == 0) {
        }
        i13 = i12;
        if ((i3 & 4096) != 0) {
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306775187) == 306775186 && (i13 & 147) == 146) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX INFO: renamed from: ExposedDropdownMenu-vNxi1II, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3642ExposedDropdownMenuvNxi1II(final boolean z, final Function0<Unit> function0, Modifier modifier, ScrollState scrollState, boolean z2, Shape shape, long j, float f, float f2, BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function0<Unit> function02;
        int i5;
        Modifier modifier2;
        ScrollState scrollState2;
        int i6;
        boolean z3;
        final long containerColor;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Composer composer2;
        final Shape shape2;
        final float f3;
        final Modifier modifier3;
        final ScrollState scrollState3;
        final boolean z4;
        final float f4;
        final BorderStroke borderStroke2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ScrollState scrollStateRememberScrollState;
        Shape shape3;
        final BorderStroke borderStroke3;
        final Modifier modifier4;
        final float f5;
        final long j2;
        final Shape shape4;
        final ScrollState scrollState4;
        final float f6;
        final boolean z5;
        Object objRememberedValue;
        final MutableState mutableState;
        Density density;
        int top;
        Object objRememberedValue2;
        final MutableTransitionState mutableTransitionState;
        Object objRememberedValue3;
        final MutableState mutableState2;
        boolean zChanged;
        Object objRememberedValue4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-126848451);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExposedDropdownMenu)N(expanded,onDismissRequest,modifier,scrollState,matchAnchorWidth,shape,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,content)324@15347L53,325@15436L7,326@15487L10,333@15744L42:ExposedDropdownMenu.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                function02 = function0;
                i4 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else {
                if ((i & 384) == 0) {
                    modifier2 = modifier;
                    i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    if ((i3 & 8) == 0) {
                        scrollState2 = scrollState;
                        int i14 = composerStartRestartGroup.changed(scrollState2) ? 2048 : 1024;
                        i4 |= i14;
                    } else {
                        scrollState2 = scrollState;
                    }
                    i4 |= i14;
                } else {
                    scrollState2 = scrollState;
                }
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        z3 = z2;
                        i4 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(shape)) ? 131072 : 65536;
                    }
                    if ((i & 1572864) != 0) {
                        containerColor = j;
                        i4 |= ((i3 & 64) == 0 && composerStartRestartGroup.changed(containerColor)) ? 1048576 : 524288;
                    } else {
                        containerColor = j;
                    }
                    i7 = i3 & 128;
                    if (i7 == 0) {
                        i4 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i4 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
                    }
                    i8 = i3 & 256;
                    if (i8 == 0) {
                        i4 |= 100663296;
                    } else {
                        if ((i & 100663296) == 0) {
                            i9 = i8;
                            i4 |= composerStartRestartGroup.changed(f2) ? 67108864 : 33554432;
                        }
                        i10 = i3 & 512;
                        if (i10 != 0) {
                            i4 |= 805306368;
                        } else {
                            if ((i & 805306368) == 0) {
                                i11 = i10;
                                i4 |= composerStartRestartGroup.changed(borderStroke) ? 536870912 : 268435456;
                            }
                            if ((i3 & 1024) == 0) {
                                i12 = i2 | 6;
                            } else if ((i2 & 6) == 0) {
                                i12 = i2 | (composerStartRestartGroup.changedInstance(function3) ? 4 : 2);
                            } else {
                                i12 = i2;
                            }
                            if ((i3 & 2048) != 0) {
                                if ((i2 & 48) == 0) {
                                    i12 |= composerStartRestartGroup.changed(this) ? 32 : 16;
                                }
                                i13 = i12;
                                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "313@14737L21,315@14838L5,316@14890L14");
                                    if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                                        if ((i3 & 8) != 0) {
                                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                            i4 &= -7169;
                                        } else {
                                            scrollStateRememberScrollState = scrollState2;
                                        }
                                        if (i6 != 0) {
                                            z3 = true;
                                        }
                                        if ((i3 & 32) != 0) {
                                            shape3 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                            i4 &= -458753;
                                        } else {
                                            shape3 = shape;
                                        }
                                        if ((i3 & 64) != 0) {
                                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                            i4 &= -3670017;
                                        }
                                        float fM3811getTonalElevationD9Ej5fM = i7 != 0 ? MenuDefaults.INSTANCE.m3811getTonalElevationD9Ej5fM() : f;
                                        float fM3810getShadowElevationD9Ej5fM = i9 != 0 ? MenuDefaults.INSTANCE.m3810getShadowElevationD9Ej5fM() : f2;
                                        if (i11 != 0) {
                                            modifier4 = companion;
                                            f5 = fM3811getTonalElevationD9Ej5fM;
                                            j2 = containerColor;
                                            shape4 = shape3;
                                            scrollState4 = scrollStateRememberScrollState;
                                            f6 = fM3810getShadowElevationD9Ej5fM;
                                            z5 = z3;
                                            borderStroke3 = null;
                                            composerStartRestartGroup.endDefaults();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-126848451, i4, i13, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:321)");
                                            }
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642251790, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                            }
                                            mutableState = (MutableState) objRememberedValue;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object objConsume = composerStartRestartGroup.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            density = (Density) objConsume;
                                            top = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getTop(density);
                                            if (z) {
                                                composerStartRestartGroup.startReplaceGroup(630077189);
                                                composerStartRestartGroup.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(629991660);
                                                ComposerKt.sourceInformation(composerStartRestartGroup, "329@15580L36,329@15551L65");
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642244351, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                                                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda2
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Object invoke() {
                                                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$2$lambda$1(mutableState);
                                                        }
                                                    };
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange((Function0) objRememberedValue5, composerStartRestartGroup, 6);
                                                composerStartRestartGroup.endReplaceGroup();
                                            }
                                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642239097, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                objRememberedValue2 = new MutableTransitionState(false);
                                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                            }
                                            mutableTransitionState = (MutableTransitionState) objRememberedValue2;
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                                            if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue() || ((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
                                                composerStartRestartGroup.startReplaceGroup(630396489);
                                                ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642232720, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m6725boximpl(TransformOrigin.INSTANCE.m6738getCenterSzJe1aQ()), null, 2, null);
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                                }
                                                mutableState2 = (MutableState) objRememberedValue3;
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642228829, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                                                zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                                if (!zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Object invoke(Object obj, Object obj2) {
                                                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$6$lambda$5(mutableState2, (IntRect) obj, (IntRect) obj2);
                                                        }
                                                    }, 8, null);
                                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                                AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function02, ExposedDropdownMenu_androidKt.m3660popupPropertiesForAnchorTypeBTG8q0(mo3643getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.2
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                        invoke(composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i15) {
                                                        ComposerKt.sourceInformation(composer3, "C355@16794L552:ExposedDropdownMenu.kt#uh7d8r");
                                                        if (!composer3.shouldExecute((i15 & 3) != 2, i15 & 1)) {
                                                            composer3.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(2063119149, i15, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.<anonymous> (ExposedDropdownMenu.kt:355)");
                                                        }
                                                        MenuKt.m3824DropdownMenuContentQj0Zi0g(ExposedDropdownMenuBoxScope.this.exposedDropdownSize(modifier4, z5), mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke3, function3, composer3, (MutableTransitionState.$stable << 3) | 384);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                                                composer2 = composerStartRestartGroup;
                                                composer2.endReplaceGroup();
                                            } else {
                                                composerStartRestartGroup.startReplaceGroup(631807237);
                                                composerStartRestartGroup.endReplaceGroup();
                                                composer2 = composerStartRestartGroup;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            modifier3 = modifier4;
                                            z4 = z5;
                                            scrollState3 = scrollState4;
                                            shape2 = shape4;
                                            containerColor = j2;
                                            f3 = f5;
                                            f4 = f6;
                                            borderStroke2 = borderStroke3;
                                        } else {
                                            borderStroke3 = borderStroke;
                                            modifier4 = companion;
                                            f5 = fM3811getTonalElevationD9Ej5fM;
                                            j2 = containerColor;
                                            shape4 = shape3;
                                            scrollState4 = scrollStateRememberScrollState;
                                            f6 = fM3810getShadowElevationD9Ej5fM;
                                        }
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i3 & 8) != 0) {
                                            i4 &= -7169;
                                        }
                                        if ((i3 & 32) != 0) {
                                            i4 &= -458753;
                                        }
                                        if ((i3 & 64) != 0) {
                                            i4 &= -3670017;
                                        }
                                        shape4 = shape;
                                        f5 = f;
                                        f6 = f2;
                                        borderStroke3 = borderStroke;
                                        j2 = containerColor;
                                        modifier4 = modifier2;
                                        scrollState4 = scrollState2;
                                    }
                                    z5 = z3;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642251790, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    }
                                    mutableState = (MutableState) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    density = (Density) objConsume2;
                                    top = WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getTop(density);
                                    if (z) {
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642239097, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    }
                                    mutableTransitionState = (MutableTransitionState) objRememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                                    if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                                        composerStartRestartGroup.startReplaceGroup(630396489);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642232720, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        }
                                        mutableState2 = (MutableState) objRememberedValue3;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1642228829, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                                        zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(top);
                                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                        if (!zChanged) {
                                            objRememberedValue4 = new ExposedDropdownMenuPositionProvider(density, top, mutableState, 0, new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3
                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(Object obj, Object obj2) {
                                                    return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$6$lambda$5(mutableState2, (IntRect) obj, (IntRect) obj2);
                                                }
                                            }, 8, null);
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                            AndroidPopup_androidKt.Popup((ExposedDropdownMenuPositionProvider) objRememberedValue4, function02, ExposedDropdownMenu_androidKt.m3660popupPropertiesForAnchorTypeBTG8q0(mo3643getAnchorTypeoYjWRB4$material3(), getAlwaysFocusable$material3(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(2063119149, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.2
                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                    invoke(composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i15) {
                                                    ComposerKt.sourceInformation(composer3, "C355@16794L552:ExposedDropdownMenu.kt#uh7d8r");
                                                    if (!composer3.shouldExecute((i15 & 3) != 2, i15 & 1)) {
                                                        composer3.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(2063119149, i15, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.<anonymous> (ExposedDropdownMenu.kt:355)");
                                                    }
                                                    MenuKt.m3824DropdownMenuContentQj0Zi0g(ExposedDropdownMenuBoxScope.this.exposedDropdownSize(modifier4, z5), mutableTransitionState, mutableState2, scrollState4, shape4, j2, f5, f6, borderStroke3, function3, composer3, (MutableTransitionState.$stable << 3) | 384);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 112) | 3072, 0);
                                            composer2 = composerStartRestartGroup;
                                            composer2.endReplaceGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            modifier3 = modifier4;
                                            z4 = z5;
                                            scrollState3 = scrollState4;
                                            shape2 = shape4;
                                            containerColor = j2;
                                            f3 = f5;
                                            f4 = f6;
                                            borderStroke2 = borderStroke3;
                                        }
                                    }
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    shape2 = shape;
                                    f3 = f;
                                    modifier3 = modifier2;
                                    scrollState3 = scrollState2;
                                    z4 = z3;
                                    f4 = f2;
                                    borderStroke2 = borderStroke;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return ExposedDropdownMenuBoxScope.ExposedDropdownMenu_vNxi1II$lambda$7(this.f$0, z, function0, modifier3, scrollState3, z4, shape2, containerColor, f3, f4, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i12 |= 48;
                            i13 = i12;
                            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        i11 = i10;
                        if ((i3 & 1024) == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                        }
                        i13 = i12;
                        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    i9 = i8;
                    i10 = i3 & 512;
                    if (i10 != 0) {
                    }
                    i11 = i10;
                    if ((i3 & 1024) == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                    }
                    i13 = i12;
                    if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z3 = z2;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                if ((i & 1572864) != 0) {
                }
                i7 = i3 & 128;
                if (i7 == 0) {
                }
                i8 = i3 & 256;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i3 & 512;
                if (i10 != 0) {
                }
                i11 = i10;
                if ((i3 & 1024) == 0) {
                }
                if ((i3 & 2048) != 0) {
                }
                i13 = i12;
                if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            if ((i & 3072) == 0) {
            }
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            z3 = z2;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if ((i & 1572864) != 0) {
            }
            i7 = i3 & 128;
            if (i7 == 0) {
            }
            i8 = i3 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i3 & 512;
            if (i10 != 0) {
            }
            i11 = i10;
            if ((i3 & 1024) == 0) {
            }
            if ((i3 & 2048) != 0) {
            }
            i13 = i12;
            if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        function02 = function0;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        modifier2 = modifier;
        if ((i & 3072) == 0) {
        }
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        z3 = z2;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if ((i & 1572864) != 0) {
        }
        i7 = i3 & 128;
        if (i7 == 0) {
        }
        i8 = i3 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3 & 512;
        if (i10 != 0) {
        }
        i11 = i10;
        if ((i3 & 1024) == 0) {
        }
        if ((i3 & 2048) != 0) {
        }
        i13 = i12;
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i13 & 19) == 18) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    public abstract Modifier exposedDropdownSize(Modifier modifier, boolean z);

    public abstract boolean getAlwaysFocusable$material3();

    /* JADX INFO: renamed from: getAnchorType-oYjWRB4$material3, reason: not valid java name */
    public abstract String mo3643getAnchorTypeoYjWRB4$material3();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use overload that takes ExposedDropdownMenuAnchorType and enabled parameters", replaceWith = @ReplaceWith(expression = "menuAnchor(type, enabled)", imports = {}))
    public final Modifier menuAnchor(Modifier modifier) {
        return m3640menuAnchor2Hz36ac$default(this, modifier, ExposedDropdownMenuAnchorType.INSTANCE.m3638getPrimaryNotEditableoYjWRB4(), false, 2, null);
    }

    /* JADX INFO: renamed from: menuAnchor-2Hz36ac, reason: not valid java name */
    public abstract Modifier mo3644menuAnchor2Hz36ac(Modifier modifier, String str, boolean z);
}
