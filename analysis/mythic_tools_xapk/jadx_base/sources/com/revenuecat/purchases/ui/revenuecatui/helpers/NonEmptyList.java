package com.revenuecat.purchases.ui.revenuecatui.helpers;

import androidx.exifinterface.media.ExifInterface;
import com.caverock.androidsvg.SVGParser;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: NonEmptyList.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005B\u0015\b\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0007J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0096\u0003¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096\u0001J\u0013\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\u0016\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u000bH\u0096\u0003¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u0016\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u000fH\u0016J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0096\u0003J\u0016\u0010!\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001dJ\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0096\u0001J\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010\u0019\u001a\u00020\u000bH\u0096\u0001J&\u0010$\u001a\b\u0012\u0004\u0012\u0002H%0\u0000\"\u0004\b\u0001\u0010%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H%0'J;\u0010(\u001a\b\u0012\u0004\u0012\u0002H%0\u0000\"\u0004\b\u0001\u0010%2'\u0010&\u001a#\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H%0)J\u001f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0096\u0001J\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\b\u00100\u001a\u000201H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u00062"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "head", "tail", "(Ljava/lang/Object;Ljava/util/List;)V", SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL, "(Ljava/util/List;)V", "getHead", "()Ljava/lang/Object;", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "equals", "other", "", "get", FirebaseAnalytics.Param.INDEX, "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "map", "B", "transform", "Lkotlin/Function1;", "mapIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "subList", "fromIndex", "toIndex", "toList", InAppPurchaseConstants.METHOD_TO_STRING, "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NonEmptyList<A> implements List<A>, KMappedMarker {
    public static final int $stable = 8;
    private final List<A> all;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NonEmptyList(A a2, List<? extends A> tail) {
        this(CollectionsKt.plus((Collection) CollectionsKt.listOf(a2), (Iterable) tail));
        Intrinsics.checkNotNullParameter(tail, "tail");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private NonEmptyList(List<? extends A> list) {
        this.all = list;
    }

    @Override // java.util.List
    public void add(int i, A a2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(A a2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends A> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends A> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addFirst(A a2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addLast(A a2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object element) {
        return this.all.contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.all.containsAll(elements);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object other) {
        boolean z = other instanceof NonEmptyList;
        List<A> list = this.all;
        return z ? Intrinsics.areEqual(list, ((NonEmptyList) other).all) : Intrinsics.areEqual(list, other);
    }

    @Override // java.util.List
    public A get(int index) {
        return this.all.get(index);
    }

    public final /* synthetic */ Object getHead() {
        return CollectionsKt.first((List) this.all);
    }

    public int getSize() {
        return this.all.size();
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.all.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        return this.all.indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public /* synthetic */ boolean isEmpty() {
        return false;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<A> iterator() {
        return this.all.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        return this.all.lastIndexOf(element);
    }

    @Override // java.util.List
    public ListIterator<A> listIterator() {
        return this.all.listIterator();
    }

    @Override // java.util.List
    public ListIterator<A> listIterator(int index) {
        return this.all.listIterator(index);
    }

    public final /* synthetic */ NonEmptyList map(Function1 transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        List<A> list = this.all;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return new NonEmptyList(arrayList);
    }

    public final /* synthetic */ NonEmptyList mapIndexed(Function2 transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        List<A> list = this.all;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(transform.invoke(Integer.valueOf(i), obj));
            i = i2;
        }
        return new NonEmptyList(arrayList);
    }

    @Override // java.util.List
    public A remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public A removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public A removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<A> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public A set(int i, A a2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public void sort(Comparator<? super A> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<A> subList(int fromIndex, int toIndex) {
        return this.all.subList(fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    /* JADX INFO: renamed from: toList, reason: from getter */
    public final /* synthetic */ List getAll() {
        return this.all;
    }

    public String toString() {
        return "NonEmptyList(" + CollectionsKt.joinToString$default(this.all, null, null, null, 0, null, null, 63, null) + ')';
    }
}
