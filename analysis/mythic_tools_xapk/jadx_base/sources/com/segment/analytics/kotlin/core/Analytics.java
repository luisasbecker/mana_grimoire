package com.segment.analytics.kotlin.core;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.segment.analytics.kotlin.core.Storage;
import com.segment.analytics.kotlin.core.UserInfo;
import com.segment.analytics.kotlin.core.platform.DestinationPlugin;
import com.segment.analytics.kotlin.core.platform.EventPlugin;
import com.segment.analytics.kotlin.core.platform.Plugin;
import com.segment.analytics.kotlin.core.platform.Timeline;
import com.segment.analytics.kotlin.core.platform.plugins.ContextPlugin;
import com.segment.analytics.kotlin.core.platform.plugins.StartupQueue;
import com.segment.analytics.kotlin.core.platform.plugins.UserInfoPlugin;
import com.segment.analytics.kotlin.core.platform.plugins.logger.ConsoleLogger;
import com.segment.analytics.kotlin.core.platform.plugins.logger.Logger;
import com.segment.analytics.kotlin.core.platform.plugins.logger.LoggerKt;
import com.segment.analytics.kotlin.core.utilities.AnySerializerKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.modules.SerializersModule;
import org.opencv.videoio.Videoio;
import sovran.kotlin.Store;
import sovran.kotlin.Subscriber;

