package com.segment.analytics.kotlin.core;

import com.segment.analytics.kotlin.core.AnalyticsError;
import com.segment.analytics.kotlin.core.System;
import com.segment.analytics.kotlin.core.platform.DestinationPlugin;
import com.segment.analytics.kotlin.core.platform.Plugin;
import com.segment.analytics.kotlin.core.platform.plugins.logger.LoggerKt;
import com.segment.analytics.kotlin.core.utilities.JsonUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import org.opencv.imgproc.Imgproc;
import sovran.kotlin.Store;

/* JADX INFO: compiled from: Settings.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000\u001a\u0012\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b\u001a\u001d\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"checkSettings", "", "Lcom/segment/analytics/kotlin/core/Analytics;", "(Lcom/segment/analytics/kotlin/core/Analytics;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchSettings", "Lcom/segment/analytics/kotlin/core/Settings;", "writeKey", "", "cdnHost", "manuallyEnableDestination", "plugin", "Lcom/segment/analytics/kotlin/core/platform/DestinationPlugin;", "update", "settings", "(Lcom/segment/analytics/kotlin/core/Analytics;Lcom/segment/analytics/kotlin/core/Settings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SettingsKt {

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.SettingsKt$checkSettings$1, reason: invalid class name */
    /* JADX INFO: compiled from: Settings.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.SettingsKt", f = "Settings.kt", i = {0, 0, 0, 1, 1, 1}, l = {87, 88, 90}, m = "checkSettings", n = {"$this$checkSettings", "writeKey", "cdnHost", "$this$checkSettings", "writeKey", "cdnHost"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SettingsKt.checkSettings(null, this);
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.SettingsKt$checkSettings$2, reason: invalid class name */
    /* JADX INFO: compiled from: Settings.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.SettingsKt$checkSettings$2", f = "Settings.kt", i = {}, l = {Imgproc.COLOR_YUV2RGBA_NV12}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $cdnHost;
        final /* synthetic */ Analytics $this_checkSettings;
        final /* synthetic */ String $writeKey;
        int label;

        /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.SettingsKt$checkSettings$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Settings.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.segment.analytics.kotlin.core.SettingsKt$checkSettings$2$1", f = "Settings.kt", i = {}, l = {98, 99, 103}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Settings $settingsObj;
            final /* synthetic */ Analytics $this_checkSettings;
            Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Settings settings, Analytics analytics, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$settingsObj = settings;
                this.$this_checkSettings = analytics;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$settingsObj, this.$this_checkSettings, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:21:0x0099, code lost:
            
                if (r9.$this_checkSettings.getStore().dispatch(new com.segment.analytics.kotlin.core.System.ToggleRunningAction(true), kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(com.segment.analytics.kotlin.core.System.class), r9) != r0) goto L23;
             */
            /* JADX WARN: Removed duplicated region for block: B:20:0x007d  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Settings settings;
                Analytics analytics;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    settings = this.$settingsObj;
                    if (settings != null) {
                        analytics = this.$this_checkSettings;
                        LoggerKt.log$default(analytics, "Dispatching update settings on " + Thread.currentThread().getName(), null, 2, null);
                        Store store = analytics.getStore();
                        System.UpdateSettingsAction updateSettingsAction = new System.UpdateSettingsAction(settings);
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(System.class);
                        this.L$0 = analytics;
                        this.L$1 = settings;
                        this.label = 1;
                        if (store.dispatch(updateSettingsAction, orCreateKotlinClass, this) != coroutine_suspended) {
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 2;
                            if (SettingsKt.update(analytics, settings, this) != coroutine_suspended) {
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    settings = (Settings) this.L$1;
                    analytics = (Analytics) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 2;
                    if (SettingsKt.update(analytics, settings, this) != coroutine_suspended) {
                        this.label = 3;
                    }
                    return coroutine_suspended;
                }
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                this.label = 3;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Analytics analytics, String str, String str2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_checkSettings = analytics;
            this.$writeKey = str;
            this.$cdnHost = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$this_checkSettings, this.$writeKey, this.$cdnHost, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LoggerKt.log$default(this.$this_checkSettings, "Fetching settings on " + Thread.currentThread().getName(), null, 2, null);
                Settings settingsFetchSettings = SettingsKt.fetchSettings(this.$this_checkSettings, this.$writeKey, this.$cdnHost);
                this.label = 1;
                if (BuildersKt.withContext(this.$this_checkSettings.getAnalyticsDispatcher(), new AnonymousClass1(settingsFetchSettings, this.$this_checkSettings, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.SettingsKt$manuallyEnableDestination$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Settings.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.SettingsKt$manuallyEnableDestination$1", f = "Settings.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    static final class C10851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DestinationPlugin $plugin;
        final /* synthetic */ Analytics $this_manuallyEnableDestination;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10851(Analytics analytics, DestinationPlugin destinationPlugin, Continuation<? super C10851> continuation) {
            super(2, continuation);
            this.$this_manuallyEnableDestination = analytics;
            this.$plugin = destinationPlugin;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10851(this.$this_manuallyEnableDestination, this.$plugin, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$this_manuallyEnableDestination.getStore().dispatch(new System.AddDestinationToSettingsAction(this.$plugin.getKey()), Reflection.getOrCreateKotlinClass(System.class), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            DestinationPlugin destinationPlugin = (DestinationPlugin) this.$this_manuallyEnableDestination.find(Reflection.getOrCreateKotlinClass(this.$plugin.getClass()));
            if (destinationPlugin != null) {
                destinationPlugin.setEnabled$core(true);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.SettingsKt$update$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Settings.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.SettingsKt", f = "Settings.kt", i = {0, 0}, l = {46, 60}, m = "update", n = {"$this$update", "settings"}, s = {"L$0", "L$1"})
    static final class C10861 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10861(Continuation<? super C10861> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SettingsKt.update(null, null, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d2, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r10, r5, r0) != r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object checkSettings(Analytics analytics, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        String cdnHost;
        String str;
        Analytics analytics2;
        String str2;
        String str3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String writeKey = analytics.getConfiguration().getWriteKey();
            cdnHost = analytics.getConfiguration().getCdnHost();
            Store store = analytics.getStore();
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(System.class);
            anonymousClass1.L$0 = analytics;
            anonymousClass1.L$1 = writeKey;
            anonymousClass1.L$2 = cdnHost;
            anonymousClass1.label = 1;
            Object objCurrentState = store.currentState(orCreateKotlinClass, anonymousClass1);
            if (objCurrentState != coroutine_suspended) {
                str = writeKey;
                obj = objCurrentState;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            String str4 = (String) anonymousClass1.L$2;
            String str5 = (String) anonymousClass1.L$1;
            Analytics analytics3 = (Analytics) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            cdnHost = str4;
            analytics = analytics3;
            str = str5;
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            str2 = (String) anonymousClass1.L$2;
            str3 = (String) anonymousClass1.L$1;
            analytics2 = (Analytics) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher networkIODispatcher = analytics2.getNetworkIODispatcher();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(analytics2, str3, str2, null);
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = null;
            anonymousClass1.label = 3;
        }
        if (((System) obj) == null) {
            return Unit.INSTANCE;
        }
        Store store2 = analytics.getStore();
        System.ToggleRunningAction toggleRunningAction = new System.ToggleRunningAction(false);
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(System.class);
        anonymousClass1.L$0 = analytics;
        anonymousClass1.L$1 = str;
        anonymousClass1.L$2 = cdnHost;
        anonymousClass1.label = 2;
        if (store2.dispatch(toggleRunningAction, orCreateKotlinClass2, anonymousClass1) != coroutine_suspended) {
            analytics2 = analytics;
            str2 = cdnHost;
            str3 = str;
            CoroutineDispatcher networkIODispatcher2 = analytics2.getNetworkIODispatcher();
            AnonymousClass2 anonymousClass22 = new AnonymousClass2(analytics2, str3, str2, null);
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = null;
            anonymousClass1.label = 3;
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Settings fetchSettings(Analytics analytics, final String writeKey, String cdnHost) {
        String text;
        Intrinsics.checkNotNullParameter(analytics, "<this>");
        Intrinsics.checkNotNullParameter(writeKey, "writeKey");
        Intrinsics.checkNotNullParameter(cdnHost, "cdnHost");
        try {
            InputStream inputStream = new HTTPClient(writeKey, analytics.getConfiguration().getRequestFactory()).settings(cdnHost).getInputStream();
            if (inputStream != null) {
                Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    text = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    if (text == null) {
                        text = "";
                    }
                } finally {
                }
            }
            LoggerKt.log$default(analytics, "Fetched Settings: " + text, null, 2, null);
            Json lenientJson = JsonUtils.getLenientJson();
            lenientJson.getSerializersModule();
            return (Settings) lenientJson.decodeFromString(BuiltinSerializersKt.getNullable(Settings.INSTANCE.serializer()), text);
        } catch (Exception e) {
            URL url = new URL("https://" + cdnHost + "/projects/" + writeKey + "/settings");
            Exception exc = e;
            ErrorsKt.reportErrorWithMetrics(analytics, new AnalyticsError.SettingsFail(new AnalyticsError.NetworkUnknown(url, exc)), "Failed to fetch settings", Telemetry.INVOKE_ERROR_METRIC, ExceptionsKt.stackTraceToString(exc), new Function1<Map<String, String>, Unit>() { // from class: com.segment.analytics.kotlin.core.SettingsKt.fetchSettings.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<String, String> map) {
                    invoke2(map);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Map<String, String> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.put("error", e.toString());
                    it.put("writekey", writeKey);
                    it.put("message", "Error retrieving settings");
                }
            });
            return null;
        }
    }

    public static final void manuallyEnableDestination(Analytics analytics, DestinationPlugin plugin) {
        Intrinsics.checkNotNullParameter(analytics, "<this>");
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        BuildersKt__Builders_commonKt.launch$default(analytics.getAnalyticsScope(), analytics.getAnalyticsDispatcher(), null, new C10851(analytics, plugin, null), 2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0094, code lost:
    
        if (r6.dispatch(r7, r8, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object update(Analytics analytics, final Settings settings, Continuation<? super Unit> continuation) {
        C10861 c10861;
        if (continuation instanceof C10861) {
            c10861 = (C10861) continuation;
            if ((c10861.label & Integer.MIN_VALUE) != 0) {
                c10861.label -= Integer.MIN_VALUE;
            } else {
                c10861 = new C10861(continuation);
            }
        }
        Object objCurrentState = c10861.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10861.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCurrentState);
            Store store = analytics.getStore();
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(System.class);
            c10861.L$0 = analytics;
            c10861.L$1 = settings;
            c10861.label = 1;
            objCurrentState = store.currentState(orCreateKotlinClass, c10861);
            if (objCurrentState != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objCurrentState);
            return Unit.INSTANCE;
        }
        settings = (Settings) c10861.L$1;
        analytics = (Analytics) c10861.L$0;
        ResultKt.throwOnFailure(objCurrentState);
        final System system = (System) objCurrentState;
        if (system == null) {
            return Unit.INSTANCE;
        }
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        analytics.getTimeline$core().applyClosure(new Function1<Plugin, Unit>() { // from class: com.segment.analytics.kotlin.core.SettingsKt.update.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Plugin plugin) {
                invoke2(plugin);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Plugin plugin) {
                Plugin.UpdateType updateType;
                Intrinsics.checkNotNullParameter(plugin, "plugin");
                if (system.getInitializedPlugins().contains(Integer.valueOf(plugin.hashCode()))) {
                    updateType = Plugin.UpdateType.Refresh;
                } else {
                    linkedHashSet.add(Integer.valueOf(plugin.hashCode()));
                    updateType = Plugin.UpdateType.Initial;
                }
                plugin.update(settings, updateType);
            }
        });
        Store store2 = analytics.getStore();
        System.AddInitializedPlugins addInitializedPlugins = new System.AddInitializedPlugins(linkedHashSet);
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(System.class);
        c10861.L$0 = null;
        c10861.L$1 = null;
        c10861.label = 2;
    }
}
