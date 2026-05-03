package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImportCsvDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionImportResult;", "", "<init>", "()V", "CsvImport", "TxtImport", "Lcom/studiolaganne/lengendarylens/CollectionImportResult$CsvImport;", "Lcom/studiolaganne/lengendarylens/CollectionImportResult$TxtImport;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class CollectionImportResult {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: ImportCsvDialogFragment.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionImportResult$CsvImport;", "Lcom/studiolaganne/lengendarylens/CollectionImportResult;", "inputStream", "Ljava/io/InputStream;", "fileName", "", "<init>", "(Ljava/io/InputStream;Ljava/lang/String;)V", "getInputStream", "()Ljava/io/InputStream;", "getFileName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CsvImport extends CollectionImportResult {
        public static final int $stable = 8;
        private final String fileName;
        private final InputStream inputStream;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CsvImport(InputStream inputStream, String fileName) {
            super(null);
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            this.inputStream = inputStream;
            this.fileName = fileName;
        }

        public static /* synthetic */ CsvImport copy$default(CsvImport csvImport, InputStream inputStream, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                inputStream = csvImport.inputStream;
            }
            if ((i & 2) != 0) {
                str = csvImport.fileName;
            }
            return csvImport.copy(inputStream, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final InputStream getInputStream() {
            return this.inputStream;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFileName() {
            return this.fileName;
        }

        public final CsvImport copy(InputStream inputStream, String fileName) {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return new CsvImport(inputStream, fileName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CsvImport)) {
                return false;
            }
            CsvImport csvImport = (CsvImport) other;
            return Intrinsics.areEqual(this.inputStream, csvImport.inputStream) && Intrinsics.areEqual(this.fileName, csvImport.fileName);
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final InputStream getInputStream() {
            return this.inputStream;
        }

        public int hashCode() {
            return (this.inputStream.hashCode() * 31) + this.fileName.hashCode();
        }

        public String toString() {
            return "CsvImport(inputStream=" + this.inputStream + ", fileName=" + this.fileName + ")";
        }
    }

    /* JADX INFO: compiled from: ImportCsvDialogFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionImportResult$TxtImport;", "Lcom/studiolaganne/lengendarylens/CollectionImportResult;", "parsedCards", "", "Lcom/studiolaganne/lengendarylens/ParsedCard;", "<init>", "(Ljava/util/List;)V", "getParsedCards", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TxtImport extends CollectionImportResult {
        public static final int $stable = 8;
        private final List<ParsedCard> parsedCards;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TxtImport(List<ParsedCard> parsedCards) {
            super(null);
            Intrinsics.checkNotNullParameter(parsedCards, "parsedCards");
            this.parsedCards = parsedCards;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TxtImport copy$default(TxtImport txtImport, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = txtImport.parsedCards;
            }
            return txtImport.copy(list);
        }

        public final List<ParsedCard> component1() {
            return this.parsedCards;
        }

        public final TxtImport copy(List<ParsedCard> parsedCards) {
            Intrinsics.checkNotNullParameter(parsedCards, "parsedCards");
            return new TxtImport(parsedCards);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TxtImport) && Intrinsics.areEqual(this.parsedCards, ((TxtImport) other).parsedCards);
        }

        public final List<ParsedCard> getParsedCards() {
            return this.parsedCards;
        }

        public int hashCode() {
            return this.parsedCards.hashCode();
        }

        public String toString() {
            return "TxtImport(parsedCards=" + this.parsedCards + ")";
        }
    }

    private CollectionImportResult() {
    }

    public /* synthetic */ CollectionImportResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
