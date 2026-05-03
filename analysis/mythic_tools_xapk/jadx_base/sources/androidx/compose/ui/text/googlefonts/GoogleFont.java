package androidx.compose.ui.text.googlefonts;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GoogleFont.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/googlefonts/GoogleFont;", "", "name", "", "bestEffort", "", "<init>", "(Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getBestEffort", "()Z", "Provider", "ui-text-google-fonts"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GoogleFont {
    public static final int $stable = 0;
    private final boolean bestEffort;
    private final String name;

    /* JADX INFO: compiled from: GoogleFont.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B9\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006¢\u0006\u0004\b\n\u0010\fB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\t¢\u0006\u0004\b\n\u0010\rJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\"\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/googlefonts/GoogleFont$Provider;", "", "providerAuthority", "", "providerPackage", "certificates", "", "", "certificatesRes", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;I)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "(Ljava/lang/String;Ljava/lang/String;I)V", "getProviderAuthority$ui_text_google_fonts", "()Ljava/lang/String;", "getProviderPackage$ui_text_google_fonts", "getCertificates$ui_text_google_fonts", "()Ljava/util/List;", "getCertificatesRes$ui_text_google_fonts", "()I", "equals", "", "other", "hashCode", "ui-text-google-fonts"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Provider {
        public static final int $stable = 8;
        private final List<List<byte[]>> certificates;
        private final int certificatesRes;
        private final String providerAuthority;
        private final String providerPackage;

        public Provider(String str, String str2, int i) {
            this(str, str2, null, i);
        }

        public Provider(String str, String str2, List<? extends List<byte[]>> list) {
            this(str, str2, list, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Provider(String str, String str2, List<? extends List<byte[]>> list, int i) {
            this.providerAuthority = str;
            this.providerPackage = str2;
            this.certificates = list;
            this.certificatesRes = i;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Provider)) {
                return false;
            }
            Provider provider = (Provider) other;
            return Intrinsics.areEqual(this.providerAuthority, provider.providerAuthority) && Intrinsics.areEqual(this.providerPackage, provider.providerPackage) && Intrinsics.areEqual(this.certificates, provider.certificates) && this.certificatesRes == provider.certificatesRes;
        }

        public final List<List<byte[]>> getCertificates$ui_text_google_fonts() {
            return this.certificates;
        }

        /* JADX INFO: renamed from: getCertificatesRes$ui_text_google_fonts, reason: from getter */
        public final int getCertificatesRes() {
            return this.certificatesRes;
        }

        /* JADX INFO: renamed from: getProviderAuthority$ui_text_google_fonts, reason: from getter */
        public final String getProviderAuthority() {
            return this.providerAuthority;
        }

        /* JADX INFO: renamed from: getProviderPackage$ui_text_google_fonts, reason: from getter */
        public final String getProviderPackage() {
            return this.providerPackage;
        }

        public int hashCode() {
            int iHashCode = ((this.providerAuthority.hashCode() * 31) + this.providerPackage.hashCode()) * 31;
            List<List<byte[]>> list = this.certificates;
            return ((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + this.certificatesRes;
        }
    }

    public GoogleFont(String str, boolean z) {
        this.name = str;
        this.bestEffort = z;
        if (str.length() <= 0) {
            throw new IllegalArgumentException("name cannot be empty".toString());
        }
    }

    public /* synthetic */ GoogleFont(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? true : z);
    }

    public final boolean getBestEffort() {
        return this.bestEffort;
    }

    public final String getName() {
        return this.name;
    }
}
