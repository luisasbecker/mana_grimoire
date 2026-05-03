package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0015J\b\u0010\b\u001a\u00020\u0005H\u0014¨\u0006\t"}, d2 = {"Lcom/studiolaganne/lengendarylens/WebActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WebActivity extends BaseActivity {
    public static final int $stable = BaseActivity.$stable;

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        View viewFindViewById = findViewById(R.id.webview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        WebView webView = (WebView) viewFindViewById;
        String stringExtra = getIntent().getStringExtra("url");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        if (stringExtra == null) {
            stringExtra = "";
        }
        webView.loadUrl(stringExtra);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        finish();
    }
}
