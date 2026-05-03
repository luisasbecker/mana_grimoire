package com.studiolaganne.lengendarylens;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.PeriodicWorkRequest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: TimerFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u0005H\u0014J\b\u0010(\u001a\u00020$H\u0014J\b\u0010)\u001a\u00020$H\u0004J\b\u0010*\u001a\u00020$H\u0004J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0005H\u0004J\u0010\u0010.\u001a\u00020$2\u0006\u0010-\u001a\u00020\u0005H$J\u0010\u0010/\u001a\u00020$2\u0006\u0010-\u001a\u00020\u0005H$J\b\u00100\u001a\u00020$H$J\b\u00101\u001a\u00020$H$J\b\u00102\u001a\u00020$H$R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00063"}, d2 = {"Lcom/studiolaganne/lengendarylens/TimerFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "autoStartTimeLeft", "", "getAutoStartTimeLeft", "()J", "setAutoStartTimeLeft", "(J)V", "initialTimeLeft", "getInitialTimeLeft", "setInitialTimeLeft", "timeLeft", "getTimeLeft", "setTimeLeft", "autoStartCountDownTimer", "Landroid/os/CountDownTimer;", "getAutoStartCountDownTimer", "()Landroid/os/CountDownTimer;", "setAutoStartCountDownTimer", "(Landroid/os/CountDownTimer;)V", "isAutoStartTimerRunning", "", "()Z", "setAutoStartTimerRunning", "(Z)V", "isTimerRunning", "setTimerRunning", "timerUpdateReceiver", "Landroid/content/BroadcastReceiver;", "getTimerUpdateReceiver", "()Landroid/content/BroadcastReceiver;", "setTimerUpdateReceiver", "(Landroid/content/BroadcastReceiver;)V", "onStart", "", "onStop", "startAutoStartCountdown", "initialTimeMillis", "pauseAutoStartCountdown", "startCountdown", "pauseCountdown", "formatTime", "", "timeMillis", "updateCountdownText", "updateAutoStartCountdownText", "onTimerStarted", "onTimerPaused", "onTimerExpired", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class TimerFragment extends Fragment {
    public static final int $stable = 8;
    private CountDownTimer autoStartCountDownTimer;
    private long autoStartTimeLeft = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    private long initialTimeLeft;
    private boolean isAutoStartTimerRunning;
    private boolean isTimerRunning;
    private long timeLeft;
    private BroadcastReceiver timerUpdateReceiver;

    protected final String formatTime(long timeMillis) {
        int i = (int) (timeMillis / 1000);
        int i2 = i / 3600;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf((i - (i2 * 3600)) / 60), Integer.valueOf(i % 60)}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    protected final CountDownTimer getAutoStartCountDownTimer() {
        return this.autoStartCountDownTimer;
    }

    protected final long getAutoStartTimeLeft() {
        return this.autoStartTimeLeft;
    }

    protected final long getInitialTimeLeft() {
        return this.initialTimeLeft;
    }

    protected final long getTimeLeft() {
        return this.timeLeft;
    }

    protected final BroadcastReceiver getTimerUpdateReceiver() {
        return this.timerUpdateReceiver;
    }

    /* JADX INFO: renamed from: isAutoStartTimerRunning, reason: from getter */
    protected final boolean getIsAutoStartTimerRunning() {
        return this.isAutoStartTimerRunning;
    }

    /* JADX INFO: renamed from: isTimerRunning, reason: from getter */
    protected final boolean getIsTimerRunning() {
        return this.isTimerRunning;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.studiolaganne.lengendarylens.TimerFragment.onStart.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, TimerService.TIMER_UPDATE_ACTION)) {
                    TimerFragment.this.updateCountdownText(intent.getLongExtra(TimerService.EXTRA_TIME_LEFT, 0L));
                    return;
                }
                if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, TimerService.TIMER_EXPIRED_ACTION)) {
                    TimerFragment.this.onTimerExpired();
                }
            }
        };
        this.timerUpdateReceiver = broadcastReceiver;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TimerService.TIMER_UPDATE_ACTION);
        intentFilter.addAction(TimerService.TIMER_EXPIRED_ACTION);
        LocalBroadcastManager.getInstance(requireActivity()).registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        BroadcastReceiver broadcastReceiver = this.timerUpdateReceiver;
        if (broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(requireActivity()).unregisterReceiver(broadcastReceiver);
        }
    }

    protected abstract void onTimerExpired();

    protected abstract void onTimerPaused();

    protected abstract void onTimerStarted();

    protected void pauseAutoStartCountdown() {
        CountDownTimer countDownTimer = this.autoStartCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.isAutoStartTimerRunning = false;
    }

    protected final void pauseCountdown() {
        if (this.isTimerRunning) {
            Intent intent = new Intent(getContext(), (Class<?>) TimerService.class);
            intent.setAction(TimerService.ACTION_PAUSE);
            Context context = getContext();
            if (context != null) {
                context.startService(intent);
            }
            this.isTimerRunning = false;
            onTimerPaused();
        }
    }

    protected final void setAutoStartCountDownTimer(CountDownTimer countDownTimer) {
        this.autoStartCountDownTimer = countDownTimer;
    }

    protected final void setAutoStartTimeLeft(long j) {
        this.autoStartTimeLeft = j;
    }

    protected final void setAutoStartTimerRunning(boolean z) {
        this.isAutoStartTimerRunning = z;
    }

    protected final void setInitialTimeLeft(long j) {
        this.initialTimeLeft = j;
    }

    protected final void setTimeLeft(long j) {
        this.timeLeft = j;
    }

    protected final void setTimerRunning(boolean z) {
        this.isTimerRunning = z;
    }

    protected final void setTimerUpdateReceiver(BroadcastReceiver broadcastReceiver) {
        this.timerUpdateReceiver = broadcastReceiver;
    }

    protected void startAutoStartCountdown(long initialTimeMillis) {
        CountDownTimer countDownTimer = new CountDownTimer(initialTimeMillis) { // from class: com.studiolaganne.lengendarylens.TimerFragment.startAutoStartCountdown.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.setAutoStartTimeLeft(0L);
                this.setAutoStartTimerRunning(false);
                this.updateAutoStartCountdownText(0L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                this.setAutoStartTimeLeft(millisUntilFinished);
                this.updateAutoStartCountdownText(millisUntilFinished);
            }
        };
        this.autoStartCountDownTimer = countDownTimer;
        countDownTimer.start();
        this.isAutoStartTimerRunning = true;
    }

    protected final void startCountdown() {
        PreferencesManager preferencesManager;
        Tournament currentTournament;
        if (isDetached() || getLifecycle().getState() == Lifecycle.State.DESTROYED || isRemoving() || this.isTimerRunning) {
            return;
        }
        long currentTimeLeft = this.initialTimeLeft;
        Context context = getContext();
        if (context != null && (currentTournament = (preferencesManager = new PreferencesManager(context)).getCurrentTournament()) != null) {
            if (currentTournament.getCurrentTimerActive()) {
                currentTimeLeft = currentTournament.getCurrentTimeLeft();
            } else {
                currentTournament.setCurrentTimerActive(true);
                preferencesManager.saveCurrentTournament(currentTournament);
            }
        }
        Intent intent = new Intent(getContext(), (Class<?>) TimerService.class);
        intent.setAction(TimerService.ACTION_START);
        intent.putExtra(TimerService.EXTRA_TIME_MILLIS, currentTimeLeft);
        Context context2 = getContext();
        if (context2 != null) {
            context2.startForegroundService(intent);
        }
        onTimerStarted();
        this.isTimerRunning = true;
    }

    protected abstract void updateAutoStartCountdownText(long timeMillis);

    protected abstract void updateCountdownText(long timeMillis);
}
