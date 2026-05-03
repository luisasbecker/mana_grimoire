package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
interface MessageInfo {
    MessageLite getDefaultInstance();

    ProtoSyntax getSyntax();

    boolean isMessageSetWireFormat();
}
