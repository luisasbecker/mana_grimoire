package io.customer.sdk;

import io.customer.sdk.core.module.CustomerIOModule;
import io.customer.sdk.core.module.CustomerIOModuleConfig;
import io.customer.sdk.core.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataPipelinesLogger.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0016\u0010\n\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\fJ\u0016\u0010\u000e\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\fJ\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0013\u001a\u00020\u0007J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0015\u001a\u00020\u0007J\u0016\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lio/customer/sdk/DataPipelinesLogger;", "", "logger", "Lio/customer/sdk/core/util/Logger;", "<init>", "(Lio/customer/sdk/core/util/Logger;)V", "coreSdkInitStart", "", "coreSdkAlreadyInitialized", "coreSdkInitSuccess", "moduleInitStart", "module", "Lio/customer/sdk/core/module/CustomerIOModule;", "Lio/customer/sdk/core/module/CustomerIOModuleConfig;", "moduleInitSuccess", "logStoringDevicePushToken", "token", "", "userId", "logStoringBlankPushToken", "logRegisteringPushToken", "logPushTokenRefreshed", "automaticTokenRegistrationForNewProfile", "logDeletingTokenDueToNewProfileIdentification", "logTrackingDevicesAttributesWithoutValidToken", "Companion", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DataPipelinesLogger {
    public static final String INIT_TAG = "Init";
    public static final String PUSH_TAG = "Push";
    private final Logger logger;

    public DataPipelinesLogger(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
    }

    public final void automaticTokenRegistrationForNewProfile(String token, String userId) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.logger.debug("Automatically registering device token: " + token + " to newly identified profile: " + userId, PUSH_TAG);
    }

    public final void coreSdkAlreadyInitialized() {
        this.logger.error("CustomerIO instance is already initialized, skipping the initialization", INIT_TAG, new IllegalStateException("CustomerIO SDK already initialized"));
    }

    public final void coreSdkInitStart() {
        this.logger.debug("Creating new instance of CustomerIO SDK version: 4.17.0...", INIT_TAG);
    }

    public final void coreSdkInitSuccess() {
        this.logger.info("CustomerIO SDK is initialized and ready to use", INIT_TAG);
    }

    public final void logDeletingTokenDueToNewProfileIdentification() {
        this.logger.debug("Deleting device token before identifying new profile", PUSH_TAG);
    }

    public final void logPushTokenRefreshed() {
        this.logger.debug("Token refreshed, deleting old token to avoid registering same device multiple times", PUSH_TAG);
    }

    public final void logRegisteringPushToken(String token, String userId) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.logger.debug("Registering device token: " + token + " for user profile: " + userId, PUSH_TAG);
    }

    public final void logStoringBlankPushToken() {
        this.logger.debug("Attempting to register blank token, ignoring request", PUSH_TAG);
    }

    public final void logStoringDevicePushToken(String token, String userId) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.logger.debug("Storing device token: " + token + " for user profile: " + userId, PUSH_TAG);
    }

    public final void logTrackingDevicesAttributesWithoutValidToken() {
        this.logger.debug("No device token found. ignoring request to track device attributes", PUSH_TAG);
    }

    public final void moduleInitStart(CustomerIOModule<? extends CustomerIOModuleConfig> module) {
        Intrinsics.checkNotNullParameter(module, "module");
        this.logger.debug("Initializing SDK module " + module.getModuleName() + " with config: " + module.getModuleConfig() + "...", INIT_TAG);
    }

    public final void moduleInitSuccess(CustomerIOModule<? extends CustomerIOModuleConfig> module) {
        Intrinsics.checkNotNullParameter(module, "module");
        this.logger.info("CustomerIO " + module.getModuleName() + " module is initialized and ready to use", INIT_TAG);
    }
}
