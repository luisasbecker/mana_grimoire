package org.apache.commons.csv;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes7.dex */
public final class CSVRecord implements Serializable, Iterable<String> {
    private static final long serialVersionUID = 1;
    private final long bytePosition;
    private final long characterPosition;
    private final String comment;
    private final transient CSVParser parser;
    private final long recordNumber;
    private final String[] values;

    CSVRecord(CSVParser cSVParser, String[] strArr, String str, long j, long j2, long j3) {
        this.recordNumber = j;
        this.values = strArr == null ? Constants.EMPTY_STRING_ARRAY : strArr;
        this.parser = cSVParser;
        this.comment = str;
        this.characterPosition = j2;
        this.bytePosition = j3;
    }

    private Map<String, Integer> getHeaderMapRaw() {
        CSVParser cSVParser = this.parser;
        if (cSVParser == null) {
            return null;
        }
        return cSVParser.getHeaderMapRaw();
    }

    public String get(int i) {
        return this.values[i];
    }

    public String get(Enum<?> r1) {
        return get(r1 == null ? null : r1.name());
    }

    public String get(String str) {
        Map<String, Integer> headerMapRaw = getHeaderMapRaw();
        if (headerMapRaw == null) {
            throw new IllegalStateException("No header mapping was specified, the record values can't be accessed by name");
        }
        Integer num = headerMapRaw.get(str);
        if (num == null) {
            throw new IllegalArgumentException(String.format("Mapping for %s not found, expected one of %s", str, headerMapRaw.keySet()));
        }
        try {
            return this.values[num.intValue()];
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException(String.format("Index for header '%s' is %d but CSVRecord only has %d values!", str, num, Integer.valueOf(this.values.length)));
        }
    }

    public long getBytePosition() {
        return this.bytePosition;
    }

    public long getCharacterPosition() {
        return this.characterPosition;
    }

    public String getComment() {
        return this.comment;
    }

    public CSVParser getParser() {
        return this.parser;
    }

    public long getRecordNumber() {
        return this.recordNumber;
    }

    public boolean hasComment() {
        return this.comment != null;
    }

    public boolean isConsistent() {
        Map<String, Integer> headerMapRaw = getHeaderMapRaw();
        return headerMapRaw == null || headerMapRaw.size() == this.values.length;
    }

    public boolean isMapped(String str) {
        Map<String, Integer> headerMapRaw = getHeaderMapRaw();
        return headerMapRaw != null && headerMapRaw.containsKey(str);
    }

    public boolean isSet(int i) {
        return i >= 0 && i < this.values.length;
    }

    public boolean isSet(String str) {
        return isMapped(str) && getHeaderMapRaw().get(str).intValue() < this.values.length;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return toList().iterator();
    }

    /* JADX INFO: renamed from: lambda$putIn$0$org-apache-commons-csv-CSVRecord, reason: not valid java name */
    /* synthetic */ void m13236lambda$putIn$0$orgapachecommonscsvCSVRecord(Map map, String str, Integer num) {
        int iIntValue = num.intValue();
        String[] strArr = this.values;
        if (iIntValue < strArr.length) {
            map.put(str, strArr[num.intValue()]);
        }
    }

    public <M extends Map<String, String>> M putIn(final M m) {
        if (getHeaderMapRaw() == null) {
            return m;
        }
        getHeaderMapRaw().forEach(new BiConsumer() { // from class: org.apache.commons.csv.CSVRecord$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f$0.m13236lambda$putIn$0$orgapachecommonscsvCSVRecord(m, (String) obj, (Integer) obj2);
            }
        });
        return m;
    }

    public int size() {
        return this.values.length;
    }

    public Stream<String> stream() {
        return Stream.of((Object[]) this.values);
    }

    public List<String> toList() {
        return (List) stream().collect(Collectors.toList());
    }

    public Map<String, String> toMap() {
        return putIn(new LinkedHashMap(this.values.length));
    }

    public String toString() {
        return "CSVRecord [comment='" + this.comment + "', recordNumber=" + this.recordNumber + ", values=" + Arrays.toString(this.values) + "]";
    }

    public String[] values() {
        return this.values;
    }
}
