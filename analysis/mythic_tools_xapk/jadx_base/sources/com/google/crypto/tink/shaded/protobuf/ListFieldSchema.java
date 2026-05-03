package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@CheckReturnValue
abstract class ListFieldSchema {
    private static final ListFieldSchema FULL_INSTANCE;
    private static final ListFieldSchema LITE_INSTANCE;

    private static final class ListFieldSchemaFull extends ListFieldSchema {
        private static final Class<?> UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private ListFieldSchemaFull() {
            super();
        }

        static <E> List<E> getList(Object obj, long j) {
            return (List) UnsafeUtil.getObject(obj, j);
        }

        private static <L> List<L> mutableListAt(Object obj, long j, int i) {
            List<L> list = getList(obj, j);
            if (list.isEmpty()) {
                List<L> lazyStringArrayList = list instanceof LazyStringList ? new LazyStringArrayList(i) : ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) ? ((Internal.ProtobufList) list).mutableCopyWithCapacity2(i) : new ArrayList<>(i);
                UnsafeUtil.putObject(obj, j, lazyStringArrayList);
                return lazyStringArrayList;
            }
            if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                ArrayList arrayList = new ArrayList(list.size() + i);
                arrayList.addAll(list);
                UnsafeUtil.putObject(obj, j, arrayList);
                return arrayList;
            }
            if (list instanceof UnmodifiableLazyStringList) {
                LazyStringArrayList lazyStringArrayList2 = new LazyStringArrayList(list.size() + i);
                lazyStringArrayList2.addAll((UnmodifiableLazyStringList) list);
                UnsafeUtil.putObject(obj, j, lazyStringArrayList2);
                return lazyStringArrayList2;
            }
            if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) {
                Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                if (!protobufList.isModifiable()) {
                    Internal.ProtobufList protobufListMutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(list.size() + i);
                    UnsafeUtil.putObject(obj, j, protobufListMutableCopyWithCapacity2);
                    return protobufListMutableCopyWithCapacity2;
                }
            }
            return list;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        void makeImmutableListAt(Object obj, long j) {
            Object objUnmodifiableList;
            List list = (List) UnsafeUtil.getObject(obj, j);
            if (list instanceof LazyStringList) {
                objUnmodifiableList = ((LazyStringList) list).getUnmodifiableView();
            } else {
                if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            UnsafeUtil.putObject(obj, j, objUnmodifiableList);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        <E> void mergeListsAt(Object obj, Object obj2, long j) {
            List list = getList(obj2, j);
            List listMutableListAt = mutableListAt(obj, j, list.size());
            int size = listMutableListAt.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                listMutableListAt.addAll(list);
            }
            if (size > 0) {
                list = listMutableListAt;
            }
            UnsafeUtil.putObject(obj, j, list);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        <L> List<L> mutableListAt(Object obj, long j) {
            return mutableListAt(obj, j, 10);
        }
    }

    private static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super();
        }

        static <E> Internal.ProtobufList<E> getProtobufList(Object obj, long j) {
            return (Internal.ProtobufList) UnsafeUtil.getObject(obj, j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        void makeImmutableListAt(Object obj, long j) {
            getProtobufList(obj, j).makeImmutable();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList] */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6 */
        /* JADX WARN: Type inference failed for: r3v7 */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r3v9 */
        /* JADX WARN: Type inference failed for: r5v1, types: [com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList, java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v3 */
        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        <E> void mergeListsAt(Object obj, Object obj2, long j) {
            Internal.ProtobufList protobufList = getProtobufList(obj, j);
            ?? protobufList2 = getProtobufList(obj2, j);
            int size = protobufList.size();
            int size2 = protobufList2.size();
            ?? r3 = protobufList;
            r3 = protobufList;
            if (size > 0 && size2 > 0) {
                boolean zIsModifiable = protobufList.isModifiable();
                ?? MutableCopyWithCapacity2 = protobufList;
                if (!zIsModifiable) {
                    MutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(size2 + size);
                }
                MutableCopyWithCapacity2.addAll(protobufList2);
                r3 = MutableCopyWithCapacity2;
            }
            if (size > 0) {
                protobufList2 = r3;
            }
            UnsafeUtil.putObject(obj, j, (Object) protobufList2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        <L> List<L> mutableListAt(Object obj, long j) {
            Internal.ProtobufList protobufList = getProtobufList(obj, j);
            if (protobufList.isModifiable()) {
                return protobufList;
            }
            int size = protobufList.size();
            Internal.ProtobufList protobufListMutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            UnsafeUtil.putObject(obj, j, protobufListMutableCopyWithCapacity2);
            return protobufListMutableCopyWithCapacity2;
        }
    }

    static {
        FULL_INSTANCE = new ListFieldSchemaFull();
        LITE_INSTANCE = new ListFieldSchemaLite();
    }

    private ListFieldSchema() {
    }

    static ListFieldSchema full() {
        return FULL_INSTANCE;
    }

    static ListFieldSchema lite() {
        return LITE_INSTANCE;
    }

    abstract void makeImmutableListAt(Object obj, long j);

    abstract <L> void mergeListsAt(Object obj, Object obj2, long j);

    abstract <L> List<L> mutableListAt(Object obj, long j);
}
