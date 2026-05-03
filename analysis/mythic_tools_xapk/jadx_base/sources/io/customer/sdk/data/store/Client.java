package io.customer.sdk.data.store;

import android.os.Bundle;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import io.customer.sdk.Version;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Client.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lio/customer/sdk/data/store/Client;", "", "source", "", "sdkVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "getSdkVersion", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Client {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String META_DATA_SDK_SOURCE = "io.customer.sdk.android.core.SDK_SOURCE";
    public static final String META_DATA_SDK_VERSION = "io.customer.sdk.android.core.SDK_VERSION";
    private static final String SOURCE_ANDROID = "Android";
    private final String sdkVersion;
    private final String source;

    /* JADX INFO: compiled from: Client.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lio/customer/sdk/data/store/Client$Companion;", "", "<init>", "()V", "SOURCE_ANDROID", "", "META_DATA_SDK_SOURCE", "META_DATA_SDK_VERSION", "fromMetadata", "Lio/customer/sdk/data/store/Client;", "metadata", "Landroid/os/Bundle;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Client fromMetadata(Bundle metadata) {
            String str;
            String string = metadata != null ? metadata.getString(Client.META_DATA_SDK_SOURCE) : null;
            String string2 = metadata != null ? metadata.getString(Client.META_DATA_SDK_VERSION) : null;
            String str2 = string;
            return (str2 == null || StringsKt.isBlank(str2) || (str = string2) == null || StringsKt.isBlank(str)) ? new Client(Client.SOURCE_ANDROID, Version.version) : new Client(string, string2);
        }
    }

    public Client(String source, String sdkVersion) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        this.source = source;
        this.sdkVersion = sdkVersion;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final String getSource() {
        return this.source;
    }

    public String toString() {
        return this.source + " Client/" + this.sdkVersion;
    }
}
