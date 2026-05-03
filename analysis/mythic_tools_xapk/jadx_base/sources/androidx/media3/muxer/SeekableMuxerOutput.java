package androidx.media3.muxer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes3.dex */
public interface SeekableMuxerOutput extends WritableByteChannel {
    static SeekableMuxerOutput of(FileOutputStream fileOutputStream) {
        return new FileOutputStreamSeekableMuxerOutput(fileOutputStream);
    }

    static SeekableMuxerOutput of(String str) throws FileNotFoundException {
        return new FileOutputStreamSeekableMuxerOutput(new FileOutputStream(str));
    }

    long getPosition() throws IOException;

    long getSize() throws IOException;

    void setPosition(long j) throws IOException;

    void truncate(long j) throws IOException;
}
