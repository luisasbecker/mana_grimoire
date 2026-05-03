package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes5.dex */
@CheckReturnValue
interface MessageInfoFactory {
    boolean isSupported(Class<?> cls);

    MessageInfo messageInfoFor(Class<?> cls);
}
