package com.google.firebase.crashlytics.internal.common;

/* JADX INFO: loaded from: classes5.dex */
public interface InstallIdProvider {

    public static abstract class InstallIds {
        static InstallIds create(String str, FirebaseInstallationId firebaseInstallationId) {
            return new AutoValue_InstallIdProvider_InstallIds(str, firebaseInstallationId.getFid(), firebaseInstallationId.getAuthToken());
        }

        public static InstallIds createWithoutFid(String str) {
            return new AutoValue_InstallIdProvider_InstallIds(str, null, null);
        }

        public abstract String getCrashlyticsInstallId();

        public abstract String getFirebaseAuthenticationToken();

        public abstract String getFirebaseInstallationId();
    }

    InstallIds getInstallIds();
}
