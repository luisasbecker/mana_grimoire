package org.apache.commons.io.file;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.io.file.Counters;

/* JADX INFO: loaded from: classes7.dex */
public class CopyDirectoryVisitor extends CountingPathVisitor {
    private final CopyOption[] copyOptions;
    private final Path sourceDirectory;
    private final Path targetDirectory;

    public CopyDirectoryVisitor(Counters.PathCounters pathCounters, Path path, Path path2, CopyOption... copyOptionArr) {
        super(pathCounters);
        this.sourceDirectory = path;
        this.targetDirectory = path2;
        this.copyOptions = toCopyOption(copyOptionArr);
    }

    public CopyDirectoryVisitor(Counters.PathCounters pathCounters, PathFilter pathFilter, PathFilter pathFilter2, Path path, Path path2, CopyOption... copyOptionArr) {
        super(pathCounters, pathFilter, pathFilter2);
        this.sourceDirectory = path;
        this.targetDirectory = path2;
        this.copyOptions = toCopyOption(copyOptionArr);
    }

    private Path resolveRelativeAsString(Path path) {
        return PathUtils.resolve(this.targetDirectory, this.sourceDirectory.relativize(path));
    }

    private static CopyOption[] toCopyOption(CopyOption... copyOptionArr) {
        return copyOptionArr == null ? PathUtils.EMPTY_COPY_OPTIONS : (CopyOption[]) copyOptionArr.clone();
    }

    protected void copy(Path path, Path path2) throws IOException {
        Files.copy(path, path2, this.copyOptions);
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        CopyDirectoryVisitor copyDirectoryVisitor = (CopyDirectoryVisitor) obj;
        return Arrays.equals(this.copyOptions, copyDirectoryVisitor.copyOptions) && Objects.equals(this.sourceDirectory, copyDirectoryVisitor.sourceDirectory) && Objects.equals(this.targetDirectory, copyDirectoryVisitor.targetDirectory);
    }

    public CopyOption[] getCopyOptions() {
        return (CopyOption[]) this.copyOptions.clone();
    }

    public Path getSourceDirectory() {
        return this.sourceDirectory;
    }

    public Path getTargetDirectory() {
        return this.targetDirectory;
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor
    public int hashCode() {
        return (((super.hashCode() * 31) + Arrays.hashCode(this.copyOptions)) * 31) + Objects.hash(this.sourceDirectory, this.targetDirectory);
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor, java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        Path pathResolveRelativeAsString = resolveRelativeAsString(path);
        if (Files.notExists(pathResolveRelativeAsString, new LinkOption[0])) {
            Files.createDirectory(pathResolveRelativeAsString, new FileAttribute[0]);
        }
        return super.preVisitDirectory(path, basicFileAttributes);
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor, java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        Path pathResolveRelativeAsString = resolveRelativeAsString(path);
        if (accept(path, basicFileAttributes)) {
            copy(path, pathResolveRelativeAsString);
            updateFileCounters(pathResolveRelativeAsString, basicFileAttributes);
        }
        return FileVisitResult.CONTINUE;
    }
}
