package androidx.camera.featurecombinationquery;

import android.hardware.camera2.CaptureRequest;
import androidx.media3.muxer.AacWriter$$ExternalSyntheticBackport0;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SessionParametersLegacy {
    private final Map<CaptureRequest.Key<?>, Object> mKeyVal;

    public static final class Builder {
        private final HashMap<CaptureRequest.Key<?>, Object> mKeyVal = new HashMap<>();

        public SessionParametersLegacy build() {
            return new SessionParametersLegacy(AacWriter$$ExternalSyntheticBackport0.m((Map) this.mKeyVal));
        }

        public <T> Builder set(CaptureRequest.Key<T> key, T t) {
            this.mKeyVal.put(key, t);
            return this;
        }
    }

    private SessionParametersLegacy(Map<CaptureRequest.Key<?>, Object> map) {
        this.mKeyVal = map;
    }

    public Map<CaptureRequest.Key<?>, Object> asMap() {
        return Collections.unmodifiableMap(this.mKeyVal);
    }

    public <T> T get(CaptureRequest.Key<T> key) {
        return (T) this.mKeyVal.get(key);
    }

    public Set<CaptureRequest.Key<?>> getKeys() {
        return AacWriter$$ExternalSyntheticBackport0.m9751m((Collection) this.mKeyVal.keySet());
    }
}
