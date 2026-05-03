package org.apache.commons.io.file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.Objects;
import org.apache.commons.io.build.AbstractSupplier;
import org.apache.commons.io.function.IOBiFunction;

/* JADX INFO: loaded from: classes7.dex */
public abstract class SimplePathVisitor extends SimpleFileVisitor<Path> implements PathVisitor {
    private final IOBiFunction<Path, IOException, FileVisitResult> visitFileFailedFunction;

    protected static abstract class AbstractBuilder<T, B extends AbstractSupplier<T, B>> extends AbstractSupplier<T, B> {
        private IOBiFunction<Path, IOException, FileVisitResult> visitFileFailedFunction;

        IOBiFunction<Path, IOException, FileVisitResult> getVisitFileFailedFunction() {
            return this.visitFileFailedFunction;
        }

        public B setVisitFileFailedFunction(IOBiFunction<Path, IOException, FileVisitResult> iOBiFunction) {
            this.visitFileFailedFunction = iOBiFunction;
            return asThis();
        }
    }

    protected SimplePathVisitor() {
        this.visitFileFailedFunction = new IOBiFunction() { // from class: org.apache.commons.io.file.SimplePathVisitor$$ExternalSyntheticLambda0
            @Override // org.apache.commons.io.function.IOBiFunction
            public final Object apply(Object obj, Object obj2) {
                return this.f$0.m13259lambda$new$0$orgapachecommonsiofileSimplePathVisitor((Path) obj, (IOException) obj2);
            }
        };
    }

    SimplePathVisitor(AbstractBuilder<?, ?> abstractBuilder) {
        this.visitFileFailedFunction = ((AbstractBuilder) abstractBuilder).visitFileFailedFunction != null ? ((AbstractBuilder) abstractBuilder).visitFileFailedFunction : new IOBiFunction() { // from class: org.apache.commons.io.file.SimplePathVisitor$$ExternalSyntheticLambda1
            @Override // org.apache.commons.io.function.IOBiFunction
            public final Object apply(Object obj, Object obj2) {
                return this.f$0.m13260lambda$new$1$orgapachecommonsiofileSimplePathVisitor((Path) obj, (IOException) obj2);
            }
        };
    }

    protected SimplePathVisitor(IOBiFunction<Path, IOException, FileVisitResult> iOBiFunction) {
        this.visitFileFailedFunction = (IOBiFunction) Objects.requireNonNull(iOBiFunction, "visitFileFailedFunction");
    }

    /* JADX INFO: renamed from: lambda$new$0$org-apache-commons-io-file-SimplePathVisitor, reason: not valid java name */
    /* synthetic */ FileVisitResult m13259lambda$new$0$orgapachecommonsiofileSimplePathVisitor(Object obj, IOException iOException) throws IOException {
        return super.visitFileFailed(obj, iOException);
    }

    /* JADX INFO: renamed from: lambda$new$1$org-apache-commons-io-file-SimplePathVisitor, reason: not valid java name */
    /* synthetic */ FileVisitResult m13260lambda$new$1$orgapachecommonsiofileSimplePathVisitor(Object obj, IOException iOException) throws IOException {
        return super.visitFileFailed(obj, iOException);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult visitFileFailed(Path path, IOException iOException) throws IOException {
        return this.visitFileFailedFunction.apply(path, iOException);
    }
}
