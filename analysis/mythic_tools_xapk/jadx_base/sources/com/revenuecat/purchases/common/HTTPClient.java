package com.revenuecat.purchases.common;

import android.os.Build;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.credentials.provider.CredentialEntry;
import com.google.common.net.HttpHeaders;
import com.revenuecat.purchases.ForceServerErrorStrategy;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.networking.ConnectionErrorReason;
import com.revenuecat.purchases.common.networking.ETagManager;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPRequest;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import com.revenuecat.purchases.common.networking.MapConverter;
import com.revenuecat.purchases.common.networking.NullPointerReadingErrorStreamException;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.common.verification.SignatureVerificationException;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.interfaces.StorefrontProvider;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import org.apache.commons.codec.language.Soundex;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: HTTPClient.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 _2\u00020\u0001:\u0001_Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010\u001d\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020%J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u0010,\u001a\n .*\u0004\u0018\u00010-0-2\u0006\u0010/\u001a\u000200H\u0002JT\u00101\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-022\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u001a2\b\u00107\u001a\u0004\u0018\u00010-2\u0006\u00108\u001a\u00020\u001a2\b\u00109\u001a\u0004\u0018\u00010-H\u0002J\u0012\u0010:\u001a\u0004\u0018\u00010 2\u0006\u0010/\u001a\u00020'H\u0002J\u0010\u0010;\u001a\u00020\u001a2\u0006\u0010/\u001a\u000200H\u0002J\u0012\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010/\u001a\u000200H\u0002J\u0012\u0010>\u001a\u0004\u0018\u00010-2\u0006\u0010/\u001a\u000200H\u0002J\b\u0010?\u001a\u00020-H\u0002Jr\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u0002052\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020E2\u0016\u0010F\u001a\u0012\u0012\u0004\u0012\u00020-\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001022\u001a\u0010G\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-0I\u0018\u00010H2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-022\u0006\u00106\u001a\u00020\u001aH\u0002J\u0082\u0001\u0010K\u001a\u00020A2\u0006\u0010B\u001a\u0002052\u0006\u0010D\u001a\u00020E2\u0016\u0010F\u001a\u0012\u0012\u0004\u0012\u00020-\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001022\u001a\u0010G\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-0I\u0018\u00010H2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-022\b\b\u0002\u00106\u001a\u00020\u001a2\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u0002050H2\b\b\u0002\u0010M\u001a\u00020NJ\u0010\u0010O\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010P\u001a\u00020-2\u0006\u0010Q\u001a\u00020)H\u0002JD\u0010R\u001a\u00020%2\u0006\u0010B\u001a\u0002052\u0006\u0010D\u001a\u00020E2\u0006\u0010S\u001a\u00020=2\u0006\u0010T\u001a\u00020\u001a2\b\u0010U\u001a\u0004\u0018\u00010A2\u0006\u0010V\u001a\u00020\u001a2\b\u0010W\u001a\u0004\u0018\u00010XH\u0002J6\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020-2\u0006\u0010/\u001a\u0002002\b\u0010\\\u001a\u0004\u0018\u00010-2\b\u00107\u001a\u0004\u0018\u00010-2\b\u00109\u001a\u0004\u0018\u00010-H\u0002J\u0018\u0010]\u001a\u00020%2\u0006\u0010^\u001a\u00020!2\u0006\u0010F\u001a\u00020-H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/revenuecat/purchases/common/HTTPClient;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "eTagManager", "Lcom/revenuecat/purchases/common/networking/ETagManager;", "diagnosticsTrackerIfEnabled", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "signingManager", "Lcom/revenuecat/purchases/common/verification/SigningManager;", "storefrontProvider", "Lcom/revenuecat/purchases/interfaces/StorefrontProvider;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "mapConverter", "Lcom/revenuecat/purchases/common/networking/MapConverter;", "localeProvider", "Lcom/revenuecat/purchases/common/LocaleProvider;", "forceServerErrorStrategy", "Lcom/revenuecat/purchases/ForceServerErrorStrategy;", "requestResponseListener", "Lcom/revenuecat/purchases/common/RequestResponseListener;", "timeoutManager", "Lcom/revenuecat/purchases/common/networking/HTTPTimeoutManager;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/networking/ETagManager;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Lcom/revenuecat/purchases/common/verification/SigningManager;Lcom/revenuecat/purchases/interfaces/StorefrontProvider;Lcom/revenuecat/purchases/common/DateProvider;Lcom/revenuecat/purchases/common/networking/MapConverter;Lcom/revenuecat/purchases/common/LocaleProvider;Lcom/revenuecat/purchases/ForceServerErrorStrategy;Lcom/revenuecat/purchases/common/RequestResponseListener;Lcom/revenuecat/purchases/common/networking/HTTPTimeoutManager;)V", "enableExtraRequestLogging", "", "getSigningManager", "()Lcom/revenuecat/purchases/common/verification/SigningManager;", "buffer", "Ljava/io/BufferedReader;", "inputStream", "Ljava/io/InputStream;", "Ljava/io/BufferedWriter;", "outputStream", "Ljava/io/OutputStream;", "clearCaches", "", "getConnection", "Ljava/net/HttpURLConnection;", "request", "Lcom/revenuecat/purchases/common/networking/HTTPRequest;", "timeoutMs", "", "getETagHeader", "", "kotlin.jvm.PlatformType", "connection", "Ljava/net/URLConnection;", "getHeaders", "", "authenticationHeaders", "fullURL", "Ljava/net/URL;", "refreshETag", "nonce", "shouldSignResponse", "postFieldsToSignHeader", "getInputStream", "getLoadShedderHeader", "getRequestDateHeader", "Ljava/util/Date;", "getRequestTimeHeader", "getXPlatformHeader", "performCall", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "baseURL", "isFallbackURL", "endpoint", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "body", "postFieldsToSign", "", "Lkotlin/Pair;", "requestHeaders", "performRequest", "fallbackBaseURLs", "fallbackURLIndex", "", "readFully", "toCurlRequest", "httpRequest", "trackHttpRequestPerformedIfNeeded", "requestStartTime", "callSuccessful", "callResult", "isRetry", "connectionException", "Ljava/io/IOException;", "verifyResponse", "Lcom/revenuecat/purchases/VerificationResult;", "urlPath", "payload", "writeFully", "writer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HTTPClient {
    public static final int NO_STATUS_CODE = -1;
    private final AppConfig appConfig;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final ETagManager eTagManager;
    private final boolean enableExtraRequestLogging;
    private final ForceServerErrorStrategy forceServerErrorStrategy;
    private final LocaleProvider localeProvider;
    private final MapConverter mapConverter;
    private final RequestResponseListener requestResponseListener;
    private final SigningManager signingManager;
    private final StorefrontProvider storefrontProvider;
    private final HTTPTimeoutManager timeoutManager;

    /* JADX INFO: compiled from: HTTPClient.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.AMAZON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public HTTPClient(AppConfig appConfig, ETagManager eTagManager, DiagnosticsTracker diagnosticsTracker, SigningManager signingManager, StorefrontProvider storefrontProvider, DateProvider dateProvider, MapConverter mapConverter, LocaleProvider localeProvider, ForceServerErrorStrategy forceServerErrorStrategy, RequestResponseListener requestResponseListener, HTTPTimeoutManager timeoutManager) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(eTagManager, "eTagManager");
        Intrinsics.checkNotNullParameter(signingManager, "signingManager");
        Intrinsics.checkNotNullParameter(storefrontProvider, "storefrontProvider");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        Intrinsics.checkNotNullParameter(mapConverter, "mapConverter");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        Intrinsics.checkNotNullParameter(timeoutManager, "timeoutManager");
        this.appConfig = appConfig;
        this.eTagManager = eTagManager;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.signingManager = signingManager;
        this.storefrontProvider = storefrontProvider;
        this.dateProvider = dateProvider;
        this.mapConverter = mapConverter;
        this.localeProvider = localeProvider;
        this.forceServerErrorStrategy = forceServerErrorStrategy;
        this.requestResponseListener = requestResponseListener;
        this.timeoutManager = timeoutManager;
        this.enableExtraRequestLogging = false;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ HTTPClient(AppConfig appConfig, ETagManager eTagManager, DiagnosticsTracker diagnosticsTracker, SigningManager signingManager, StorefrontProvider storefrontProvider, DateProvider dateProvider, MapConverter mapConverter, LocaleProvider localeProvider, ForceServerErrorStrategy forceServerErrorStrategy, RequestResponseListener requestResponseListener, HTTPTimeoutManager hTTPTimeoutManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        DateProvider defaultDateProvider = (i & 32) != 0 ? new DefaultDateProvider() : dateProvider;
        this(appConfig, eTagManager, diagnosticsTracker, signingManager, storefrontProvider, defaultDateProvider, (i & 64) != 0 ? new MapConverter() : mapConverter, localeProvider, (i & 256) != 0 ? null : forceServerErrorStrategy, (i & 512) != 0 ? null : requestResponseListener, (i & 1024) != 0 ? new HTTPTimeoutManager(appConfig, defaultDateProvider) : hTTPTimeoutManager);
    }

    private final BufferedReader buffer(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private final BufferedWriter buffer(OutputStream outputStream) {
        return new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    private final HttpURLConnection getConnection(HTTPRequest request, long timeoutMs) throws IOException {
        URLConnection uRLConnectionOpenConnection = request.getFullURL().openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setConnectTimeout((int) timeoutMs);
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        JSONObject body = request.getBody();
        if (body != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
            OutputStream os = httpURLConnection.getOutputStream();
            Intrinsics.checkNotNullExpressionValue(os, "os");
            BufferedWriter bufferedWriterBuffer = buffer(os);
            String string = body.toString();
            Intrinsics.checkNotNullExpressionValue(string, "body.toString()");
            writeFully(bufferedWriterBuffer, string);
        }
        return httpURLConnection;
    }

    private final String getETagHeader(URLConnection connection) {
        return connection.getHeaderField("X-RevenueCat-ETag");
    }

    private final Map<String, String> getHeaders(Map<String, String> authenticationHeaders, URL fullURL, boolean refreshETag, String nonce, boolean shouldSignResponse, String postFieldsToSignHeader) {
        Pair[] pairArr = new Pair[22];
        pairArr[0] = TuplesKt.to(HttpHeaders.CONTENT_TYPE, "application/json");
        pairArr[1] = TuplesKt.to("X-Platform", getXPlatformHeader());
        pairArr[2] = TuplesKt.to("X-Platform-Flavor", this.appConfig.getPlatformInfo().getFlavor());
        pairArr[3] = TuplesKt.to("X-Platform-Flavor-Version", this.appConfig.getPlatformInfo().getVersion());
        pairArr[4] = TuplesKt.to("X-Platform-Version", String.valueOf(Build.VERSION.SDK_INT));
        pairArr[5] = TuplesKt.to("X-Platform-Device", Build.MODEL);
        pairArr[6] = TuplesKt.to("X-Platform-Brand", Build.BRAND);
        pairArr[7] = TuplesKt.to("X-Version", "10.2.0");
        pairArr[8] = TuplesKt.to("X-Preferred-Locales", StringsKt.replace$default(this.localeProvider.getCurrentLocalesLanguageTags(), Soundex.SILENT_MARKER, '_', false, 4, (Object) null));
        pairArr[9] = TuplesKt.to("X-Client-Locale", this.appConfig.getLanguageTag());
        pairArr[10] = TuplesKt.to("X-Client-Version", this.appConfig.getVersionName());
        pairArr[11] = TuplesKt.to("X-Client-Bundle-ID", this.appConfig.getPackageName());
        pairArr[12] = TuplesKt.to("X-Observer-Mode-Enabled", this.appConfig.getFinishTransactions() ? CredentialEntry.FALSE_STRING : "true");
        pairArr[13] = TuplesKt.to("X-Nonce", nonce);
        pairArr[14] = TuplesKt.to(HTTPRequest.POST_PARAMS_HASH, postFieldsToSignHeader);
        pairArr[15] = TuplesKt.to("X-Custom-Entitlements-Computation", this.appConfig.getCustomEntitlementComputation() ? "true" : null);
        pairArr[16] = TuplesKt.to("X-UI-Preview-Mode", this.appConfig.getUiPreviewMode() ? "true" : null);
        pairArr[17] = TuplesKt.to("X-Storefront", this.storefrontProvider.getStorefront());
        pairArr[18] = TuplesKt.to("X-Is-Debug-Build", String.valueOf(this.appConfig.getIsDebugBuild()));
        pairArr[19] = TuplesKt.to("X-Kotlin-Version", KotlinVersion.CURRENT.toString());
        pairArr[20] = TuplesKt.to("X-Is-Backgrounded", String.valueOf(this.appConfig.isAppBackgrounded()));
        pairArr[21] = TuplesKt.to("X-Billing-Client-Sdk-Version", "8.3.0");
        Map mapPlus = MapsKt.plus(MapsKt.mapOf(pairArr), authenticationHeaders);
        ETagManager eTagManager = this.eTagManager;
        String string = fullURL.toString();
        Intrinsics.checkNotNullExpressionValue(string, "fullURL.toString()");
        return MapExtensionsKt.filterNotNullValues(MapsKt.plus(mapPlus, eTagManager.getETagHeaders$purchases_defaultsBc8Release(string, shouldSignResponse, refreshETag)));
    }

    private final InputStream getInputStream(HttpURLConnection connection) throws Exception {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        try {
            return connection.getInputStream();
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException ? true : e instanceof IOException)) {
                throw e;
            }
            final LogIntent logIntent = LogIntent.WARNING;
            Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.HTTPClient$getInputStream$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                    String str2 = String.format(NetworkStrings.PROBLEM_CONNECTING, Arrays.copyOf(new Object[]{e.getMessage()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    return sbAppend.append(str2).toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.d(str, strInvoke);
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
                        str = "[Purchases] - " + logLevel4.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.d(str, strInvoke);
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
                        str = "[Purchases] - " + logLevel6.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.d(str, strInvoke);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        strInvoke = function0.invoke();
                        currentLogHandler.d(str, strInvoke);
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
            try {
                return connection.getErrorStream();
            } catch (NullPointerException e2) {
                throw new NullPointerReadingErrorStreamException(e2.getMessage(), e2);
            }
        }
    }

    private final boolean getLoadShedderHeader(URLConnection connection) {
        String lowerCase;
        String headerField = connection.getHeaderField(HTTPResult.LOAD_SHEDDER_HEADER_NAME);
        if (headerField != null) {
            lowerCase = headerField.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        return Intrinsics.areEqual(lowerCase, "true");
    }

    private final Date getRequestDateHeader(URLConnection connection) {
        String requestTimeHeader = getRequestTimeHeader(connection);
        if (requestTimeHeader != null) {
            return new Date(Long.parseLong(requestTimeHeader));
        }
        return null;
    }

    private final String getRequestTimeHeader(URLConnection connection) {
        String headerField = connection.getHeaderField(HTTPResult.REQUEST_TIME_HEADER_NAME);
        if (headerField == null || StringsKt.isBlank(headerField)) {
            return null;
        }
        return headerField;
    }

    private final String getXPlatformHeader() {
        return WhenMappings.$EnumSwitchMapping$0[this.appConfig.getStore().ordinal()] == 1 ? "amazon" : com.facebook.appevents.codeless.internal.Constants.PLATFORM;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final HTTPResult performCall(URL baseURL, boolean isFallbackURL, Endpoint endpoint, Map<String, ? extends Object> body, List<Pair<String, String>> postFieldsToSign, Map<String, String> requestHeaders, boolean refreshETag) throws Exception {
        boolean z;
        URL url;
        String postParamsForSigningHeaderIfNeeded;
        URL url2;
        InputStream inputStream;
        String str;
        boolean z2;
        String str2;
        URL url3;
        String str3;
        boolean z3;
        HTTPClient hTTPClient;
        String str4;
        VerificationResult verificationResultVerifyResponse;
        RequestResponseListener requestResponseListener;
        ForceServerErrorStrategy forceServerErrorStrategy;
        ForceServerErrorStrategy forceServerErrorStrategy2;
        HTTPResult hTTPResultFakeResponseWithoutPerformingRequest;
        JSONObject jSONObjectConvertToJSON$purchases_defaultsBc8Release = body != null ? this.mapConverter.convertToJSON$purchases_defaultsBc8Release(body) : null;
        String path = endpoint.getPath(isFallbackURL);
        boolean zShouldVerifyEndpoint = this.signingManager.shouldVerifyEndpoint(endpoint);
        boolean z4 = zShouldVerifyEndpoint && endpoint.getNeedsNonceToPerformSigning();
        if (this.appConfig.getRunningTests() && (forceServerErrorStrategy2 = this.forceServerErrorStrategy) != null && (hTTPResultFakeResponseWithoutPerformingRequest = forceServerErrorStrategy2.fakeResponseWithoutPerformingRequest(baseURL, endpoint)) != null) {
            LogLevel logLevel = LogLevel.WARN;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.w("[Purchases] - " + logLevel.name(), "Faking response for request to " + Endpoint.getPath$default(endpoint, false, 1, null));
            }
            return hTTPResultFakeResponseWithoutPerformingRequest;
        }
        try {
            if (this.appConfig.getRunningTests() && (forceServerErrorStrategy = this.forceServerErrorStrategy) != null && forceServerErrorStrategy.shouldForceServerError(baseURL, endpoint)) {
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                z = z4;
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), "Forcing server error for request to " + new URL(baseURL, path));
                }
                url = new URL(this.forceServerErrorStrategy.getServerErrorURL());
            } else {
                z = z4;
                url = new URL(baseURL, path);
            }
            String strCreateRandomNonce = z ? this.signingManager.createRandomNonce() : null;
            if (postFieldsToSign == null) {
                postParamsForSigningHeaderIfNeeded = null;
            } else if ((zShouldVerifyEndpoint ? postFieldsToSign : null) != null) {
                postParamsForSigningHeaderIfNeeded = this.signingManager.getPostParamsForSigningHeaderIfNeeded(endpoint, postFieldsToSign);
            }
            URL url4 = url;
            HTTPRequest hTTPRequest = new HTTPRequest(url4, getHeaders(requestHeaders, url4, refreshETag, strCreateRandomNonce, zShouldVerifyEndpoint, postParamsForSigningHeaderIfNeeded), jSONObjectConvertToJSON$purchases_defaultsBc8Release);
            if (this.enableExtraRequestLogging) {
                LogLevel logLevel3 = LogLevel.DEBUG;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                url2 = url4;
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.d("[Purchases] - " + logLevel3.name(), "HTTP request:\\n " + toCurlRequest(hTTPRequest));
                }
            } else {
                url2 = url4;
            }
            HttpURLConnection connection = getConnection(hTTPRequest, this.timeoutManager.getTimeoutForRequest(isFallbackURL, endpoint.getSupportsFallbackBaseURLs() && !this.appConfig.getFallbackBaseURLs().isEmpty()));
            InputStream inputStream2 = getInputStream(connection);
            try {
                LogLevel logLevel4 = LogLevel.DEBUG;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    String str5 = "[Purchases] - " + logLevel4.name();
                    str = strCreateRandomNonce;
                    z2 = zShouldVerifyEndpoint;
                    String str6 = String.format(NetworkStrings.API_REQUEST_STARTED, Arrays.copyOf(new Object[]{connection.getRequestMethod(), path}, 2));
                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                    currentLogHandler4.d(str5, str6);
                } else {
                    str = strCreateRandomNonce;
                    z2 = zShouldVerifyEndpoint;
                }
                int responseCode = connection.getResponseCode();
                String fully = inputStream2 != null ? readFully(inputStream2) : null;
                if (this.enableExtraRequestLogging) {
                    LogLevel logLevel5 = LogLevel.DEBUG;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    inputStream = inputStream2;
                    try {
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler5.d("[Purchases] - " + logLevel5.name(), "HTTP response:\\n  status code: " + responseCode + " \\n  body: " + fully);
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            if (this.enableExtraRequestLogging) {
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "HTTP request failed", th);
                            }
                            throw th;
                        } catch (Throwable th2) {
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            connection.disconnect();
                            throw th2;
                        }
                    }
                } else {
                    inputStream = inputStream2;
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                connection.disconnect();
                LogLevel logLevel6 = LogLevel.DEBUG;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    String str7 = "[Purchases] - " + logLevel6.name();
                    String str8 = String.format(NetworkStrings.API_REQUEST_COMPLETED, Arrays.copyOf(new Object[]{connection.getRequestMethod(), path, Integer.valueOf(responseCode)}, 3));
                    Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                    currentLogHandler6.d(str7, str8);
                }
                if (fully == null) {
                    throw new IOException(NetworkStrings.HTTP_RESPONSE_PAYLOAD_NULL);
                }
                if (!this.appConfig.getRunningTests() || (requestResponseListener = this.requestResponseListener) == null) {
                    str2 = str;
                    url3 = url2;
                    str3 = fully;
                    z3 = z2;
                } else {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Map<String, List<String>> headerFields = connection.getHeaderFields();
                    Intrinsics.checkNotNullExpressionValue(headerFields, "connection.headerFields");
                    for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                        String key = entry.getKey();
                        List<String> values = entry.getValue();
                        if (key != null) {
                            Intrinsics.checkNotNullExpressionValue(values, "values");
                            if (!values.isEmpty()) {
                                linkedHashMap.put(key, CollectionsKt.joinToString$default(values, ", ", null, null, 0, null, null, 62, null));
                            }
                        }
                    }
                    try {
                        URL url5 = new URL(baseURL, path);
                        String string = url5.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "fullURL.toString()");
                        String requestMethod = connection.getRequestMethod();
                        Intrinsics.checkNotNullExpressionValue(requestMethod, "connection.requestMethod");
                        str2 = str;
                        url3 = url2;
                        str3 = fully;
                        z3 = z2;
                        try {
                            try {
                                requestResponseListener.onRequestResponse(string, requestMethod, getHeaders(requestHeaders, url5, refreshETag, str2, z3, postParamsForSigningHeaderIfNeeded), jSONObjectConvertToJSON$purchases_defaultsBc8Release != null ? jSONObjectConvertToJSON$purchases_defaultsBc8Release.toString() : null, responseCode, linkedHashMap, str3);
                                responseCode = responseCode;
                            } catch (Throwable th3) {
                                th = th3;
                                responseCode = responseCode;
                                LogLevel logLevel7 = LogLevel.WARN;
                                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                    currentLogHandler7.w("[Purchases] - " + logLevel7.name(), "RequestResponseListener error: " + th.getMessage());
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        str2 = str;
                        url3 = url2;
                        str3 = fully;
                        z3 = z2;
                    }
                }
                if (z3 && RCHTTPStatusCodes.INSTANCE.isSuccessful(responseCode)) {
                    hTTPClient = this;
                    str4 = path;
                    verificationResultVerifyResponse = hTTPClient.verifyResponse(str4, connection, str3, str2, postParamsForSigningHeaderIfNeeded);
                } else {
                    hTTPClient = this;
                    str4 = path;
                    verificationResultVerifyResponse = VerificationResult.NOT_REQUESTED;
                }
                VerificationResult verificationResult = verificationResultVerifyResponse;
                if (verificationResult == VerificationResult.FAILED && (hTTPClient.signingManager.getSignatureVerificationMode() instanceof SignatureVerificationMode.Enforced)) {
                    throw new SignatureVerificationException(str4);
                }
                HttpURLConnection httpURLConnection = connection;
                boolean loadShedderHeader = hTTPClient.getLoadShedderHeader(httpURLConnection);
                ETagManager eTagManager = hTTPClient.eTagManager;
                String eTagHeader = hTTPClient.getETagHeader(httpURLConnection);
                String string2 = url3.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "fullURL.toString()");
                return eTagManager.getHTTPResultFromCacheOrBackend$purchases_defaultsBc8Release(responseCode, str3, eTagHeader, string2, refreshETag, hTTPClient.getRequestDateHeader(httpURLConnection), verificationResult, loadShedderHeader, isFallbackURL);
            } catch (Throwable th6) {
                th = th6;
                inputStream = inputStream2;
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static final boolean performRequest$canUseFallback(Endpoint endpoint, int i, List<URL> list) {
        return endpoint.getSupportsFallbackBaseURLs() && i >= 0 && i < list.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HTTPResult performRequest$default(HTTPClient hTTPClient, URL url, Endpoint endpoint, Map map, List list, Map map2, boolean z, List list2, int i, int i2, Object obj) throws JSONException, IOException {
        if ((i2 & 32) != 0) {
            z = false;
        }
        if ((i2 & 64) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        if ((i2 & 128) != 0) {
            i = 0;
        }
        return hTTPClient.performRequest(url, endpoint, map, list, map2, z, list2, i);
    }

    private static final HTTPResult performRequest$performRequestToFallbackURL(List<URL> list, int i, HTTPClient hTTPClient, final Endpoint endpoint, Map<String, ? extends Object> map, List<Pair<String, String>> list2, Map<String, String> map2, boolean z) {
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        final URL url = list.get(i);
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.HTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sbAppend = new StringBuilder().append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null)).append(' ');
                String str2 = String.format(NetworkStrings.RETRYING_CALL_WITH_FALLBACK_URL, Arrays.copyOf(new Object[]{endpoint.getPath(true), url}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return sbAppend.append(str2).toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
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
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
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
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
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
        return hTTPClient.performRequest(url, endpoint, map, list2, map2, z, list, i + 1);
    }

    private final String readFully(InputStream inputStream) throws IOException {
        return TextStreamsKt.readText(buffer(inputStream));
    }

    private final String toCurlRequest(HTTPRequest httpRequest) {
        StringBuilder sb = new StringBuilder("curl -v -X ");
        sb.append(httpRequest.getBody() == null ? ShareTarget.METHOD_GET : ShareTarget.METHOD_POST).append(" \\\n  ");
        for (Map.Entry<String, String> entry : httpRequest.getHeaders().entrySet()) {
            sb.append("-H \"").append(entry.getKey()).append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append(entry.getValue());
            sb.append("\" \\\n  ");
        }
        if (httpRequest.getBody() != null) {
            sb.append("-d '").append(httpRequest.getBody().toString()).append("' \\\n  ");
        }
        sb.append("\"").append(httpRequest.getFullURL()).append("\"");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }

    private final void trackHttpRequestPerformedIfNeeded(URL baseURL, Endpoint endpoint, Date requestStartTime, boolean callSuccessful, HTTPResult callResult, boolean isRetry, IOException connectionException) {
        VerificationResult verificationResult;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            long jBetween = DurationExtensionsKt.between(Duration.INSTANCE, requestStartTime, this.dateProvider.getNow());
            int responseCode = callSuccessful ? callResult != null ? callResult.getResponseCode() : 304 : -1;
            HTTPResult.Origin origin = callResult != null ? callResult.getOrigin() : null;
            if (callResult == null || (verificationResult = callResult.getVerificationResult()) == null) {
                verificationResult = VerificationResult.NOT_REQUESTED;
            }
            VerificationResult verificationResult2 = verificationResult;
            boolean z = callSuccessful && RCHTTPStatusCodes.INSTANCE.isSuccessful(responseCode);
            ConnectionErrorReason connectionErrorReasonFromIOException = connectionException != null ? ConnectionErrorReason.INSTANCE.fromIOException(connectionException) : null;
            String host = baseURL.getHost();
            Intrinsics.checkNotNullExpressionValue(host, "baseURL.host");
            diagnosticsTracker.m10346trackHttpRequestPerformedXzGXFE(host, endpoint, jBetween, z, responseCode, callResult != null ? callResult.getBackendErrorCode() : null, origin, verificationResult2, isRetry, connectionErrorReasonFromIOException);
        }
    }

    private final VerificationResult verifyResponse(String urlPath, URLConnection connection, String payload, String nonce, String postFieldsToSignHeader) {
        return this.signingManager.verifyResponse(urlPath, connection.getHeaderField(HTTPResult.SIGNATURE_HEADER_NAME), nonce, payload, getRequestTimeHeader(connection), getETagHeader(connection), postFieldsToSignHeader);
    }

    private final void writeFully(BufferedWriter writer, String body) throws IOException {
        writer.write(body);
        writer.flush();
    }

    public final void clearCaches() {
        this.eTagManager.clearCaches$purchases_defaultsBc8Release();
    }

    public final SigningManager getSigningManager() {
        return this.signingManager;
    }

    public final HTTPResult performRequest(URL baseURL, Endpoint endpoint, Map<String, ? extends Object> body, List<Pair<String, String>> postFieldsToSign, Map<String, String> requestHeaders, boolean refreshETag, List<URL> fallbackBaseURLs, int fallbackURLIndex) throws Throwable {
        IOException iOException;
        boolean z;
        Date date;
        HTTPResult hTTPResult;
        Endpoint endpoint2;
        IOException iOException2;
        boolean z2;
        HTTPResult hTTPResult2;
        IOException iOException3;
        boolean z3;
        HTTPResult hTTPResult3;
        Date date2;
        Endpoint endpoint3;
        URL url;
        LogHandler currentLogHandler;
        String str;
        String strInvoke;
        IOException iOException4;
        HTTPResult hTTPResultPerformRequest$performRequestToFallbackURL;
        HTTPClient hTTPClient = this;
        Intrinsics.checkNotNullParameter(baseURL, "baseURL");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        Intrinsics.checkNotNullParameter(fallbackBaseURLs, "fallbackBaseURLs");
        boolean z4 = fallbackURLIndex == 0;
        Date now = hTTPClient.dateProvider.getNow();
        HTTPTimeoutManager.RequestResult requestResult = HTTPTimeoutManager.RequestResult.OTHER_RESULT;
        try {
            HTTPResult hTTPResultPerformCall = hTTPClient.performCall(baseURL, fallbackURLIndex > 0, endpoint, body, postFieldsToSign, requestHeaders, refreshETag);
            z = true;
            if (z4 && hTTPResultPerformCall != null) {
                try {
                    if (RCHTTPStatusCodes.INSTANCE.isSuccessful(hTTPResultPerformCall.getResponseCode())) {
                        requestResult = HTTPTimeoutManager.RequestResult.SUCCESS_ON_MAIN_BACKEND;
                    }
                } catch (IOException e) {
                    iOException2 = e;
                    hTTPResult2 = hTTPResultPerformCall;
                    z2 = true;
                    endpoint2 = endpoint;
                    try {
                        try {
                            if ((iOException2 instanceof SocketTimeoutException) && z4) {
                                try {
                                    if (performRequest$canUseFallback(endpoint2, fallbackURLIndex, fallbackBaseURLs)) {
                                        requestResult = HTTPTimeoutManager.RequestResult.TIMEOUT_ON_MAIN_BACKEND_FOR_FALLBACK_SUPPORTED_ENDPOINT;
                                        iOException4 = iOException2;
                                        try {
                                            hTTPResultPerformRequest$performRequestToFallbackURL = performRequest$performRequestToFallbackURL(fallbackBaseURLs, fallbackURLIndex, this, endpoint2, body, postFieldsToSign, requestHeaders, refreshETag);
                                            hTTPClient = this;
                                        } catch (Throwable th) {
                                            th = th;
                                            hTTPClient = this;
                                            iOException = iOException4;
                                            hTTPResult = hTTPResult2;
                                            date = now;
                                            z = z2;
                                            hTTPClient.timeoutManager.recordRequestResult(requestResult);
                                            hTTPClient.trackHttpRequestPerformedIfNeeded(baseURL, endpoint, date, z, hTTPResult, refreshETag, iOException);
                                            throw th;
                                        }
                                    }
                                    hTTPResult3 = hTTPResultPerformRequest$performRequestToFallbackURL;
                                    hTTPClient.timeoutManager.recordRequestResult(requestResult);
                                    url = baseURL;
                                    endpoint3 = endpoint;
                                    z3 = refreshETag;
                                    iOException3 = iOException4;
                                    date2 = now;
                                    z = z2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    iOException4 = iOException2;
                                }
                            }
                            if (!performRequest$canUseFallback(endpoint2, fallbackURLIndex, fallbackBaseURLs)) {
                                hTTPClient = this;
                                iOException = iOException4;
                                date = now;
                                z = z2;
                                try {
                                    throw iOException;
                                } catch (Throwable th3) {
                                    th = th3;
                                    hTTPResult = hTTPResult2;
                                    hTTPClient.timeoutManager.recordRequestResult(requestResult);
                                    hTTPClient.trackHttpRequestPerformedIfNeeded(baseURL, endpoint, date, z, hTTPResult, refreshETag, iOException);
                                    throw th;
                                }
                            }
                            try {
                                hTTPResultPerformRequest$performRequestToFallbackURL = performRequest$performRequestToFallbackURL(fallbackBaseURLs, fallbackURLIndex, this, endpoint2, body, postFieldsToSign, requestHeaders, refreshETag);
                                hTTPClient = this;
                                hTTPResult3 = hTTPResultPerformRequest$performRequestToFallbackURL;
                                hTTPClient.timeoutManager.recordRequestResult(requestResult);
                                url = baseURL;
                                endpoint3 = endpoint;
                                z3 = refreshETag;
                                iOException3 = iOException4;
                                date2 = now;
                                z = z2;
                            } catch (Throwable th4) {
                                th = th4;
                                hTTPClient = this;
                                iOException = iOException4;
                                date = now;
                                z = z2;
                                hTTPResult = hTTPResult2;
                                hTTPClient.timeoutManager.recordRequestResult(requestResult);
                                hTTPClient.trackHttpRequestPerformedIfNeeded(baseURL, endpoint, date, z, hTTPResult, refreshETag, iOException);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            hTTPClient = this;
                        }
                        iOException4 = iOException2;
                    } catch (Throwable th6) {
                        th = th6;
                        iOException = iOException2;
                        date = now;
                        z = z2;
                        hTTPClient = this;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    hTTPResult = hTTPResultPerformCall;
                    date = now;
                    iOException = null;
                    hTTPClient.timeoutManager.recordRequestResult(requestResult);
                    hTTPClient.trackHttpRequestPerformedIfNeeded(baseURL, endpoint, date, z, hTTPResult, refreshETag, iOException);
                    throw th;
                }
            }
            hTTPClient.timeoutManager.recordRequestResult(requestResult);
            url = baseURL;
            z3 = refreshETag;
            hTTPResult3 = hTTPResultPerformCall;
            date2 = now;
            iOException3 = null;
            endpoint3 = endpoint;
        } catch (IOException e2) {
            endpoint2 = endpoint;
            iOException2 = e2;
            z2 = false;
            hTTPResult2 = null;
        } catch (Throwable th8) {
            th = th8;
            iOException = null;
            hTTPClient = this;
            z = false;
            date = now;
            hTTPResult = null;
        }
        hTTPClient.trackHttpRequestPerformedIfNeeded(url, endpoint3, date2, z, hTTPResult3, z3, iOException3);
        HTTPResult hTTPResult4 = hTTPResult3;
        if (hTTPResult4 != null) {
            return (RCHTTPStatusCodes.INSTANCE.isServerError(hTTPResult4.getResponseCode()) && performRequest$canUseFallback(endpoint, fallbackURLIndex, fallbackBaseURLs)) ? performRequest$performRequestToFallbackURL(fallbackBaseURLs, fallbackURLIndex, this, endpoint, body, postFieldsToSign, requestHeaders, refreshETag) : hTTPResult4;
        }
        final LogIntent logIntent = LogIntent.WARNING;
        Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.common.HTTPClient$performRequest$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " We were expecting to be able to return a cached response, but we can't find it. Retrying call with a new ETag";
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
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
                    str = "[Purchases] - " + logLevel4.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
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
                    str = "[Purchases] - " + logLevel6.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    strInvoke = function0.invoke();
                    currentLogHandler.d(str, strInvoke);
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
        return performRequest(baseURL, endpoint, body, postFieldsToSign, requestHeaders, true, fallbackBaseURLs, fallbackURLIndex);
    }
}
