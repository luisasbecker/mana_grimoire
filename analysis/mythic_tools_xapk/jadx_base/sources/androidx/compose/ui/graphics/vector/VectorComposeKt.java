package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.constraintlayout.motion.widget.Key;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VectorCompose.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a£\u0001\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005H\u0007¢\u0006\u0004\b&\u0010'¨\u0006("}, d2 = {"Group", "", "name", "", Key.ROTATION, "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Path", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class VectorComposeKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Group(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List<? extends PathNode> list, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        String str2;
        int i3;
        float f8;
        int i4;
        float f9;
        int i5;
        float f10;
        int i6;
        float f11;
        int i7;
        int i8;
        int i9;
        int i10;
        final float f12;
        float f13;
        final List<? extends PathNode> emptyPath;
        final float f14;
        final float f15;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float f16;
        float f17;
        float f18;
        VectorComposeKt$Group$1$1 vectorComposeKt$Group$1$1RememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1851426205);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Group)P(2,5,3,4,6,7,8,9)59@2563L20,58@2501L586:VectorCompose.kt#huu6hf");
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 = i | 6;
            str2 = str;
        } else if ((i & 6) == 0) {
            str2 = str;
            i3 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i;
        } else {
            str2 = str;
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                f8 = f;
                i3 |= composerStartRestartGroup.changed(f8) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    f9 = f2;
                    i3 |= composerStartRestartGroup.changed(f9) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        f10 = f3;
                        i3 |= composerStartRestartGroup.changed(f10) ? 2048 : 1024;
                    }
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            f11 = f4;
                            i3 |= composerStartRestartGroup.changed(f11) ? 16384 : 8192;
                        }
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i3 |= composerStartRestartGroup.changed(f5) ? 131072 : 65536;
                        }
                        i8 = i2 & 64;
                        if (i8 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changed(f6) ? 1048576 : 524288;
                        }
                        i9 = i2 & 128;
                        if (i9 == 0) {
                            if ((i & 12582912) == 0) {
                                i10 = i9;
                                i3 |= composerStartRestartGroup.changed(f7) ? 8388608 : 4194304;
                            }
                            if ((i & 100663296) == 0) {
                                i3 |= ((i2 & 256) == 0 && composerStartRestartGroup.changedInstance(list)) ? 67108864 : 33554432;
                            }
                            if ((i & 805306368) == 0) {
                                i3 |= composerStartRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                            }
                            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                f12 = f6;
                                f13 = f7;
                                emptyPath = list;
                                f14 = f8;
                                f15 = f5;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i11 != 0) {
                                        str2 = "";
                                    }
                                    if (i12 != 0) {
                                        f8 = 0.0f;
                                    }
                                    if (i4 != 0) {
                                        f9 = 0.0f;
                                    }
                                    if (i5 != 0) {
                                        f10 = 0.0f;
                                    }
                                    if (i6 != 0) {
                                        f11 = 1.0f;
                                    }
                                    f16 = i7 == 0 ? f5 : 1.0f;
                                    f12 = i8 != 0 ? 0.0f : f6;
                                    f17 = i10 == 0 ? f7 : 0.0f;
                                    if ((i2 & 256) != 0) {
                                        emptyPath = VectorKt.getEmptyPath();
                                        i3 &= -234881025;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        f18 = f17;
                                    } else {
                                        f18 = f17;
                                        ComposerKt.traceEventStart(-1851426205, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1104106697, "CC(remember):VectorCompose.kt#9igjgp");
                                    vectorComposeKt$Group$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (vectorComposeKt$Group$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        vectorComposeKt$Group$1$1RememberedValue = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1$1
                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final GroupComponent invoke() {
                                                return new GroupComponent();
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(vectorComposeKt$Group$1$1RememberedValue);
                                    }
                                    Function0 function0 = (Function0) vectorComposeKt$Group$1$1RememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1291542257, "CC(ComposeNode)N(factory,update,content)361@14118L9:Composables.kt#9igjgp");
                                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composerStartRestartGroup.startNode();
                                    if (composerStartRestartGroup.getInserting()) {
                                        composerStartRestartGroup.useNode();
                                    } else {
                                        composerStartRestartGroup.createNode(function0);
                                    }
                                    Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                                    Updater.m5603setimpl(composerM5595constructorimpl, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str3) {
                                            invoke2(groupComponent, str3);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(GroupComponent groupComponent, String str3) {
                                            groupComponent.setName(str3);
                                        }
                                    });
                                    Updater.m5603setimpl(composerM5595constructorimpl, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f19) {
                                            invoke(groupComponent, f19.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent groupComponent, float f19) {
                                            groupComponent.setRotation(f19);
                                        }
                                    });
                                    Updater.m5603setimpl(composerM5595constructorimpl, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f19) {
                                            invoke(groupComponent, f19.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent groupComponent, float f19) {
                                            groupComponent.setPivotX(f19);
                                        }
                                    });
                                    Updater.m5603setimpl(composerM5595constructorimpl, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f19) {
                                            invoke(groupComponent, f19.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent groupComponent, float f19) {
                                            groupComponent.setPivotY(f19);
                                        }
                                    });
                                    Updater.m5603setimpl(composerM5595constructorimpl, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f19) {
                                            invoke(groupComponent, f19.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent groupComponent, float f19) {
                                            groupComponent.setScaleX(f19);
                                        }
                                    });
                                    Updater.m5603setimpl(composerM5595constructorimpl, Float.valueOf(f16), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f19) {
                                            invoke(groupComponent, f19.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent groupComponent, float f19) {
                                            groupComponent.setScaleY(f19);
                                        }
                                    });
                                    Updater.m5603setimpl(composerM5595constructorimpl, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f19) {
                                            invoke(groupComponent, f19.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent groupComponent, float f19) {
                                            groupComponent.setTranslationX(f19);
                                        }
                                    });
                                    Updater.m5603setimpl(composerM5595constructorimpl, Float.valueOf(f18), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f19) {
                                            invoke(groupComponent, f19.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GroupComponent groupComponent, float f19) {
                                            groupComponent.setTranslationY(f19);
                                        }
                                    });
                                    Updater.m5603setimpl(composerM5595constructorimpl, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list2) {
                                            invoke2(groupComponent, list2);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(GroupComponent groupComponent, List<? extends PathNode> list2) {
                                            groupComponent.setClipPathData(list2);
                                        }
                                    });
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1167503970, "C72@3072L9:VectorCompose.kt#huu6hf");
                                    function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    composerStartRestartGroup.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    f13 = f18;
                                    f14 = f8;
                                    f15 = f16;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 256) != 0) {
                                        i3 &= -234881025;
                                    }
                                    f16 = f5;
                                    f12 = f6;
                                    f17 = f7;
                                }
                                emptyPath = list;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1104106697, "CC(remember):VectorCompose.kt#9igjgp");
                                vectorComposeKt$Group$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (vectorComposeKt$Group$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                }
                                Function0 function02 = (Function0) vectorComposeKt$Group$1$1RememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1291542257, "CC(ComposeNode)N(factory,update,content)361@14118L9:Composables.kt#9igjgp");
                                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                }
                                composerStartRestartGroup.startNode();
                                if (composerStartRestartGroup.getInserting()) {
                                }
                                Composer composerM5595constructorimpl2 = Updater.m5595constructorimpl(composerStartRestartGroup);
                                Updater.m5603setimpl(composerM5595constructorimpl2, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str3) {
                                        invoke2(groupComponent, str3);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(GroupComponent groupComponent, String str3) {
                                        groupComponent.setName(str3);
                                    }
                                });
                                Updater.m5603setimpl(composerM5595constructorimpl2, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f19) {
                                        invoke(groupComponent, f19.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GroupComponent groupComponent, float f19) {
                                        groupComponent.setRotation(f19);
                                    }
                                });
                                Updater.m5603setimpl(composerM5595constructorimpl2, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f19) {
                                        invoke(groupComponent, f19.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GroupComponent groupComponent, float f19) {
                                        groupComponent.setPivotX(f19);
                                    }
                                });
                                Updater.m5603setimpl(composerM5595constructorimpl2, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f19) {
                                        invoke(groupComponent, f19.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GroupComponent groupComponent, float f19) {
                                        groupComponent.setPivotY(f19);
                                    }
                                });
                                Updater.m5603setimpl(composerM5595constructorimpl2, Float.valueOf(f11), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f19) {
                                        invoke(groupComponent, f19.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GroupComponent groupComponent, float f19) {
                                        groupComponent.setScaleX(f19);
                                    }
                                });
                                Updater.m5603setimpl(composerM5595constructorimpl2, Float.valueOf(f16), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f19) {
                                        invoke(groupComponent, f19.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GroupComponent groupComponent, float f19) {
                                        groupComponent.setScaleY(f19);
                                    }
                                });
                                Updater.m5603setimpl(composerM5595constructorimpl2, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f19) {
                                        invoke(groupComponent, f19.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GroupComponent groupComponent, float f19) {
                                        groupComponent.setTranslationX(f19);
                                    }
                                });
                                Updater.m5603setimpl(composerM5595constructorimpl2, Float.valueOf(f18), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f19) {
                                        invoke(groupComponent, f19.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GroupComponent groupComponent, float f19) {
                                        groupComponent.setTranslationY(f19);
                                    }
                                });
                                Updater.m5603setimpl(composerM5595constructorimpl2, emptyPath, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list2) {
                                        invoke2(groupComponent, list2);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(GroupComponent groupComponent, List<? extends PathNode> list2) {
                                        groupComponent.setClipPathData(list2);
                                    }
                                });
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1167503970, "C72@3072L9:VectorCompose.kt#huu6hf");
                                function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                f13 = f18;
                                f14 = f8;
                                f15 = f16;
                            }
                            final float f19 = f10;
                            final float f20 = f11;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                final String str3 = str2;
                                final float f21 = f9;
                                final float f22 = f13;
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt.Group.4
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

                                    public final void invoke(Composer composer2, int i13) {
                                        VectorComposeKt.Group(str3, f14, f21, f19, f20, f15, f12, f22, emptyPath, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 12582912;
                        i10 = i9;
                        if ((i & 100663296) == 0) {
                        }
                        if ((i & 805306368) == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        }
                        final float f192 = f10;
                        final float f202 = f11;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    f11 = f4;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                    }
                    i9 = i2 & 128;
                    if (i9 == 0) {
                    }
                    i10 = i9;
                    if ((i & 100663296) == 0) {
                    }
                    if ((i & 805306368) == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                    }
                    final float f1922 = f10;
                    final float f2022 = f11;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                f10 = f3;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                f11 = f4;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                }
                i9 = i2 & 128;
                if (i9 == 0) {
                }
                i10 = i9;
                if ((i & 100663296) == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                final float f19222 = f10;
                final float f20222 = f11;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            f9 = f2;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            f10 = f3;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            f11 = f4;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            i8 = i2 & 64;
            if (i8 != 0) {
            }
            i9 = i2 & 128;
            if (i9 == 0) {
            }
            i10 = i9;
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            final float f192222 = f10;
            final float f202222 = f11;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        f8 = f;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        f9 = f2;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        f10 = f3;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        f11 = f4;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        i8 = i2 & 64;
        if (i8 != 0) {
        }
        i9 = i2 & 128;
        if (i9 == 0) {
        }
        i10 = i9;
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        final float f1922222 = f10;
        final float f2022222 = f11;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0123  */
    /* JADX INFO: renamed from: Path-9cdaXJ4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m7069Path9cdaXJ4(final List<? extends PathNode> list, int i, String str, Brush brush, float f, Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        Brush brush3;
        int i11;
        float f8;
        int i12;
        Brush brush4;
        int i13;
        float f9;
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
        final String str2;
        final float f10;
        final float f11;
        final float f12;
        Composer composer2;
        final Brush brush5;
        final float f13;
        final Brush brush6;
        final int i27;
        final float f14;
        final int i28;
        final int i29;
        final float f15;
        final float f16;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i30;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1478270750);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Path)P(3,4:c#ui.graphics.PathFillType,2!4,10,7:c#ui.graphics.StrokeCap,8:c#ui.graphics.StrokeJoin!1,13)116@5136L19,115@5075L877:VectorCompose.kt#huu6hf");
        if ((i4 & 6) == 0) {
            i7 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i31 = i6 & 2;
        if (i31 != 0) {
            i7 |= 48;
        } else {
            if ((i4 & 48) == 0) {
                i8 = i;
                i7 |= composerStartRestartGroup.changed(i8) ? 32 : 16;
            }
            i9 = i6 & 4;
            if (i9 == 0) {
                i7 |= 384;
            } else {
                if ((i4 & 384) == 0) {
                    i7 |= composerStartRestartGroup.changed(str) ? 256 : 128;
                }
                i10 = i6 & 8;
                if (i10 != 0) {
                    i7 |= 3072;
                } else {
                    if ((i4 & 3072) == 0) {
                        brush3 = brush;
                        i7 |= composerStartRestartGroup.changed(brush3) ? 2048 : 1024;
                    }
                    i11 = i6 & 16;
                    if (i11 == 0) {
                        i7 |= 24576;
                    } else {
                        if ((i4 & 24576) == 0) {
                            f8 = f;
                            i7 |= composerStartRestartGroup.changed(f8) ? 16384 : 8192;
                        }
                        i12 = i6 & 32;
                        if (i12 != 0) {
                            i7 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            brush4 = brush2;
                        } else {
                            brush4 = brush2;
                            if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i7 |= composerStartRestartGroup.changed(brush4) ? 131072 : 65536;
                            }
                        }
                        i13 = i6 & 64;
                        if (i13 != 0) {
                            i7 |= 1572864;
                            f9 = f2;
                        } else {
                            f9 = f2;
                            if ((i4 & 1572864) == 0) {
                                i7 |= composerStartRestartGroup.changed(f9) ? 1048576 : 524288;
                            }
                        }
                        i14 = i6 & 128;
                        if (i14 != 0) {
                            i7 |= 12582912;
                        } else if ((i4 & 12582912) == 0) {
                            i7 |= composerStartRestartGroup.changed(f3) ? 8388608 : 4194304;
                        }
                        i15 = i6 & 256;
                        if (i15 != 0) {
                            i7 |= 100663296;
                        } else {
                            if ((i4 & 100663296) == 0) {
                                i16 = i15;
                                i7 |= composerStartRestartGroup.changed(i2) ? 67108864 : 33554432;
                            }
                            i17 = i6 & 512;
                            if (i17 == 0) {
                                i7 |= 805306368;
                            } else {
                                if ((i4 & 805306368) == 0) {
                                    i18 = i17;
                                    i7 |= composerStartRestartGroup.changed(i3) ? 536870912 : 268435456;
                                }
                                i19 = i6 & 1024;
                                if (i19 != 0) {
                                    i21 = i5 | 6;
                                    i20 = i19;
                                } else if ((i5 & 6) == 0) {
                                    i20 = i19;
                                    i21 = i5 | (composerStartRestartGroup.changed(f4) ? 4 : 2);
                                } else {
                                    i20 = i19;
                                    i21 = i5;
                                }
                                i22 = i6 & 2048;
                                if (i22 != 0) {
                                    i21 |= 48;
                                    i23 = i22;
                                } else if ((i5 & 48) == 0) {
                                    i23 = i22;
                                    i21 |= composerStartRestartGroup.changed(f5) ? 32 : 16;
                                } else {
                                    i23 = i22;
                                }
                                int i32 = i21;
                                i24 = i6 & 4096;
                                if (i24 != 0) {
                                    i25 = i32 | 384;
                                } else {
                                    int i33 = i32;
                                    if ((i5 & 384) == 0) {
                                        i33 |= composerStartRestartGroup.changed(f6) ? 256 : 128;
                                    }
                                    i25 = i33;
                                }
                                i26 = i6 & 8192;
                                if (i26 == 0) {
                                    if ((i5 & 3072) == 0) {
                                        i25 |= composerStartRestartGroup.changed(f7) ? 2048 : 1024;
                                    }
                                    if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 1171) != 1170, i7 & 1)) {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        str2 = str;
                                        f10 = f3;
                                        f11 = f5;
                                        f12 = f7;
                                        composer2 = composerStartRestartGroup;
                                        brush5 = brush3;
                                        f13 = f8;
                                        brush6 = brush4;
                                        i27 = i8;
                                        f14 = f9;
                                        i28 = i2;
                                        i29 = i3;
                                        f15 = f4;
                                        f16 = f6;
                                    } else {
                                        int defaultFillType = i31 != 0 ? VectorKt.getDefaultFillType() : i8;
                                        String str3 = i9 != 0 ? "" : str;
                                        if (i10 != 0) {
                                            brush3 = null;
                                        }
                                        if (i11 != 0) {
                                            f8 = 1.0f;
                                        }
                                        if (i12 != 0) {
                                            brush4 = null;
                                        }
                                        if (i13 != 0) {
                                            f9 = 1.0f;
                                        }
                                        float f17 = i14 != 0 ? 0.0f : f3;
                                        int defaultStrokeLineCap = i16 != 0 ? VectorKt.getDefaultStrokeLineCap() : i2;
                                        int defaultStrokeLineJoin = i18 != 0 ? VectorKt.getDefaultStrokeLineJoin() : i3;
                                        float f18 = i20 != 0 ? 4.0f : f4;
                                        float f19 = i23 != 0 ? 0.0f : f5;
                                        float f20 = i24 == 0 ? f6 : 1.0f;
                                        float f21 = i26 == 0 ? f7 : 0.0f;
                                        if (ComposerKt.isTraceInProgress()) {
                                            i30 = defaultFillType;
                                            ComposerKt.traceEventStart(-1478270750, i7, i25, "androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:114)");
                                        } else {
                                            i30 = defaultFillType;
                                        }
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1016005589, "CC(remember):VectorCompose.kt#9igjgp");
                                        VectorComposeKt$Path$1$1 vectorComposeKt$Path$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (vectorComposeKt$Path$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                            vectorComposeKt$Path$1$1RememberedValue = new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$1$1
                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final PathComponent invoke() {
                                                    return new PathComponent();
                                                }
                                            };
                                            composerStartRestartGroup.updateRememberedValue(vectorComposeKt$Path$1$1RememberedValue);
                                        }
                                        Function0 function0 = (Function0) vectorComposeKt$Path$1$1RememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1886828752, "CC(ComposeNode)N(factory,update):Composables.kt#9igjgp");
                                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composerStartRestartGroup.startNode();
                                        if (composerStartRestartGroup.getInserting()) {
                                            composerStartRestartGroup.createNode(function0);
                                        } else {
                                            composerStartRestartGroup.useNode();
                                        }
                                        Composer composerM5595constructorimpl = Updater.m5595constructorimpl(composerStartRestartGroup);
                                        Updater.m5603setimpl(composerM5595constructorimpl, str3, new Function2<PathComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$1
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, String str4) {
                                                invoke2(pathComponent, str4);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(PathComponent pathComponent, String str4) {
                                                pathComponent.setName(str4);
                                            }
                                        });
                                        Updater.m5603setimpl(composerM5595constructorimpl, list, new Function2<PathComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$2
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, List<? extends PathNode> list2) {
                                                invoke2(pathComponent, list2);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(PathComponent pathComponent, List<? extends PathNode> list2) {
                                                pathComponent.setPathData(list2);
                                            }
                                        });
                                        Updater.m5603setimpl(composerM5595constructorimpl, PathFillType.m6614boximpl(i30), new Function2<PathComponent, PathFillType, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$3
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, PathFillType pathFillType) {
                                                m7071invokepweu1eQ(pathComponent, pathFillType.getValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke-pweu1eQ, reason: not valid java name */
                                            public final void m7071invokepweu1eQ(PathComponent pathComponent, int i34) {
                                                pathComponent.m7063setPathFillTypeoQ8Xj4U(i34);
                                            }
                                        });
                                        Updater.m5603setimpl(composerM5595constructorimpl, brush3, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$4
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush7) {
                                                invoke2(pathComponent, brush7);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(PathComponent pathComponent, Brush brush7) {
                                                pathComponent.setFill(brush7);
                                            }
                                        });
                                        Updater.m5603setimpl(composerM5595constructorimpl, Float.valueOf(f8), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$5
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f22) {
                                                invoke(pathComponent, f22.floatValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(PathComponent pathComponent, float f22) {
                                                pathComponent.setFillAlpha(f22);
                                            }
                                        });
                                        Updater.m5603setimpl(composerM5595constructorimpl, brush4, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$6
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush7) {
                                                invoke2(pathComponent, brush7);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(PathComponent pathComponent, Brush brush7) {
                                                pathComponent.setStroke(brush7);
                                            }
                                        });
                                        Updater.m5603setimpl(composerM5595constructorimpl, Float.valueOf(f9), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$7
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f22) {
                                                invoke(pathComponent, f22.floatValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(PathComponent pathComponent, float f22) {
                                                pathComponent.setStrokeAlpha(f22);
                                            }
                                        });
                                        Updater.m5603setimpl(composerM5595constructorimpl, Float.valueOf(f17), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$8
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f22) {
                                                invoke(pathComponent, f22.floatValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(PathComponent pathComponent, float f22) {
                                                pathComponent.setStrokeLineWidth(f22);
                                            }
                                        });
                                        Updater.m5603setimpl(composerM5595constructorimpl, StrokeJoin.m6702boximpl(defaultStrokeLineJoin), new Function2<PathComponent, StrokeJoin, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$9
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, StrokeJoin strokeJoin) {
                                                m7072invokekLtJ_vA(pathComponent, strokeJoin.getValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke-kLtJ_vA, reason: not valid java name */
                                            public final void m7072invokekLtJ_vA(PathComponent pathComponent, int i34) {
                                                pathComponent.m7065setStrokeLineJoinWw9F2mQ(i34);
                                            }
                                        });
                                        Updater.m5603setimpl(composerM5595constructorimpl, StrokeCap.m6692boximpl(defaultStrokeLineCap), new Function2<PathComponent, StrokeCap, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$10
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, StrokeCap strokeCap) {
                                                m7070invokeCSYIeUk(pathComponent, strokeCap.getValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke-CSYIeUk, reason: not valid java name */
                                            public final void m7070invokeCSYIeUk(PathComponent pathComponent, int i34) {
                                                pathComponent.m7064setStrokeLineCapBeK7IIE(i34);
                                            }
                                        });
                                        Updater.m5603setimpl(composerM5595constructorimpl, Float.valueOf(f18), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$11
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f22) {
                                                invoke(pathComponent, f22.floatValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(PathComponent pathComponent, float f22) {
                                                pathComponent.setStrokeLineMiter(f22);
                                            }
                                        });
                                        Updater.m5603setimpl(composerM5595constructorimpl, Float.valueOf(f19), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$12
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f22) {
                                                invoke(pathComponent, f22.floatValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(PathComponent pathComponent, float f22) {
                                                pathComponent.setTrimPathStart(f22);
                                            }
                                        });
                                        Updater.m5603setimpl(composerM5595constructorimpl, Float.valueOf(f20), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$13
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f22) {
                                                invoke(pathComponent, f22.floatValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(PathComponent pathComponent, float f22) {
                                                pathComponent.setTrimPathEnd(f22);
                                            }
                                        });
                                        Updater.m5603setimpl(composerM5595constructorimpl, Float.valueOf(f21), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$14
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f22) {
                                                invoke(pathComponent, f22.floatValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(PathComponent pathComponent, float f22) {
                                                pathComponent.setTrimPathOffset(f22);
                                            }
                                        });
                                        composerStartRestartGroup.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        str2 = str3;
                                        composer2 = composerStartRestartGroup;
                                        brush5 = brush3;
                                        f13 = f8;
                                        brush6 = brush4;
                                        f14 = f9;
                                        i28 = defaultStrokeLineCap;
                                        i29 = defaultStrokeLineJoin;
                                        i27 = i30;
                                        f16 = f20;
                                        f12 = f21;
                                        f10 = f17;
                                        f15 = f18;
                                        f11 = f19;
                                    }
                                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                    if (scopeUpdateScopeEndRestartGroup == null) {
                                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i34) {
                                                VectorComposeKt.m7069Path9cdaXJ4(list, i27, str2, brush5, f13, brush6, f14, f10, i28, i29, f15, f11, f16, f12, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i25 |= 3072;
                                if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 1171) != 1170, i7 & 1)) {
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup == null) {
                                }
                            }
                            i18 = i17;
                            i19 = i6 & 1024;
                            if (i19 != 0) {
                            }
                            i22 = i6 & 2048;
                            if (i22 != 0) {
                            }
                            int i322 = i21;
                            i24 = i6 & 4096;
                            if (i24 != 0) {
                            }
                            i26 = i6 & 8192;
                            if (i26 == 0) {
                            }
                            if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 1171) != 1170, i7 & 1)) {
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                            }
                        }
                        i16 = i15;
                        i17 = i6 & 512;
                        if (i17 == 0) {
                        }
                        i18 = i17;
                        i19 = i6 & 1024;
                        if (i19 != 0) {
                        }
                        i22 = i6 & 2048;
                        if (i22 != 0) {
                        }
                        int i3222 = i21;
                        i24 = i6 & 4096;
                        if (i24 != 0) {
                        }
                        i26 = i6 & 8192;
                        if (i26 == 0) {
                        }
                        if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 1171) != 1170, i7 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    f8 = f;
                    i12 = i6 & 32;
                    if (i12 != 0) {
                    }
                    i13 = i6 & 64;
                    if (i13 != 0) {
                    }
                    i14 = i6 & 128;
                    if (i14 != 0) {
                    }
                    i15 = i6 & 256;
                    if (i15 != 0) {
                    }
                    i16 = i15;
                    i17 = i6 & 512;
                    if (i17 == 0) {
                    }
                    i18 = i17;
                    i19 = i6 & 1024;
                    if (i19 != 0) {
                    }
                    i22 = i6 & 2048;
                    if (i22 != 0) {
                    }
                    int i32222 = i21;
                    i24 = i6 & 4096;
                    if (i24 != 0) {
                    }
                    i26 = i6 & 8192;
                    if (i26 == 0) {
                    }
                    if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 1171) != 1170, i7 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                brush3 = brush;
                i11 = i6 & 16;
                if (i11 == 0) {
                }
                f8 = f;
                i12 = i6 & 32;
                if (i12 != 0) {
                }
                i13 = i6 & 64;
                if (i13 != 0) {
                }
                i14 = i6 & 128;
                if (i14 != 0) {
                }
                i15 = i6 & 256;
                if (i15 != 0) {
                }
                i16 = i15;
                i17 = i6 & 512;
                if (i17 == 0) {
                }
                i18 = i17;
                i19 = i6 & 1024;
                if (i19 != 0) {
                }
                i22 = i6 & 2048;
                if (i22 != 0) {
                }
                int i322222 = i21;
                i24 = i6 & 4096;
                if (i24 != 0) {
                }
                i26 = i6 & 8192;
                if (i26 == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 1171) != 1170, i7 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i10 = i6 & 8;
            if (i10 != 0) {
            }
            brush3 = brush;
            i11 = i6 & 16;
            if (i11 == 0) {
            }
            f8 = f;
            i12 = i6 & 32;
            if (i12 != 0) {
            }
            i13 = i6 & 64;
            if (i13 != 0) {
            }
            i14 = i6 & 128;
            if (i14 != 0) {
            }
            i15 = i6 & 256;
            if (i15 != 0) {
            }
            i16 = i15;
            i17 = i6 & 512;
            if (i17 == 0) {
            }
            i18 = i17;
            i19 = i6 & 1024;
            if (i19 != 0) {
            }
            i22 = i6 & 2048;
            if (i22 != 0) {
            }
            int i3222222 = i21;
            i24 = i6 & 4096;
            if (i24 != 0) {
            }
            i26 = i6 & 8192;
            if (i26 == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 1171) != 1170, i7 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        i8 = i;
        i9 = i6 & 4;
        if (i9 == 0) {
        }
        i10 = i6 & 8;
        if (i10 != 0) {
        }
        brush3 = brush;
        i11 = i6 & 16;
        if (i11 == 0) {
        }
        f8 = f;
        i12 = i6 & 32;
        if (i12 != 0) {
        }
        i13 = i6 & 64;
        if (i13 != 0) {
        }
        i14 = i6 & 128;
        if (i14 != 0) {
        }
        i15 = i6 & 256;
        if (i15 != 0) {
        }
        i16 = i15;
        i17 = i6 & 512;
        if (i17 == 0) {
        }
        i18 = i17;
        i19 = i6 & 1024;
        if (i19 != 0) {
        }
        i22 = i6 & 2048;
        if (i22 != 0) {
        }
        int i32222222 = i21;
        i24 = i6 & 4096;
        if (i24 != 0) {
        }
        i26 = i6 & 8192;
        if (i26 == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i25 & 1171) != 1170, i7 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
