package com.google.firebase.platforminfo;

import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
abstract class LibraryVersion {
    LibraryVersion() {
    }

    static LibraryVersion create(String str, String str2) {
        return new AutoValue_LibraryVersion(str, str2);
    }

    @Nonnull
    public abstract String getLibraryName();

    @Nonnull
    public abstract String getVersion();
}
