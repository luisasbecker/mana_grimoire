package com.studiolaganne.lengendarylens;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BaseActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0010H\u0014J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0014J\u001a\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "receiver", "Landroid/content/BroadcastReceiver;", "toastLayout", "Landroid/view/View;", "toastMessage", "Landroid/widget/TextView;", "toastTitle", "gestureDetector", "Landroidx/core/view/GestureDetectorCompat;", "currentNotificationIntent", "Landroid/content/Intent;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "checkAndRefreshTokenIfNeeded", "onDestroy", "showToastNotification", "messageTitle", "", "messageContent", "handleNotificationTap", "hideToast", "SwipeGestureListener", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BaseActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private Intent currentNotificationIntent;
    private GestureDetectorCompat gestureDetector;
    private BroadcastReceiver receiver;
    private View toastLayout;
    private TextView toastMessage;
    private TextView toastTitle;

    /* JADX INFO: compiled from: BaseActivity.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J*\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/BaseActivity$SwipeGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "<init>", "(Lcom/studiolaganne/lengendarylens/BaseActivity;)V", "SWIPE_THRESHOLD", "", "SWIPE_VELOCITY_THRESHOLD", "onDown", "", "e", "Landroid/view/MotionEvent;", "onSingleTapUp", "onFling", "e1", "e2", "velocityX", "", "velocityY", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class SwipeGestureListener extends GestureDetector.SimpleOnGestureListener {
        private final int SWIPE_THRESHOLD = 100;
        private final int SWIPE_VELOCITY_THRESHOLD = 100;

        public SwipeGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Intrinsics.checkNotNullParameter(e2, "e2");
            if (e1 == null) {
                return false;
            }
            BaseActivity baseActivity = BaseActivity.this;
            float y = e2.getY() - e1.getY();
            if (Math.abs(y) <= this.SWIPE_THRESHOLD || Math.abs(velocityY) <= this.SWIPE_VELOCITY_THRESHOLD || y >= 0.0f) {
                return false;
            }
            baseActivity.hideToast();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            BaseActivity.this.handleNotificationTap();
            BaseActivity.this.hideToast();
            return true;
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.BaseActivity$checkAndRefreshTokenIfNeeded$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.studiolaganne.lengendarylens.BaseActivity$checkAndRefreshTokenIfNeeded$1", f = "BaseActivity.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FirebaseTokenManager.INSTANCE.refreshToken(BaseActivity.this, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void checkAndRefreshTokenIfNeeded() {
        BaseActivity baseActivity = this;
        if (!new PreferencesManager(baseActivity).hasValidUser() || TokenValidator.INSTANCE.isTokenValid(baseActivity)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void handleNotificationTap() {
        String stringExtra;
        MTPlaygroup currentPlaygroup;
        Intent intent = this.currentNotificationIntent;
        if (intent == null || (stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE)) == null) {
            return;
        }
        switch (stringExtra.hashCode()) {
            case -1814490512:
                if (!stringExtra.equals(PreferencesManager.MSG_TYPE_SHARED_COLLECTION_INVITE)) {
                    return;
                }
                break;
            case -1208568283:
                if (!stringExtra.equals(PreferencesManager.MSG_TYPE_SHARED_COLLECTION_REJECTED)) {
                    return;
                }
                break;
            case -517166289:
                if (!stringExtra.equals(PreferencesManager.MSG_TYPE_UNSHARE_COLLECTION_ACCEPTED)) {
                    return;
                }
                break;
            case 610173073:
                if (!stringExtra.equals(PreferencesManager.MSG_TYPE_UNSHARE_COLLECTION_INVITE)) {
                    return;
                }
                break;
            case 1020862470:
                if (!stringExtra.equals(PreferencesManager.MSG_TYPE_UNSHARE_COLLECTION_REJECTED)) {
                    return;
                }
                break;
            case 1548370254:
                if (!stringExtra.equals(PreferencesManager.MSG_TYPE_SHARED_COLLECTION_ACCEPTED)) {
                    return;
                }
                break;
            case 1964028755:
                if (stringExtra.equals(PreferencesManager.MSG_TYPE_PLAYGROUP_MESSAGE)) {
                    PlaygroupDetailsActivity playgroupDetailsActivity = this instanceof PlaygroupDetailsActivity ? (PlaygroupDetailsActivity) this : null;
                    boolean zAreEqual = false;
                    if (playgroupDetailsActivity != null && (currentPlaygroup = playgroupDetailsActivity.getCurrentPlaygroup()) != null) {
                        intent.getStringExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE);
                        zAreEqual = Intrinsics.areEqual(intent.getStringExtra("message_playgroupId"), String.valueOf(currentPlaygroup.getId()));
                    }
                    if (zAreEqual) {
                        return;
                    }
                    String stringExtra2 = intent.getStringExtra("message_playgroupId");
                    Intent intent2 = new Intent(this, (Class<?>) PlaygroupDetailsActivity.class);
                    Integer intOrNull = stringExtra2 != null ? StringsKt.toIntOrNull(stringExtra2) : null;
                    if (intOrNull != null) {
                        intent2.putExtra("playgroupId", intOrNull.intValue());
                        startActivity(intent2);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
        startActivity(new Intent(this, (Class<?>) SharedCollectionsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideToast() {
        final View view = this.toastLayout;
        if (view != null) {
            view.animate().translationY(-view.getHeight()).setInterpolator(new AccelerateInterpolator()).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.studiolaganne.lengendarylens.BaseActivity$hideToast$1$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    super.onAnimationEnd(animation);
                    view.setVisibility(8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToastNotification(String messageTitle, String messageContent) {
        if (this.toastLayout == null) {
            View viewInflate = LayoutInflater.from(this).inflate(R.layout.toast_notification, (ViewGroup) findViewById(android.R.id.content), false);
            this.toastLayout = viewInflate;
            this.toastMessage = viewInflate != null ? (TextView) viewInflate.findViewById(R.id.toast_message) : null;
            View view = this.toastLayout;
            this.toastTitle = view != null ? (TextView) view.findViewById(R.id.toast_title) : null;
            View view2 = this.toastLayout;
            if (view2 != null) {
                view2.setElevation(1000.0f);
            }
            ((ViewGroup) findViewById(android.R.id.content)).addView(this.toastLayout);
            View view3 = this.toastLayout;
            if (view3 != null) {
                view3.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.BaseActivity$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view4, MotionEvent motionEvent) {
                        return BaseActivity.showToastNotification$lambda$1(this.f$0, view4, motionEvent);
                    }
                });
            }
        }
        TextView textView = this.toastMessage;
        if (textView != null) {
            textView.setText(messageContent);
        }
        if (messageTitle != null) {
            TextView textView2 = this.toastTitle;
            if (textView2 != null) {
                textView2.setText(messageTitle);
            }
        } else {
            TextView textView3 = this.toastTitle;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        View view4 = this.toastLayout;
        if (view4 != null) {
            view4.setVisibility(0);
            view4.setTranslationY(-view4.getHeight());
            view4.animate().translationY(12.0f).setInterpolator(new DecelerateInterpolator()).setDuration(300L).setListener(new BaseActivity$showToastNotification$5$1(this, view4));
        }
    }

    static final boolean showToastNotification$lambda$1(BaseActivity baseActivity, View view, MotionEvent motionEvent) {
        GestureDetectorCompat gestureDetectorCompat = baseActivity.gestureDetector;
        if (gestureDetectorCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
            gestureDetectorCompat = null;
        }
        return gestureDetectorCompat.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        Intrinsics.checkNotNullParameter(newBase, "newBase");
        super.attachBaseContext(LocaleHelper.INSTANCE.setLocale(newBase));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.receiver = new BroadcastReceiver() { // from class: com.studiolaganne.lengendarylens.BaseActivity.onCreate.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                MTPlaygroup currentPlaygroup;
                String stringExtra = intent != null ? intent.getStringExtra("message_title") : null;
                String stringExtra2 = intent != null ? intent.getStringExtra("message_notification") : null;
                if (stringExtra2 != null) {
                    BaseActivity baseActivity = BaseActivity.this;
                    PlaygroupDetailsActivity playgroupDetailsActivity = baseActivity instanceof PlaygroupDetailsActivity ? (PlaygroupDetailsActivity) baseActivity : null;
                    boolean z = false;
                    if (playgroupDetailsActivity != null && (currentPlaygroup = playgroupDetailsActivity.getCurrentPlaygroup()) != null) {
                        String stringExtra3 = intent.getStringExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE);
                        String stringExtra4 = intent.getStringExtra("message_playgroupId");
                        if (Intrinsics.areEqual(stringExtra3, PreferencesManager.MSG_TYPE_PLAYGROUP_MESSAGE) && Intrinsics.areEqual(stringExtra4, String.valueOf(currentPlaygroup.getId())) && playgroupDetailsActivity.isShowingMessages()) {
                            z = true;
                        }
                    }
                    baseActivity.currentNotificationIntent = intent;
                    if (!z) {
                        if (stringExtra != null) {
                            baseActivity.showToastNotification(stringExtra, stringExtra2);
                        } else {
                            baseActivity.showToastNotification(null, stringExtra2);
                        }
                    }
                    new PreferencesManager(baseActivity).setForcedApiUpdate(true);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter(PreferencesManager.MESSAGE_INTENT);
        BaseActivity baseActivity = this;
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(baseActivity);
        BroadcastReceiver broadcastReceiver = this.receiver;
        if (broadcastReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receiver");
            broadcastReceiver = null;
        }
        localBroadcastManager.registerReceiver(broadcastReceiver, intentFilter);
        this.gestureDetector = new GestureDetectorCompat(baseActivity, new SwipeGestureListener());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        BroadcastReceiver broadcastReceiver = this.receiver;
        if (broadcastReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("receiver");
            broadcastReceiver = null;
        }
        localBroadcastManager.unregisterReceiver(broadcastReceiver);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        checkAndRefreshTokenIfNeeded();
    }
}
