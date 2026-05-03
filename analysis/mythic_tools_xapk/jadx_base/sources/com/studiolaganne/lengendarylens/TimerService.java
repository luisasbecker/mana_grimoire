package com.studiolaganne.lengendarylens;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: TimerService.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\"\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0010H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/TimerService;", "Landroid/app/Service;", "<init>", "()V", "countDownTimer", "Landroid/os/CountDownTimer;", "prefs", "Lcom/studiolaganne/lengendarylens/PreferencesManager;", "timeLeft", "", "isTimerRunning", "", "mediaPlayer", "Landroid/media/MediaPlayer;", "isTimerFinished", "onCreate", "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "startTimer", "timeMillis", "playAlarmSound", "stopAlarm", "fadeOutMediaPlayer", "pauseTimer", "onBind", "Landroid/os/IBinder;", "createNotification", "Landroid/app/Notification;", "createNotificationChannel", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TimerService extends Service {
    public static final String ACTION_PAUSE = "TimerServiceActionPause";
    public static final String ACTION_START = "TimerServiceActionStart";
    public static final String ACTION_STOP_ALARM = "TimerServiceActionStopAlarm";
    private static final String CHANNEL_ID = "timer_service_channel";
    public static final String EXTRA_TIME_LEFT = "extra_time_left";
    public static final String EXTRA_TIME_MILLIS = "ExtraTimeMillis";
    private static final int NOTIFICATION_ID = 1;
    public static final String TIMER_EXPIRED_ACTION = "com.studiolaganne.legendarylens.TIMER_EXPIRED";
    public static final String TIMER_UPDATE_ACTION = "com.studiolaganne.legendarylens.TIMER_UPDATE";
    private CountDownTimer countDownTimer;
    private boolean isTimerFinished;
    private boolean isTimerRunning;
    private MediaPlayer mediaPlayer;
    private PreferencesManager prefs;
    private long timeLeft;
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public final Notification createNotification() {
        TimerService timerService = this;
        PendingIntent activity = PendingIntent.getActivity(timerService, 0, new Intent(timerService, (Class<?>) MainActivity.class), 201326592);
        Intent intent = new Intent(timerService, (Class<?>) TimerService.class);
        intent.setAction(ACTION_STOP_ALARM);
        PendingIntent service = PendingIntent.getService(timerService, 0, intent, 201326592);
        Intent intent2 = new Intent(timerService, (Class<?>) TimerService.class);
        intent2.setAction(ACTION_STOP_ALARM);
        NotificationCompat.Builder deleteIntent = new NotificationCompat.Builder(timerService, CHANNEL_ID).setContentTitle(getResources().getString(R.string.timer_service_title)).setContentText(getResources().getString(R.string.timer_service_body)).setSmallIcon(R.drawable.white_icon).setContentIntent(activity).setOngoing(true).setDeleteIntent(PendingIntent.getService(timerService, 1, intent2, 201326592));
        Intrinsics.checkNotNullExpressionValue(deleteIntent, "setDeleteIntent(...)");
        if (this.isTimerFinished) {
            deleteIntent.setContentTitle(getResources().getString(R.string.timer_service_finished_title)).setContentText(getResources().getString(R.string.timer_service_finished_body)).setOngoing(false).addAction(R.drawable.ic_stop, "Stop Alarm", service);
        }
        Notification notificationBuild = deleteIntent.build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        return notificationBuild;
    }

    private final void createNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Timer Service Channel", 2);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private final void fadeOutMediaPlayer(final MediaPlayer mediaPlayer) {
        final Handler handler = new Handler(Looper.getMainLooper());
        final Ref.IntRef intRef = new Ref.IntRef();
        final int i = 20;
        intRef.element = 20;
        final long j = 100;
        handler.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.TimerService$fadeOutMediaPlayer$fadeOutRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                if (intRef.element <= 0) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    return;
                }
                float f = intRef.element / i;
                mediaPlayer.setVolume(f, f);
                intRef.element--;
                handler.postDelayed(this, j);
            }
        });
    }

    private final void pauseTimer() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.isTimerRunning = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playAlarmSound() throws IOException {
        Uri defaultUri = RingtoneManager.getDefaultUri(4);
        if (defaultUri == null) {
            defaultUri = RingtoneManager.getDefaultUri(2);
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(this, defaultUri);
        mediaPlayer.setLooping(false);
        mediaPlayer.prepare();
        mediaPlayer.start();
        this.mediaPlayer = mediaPlayer;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.studiolaganne.lengendarylens.TimerService$startTimer$1] */
    private final void startTimer(long timeMillis) {
        if (this.isTimerRunning) {
            return;
        }
        this.countDownTimer = new CountDownTimer(timeMillis) { // from class: com.studiolaganne.lengendarylens.TimerService.startTimer.1
            @Override // android.os.CountDownTimer
            public void onFinish() throws IOException {
                this.isTimerRunning = false;
                this.isTimerFinished = true;
                this.timeLeft = 0L;
                Intent intent = new Intent(TimerService.TIMER_EXPIRED_ACTION);
                intent.putExtra(TimerService.EXTRA_TIME_LEFT, this.timeLeft);
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
                PreferencesManager preferencesManager = this.prefs;
                PreferencesManager preferencesManager2 = null;
                if (preferencesManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("prefs");
                    preferencesManager = null;
                }
                Tournament currentTournament = preferencesManager.getCurrentTournament();
                if (currentTournament != null) {
                    TimerService timerService = this;
                    currentTournament.setCurrentTimeLeft(0L);
                    PreferencesManager preferencesManager3 = timerService.prefs;
                    if (preferencesManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                    } else {
                        preferencesManager2 = preferencesManager3;
                    }
                    preferencesManager2.saveCurrentTournament(currentTournament);
                }
                this.playAlarmSound();
                ((NotificationManager) this.getSystemService(NotificationManager.class)).notify(1, this.createNotification());
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                this.timeLeft = millisUntilFinished;
                PreferencesManager preferencesManager = this.prefs;
                PreferencesManager preferencesManager2 = null;
                if (preferencesManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("prefs");
                    preferencesManager = null;
                }
                Tournament currentTournament = preferencesManager.getCurrentTournament();
                if (currentTournament != null) {
                    TimerService timerService = this;
                    currentTournament.setCurrentTimeLeft(timerService.timeLeft);
                    PreferencesManager preferencesManager3 = timerService.prefs;
                    if (preferencesManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                    } else {
                        preferencesManager2 = preferencesManager3;
                    }
                    preferencesManager2.saveCurrentTournament(currentTournament);
                }
                Intent intent = new Intent(TimerService.TIMER_UPDATE_ACTION);
                intent.putExtra(TimerService.EXTRA_TIME_LEFT, this.timeLeft);
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
            }
        }.start();
        this.isTimerRunning = true;
    }

    private final void stopAlarm() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        this.mediaPlayer = null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.prefs = new PreferencesManager(this);
        createNotificationChannel();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != -233870480) {
                if (iHashCode != -230553124) {
                    if (iHashCode == 1791175657 && action.equals(ACTION_STOP_ALARM)) {
                        stopAlarm();
                        stopForeground(1);
                        stopSelf();
                    }
                } else if (action.equals(ACTION_START)) {
                    long longExtra = intent.getLongExtra(EXTRA_TIME_MILLIS, 0L);
                    this.timeLeft = longExtra;
                    this.isTimerFinished = false;
                    startForeground(1, createNotification());
                    startTimer(longExtra);
                }
            } else if (action.equals(ACTION_PAUSE)) {
                pauseTimer();
                stopForeground(1);
                stopSelf();
            }
        }
        return 1;
    }
}
