package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/* JADX INFO: loaded from: classes7.dex */
public class CompositeFileComparator extends AbstractFileComparator implements Serializable {
    private static final Comparator<?>[] EMPTY_COMPARATOR_ARRAY = new Comparator[0];
    private static final long serialVersionUID = -2224170307287243428L;
    private final Comparator<File>[] delegates;

    public CompositeFileComparator(Iterable<Comparator<File>> iterable) {
        this.delegates = iterable == null ? emptyArray() : (Comparator[]) StreamSupport.stream(iterable.spliterator(), false).toArray(new IntFunction() { // from class: org.apache.commons.io.comparator.CompositeFileComparator$$ExternalSyntheticLambda0
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return CompositeFileComparator.lambda$new$0(i);
            }
        });
    }

    public CompositeFileComparator(Comparator<File>... comparatorArr) {
        this.delegates = comparatorArr == null ? emptyArray() : (Comparator[]) comparatorArr.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Comparator<?>[], java.util.Comparator<java.io.File>[]] */
    private Comparator<File>[] emptyArray() {
        return EMPTY_COMPARATOR_ARRAY;
    }

    static /* synthetic */ boolean lambda$compare$2(Integer num) {
        return num.intValue() != 0;
    }

    static /* synthetic */ Comparator[] lambda$new$0(int i) {
        return new Comparator[i];
    }

    @Override // java.util.Comparator
    public int compare(final File file, final File file2) {
        return ((Integer) Stream.of((Object[]) this.delegates).map(new Function() { // from class: org.apache.commons.io.comparator.CompositeFileComparator$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((Comparator) obj).compare(file, file2));
            }
        }).filter(new Predicate() { // from class: org.apache.commons.io.comparator.CompositeFileComparator$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CompositeFileComparator.lambda$compare$2((Integer) obj);
            }
        }).findFirst().orElse(0)).intValue();
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ List sort(List list) {
        return super.sort((List<File>) list);
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ File[] sort(File[] fileArr) {
        return super.sort(fileArr);
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public String toString() {
        return super.toString() + Arrays.toString(this.delegates);
    }
}
