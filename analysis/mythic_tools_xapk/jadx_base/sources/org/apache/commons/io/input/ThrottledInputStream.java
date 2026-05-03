package org.apache.commons.io.input;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.function.IOIntConsumer;
import org.apache.commons.io.input.ProxyInputStream;

/* JADX INFO: loaded from: classes7.dex */
public final class ThrottledInputStream extends CountingInputStream {
    private final double maxBytesPerSecond;
    private final long startTime;
    private Duration totalSleepDuration;

    public static class Builder extends ProxyInputStream.AbstractBuilder<ThrottledInputStream, Builder> {
        private double maxBytesPerSecond = Double.MAX_VALUE;

        /* JADX WARN: Multi-variable type inference failed */
        private Builder setMaxBytesPerSecond(double d) {
            if (d <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                throw new IllegalArgumentException("Bandwidth " + d + " must be > 0.");
            }
            this.maxBytesPerSecond = d;
            return (Builder) asThis();
        }

        @Override // org.apache.commons.io.function.IOSupplier
        public ThrottledInputStream get() throws IOException {
            return new ThrottledInputStream(this);
        }

        @Override // org.apache.commons.io.input.ProxyInputStream.AbstractBuilder
        public /* bridge */ /* synthetic */ IOIntConsumer getAfterRead() {
            return super.getAfterRead();
        }

        double getMaxBytesPerSecond() {
            return this.maxBytesPerSecond;
        }

        @Override // org.apache.commons.io.input.ProxyInputStream.AbstractBuilder
        public /* bridge */ /* synthetic */ AbstractStreamBuilder setAfterRead(IOIntConsumer iOIntConsumer) {
            return super.setAfterRead(iOIntConsumer);
        }

        /* JADX WARN: Multi-variable type inference failed */
        Builder setMaxBytes(long j, Duration duration) {
            setMaxBytesPerSecond((((Duration) Objects.requireNonNull(duration, TypedValues.TransitionType.S_DURATION)).toMillis() / 1000.0d) * j);
            return (Builder) asThis();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder setMaxBytes(long j, ChronoUnit chronoUnit) {
            setMaxBytes(j, chronoUnit.getDuration());
            return (Builder) asThis();
        }

        public void setMaxBytesPerSecond(long j) {
            setMaxBytesPerSecond(j);
        }
    }

    private ThrottledInputStream(Builder builder) throws IOException {
        super(builder);
        this.startTime = System.currentTimeMillis();
        this.totalSleepDuration = Duration.ZERO;
        if (builder.maxBytesPerSecond <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            throw new IllegalArgumentException("Bandwidth " + builder.maxBytesPerSecond + " is invalid.");
        }
        this.maxBytesPerSecond = builder.maxBytesPerSecond;
    }

    public static Builder builder() {
        return new Builder();
    }

    private long getBytesPerSecond() {
        long jCurrentTimeMillis = (System.currentTimeMillis() - this.startTime) / 1000;
        return jCurrentTimeMillis == 0 ? getByteCount() : getByteCount() / jCurrentTimeMillis;
    }

    private long getSleepMillis() {
        return toSleepMillis(getByteCount(), System.currentTimeMillis() - this.startTime, this.maxBytesPerSecond);
    }

    private void throttle() throws InterruptedIOException {
        long sleepMillis = getSleepMillis();
        if (sleepMillis > 0) {
            this.totalSleepDuration = this.totalSleepDuration.plus(sleepMillis, ChronoUnit.MILLIS);
            try {
                TimeUnit.MILLISECONDS.sleep(sleepMillis);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException("Thread aborted");
            }
        }
    }

    static long toSleepMillis(long j, long j2, double d) {
        if (j <= 0 || d <= AudioStats.AUDIO_AMPLITUDE_NONE || j2 == 0) {
            return 0L;
        }
        long j3 = (long) (((j / d) * 1000.0d) - j2);
        if (j3 <= 0) {
            return 0L;
        }
        return j3;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream
    protected void beforeRead(int i) throws IOException {
        throttle();
    }

    double getMaxBytesPerSecond() {
        return this.maxBytesPerSecond;
    }

    Duration getTotalSleepDuration() {
        return this.totalSleepDuration;
    }

    public String toString() {
        return "ThrottledInputStream[bytesRead=" + getByteCount() + ", maxBytesPerSec=" + this.maxBytesPerSecond + ", bytesPerSec=" + getBytesPerSecond() + ", totalSleepDuration=" + this.totalSleepDuration + AbstractJsonLexerKt.END_LIST;
    }
}
