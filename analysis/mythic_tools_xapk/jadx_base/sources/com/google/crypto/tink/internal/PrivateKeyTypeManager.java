package com.google.crypto.tink.internal;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PrivateKeyTypeManager<KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> extends KeyTypeManager<KeyProtoT> {
    private final Class<PublicKeyProtoT> publicKeyClazz;

    @SafeVarargs
    protected PrivateKeyTypeManager(Class<KeyProtoT> cls, Class<PublicKeyProtoT> cls2, PrimitiveFactory<?, KeyProtoT>... primitiveFactoryArr) {
        super(cls, primitiveFactoryArr);
        this.publicKeyClazz = cls2;
    }

    public abstract PublicKeyProtoT getPublicKey(KeyProtoT keyprotot) throws GeneralSecurityException;

    public final Class<PublicKeyProtoT> getPublicKeyClass() {
        return this.publicKeyClazz;
    }
}