/* JADX INFO: compiled from: Analytics.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 s2\u00020\u00012\u00020\u0002:\u0001sB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\u000e\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u000204J?\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082/\b\u0002\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?J\u0006\u0010@\u001a\u000208J\b\u0010A\u001a\u000208H\u0007J\u001a\u0010B\u001a\u0002062\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002060:J\r\u0010D\u001a\u000206H\u0000¢\u0006\u0002\bEJ\u0010\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u000208J%\u0010F\u001a\u0004\u0018\u0001HI\"\b\b\u0000\u0010I*\u0002042\f\u00103\u001a\b\u0012\u0004\u0012\u0002HI0J¢\u0006\u0002\u0010KJ$\u0010L\u001a\b\u0012\u0004\u0012\u0002HI0M\"\b\b\u0000\u0010I*\u0002042\f\u00103\u001a\b\u0012\u0004\u0012\u0002HI0JJ\u0006\u0010N\u001a\u000206JZ\u0010O\u001a\u000206\"\u0006\b\u0000\u0010I\u0018\u00012\u0006\u0010P\u001a\u0002082\u0006\u0010Q\u001a\u0002HI2/\b\n\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010RJ`\u0010O\u001a\u000206\"\u0004\b\u0000\u0010I2\u0006\u0010P\u001a\u0002082\u0006\u0010Q\u001a\u0002HI2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002HI0T2/\b\u0002\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?¢\u0006\u0002\u0010UJK\u0010O\u001a\u0002062\u0006\u0010P\u001a\u0002082\b\b\u0002\u0010Q\u001a\u00020V2/\b\u0002\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?H\u0007JR\u0010W\u001a\u000206\"\u0006\b\u0000\u0010I\u0018\u00012\u0006\u0010Q\u001a\u0002HI2/\b\n\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010XJX\u0010W\u001a\u000206\"\u0004\b\u0000\u0010I2\u0006\u0010Q\u001a\u0002HI2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002HI0T2/\b\u0002\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?¢\u0006\u0002\u0010YJZ\u0010W\u001a\u000206\"\u0006\b\u0000\u0010I\u0018\u00012\u0006\u0010Z\u001a\u0002082\u0006\u0010Q\u001a\u0002HI2/\b\n\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010RJ`\u0010W\u001a\u000206\"\u0004\b\u0000\u0010I2\u0006\u0010Z\u001a\u0002082\u0006\u0010Q\u001a\u0002HI2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002HI0T2/\b\u0002\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?¢\u0006\u0002\u0010UJK\u0010W\u001a\u0002062\u0006\u0010Z\u001a\u0002082\b\b\u0002\u0010Q\u001a\u00020V2/\b\u0002\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?H\u0007JC\u0010W\u001a\u0002062\b\b\u0002\u0010Q\u001a\u00020V2/\b\u0002\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?H\u0007J\f\u0010[\u001a\b\u0012\u0004\u0012\u0002080MJ?\u0010\\\u001a\u0002062\u0006\u0010>\u001a\u00020;2/\b\u0002\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?J\u0006\u0010]\u001a\u000206J\u000e\u0010]\u001a\u0002062\u0006\u0010^\u001a\u000208J\u000e\u0010_\u001a\u00020\u00002\u0006\u00103\u001a\u000204J\u0006\u0010`\u001a\u000206Jd\u0010a\u001a\u000206\"\u0006\b\u0000\u0010I\u0018\u00012\u0006\u0010b\u001a\u0002082\u0006\u0010c\u001a\u0002HI2\b\b\u0002\u0010d\u001a\u0002082/\b\n\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010eJj\u0010a\u001a\u000206\"\u0004\b\u0000\u0010I2\u0006\u0010b\u001a\u0002082\u0006\u0010c\u001a\u0002HI2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002HI0T2\b\b\u0002\u0010d\u001a\u0002082/\b\u0002\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?¢\u0006\u0002\u0010fJU\u0010a\u001a\u0002062\u0006\u0010b\u001a\u0002082\b\b\u0002\u0010c\u001a\u00020V2\b\b\u0002\u0010d\u001a\u0002082/\b\u0002\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?H\u0007J\n\u0010g\u001a\u0004\u0018\u00010hH\u0007J\u0013\u0010i\u001a\u0004\u0018\u00010hH\u0086@ø\u0001\u0001¢\u0006\u0002\u0010jJ\u0006\u0010k\u001a\u000206JZ\u0010l\u001a\u000206\"\u0006\b\u0000\u0010I\u0018\u00012\u0006\u0010=\u001a\u0002082\u0006\u0010c\u001a\u0002HI2/\b\n\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010RJ`\u0010l\u001a\u000206\"\u0004\b\u0000\u0010I2\u0006\u0010=\u001a\u0002082\u0006\u0010c\u001a\u0002HI2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002HI0T2/\b\u0002\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?¢\u0006\u0002\u0010UJK\u0010l\u001a\u0002062\u0006\u0010=\u001a\u0002082\b\b\u0002\u0010c\u001a\u00020V2/\b\u0002\u00109\u001a)\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:j\u0004\u0018\u0001`?H\u0007J\b\u0010Q\u001a\u0004\u0018\u00010VJ(\u0010Q\u001a\u0004\u0018\u0001HI\"\u0006\b\u0000\u0010I\u0018\u00012\u000e\b\u0002\u0010m\u001a\b\u0012\u0004\u0012\u0002HI0nH\u0086\b¢\u0006\u0002\u0010oJ\n\u0010p\u001a\u0004\u0018\u00010VH\u0007J(\u0010p\u001a\u0004\u0018\u0001HI\"\u0006\b\u0000\u0010I\u0018\u00012\u000e\b\u0002\u0010m\u001a\b\u0012\u0004\u0012\u0002HI0nH\u0087\b¢\u0006\u0002\u0010oJ\b\u0010Z\u001a\u0004\u0018\u000108J\n\u0010q\u001a\u0004\u0018\u000108H\u0007J\u0006\u0010r\u001a\u000208R\u0012\u0010\b\u001a\u00020\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000bR\u0012\u0010\u001b\u001a\u00020\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000bR\u001b\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u0012\u0010#\u001a\u00020$X\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001b\u0010'\u001a\u00020(8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\"\u001a\u0004\b)\u0010*R\u001a\u0010,\u001a\u00020-X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006t"}, d2 = {"Lcom/segment/analytics/kotlin/core/Analytics;", "Lsovran/kotlin/Subscriber;", "Lcom/segment/analytics/kotlin/core/CoroutineConfiguration;", "configuration", "Lcom/segment/analytics/kotlin/core/Configuration;", "(Lcom/segment/analytics/kotlin/core/Configuration;)V", "coroutineConfig", "(Lcom/segment/analytics/kotlin/core/Configuration;Lcom/segment/analytics/kotlin/core/CoroutineConfiguration;)V", "analyticsDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getAnalyticsDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "analyticsScope", "Lkotlinx/coroutines/CoroutineScope;", "getAnalyticsScope", "()Lkotlinx/coroutines/CoroutineScope;", "getConfiguration", "()Lcom/segment/analytics/kotlin/core/Configuration;", "value", "", "enabled", "getEnabled", "()Z", "setEnabled", "(Z)V", "fileIODispatcher", "getFileIODispatcher", "networkIODispatcher", "getNetworkIODispatcher", "storage", "Lcom/segment/analytics/kotlin/core/Storage;", "getStorage", "()Lcom/segment/analytics/kotlin/core/Storage;", "storage$delegate", "Lkotlin/Lazy;", ProductResponseJsonKeys.STORE, "Lsovran/kotlin/Store;", "getStore", "()Lsovran/kotlin/Store;", "timeline", "Lcom/segment/analytics/kotlin/core/platform/Timeline;", "getTimeline$core", "()Lcom/segment/analytics/kotlin/core/platform/Timeline;", "timeline$delegate", "userInfo", "Lcom/segment/analytics/kotlin/core/UserInfo;", "getUserInfo$core", "()Lcom/segment/analytics/kotlin/core/UserInfo;", "setUserInfo$core", "(Lcom/segment/analytics/kotlin/core/UserInfo;)V", "add", "plugin", "Lcom/segment/analytics/kotlin/core/platform/Plugin;", "alias", "", "newId", "", "enrichment", "Lkotlin/Function1;", "Lcom/segment/analytics/kotlin/core/BaseEvent;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_EVENT, "Lcom/segment/analytics/kotlin/core/platform/EnrichmentClosure;", "anonymousId", "anonymousIdAsync", "applyClosureToPlugins", "closure", "build", "build$core", "find", "Lcom/segment/analytics/kotlin/core/platform/DestinationPlugin;", "destinationKey", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Lcom/segment/analytics/kotlin/core/platform/Plugin;", "findAll", "", "flush", "group", "groupId", "traits", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "serializationStrategy", "Lkotlinx/serialization/SerializationStrategy;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/serialization/json/JsonObject;", "identify", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;Lkotlin/jvm/functions/Function1;)V", "userId", "pendingUploads", "process", "purgeStorage", "filePath", "remove", "reset", AndroidContextPlugin.SCREEN_KEY, com.facebook.appevents.internal.Constants.GP_IAP_TITLE, DiagnosticsEntry.PROPERTIES_KEY, "category", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "settings", "Lcom/segment/analytics/kotlin/core/Settings;", "settingsAsync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shutdown", "track", "deserializationStrategy", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "traitsAsync", "userIdAsync", "version", "Companion", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class Analytics implements Subscriber, CoroutineConfiguration {
    private static boolean debugLogsEnabled;
    private final /* synthetic */ CoroutineConfiguration $$delegate_0;
    private final Configuration configuration;
    private boolean enabled;

    /* JADX INFO: renamed from: storage$delegate, reason: from kotlin metadata */
    private final Lazy storage;

    /* JADX INFO: renamed from: timeline$delegate, reason: from kotlin metadata */
    private final Lazy timeline;
    private UserInfo userInfo;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Logger logger = new ConsoleLogger();

    /* JADX INFO: compiled from: Analytics.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/segment/analytics/kotlin/core/Analytics$Companion;", "", "()V", "debugLogsEnabled", "", "getDebugLogsEnabled", "()Z", "setDebugLogsEnabled", "(Z)V", "logger", "Lcom/segment/analytics/kotlin/core/platform/plugins/logger/Logger;", "getLogger$core", "()Lcom/segment/analytics/kotlin/core/platform/plugins/logger/Logger;", "setLogger$core", "(Lcom/segment/analytics/kotlin/core/platform/plugins/logger/Logger;)V", "setLogger", "", "version", "", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getDebugLogsEnabled() {
            return Analytics.debugLogsEnabled;
        }

        public final Logger getLogger$core() {
            return Analytics.logger;
        }

        public final void setDebugLogsEnabled(boolean z) {
            Analytics.debugLogsEnabled = z;
        }

        public final void setLogger(Logger logger) {
            Intrinsics.checkNotNullParameter(logger, "logger");
            Analytics.INSTANCE.setLogger$core(logger);
        }

        public final void setLogger$core(Logger logger) {
            Intrinsics.checkNotNullParameter(logger, "<set-?>");
            Analytics.logger = logger;
        }

        public final String version() {
            return "1.19.2";
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.Analytics$alias$1, reason: invalid class name */
    /* JADX INFO: compiled from: Analytics.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.Analytics$alias$1", f = "Analytics.kt", i = {0}, l = {493}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<BaseEvent, BaseEvent> $enrichment;
        final /* synthetic */ String $newId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.Analytics$alias$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Analytics.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.segment.analytics.kotlin.core.Analytics$alias$1$1", f = "Analytics.kt", i = {}, l = {500}, m = "invokeSuspend", n = {}, s = {})
        static final class C01971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $newId;
            int label;
            final /* synthetic */ Analytics this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01971(Analytics analytics, String str, Continuation<? super C01971> continuation) {
                super(2, continuation);
                this.this$0 = analytics;
                this.$newId = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01971(this.this$0, this.$newId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01971) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.this$0.getStore().dispatch(new UserInfo.SetUserIdAction(this.$newId), Reflection.getOrCreateKotlinClass(UserInfo.class), this) == coroutine_suspended) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(String str, Function1<? super BaseEvent, ? extends BaseEvent> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$newId = str;
            this.$enrichment = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = Analytics.this.new AnonymousClass1(this.$newId, this.$enrichment, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                this.L$0 = coroutineScope2;
                this.label = 1;
                Object objCurrentState = Analytics.this.getStore().currentState(Reflection.getOrCreateKotlinClass(UserInfo.class), this);
                if (objCurrentState == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
                obj = objCurrentState;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            UserInfo userInfo = (UserInfo) obj;
            if (userInfo != null) {
                String str = this.$newId;
                String userId = userInfo.getUserId();
                if (userId == null) {
                    userId = userInfo.getAnonymousId();
                }
                AliasEvent aliasEvent = new AliasEvent(str, userId);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C01971(Analytics.this, this.$newId, null), 3, null);
                Analytics.this.process(aliasEvent, this.$enrichment);
            } else {
                LoggerKt.log$default(Analytics.this, "failed to fetch current UserInfo state", null, 2, null);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.Analytics$identify$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Analytics.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.Analytics$identify$1", f = "Analytics.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
    static final class C10751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JsonObject $traits;
        final /* synthetic */ String $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10751(String str, JsonObject jsonObject, Continuation<? super C10751> continuation) {
            super(2, continuation);
            this.$userId = str;
            this.$traits = jsonObject;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Analytics.this.new C10751(this.$userId, this.$traits, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (Analytics.this.getStore().dispatch(new UserInfo.SetUserIdAndTraitsAction(this.$userId, this.$traits), Reflection.getOrCreateKotlinClass(UserInfo.class), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.Analytics$identify$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Analytics.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.Analytics$identify$2", f = "Analytics.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
    static final class C10762 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JsonObject $traits;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10762(JsonObject jsonObject, Continuation<? super C10762> continuation) {
            super(2, continuation);
            this.$traits = jsonObject;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Analytics.this.new C10762(this.$traits, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10762) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (Analytics.this.getStore().dispatch(new UserInfo.SetTraitsAction(this.$traits), Reflection.getOrCreateKotlinClass(UserInfo.class), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.Analytics$process$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Analytics.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.Analytics$process$1", f = "Analytics.kt", i = {}, l = {Videoio.CAP_PROP_XI_LENS_FOCAL_LENGTH}, m = "invokeSuspend", n = {}, s = {})
    static final class C10771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BaseEvent $event;
        int label;
        final /* synthetic */ Analytics this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10771(BaseEvent baseEvent, Analytics analytics, Continuation<? super C10771> continuation) {
            super(2, continuation);
            this.$event = baseEvent;
            this.this$0 = analytics;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10771(this.$event, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$event.applyBaseEventData$core(this.this$0.getStore(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            LoggerKt.log$default(this.this$0, "processing event on " + Thread.currentThread().getName(), null, 2, null);
            this.this$0.getTimeline$core().process(this.$event);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.Analytics$purgeStorage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Analytics.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.Analytics$purgeStorage$1", f = "Analytics.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C10781(Continuation<? super C10781> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Analytics.this.new C10781(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Iterator<String> it = Analytics.this.pendingUploads().iterator();
            while (it.hasNext()) {
                try {
                    Analytics.this.getStorage().removeFile(it.next());
                } catch (Exception unused) {
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.Analytics$purgeStorage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Analytics.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.Analytics$purgeStorage$2", f = "Analytics.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10792 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $filePath;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10792(String str, Continuation<? super C10792> continuation) {
            super(2, continuation);
            this.$filePath = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Analytics.this.new C10792(this.$filePath, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10792) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                Analytics.this.getStorage().removeFile(this.$filePath);
            } catch (Exception unused) {
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.Analytics$reset$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Analytics.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.Analytics$reset$1", f = "Analytics.kt", i = {}, l = {Videoio.CAP_PROP_XI_SENSOR_FEATURE_VALUE}, m = "invokeSuspend", n = {}, s = {})
    static final class C10801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $newAnonymousId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10801(String str, Continuation<? super C10801> continuation) {
            super(2, continuation);
            this.$newAnonymousId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Analytics.this.new C10801(this.$newAnonymousId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10801) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (Analytics.this.getStore().dispatch(new UserInfo.ResetAction(this.$newAnonymousId), Reflection.getOrCreateKotlinClass(UserInfo.class), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Analytics.this.getTimeline$core().applyClosure(new Function1<Plugin, Unit>() { // from class: com.segment.analytics.kotlin.core.Analytics.reset.1.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Plugin plugin) {
                    invoke2(plugin);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Plugin it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    EventPlugin eventPlugin = it instanceof EventPlugin ? (EventPlugin) it : null;
                    if (eventPlugin != null) {
                        eventPlugin.reset();
                    }
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.Analytics$settings$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Analytics.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/segment/analytics/kotlin/core/Settings;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.Analytics$settings$1", f = "Analytics.kt", i = {}, l = {674}, m = "invokeSuspend", n = {}, s = {})
    static final class C10811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Settings>, Object> {
        int label;

        C10811(Continuation<? super C10811> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Analytics.this.new C10811(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Settings> continuation) {
            return ((C10811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object obj2 = Analytics.this.settingsAsync(this);
            return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
        }
    }

    /* JADX INFO: renamed from: com.segment.analytics.kotlin.core.Analytics$settingsAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Analytics.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.segment.analytics.kotlin.core.Analytics", f = "Analytics.kt", i = {}, l = {681}, m = "settingsAsync", n = {}, s = {})
    static final class C10821 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C10821(Continuation<? super C10821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Analytics.this.settingsAsync(this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Analytics(Configuration configuration) {
        this(configuration, new CoroutineConfiguration() { // from class: com.segment.analytics.kotlin.core.Analytics.2
            private final ExecutorCoroutineDispatcher analyticsDispatcher;
            private final CoroutineScope analyticsScope;
            private final CoroutineExceptionHandler exceptionHandler;
            private final ExecutorCoroutineDispatcher fileIODispatcher;
            private final ExecutorCoroutineDispatcher networkIODispatcher;
            private final Store store = new Store();

            {
                Analytics$2$special$$inlined$CoroutineExceptionHandler$1 analytics$2$special$$inlined$CoroutineExceptionHandler$1 = new Analytics$2$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
                this.exceptionHandler = analytics$2$special$$inlined$CoroutineExceptionHandler$1;
                this.analyticsScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(analytics$2$special$$inlined$CoroutineExceptionHandler$1));
                ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
                Intrinsics.checkNotNullExpressionValue(executorServiceNewCachedThreadPool, "newCachedThreadPool()");
                this.analyticsDispatcher = ExecutorsKt.from(executorServiceNewCachedThreadPool);
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
                this.networkIODispatcher = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
                ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2);
                Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(2)");
                this.fileIODispatcher = ExecutorsKt.from(executorServiceNewFixedThreadPool);
            }

            @Override // com.segment.analytics.kotlin.core.CoroutineConfiguration
            public ExecutorCoroutineDispatcher getAnalyticsDispatcher() {
                return this.analyticsDispatcher;
            }

            @Override // com.segment.analytics.kotlin.core.CoroutineConfiguration
            public CoroutineScope getAnalyticsScope() {
                return this.analyticsScope;
            }

            public final CoroutineExceptionHandler getExceptionHandler() {
                return this.exceptionHandler;
            }

            @Override // com.segment.analytics.kotlin.core.CoroutineConfiguration
            public ExecutorCoroutineDispatcher getFileIODispatcher() {
                return this.fileIODispatcher;
            }

            @Override // com.segment.analytics.kotlin.core.CoroutineConfiguration
            public ExecutorCoroutineDispatcher getNetworkIODispatcher() {
                return this.networkIODispatcher;
            }

            @Override // com.segment.analytics.kotlin.core.CoroutineConfiguration
            public Store getStore() {
                return this.store;
            }
        });
        Intrinsics.checkNotNullParameter(configuration, "configuration");
    }

    protected Analytics(Configuration configuration, CoroutineConfiguration coroutineConfig) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(coroutineConfig, "coroutineConfig");
        this.configuration = configuration;
        this.$$delegate_0 = coroutineConfig;
        this.timeline = LazyKt.lazy(new Function0<Timeline>() { // from class: com.segment.analytics.kotlin.core.Analytics$timeline$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Timeline invoke() {
                Timeline timeline = new Timeline();
                timeline.setAnalytics(this.this$0);
                return timeline;
            }
        });
        this.storage = LazyKt.lazy(new Function0<Storage>() { // from class: com.segment.analytics.kotlin.core.Analytics$storage$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Storage invoke() {
                StorageProvider storageProvider = this.this$0.getConfiguration().getStorageProvider();
                Analytics analytics = this.this$0;
                Object application = analytics.getConfiguration().getApplication();
                Intrinsics.checkNotNull(application);
                return storageProvider.createStorage(analytics, application);
            }
        });
        this.userInfo = UserInfo.INSTANCE.defaultState(getStorage());
        this.enabled = true;
        if (!configuration.isValid()) {
            throw new IllegalArgumentException("invalid configuration".toString());
        }
        build$core();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void alias$default(Analytics analytics, String str, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: alias");
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        analytics.alias(str, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void group$default(Analytics analytics, String groupId, Object obj, Function1 function1, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: group");
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        SerializersModule serializersModule = AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        analytics.group(groupId, obj, SerializersKt.serializer(serializersModule, (KType) null), function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void group$default(Analytics analytics, String str, Object obj, SerializationStrategy serializationStrategy, Function1 function1, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: group");
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        analytics.group(str, obj, serializationStrategy, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void group$default(Analytics analytics, String str, JsonObject jsonObject, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: group");
        }
        if ((i & 2) != 0) {
            jsonObject = EventsKt.getEmptyJsonObject();
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        analytics.group(str, jsonObject, (Function1<? super BaseEvent, ? extends BaseEvent>) function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void identify$default(Analytics analytics, Object obj, Function1 function1, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: identify");
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        SerializersModule serializersModule = AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        analytics.identify(obj, SerializersKt.serializer(serializersModule, (KType) null), (Function1<? super BaseEvent, ? extends BaseEvent>) function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void identify$default(Analytics analytics, Object obj, SerializationStrategy serializationStrategy, Function1 function1, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: identify");
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        analytics.identify(obj, (SerializationStrategy<? super Object>) serializationStrategy, (Function1<? super BaseEvent, ? extends BaseEvent>) function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void identify$default(Analytics analytics, String userId, Object obj, Function1 function1, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: identify");
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(userId, "userId");
        SerializersModule serializersModule = AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        analytics.identify(userId, obj, SerializersKt.serializer(serializersModule, (KType) null), function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void identify$default(Analytics analytics, String str, Object obj, SerializationStrategy serializationStrategy, Function1 function1, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: identify");
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        analytics.identify(str, obj, serializationStrategy, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void identify$default(Analytics analytics, String str, JsonObject jsonObject, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: identify");
        }
        if ((i & 2) != 0) {
            jsonObject = EventsKt.getEmptyJsonObject();
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        analytics.identify(str, jsonObject, (Function1<? super BaseEvent, ? extends BaseEvent>) function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void identify$default(Analytics analytics, JsonObject jsonObject, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: identify");
        }
        if ((i & 1) != 0) {
            jsonObject = EventsKt.getEmptyJsonObject();
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        analytics.identify(jsonObject, (Function1<? super BaseEvent, ? extends BaseEvent>) function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void process$default(Analytics analytics, BaseEvent baseEvent, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: process");
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        analytics.process(baseEvent, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void screen$default(Analytics analytics, String title, Object obj, String str, Function1 function1, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: screen");
        }
        if ((i & 4) != 0) {
            str = "";
        }
        String category = str;
        Function1 function12 = (i & 8) != 0 ? null : function1;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(category, "category");
        SerializersModule serializersModule = AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        analytics.screen(title, obj, SerializersKt.serializer(serializersModule, (KType) null), category, function12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void screen$default(Analytics analytics, String str, Object obj, SerializationStrategy serializationStrategy, String str2, Function1 function1, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: screen");
        }
        if ((i & 8) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            function1 = null;
        }
        analytics.screen(str, obj, serializationStrategy, str3, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void screen$default(Analytics analytics, String str, JsonObject jsonObject, String str2, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: screen");
        }
        if ((i & 2) != 0) {
            jsonObject = EventsKt.getEmptyJsonObject();
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        analytics.screen(str, jsonObject, str2, (Function1<? super BaseEvent, ? extends BaseEvent>) function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void track$default(Analytics analytics, String name, Object obj, Function1 function1, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: track");
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(name, "name");
        SerializersModule serializersModule = AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        analytics.track(name, obj, SerializersKt.serializer(serializersModule, (KType) null), function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void track$default(Analytics analytics, String str, Object obj, SerializationStrategy serializationStrategy, Function1 function1, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: track");
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        analytics.track(str, obj, serializationStrategy, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void track$default(Analytics analytics, String str, JsonObject jsonObject, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: track");
        }
        if ((i & 2) != 0) {
            jsonObject = EventsKt.getEmptyJsonObject();
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        analytics.track(str, jsonObject, (Function1<? super BaseEvent, ? extends BaseEvent>) function1);
    }

    public static /* synthetic */ Object traits$default(Analytics analytics, DeserializationStrategy deserializationStrategy, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: traits");
        }
        if ((i & 1) != 0) {
            SerializersModule serializersModule = Json.INSTANCE.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
            deserializationStrategy = SerializersKt.serializer(serializersModule, (KType) null);
        }
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializationStrategy");
        JsonObject jsonObjectTraits = analytics.traits();
        if (jsonObjectTraits != null) {
            return Json.INSTANCE.decodeFromJsonElement(deserializationStrategy, jsonObjectTraits);
        }
        return null;
    }

    public static /* synthetic */ Object traitsAsync$default(Analytics analytics, DeserializationStrategy deserializationStrategy, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: traitsAsync");
        }
        if ((i & 1) != 0) {
            SerializersModule serializersModule = Json.INSTANCE.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
            deserializationStrategy = SerializersKt.serializer(serializersModule, (KType) null);
        }
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializationStrategy");
        JsonObject jsonObjectTraits = analytics.traits();
        if (jsonObjectTraits != null) {
            return Json.INSTANCE.decodeFromJsonElement(deserializationStrategy, jsonObjectTraits);
        }
        return null;
    }

    public final Analytics add(Plugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        getTimeline$core().add(plugin);
        return this;
    }

    public final void alias(String newId, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Intrinsics.checkNotNullParameter(newId, "newId");
        BuildersKt__Builders_commonKt.launch$default(getAnalyticsScope(), getAnalyticsDispatcher(), null, new AnonymousClass1(newId, enrichment, null), 2, null);
    }

    public final String anonymousId() {
        return this.userInfo.getAnonymousId();
    }

    @Deprecated(message = "This function no longer serves a purpose and internally calls `anonymousId()`.", replaceWith = @ReplaceWith(expression = "anonymousId()", imports = {}))
    public final String anonymousIdAsync() {
        return anonymousId();
    }

    public final void applyClosureToPlugins(Function1<? super Plugin, Unit> closure) {
        Intrinsics.checkNotNullParameter(closure, "closure");
        getTimeline$core().applyClosure(closure);
    }

    public final void build$core() {
        add(new StartupQueue());
        add(new ContextPlugin());
        add(new UserInfoPlugin());
        Telemetry.INSTANCE.increment(Telemetry.INVOKE_METRIC, new Function1<Map<String, String>, Unit>() { // from class: com.segment.analytics.kotlin.core.Analytics$build$1
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
                it.put("message", "configured");
                it.put("apihost", this.this$0.getConfiguration().getApiHost());
                it.put("cdnhost", this.this$0.getConfiguration().getCdnHost());
                it.put("flush", "at:" + this.this$0.getConfiguration().getFlushAt() + " int:" + this.this$0.getConfiguration().getFlushInterval() + " pol:" + this.this$0.getConfiguration().getFlushPolicies().size());
                it.put("config", "seg:" + this.this$0.getConfiguration().getAutoAddSegmentDestination());
            }
        });
        BuildersKt__Builders_commonKt.launch$default(getAnalyticsScope(), getAnalyticsDispatcher(), null, new Analytics$build$2(this, null), 2, null);
    }

    public final DestinationPlugin find(String destinationKey) {
        Intrinsics.checkNotNullParameter(destinationKey, "destinationKey");
        return getTimeline$core().find(destinationKey);
    }

    public final <T extends Plugin> T find(KClass<T> plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        return (T) getTimeline$core().find(plugin);
    }

    public final <T extends Plugin> List<T> findAll(KClass<T> plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        return getTimeline$core().findAll(plugin);
    }

    public final void flush() {
        getTimeline$core().applyClosure(new Function1<Plugin, Unit>() { // from class: com.segment.analytics.kotlin.core.Analytics.flush.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Plugin plugin) {
                invoke2(plugin);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Plugin it) {
                Intrinsics.checkNotNullParameter(it, "it");
                EventPlugin eventPlugin = it instanceof EventPlugin ? (EventPlugin) it : null;
                if (eventPlugin != null) {
                    eventPlugin.flush();
                }
            }
        });
    }

    @Override // com.segment.analytics.kotlin.core.CoroutineConfiguration
    public CoroutineDispatcher getAnalyticsDispatcher() {
        return this.$$delegate_0.getAnalyticsDispatcher();
    }

    @Override // com.segment.analytics.kotlin.core.CoroutineConfiguration
    public CoroutineScope getAnalyticsScope() {
        return this.$$delegate_0.getAnalyticsScope();
    }

    public final Configuration getConfiguration() {
        return this.configuration;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    @Override // com.segment.analytics.kotlin.core.CoroutineConfiguration
    public CoroutineDispatcher getFileIODispatcher() {
        return this.$$delegate_0.getFileIODispatcher();
    }

    @Override // com.segment.analytics.kotlin.core.CoroutineConfiguration
    public CoroutineDispatcher getNetworkIODispatcher() {
        return this.$$delegate_0.getNetworkIODispatcher();
    }

    public Storage getStorage() {
        return (Storage) this.storage.getValue();
    }

    @Override // com.segment.analytics.kotlin.core.CoroutineConfiguration
    public Store getStore() {
        return this.$$delegate_0.getStore();
    }

    public final Timeline getTimeline$core() {
        return (Timeline) this.timeline.getValue();
    }

    /* JADX INFO: renamed from: getUserInfo$core, reason: from getter */
    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public final void group(String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        group$default(this, groupId, (JsonObject) null, (Function1) null, 6, (Object) null);
    }

    public final /* synthetic */ <T> void group(String groupId, T traits, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        SerializersModule serializersModule = AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        group(groupId, traits, SerializersKt.serializer(serializersModule, (KType) null), enrichment);
    }

    public final <T> void group(String groupId, T traits, SerializationStrategy<? super T> serializationStrategy, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializationStrategy");
        group(groupId, JsonElementKt.getJsonObject(Json.INSTANCE.encodeToJsonElement(serializationStrategy, traits)), enrichment);
    }

    public final void group(String groupId, JsonObject traits) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(traits, "traits");
        group$default(this, groupId, traits, (Function1) null, 4, (Object) null);
    }

    public final void group(String groupId, JsonObject traits, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(traits, "traits");
        process(new GroupEvent(groupId, traits), enrichment);
    }

    public final void identify() {
        identify$default(this, (JsonObject) null, (Function1) null, 3, (Object) null);
    }

    public final /* synthetic */ <T> void identify(T traits, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        SerializersModule serializersModule = AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        identify(traits, SerializersKt.serializer(serializersModule, (KType) null), enrichment);
    }

    public final <T> void identify(T traits, SerializationStrategy<? super T> serializationStrategy, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializationStrategy");
        identify(JsonElementKt.getJsonObject(Json.INSTANCE.encodeToJsonElement(serializationStrategy, traits)), enrichment);
    }

    public final void identify(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        identify$default(this, userId, (JsonObject) null, (Function1) null, 6, (Object) null);
    }

    public final /* synthetic */ <T> void identify(String userId, T traits, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        SerializersModule serializersModule = AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        identify(userId, traits, SerializersKt.serializer(serializersModule, (KType) null), enrichment);
    }

    public final <T> void identify(String userId, T traits, SerializationStrategy<? super T> serializationStrategy, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializationStrategy");
        identify(userId, JsonElementKt.getJsonObject(Json.INSTANCE.encodeToJsonElement(serializationStrategy, traits)), enrichment);
    }

    public final void identify(String userId, JsonObject traits) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(traits, "traits");
        identify$default(this, userId, traits, (Function1) null, 4, (Object) null);
    }

    public final void identify(String userId, JsonObject traits, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(traits, "traits");
        BuildersKt__Builders_commonKt.launch$default(getAnalyticsScope(), getAnalyticsDispatcher(), null, new C10751(userId, traits, null), 2, null);
        process(new IdentifyEvent(userId, traits), enrichment);
    }

    public final void identify(JsonObject traits) {
        Intrinsics.checkNotNullParameter(traits, "traits");
        identify$default(this, traits, (Function1) null, 2, (Object) null);
    }

    public final void identify(JsonObject traits, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Intrinsics.checkNotNullParameter(traits, "traits");
        BuildersKt__Builders_commonKt.launch$default(getAnalyticsScope(), getAnalyticsDispatcher(), null, new C10762(traits, null), 2, null);
        process(new IdentifyEvent("", traits), enrichment);
    }

    public final List<String> pendingUploads() {
        return StorageKt.parseFilePaths(getStorage().read(Storage.Constants.Events));
    }

    public final void process(BaseEvent event, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.enabled) {
            event.applyBaseData$core(enrichment);
            LoggerKt.log$default(this, "applying base attributes on " + Thread.currentThread().getName(), null, 2, null);
            BuildersKt__Builders_commonKt.launch$default(getAnalyticsScope(), getAnalyticsDispatcher(), null, new C10771(event, this, null), 2, null);
        }
    }

    public final void purgeStorage() {
        BuildersKt__Builders_commonKt.launch$default(getAnalyticsScope(), getFileIODispatcher(), null, new C10781(null), 2, null);
    }

    public final void purgeStorage(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        BuildersKt__Builders_commonKt.launch$default(getAnalyticsScope(), getFileIODispatcher(), null, new C10792(filePath, null), 2, null);
    }

    public final Analytics remove(Plugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        getTimeline$core().remove(plugin);
        return this;
    }

    public final void reset() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this.userInfo = new UserInfo(string, null, null);
        BuildersKt__Builders_commonKt.launch$default(getAnalyticsScope(), getAnalyticsDispatcher(), null, new C10801(string, null), 2, null);
    }

    public final void screen(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        screen$default(this, title, (JsonObject) null, (String) null, (Function1) null, 14, (Object) null);
    }

    public final /* synthetic */ <T> void screen(String title, T properties, String category, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(category, "category");
        SerializersModule serializersModule = AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        screen(title, properties, SerializersKt.serializer(serializersModule, (KType) null), category, enrichment);
    }

    public final <T> void screen(String title, T properties, SerializationStrategy<? super T> serializationStrategy, String category, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializationStrategy");
        Intrinsics.checkNotNullParameter(category, "category");
        screen(title, JsonElementKt.getJsonObject(Json.INSTANCE.encodeToJsonElement(serializationStrategy, properties)), category, enrichment);
    }

    public final void screen(String title, JsonObject properties) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(properties, "properties");
        screen$default(this, title, properties, (String) null, (Function1) null, 12, (Object) null);
    }

    public final void screen(String title, JsonObject properties, String category) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(category, "category");
        screen$default(this, title, properties, category, (Function1) null, 8, (Object) null);
    }

    public final void screen(String title, JsonObject properties, String category, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(category, "category");
        process(new ScreenEvent(title, category, properties), enrichment);
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
        BuildersKt__Builders_commonKt.launch$default(getAnalyticsScope(), getAnalyticsDispatcher(), null, new Analytics$enabled$1(this, z, null), 2, null);
    }

    public final void setUserInfo$core(UserInfo userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "<set-?>");
        this.userInfo = userInfo;
    }

    @BlockingApi
    public final Settings settings() {
        return (Settings) BuildersKt__BuildersKt.runBlocking$default(null, new C10811(null), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object settingsAsync(Continuation<? super Settings> continuation) {
        C10821 c10821;
        if (continuation instanceof C10821) {
            c10821 = (C10821) continuation;
            if ((c10821.label & Integer.MIN_VALUE) != 0) {
                c10821.label -= Integer.MIN_VALUE;
            } else {
                c10821 = new C10821(continuation);
            }
        }
        Object objCurrentState = c10821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10821.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCurrentState);
            Store store = getStore();
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(System.class);
            c10821.label = 1;
            objCurrentState = store.currentState(orCreateKotlinClass, c10821);
            if (objCurrentState == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objCurrentState);
        }
        System system = (System) objCurrentState;
        if (system != null) {
            return system.getSettings();
        }
        return null;
    }

    public final void shutdown() {
        CoroutineDispatcher analyticsDispatcher = getAnalyticsDispatcher();
        Intrinsics.checkNotNull(analyticsDispatcher, "null cannot be cast to non-null type kotlinx.coroutines.ExecutorCoroutineDispatcher{ kotlinx.coroutines.ExecutorsKt.CloseableCoroutineDispatcher }");
        ((ExecutorCoroutineDispatcher) analyticsDispatcher).close();
        CoroutineDispatcher networkIODispatcher = getNetworkIODispatcher();
        Intrinsics.checkNotNull(networkIODispatcher, "null cannot be cast to non-null type kotlinx.coroutines.ExecutorCoroutineDispatcher{ kotlinx.coroutines.ExecutorsKt.CloseableCoroutineDispatcher }");
        ((ExecutorCoroutineDispatcher) networkIODispatcher).close();
        CoroutineDispatcher fileIODispatcher = getFileIODispatcher();
        Intrinsics.checkNotNull(fileIODispatcher, "null cannot be cast to non-null type kotlinx.coroutines.ExecutorCoroutineDispatcher{ kotlinx.coroutines.ExecutorsKt.CloseableCoroutineDispatcher }");
        ((ExecutorCoroutineDispatcher) fileIODispatcher).close();
        getStore().shutdown();
    }

    public final void track(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        track$default(this, name, (JsonObject) null, (Function1) null, 6, (Object) null);
    }

    public final /* synthetic */ <T> void track(String name, T properties, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Intrinsics.checkNotNullParameter(name, "name");
        SerializersModule serializersModule = AnySerializerKt.getJsonAnySerializer().getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        track(name, properties, SerializersKt.serializer(serializersModule, (KType) null), enrichment);
    }

    public final <T> void track(String name, T properties, SerializationStrategy<? super T> serializationStrategy, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializationStrategy");
        track(name, JsonElementKt.getJsonObject(Json.INSTANCE.encodeToJsonElement(serializationStrategy, properties)), enrichment);
    }

    public final void track(String name, JsonObject properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        track$default(this, name, properties, (Function1) null, 4, (Object) null);
    }

    public final void track(String name, JsonObject properties, Function1<? super BaseEvent, ? extends BaseEvent> enrichment) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        process(new TrackEvent(properties, name), enrichment);
    }

    public final /* synthetic */ <T> T traits(DeserializationStrategy<? extends T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializationStrategy");
        JsonObject jsonObjectTraits = traits();
        if (jsonObjectTraits != null) {
            return (T) Json.INSTANCE.decodeFromJsonElement(deserializationStrategy, jsonObjectTraits);
        }
        return null;
    }

    public final JsonObject traits() {
        return this.userInfo.getTraits();
    }

    @Deprecated(message = "This function no longer serves a purpose and internally calls `traits(deserializationStrategy: DeserializationStrategy<T>)`.", replaceWith = @ReplaceWith(expression = "traits(deserializationStrategy: DeserializationStrategy<T>)", imports = {}))
    public final /* synthetic */ <T> T traitsAsync(DeserializationStrategy<? extends T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializationStrategy");
        JsonObject jsonObjectTraits = traits();
        if (jsonObjectTraits != null) {
            return (T) Json.INSTANCE.decodeFromJsonElement(deserializationStrategy, jsonObjectTraits);
        }
        return null;
    }

    @Deprecated(message = "This function no longer serves a purpose and internally calls `traits()`.", replaceWith = @ReplaceWith(expression = "traits()", imports = {}))
    public final JsonObject traitsAsync() {
        return traits();
    }

    public final String userId() {
        return this.userInfo.getUserId();
    }

    @Deprecated(message = "This function no longer serves a purpose and internally calls `userId()`.", replaceWith = @ReplaceWith(expression = "userId()", imports = {}))
    public final String userIdAsync() {
        return userId();
    }

    public final String version() {
        return INSTANCE.version();
    }
}
