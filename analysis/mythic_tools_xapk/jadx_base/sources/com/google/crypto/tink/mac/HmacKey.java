package com.google.crypto.tink.mac;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.mac.HmacParameters;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class HmacKey extends MacKey {

    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final Bytes outputPrefix;
    private final HmacParameters parameters;

    public static class Builder {

        @Nullable
        private Integer idRequirement;

        @Nullable
        private SecretBytes keyBytes;

        @Nullable
        private HmacParameters parameters;

        private Builder() {
            this.parameters = null;
            this.keyBytes = null;
            this.idRequirement = null;
        }

        private Bytes getOutputPrefix() {
            if (this.parameters.getVariant() == HmacParameters.Variant.NO_PREFIX) {
                return Bytes.copyFrom(new byte[0]);
            }
            if (this.parameters.getVariant() == HmacParameters.Variant.LEGACY || this.parameters.getVariant() == HmacParameters.Variant.CRUNCHY) {
                return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(this.idRequirement.intValue()).array());
            }
            if (this.parameters.getVariant() == HmacParameters.Variant.TINK) {
                return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(this.idRequirement.intValue()).array());
            }
            throw new IllegalStateException("Unknown HmacParameters.Variant: " + this.parameters.getVariant());
        }

        public HmacKey build() throws GeneralSecurityException {
            HmacParameters hmacParameters = this.parameters;
            if (hmacParameters == null || this.keyBytes == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (hmacParameters.getKeySizeBytes() != this.keyBytes.size()) {
                throw new GeneralSecurityException("Key size mismatch");
            }
            if (this.parameters.hasIdRequirement() && this.idRequirement == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.parameters.hasIdRequirement() && this.idRequirement != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            return new HmacKey(this.parameters, this.keyBytes, getOutputPrefix(), this.idRequirement);
        }

        public Builder setIdRequirement(@Nullable Integer num) {
            this.idRequirement = num;
            return this;
        }

        public Builder setKeyBytes(SecretBytes secretBytes) {
            this.keyBytes = secretBytes;
            return this;
        }

        public Builder setParameters(HmacParameters hmacParameters) {
            this.parameters = hmacParameters;
            return this;
        }
    }

    private HmacKey(HmacParameters hmacParameters, SecretBytes secretBytes, Bytes bytes, @Nullable Integer num) {
        this.parameters = hmacParameters;
        this.keyBytes = secretBytes;
        this.outputPrefix = bytes;
        this.idRequirement = num;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof HmacKey)) {
            return false;
        }
        HmacKey hmacKey = (HmacKey) key;
        return hmacKey.parameters.equals(this.parameters) && hmacKey.keyBytes.equalsSecretBytes(this.keyBytes) && Objects.equals(hmacKey.idRequirement, this.idRequirement);
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    @Override // com.google.crypto.tink.mac.MacKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    @Override // com.google.crypto.tink.mac.MacKey, com.google.crypto.tink.Key
    public HmacParameters getParameters() {
        return this.parameters;
    }
}
