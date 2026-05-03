package com.revenuecat.purchases.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.DebugEvent;
import com.revenuecat.purchases.DebugEventName;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.utils.Event;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventsFileHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u0000 $*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001$BE\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0017\u0010\u001c\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u001eJ\"\u0010\u001f\u001a\u00020\u000e2\u001a\u0010 \u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000!\u0012\u0004\u0012\u00020\u000e0\tJ \u0010\"\u001a\u00020\u000e2\u0018\u0010 \u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0!\u0012\u0004\u0012\u00020\u000e0\tR(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/revenuecat/purchases/utils/EventsFileHelper;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/revenuecat/purchases/utils/Event;", "", "fileHelper", "Lcom/revenuecat/purchases/common/FileHelper;", "filePath", "", "eventSerializer", "Lkotlin/Function1;", "eventDeserializer", "(Lcom/revenuecat/purchases/common/FileHelper;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "debugEventCallback", "Lcom/revenuecat/purchases/DebugEvent;", "", "getDebugEventCallback", "()Lkotlin/jvm/functions/Function1;", "setDebugEventCallback", "(Lkotlin/jvm/functions/Function1;)V", "appendEvent", NotificationCompat.CATEGORY_EVENT, "(Lcom/revenuecat/purchases/utils/Event;)V", "clear", "eventsToDeleteCount", "", "deleteFile", "fileSizeInKB", "", "mapToEvent", TypedValues.Custom.S_STRING, "(Ljava/lang/String;)Lcom/revenuecat/purchases/utils/Event;", "readFile", "block", "Lkotlin/sequences/Sequence;", "readFileAsJson", "Lorg/json/JSONObject;", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class EventsFileHelper<T extends Event> {
    public static final int MAX_EVENT_PROPERTY_SIZE = 80;
    private Function1<? super DebugEvent, Unit> debugEventCallback;
    private final Function1<String, T> eventDeserializer;
    private final Function1<T, String> eventSerializer;
    private final FileHelper fileHelper;
    private final String filePath;

    /* JADX WARN: Multi-variable type inference failed */
    public EventsFileHelper(FileHelper fileHelper, String filePath, Function1<? super T, String> function1, Function1<? super String, ? extends T> function12) {
        Intrinsics.checkNotNullParameter(fileHelper, "fileHelper");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.fileHelper = fileHelper;
        this.filePath = filePath;
        this.eventSerializer = function1;
        this.eventDeserializer = function12;
    }

    public /* synthetic */ EventsFileHelper(FileHelper fileHelper, String str, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileHelper, str, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T mapToEvent(String string) {
        Function1<String, T> function1 = this.eventDeserializer;
        if (function1 == null) {
            Function1<? super DebugEvent, Unit> function12 = this.debugEventCallback;
            if (function12 != null) {
                function12.invoke(new DebugEvent(DebugEventName.DESERIALIZATION_ERROR, MapsKt.emptyMap()));
            }
            return null;
        }
        try {
            return function1.invoke(string);
        } catch (SerializationException e) {
            Function1<? super DebugEvent, Unit> function13 = this.debugEventCallback;
            if (function13 != null) {
                DebugEventName debugEventName = DebugEventName.DESERIALIZATION_ERROR;
                Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                mapCreateMapBuilder.put("exceptionType", "SerializationException");
                String message = e.getMessage();
                if (message != null) {
                    mapCreateMapBuilder.put("message", StringsKt.take(message, 80));
                }
                Unit unit = Unit.INSTANCE;
                function13.invoke(new DebugEvent(debugEventName, MapsKt.build(mapCreateMapBuilder)));
            }
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error parsing event from file: " + string, e);
            return null;
        } catch (IllegalArgumentException e2) {
            Function1<? super DebugEvent, Unit> function14 = this.debugEventCallback;
            if (function14 != null) {
                DebugEventName debugEventName2 = DebugEventName.DESERIALIZATION_ERROR;
                Map mapCreateMapBuilder2 = MapsKt.createMapBuilder();
                mapCreateMapBuilder2.put("exceptionType", "IllegalArgumentException");
                String message2 = e2.getMessage();
                if (message2 != null) {
                    mapCreateMapBuilder2.put("message", StringsKt.take(message2, 80));
                }
                Unit unit2 = Unit.INSTANCE;
                function14.invoke(new DebugEvent(debugEventName2, MapsKt.build(mapCreateMapBuilder2)));
            }
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error parsing event from file: " + string, e2);
            return null;
        }
    }

    public final synchronized void appendEvent(T event) {
        String string;
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            FileHelper fileHelper = this.fileHelper;
            String str = this.filePath;
            StringBuilder sb = new StringBuilder();
            Function1<T, String> function1 = this.eventSerializer;
            if (function1 == null || (string = function1.invoke(event)) == null) {
                string = event.toString();
            }
            fileHelper.appendToFile(str, sb.append(string).append('\n').toString());
        } catch (Exception e) {
            Function1<? super DebugEvent, Unit> function12 = this.debugEventCallback;
            if (function12 != null) {
                DebugEventName debugEventName = DebugEventName.APPEND_EVENT_EXCEPTION;
                Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                String simpleName = Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName();
                if (simpleName == null) {
                    simpleName = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                }
                mapCreateMapBuilder.put("exceptionType", simpleName);
                String message = e.getMessage();
                if (message != null) {
                    mapCreateMapBuilder.put("message", StringsKt.take(message, 80));
                }
                Unit unit = Unit.INSTANCE;
                function12.invoke(new DebugEvent(debugEventName, MapsKt.build(mapCreateMapBuilder)));
            }
            throw e;
        }
    }

    public final synchronized void clear(int eventsToDeleteCount) {
        this.fileHelper.removeFirstLinesFromFile(this.filePath, eventsToDeleteCount, new Function1<Throwable, Unit>(this) { // from class: com.revenuecat.purchases.utils.EventsFileHelper.clear.1
            final /* synthetic */ EventsFileHelper<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable e) {
                Intrinsics.checkNotNullParameter(e, "e");
                Function1<DebugEvent, Unit> debugEventCallback = this.this$0.getDebugEventCallback();
                if (debugEventCallback != null) {
                    DebugEventName debugEventName = DebugEventName.REMOVE_LINES_EXCEPTION;
                    Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                    String simpleName = Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName();
                    if (simpleName == null) {
                        simpleName = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    }
                    mapCreateMapBuilder.put("exceptionType", simpleName);
                    String message = e.getMessage();
                    if (message != null) {
                        mapCreateMapBuilder.put("message", StringsKt.take(message, 80));
                    }
                    Unit unit = Unit.INSTANCE;
                    debugEventCallback.invoke(new DebugEvent(debugEventName, MapsKt.build(mapCreateMapBuilder)));
                }
            }
        });
    }

    public final synchronized void deleteFile() {
        if (!this.fileHelper.deleteFile(this.filePath)) {
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.v("[Purchases] - " + logLevel.name(), "Failed to delete events file in " + this.filePath + FilenameUtils.EXTENSION_SEPARATOR);
            }
        }
    }

    public final synchronized double fileSizeInKB() {
        return this.fileHelper.fileSizeInKB(this.filePath);
    }

    public final Function1<DebugEvent, Unit> getDebugEventCallback() {
        return this.debugEventCallback;
    }

    public final synchronized void readFile(final Function1<? super Sequence<? extends T>, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.eventDeserializer == null || this.fileHelper.fileIsEmpty(this.filePath)) {
            block.invoke(SequencesKt.emptySequence());
        } else {
            this.fileHelper.readFilePerLines(this.filePath, new Function1<Sequence<? extends String>, Unit>() { // from class: com.revenuecat.purchases.utils.EventsFileHelper.readFile.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Sequence<? extends String> sequence) {
                    invoke2((Sequence<String>) sequence);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Sequence<String> sequence) {
                    Intrinsics.checkNotNullParameter(sequence, "sequence");
                    Function1<Sequence<? extends T>, Unit> function1 = block;
                    final EventsFileHelper<T> eventsFileHelper = this;
                    function1.invoke(SequencesKt.map(sequence, new Function1<String, T>() { // from class: com.revenuecat.purchases.utils.EventsFileHelper.readFile.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final T invoke(String line) {
                            Intrinsics.checkNotNullParameter(line, "line");
                            return (T) eventsFileHelper.mapToEvent(line);
                        }
                    }));
                }
            });
        }
    }

    public final synchronized void readFileAsJson(final Function1<? super Sequence<? extends JSONObject>, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.fileHelper.fileIsEmpty(this.filePath)) {
            block.invoke(SequencesKt.emptySequence());
        } else {
            this.fileHelper.readFilePerLines(this.filePath, new Function1<Sequence<? extends String>, Unit>() { // from class: com.revenuecat.purchases.utils.EventsFileHelper.readFileAsJson.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Sequence<? extends String> sequence) {
                    invoke2((Sequence<String>) sequence);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Sequence<String> sequence) {
                    Intrinsics.checkNotNullParameter(sequence, "sequence");
                    block.invoke(SequencesKt.map(sequence, new Function1<String, JSONObject>() { // from class: com.revenuecat.purchases.utils.EventsFileHelper.readFileAsJson.1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final JSONObject invoke(String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return new JSONObject(it);
                        }
                    }));
                }
            });
        }
    }

    public final void setDebugEventCallback(Function1<? super DebugEvent, Unit> function1) {
        this.debugEventCallback = function1;
    }
}
