package androidx.media3.container;

import androidx.media3.common.C;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class ReorderingBufferQueue {
    private BuffersWithTimestamp lastQueuedBuffer;
    private final OutputConsumer outputConsumer;
    private final ArrayDeque<ParsableByteArray> unusedParsableByteArrays = new ArrayDeque<>();
    private final ArrayDeque<BuffersWithTimestamp> unusedBuffersWithTimestamp = new ArrayDeque<>();
    private final PriorityQueue<BuffersWithTimestamp> pendingBuffers = new PriorityQueue<>();
    private int reorderingQueueSize = -1;

    private static final class BuffersWithTimestamp implements Comparable<BuffersWithTimestamp> {
        public long presentationTimeUs = C.TIME_UNSET;
        public final List<ParsableByteArray> nalBuffers = new ArrayList();

        @Override // java.lang.Comparable
        public int compareTo(BuffersWithTimestamp buffersWithTimestamp) {
            return Long.compare(this.presentationTimeUs, buffersWithTimestamp.presentationTimeUs);
        }

        public void init(long j, ParsableByteArray parsableByteArray) {
            Preconditions.checkArgument(j != C.TIME_UNSET);
            Preconditions.checkState(this.nalBuffers.isEmpty());
            this.presentationTimeUs = j;
            this.nalBuffers.add(parsableByteArray);
        }
    }

    public interface OutputConsumer {
        void consume(long j, ParsableByteArray parsableByteArray);
    }

    public ReorderingBufferQueue(OutputConsumer outputConsumer) {
        this.outputConsumer = outputConsumer;
    }

    private ParsableByteArray copy(ParsableByteArray parsableByteArray) {
        ParsableByteArray parsableByteArray2 = this.unusedParsableByteArrays.isEmpty() ? new ParsableByteArray() : this.unusedParsableByteArrays.pop();
        parsableByteArray2.reset(parsableByteArray.bytesLeft());
        System.arraycopy(parsableByteArray.getData(), parsableByteArray.getPosition(), parsableByteArray2.getData(), 0, parsableByteArray2.bytesLeft());
        return parsableByteArray2;
    }

    private void flushQueueDownToSize(int i) {
        while (this.pendingBuffers.size() > i) {
            BuffersWithTimestamp buffersWithTimestamp = (BuffersWithTimestamp) Util.castNonNull(this.pendingBuffers.poll());
            for (int i2 = 0; i2 < buffersWithTimestamp.nalBuffers.size(); i2++) {
                this.outputConsumer.consume(buffersWithTimestamp.presentationTimeUs, buffersWithTimestamp.nalBuffers.get(i2));
                this.unusedParsableByteArrays.push(buffersWithTimestamp.nalBuffers.get(i2));
            }
            buffersWithTimestamp.nalBuffers.clear();
            BuffersWithTimestamp buffersWithTimestamp2 = this.lastQueuedBuffer;
            if (buffersWithTimestamp2 != null && buffersWithTimestamp2.presentationTimeUs == buffersWithTimestamp.presentationTimeUs) {
                this.lastQueuedBuffer = null;
            }
            this.unusedBuffersWithTimestamp.push(buffersWithTimestamp);
        }
    }

    public void add(long j, ParsableByteArray parsableByteArray) {
        int i;
        if (j == C.TIME_UNSET || (i = this.reorderingQueueSize) == 0 || (i != -1 && this.pendingBuffers.size() >= this.reorderingQueueSize && j < ((BuffersWithTimestamp) Util.castNonNull(this.pendingBuffers.peek())).presentationTimeUs)) {
            this.outputConsumer.consume(j, parsableByteArray);
            return;
        }
        ParsableByteArray parsableByteArrayCopy = copy(parsableByteArray);
        BuffersWithTimestamp buffersWithTimestamp = this.lastQueuedBuffer;
        if (buffersWithTimestamp != null && j == buffersWithTimestamp.presentationTimeUs) {
            this.lastQueuedBuffer.nalBuffers.add(parsableByteArrayCopy);
            return;
        }
        BuffersWithTimestamp buffersWithTimestamp2 = this.unusedBuffersWithTimestamp.isEmpty() ? new BuffersWithTimestamp() : this.unusedBuffersWithTimestamp.pop();
        buffersWithTimestamp2.init(j, parsableByteArrayCopy);
        this.pendingBuffers.add(buffersWithTimestamp2);
        this.lastQueuedBuffer = buffersWithTimestamp2;
        int i2 = this.reorderingQueueSize;
        if (i2 != -1) {
            flushQueueDownToSize(i2);
        }
    }

    public void clear() {
        this.pendingBuffers.clear();
    }

    public void flush() {
        flushQueueDownToSize(0);
    }

    public int getMaxSize() {
        return this.reorderingQueueSize;
    }

    public void setMaxSize(int i) {
        Preconditions.checkState(i >= 0);
        this.reorderingQueueSize = i;
        flushQueueDownToSize(i);
    }
}
