package org.apache.commons.csv;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;
import org.apache.commons.io.function.IOConsumer;
import org.apache.commons.io.function.IOStream;

/* JADX INFO: loaded from: classes7.dex */
public final class CSVPrinter implements Flushable, Closeable {
    private final Appendable appendable;
    private final CSVFormat format;
    private long recordCount;
    private boolean newRecord = true;
    private final ReentrantLock lock = new ReentrantLock();

    public CSVPrinter(Appendable appendable, CSVFormat cSVFormat) throws IOException {
        Objects.requireNonNull(appendable, "appendable");
        Objects.requireNonNull(cSVFormat, "format");
        this.appendable = appendable;
        this.format = cSVFormat.copy();
        String[] headerComments = cSVFormat.getHeaderComments();
        if (headerComments != null) {
            for (String str : headerComments) {
                printComment(str);
            }
        }
        if (cSVFormat.getHeader() == null || cSVFormat.getSkipHeaderRecord()) {
            return;
        }
        printRecord(cSVFormat.getHeader());
    }

    private void endOfRecord() throws IOException {
        println();
        this.recordCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printRaw(Object obj) throws IOException {
        this.format.print(obj, this.appendable, this.newRecord);
        this.newRecord = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printRecordObject(Object obj) throws IOException {
        if (obj instanceof Object[]) {
            printRecord((Object[]) obj);
        } else if (obj instanceof Iterable) {
            printRecord((Iterable<?>) obj);
        } else {
            printRecord(obj);
        }
    }

    private void printRecords(IOStream<?> iOStream) throws IOException {
        this.format.limit(iOStream).forEachOrdered(new IOConsumer() { // from class: org.apache.commons.csv.CSVPrinter$$ExternalSyntheticLambda2
            @Override // org.apache.commons.io.function.IOConsumer
            public final void accept(Object obj) throws IOException {
                this.f$0.printRecordObject(obj);
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close(false);
    }

    public void close(boolean z) throws IOException {
        if (z || this.format.getAutoFlush()) {
            flush();
        }
        Appendable appendable = this.appendable;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        Appendable appendable = this.appendable;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    public Appendable getOut() {
        return this.appendable;
    }

    public long getRecordCount() {
        return this.recordCount;
    }

    public void print(Object obj) throws IOException {
        this.lock.lock();
        try {
            printRaw(obj);
        } finally {
            this.lock.unlock();
        }
    }

    public void printComment(String str) throws IOException {
        this.lock.lock();
        if (str != null) {
            try {
                if (this.format.isCommentMarkerSet()) {
                    if (!this.newRecord) {
                        println();
                    }
                    this.appendable.append(this.format.getCommentMarker().charValue());
                    this.appendable.append(' ');
                    int i = 0;
                    while (i < str.length()) {
                        char cCharAt = str.charAt(i);
                        if (cCharAt == '\n') {
                            println();
                            this.appendable.append(this.format.getCommentMarker().charValue());
                            this.appendable.append(' ');
                        } else if (cCharAt != '\r') {
                            this.appendable.append(cCharAt);
                        } else {
                            int i2 = i + 1;
                            if (i2 < str.length() && str.charAt(i2) == '\n') {
                                i = i2;
                            }
                            println();
                            this.appendable.append(this.format.getCommentMarker().charValue());
                            this.appendable.append(' ');
                        }
                        i++;
                    }
                    println();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    public void printHeaders(ResultSet resultSet) throws SQLException, IOException {
        this.lock.lock();
        try {
            IOStream iOStreamOf = IOStream.of((Object[]) this.format.builder().setHeader(resultSet).get().getHeader());
            try {
                iOStreamOf.forEachOrdered(new IOConsumer() { // from class: org.apache.commons.csv.CSVPrinter$$ExternalSyntheticLambda0
                    @Override // org.apache.commons.io.function.IOConsumer
                    public final void accept(Object obj) throws IOException {
                        this.f$0.print((String) obj);
                    }
                });
                if (iOStreamOf != null) {
                    iOStreamOf.close();
                }
                println();
            } finally {
            }
        } finally {
            this.lock.unlock();
        }
    }

    public void printRecord(Iterable<?> iterable) throws IOException {
        this.lock.lock();
        try {
            IOStream.of((Iterable) iterable).forEachOrdered(new CSVPrinter$$ExternalSyntheticLambda1(this));
            endOfRecord();
        } finally {
            this.lock.unlock();
        }
    }

    public void printRecord(Stream<?> stream) throws IOException {
        this.lock.lock();
        try {
            IOStream.adapt(stream).forEachOrdered(stream.isParallel() ? new IOConsumer() { // from class: org.apache.commons.csv.CSVPrinter$$ExternalSyntheticLambda3
                @Override // org.apache.commons.io.function.IOConsumer
                public final void accept(Object obj) throws IOException {
                    this.f$0.printRaw(obj);
                }
            } : new CSVPrinter$$ExternalSyntheticLambda1(this));
            endOfRecord();
        } finally {
            this.lock.unlock();
        }
    }

    public void printRecord(Object... objArr) throws IOException {
        printRecord(Arrays.asList(objArr));
    }

    public void printRecords(Iterable<?> iterable) throws IOException {
        printRecords(IOStream.of((Iterable) iterable));
    }

    public void printRecords(ResultSet resultSet) throws SQLException, IOException {
        int columnCount = resultSet.getMetaData().getColumnCount();
        while (resultSet.next() && this.format.useRow(resultSet.getRow())) {
            this.lock.lock();
            for (int i = 1; i <= columnCount; i++) {
                try {
                    Object object = resultSet.getObject(i);
                    if (object instanceof Clob) {
                        Reader characterStream = ((Clob) object).getCharacterStream();
                        try {
                            print(characterStream);
                            if (characterStream != null) {
                                characterStream.close();
                            }
                        } finally {
                        }
                    } else if (object instanceof Blob) {
                        InputStream binaryStream = ((Blob) object).getBinaryStream();
                        try {
                            print(binaryStream);
                            if (binaryStream != null) {
                                binaryStream.close();
                            }
                        } finally {
                        }
                    } else {
                        print(object);
                    }
                } finally {
                    this.lock.unlock();
                }
            }
            endOfRecord();
        }
    }

    public void printRecords(ResultSet resultSet, boolean z) throws SQLException, IOException {
        if (z) {
            printHeaders(resultSet);
        }
        printRecords(resultSet);
    }

    public void printRecords(Stream<?> stream) throws IOException {
        printRecords(IOStream.adapt(stream));
    }

    public void printRecords(Object... objArr) throws IOException {
        printRecords(Arrays.asList(objArr));
    }

    public void println() throws IOException {
        this.lock.lock();
        try {
            this.format.println(this.appendable);
            this.newRecord = true;
        } finally {
            this.lock.unlock();
        }
    }
}
