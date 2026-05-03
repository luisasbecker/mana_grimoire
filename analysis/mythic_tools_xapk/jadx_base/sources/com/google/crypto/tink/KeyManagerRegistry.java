package com.google.crypto.tink;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
final class KeyManagerRegistry {
    private static final Logger logger = Logger.getLogger(KeyManagerRegistry.class.getName());
    private final ConcurrentMap<String, KeyManagerContainer> keyManagerMap;

    private interface KeyManagerContainer {
        Class<?> getImplementingClass();

        <P> KeyManager<P> getKeyManager(Class<P> cls) throws GeneralSecurityException;

        KeyManager<?> getUntypedKeyManager();

        MessageLite parseKey(ByteString byteString) throws InvalidProtocolBufferException, GeneralSecurityException;

        Class<?> publicKeyManagerClassOrNull();

        Set<Class<?>> supportedPrimitives();
    }

    KeyManagerRegistry() {
        this.keyManagerMap = new ConcurrentHashMap();
    }

    KeyManagerRegistry(KeyManagerRegistry keyManagerRegistry) {
        this.keyManagerMap = new ConcurrentHashMap(keyManagerRegistry.keyManagerMap);
    }

    private static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }

    private static <P> KeyManagerContainer createContainerFor(final KeyManager<P> keyManager) {
        return new KeyManagerContainer() { // from class: com.google.crypto.tink.KeyManagerRegistry.1
            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Class<?> getImplementingClass() {
                return keyManager.getClass();
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public <Q> KeyManager<Q> getKeyManager(Class<Q> cls) throws GeneralSecurityException {
                if (keyManager.getPrimitiveClass().equals(cls)) {
                    return keyManager;
                }
                throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public KeyManager<?> getUntypedKeyManager() {
                return keyManager;
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public MessageLite parseKey(ByteString byteString) throws InvalidProtocolBufferException, GeneralSecurityException {
                return null;
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Class<?> publicKeyManagerClassOrNull() {
                return null;
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Set<Class<?>> supportedPrimitives() {
                return Collections.singleton(keyManager.getPrimitiveClass());
            }
        };
    }

    private static <KeyProtoT extends MessageLite> KeyManagerContainer createContainerFor(final KeyTypeManager<KeyProtoT> keyTypeManager) {
        return new KeyManagerContainer() { // from class: com.google.crypto.tink.KeyManagerRegistry.2
            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Class<?> getImplementingClass() {
                return keyTypeManager.getClass();
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public <Q> KeyManager<Q> getKeyManager(Class<Q> cls) throws GeneralSecurityException {
                try {
                    return new KeyManagerImpl(keyTypeManager, cls);
                } catch (IllegalArgumentException e) {
                    throw new GeneralSecurityException("Primitive type not supported", e);
                }
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public KeyManager<?> getUntypedKeyManager() {
                KeyTypeManager keyTypeManager2 = keyTypeManager;
                return new KeyManagerImpl(keyTypeManager2, keyTypeManager2.firstSupportedPrimitiveClass());
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public MessageLite parseKey(ByteString byteString) throws InvalidProtocolBufferException, GeneralSecurityException {
                MessageLite key = keyTypeManager.parseKey(byteString);
                keyTypeManager.validateKey(key);
                return key;
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Class<?> publicKeyManagerClassOrNull() {
                return null;
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Set<Class<?>> supportedPrimitives() {
                return keyTypeManager.supportedPrimitives();
            }
        };
    }

    private static <KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> KeyManagerContainer createPrivateKeyContainerFor(final PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyTypeManager, final KeyTypeManager<PublicKeyProtoT> keyTypeManager) {
        return new KeyManagerContainer() { // from class: com.google.crypto.tink.KeyManagerRegistry.3
            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Class<?> getImplementingClass() {
                return privateKeyTypeManager.getClass();
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public <Q> KeyManager<Q> getKeyManager(Class<Q> cls) throws GeneralSecurityException {
                try {
                    return new PrivateKeyManagerImpl(privateKeyTypeManager, keyTypeManager, cls);
                } catch (IllegalArgumentException e) {
                    throw new GeneralSecurityException("Primitive type not supported", e);
                }
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public KeyManager<?> getUntypedKeyManager() {
                PrivateKeyTypeManager privateKeyTypeManager2 = privateKeyTypeManager;
                return new PrivateKeyManagerImpl(privateKeyTypeManager2, keyTypeManager, privateKeyTypeManager2.firstSupportedPrimitiveClass());
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [com.google.crypto.tink.shaded.protobuf.MessageLite] */
            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public MessageLite parseKey(ByteString byteString) throws InvalidProtocolBufferException, GeneralSecurityException {
                ?? key = privateKeyTypeManager.parseKey(byteString);
                privateKeyTypeManager.validateKey(key);
                return key;
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Class<?> publicKeyManagerClassOrNull() {
                return keyTypeManager.getClass();
            }

            @Override // com.google.crypto.tink.KeyManagerRegistry.KeyManagerContainer
            public Set<Class<?>> supportedPrimitives() {
                return privateKeyTypeManager.supportedPrimitives();
            }
        };
    }

    private synchronized KeyManagerContainer getKeyManagerContainerOrThrow(String str) throws GeneralSecurityException {
        if (!this.keyManagerMap.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str);
        }
        return this.keyManagerMap.get(str);
    }

    private <P> KeyManager<P> getKeyManagerInternal(String str, Class<P> cls) throws GeneralSecurityException {
        KeyManagerContainer keyManagerContainerOrThrow = getKeyManagerContainerOrThrow(str);
        if (cls == null) {
            return (KeyManager<P>) keyManagerContainerOrThrow.getUntypedKeyManager();
        }
        if (keyManagerContainerOrThrow.supportedPrimitives().contains(cls)) {
            return keyManagerContainerOrThrow.getKeyManager(cls);
        }
        throw new GeneralSecurityException("Primitive type " + cls.getName() + " not supported by key manager of type " + keyManagerContainerOrThrow.getImplementingClass() + ", supported primitives: " + toCommaSeparatedString(keyManagerContainerOrThrow.supportedPrimitives()));
    }

    private synchronized <P> void registerKeyManagerContainer(KeyManagerContainer keyManagerContainer, boolean z) throws GeneralSecurityException {
        String keyType = keyManagerContainer.getUntypedKeyManager().getKeyType();
        KeyManagerContainer keyManagerContainer2 = this.keyManagerMap.get(keyType);
        if (keyManagerContainer2 != null && !keyManagerContainer2.getImplementingClass().equals(keyManagerContainer.getImplementingClass())) {
            logger.warning("Attempted overwrite of a registered key manager for key type " + keyType);
            throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", keyType, keyManagerContainer2.getImplementingClass().getName(), keyManagerContainer.getImplementingClass().getName()));
        }
        ConcurrentMap<String, KeyManagerContainer> concurrentMap = this.keyManagerMap;
        if (z) {
            concurrentMap.put(keyType, keyManagerContainer);
        } else {
            concurrentMap.putIfAbsent(keyType, keyManagerContainer);
        }
    }

    private static String toCommaSeparatedString(Set<Class<?>> set) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class<?> cls : set) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls.getCanonicalName());
            z = false;
        }
        return sb.toString();
    }

    @Deprecated
    <P> KeyManager<P> getKeyManager(String str) throws GeneralSecurityException {
        return getKeyManagerInternal(str, null);
    }

    <P> KeyManager<P> getKeyManager(String str, Class<P> cls) throws GeneralSecurityException {
        return getKeyManagerInternal(str, (Class) checkNotNull(cls));
    }

    KeyManager<?> getUntypedKeyManager(String str) throws GeneralSecurityException {
        return getKeyManagerContainerOrThrow(str).getUntypedKeyManager();
    }

    boolean isEmpty() {
        return this.keyManagerMap.isEmpty();
    }

    MessageLite parseKeyData(KeyData keyData) throws InvalidProtocolBufferException, GeneralSecurityException {
        return getKeyManagerContainerOrThrow(keyData.getTypeUrl()).parseKey(keyData.getValue());
    }

    synchronized <KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> void registerAsymmetricKeyManagers(PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyTypeManager, KeyTypeManager<PublicKeyProtoT> keyTypeManager) throws GeneralSecurityException {
        Class<?> clsPublicKeyManagerClassOrNull;
        TinkFipsUtil.AlgorithmFipsCompatibility algorithmFipsCompatibilityFipsStatus = privateKeyTypeManager.fipsStatus();
        TinkFipsUtil.AlgorithmFipsCompatibility algorithmFipsCompatibilityFipsStatus2 = keyTypeManager.fipsStatus();
        if (!algorithmFipsCompatibilityFipsStatus.isCompatible()) {
            throw new GeneralSecurityException("failed to register key manager " + privateKeyTypeManager.getClass() + " as it is not FIPS compatible.");
        }
        if (!algorithmFipsCompatibilityFipsStatus2.isCompatible()) {
            throw new GeneralSecurityException("failed to register key manager " + keyTypeManager.getClass() + " as it is not FIPS compatible.");
        }
        String keyType = privateKeyTypeManager.getKeyType();
        String keyType2 = keyTypeManager.getKeyType();
        if (this.keyManagerMap.containsKey(keyType) && this.keyManagerMap.get(keyType).publicKeyManagerClassOrNull() != null && (clsPublicKeyManagerClassOrNull = this.keyManagerMap.get(keyType).publicKeyManagerClassOrNull()) != null && !clsPublicKeyManagerClassOrNull.getName().equals(keyTypeManager.getClass().getName())) {
            logger.warning("Attempted overwrite of a registered key manager for key type " + keyType + " with inconsistent public key type " + keyType2);
            throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", privateKeyTypeManager.getClass().getName(), clsPublicKeyManagerClassOrNull.getName(), keyTypeManager.getClass().getName()));
        }
        registerKeyManagerContainer(createPrivateKeyContainerFor(privateKeyTypeManager, keyTypeManager), true);
        registerKeyManagerContainer(createContainerFor(keyTypeManager), false);
    }

    synchronized <P> void registerKeyManager(KeyManager<P> keyManager) throws GeneralSecurityException {
        if (!TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible()) {
            throw new GeneralSecurityException("Registering key managers is not supported in FIPS mode");
        }
        registerKeyManagerContainer(createContainerFor(keyManager), false);
    }

    synchronized <KeyProtoT extends MessageLite> void registerKeyManager(KeyTypeManager<KeyProtoT> keyTypeManager) throws GeneralSecurityException {
        if (!keyTypeManager.fipsStatus().isCompatible()) {
            throw new GeneralSecurityException("failed to register key manager " + keyTypeManager.getClass() + " as it is not FIPS compatible.");
        }
        registerKeyManagerContainer(createContainerFor(keyTypeManager), false);
    }

    boolean typeUrlExists(String str) {
        return this.keyManagerMap.containsKey(str);
    }
}
