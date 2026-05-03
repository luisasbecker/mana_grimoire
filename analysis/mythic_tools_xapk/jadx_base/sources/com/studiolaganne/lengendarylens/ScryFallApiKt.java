package com.studiolaganne.lengendarylens;

import com.appsflyer.AppsFlyerProperties;
import com.google.common.net.HttpHeaders;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: ScryFallApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"cacheSize", "", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "cache", "Lokhttp3/Cache;", "getCache", "()Lokhttp3/Cache;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "api", "Lcom/studiolaganne/lengendarylens/ScryfallApi;", "getApi", "()Lcom/studiolaganne/lengendarylens/ScryfallApi;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ScryFallApiKt {
    private static final ScryfallApi api;
    private static final Cache cache;
    private static final File cacheDirectory;
    public static final int cacheSize = 10485760;
    private static final OkHttpClient okHttpClient;
    private static final Retrofit retrofit;

    static {
        File file = new File(LegendaryLensApplication.INSTANCE.applicationContext().getCacheDir(), AppsFlyerProperties.HTTP_CACHE);
        cacheDirectory = file;
        Cache cache2 = new Cache(file, 10485760L);
        cache = cache2;
        OkHttpClient okHttpClientBuild = new OkHttpClient.Builder().cache(cache2).addInterceptor(new Interceptor() { // from class: com.studiolaganne.lengendarylens.ScryFallApiKt$special$$inlined$-addInterceptor$1
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                Intrinsics.checkNotNullParameter(chain, "chain");
                return chain.proceed(chain.request().newBuilder().header(HttpHeaders.USER_AGENT, "MythicTools/2.9.4 (621)").header(HttpHeaders.ACCEPT, "application/json;q=0.9,*/*;q=0.8").build());
            }
        }).build();
        okHttpClient = okHttpClientBuild;
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl("https://api.scryfall.com/").addConverterFactory(GsonConverterFactory.create()).client(okHttpClientBuild).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "build(...)");
        retrofit = retrofitBuild;
        Object objCreate = retrofitBuild.create(ScryfallApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        api = (ScryfallApi) objCreate;
    }

    public static final ScryfallApi getApi() {
        return api;
    }

    public static final Cache getCache() {
        return cache;
    }

    public static final File getCacheDirectory() {
        return cacheDirectory;
    }

    public static final OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public static final Retrofit getRetrofit() {
        return retrofit;
    }
}
