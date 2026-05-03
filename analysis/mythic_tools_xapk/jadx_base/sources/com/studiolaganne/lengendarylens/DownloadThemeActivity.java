package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: DownloadThemeActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J0\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0002J\u001e\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/studiolaganne/lengendarylens/DownloadThemeActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "<init>", "()V", "theme", "Lcom/studiolaganne/lengendarylens/MTTheme;", "getTheme", "()Lcom/studiolaganne/lengendarylens/MTTheme;", "setTheme", "(Lcom/studiolaganne/lengendarylens/MTTheme;)V", "byCode", "", "getByCode", "()Z", "setByCode", "(Z)V", "fromQRCode", "getFromQRCode", "setFromQRCode", "promoTropyhId", "", "getPromoTropyhId", "()Ljava/lang/Integer;", "setPromoTropyhId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "downloadTheme", "themeId", "themeSku", "", "platform", "receipt", "progressListener", "Lcom/studiolaganne/lengendarylens/ProgressListener;", "unzipTheme", "context", "Landroid/content/Context;", "inputStream", "Ljava/io/InputStream;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DownloadThemeActivity extends BaseActivity {
    public static final int $stable = 8;
    private boolean byCode;
    private boolean fromQRCode;
    private Integer promoTropyhId;
    private MTTheme theme;

    private final void downloadTheme(int themeId, final String themeSku, String platform, String receipt, final ProgressListener progressListener) {
        final PreferencesManager preferencesManager = new PreferencesManager(this);
        ((MTApi) new Retrofit.Builder().baseUrl("https://api.mythic.tools/").addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient.Builder().dns(new Dns() { // from class: com.studiolaganne.lengendarylens.DownloadThemeActivity$downloadTheme$ipv4OnlyDns$1
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
        }).connectTimeout(10L, TimeUnit.SECONDS).readTimeout(15L, TimeUnit.MINUTES).writeTimeout(15L, TimeUnit.MINUTES).cache(MTApiKt.getMt_cache()).addInterceptor(new ProgressInterceptor(progressListener)).addInterceptor(new Interceptor() { // from class: com.studiolaganne.lengendarylens.DownloadThemeActivity$downloadTheme$$inlined$-addInterceptor$1
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) throws NoSuchAlgorithmException {
                Intrinsics.checkNotNullParameter(chain, "chain");
                String strValueOf = String.valueOf(System.currentTimeMillis());
                String strSha256 = MTApiKt.sha256("mythic_sloot+/" + strValueOf + ".AIzaSyA-8p8r9VS10L8vw2iJHN-bfMEUXTsxp7c/+cihtym_tools!");
                String string = preferencesManager.getString(PreferencesManager.GOOGLE_TOKEN, "");
                String string2 = preferencesManager.getString(PreferencesManager.FIREBASE_TOKEN, "");
                Request.Builder builderAddHeader = chain.request().newBuilder().addHeader("x-api-key", "AIzaSyBSEcgdWo0mOif56fGXztJO7tCsmRY1MX0").addHeader("x-mythic-timestamp", strValueOf).addHeader("x-mythic-device", Constants.PLATFORM).addHeader("x-mythic-signature", strSha256);
                String appVersion = MTApiKt.getAppVersion();
                Request.Builder builderAddHeader2 = builderAddHeader.addHeader("x-app-version", appVersion != null ? appVersion : "").addHeader("x-app-build", MTApiKt.getAppBuildNumber());
                String osVersion = MTApiKt.getOsVersion();
                Intrinsics.checkNotNullExpressionValue(osVersion, "<get-osVersion>(...)");
                Request.Builder builderAddHeader3 = builderAddHeader2.addHeader("x-app-osversion", osVersion).addHeader("x-app-device", MTApiKt.getDeviceName()).addHeader("x-app-locale", MTApiKt.getLocale());
                if (string.length() > 0) {
                    builderAddHeader3.addHeader("x-mythic-google-token", string);
                }
                String str = string2;
                if (str.length() > 0) {
                    builderAddHeader3.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + StringsKt.trimEnd(StringsKt.trim((CharSequence) str).toString(), AbstractJsonLexerKt.COMMA));
                }
                return chain.proceed(builderAddHeader3.build());
            }
        }).build()).build().create(MTApi.class)).downloadTheme(themeId, platform, receipt).enqueue(new Callback<ResponseBody>() { // from class: com.studiolaganne.lengendarylens.DownloadThemeActivity.downloadTheme.1
            @Override // retrofit2.Callback
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (DownloadThemeActivity.this.isDestroyed() || DownloadThemeActivity.this.isFinishing()) {
                    return;
                }
                ProgressListener progressListener2 = progressListener;
                String message = t.getMessage();
                if (message == null) {
                    message = "Unknown error occurred";
                }
                progressListener2.onDownloadFailed(message);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) throws Throwable {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (DownloadThemeActivity.this.isDestroyed() || DownloadThemeActivity.this.isFinishing()) {
                    return;
                }
                if (!response.isSuccessful()) {
                    progressListener.onDownloadFailed("Download failed with code: " + response.code());
                    return;
                }
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody != null) {
                    DownloadThemeActivity downloadThemeActivity = DownloadThemeActivity.this;
                    String str = themeSku;
                    ProgressListener progressListener2 = progressListener;
                    InputStream inputStreamByteStream = responseBodyBody.byteStream();
                    downloadThemeActivity.unzipTheme(downloadThemeActivity, inputStreamByteStream, str);
                    inputStreamByteStream.close();
                    progressListener2.onDownloadComplete();
                }
            }
        });
    }

    static final Unit onCreate$lambda$3(DownloadThemeActivity downloadThemeActivity) {
        downloadThemeActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final Unit onCreate$lambda$4(DownloadThemeActivity downloadThemeActivity, Ref.ObjectRef objectRef) {
        PreferencesManager preferencesManager = new PreferencesManager(downloadThemeActivity);
        preferencesManager.setString(PreferencesManager.CREATOR_CODE, (String) objectRef.element);
        PreferencesManager.syncCurrentSettingsToAPI$default(preferencesManager, null, 1, null);
        downloadThemeActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void unzipTheme$lambda$1$0$0$0(ImageView imageView) {
        imageView.setClipToOutline(true);
        imageView.setOutlineProvider(new RoundedOutlineProvider(imageView.getWidth() * 0.07f));
    }

    public final boolean getByCode() {
        return this.byCode;
    }

    public final boolean getFromQRCode() {
        return this.fromQRCode;
    }

    public final Integer getPromoTropyhId() {
        return this.promoTropyhId;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final MTTheme getTheme() {
        return this.theme;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [T, java.lang.String] */
    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        final DownloadThemeActivity downloadThemeActivity;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_theme);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        MTTheme mTTheme = (MTTheme) new Gson().fromJson(getIntent().getStringExtra("theme"), MTTheme.class);
        this.byCode = getIntent().getBooleanExtra("byCode", false);
        boolean booleanExtra = getIntent().getBooleanExtra("fromQRCode", false);
        this.fromQRCode = booleanExtra;
        Object obj = null;
        if (booleanExtra) {
            Integer numValueOf = Integer.valueOf(getIntent().getIntExtra("withTrophyId", -1));
            this.promoTropyhId = numValueOf;
            if (numValueOf != null && numValueOf.intValue() == -1) {
                this.promoTropyhId = null;
            }
        }
        View viewFindViewById = findViewById(R.id.trophyImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.medalUnlocked);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById2;
        imageView.setVisibility(4);
        textView.setVisibility(4);
        Integer num = this.promoTropyhId;
        if (num != null) {
            int iIntValue = num.intValue();
            DownloadThemeActivity downloadThemeActivity2 = this;
            Iterator<T> it = new PreferencesManager(downloadThemeActivity2).getCurrentUserTrophies().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((MTTrophy) next).getId() == iIntValue) {
                    obj = next;
                    break;
                }
            }
            MTTrophy mTTrophy = (MTTrophy) obj;
            if (mTTrophy != null) {
                imageView.setVisibility(0);
                String image_url = mTTrophy.getImage_url();
                if (image_url != null) {
                    if (image_url.length() > 0) {
                        Intrinsics.checkNotNull(Glide.with((FragmentActivity) this).load(image_url).placeholder(R.drawable.medal_outline).into(imageView));
                    } else {
                        imageView.setImageDrawable(ContextCompat.getDrawable(downloadThemeActivity2, R.drawable.medal_outline));
                    }
                }
                textView.setVisibility(0);
            }
        }
        View viewFindViewById3 = findViewById(R.id.themeUnlocked);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        TextView textView2 = (TextView) viewFindViewById3;
        if (this.fromQRCode) {
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(4);
        }
        if (mTTheme != null) {
            this.theme = mTTheme;
            objectRef.element = mTTheme.getGoogleproductid();
            ((TextView) findViewById(R.id.catchphraseTextView)).setText(mTTheme.getCatchphrase());
            View viewFindViewById4 = findViewById(R.id.themeImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            CachedImageView cachedImageView = (CachedImageView) viewFindViewById4;
            cachedImageView.clearBackground();
            String bannerurl = mTTheme.getBannerurl();
            if (bannerurl != null) {
                cachedImageView.reset();
                cachedImageView.loadImage(bannerurl);
            }
            String googleproductid = mTTheme.getGoogleproductid();
            String str = new PreferencesManager(this).getAllThemeTokens().get(googleproductid);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
            progressBar.setProgress(0);
            Log.d("DownloadThemeActivity", "Theme code: " + googleproductid);
            Log.d("DownloadThemeActivity", "Theme token: " + str);
            downloadThemeActivity = this;
            downloadThemeActivity.downloadTheme(mTTheme.getId(), mTTheme.getGoogleproductid(), Constants.PLATFORM, str == null ? "" : str, new DownloadThemeActivity$onCreate$2$2(progressBar, this));
        } else {
            downloadThemeActivity = this;
            Log.e("DownloadThemeActivity", "No theme");
            downloadThemeActivity.finish();
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) downloadThemeActivity.findViewById(R.id.closeButtonLayout);
        Intrinsics.checkNotNull(constraintLayout);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.DownloadThemeActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DownloadThemeActivity.onCreate$lambda$3(this.f$0);
            }
        });
        ConstraintLayout constraintLayout2 = (ConstraintLayout) downloadThemeActivity.findViewById(R.id.applyButtonLayout);
        Intrinsics.checkNotNull(constraintLayout2);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.DownloadThemeActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DownloadThemeActivity.onCreate$lambda$4(this.f$0, objectRef);
            }
        });
    }

    public final void setByCode(boolean z) {
        this.byCode = z;
    }

    public final void setFromQRCode(boolean z) {
        this.fromQRCode = z;
    }

    public final void setPromoTropyhId(Integer num) {
        this.promoTropyhId = num;
    }

    public final void setTheme(MTTheme mTTheme) {
        this.theme = mTTheme;
    }

    public final boolean unzipTheme(Context context, InputStream inputStream, String themeSku) throws Throwable {
        ZipInputStream zipInputStream;
        MTTheme mTTheme;
        List<String> unlockedPlaymats;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(themeSku, "themeSku");
        if (isFinishing() || isDestroyed()) {
            return false;
        }
        ((ImageView) findViewById(R.id.checkmarkDownload)).setVisibility(0);
        ((TextView) findViewById(R.id.unpackingText)).setVisibility(0);
        ZipInputStream zipInputStream2 = null;
        File file = new File(context.getExternalFilesDir(null), "themes");
        if (!file.exists() && !file.mkdirs()) {
            Log.e("Unzip", "Failed to create theme directory");
            return false;
        }
        Log.d("Unzip", "Created themes directory: " + file.getAbsolutePath());
        File file2 = new File(file, themeSku);
        if (!file2.exists() && !file2.mkdirs()) {
            Log.e("Unzip", "Failed to create theme subfolder");
            return false;
        }
        Log.d("Unzip", "Unzipping theme to: " + file2.getAbsolutePath());
        byte[] bArr = new byte[1024];
        try {
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(inputStream));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                String name = nextEntry.getName();
                File file3 = new File(file2, name);
                Intrinsics.checkNotNull(name);
                if (!StringsKt.startsWith$default(name, "_", false, 2, (Object) null)) {
                    Log.d("Unzip", "Processing file: " + file3.getAbsolutePath());
                    if (!nextEntry.isDirectory()) {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
                        try {
                            BufferedOutputStream bufferedOutputStream2 = bufferedOutputStream;
                            while (true) {
                                int i = zipInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                bufferedOutputStream2.write(bArr, 0, i);
                            }
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(bufferedOutputStream, null);
                            Log.i("Unzip", "Unzipped file: " + file3.getAbsolutePath());
                        } finally {
                        }
                    } else if (!file3.isDirectory() && !file3.mkdirs()) {
                        Log.e("Unzip", "Failed to create directory " + file3.getAbsolutePath());
                        try {
                            zipInputStream.close();
                            return false;
                        } catch (IOException e2) {
                            Log.e("Unzip", "Error closing ZipInputStream: " + e2.getMessage(), e2);
                            return false;
                        }
                    }
                }
            }
            zipInputStream.closeEntry();
            try {
                if (!SkinManager.INSTANCE.getInstance().isSkinValid(this, themeSku)) {
                    Log.e("Unzip", "Unzipped theme is not valid");
                    try {
                        zipInputStream.close();
                        return false;
                    } catch (IOException e3) {
                        Log.e("Unzip", "Error closing ZipInputStream: " + e3.getMessage(), e3);
                        return false;
                    }
                }
                SkinDefinition skinDefinition = SkinManager.INSTANCE.getInstance().getSkinDefinition(this, themeSku);
                if (skinDefinition != null && (unlockedPlaymats = skinDefinition.getUnlockedPlaymats()) != null && !unlockedPlaymats.isEmpty()) {
                    PreferencesManager preferencesManager = new PreferencesManager(this);
                    Iterator<String> it = unlockedPlaymats.iterator();
                    while (it.hasNext()) {
                        preferencesManager.addUnlockedPlaymat(themeSku + com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + it.next());
                    }
                    Bitmap imageFromSkin = SkinManager.INSTANCE.getInstance().getImageFromSkin(this, themeSku, (String) CollectionsKt.first((List) unlockedPlaymats));
                    if (imageFromSkin != null) {
                        View viewFindViewById = findViewById(R.id.playmatImage);
                        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                        final ImageView imageView = (ImageView) viewFindViewById;
                        View viewFindViewById2 = findViewById(R.id.playmatUnlocked);
                        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                        imageView.setImageBitmap(imageFromSkin);
                        imageView.setVisibility(0);
                        ((TextView) viewFindViewById2).setVisibility(0);
                        imageView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.DownloadThemeActivity$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                DownloadThemeActivity.unzipTheme$lambda$1$0$0$0(imageView);
                            }
                        });
                    }
                }
                ((ImageView) findViewById(R.id.unpackCheckmark)).setVisibility(0);
                PreferencesManager preferencesManager2 = new PreferencesManager(this);
                preferencesManager2.setBoolean(PreferencesManager.REFRESH_THEMES, true);
                preferencesManager2.addThemePurchased(themeSku);
                MTTheme mTTheme2 = this.theme;
                if (mTTheme2 != null) {
                    Map<String, Integer> mutableMap = MapsKt.toMutableMap(preferencesManager2.getAllThemeVersions());
                    mutableMap.put(themeSku, Integer.valueOf(mTTheme2.getVersion()));
                    preferencesManager2.saveAllThemeVersions(mutableMap);
                }
                if (this.byCode && (mTTheme = this.theme) != null) {
                    List<MTTheme> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager2.getLocalThemesCache());
                    List<MTTheme> list = mutableList;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it2 = list.iterator();
                        while (it2.hasNext()) {
                            if (((MTTheme) it2.next()).getId() == mTTheme.getId()) {
                                break;
                            }
                        }
                    }
                    mutableList.add(mTTheme);
                    preferencesManager2.setBoolean(PreferencesManager.REFRESH_THEMES, true);
                    preferencesManager2.saveLocalThemesCache(mutableList);
                }
                ((ConstraintLayout) findViewById(R.id.closeButtonLayout)).setVisibility(0);
                ((ConstraintLayout) findViewById(R.id.applyButtonLayout)).setVisibility(0);
                try {
                    zipInputStream.close();
                    return true;
                } catch (IOException e4) {
                    Log.e("Unzip", "Error closing ZipInputStream: " + e4.getMessage(), e4);
                    return true;
                }
            } catch (Exception e5) {
                Log.e("Unzip", "Error checking if skin is valid: " + e5.getMessage(), e5);
                try {
                    zipInputStream.close();
                } catch (IOException e6) {
                    Log.e("Unzip", "Error closing ZipInputStream: " + e6.getMessage(), e6);
                }
                return false;
            }
        } catch (IOException e7) {
            e = e7;
            zipInputStream2 = zipInputStream;
            Log.e("Unzip", "Error during unzipping: " + e.getMessage(), e);
            try {
                if (zipInputStream2 != null) {
                    zipInputStream2.close();
                }
            } catch (IOException e8) {
                Log.e("Unzip", "Error closing ZipInputStream: " + e8.getMessage(), e8);
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            zipInputStream2 = zipInputStream;
            try {
                if (zipInputStream2 != null) {
                    zipInputStream2.close();
                }
            } catch (IOException e9) {
                Log.e("Unzip", "Error closing ZipInputStream: " + e9.getMessage(), e9);
            }
            throw th;
        }
    }
}
