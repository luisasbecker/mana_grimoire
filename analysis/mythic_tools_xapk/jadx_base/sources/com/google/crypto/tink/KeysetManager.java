package com.google.crypto.tink;

import com.google.crypto.tink.internal.KeyStatusTypeProtoConverter;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.crypto.tink.tinkkey.KeyHandle;
import com.google.crypto.tink.tinkkey.internal.ProtoKey;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class KeysetManager {
    private final Keyset.Builder keysetBuilder;

    private KeysetManager(Keyset.Builder builder) {
        this.keysetBuilder = builder;
    }

    private synchronized Keyset.Key createKeysetKey(KeyData keyData, OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        int iNewKeyId;
        iNewKeyId = newKeyId();
        if (outputPrefixType == OutputPrefixType.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return (Keyset.Key) Keyset.Key.newBuilder().setKeyData(keyData).setKeyId(iNewKeyId).setStatus(KeyStatusType.ENABLED).setOutputPrefixType(outputPrefixType).build();
    }

    private synchronized boolean keyIdExists(int i) {
        Iterator<Keyset.Key> it = this.keysetBuilder.getKeyList().iterator();
        while (it.hasNext()) {
            if (it.next().getKeyId() == i) {
                return true;
            }
        }
        return false;
    }

    private synchronized Keyset.Key newKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        return createKeysetKey(Registry.newKeyData(keyTemplate), keyTemplate.getOutputPrefixType());
    }

    private synchronized int newKeyId() {
        int iRandKeyId;
        iRandKeyId = com.google.crypto.tink.internal.Util.randKeyId();
        while (keyIdExists(iRandKeyId)) {
            iRandKeyId = com.google.crypto.tink.internal.Util.randKeyId();
        }
        return iRandKeyId;
    }

    public static KeysetManager withEmptyKeyset() {
        return new KeysetManager(Keyset.newBuilder());
    }

    public static KeysetManager withKeysetHandle(KeysetHandle keysetHandle) {
        return new KeysetManager((Keyset.Builder) keysetHandle.getKeyset().toBuilder());
    }

    public synchronized KeysetManager add(KeyTemplate keyTemplate) throws GeneralSecurityException {
        addNewKey(keyTemplate.getProto(), false);
        return this;
    }

    @Deprecated
    public synchronized KeysetManager add(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        addNewKey(keyTemplate, false);
        return this;
    }

    public synchronized KeysetManager add(KeyHandle keyHandle) throws GeneralSecurityException {
        try {
            try {
                ProtoKey protoKey = (ProtoKey) keyHandle.getKey(com.google.crypto.tink.tinkkey.SecretKeyAccess.insecureSecretAccess());
                if (keyIdExists(keyHandle.getId())) {
                    throw new GeneralSecurityException("Trying to add a key with an ID already contained in the keyset.");
                }
                this.keysetBuilder.addKey((Keyset.Key) Keyset.Key.newBuilder().setKeyData(protoKey.getProtoKey()).setKeyId(keyHandle.getId()).setStatus(KeyStatusTypeProtoConverter.toProto(keyHandle.getStatus())).setOutputPrefixType(KeyTemplate.toProto(protoKey.getOutputPrefixType())).build());
            } catch (ClassCastException e) {
                throw new UnsupportedOperationException("KeyHandles which contain TinkKeys that are not ProtoKeys are not yet supported.", e);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized KeysetManager add(KeyHandle keyHandle, KeyAccess keyAccess) throws GeneralSecurityException {
        return add(keyHandle);
    }

    @Deprecated
    public synchronized int addNewKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate, boolean z) throws GeneralSecurityException {
        Keyset.Key keyNewKey;
        keyNewKey = newKey(keyTemplate);
        this.keysetBuilder.addKey(keyNewKey);
        if (z) {
            this.keysetBuilder.setPrimaryKeyId(keyNewKey.getKeyId());
        }
        return keyNewKey.getKeyId();
    }

    public synchronized KeysetManager delete(int i) throws GeneralSecurityException {
        if (i == this.keysetBuilder.getPrimaryKeyId()) {
            throw new GeneralSecurityException("cannot delete the primary key");
        }
        for (int i2 = 0; i2 < this.keysetBuilder.getKeyCount(); i2++) {
            if (this.keysetBuilder.getKey(i2).getKeyId() == i) {
                this.keysetBuilder.removeKey(i2);
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }

    public synchronized KeysetManager destroy(int i) throws GeneralSecurityException {
        if (i == this.keysetBuilder.getPrimaryKeyId()) {
            throw new GeneralSecurityException("cannot destroy the primary key");
        }
        for (int i2 = 0; i2 < this.keysetBuilder.getKeyCount(); i2++) {
            Keyset.Key key = this.keysetBuilder.getKey(i2);
            if (key.getKeyId() == i) {
                if (key.getStatus() != KeyStatusType.ENABLED && key.getStatus() != KeyStatusType.DISABLED && key.getStatus() != KeyStatusType.DESTROYED) {
                    throw new GeneralSecurityException("cannot destroy key with id " + i);
                }
                this.keysetBuilder.setKey(i2, (Keyset.Key) ((Keyset.Key.Builder) key.toBuilder()).setStatus(KeyStatusType.DESTROYED).clearKeyData().build());
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }

    public synchronized KeysetManager disable(int i) throws GeneralSecurityException {
        if (i == this.keysetBuilder.getPrimaryKeyId()) {
            throw new GeneralSecurityException("cannot disable the primary key");
        }
        for (int i2 = 0; i2 < this.keysetBuilder.getKeyCount(); i2++) {
            Keyset.Key key = this.keysetBuilder.getKey(i2);
            if (key.getKeyId() == i) {
                if (key.getStatus() != KeyStatusType.ENABLED && key.getStatus() != KeyStatusType.DISABLED) {
                    throw new GeneralSecurityException("cannot disable key with id " + i);
                }
                this.keysetBuilder.setKey(i2, (Keyset.Key) ((Keyset.Key.Builder) key.toBuilder()).setStatus(KeyStatusType.DISABLED).build());
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }

    public synchronized KeysetManager enable(int i) throws GeneralSecurityException {
        for (int i2 = 0; i2 < this.keysetBuilder.getKeyCount(); i2++) {
            Keyset.Key key = this.keysetBuilder.getKey(i2);
            if (key.getKeyId() == i) {
                if (key.getStatus() != KeyStatusType.ENABLED && key.getStatus() != KeyStatusType.DISABLED) {
                    throw new GeneralSecurityException("cannot enable key with id " + i);
                }
                this.keysetBuilder.setKey(i2, (Keyset.Key) ((Keyset.Key.Builder) key.toBuilder()).setStatus(KeyStatusType.ENABLED).build());
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }

    public synchronized KeysetHandle getKeysetHandle() throws GeneralSecurityException {
        return KeysetHandle.fromKeyset((Keyset) this.keysetBuilder.build());
    }

    @Deprecated
    public synchronized KeysetManager promote(int i) throws GeneralSecurityException {
        return setPrimary(i);
    }

    @Deprecated
    public synchronized KeysetManager rotate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        addNewKey(keyTemplate, true);
        return this;
    }

    public synchronized KeysetManager setPrimary(int i) throws GeneralSecurityException {
        for (int i2 = 0; i2 < this.keysetBuilder.getKeyCount(); i2++) {
            Keyset.Key key = this.keysetBuilder.getKey(i2);
            if (key.getKeyId() == i) {
                if (!key.getStatus().equals(KeyStatusType.ENABLED)) {
                    throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i);
                }
                this.keysetBuilder.setPrimaryKeyId(i);
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }
}
