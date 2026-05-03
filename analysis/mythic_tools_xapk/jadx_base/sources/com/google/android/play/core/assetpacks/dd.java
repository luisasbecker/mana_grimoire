package com.google.android.play.core.assetpacks;

import androidx.camera.video.AudioStats;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class dd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f271a = new HashMap();

    dd() {
    }

    final synchronized double a(String str) {
        Double d = (Double) this.f271a.get(str);
        if (d == null) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return d.doubleValue();
    }

    final synchronized double b(String str, dv dvVar) {
        double d;
        co coVar = (co) dvVar;
        d = (((double) coVar.f) + 1.0d) / ((double) coVar.g);
        this.f271a.put(str, Double.valueOf(d));
        return d;
    }

    final synchronized void c(String str) {
        this.f271a.put(str, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
    }
}
