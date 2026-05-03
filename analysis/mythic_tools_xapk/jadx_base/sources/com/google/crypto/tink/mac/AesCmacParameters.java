package com.google.crypto.tink.mac;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class AesCmacParameters extends MacParameters {
    private final int keySizeBytes;
    private final int tagSizeBytes;
    private final Variant variant;

    public static final class Builder {

        @Nullable
        private Integer keySizeBytes;

        @Nullable
        private Integer tagSizeBytes;
        private Variant variant;

        private Builder() {
            this.keySizeBytes = null;
            this.tagSizeBytes = null;
            this.variant = Variant.NO_PREFIX;
        }

        public AesCmacParameters build() throws GeneralSecurityException {
            if (this.keySizeBytes == null) {
                throw new GeneralSecurityException("key size not set");
            }
            if (this.tagSizeBytes == null) {
                throw new GeneralSecurityException("tag size not set");
            }
            if (this.variant != null) {
                return new AesCmacParameters(this.keySizeBytes.intValue(), this.tagSizeBytes.intValue(), this.variant);
            }
            throw new GeneralSecurityException("variant not set");
        }

        public Builder setKeySizeBytes(int i) throws GeneralSecurityException {
            if (i != 16 && i != 32) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i * 8)));
            }
            this.keySizeBytes = Integer.valueOf(i);
            return this;
        }

        public Builder setTagSizeBytes(int i) throws GeneralSecurityException {
            if (i < 10 || 16 < i) {
                throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i);
            }
            this.tagSizeBytes = Integer.valueOf(i);
            return this;
        }

        public Builder setVariant(Variant variant) {
            this.variant = variant;
            return this;
        }
    }

    @Immutable
    public static final class Variant {
        private final String name;
        public static final Variant TINK = new Variant("TINK");
        public static final Variant CRUNCHY = new Variant("CRUNCHY");
        public static final Variant LEGACY = new Variant("LEGACY");
        public static final Variant NO_PREFIX = new Variant("NO_PREFIX");

        private Variant(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    private AesCmacParameters(int i, int i2, Variant variant) {
        this.keySizeBytes = i;
        this.tagSizeBytes = i2;
        this.variant = variant;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AesCmacParameters)) {
            return false;
        }
        AesCmacParameters aesCmacParameters = (AesCmacParameters) obj;
        return aesCmacParameters.getKeySizeBytes() == getKeySizeBytes() && aesCmacParameters.getTotalTagSizeBytes() == getTotalTagSizeBytes() && aesCmacParameters.getVariant() == getVariant();
    }

    public int getCryptographicTagSizeBytes() {
        return this.tagSizeBytes;
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes;
    }

    public int getTotalTagSizeBytes() {
        if (this.variant == Variant.NO_PREFIX) {
            return getCryptographicTagSizeBytes();
        }
        if (this.variant != Variant.TINK && this.variant != Variant.CRUNCHY && this.variant != Variant.LEGACY) {
            throw new IllegalStateException("Unknown variant");
        }
        int cryptographicTagSizeBytes = getCryptographicTagSizeBytes();
        return cryptographicTagSizeBytes + 5;
    }

    public Variant getVariant() {
        return this.variant;
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return this.variant != Variant.NO_PREFIX;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.keySizeBytes), Integer.valueOf(this.tagSizeBytes), this.variant);
    }

    public String toString() {
        return "AES-CMAC Parameters (variant: " + this.variant + ", " + this.tagSizeBytes + "-byte tags, and " + this.keySizeBytes + "-byte key)";
    }
}
