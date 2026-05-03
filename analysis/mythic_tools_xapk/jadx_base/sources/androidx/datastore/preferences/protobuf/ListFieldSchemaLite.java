package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class ListFieldSchemaLite implements ListFieldSchema {
    ListFieldSchemaLite() {
    }

    static <E> Internal.ProtobufList<E> getProtobufList(Object obj, long j) {
        return (Internal.ProtobufList) UnsafeUtil.getObject(obj, j);
    }

    @Override // androidx.datastore.preferences.protobuf.ListFieldSchema
    public void makeImmutableListAt(Object obj, long j) {
        getProtobufList(obj, j).makeImmutable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.datastore.preferences.protobuf.Internal$ProtobufList] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.datastore.preferences.protobuf.Internal$ProtobufList, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v3 */
    @Override // androidx.datastore.preferences.protobuf.ListFieldSchema
    public <E> void mergeListsAt(Object obj, Object obj2, long j) {
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

    @Override // androidx.datastore.preferences.protobuf.ListFieldSchema
    public <L> List<L> mutableListAt(Object obj, long j) {
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
