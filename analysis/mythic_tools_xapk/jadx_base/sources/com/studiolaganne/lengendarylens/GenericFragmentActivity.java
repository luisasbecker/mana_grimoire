package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.codeless.internal.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GenericFragmentActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"Lcom/studiolaganne/lengendarylens/GenericFragmentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getStatusBarHeight", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GenericFragmentActivity extends AppCompatActivity {
    public static final int $stable = 8;

    private final int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", Constants.PLATFORM);
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    static final Unit onCreate$lambda$1(GenericFragmentActivity genericFragmentActivity, FrameLayout frameLayout, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        if (genericFragmentActivity.getSupportFragmentManager().findFragmentById(frameLayout.getId()) instanceof OnBackPressedCallback) {
            return Unit.INSTANCE;
        }
        genericFragmentActivity.finish();
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(View.generateViewId());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setPadding(0, getStatusBarHeight(), 0, 0);
        setContentView(frameLayout);
        OnBackPressedDispatcherKt.addCallback$default(getOnBackPressedDispatcher(), this, false, new Function1() { // from class: com.studiolaganne.lengendarylens.GenericFragmentActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GenericFragmentActivity.onCreate$lambda$1(this.f$0, frameLayout, (OnBackPressedCallback) obj);
            }
        }, 2, null);
        String stringExtra = getIntent().getStringExtra("fragment_class");
        Bundle bundleExtra = getIntent().getBundleExtra("fragment_args");
        if (stringExtra == null || savedInstanceState != null) {
            return;
        }
        try {
            Object objNewInstance = Class.forName(stringExtra).newInstance();
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) objNewInstance;
            if (bundleExtra != null) {
                fragment.setArguments(bundleExtra);
            }
            getSupportFragmentManager().beginTransaction().replace(frameLayout.getId(), fragment).commit();
        } catch (Exception unused) {
            finish();
        }
    }
}
