package androidx.camera.featurecombinationquery;

import android.hardware.camera2.params.OutputConfiguration;
import androidx.camera.featurecombinationquery.SessionParametersLegacy;
import androidx.media3.muxer.AacWriter$$ExternalSyntheticBackport0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SessionConfigurationLegacy {
    private final List<OutputConfiguration> mOutputConfigs;
    private final SessionParametersLegacy mSessionParams;

    public static final class Builder {
        private final ArrayList<OutputConfiguration> mOutputConfigs = new ArrayList<>();
        private SessionParametersLegacy mSessionParams = new SessionParametersLegacy.Builder().build();

        public Builder addOutputConfiguration(OutputConfiguration outputConfiguration) {
            this.mOutputConfigs.add(outputConfiguration);
            return this;
        }

        public Builder addOutputConfigurations(Collection<OutputConfiguration> collection) {
            this.mOutputConfigs.addAll(collection);
            return this;
        }

        public SessionConfigurationLegacy build() {
            return new SessionConfigurationLegacy(AacWriter$$ExternalSyntheticBackport0.m((Collection) this.mOutputConfigs), this.mSessionParams);
        }

        public Builder setSessionParameters(SessionParametersLegacy sessionParametersLegacy) {
            this.mSessionParams = sessionParametersLegacy;
            return this;
        }
    }

    private SessionConfigurationLegacy(List<OutputConfiguration> list, SessionParametersLegacy sessionParametersLegacy) {
        this.mOutputConfigs = list;
        this.mSessionParams = sessionParametersLegacy;
    }

    public List<OutputConfiguration> getOutputConfigurations() {
        return this.mOutputConfigs;
    }

    public SessionParametersLegacy getSessionParameters() {
        return this.mSessionParams;
    }
}
