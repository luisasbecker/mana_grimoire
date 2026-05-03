package com.studiolaganne.lengendarylens;

import androidx.camera.video.AudioStats;
import androidx.credentials.provider.CredentialEntry;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MTCardCsvExporter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardCsvExporter;", "", "<init>", "()V", "Column", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTCardCsvExporter {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Column> columns = CollectionsKt.listOf((Object[]) new Column[]{new Column("Card Name", new Function1() { // from class: com.studiolaganne.lengendarylens.MTCardCsvExporter$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MTCardCsvExporter.columns$lambda$0((MTFullCard) obj);
        }
    }), new Column("Set Code", new Function1() { // from class: com.studiolaganne.lengendarylens.MTCardCsvExporter$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MTCardCsvExporter.columns$lambda$1((MTFullCard) obj);
        }
    }), new Column("Set Name", new Function1() { // from class: com.studiolaganne.lengendarylens.MTCardCsvExporter$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MTCardCsvExporter.columns$lambda$2((MTFullCard) obj);
        }
    }), new Column("Collector Number", new Function1() { // from class: com.studiolaganne.lengendarylens.MTCardCsvExporter$$ExternalSyntheticLambda13
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MTCardCsvExporter.columns$lambda$3((MTFullCard) obj);
        }
    }), new Column("Rarity", new Function1() { // from class: com.studiolaganne.lengendarylens.MTCardCsvExporter$$ExternalSyntheticLambda14
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MTCardCsvExporter.columns$lambda$4((MTFullCard) obj);
        }
    }), new Column("Language", new Function1() { // from class: com.studiolaganne.lengendarylens.MTCardCsvExporter$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MTCardCsvExporter.columns$lambda$5((MTFullCard) obj);
        }
    }), new Column("Quantity", new Function1() { // from class: com.studiolaganne.lengendarylens.MTCardCsvExporter$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MTCardCsvExporter.columns$lambda$6((MTFullCard) obj);
        }
    }), new Column("Condition", new Function1() { // from class: com.studiolaganne.lengendarylens.MTCardCsvExporter$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MTCardCsvExporter.columns$lambda$7((MTFullCard) obj);
        }
    }), new Column("Finish", new Function1() { // from class: com.studiolaganne.lengendarylens.MTCardCsvExporter$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MTCardCsvExporter.columns$lambda$8((MTFullCard) obj);
        }
    }), new Column("Altered", new Function1() { // from class: com.studiolaganne.lengendarylens.MTCardCsvExporter$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MTCardCsvExporter.columns$lambda$9((MTFullCard) obj);
        }
    }), new Column("Signed", new Function1() { // from class: com.studiolaganne.lengendarylens.MTCardCsvExporter$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MTCardCsvExporter.columns$lambda$10((MTFullCard) obj);
        }
    }), new Column("Misprint", new Function1() { // from class: com.studiolaganne.lengendarylens.MTCardCsvExporter$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MTCardCsvExporter.columns$lambda$11((MTFullCard) obj);
        }
    }), new Column("Price (USD)", new Function1() { // from class: com.studiolaganne.lengendarylens.MTCardCsvExporter$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MTCardCsvExporter.columns$lambda$12((MTFullCard) obj);
        }
    }), new Column("Price (EUR)", new Function1() { // from class: com.studiolaganne.lengendarylens.MTCardCsvExporter$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MTCardCsvExporter.columns$lambda$13((MTFullCard) obj);
        }
    }), new Column("Scryfall ID", new Function1() { // from class: com.studiolaganne.lengendarylens.MTCardCsvExporter$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MTCardCsvExporter.columns$lambda$14((MTFullCard) obj);
        }
    })});

    /* JADX INFO: compiled from: MTCardCsvExporter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardCsvExporter$Column;", "", "header", "", "valueExtractor", "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getHeader", "()Ljava/lang/String;", "getValueExtractor", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class Column {
        private final String header;
        private final Function1<MTFullCard, Object> valueExtractor;

        /* JADX WARN: Multi-variable type inference failed */
        public Column(String header, Function1<? super MTFullCard, ? extends Object> valueExtractor) {
            Intrinsics.checkNotNullParameter(header, "header");
            Intrinsics.checkNotNullParameter(valueExtractor, "valueExtractor");
            this.header = header;
            this.valueExtractor = valueExtractor;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Column copy$default(Column column, String str, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                str = column.header;
            }
            if ((i & 2) != 0) {
                function1 = column.valueExtractor;
            }
            return column.copy(str, function1);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getHeader() {
            return this.header;
        }

        public final Function1<MTFullCard, Object> component2() {
            return this.valueExtractor;
        }

        public final Column copy(String header, Function1<? super MTFullCard, ? extends Object> valueExtractor) {
            Intrinsics.checkNotNullParameter(header, "header");
            Intrinsics.checkNotNullParameter(valueExtractor, "valueExtractor");
            return new Column(header, valueExtractor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Column)) {
                return false;
            }
            Column column = (Column) other;
            return Intrinsics.areEqual(this.header, column.header) && Intrinsics.areEqual(this.valueExtractor, column.valueExtractor);
        }

        public final String getHeader() {
            return this.header;
        }

        public final Function1<MTFullCard, Object> getValueExtractor() {
            return this.valueExtractor;
        }

        public int hashCode() {
            return (this.header.hashCode() * 31) + this.valueExtractor.hashCode();
        }

        public String toString() {
            return "Column(header=" + this.header + ", valueExtractor=" + this.valueExtractor + ")";
        }
    }

    /* JADX INFO: compiled from: MTCardCsvExporter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\r\u001a\u00020\fJ\u001a\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardCsvExporter$Companion;", "", "<init>", "()V", "columns", "", "Lcom/studiolaganne/lengendarylens/MTCardCsvExporter$Column;", "generateCsv", "", "cards", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "createCsvFile", "Ljava/io/File;", "cacheDir", "formatValueForCsv", "value", "column", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0054 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final String formatValueForCsv(Object value, String column) {
            if (value != null) {
                if (value instanceof Boolean) {
                    return ((Boolean) value).booleanValue() ? "true" : CredentialEntry.FALSE_STRING;
                }
                if (value instanceof Double) {
                    String str = new DecimalFormat("#0.00", new DecimalFormatSymbols(Locale.US)).format(((Number) value).doubleValue());
                    Intrinsics.checkNotNull(str);
                    return str;
                }
                if (value instanceof Float) {
                    String str2 = new DecimalFormat("#0.00", new DecimalFormatSymbols(Locale.US)).format(((Number) value).floatValue());
                    Intrinsics.checkNotNull(str2);
                    return str2;
                }
                if (value instanceof Integer) {
                    return String.valueOf(((Number) value).intValue());
                }
                if (!(value instanceof String)) {
                    return value.toString();
                }
                CharSequence charSequence = (CharSequence) value;
                if (StringsKt.contains$default(charSequence, (CharSequence) ",", false, 2, (Object) null) || StringsKt.contains$default(charSequence, (CharSequence) "\"", false, 2, (Object) null) || StringsKt.contains$default(charSequence, (CharSequence) "\n", false, 2, (Object) null)) {
                    return "\"" + StringsKt.replace$default((String) value, "\"", "\"\"", false, 4, (Object) null) + "\"";
                }
                return (String) value;
            }
            switch (column.hashCode()) {
                case -1818600644:
                    return !column.equals("Signed") ? "" : CredentialEntry.FALSE_STRING;
                case -1220360021:
                    return !column.equals("Quantity") ? "" : "1";
                case -1144664362:
                    if (!column.equals("Misprint")) {
                        return "";
                    }
                    break;
                case 760395541:
                    if (!column.equals("Altered")) {
                        return "";
                    }
                    break;
                case 1679222072:
                    return !column.equals("Price (EUR)") ? "" : "0.0";
                case 1679696372:
                    return !column.equals("Price (USD)") ? "" : "0.0";
                case 2104391859:
                    return !column.equals("Finish") ? "" : "nonfoil";
                default:
                    return "";
            }
        }

        public final File createCsvFile(List<MTFullCard> cards, File cacheDir) {
            Intrinsics.checkNotNullParameter(cards, "cards");
            Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
            String strGenerateCsv = generateCsv(cards);
            File file = new File(cacheDir, "MythicTools_export_" + System.currentTimeMillis() + ".csv");
            try {
                FileWriter fileWriter = new FileWriter(file);
                try {
                    fileWriter.write(strGenerateCsv);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileWriter, null);
                    return file;
                } finally {
                }
            } catch (IOException e) {
                System.out.println((Object) ("Error writing CSV file: " + e.getMessage()));
                return null;
            }
        }

        public final String generateCsv(List<MTFullCard> cards) {
            Intrinsics.checkNotNullParameter(cards, "cards");
            StringBuilder sb = new StringBuilder();
            List list = MTCardCsvExporter.columns;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((Column) it.next()).getHeader());
            }
            sb.append(CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null)).append("\n");
            for (MTFullCard mTFullCard : cards) {
                List<Column> list2 = MTCardCsvExporter.columns;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (Column column : list2) {
                    arrayList2.add(MTCardCsvExporter.INSTANCE.formatValueForCsv(column.getValueExtractor().invoke(mTFullCard), column.getHeader()));
                }
                sb.append(CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, null, 62, null)).append("\n");
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    static final Object columns$lambda$0(MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getName();
    }

    static final Object columns$lambda$1(MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getSet_code();
    }

    static final Object columns$lambda$10(MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getSigned();
    }

    static final Object columns$lambda$11(MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getMissprint();
    }

    static final Object columns$lambda$12(MTFullCard it) {
        MTMarketplaceFinishPrices mythictools;
        Double nonfoil;
        Intrinsics.checkNotNullParameter(it, "it");
        MTCardMarketplaceValues values = it.getValues();
        if (values != null && (mythictools = values.getMythictools()) != null && (nonfoil = mythictools.getNonfoil()) != null) {
            return nonfoil;
        }
        Double current_value_usd = it.getCurrent_value_usd();
        return current_value_usd == null ? Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE) : current_value_usd;
    }

    static final Object columns$lambda$13(MTFullCard it) {
        MTMarketplaceFinishPrices mythictools;
        Double nonfoil;
        Intrinsics.checkNotNullParameter(it, "it");
        MTCardMarketplaceValues values = it.getValues();
        if (values != null && (mythictools = values.getMythictools()) != null && (nonfoil = mythictools.getNonfoil()) != null) {
            return nonfoil;
        }
        Double current_value_eur = it.getCurrent_value_eur();
        return current_value_eur == null ? Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE) : current_value_eur;
    }

    static final Object columns$lambda$14(MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getScryfallid();
    }

    static final Object columns$lambda$2(MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getSet_name();
    }

    static final Object columns$lambda$3(MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getCollector_number();
    }

    static final Object columns$lambda$4(MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRarity();
    }

    static final Object columns$lambda$5(MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getLang();
    }

    static final Object columns$lambda$6(MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getQuantity();
    }

    static final Object columns$lambda$7(MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getCondition();
    }

    static final Object columns$lambda$8(MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getFinish();
    }

    static final Object columns$lambda$9(MTFullCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getAltered();
    }
}
