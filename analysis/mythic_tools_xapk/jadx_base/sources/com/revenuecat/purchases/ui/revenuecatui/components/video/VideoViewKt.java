package com.revenuecat.purchases.ui.revenuecatui.components.video;

import android.content.Context;
import android.net.Uri;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import com.revenuecat.purchases.ui.revenuecatui.components.video.TextureVideoView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: VideoView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aY\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eH\u0003¢\u0006\u0002\u0010\u000f\u001ac\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eH\u0001¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Video", "", "scaleType", "Lcom/revenuecat/purchases/ui/revenuecatui/components/video/TextureVideoView$ScaleType;", "videoUri", "", "showControls", "", "autoPlay", "loop", "muteAudio", "modifier", "Landroidx/compose/ui/Modifier;", "onReady", "Lkotlin/Function0;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/video/TextureVideoView$ScaleType;Ljava/lang/String;ZZZZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "VideoView", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZZZZLandroidx/compose/ui/layout/ContentScale;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VideoViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Video(final TextureVideoView.ScaleType scaleType, final String str, final boolean z, final boolean z2, final boolean z3, final boolean z4, Modifier modifier, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        boolean z5;
        int i4;
        Modifier modifier2;
        int i5;
        final Function0<Unit> function02;
        final String str2;
        final Map map;
        Object objRememberedValue;
        final MutableState mutableState;
        boolean z6;
        VideoViewKt$Video$1$1 videoViewKt$Video$1$1RememberedValue;
        boolean zChangedInstance;
        Object objRememberedValue2;
        int currentCompositeKeyHash;
        Composer composerM5595constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int i6;
        boolean z7;
        Object objRememberedValue3;
        int i7;
        final String str3;
        final MutableState mutableState2;
        int i8;
        final Map map2;
        String str4;
        boolean zChangedInstance2;
        Object objRememberedValue4;
        boolean z8;
        Object objRememberedValue5;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-298505257);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Video)P(5,7,6!2,3)385@12711L86,390@12887L64,397@13141L111,397@13109L143,405@13350L337,405@13316L371,415@13692L2317:VideoView.kt#26k46s");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(scaleType) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else {
            if ((i & 384) == 0) {
                z5 = z;
                i3 |= composerStartRestartGroup.changed(z5) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
            }
            if ((i2 & 16) != 0) {
                if ((i & 24576) == 0) {
                    i3 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                }
                if ((i2 & 32) != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i3 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
                }
                i4 = i2 & 64;
                if (i4 != 0) {
                    i3 |= 1572864;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changed(modifier2) ? 1048576 : 524288;
                    }
                }
                i5 = i2 & 128;
                if (i5 != 0) {
                    i3 |= 12582912;
                    function02 = function0;
                } else {
                    function02 = function0;
                    if ((i & 12582912) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function02) ? 8388608 : 4194304;
                    }
                }
                if ((i3 & 4793491) == 4793490 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                } else {
                    Modifier modifier4 = i4 == 0 ? Modifier.INSTANCE : modifier2;
                    if (i5 != 0) {
                        function02 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-298505257, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.video.Video (VideoView.kt:382)");
                    }
                    str2 = "video_" + scaleType + '_' + str;
                    map = (Map) RememberSaveableKt.m5765rememberSaveable(new Object[0], (Saver) null, str2, (Function0) new Function0<Map<String, VideoPlaybackState>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoViewKt$Video$savedState$1
                        @Override // kotlin.jvm.functions.Function0
                        public final Map<String, VideoPlaybackState> invoke() {
                            return new LinkedHashMap();
                        }
                    }, composerStartRestartGroup, 3072, 2);
                    composerStartRestartGroup.startReplaceGroup(-2041714535);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VideoView.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    Object value = mutableState.getValue();
                    composerStartRestartGroup.startReplaceGroup(-2041706360);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VideoView.kt#9igjgp");
                    int i9 = i3 & 7168;
                    z6 = i9 != 2048;
                    videoViewKt$Video$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6 || videoViewKt$Video$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        videoViewKt$Video$1$1RememberedValue = new VideoViewKt$Video$1$1(mutableState, z2, null);
                        composerStartRestartGroup.updateRememberedValue(videoViewKt$Video$1$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(value, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) videoViewKt$Video$1$1RememberedValue, composerStartRestartGroup, 0);
                    Object value2 = mutableState.getValue();
                    composerStartRestartGroup.startReplaceGroup(-2041699446);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VideoView.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(map) | composerStartRestartGroup.changed(str2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoViewKt$Video$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                final MutableState<TextureVideoView> mutableState3 = mutableState;
                                final Map<String, VideoPlaybackState> map3 = map;
                                final String str5 = str2;
                                return new DisposableEffectResult() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoViewKt$Video$2$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        TextureVideoView textureVideoView = (TextureVideoView) mutableState3.getValue();
                                        if (textureVideoView != null) {
                                            TextureVideoView.PlaybackState playbackState = textureVideoView.getPlaybackState();
                                            map3.put(str5, new VideoPlaybackState(playbackState.getPositionMs(), playbackState.getPlayWhenReady()));
                                        }
                                    }
                                };
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(value2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                    Modifier modifierClipToBounds = ClipKt.clipToBounds(modifier4);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClipToBounds);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1134871122, "C420@13837L1507,461@15551L441,457@15414L111,419@13802L2201:VideoView.kt#26k46s");
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    composerStartRestartGroup.startReplaceGroup(-794674821);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VideoView.kt#9igjgp");
                    boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(map) | composerStartRestartGroup.changed(str2) | (i9 != 2048) | ((i3 & 112) != 32) | ((i3 & 896) != 256) | ((458752 & i3) != 131072) | ((i3 & 14) != 4) | ((57344 & i3) != 16384);
                    i6 = i3 & 29360128;
                    z7 = zChangedInstance3 | (i6 != 8388608);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z7 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        i7 = 8388608;
                        final boolean z9 = z5;
                        str3 = str2;
                        mutableState2 = mutableState;
                        i8 = i6;
                        map2 = map;
                        str4 = "CC(remember):VideoView.kt#9igjgp";
                        objRememberedValue3 = (Function1) new Function1<Context, TextureVideoView>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoViewKt$Video$3$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final TextureVideoView invoke(Context ctx) {
                                Intrinsics.checkNotNullParameter(ctx, "ctx");
                                VideoPlaybackState videoPlaybackState = map2.get(str3);
                                if (videoPlaybackState == null) {
                                    videoPlaybackState = new VideoPlaybackState(0, z2);
                                }
                                int iMax = Math.max(videoPlaybackState.getPositionMs(), videoPlaybackState.getPositionMs());
                                boolean playWhenReady = iMax > 0 ? videoPlaybackState.getPlayWhenReady() : z2;
                                Uri uri = Uri.parse(str);
                                TextureVideoView textureVideoView = new TextureVideoView(ctx, null, z9, z4, 2, null);
                                MutableState<TextureVideoView> mutableState3 = mutableState2;
                                TextureVideoView.ScaleType scaleType2 = scaleType;
                                boolean z10 = z3;
                                Function0<Unit> function03 = function02;
                                mutableState3.setValue(textureVideoView);
                                textureVideoView.setScaleType(scaleType2);
                                textureVideoView.setLooping(z10);
                                textureVideoView.setAutoStart(playWhenReady);
                                textureVideoView.setOnReadyCallback(function03);
                                textureVideoView.setVideoURI(uri);
                                if (iMax > 0) {
                                    textureVideoView.setPlaybackState(new TextureVideoView.PlaybackState(iMax, playWhenReady));
                                }
                                return textureVideoView;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        i7 = 8388608;
                        str3 = str2;
                        mutableState2 = mutableState;
                        i8 = i6;
                        map2 = map;
                        str4 = "CC(remember):VideoView.kt#9igjgp";
                    }
                    Function1 function1 = (Function1) objRememberedValue3;
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-794621039);
                    ComposerKt.sourceInformation(composerStartRestartGroup, str4);
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(map2) | composerStartRestartGroup.changed(str3);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = (Function1) new Function1<TextureVideoView, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoViewKt$Video$3$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextureVideoView textureVideoView) {
                                invoke2(textureVideoView);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextureVideoView view) {
                                Intrinsics.checkNotNullParameter(view, "view");
                                Map<String, VideoPlaybackState> map3 = map2;
                                String str5 = str3;
                                TextureVideoView.PlaybackState playbackState = view.getPlaybackState();
                                map3.put(str5, new VideoPlaybackState(playbackState.getPositionMs(), playbackState.getPlayWhenReady()));
                                view.release();
                                mutableState2.setValue(null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function12 = (Function1) objRememberedValue4;
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-794625753);
                    ComposerKt.sourceInformation(composerStartRestartGroup, str4);
                    z8 = i8 != i7;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z8 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<TextureVideoView, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoViewKt$Video$3$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextureVideoView textureVideoView) {
                                invoke2(textureVideoView);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextureVideoView view) {
                                Intrinsics.checkNotNullParameter(view, "view");
                                mutableState2.setValue(view);
                                view.setOnReadyCallback(function02);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup = composerStartRestartGroup;
                    AndroidView_androidKt.AndroidView(function1, modifierFillMaxSize$default, null, function12, (Function1) objRememberedValue5, composerStartRestartGroup, 48, 4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                }
                final Function0<Unit> function03 = function02;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoViewKt.Video.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i10) {
                            VideoViewKt.Video(scaleType, str, z, z2, z3, z4, modifier3, function03, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 24576;
            if ((i2 & 32) != 0) {
            }
            i4 = i2 & 64;
            if (i4 != 0) {
            }
            i5 = i2 & 128;
            if (i5 != 0) {
            }
            if ((i3 & 4793491) == 4793490) {
                if (i4 == 0) {
                }
                if (i5 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                str2 = "video_" + scaleType + '_' + str;
                map = (Map) RememberSaveableKt.m5765rememberSaveable(new Object[0], (Saver) null, str2, (Function0) new Function0<Map<String, VideoPlaybackState>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoViewKt$Video$savedState$1
                    @Override // kotlin.jvm.functions.Function0
                    public final Map<String, VideoPlaybackState> invoke() {
                        return new LinkedHashMap();
                    }
                }, composerStartRestartGroup, 3072, 2);
                composerStartRestartGroup.startReplaceGroup(-2041714535);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VideoView.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                mutableState = (MutableState) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                Object value3 = mutableState.getValue();
                composerStartRestartGroup.startReplaceGroup(-2041706360);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VideoView.kt#9igjgp");
                int i92 = i3 & 7168;
                if (i92 != 2048) {
                }
                videoViewKt$Video$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    videoViewKt$Video$1$1RememberedValue = new VideoViewKt$Video$1$1(mutableState, z2, null);
                    composerStartRestartGroup.updateRememberedValue(videoViewKt$Video$1$1RememberedValue);
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(value3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) videoViewKt$Video$1$1RememberedValue, composerStartRestartGroup, 0);
                    Object value22 = mutableState.getValue();
                    composerStartRestartGroup.startReplaceGroup(-2041699446);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VideoView.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(map) | composerStartRestartGroup.changed(str2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoViewKt$Video$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                final MutableState mutableState3 = mutableState;
                                final Map map3 = map;
                                final String str5 = str2;
                                return new DisposableEffectResult() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoViewKt$Video$2$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        TextureVideoView textureVideoView = (TextureVideoView) mutableState3.getValue();
                                        if (textureVideoView != null) {
                                            TextureVideoView.PlaybackState playbackState = textureVideoView.getPlaybackState();
                                            map3.put(str5, new VideoPlaybackState(playbackState.getPositionMs(), playbackState.getPlayWhenReady()));
                                        }
                                    }
                                };
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.DisposableEffect(value22, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                        Modifier modifierClipToBounds2 = ClipKt.clipToBounds(modifier4);
                        Alignment center2 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClipToBounds2);
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1134871122, "C420@13837L1507,461@15551L441,457@15414L111,419@13802L2201:VideoView.kt#26k46s");
                            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            composerStartRestartGroup.startReplaceGroup(-794674821);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):VideoView.kt#9igjgp");
                            boolean zChangedInstance32 = composerStartRestartGroup.changedInstance(map) | composerStartRestartGroup.changed(str2) | (i92 != 2048) | ((i3 & 112) != 32) | ((i3 & 896) != 256) | ((458752 & i3) != 131072) | ((i3 & 14) != 4) | ((57344 & i3) != 16384);
                            i6 = i3 & 29360128;
                            z7 = zChangedInstance32 | (i6 != 8388608);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (z7) {
                                i7 = 8388608;
                                final boolean z92 = z5;
                                str3 = str2;
                                mutableState2 = mutableState;
                                i8 = i6;
                                map2 = map;
                                str4 = "CC(remember):VideoView.kt#9igjgp";
                                objRememberedValue3 = (Function1) new Function1<Context, TextureVideoView>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoViewKt$Video$3$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final TextureVideoView invoke(Context ctx) {
                                        Intrinsics.checkNotNullParameter(ctx, "ctx");
                                        VideoPlaybackState videoPlaybackState = map2.get(str3);
                                        if (videoPlaybackState == null) {
                                            videoPlaybackState = new VideoPlaybackState(0, z2);
                                        }
                                        int iMax = Math.max(videoPlaybackState.getPositionMs(), videoPlaybackState.getPositionMs());
                                        boolean playWhenReady = iMax > 0 ? videoPlaybackState.getPlayWhenReady() : z2;
                                        Uri uri = Uri.parse(str);
                                        TextureVideoView textureVideoView = new TextureVideoView(ctx, null, z92, z4, 2, null);
                                        MutableState<TextureVideoView> mutableState3 = mutableState2;
                                        TextureVideoView.ScaleType scaleType2 = scaleType;
                                        boolean z10 = z3;
                                        Function0<Unit> function032 = function02;
                                        mutableState3.setValue(textureVideoView);
                                        textureVideoView.setScaleType(scaleType2);
                                        textureVideoView.setLooping(z10);
                                        textureVideoView.setAutoStart(playWhenReady);
                                        textureVideoView.setOnReadyCallback(function032);
                                        textureVideoView.setVideoURI(uri);
                                        if (iMax > 0) {
                                            textureVideoView.setPlaybackState(new TextureVideoView.PlaybackState(iMax, playWhenReady));
                                        }
                                        return textureVideoView;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                Function1 function13 = (Function1) objRememberedValue3;
                                composerStartRestartGroup.endReplaceGroup();
                                composerStartRestartGroup.startReplaceGroup(-794621039);
                                ComposerKt.sourceInformation(composerStartRestartGroup, str4);
                                zChangedInstance2 = composerStartRestartGroup.changedInstance(map2) | composerStartRestartGroup.changed(str3);
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (!zChangedInstance2) {
                                    objRememberedValue4 = (Function1) new Function1<TextureVideoView, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoViewKt$Video$3$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(TextureVideoView textureVideoView) {
                                            invoke2(textureVideoView);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(TextureVideoView view) {
                                            Intrinsics.checkNotNullParameter(view, "view");
                                            Map<String, VideoPlaybackState> map3 = map2;
                                            String str5 = str3;
                                            TextureVideoView.PlaybackState playbackState = view.getPlaybackState();
                                            map3.put(str5, new VideoPlaybackState(playbackState.getPositionMs(), playbackState.getPlayWhenReady()));
                                            view.release();
                                            mutableState2.setValue(null);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                    Function1 function122 = (Function1) objRememberedValue4;
                                    composerStartRestartGroup.endReplaceGroup();
                                    composerStartRestartGroup.startReplaceGroup(-794625753);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, str4);
                                    if (i8 != i7) {
                                    }
                                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                    if (!z8) {
                                        objRememberedValue5 = (Function1) new Function1<TextureVideoView, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoViewKt$Video$3$3$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(TextureVideoView textureVideoView) {
                                                invoke2(textureVideoView);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(TextureVideoView view) {
                                                Intrinsics.checkNotNullParameter(view, "view");
                                                mutableState2.setValue(view);
                                                view.setOnReadyCallback(function02);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                        composerStartRestartGroup.endReplaceGroup();
                                        composerStartRestartGroup = composerStartRestartGroup;
                                        AndroidView_androidKt.AndroidView(function13, modifierFillMaxSize$default2, null, function122, (Function1) objRememberedValue5, composerStartRestartGroup, 48, 4);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        composerStartRestartGroup.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        modifier3 = modifier4;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            final Function0<Unit> function032 = function02;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        z5 = z;
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        i4 = i2 & 64;
        if (i4 != 0) {
        }
        i5 = i2 & 128;
        if (i5 != 0) {
        }
        if ((i3 & 4793491) == 4793490) {
        }
        final Function0<Unit> function0322 = function02;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void VideoView(final String videoUri, Modifier modifier, boolean z, boolean z2, boolean z3, boolean z4, ContentScale contentScale, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z5;
        int i5;
        boolean z6;
        int i6;
        boolean z7;
        int i7;
        boolean z8;
        int i8;
        int i9;
        int i10;
        final boolean z9;
        final Modifier modifier3;
        final boolean z10;
        final boolean z11;
        final boolean z12;
        Composer composer2;
        final Function0<Unit> function02;
        final ContentScale contentScale2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(videoUri, "videoUri");
        Composer composerStartRestartGroup = composer.startRestartGroup(-688849339);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VideoView)P(7,3,6!1,2,4)46@1604L390:VideoView.kt#26k46s");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(videoUri) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else {
                if ((i & 384) == 0) {
                    z5 = z;
                    i3 |= composerStartRestartGroup.changed(z5) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else {
                    if ((i & 3072) == 0) {
                        z6 = z2;
                        i3 |= composerStartRestartGroup.changed(z6) ? 2048 : 1024;
                    }
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else {
                        if ((i & 24576) == 0) {
                            z7 = z3;
                            i3 |= composerStartRestartGroup.changed(z7) ? 16384 : 8192;
                        }
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else {
                            if ((196608 & i) == 0) {
                                z8 = z4;
                                i3 |= composerStartRestartGroup.changed(z8) ? 131072 : 65536;
                            }
                            i8 = i2 & 64;
                            if (i8 == 0) {
                                i3 |= 1572864;
                            } else if ((i & 1572864) == 0) {
                                i3 |= composerStartRestartGroup.changed(contentScale) ? 1048576 : 524288;
                            }
                            i9 = i2 & 128;
                            if (i9 != 0) {
                                if ((i & 12582912) == 0) {
                                    i10 = i9;
                                    i3 |= composerStartRestartGroup.changedInstance(function0) ? 8388608 : 4194304;
                                }
                                if ((i3 & 4793491) == 4793490 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    contentScale2 = contentScale;
                                    modifier3 = modifier2;
                                    z9 = z5;
                                    composer2 = composerStartRestartGroup;
                                    z12 = z6;
                                    z11 = z7;
                                    z10 = z8;
                                    function02 = function0;
                                } else {
                                    Modifier.Companion companion = i11 == 0 ? Modifier.INSTANCE : modifier2;
                                    if (i4 != 0) {
                                        z5 = true;
                                    }
                                    boolean z13 = i5 == 0 ? false : z6;
                                    boolean z14 = i6 == 0 ? false : z7;
                                    boolean z15 = i7 == 0 ? false : z8;
                                    ContentScale fit = i8 == 0 ? ContentScale.INSTANCE.getFit() : contentScale;
                                    Function0<Unit> function03 = i10 == 0 ? null : function0;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-688849339, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.video.VideoView (VideoView.kt:45)");
                                    }
                                    int i12 = ((i3 << 3) & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 15) & 3670016) | (i3 & 29360128);
                                    boolean z16 = z5;
                                    Modifier modifier4 = companion;
                                    Video(!Intrinsics.areEqual(fit, ContentScale.INSTANCE.getFit()) ? TextureVideoView.ScaleType.FIT : TextureVideoView.ScaleType.FILL, videoUri, z16, z13, z14, z15, modifier4, function03, composerStartRestartGroup, i12, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    boolean z17 = z13;
                                    z9 = z16;
                                    modifier3 = modifier4;
                                    z10 = z15;
                                    z11 = z14;
                                    z12 = z17;
                                    composer2 = composerStartRestartGroup;
                                    function02 = function03;
                                    contentScale2 = fit;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoViewKt.VideoView.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i13) {
                                            VideoViewKt.VideoView(videoUri, modifier3, z9, z12, z11, z10, contentScale2, function02, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i3 |= 12582912;
                            i10 = i9;
                            if ((i3 & 4793491) == 4793490) {
                                if (i11 == 0) {
                                }
                                if (i4 != 0) {
                                }
                                if (i5 == 0) {
                                }
                                if (i6 == 0) {
                                }
                                if (i7 == 0) {
                                }
                                if (i8 == 0) {
                                }
                                if (i10 == 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i122 = ((i3 << 3) & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 15) & 3670016) | (i3 & 29360128);
                                boolean z162 = z5;
                                Modifier modifier42 = companion;
                                Video(!Intrinsics.areEqual(fit, ContentScale.INSTANCE.getFit()) ? TextureVideoView.ScaleType.FIT : TextureVideoView.ScaleType.FILL, videoUri, z162, z13, z14, z15, modifier42, function03, composerStartRestartGroup, i122, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                boolean z172 = z13;
                                z9 = z162;
                                modifier3 = modifier42;
                                z10 = z15;
                                z11 = z14;
                                z12 = z172;
                                composer2 = composerStartRestartGroup;
                                function02 = function03;
                                contentScale2 = fit;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                            }
                        }
                        z8 = z4;
                        i8 = i2 & 64;
                        if (i8 == 0) {
                        }
                        i9 = i2 & 128;
                        if (i9 != 0) {
                        }
                        i10 = i9;
                        if ((i3 & 4793491) == 4793490) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                        }
                    }
                    z7 = z3;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    z8 = z4;
                    i8 = i2 & 64;
                    if (i8 == 0) {
                    }
                    i9 = i2 & 128;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    if ((i3 & 4793491) == 4793490) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                z6 = z2;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                z7 = z3;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                z8 = z4;
                i8 = i2 & 64;
                if (i8 == 0) {
                }
                i9 = i2 & 128;
                if (i9 != 0) {
                }
                i10 = i9;
                if ((i3 & 4793491) == 4793490) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            z5 = z;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z6 = z2;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            z7 = z3;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            z8 = z4;
            i8 = i2 & 64;
            if (i8 == 0) {
            }
            i9 = i2 & 128;
            if (i9 != 0) {
            }
            i10 = i9;
            if ((i3 & 4793491) == 4793490) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z5 = z;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z6 = z2;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        z7 = z3;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        z8 = z4;
        i8 = i2 & 64;
        if (i8 == 0) {
        }
        i9 = i2 & 128;
        if (i9 != 0) {
        }
        i10 = i9;
        if ((i3 & 4793491) == 4793490) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }
}
