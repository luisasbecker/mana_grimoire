package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallTemplate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0080\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;", "", "id", "", "configurationType", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PackageConfigurationType;", "(Ljava/lang/String;ILjava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PackageConfigurationType;)V", "getConfigurationType", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PackageConfigurationType;", "getId", "()Ljava/lang/String;", "TEMPLATE_1", "TEMPLATE_2", "TEMPLATE_3", "TEMPLATE_4", "TEMPLATE_5", "TEMPLATE_7", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum PaywallTemplate {
    TEMPLATE_1("1", PackageConfigurationType.SINGLE),
    TEMPLATE_2(ExifInterface.GPS_MEASUREMENT_2D, PackageConfigurationType.MULTIPLE),
    TEMPLATE_3(ExifInterface.GPS_MEASUREMENT_3D, PackageConfigurationType.SINGLE),
    TEMPLATE_4("4", PackageConfigurationType.MULTIPLE),
    TEMPLATE_5("5", PackageConfigurationType.MULTIPLE),
    TEMPLATE_7("7", PackageConfigurationType.MULTITIER);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PackageConfigurationType configurationType;
    private final String id;

    /* JADX INFO: compiled from: PaywallTemplate.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate$Companion;", "", "()V", "fromId", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;", "id", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PaywallTemplate fromId(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            for (PaywallTemplate paywallTemplate : PaywallTemplate.values()) {
                if (Intrinsics.areEqual(paywallTemplate.getId(), id)) {
                    return paywallTemplate;
                }
            }
            return null;
        }
    }

    PaywallTemplate(String str, PackageConfigurationType packageConfigurationType) {
        this.id = str;
        this.configurationType = packageConfigurationType;
    }

    public final PackageConfigurationType getConfigurationType() {
        return this.configurationType;
    }

    public final String getId() {
        return this.id;
    }
}
