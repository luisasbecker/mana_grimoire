package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
abstract class UnknownFieldSchema<T, B> {
    static final int DEFAULT_RECURSION_LIMIT = 100;
    private static volatile int recursionLimit = 100;

    UnknownFieldSchema() {
    }

    private final void mergeFrom(B b, Reader reader, int i) throws IOException {
        while (reader.getFieldNumber() != Integer.MAX_VALUE && mergeOneFieldFrom(b, reader, i)) {
        }
    }

    abstract void addFixed32(B b, int i, int i2);

    abstract void addFixed64(B b, int i, long j);

    abstract void addGroup(B b, int i, T t);

    abstract void addLengthDelimited(B b, int i, ByteString byteString);

    abstract void addVarint(B b, int i, long j);

    abstract B getBuilderFromMessage(Object obj);

    abstract T getFromMessage(Object obj);

    abstract int getSerializedSize(T t);

    abstract int getSerializedSizeAsMessageSet(T t);

    abstract void makeImmutable(Object obj);

    abstract T merge(T t, T t2);

    final boolean mergeOneFieldFrom(B b, Reader reader, int i) throws IOException {
        int tag = reader.getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            addVarint(b, tagFieldNumber, reader.readInt64());
            return true;
        }
        if (tagWireType == 1) {
            addFixed64(b, tagFieldNumber, reader.readFixed64());
            return true;
        }
        if (tagWireType == 2) {
            addLengthDelimited(b, tagFieldNumber, reader.readBytes());
            return true;
        }
        if (tagWireType != 3) {
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            addFixed32(b, tagFieldNumber, reader.readFixed32());
            return true;
        }
        B bNewBuilder = newBuilder();
        int iMakeTag = WireFormat.makeTag(tagFieldNumber, 4);
        int i2 = i + 1;
        if (i2 >= recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        mergeFrom(bNewBuilder, reader, i2);
        if (iMakeTag != reader.getTag()) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        addGroup(b, tagFieldNumber, toImmutable(bNewBuilder));
        return true;
    }

    abstract B newBuilder();

    abstract void setBuilderToMessage(Object obj, B b);

    public void setRecursionLimit(int i) {
        recursionLimit = i;
    }

    abstract void setToMessage(Object obj, T t);

    abstract boolean shouldDiscardUnknownFields(Reader reader);

    abstract T toImmutable(B b);

    abstract void writeAsMessageSetTo(T t, Writer writer) throws IOException;

    abstract void writeTo(T t, Writer writer) throws IOException;
}
