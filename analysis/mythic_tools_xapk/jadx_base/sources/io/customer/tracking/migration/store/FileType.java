package io.customer.tracking.migration.store;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileType.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0007\bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lio/customer/tracking/migration/store/FileType;", "", "getFilePath", "Ljava/io/File;", "existingPath", "getFileName", "", "QueueInventory", "QueueTask", "Lio/customer/tracking/migration/store/FileType$QueueInventory;", "Lio/customer/tracking/migration/store/FileType$QueueTask;", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface FileType {

    /* JADX INFO: compiled from: FileType.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lio/customer/tracking/migration/store/FileType$QueueInventory;", "Lio/customer/tracking/migration/store/FileType;", "<init>", "()V", "getFileName", "", "getFilePath", "Ljava/io/File;", "existingPath", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class QueueInventory implements FileType {
        @Override // io.customer.tracking.migration.store.FileType
        public String getFileName() {
            return "inventory.json";
        }

        @Override // io.customer.tracking.migration.store.FileType
        public File getFilePath(File existingPath) {
            Intrinsics.checkNotNullParameter(existingPath, "existingPath");
            return new File(existingPath, "queue");
        }
    }

    /* JADX INFO: compiled from: FileType.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lio/customer/tracking/migration/store/FileType$QueueTask;", "Lio/customer/tracking/migration/store/FileType;", "fileId", "", "<init>", "(Ljava/lang/String;)V", "getFileName", "getFilePath", "Ljava/io/File;", "existingPath", "tracking-migration_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class QueueTask implements FileType {
        private final String fileId;

        public QueueTask(String fileId) {
            Intrinsics.checkNotNullParameter(fileId, "fileId");
            this.fileId = fileId;
        }

        @Override // io.customer.tracking.migration.store.FileType
        public String getFileName() {
            return this.fileId + ".json";
        }

        @Override // io.customer.tracking.migration.store.FileType
        public File getFilePath(File existingPath) {
            Intrinsics.checkNotNullParameter(existingPath, "existingPath");
            return new File(new File(existingPath, "queue"), "tasks");
        }
    }

    String getFileName();

    File getFilePath(File existingPath);
}
