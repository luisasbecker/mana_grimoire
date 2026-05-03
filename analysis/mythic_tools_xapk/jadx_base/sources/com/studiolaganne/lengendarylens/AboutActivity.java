package com.studiolaganne.lengendarylens;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: AboutActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0019\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u001cH\u0014J\b\u0010 \u001a\u00020\u001cH\u0002J/\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\rH\u0002¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0002J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010.\u001a\u00020\u001cH\u0002J\u0010\u0010/\u001a\u00020%2\u0006\u00100\u001a\u000201H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u00062"}, d2 = {"Lcom/studiolaganne/lengendarylens/AboutActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "<init>", "()V", "networkStatusDot", "Landroid/widget/TextView;", "networkStatusText", "apiStatusDot", "apiStatusText", "versionLabel", "versionCode", "", "versionName", "", "tapCount", "firstTapTime", "", "twoFingerTapCount", "twoFingerFirstTapTime", "TAP_TIMEOUT", "REQUIRED_TAPS", "maxPointersInGesture", "handler", "Landroid/os/Handler;", "statusRunnable", "com/studiolaganne/lengendarylens/AboutActivity$statusRunnable$1", "Lcom/studiolaganne/lengendarylens/AboutActivity$statusRunnable$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "updateStatuses", "setStatusIndicator", "dot", Constants.ScionAnalytics.PARAM_LABEL, "connected", "", "text", "(Landroid/widget/TextView;Landroid/widget/TextView;Ljava/lang/Boolean;Ljava/lang/String;)V", "handleSingleFingerTap", "handleTwoFingerTap", "toggleEnvironment", "prefs", "Lcom/studiolaganne/lengendarylens/PreferencesManager;", "showCustomHostDialog", "updateVersionLabel", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AboutActivity extends BaseActivity {
    public static final int $stable = 8;
    private TextView apiStatusDot;
    private TextView apiStatusText;
    private long firstTapTime;
    private int maxPointersInGesture;
    private TextView networkStatusDot;
    private TextView networkStatusText;
    private int tapCount;
    private long twoFingerFirstTapTime;
    private int twoFingerTapCount;
    private int versionCode;
    private TextView versionLabel;
    private String versionName = "";
    private final long TAP_TIMEOUT = 30000;
    private final int REQUIRED_TAPS = 10;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final AboutActivity$statusRunnable$1 statusRunnable = new Runnable() { // from class: com.studiolaganne.lengendarylens.AboutActivity$statusRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            this.this$0.updateStatuses();
            this.this$0.handler.postDelayed(this, 30000L);
        }
    };

    private final void handleSingleFingerTap() {
        PreferencesManager preferencesManager = new PreferencesManager(this);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null) {
            return;
        }
        if (currentUser.getId() == 1 || currentUser.getId() == 2 || currentUser.getId() == 11 || currentUser.getId() == 52861) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.firstTapTime > this.TAP_TIMEOUT) {
                this.tapCount = 0;
            }
            int i = this.tapCount;
            if (i == 0) {
                this.firstTapTime = jCurrentTimeMillis;
            }
            int i2 = i + 1;
            this.tapCount = i2;
            if (i2 >= this.REQUIRED_TAPS) {
                this.tapCount = 0;
                toggleEnvironment(preferencesManager);
            }
        }
    }

    private final void handleTwoFingerTap() {
        PreferencesManager preferencesManager = new PreferencesManager(this);
        MTUser currentUser = preferencesManager.getCurrentUser();
        if (currentUser == null) {
            return;
        }
        if (currentUser.getId() == 1 || currentUser.getId() == 2 || currentUser.getId() == 11 || currentUser.getId() == 52861) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.twoFingerFirstTapTime > this.TAP_TIMEOUT) {
                this.twoFingerTapCount = 0;
            }
            int i = this.twoFingerTapCount;
            if (i == 0) {
                this.twoFingerFirstTapTime = jCurrentTimeMillis;
            }
            int i2 = i + 1;
            this.twoFingerTapCount = i2;
            if (i2 >= this.REQUIRED_TAPS) {
                this.twoFingerTapCount = 0;
                showCustomHostDialog(preferencesManager);
            }
        }
    }

    static final Unit onCreate$lambda$0(AboutActivity aboutActivity) {
        Breadcrumbs.INSTANCE.leaveBreadcrumb("email_button");
        AboutActivity aboutActivity2 = aboutActivity;
        FirebaseAnalytics.getInstance(aboutActivity2).logEvent("email_button", null);
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("mailto:support@studiomythic.com"));
        intent.putExtra("android.intent.extra.SUBJECT", "Mythic Tools Android v" + aboutActivity.versionName + " (" + aboutActivity.versionCode + ")");
        try {
            aboutActivity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(aboutActivity2, aboutActivity.getString(R.string.no_email_app), 1).show();
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$1(AboutActivity aboutActivity) {
        Breadcrumbs.INSTANCE.leaveBreadcrumb("instagram_button");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(aboutActivity);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("instagram_button", null);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.instagram.com/mythic_tools/"));
        intent.setPackage("com.instagram.android");
        try {
            aboutActivity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            intent.setPackage(null);
            aboutActivity.startActivity(Intent.createChooser(intent, "Open with"));
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$2(AboutActivity aboutActivity) {
        Breadcrumbs.INSTANCE.leaveBreadcrumb("discord_button");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(aboutActivity);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("discord_button", null);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://discord.gg/F5ygngNM4g"));
        intent.setPackage("com.discord");
        try {
            aboutActivity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            intent.setPackage(null);
            aboutActivity.startActivity(Intent.createChooser(intent, "Open with"));
        }
        return Unit.INSTANCE;
    }

    static final boolean onCreate$lambda$3(AboutActivity aboutActivity, View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            aboutActivity.maxPointersInGesture = 1;
        } else if (actionMasked == 1) {
            int i = aboutActivity.maxPointersInGesture;
            if (i == 1) {
                aboutActivity.handleSingleFingerTap();
            } else if (i == 2) {
                aboutActivity.handleTwoFingerTap();
            }
            aboutActivity.maxPointersInGesture = 0;
        } else if (actionMasked == 5) {
            aboutActivity.maxPointersInGesture = Math.max(aboutActivity.maxPointersInGesture, motionEvent.getPointerCount());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setStatusIndicator(TextView dot, TextView label, Boolean connected, String text) {
        int i;
        if (Intrinsics.areEqual((Object) connected, (Object) true)) {
            i = R.color.winner_green;
        } else if (Intrinsics.areEqual((Object) connected, (Object) false)) {
            i = R.color.loser_red;
        } else {
            if (connected != null) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.color.draw_orange;
        }
        dot.setTextColor(ContextCompat.getColor(this, i));
        label.setText(text);
    }

    private final void showCustomHostDialog(final PreferencesManager prefs) {
        if (prefs.getBoolean(PreferencesManager.CUSTOM_API_HOST_ENABLED, false)) {
            new AlertDialog.Builder(this).setTitle("Custom API Host").setMessage("Custom host is active. Disable it?").setPositiveButton("Disable", new DialogInterface.OnClickListener() { // from class: com.studiolaganne.lengendarylens.AboutActivity$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AboutActivity.showCustomHostDialog$lambda$0(prefs, this, dialogInterface, i);
                }
            }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
            return;
        }
        AboutActivity aboutActivity = this;
        final EditText editText = new EditText(aboutActivity);
        editText.setHint("127.0.0.1:80");
        editText.setText(prefs.getString(PreferencesManager.CUSTOM_API_HOST, "127.0.0.1:80"));
        editText.setInputType(1);
        new AlertDialog.Builder(aboutActivity).setTitle("Custom API Host").setMessage("Enter IP:port (HTTP will be used)").setView(editText).setPositiveButton("Apply", new DialogInterface.OnClickListener() { // from class: com.studiolaganne.lengendarylens.AboutActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AboutActivity.showCustomHostDialog$lambda$2(editText, prefs, this, dialogInterface, i);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    static final void showCustomHostDialog$lambda$0(PreferencesManager preferencesManager, AboutActivity aboutActivity, DialogInterface dialogInterface, int i) {
        preferencesManager.setBoolean(PreferencesManager.CUSTOM_API_HOST_ENABLED, false);
        MTApiKt.rebuildMtApi();
        aboutActivity.updateVersionLabel();
        aboutActivity.updateStatuses();
        Toast.makeText(aboutActivity, "Custom host disabled", 1).show();
    }

    static final void showCustomHostDialog$lambda$2(EditText editText, PreferencesManager preferencesManager, AboutActivity aboutActivity, DialogInterface dialogInterface, int i) {
        String string = editText.getText().toString();
        if (string.length() == 0) {
            string = "127.0.0.1:80";
        }
        String str = string;
        preferencesManager.setString(PreferencesManager.CUSTOM_API_HOST, str);
        preferencesManager.setBoolean(PreferencesManager.CUSTOM_API_HOST_ENABLED, true);
        MTApiKt.rebuildMtApi();
        aboutActivity.updateVersionLabel();
        aboutActivity.updateStatuses();
        Toast.makeText(aboutActivity, "Custom host: http://" + str + DomExceptionUtils.SEPARATOR, 1).show();
    }

    private final void toggleEnvironment(PreferencesManager prefs) {
        boolean z = prefs.getBoolean(PreferencesManager.FORCE_PREPROD_API, false);
        prefs.setBoolean(PreferencesManager.FORCE_PREPROD_API, !z);
        MTApiKt.rebuildMtApi();
        updateVersionLabel();
        updateStatuses();
        Toast.makeText(this, !z ? "Switched to PREPROD" : "Switched to PROD", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStatuses() {
        TextView textView = this.networkStatusDot;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkStatusDot");
            textView = null;
        }
        TextView textView3 = this.networkStatusText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkStatusText");
            textView3 = null;
        }
        String string = getString(R.string.status_checking);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        setStatusIndicator(textView, textView3, null, string);
        TextView textView4 = this.apiStatusDot;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiStatusDot");
            textView4 = null;
        }
        TextView textView5 = this.apiStatusText;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiStatusText");
            textView5 = null;
        }
        String string2 = getString(R.string.status_checking);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        setStatusIndicator(textView4, textView5, null, string2);
        boolean zIsNetworkAvailable = NetworkHelper.INSTANCE.isNetworkAvailable(this);
        String str = getString(R.string.status_network) + ": " + getString(zIsNetworkAvailable ? R.string.status_connected : R.string.status_disconnected);
        TextView textView6 = this.networkStatusDot;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkStatusDot");
            textView6 = null;
        }
        TextView textView7 = this.networkStatusText;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkStatusText");
        } else {
            textView2 = textView7;
        }
        setStatusIndicator(textView6, textView2, Boolean.valueOf(zIsNetworkAvailable), str);
        MTApiKt.getMtApi().ping().enqueue(new Callback<MTResponse>() { // from class: com.studiolaganne.lengendarylens.AboutActivity.updateStatuses.1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Log.e("AboutActivity", "API ping failed: " + t.getMessage(), t);
                String str2 = AboutActivity.this.getString(R.string.status_api) + ": " + AboutActivity.this.getString(R.string.status_disconnected);
                AboutActivity aboutActivity = AboutActivity.this;
                TextView textView8 = aboutActivity.apiStatusDot;
                TextView textView9 = null;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("apiStatusDot");
                    textView8 = null;
                }
                TextView textView10 = AboutActivity.this.apiStatusText;
                if (textView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("apiStatusText");
                } else {
                    textView9 = textView10;
                }
                aboutActivity.setStatusIndicator(textView8, textView9, false, str2);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTResponse> call, Response<MTResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                boolean zIsSuccessful = response.isSuccessful();
                String str2 = AboutActivity.this.getString(R.string.status_api) + ": " + AboutActivity.this.getString(zIsSuccessful ? R.string.status_connected : R.string.status_disconnected);
                AboutActivity aboutActivity = AboutActivity.this;
                TextView textView8 = aboutActivity.apiStatusDot;
                TextView textView9 = null;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("apiStatusDot");
                    textView8 = null;
                }
                TextView textView10 = AboutActivity.this.apiStatusText;
                if (textView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("apiStatusText");
                } else {
                    textView9 = textView10;
                }
                aboutActivity.setStatusIndicator(textView8, textView9, Boolean.valueOf(zIsSuccessful), str2);
            }
        });
    }

    private final void updateVersionLabel() {
        PreferencesManager preferencesManager = new PreferencesManager(this);
        TextView textView = null;
        String str = preferencesManager.getBoolean(PreferencesManager.CUSTOM_API_HOST_ENABLED, false) ? " (CUSTOM: " + preferencesManager.getString(PreferencesManager.CUSTOM_API_HOST, "127.0.0.1:80") + ")" : (preferencesManager.getBoolean(PreferencesManager.FORCE_PREPROD_API, false) || StringsKt.contains$default((CharSequence) "https://api.mythic.tools/", (CharSequence) "preprod", false, 2, (Object) null)) ? " (PREPROD)" : "";
        TextView textView2 = this.versionLabel;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("versionLabel");
        } else {
            textView = textView2;
        }
        textView.setText("Mythic Tools v" + this.versionName + " (Build " + this.versionCode + ")" + str);
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(getString(R.string.about));
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayOptions(2, 2);
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.setDisplayHomeAsUpEnabled(true);
        }
        View childAt = toolbar.getChildAt(0);
        TextView textView = null;
        TextView textView2 = childAt instanceof TextView ? (TextView) childAt : null;
        if (textView2 != null) {
            textView2.setTypeface(getResources().getFont(R.font.baloo_da_2_bold));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.emailLayout);
        Intrinsics.checkNotNull(linearLayout);
        ViewExtensionsKt.setOnClickWithFade(linearLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.AboutActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AboutActivity.onCreate$lambda$0(this.f$0);
            }
        });
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.instagramLayout);
        Intrinsics.checkNotNull(linearLayout2);
        ViewExtensionsKt.setOnClickWithFade(linearLayout2, new Function0() { // from class: com.studiolaganne.lengendarylens.AboutActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AboutActivity.onCreate$lambda$1(this.f$0);
            }
        });
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.discordLayout);
        Intrinsics.checkNotNull(linearLayout3);
        ViewExtensionsKt.setOnClickWithFade(linearLayout3, new Function0() { // from class: com.studiolaganne.lengendarylens.AboutActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AboutActivity.onCreate$lambda$2(this.f$0);
            }
        });
        View viewFindViewById = findViewById(R.id.versionText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.versionLabel = (TextView) viewFindViewById;
        TextView textView3 = (TextView) findViewById(R.id.systemText);
        PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        this.versionCode = Build.VERSION.SDK_INT >= 28 ? (int) packageInfo.getLongVersionCode() : packageInfo.versionCode;
        String str = packageInfo.versionName;
        if (str == null) {
            str = "";
        }
        this.versionName = str;
        updateVersionLabel();
        textView3.setText("Android " + Build.VERSION.RELEASE + " (SDK " + Build.VERSION.SDK_INT + ")");
        TextView textView4 = this.versionLabel;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("versionLabel");
        } else {
            textView = textView4;
        }
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.AboutActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return AboutActivity.onCreate$lambda$3(this.f$0, view, motionEvent);
            }
        });
        View viewFindViewById2 = findViewById(R.id.networkStatusDot);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.networkStatusDot = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.networkStatusText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.networkStatusText = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.apiStatusDot);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.apiStatusDot = (TextView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.apiStatusText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.apiStatusText = (TextView) viewFindViewById5;
        this.handler.post(this.statusRunnable);
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacks(this.statusRunnable);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }
}
