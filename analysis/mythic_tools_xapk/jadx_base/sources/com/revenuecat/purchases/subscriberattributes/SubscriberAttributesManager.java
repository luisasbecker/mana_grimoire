package com.revenuecat.purchases.subscriberattributes;

import android.app.Application;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SubscriberAttributesManager.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001;B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u00020\u00122\n\u0010\u0018\u001a\u00060\u0014j\u0002`\u00192\n\u0010\u001a\u001a\u00060\u0014j\u0002`\u0019JA\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162/\u0010\u001c\u001a+\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00120\u001dH\u0002J2\u0010\"\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\"\u0010\u001c\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020#0\u001ej\u0002`$\u0012\u0004\u0012\u00020\u00120\u001dJ0\u0010%\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020#0\u001e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(J \u0010*\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0010\u0010+\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001eJ*\u0010,\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001e2\u0006\u0010\u0015\u001a\u00020\u0016J \u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0014J$\u00101\u001a\u00020\u00122\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u001e2\u0006\u0010\u0013\u001a\u00020\u0014J(\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u0002052\b\u00100\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J$\u00106\u001a\u00020\u00122\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020#0\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J$\u00108\u001a\u00020\u00122\n\u00109\u001a\u00060\u0014j\u0002`\u00192\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010:R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager;", "", "deviceCache", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "backend", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesPoster;", "deviceIdentifiersFetcher", "Lcom/revenuecat/purchases/common/subscriberattributes/DeviceIdentifiersFetcher;", "automaticDeviceIdentifierCollectionEnabled", "", "(Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesPoster;Lcom/revenuecat/purchases/common/subscriberattributes/DeviceIdentifiersFetcher;Z)V", "getBackend", "()Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesPoster;", "getDeviceCache", "()Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "obtainingDeviceIdentifiersObservable", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager$ObtainDeviceIdentifiersObservable;", "collectDeviceIdentifiers", "", "appUserID", "", "applicationContext", "Landroid/app/Application;", "copyUnsyncedSubscriberAttributes", "originalAppUserId", "Lcom/revenuecat/purchases/subscriberattributes/caching/AppUserID;", "newAppUserID", "getDeviceIdentifiers", "completion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "deviceIdentifiers", "getUnsyncedSubscriberAttributes", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "markAsSynced", "attributesToMarkAsSynced", "attributeErrors", "", "Lcom/revenuecat/purchases/common/SubscriberAttributeError;", "setAppsFlyerConversionData", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "setAppstackAttributionParams", "setAttribute", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "value", "setAttributes", "attributesToSet", "setAttributionID", "attributionKey", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey$AttributionIds;", "storeAttributesIfNeeded", "attributesAsObjects", "synchronizeSubscriberAttributesForAllUsers", "currentAppUserID", "Lkotlin/Function0;", "ObtainDeviceIdentifiersObservable", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriberAttributesManager {
    private final boolean automaticDeviceIdentifierCollectionEnabled;
    private final SubscriberAttributesPoster backend;
    private final SubscriberAttributesCache deviceCache;
    private final DeviceIdentifiersFetcher deviceIdentifiersFetcher;
    private final ObtainDeviceIdentifiersObservable obtainingDeviceIdentifiersObservable;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SubscriberAttributesManager.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R,\u0010\u0003\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u00078BX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesManager$ObtainDeviceIdentifiersObservable;", "Ljava/util/Observable;", "()V", "listeners", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "", "Lkotlin/collections/ArrayList;", "value", "", "numberOfProcesses", "getNumberOfProcesses", "()I", "setNumberOfProcesses", "(I)V", "waitUntilIdle", "completion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class ObtainDeviceIdentifiersObservable extends Observable {
        private final ArrayList<Function0<Unit>> listeners = new ArrayList<>();
        private int numberOfProcesses;

        public ObtainDeviceIdentifiersObservable() {
            addObserver(new Observer() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$ObtainDeviceIdentifiersObservable$$ExternalSyntheticLambda0
                @Override // java.util.Observer
                public final void update(Observable observable, Object obj) {
                    SubscriberAttributesManager.ObtainDeviceIdentifiersObservable._init_$lambda$2(this.f$0, observable, obj);
                }
            });
        }

        static final void _init_$lambda$2(ObtainDeviceIdentifiersObservable obtainDeviceIdentifiersObservable, Observable observable, Object obj) {
            Intrinsics.checkNotNull(observable, "null cannot be cast to non-null type com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager.ObtainDeviceIdentifiersObservable");
            if (((ObtainDeviceIdentifiersObservable) observable).numberOfProcesses == 0) {
                synchronized (obtainDeviceIdentifiersObservable) {
                    Iterator<T> it = obtainDeviceIdentifiersObservable.listeners.iterator();
                    while (it.hasNext()) {
                        ((Function0) it.next()).invoke();
                    }
                    obtainDeviceIdentifiersObservable.listeners.clear();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public final synchronized int getNumberOfProcesses() {
            return this.numberOfProcesses;
        }

        public final synchronized void setNumberOfProcesses(int i) {
            if (this.numberOfProcesses == i) {
                return;
            }
            this.numberOfProcesses = i;
            setChanged();
            notifyObservers();
        }

        public final synchronized void waitUntilIdle(final Function0<Unit> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            if (this.numberOfProcesses == 0) {
                completion.invoke();
            } else {
                this.listeners.add(new Function0<Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$ObtainDeviceIdentifiersObservable$waitUntilIdle$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        completion.invoke();
                    }
                });
            }
        }
    }

    public SubscriberAttributesManager(SubscriberAttributesCache deviceCache, SubscriberAttributesPoster backend, DeviceIdentifiersFetcher deviceIdentifiersFetcher, boolean z) {
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(deviceIdentifiersFetcher, "deviceIdentifiersFetcher");
        this.deviceCache = deviceCache;
        this.backend = backend;
        this.deviceIdentifiersFetcher = deviceIdentifiersFetcher;
        this.automaticDeviceIdentifierCollectionEnabled = z;
        this.obtainingDeviceIdentifiersObservable = new ObtainDeviceIdentifiersObservable();
    }

    private final void getDeviceIdentifiers(Application applicationContext, final Function1<? super Map<String, String>, Unit> completion) {
        ObtainDeviceIdentifiersObservable obtainDeviceIdentifiersObservable = this.obtainingDeviceIdentifiersObservable;
        obtainDeviceIdentifiersObservable.setNumberOfProcesses(obtainDeviceIdentifiersObservable.getNumberOfProcesses() + 1);
        this.deviceIdentifiersFetcher.getDeviceIdentifiers(applicationContext, new Function1<Map<String, ? extends String>, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager.getDeviceIdentifiers.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
                invoke2((Map<String, String>) map);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, String> deviceIdentifiers) {
                Intrinsics.checkNotNullParameter(deviceIdentifiers, "deviceIdentifiers");
                completion.invoke(deviceIdentifiers);
                this.obtainingDeviceIdentifiersObservable.setNumberOfProcesses(r1.getNumberOfProcesses() - 1);
            }
        });
    }

    private final void storeAttributesIfNeeded(Map<String, SubscriberAttribute> attributesAsObjects, String appUserID) {
        Map<String, SubscriberAttribute> allStoredSubscriberAttributes = this.deviceCache.getAllStoredSubscriberAttributes(appUserID);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, SubscriberAttribute> entry : attributesAsObjects.entrySet()) {
            String key = entry.getKey();
            SubscriberAttribute value = entry.getValue();
            if (allStoredSubscriberAttributes.containsKey(key)) {
                SubscriberAttribute subscriberAttribute = allStoredSubscriberAttributes.get(key);
                if (!Intrinsics.areEqual(subscriberAttribute != null ? subscriberAttribute.getValue() : null, value.getValue())) {
                }
            }
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        if (linkedHashMap.isEmpty()) {
            return;
        }
        this.deviceCache.setAttributes(appUserID, linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void synchronizeSubscriberAttributesForAllUsers$default(SubscriberAttributesManager subscriberAttributesManager, String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        subscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers(str, function0);
    }

    public final void collectDeviceIdentifiers(final String appUserID, Application applicationContext) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        getDeviceIdentifiers(applicationContext, new Function1<Map<String, ? extends String>, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager.collectDeviceIdentifiers.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
                invoke2((Map<String, String>) map);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, String> deviceIdentifiers) {
                Intrinsics.checkNotNullParameter(deviceIdentifiers, "deviceIdentifiers");
                SubscriberAttributesManager.this.setAttributes(deviceIdentifiers, appUserID);
            }
        });
    }

    public final synchronized void copyUnsyncedSubscriberAttributes(String originalAppUserId, String newAppUserID) {
        Intrinsics.checkNotNullParameter(originalAppUserId, "originalAppUserId");
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        Map<String, SubscriberAttribute> unsyncedSubscriberAttributes = this.deviceCache.getUnsyncedSubscriberAttributes(originalAppUserId);
        if (unsyncedSubscriberAttributes.isEmpty()) {
            return;
        }
        LogLevel logLevel = LogLevel.INFO;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            String str = "[Purchases] - " + logLevel.name();
            String str2 = String.format(AttributionStrings.COPYING_ATTRIBUTES_FROM_TO_USER, Arrays.copyOf(new Object[]{originalAppUserId, newAppUserID}, 2));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            currentLogHandler.i(str, str2);
        }
        this.deviceCache.setAttributes(newAppUserID, unsyncedSubscriberAttributes);
        this.deviceCache.clearAllSubscriberAttributesFromUser(originalAppUserId);
    }

    public final SubscriberAttributesPoster getBackend() {
        return this.backend;
    }

    public final SubscriberAttributesCache getDeviceCache() {
        return this.deviceCache;
    }

    public final synchronized void getUnsyncedSubscriberAttributes(final String appUserID, final Function1<? super Map<String, SubscriberAttribute>, Unit> completion) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(completion, "completion");
        this.obtainingDeviceIdentifiersObservable.waitUntilIdle(new Function0<Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager.getUnsyncedSubscriberAttributes.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                completion.invoke(this.getDeviceCache().getUnsyncedSubscriberAttributes(appUserID));
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final synchronized void markAsSynced(final String appUserID, final Map<String, SubscriberAttribute> attributesToMarkAsSynced, final List<SubscriberAttributeError> attributeErrors) {
        String str;
        SubscriberAttribute subscriberAttribute;
        LogHandler currentLogHandler;
        String str2;
        String strInvoke;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(attributesToMarkAsSynced, "attributesToMarkAsSynced");
        Intrinsics.checkNotNullParameter(attributeErrors, "attributeErrors");
        if (!attributeErrors.isEmpty()) {
            final LogIntent logIntent = LogIntent.RC_ERROR;
            str = "[Purchases] - ";
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$markAsSynced$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                    String str3 = String.format(AttributionStrings.SUBSCRIBER_ATTRIBUTES_ERROR, Arrays.copyOf(new Object[]{attributeErrors}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    return sbAppend.append(str3).toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str2 = "[Purchases] - " + logLevel.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.d(str2, strInvoke);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str2 = "[Purchases] - " + logLevel4.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.d(str2, strInvoke);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str2 = "[Purchases] - " + logLevel6.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.d(str2, strInvoke);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str2 = "[Purchases] - " + logLevel7.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.d(str2, strInvoke);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function0.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function0.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function0.invoke(), null);
                    break;
            }
        } else {
            str = "[Purchases] - ";
        }
        if (attributesToMarkAsSynced.isEmpty()) {
            return;
        }
        final LogIntent logIntent2 = LogIntent.INFO;
        Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$markAsSynced$$inlined$log$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                StringBuilder sb = new StringBuilder();
                String str3 = String.format(AttributionStrings.MARKING_ATTRIBUTES_SYNCED, Arrays.copyOf(new Object[]{appUserID}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                return sbAppend.append(sb.append(str3).append(CollectionsKt.joinToString$default(attributesToMarkAsSynced.values(), "\n", null, null, 0, null, null, 62, null)).toString()).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
            case 1:
                subscriberAttribute = null;
                LogLevel logLevel11 = LogLevel.DEBUG;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                    currentLogHandler8.d("[Purchases] - " + logLevel11.name(), function02.invoke());
                }
                break;
            case 2:
                subscriberAttribute = null;
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                break;
            case 3:
                LogLevel logLevel12 = LogLevel.WARN;
                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                    currentLogHandler9.w("[Purchases] - " + logLevel12.name(), function02.invoke());
                }
                subscriberAttribute = null;
                break;
            case 4:
                LogLevel logLevel13 = LogLevel.INFO;
                LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                    currentLogHandler10.i("[Purchases] - " + logLevel13.name(), function02.invoke());
                }
                subscriberAttribute = null;
                break;
            case 5:
                LogLevel logLevel14 = LogLevel.DEBUG;
                LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                    currentLogHandler11.d("[Purchases] - " + logLevel14.name(), function02.invoke());
                }
                subscriberAttribute = null;
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                subscriberAttribute = null;
                break;
            case 7:
                LogLevel logLevel15 = LogLevel.INFO;
                LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                    currentLogHandler12.i("[Purchases] - " + logLevel15.name(), function02.invoke());
                }
                subscriberAttribute = null;
                break;
            case 8:
                LogLevel logLevel16 = LogLevel.DEBUG;
                LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                    currentLogHandler13.d("[Purchases] - " + logLevel16.name(), function02.invoke());
                }
                subscriberAttribute = null;
                break;
            case 9:
                LogLevel logLevel17 = LogLevel.DEBUG;
                LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                    currentLogHandler14.d("[Purchases] - " + logLevel17.name(), function02.invoke());
                }
                subscriberAttribute = null;
                break;
            case 10:
                LogLevel logLevel18 = LogLevel.WARN;
                LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                    currentLogHandler15.w("[Purchases] - " + logLevel18.name(), function02.invoke());
                }
                subscriberAttribute = null;
                break;
            case 11:
                LogLevel logLevel19 = LogLevel.WARN;
                LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                    currentLogHandler16.w("[Purchases] - " + logLevel19.name(), function02.invoke());
                }
                subscriberAttribute = null;
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                subscriberAttribute = null;
                break;
            case 13:
                LogLevel logLevel20 = LogLevel.WARN;
                LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                    currentLogHandler17.w(str + logLevel20.name(), function02.invoke());
                }
                subscriberAttribute = null;
                break;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function02.invoke(), null);
                subscriberAttribute = null;
                break;
            default:
                subscriberAttribute = null;
                break;
        }
        Map<String, SubscriberAttribute> allStoredSubscriberAttributes = this.deviceCache.getAllStoredSubscriberAttributes(appUserID);
        Map<String, SubscriberAttribute> mutableMap = MapsKt.toMutableMap(allStoredSubscriberAttributes);
        for (Map.Entry<String, SubscriberAttribute> entry : attributesToMarkAsSynced.entrySet()) {
            String key = entry.getKey();
            SubscriberAttribute value = entry.getValue();
            SubscriberAttribute subscriberAttribute2 = allStoredSubscriberAttributes.get(key);
            if (subscriberAttribute2 != null) {
                if (subscriberAttribute2.isSynced()) {
                    subscriberAttribute2 = subscriberAttribute;
                }
                if (subscriberAttribute2 != null) {
                    if (!Intrinsics.areEqual(subscriberAttribute2.getValue(), value.getValue())) {
                        subscriberAttribute2 = subscriberAttribute;
                    }
                    if (subscriberAttribute2 != null) {
                        mutableMap.put(key, SubscriberAttribute.copy$default(value, null, null, null, null, true, 15, null));
                    }
                }
            }
        }
        this.deviceCache.setAttributes(appUserID, mutableMap);
    }

    public final void setAppsFlyerConversionData(String appUserID, Map<?, ?> data) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        if (data == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String stringValueForPrimitive = MapExtensionsKt.getStringValueForPrimitive(data, "media_source");
        if (stringValueForPrimitive != null) {
            linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.MediaSource.INSTANCE.getBackendKey(), stringValueForPrimitive);
        } else {
            String stringValueForPrimitive2 = MapExtensionsKt.getStringValueForPrimitive(data, "af_status");
            if (stringValueForPrimitive2 != null && StringsKt.equals(stringValueForPrimitive2, "Organic", true)) {
                linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.MediaSource.INSTANCE.getBackendKey(), "Organic");
            }
        }
        String stringValueForPrimitive3 = MapExtensionsKt.getStringValueForPrimitive(data, "campaign");
        if (stringValueForPrimitive3 != null) {
            linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.Campaign.INSTANCE.getBackendKey(), stringValueForPrimitive3);
        }
        String stringValueForPrimitive4 = MapExtensionsKt.getStringValueForPrimitive(data, "adgroup");
        if (stringValueForPrimitive4 == null) {
            stringValueForPrimitive4 = MapExtensionsKt.getStringValueForPrimitive(data, "adset");
        }
        if (stringValueForPrimitive4 != null) {
            linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.AdGroup.INSTANCE.getBackendKey(), stringValueForPrimitive4);
        }
        String stringValueForPrimitive5 = MapExtensionsKt.getStringValueForPrimitive(data, "af_ad");
        if (stringValueForPrimitive5 == null) {
            stringValueForPrimitive5 = MapExtensionsKt.getStringValueForPrimitive(data, "ad_id");
        }
        if (stringValueForPrimitive5 != null) {
            linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.Ad.INSTANCE.getBackendKey(), stringValueForPrimitive5);
        }
        String stringValueForPrimitive6 = MapExtensionsKt.getStringValueForPrimitive(data, "af_keywords");
        if (stringValueForPrimitive6 == null) {
            stringValueForPrimitive6 = MapExtensionsKt.getStringValueForPrimitive(data, "keyword");
        }
        if (stringValueForPrimitive6 != null) {
            linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.Keyword.INSTANCE.getBackendKey(), stringValueForPrimitive6);
        }
        String stringValueForPrimitive7 = MapExtensionsKt.getStringValueForPrimitive(data, "creative");
        if (stringValueForPrimitive7 == null) {
            stringValueForPrimitive7 = MapExtensionsKt.getStringValueForPrimitive(data, "af_creative");
        }
        if (stringValueForPrimitive7 != null) {
            linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.Creative.INSTANCE.getBackendKey(), stringValueForPrimitive7);
        }
        if (linkedHashMap.isEmpty()) {
            return;
        }
        setAttributes(linkedHashMap, appUserID);
    }

    public final void setAppstackAttributionParams(String appUserID, Map<String, String> data, Application applicationContext) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = data.get("appstack_adnetwork");
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                str = null;
            }
            if (str != null) {
                linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.MediaSource.INSTANCE.getBackendKey(), str);
                linkedHashMap.put("appstack_adnetwork", str);
            }
        }
        String str2 = data.get("appstack_campaign");
        if (str2 != null) {
            if (StringsKt.isBlank(str2)) {
                str2 = null;
            }
            if (str2 != null) {
                linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.Campaign.INSTANCE.getBackendKey(), str2);
                linkedHashMap.put("appstack_campaign", str2);
            }
        }
        String str3 = data.get("appstack_adset");
        if (str3 != null) {
            if (StringsKt.isBlank(str3)) {
                str3 = null;
            }
            if (str3 != null) {
                linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.AdGroup.INSTANCE.getBackendKey(), str3);
                linkedHashMap.put("appstack_adset", str3);
            }
        }
        String str4 = data.get("appstack_ad");
        if (str4 != null) {
            if (StringsKt.isBlank(str4)) {
                str4 = null;
            }
            if (str4 != null) {
                linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.Ad.INSTANCE.getBackendKey(), str4);
                linkedHashMap.put("appstack_ad", str4);
            }
        }
        String str5 = data.get("appstack_keywords");
        if (str5 != null) {
            if (StringsKt.isBlank(str5)) {
                str5 = null;
            }
            if (str5 != null) {
                linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.Keyword.INSTANCE.getBackendKey(), str5);
                linkedHashMap.put("appstack_keywords", str5);
            }
        }
        for (String str6 : CollectionsKt.listOf((Object[]) new String[]{"fbclid", "gclid", "wbraid", "gbraid", "ttclid"})) {
            String str7 = data.get(str6);
            if (str7 != null) {
                if (StringsKt.isBlank(str7)) {
                    str7 = null;
                }
                if (str7 != null) {
                    linkedHashMap.put(str6, str7);
                }
            }
        }
        if (!linkedHashMap.isEmpty()) {
            setAttributes(linkedHashMap, appUserID);
        }
        String str8 = data.get("appstack_id");
        if (str8 != null) {
            String str9 = StringsKt.isBlank(str8) ? null : str8;
            if (str9 != null) {
                setAttributionID(SubscriberAttributeKey.AttributionIds.Appstack.INSTANCE, str9, appUserID, applicationContext);
            }
        }
    }

    public final synchronized void setAttribute(SubscriberAttributeKey key, String value, String appUserID) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        setAttributes(MapsKt.mapOf(TuplesKt.to(key.getBackendKey(), value)), appUserID);
    }

    public final synchronized void setAttributes(Map<String, String> attributesToSet, String appUserID) {
        Intrinsics.checkNotNullParameter(attributesToSet, "attributesToSet");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        ArrayList arrayList = new ArrayList(attributesToSet.size());
        for (Map.Entry<String, String> entry : attributesToSet.entrySet()) {
            String key = entry.getKey();
            arrayList.add(TuplesKt.to(key, new SubscriberAttribute(key, entry.getValue(), (DateProvider) null, (Date) null, false, 28, (DefaultConstructorMarker) null)));
        }
        storeAttributesIfNeeded(MapsKt.toMap(arrayList), appUserID);
    }

    public final void setAttributionID(final SubscriberAttributeKey.AttributionIds attributionKey, final String value, final String appUserID, Application applicationContext) {
        Intrinsics.checkNotNullParameter(attributionKey, "attributionKey");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        final Function1<Map<String, ? extends String>, Unit> function1 = new Function1<Map<String, ? extends String>, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$setAttributionID$setAttributes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
                invoke2((Map<String, String>) map);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, String> deviceIdentifiers) {
                Intrinsics.checkNotNullParameter(deviceIdentifiers, "deviceIdentifiers");
                this.setAttributes(MapsKt.plus(MapsKt.mapOf(TuplesKt.to(attributionKey.getBackendKey(), value)), deviceIdentifiers), appUserID);
            }
        };
        if (this.automaticDeviceIdentifierCollectionEnabled) {
            getDeviceIdentifiers(applicationContext, new Function1<Map<String, ? extends String>, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager.setAttributionID.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
                    invoke2((Map<String, String>) map);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Map<String, String> deviceIdentifiers) {
                    Intrinsics.checkNotNullParameter(deviceIdentifiers, "deviceIdentifiers");
                    function1.invoke(deviceIdentifiers);
                }
            });
        } else {
            function1.invoke(MapsKt.emptyMap());
        }
    }

    public final void synchronizeSubscriberAttributesForAllUsers(final String currentAppUserID, final Function0<Unit> completion) {
        Intrinsics.checkNotNullParameter(currentAppUserID, "currentAppUserID");
        this.obtainingDeviceIdentifiersObservable.waitUntilIdle(new Function0<Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LogHandler currentLogHandler;
                String str;
                String strInvoke;
                Map<String, Map<String, SubscriberAttribute>> unsyncedSubscriberAttributes = SubscriberAttributesManager.this.getDeviceCache().getUnsyncedSubscriberAttributes();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, Map<String, SubscriberAttribute>> entry : unsyncedSubscriberAttributes.entrySet()) {
                    if (!StringsKt.isBlank(entry.getKey())) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                if (!linkedHashMap2.isEmpty()) {
                    final int size = linkedHashMap2.size();
                    Ref.IntRef intRef = new Ref.IntRef();
                    final SubscriberAttributesManager subscriberAttributesManager = SubscriberAttributesManager.this;
                    final Ref.IntRef intRef2 = intRef;
                    final String str2 = currentAppUserID;
                    Function0<Unit> function0 = completion;
                    for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                        final String str3 = (String) entry2.getKey();
                        final Map map = (Map) entry2.getValue();
                        SubscriberAttributesPoster backend = subscriberAttributesManager.getBackend();
                        Map<String, Map<String, Object>> backendMap = BackendHelpersKt.toBackendMap(map);
                        final int i = size;
                        final Function0<Unit> function02 = function0;
                        Function0<Unit> function03 = new Function0<Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                LogHandler currentLogHandler2;
                                String str4;
                                String strInvoke2;
                                subscriberAttributesManager.markAsSynced(str3, map, CollectionsKt.emptyList());
                                final LogIntent logIntent = LogIntent.RC_SUCCESS;
                                final String str5 = str3;
                                Function0<String> function04 = new Function0<String>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$2$1$invoke$$inlined$log$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                                        String str6 = String.format(AttributionStrings.ATTRIBUTES_SYNC_SUCCESS, Arrays.copyOf(new Object[]{str5}, 1));
                                        Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                                        return sbAppend.append(str6).toString();
                                    }
                                };
                                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                                    case 1:
                                        LogLevel logLevel = LogLevel.DEBUG;
                                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                            str4 = "[Purchases] - " + logLevel.name();
                                            strInvoke2 = function04.invoke();
                                            currentLogHandler2.d(str4, strInvoke2);
                                        }
                                        break;
                                    case 2:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function04.invoke(), null);
                                        break;
                                    case 3:
                                        LogLevel logLevel2 = LogLevel.WARN;
                                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                                            currentLogHandler3.w("[Purchases] - " + logLevel2.name(), function04.invoke());
                                        }
                                        break;
                                    case 4:
                                        LogLevel logLevel3 = LogLevel.INFO;
                                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                            currentLogHandler4.i("[Purchases] - " + logLevel3.name(), function04.invoke());
                                        }
                                        break;
                                    case 5:
                                        LogLevel logLevel4 = LogLevel.DEBUG;
                                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                            str4 = "[Purchases] - " + logLevel4.name();
                                            strInvoke2 = function04.invoke();
                                            currentLogHandler2.d(str4, strInvoke2);
                                        }
                                        break;
                                    case 6:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function04.invoke(), null);
                                        break;
                                    case 7:
                                        LogLevel logLevel5 = LogLevel.INFO;
                                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                            currentLogHandler5.i("[Purchases] - " + logLevel5.name(), function04.invoke());
                                        }
                                        break;
                                    case 8:
                                        LogLevel logLevel6 = LogLevel.DEBUG;
                                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                            str4 = "[Purchases] - " + logLevel6.name();
                                            strInvoke2 = function04.invoke();
                                            currentLogHandler2.d(str4, strInvoke2);
                                        }
                                        break;
                                    case 9:
                                        LogLevel logLevel7 = LogLevel.DEBUG;
                                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                            str4 = "[Purchases] - " + logLevel7.name();
                                            strInvoke2 = function04.invoke();
                                            currentLogHandler2.d(str4, strInvoke2);
                                        }
                                        break;
                                    case 10:
                                        LogLevel logLevel8 = LogLevel.WARN;
                                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                            currentLogHandler6.w("[Purchases] - " + logLevel8.name(), function04.invoke());
                                        }
                                        break;
                                    case 11:
                                        LogLevel logLevel9 = LogLevel.WARN;
                                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                            currentLogHandler7.w("[Purchases] - " + logLevel9.name(), function04.invoke());
                                        }
                                        break;
                                    case 12:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function04.invoke(), null);
                                        break;
                                    case 13:
                                        LogLevel logLevel10 = LogLevel.WARN;
                                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                            currentLogHandler8.w("[Purchases] - " + logLevel10.name(), function04.invoke());
                                        }
                                        break;
                                    case 14:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function04.invoke(), null);
                                        break;
                                }
                                if (!Intrinsics.areEqual(str2, str3)) {
                                    subscriberAttributesManager.getDeviceCache().clearSubscriberAttributesIfSyncedForSubscriber(str3);
                                }
                                intRef2.element++;
                                if (function02 == null || intRef2.element != i) {
                                    return;
                                }
                                function02.invoke();
                            }
                        };
                        String str4 = str2;
                        size = i;
                        final Ref.IntRef intRef3 = intRef2;
                        intRef2 = intRef3;
                        backend.postSubscriberAttributes(backendMap, str3, function03, new Function3<PurchasesError, Boolean, List<? extends SubscriberAttributeError>, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$2$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(PurchasesError purchasesError, Boolean bool, List<? extends SubscriberAttributeError> list) {
                                invoke(purchasesError, bool.booleanValue(), (List<SubscriberAttributeError>) list);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(final PurchasesError error, boolean z, List<SubscriberAttributeError> attributeErrors) {
                                LogHandler currentLogHandler2;
                                String str5;
                                String strInvoke2;
                                Intrinsics.checkNotNullParameter(error, "error");
                                Intrinsics.checkNotNullParameter(attributeErrors, "attributeErrors");
                                if (z) {
                                    subscriberAttributesManager.markAsSynced(str3, map, attributeErrors);
                                }
                                final LogIntent logIntent = LogIntent.RC_ERROR;
                                final String str6 = str3;
                                Function0<String> function04 = new Function0<String>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$2$2$invoke$$inlined$log$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                                        String str7 = String.format(AttributionStrings.ATTRIBUTES_SYNC_ERROR, Arrays.copyOf(new Object[]{str6, error}, 2));
                                        Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                        return sbAppend.append(str7).toString();
                                    }
                                };
                                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                                    case 1:
                                        LogLevel logLevel = LogLevel.DEBUG;
                                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                            str5 = "[Purchases] - " + logLevel.name();
                                            strInvoke2 = function04.invoke();
                                            currentLogHandler2.d(str5, strInvoke2);
                                        }
                                        break;
                                    case 2:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function04.invoke(), null);
                                        break;
                                    case 3:
                                        LogLevel logLevel2 = LogLevel.WARN;
                                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                                            currentLogHandler3.w("[Purchases] - " + logLevel2.name(), function04.invoke());
                                        }
                                        break;
                                    case 4:
                                        LogLevel logLevel3 = LogLevel.INFO;
                                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                            currentLogHandler4.i("[Purchases] - " + logLevel3.name(), function04.invoke());
                                        }
                                        break;
                                    case 5:
                                        LogLevel logLevel4 = LogLevel.DEBUG;
                                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                            str5 = "[Purchases] - " + logLevel4.name();
                                            strInvoke2 = function04.invoke();
                                            currentLogHandler2.d(str5, strInvoke2);
                                        }
                                        break;
                                    case 6:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function04.invoke(), null);
                                        break;
                                    case 7:
                                        LogLevel logLevel5 = LogLevel.INFO;
                                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                            currentLogHandler5.i("[Purchases] - " + logLevel5.name(), function04.invoke());
                                        }
                                        break;
                                    case 8:
                                        LogLevel logLevel6 = LogLevel.DEBUG;
                                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                            str5 = "[Purchases] - " + logLevel6.name();
                                            strInvoke2 = function04.invoke();
                                            currentLogHandler2.d(str5, strInvoke2);
                                        }
                                        break;
                                    case 9:
                                        LogLevel logLevel7 = LogLevel.DEBUG;
                                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                            str5 = "[Purchases] - " + logLevel7.name();
                                            strInvoke2 = function04.invoke();
                                            currentLogHandler2.d(str5, strInvoke2);
                                        }
                                        break;
                                    case 10:
                                        LogLevel logLevel8 = LogLevel.WARN;
                                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                            currentLogHandler6.w("[Purchases] - " + logLevel8.name(), function04.invoke());
                                        }
                                        break;
                                    case 11:
                                        LogLevel logLevel9 = LogLevel.WARN;
                                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                            currentLogHandler7.w("[Purchases] - " + logLevel9.name(), function04.invoke());
                                        }
                                        break;
                                    case 12:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function04.invoke(), null);
                                        break;
                                    case 13:
                                        LogLevel logLevel10 = LogLevel.WARN;
                                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                            currentLogHandler8.w("[Purchases] - " + logLevel10.name(), function04.invoke());
                                        }
                                        break;
                                    case 14:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function04.invoke(), null);
                                        break;
                                }
                                intRef3.element++;
                                if (function02 == null || intRef3.element != size) {
                                    return;
                                }
                                function02.invoke();
                            }
                        });
                        str2 = str4;
                        function0 = function02;
                    }
                    return;
                }
                final LogIntent logIntent = LogIntent.DEBUG;
                Function0<String> function04 = new Function0<String>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$invoke$$inlined$log$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " No subscriber attributes to synchronize.";
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            str = "[Purchases] - " + logLevel.name();
                            strInvoke = function04.invoke();
                            currentLogHandler.d(str, strInvoke);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function04.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), function04.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), function04.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            str = "[Purchases] - " + logLevel4.name();
                            strInvoke = function04.invoke();
                            currentLogHandler.d(str, strInvoke);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function04.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel5.name(), function04.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            str = "[Purchases] - " + logLevel6.name();
                            strInvoke = function04.invoke();
                            currentLogHandler.d(str, strInvoke);
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str = "[Purchases] - " + logLevel7.name();
                            strInvoke = function04.invoke();
                            currentLogHandler.d(str, strInvoke);
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler5.w("[Purchases] - " + logLevel8.name(), function04.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler6.w("[Purchases] - " + logLevel9.name(), function04.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function04.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler7.w("[Purchases] - " + logLevel10.name(), function04.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", function04.invoke(), null);
                        break;
                }
                Function0<Unit> function05 = completion;
                if (function05 != null) {
                    function05.invoke();
                }
            }
        });
    }
}
