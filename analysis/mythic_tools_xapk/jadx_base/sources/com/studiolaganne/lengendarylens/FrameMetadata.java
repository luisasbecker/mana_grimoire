package com.studiolaganne.lengendarylens;

import androidx.constraintlayout.motion.widget.Key;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FrameMetadata.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/studiolaganne/lengendarylens/FrameMetadata;", "", "width", "", "height", Key.ROTATION, "<init>", "(III)V", "getWidth", "()I", "getHeight", "getRotation", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FrameMetadata {
    public static final int $stable = 0;
    private final int height;
    private final int rotation;
    private final int width;

    /* JADX INFO: compiled from: FrameMetadata.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/studiolaganne/lengendarylens/FrameMetadata$Builder;", "", "<init>", "()V", "width", "", "height", Key.ROTATION, "setWidth", "setHeight", "setRotation", "build", "Lcom/studiolaganne/lengendarylens/FrameMetadata;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private int height;
        private int rotation;
        private int width;

        public final FrameMetadata build() {
            return new FrameMetadata(this.width, this.height, this.rotation, null);
        }

        public final Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public final Builder setRotation(int rotation) {
            this.rotation = rotation;
            return this;
        }

        public final Builder setWidth(int width) {
            this.width = width;
            return this;
        }
    }

    private FrameMetadata(int i, int i2, int i3) {
        this.width = i;
        this.height = i2;
        this.rotation = i3;
    }

    public /* synthetic */ FrameMetadata(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getRotation() {
        return this.rotation;
    }

    public final int getWidth() {
        return this.width;
    }
}
