package com.studiolaganne.lengendarylens;

import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Cache;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u001a\u000e\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006\u001a\u0006\u0010C\u001a\u00020\u0006\u001a\n\u0010D\u001a\u00020E*\u00020F\u001a\u0006\u0010G\u001a\u00020H\u001a\u0006\u0010M\u001a\u00020N\"\u0019\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\"\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b\"\u001c\u0010\r\u001a\n \u0002*\u0004\u0018\u00010\u00060\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00100\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000\"\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104\"\u0011\u00105\u001a\u000206¢\u0006\b\n\u0000\u001a\u0004\b7\u00108\"\u0011\u00109\u001a\u00020:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<\"\u0011\u0010=\u001a\u00020>¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@\"\u000e\u0010A\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010B\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u001e\u0010J\u001a\u00020H2\u0006\u0010I\u001a\u00020H@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bK\u0010L*\"\u0010\u001c\"\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u001d2\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u001d¨\u0006O"}, d2 = {"packageInfo", "Landroid/content/pm/PackageInfo;", "kotlin.jvm.PlatformType", "getPackageInfo", "()Landroid/content/pm/PackageInfo;", "appVersion", "", "getAppVersion", "()Ljava/lang/String;", "appBuildNumber", "getAppBuildNumber", "deviceName", "getDeviceName", "osVersion", "getOsVersion", AndroidContextPlugin.LOCALE_KEY, "getLocale", "RESULT_LOSS", "", "RESULT_WIN", "RESULT_CONCEDE", "RESULT_DRAW", "PRIVACY_TYPE_PRIVATE", "PRIVACY_TYPE_SHARED", "PRIVACY_TYPE_UNLISTED", "PRIVACY_TYPE_PUBLIC", "CIRCLE_AUTO_UPDATE_TYPE_ALL_FRIENDS", "CIRCLE_AUTO_UPDATE_TYPE_ALL_PLAYGROUPS", "MTCardsValues", "", "Lcom/studiolaganne/lengendarylens/MTCardsValue;", "ID_RECENT", "ID_WANTS", "ID_TRADES", "ID_BULK", "TYPE_LIST", "TYPE_BINDER", "TYPE_BOX", "TYPE_DECK", "TYPE_SIDEBOARD", "TYPE_MAYBEBOARD", "FLAG_COMMANDER", "FLAG_PARTNER", "FLAG_SIGNATURE_SPELL", "FLAG_PARTNER_SIGNATURE_SPELL", "FLAG_COMPANION", SigningManager.POST_PARAMS_ALGORITHM, "input", "mt_cacheSize", "mt_cacheDirectory", "Ljava/io/File;", "getMt_cacheDirectory", "()Ljava/io/File;", "mt_cache", "Lokhttp3/Cache;", "getMt_cache", "()Lokhttp3/Cache;", "ipv4OnlyDns", "Lokhttp3/Dns;", "getIpv4OnlyDns", "()Lokhttp3/Dns;", "mt_okHttpClient", "Lokhttp3/OkHttpClient;", "getMt_okHttpClient", "()Lokhttp3/OkHttpClient;", "PREPROD_URL", "PROD_URL", "getEffectiveBaseUrl", "toRequestBody", "Lokhttp3/RequestBody;", "Lcom/studiolaganne/lengendarylens/MTEditListBody;", "createMtApi", "Lcom/studiolaganne/lengendarylens/MTApi;", "value", "mtApi", "getMtApi", "()Lcom/studiolaganne/lengendarylens/MTApi;", "rebuildMtApi", "", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MTApiKt {
    public static final String CIRCLE_AUTO_UPDATE_TYPE_ALL_FRIENDS = "all_friends";
    public static final String CIRCLE_AUTO_UPDATE_TYPE_ALL_PLAYGROUPS = "all_playgroups";
    public static final int FLAG_COMMANDER = 1;
    public static final int FLAG_COMPANION = 5;
    public static final int FLAG_PARTNER = 2;
    public static final int FLAG_PARTNER_SIGNATURE_SPELL = 4;
    public static final int FLAG_SIGNATURE_SPELL = 3;
    public static final int ID_BULK = 4;
    public static final int ID_RECENT = 1;
    public static final int ID_TRADES = 3;
    public static final int ID_WANTS = 2;
    public static final String PREPROD_URL = "https://api.mythic.tools/preprod/";
    public static final String PRIVACY_TYPE_PRIVATE = "private";
    public static final String PRIVACY_TYPE_PUBLIC = "public";
    public static final String PRIVACY_TYPE_SHARED = "shared";
    public static final String PRIVACY_TYPE_UNLISTED = "unlisted";
    public static final String PROD_URL = "https://api.mythic.tools/";
    public static final int RESULT_CONCEDE = 2;
    public static final int RESULT_DRAW = 3;
    public static final int RESULT_LOSS = 0;
    public static final int RESULT_WIN = 1;
    public static final int TYPE_BINDER = 1;
    public static final int TYPE_BOX = 2;
    public static final int TYPE_DECK = 3;
    public static final int TYPE_LIST = 0;
    public static final int TYPE_MAYBEBOARD = 5;
    public static final int TYPE_SIDEBOARD = 4;
    private static final String appBuildNumber;
    private static final String appVersion;
    private static final String deviceName;
    private static final Dns ipv4OnlyDns;
    private static final String locale;
    private static MTApi mtApi = null;
    private static final Cache mt_cache;
    private static final File mt_cacheDirectory;
    public static final int mt_cacheSize = 10485760;
    private static final OkHttpClient mt_okHttpClient;
    private static final String osVersion;
    private static final PackageInfo packageInfo;

    static {
        PackageInfo packageInfo2 = LegendaryLensApplication.INSTANCE.applicationContext().getPackageManager().getPackageInfo(LegendaryLensApplication.INSTANCE.applicationContext().getPackageName(), 0);
        packageInfo = packageInfo2;
        appVersion = packageInfo2.versionName;
        appBuildNumber = Build.VERSION.SDK_INT >= 28 ? String.valueOf(packageInfo2.getLongVersionCode()) : String.valueOf(packageInfo2.versionCode);
        deviceName = StringsKt.trim((CharSequence) (Build.MANUFACTURER + " " + Build.MODEL)).toString();
        osVersion = Build.VERSION.RELEASE;
        locale = new PreferencesManager(LegendaryLensApplication.INSTANCE.applicationContext()).getDeviceLanguage();
        File file = new File(LegendaryLensApplication.INSTANCE.applicationContext().getCacheDir(), "mt_cache");
        mt_cacheDirectory = file;
        Cache cache = new Cache(file, 10485760L);
        mt_cache = cache;
        Dns dns = new Dns() { // from class: com.studiolaganne.lengendarylens.MTApiKt$ipv4OnlyDns$1
            @Override // okhttp3.Dns
            public List<InetAddress> lookup(String hostname) throws UnknownHostException {
                Intrinsics.checkNotNullParameter(hostname, "hostname");
                InetAddress[] allByName = InetAddress.getAllByName(hostname);
                Intrinsics.checkNotNullExpressionValue(allByName, "getAllByName(...)");
                ArrayList arrayList = new ArrayList();
                for (InetAddress inetAddress : allByName) {
                    if (inetAddress instanceof Inet4Address) {
                        arrayList.add(inetAddress);
                    }
                }
                return arrayList;
            }
        };
        ipv4OnlyDns = dns;
        mt_okHttpClient = new OkHttpClient.Builder().cache(cache).dns(dns).connectTimeout(10L, TimeUnit.SECONDS).readTimeout(600L, TimeUnit.SECONDS).writeTimeout(600L, TimeUnit.SECONDS).addInterceptor(new Interceptor() { // from class: com.studiolaganne.lengendarylens.MTApiKt$special$$inlined$-addInterceptor$1
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) throws NoSuchAlgorithmException {
                Intrinsics.checkNotNullParameter(chain, "chain");
                String strValueOf = String.valueOf(System.currentTimeMillis());
                String strSha256 = MTApiKt.sha256("mythic_sloot+/" + strValueOf + ".AIzaSyA-8p8r9VS10L8vw2iJHN-bfMEUXTsxp7c/+cihtym_tools!");
                PreferencesManager preferencesManager = new PreferencesManager(LegendaryLensApplication.INSTANCE.applicationContext());
                String string = preferencesManager.getString(PreferencesManager.GOOGLE_TOKEN, "");
                String string2 = preferencesManager.getString(PreferencesManager.FIREBASE_TOKEN, "");
                Request.Builder builderAddHeader = chain.request().newBuilder().addHeader("x-api-key", "AIzaSyBSEcgdWo0mOif56fGXztJO7tCsmRY1MX0").addHeader("x-mythic-timestamp", strValueOf).addHeader("x-mythic-device", Constants.PLATFORM).addHeader("x-mythic-signature", strSha256);
                String appVersion2 = MTApiKt.getAppVersion();
                Request.Builder builderAddHeader2 = builderAddHeader.addHeader("x-app-version", appVersion2 != null ? appVersion2 : "").addHeader("x-app-build", MTApiKt.getAppBuildNumber());
                String osVersion2 = MTApiKt.getOsVersion();
                Intrinsics.checkNotNullExpressionValue(osVersion2, "<get-osVersion>(...)");
                Request.Builder builderAddHeader3 = builderAddHeader2.addHeader("x-app-osversion", osVersion2).addHeader("x-app-device", MTApiKt.getDeviceName()).addHeader("x-app-locale", MTApiKt.getLocale());
                if (string.length() > 0) {
                    builderAddHeader3.addHeader("x-mythic-google-token", string);
                }
                String str = string2;
                if (str.length() > 0) {
                    builderAddHeader3.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + StringsKt.trimEnd(StringsKt.trim((CharSequence) str).toString(), AbstractJsonLexerKt.COMMA));
                }
                return chain.proceed(builderAddHeader3.build());
            }
        }).addInterceptor(new TokenRefreshInterceptor(LegendaryLensApplication.INSTANCE.applicationContext())).addInterceptor(new LoggingInterceptor()).build();
        mtApi = createMtApi();
    }

    public static final MTApi createMtApi() {
        Object objCreate = new Retrofit.Builder().baseUrl(getEffectiveBaseUrl()).addConverterFactory(GsonConverterFactory.create()).client(mt_okHttpClient).build().create(MTApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (MTApi) objCreate;
    }

    public static final String getAppBuildNumber() {
        return appBuildNumber;
    }

    public static final String getAppVersion() {
        return appVersion;
    }

    public static final String getDeviceName() {
        return deviceName;
    }

    public static final String getEffectiveBaseUrl() {
        PreferencesManager preferencesManager = new PreferencesManager(LegendaryLensApplication.INSTANCE.applicationContext());
        if (preferencesManager.getBoolean(PreferencesManager.CUSTOM_API_HOST_ENABLED, false)) {
            return "http://" + preferencesManager.getString(PreferencesManager.CUSTOM_API_HOST, "127.0.0.1:80") + DomExceptionUtils.SEPARATOR;
        }
        return preferencesManager.getBoolean(PreferencesManager.FORCE_PREPROD_API, false) ? PREPROD_URL : "https://api.mythic.tools/";
    }

    public static final Dns getIpv4OnlyDns() {
        return ipv4OnlyDns;
    }

    public static final String getLocale() {
        return locale;
    }

    public static final MTApi getMtApi() {
        return mtApi;
    }

    public static final Cache getMt_cache() {
        return mt_cache;
    }

    public static final File getMt_cacheDirectory() {
        return mt_cacheDirectory;
    }

    public static final OkHttpClient getMt_okHttpClient() {
        return mt_okHttpClient;
    }

    public static final String getOsVersion() {
        return osVersion;
    }

    public static final PackageInfo getPackageInfo() {
        return packageInfo;
    }

    public static final void rebuildMtApi() {
        mtApi = createMtApi();
    }

    public static final String sha256(String input) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(input, "input");
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        byte[] bytes = input.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics.checkNotNull(bArrDigest);
        return ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.studiolaganne.lengendarylens.MTApiKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MTApiKt.sha256$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence sha256$lambda$0(byte b) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final RequestBody toRequestBody(MTEditListBody mTEditListBody) {
        Intrinsics.checkNotNullParameter(mTEditListBody, "<this>");
        JsonObject asJsonObject = new Gson().toJsonTree(mTEditListBody).getAsJsonObject();
        if (mTEditListBody.getIncludeNullColor()) {
            asJsonObject.add("color", JsonNull.INSTANCE);
        }
        RequestBody.Companion companion = RequestBody.INSTANCE;
        String string = asJsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return companion.create(string, MediaType.INSTANCE.parse("application/json"));
    }
}
