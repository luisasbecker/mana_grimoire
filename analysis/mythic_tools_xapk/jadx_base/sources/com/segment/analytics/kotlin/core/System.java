package com.segment.analytics.kotlin.core;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.ServerProtocol;
import com.segment.analytics.kotlin.core.Storage;
import com.segment.analytics.kotlin.core.utilities.JsonUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import sovran.kotlin.Action;
import sovran.kotlin.State;

/* JADX INFO: compiled from: State.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0006+,-./0B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003JC\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\nHÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u00061"}, d2 = {"Lcom/segment/analytics/kotlin/core/System;", "Lsovran/kotlin/State;", "configuration", "Lcom/segment/analytics/kotlin/core/Configuration;", "settings", "Lcom/segment/analytics/kotlin/core/Settings;", "running", "", "initializedPlugins", "", "", "enabled", "(Lcom/segment/analytics/kotlin/core/Configuration;Lcom/segment/analytics/kotlin/core/Settings;ZLjava/util/Set;Z)V", "getConfiguration", "()Lcom/segment/analytics/kotlin/core/Configuration;", "setConfiguration", "(Lcom/segment/analytics/kotlin/core/Configuration;)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getInitializedPlugins", "()Ljava/util/Set;", "setInitializedPlugins", "(Ljava/util/Set;)V", "getRunning", "setRunning", "getSettings", "()Lcom/segment/analytics/kotlin/core/Settings;", "setSettings", "(Lcom/segment/analytics/kotlin/core/Settings;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "AddDestinationToSettingsAction", "AddInitializedPlugins", "Companion", "ToggleEnabledAction", "ToggleRunningAction", "UpdateSettingsAction", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class System implements State {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Configuration configuration;
    private boolean enabled;
    private Set<Integer> initializedPlugins;
    private boolean running;
    private Settings settings;

    /* JADX INFO: compiled from: State.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/segment/analytics/kotlin/core/System$AddDestinationToSettingsAction;", "Lsovran/kotlin/Action;", "Lcom/segment/analytics/kotlin/core/System;", "destinationKey", "", "(Ljava/lang/String;)V", "getDestinationKey", "()Ljava/lang/String;", "setDestinationKey", "reduce", ServerProtocol.DIALOG_PARAM_STATE, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AddDestinationToSettingsAction implements Action<System> {
        private String destinationKey;

        public AddDestinationToSettingsAction(String destinationKey) {
            Intrinsics.checkNotNullParameter(destinationKey, "destinationKey");
            this.destinationKey = destinationKey;
        }

        public final String getDestinationKey() {
            return this.destinationKey;
        }

        @Override // sovran.kotlin.Action
        public System reduce(System state) {
            JsonObject integrations;
            Intrinsics.checkNotNullParameter(state, "state");
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            Settings settings = state.getSettings();
            if (settings != null && (integrations = settings.getIntegrations()) != null) {
                JsonUtils.putAll(jsonObjectBuilder, integrations);
            }
            JsonElementBuildersKt.put(jsonObjectBuilder, this.destinationKey, (Boolean) true);
            JsonObject jsonObjectBuild = jsonObjectBuilder.build();
            Settings settings2 = state.getSettings();
            return new System(state.getConfiguration(), settings2 != null ? Settings.copy$default(settings2, jsonObjectBuild, null, null, null, null, null, 62, null) : null, state.getRunning(), state.getInitializedPlugins(), state.getEnabled());
        }

        public final void setDestinationKey(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.destinationKey = str;
        }
    }

    /* JADX INFO: compiled from: State.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/segment/analytics/kotlin/core/System$AddInitializedPlugins;", "Lsovran/kotlin/Action;", "Lcom/segment/analytics/kotlin/core/System;", "dispatched", "", "", "(Ljava/util/Set;)V", "getDispatched", "()Ljava/util/Set;", "setDispatched", "reduce", ServerProtocol.DIALOG_PARAM_STATE, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AddInitializedPlugins implements Action<System> {
        private Set<Integer> dispatched;

        public AddInitializedPlugins(Set<Integer> dispatched) {
            Intrinsics.checkNotNullParameter(dispatched, "dispatched");
            this.dispatched = dispatched;
        }

        public final Set<Integer> getDispatched() {
            return this.dispatched;
        }

        @Override // sovran.kotlin.Action
        public System reduce(System state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new System(state.getConfiguration(), state.getSettings(), state.getRunning(), SetsKt.plus((Set) state.getInitializedPlugins(), (Iterable) this.dispatched), state.getEnabled());
        }

        public final void setDispatched(Set<Integer> set) {
            Intrinsics.checkNotNullParameter(set, "<set-?>");
            this.dispatched = set;
        }
    }

    /* JADX INFO: compiled from: State.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/segment/analytics/kotlin/core/System$Companion;", "", "()V", "defaultState", "Lcom/segment/analytics/kotlin/core/System;", "configuration", "Lcom/segment/analytics/kotlin/core/Configuration;", "storage", "Lcom/segment/analytics/kotlin/core/Storage;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final System defaultState(Configuration configuration, Storage storage) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(storage, "storage");
            String str = storage.read(Storage.Constants.Settings);
            Settings defaultSettings = configuration.getDefaultSettings();
            if (defaultSettings == null) {
                JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
                JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
                JsonElementBuildersKt.put(jsonObjectBuilder2, "apiKey", configuration.getWriteKey());
                JsonElementBuildersKt.put(jsonObjectBuilder2, "apiHost", Constants.DEFAULT_API_HOST);
                Unit unit = Unit.INSTANCE;
                jsonObjectBuilder.put("Segment.io", jsonObjectBuilder2.build());
                defaultSettings = new Settings(jsonObjectBuilder.build(), EventsKt.getEmptyJsonObject(), EventsKt.getEmptyJsonObject(), EventsKt.getEmptyJsonObject(), (JsonObject) null, (JsonObject) null, 48, (DefaultConstructorMarker) null);
            }
            if (str != null && !Intrinsics.areEqual(str, "") && !Intrinsics.areEqual(str, "{}")) {
                try {
                    defaultSettings = (Settings) Json.INSTANCE.decodeFromString(Settings.INSTANCE.serializer(), str);
                } catch (Exception unused) {
                }
            }
            return new System(configuration, defaultSettings, false, SetsKt.emptySet(), true);
        }
    }

    /* JADX INFO: compiled from: State.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/segment/analytics/kotlin/core/System$ToggleEnabledAction;", "Lsovran/kotlin/Action;", "Lcom/segment/analytics/kotlin/core/System;", "enabled", "", "(Z)V", "getEnabled", "()Z", "reduce", ServerProtocol.DIALOG_PARAM_STATE, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ToggleEnabledAction implements Action<System> {
        private final boolean enabled;

        public ToggleEnabledAction(boolean z) {
            this.enabled = z;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        @Override // sovran.kotlin.Action
        public System reduce(System state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new System(state.getConfiguration(), state.getSettings(), state.getRunning(), state.getInitializedPlugins(), this.enabled);
        }
    }

    /* JADX INFO: compiled from: State.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/segment/analytics/kotlin/core/System$ToggleRunningAction;", "Lsovran/kotlin/Action;", "Lcom/segment/analytics/kotlin/core/System;", "running", "", "(Z)V", "getRunning", "()Z", "setRunning", "reduce", ServerProtocol.DIALOG_PARAM_STATE, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ToggleRunningAction implements Action<System> {
        private boolean running;

        public ToggleRunningAction(boolean z) {
            this.running = z;
        }

        public final boolean getRunning() {
            return this.running;
        }

        @Override // sovran.kotlin.Action
        public System reduce(System state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new System(state.getConfiguration(), state.getSettings(), this.running, state.getInitializedPlugins(), state.getEnabled());
        }

        public final void setRunning(boolean z) {
            this.running = z;
        }
    }

    /* JADX INFO: compiled from: State.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/segment/analytics/kotlin/core/System$UpdateSettingsAction;", "Lsovran/kotlin/Action;", "Lcom/segment/analytics/kotlin/core/System;", "settings", "Lcom/segment/analytics/kotlin/core/Settings;", "(Lcom/segment/analytics/kotlin/core/Settings;)V", "getSettings", "()Lcom/segment/analytics/kotlin/core/Settings;", "setSettings", "reduce", ServerProtocol.DIALOG_PARAM_STATE, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class UpdateSettingsAction implements Action<System> {
        private Settings settings;

        public UpdateSettingsAction(Settings settings) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            this.settings = settings;
        }

        public final Settings getSettings() {
            return this.settings;
        }

        @Override // sovran.kotlin.Action
        public System reduce(System state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new System(state.getConfiguration(), this.settings, state.getRunning(), state.getInitializedPlugins(), state.getEnabled());
        }

        public final void setSettings(Settings settings) {
            Intrinsics.checkNotNullParameter(settings, "<set-?>");
            this.settings = settings;
        }
    }

    public System(Configuration configuration, Settings settings, boolean z, Set<Integer> initializedPlugins, boolean z2) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(initializedPlugins, "initializedPlugins");
        this.configuration = configuration;
        this.settings = settings;
        this.running = z;
        this.initializedPlugins = initializedPlugins;
        this.enabled = z2;
    }

    public /* synthetic */ System(Configuration configuration, Settings settings, boolean z, Set set, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Configuration("", null, null, false, false, false, false, 0, 0, null, null, false, null, null, null, null, 65534, null) : configuration, settings, z, set, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ System copy$default(System system, Configuration configuration, Settings settings, boolean z, Set set, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            configuration = system.configuration;
        }
        if ((i & 2) != 0) {
            settings = system.settings;
        }
        if ((i & 4) != 0) {
            z = system.running;
        }
        if ((i & 8) != 0) {
            set = system.initializedPlugins;
        }
        if ((i & 16) != 0) {
            z2 = system.enabled;
        }
        boolean z3 = z2;
        boolean z4 = z;
        return system.copy(configuration, settings, z4, set, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Configuration getConfiguration() {
        return this.configuration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Settings getSettings() {
        return this.settings;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getRunning() {
        return this.running;
    }

    public final Set<Integer> component4() {
        return this.initializedPlugins;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final System copy(Configuration configuration, Settings settings, boolean running, Set<Integer> initializedPlugins, boolean enabled) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(initializedPlugins, "initializedPlugins");
        return new System(configuration, settings, running, initializedPlugins, enabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof System)) {
            return false;
        }
        System system = (System) other;
        return Intrinsics.areEqual(this.configuration, system.configuration) && Intrinsics.areEqual(this.settings, system.settings) && this.running == system.running && Intrinsics.areEqual(this.initializedPlugins, system.initializedPlugins) && this.enabled == system.enabled;
    }

    public final Configuration getConfiguration() {
        return this.configuration;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Set<Integer> getInitializedPlugins() {
        return this.initializedPlugins;
    }

    public final boolean getRunning() {
        return this.running;
    }

    public final Settings getSettings() {
        return this.settings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = this.configuration.hashCode() * 31;
        Settings settings = this.settings;
        int iHashCode2 = (iHashCode + (settings == null ? 0 : settings.hashCode())) * 31;
        boolean z = this.running;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode3 = (((iHashCode2 + r1) * 31) + this.initializedPlugins.hashCode()) * 31;
        boolean z2 = this.enabled;
        return iHashCode3 + (z2 ? 1 : z2);
    }

    public final void setConfiguration(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "<set-?>");
        this.configuration = configuration;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final void setInitializedPlugins(Set<Integer> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.initializedPlugins = set;
    }

    public final void setRunning(boolean z) {
        this.running = z;
    }

    public final void setSettings(Settings settings) {
        this.settings = settings;
    }

    public String toString() {
        return "System(configuration=" + this.configuration + ", settings=" + this.settings + ", running=" + this.running + ", initializedPlugins=" + this.initializedPlugins + ", enabled=" + this.enabled + ')';
    }
}
