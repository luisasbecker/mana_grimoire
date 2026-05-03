package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class JwtEcdsaKeyFormat extends GeneratedMessageLite<JwtEcdsaKeyFormat, Builder> implements JwtEcdsaKeyFormatOrBuilder {
    public static final int ALGORITHM_FIELD_NUMBER = 2;
    private static final JwtEcdsaKeyFormat DEFAULT_INSTANCE;
    private static volatile Parser<JwtEcdsaKeyFormat> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private int algorithm_;
    private int version_;

    /* JADX INFO: renamed from: com.google.crypto.tink.proto.JwtEcdsaKeyFormat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<JwtEcdsaKeyFormat, Builder> implements JwtEcdsaKeyFormatOrBuilder {
        private Builder() {
            super(JwtEcdsaKeyFormat.DEFAULT_INSTANCE);
        }

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return super.build();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return super.buildPartial();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return super.clear();
        }

        public Builder clearAlgorithm() {
            copyOnWrite();
            ((JwtEcdsaKeyFormat) this.instance).clearAlgorithm();
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((JwtEcdsaKeyFormat) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10168clone() {
            return super.mo10168clone();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ MessageLite.Builder mo10168clone() {
            return super.mo10168clone();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo10168clone() throws CloneNotSupportedException {
            return super.mo10168clone();
        }

        @Override // com.google.crypto.tink.proto.JwtEcdsaKeyFormatOrBuilder
        public JwtEcdsaAlgorithm getAlgorithm() {
            return ((JwtEcdsaKeyFormat) this.instance).getAlgorithm();
        }

        @Override // com.google.crypto.tink.proto.JwtEcdsaKeyFormatOrBuilder
        public int getAlgorithmValue() {
            return ((JwtEcdsaKeyFormat) this.instance).getAlgorithmValue();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.crypto.tink.proto.JwtEcdsaKeyFormatOrBuilder
        public int getVersion() {
            return ((JwtEcdsaKeyFormat) this.instance).getVersion();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder
        protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite abstractMessageLite) {
            return super.internalMergeFrom((GeneratedMessageLite) abstractMessageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return super.mergeFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            return super.mergeFrom(bArr, i, i2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return super.mergeFrom(bArr, i, i2, extensionRegistryLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return super.mergeFrom(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return super.mergeFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream) throws IOException {
            return super.mergeFrom(codedInputStream);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return super.mergeFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(MessageLite messageLite) {
            return super.mergeFrom(messageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream inputStream) throws IOException {
            return super.mergeFrom(inputStream);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return super.mergeFrom(inputStream, extensionRegistryLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return super.mergeFrom(bArr);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            return super.mergeFrom(bArr, i, i2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return super.mergeFrom(bArr, i, i2, extensionRegistryLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return super.mergeFrom(bArr, extensionRegistryLite);
        }

        public Builder setAlgorithm(JwtEcdsaAlgorithm jwtEcdsaAlgorithm) {
            copyOnWrite();
            ((JwtEcdsaKeyFormat) this.instance).setAlgorithm(jwtEcdsaAlgorithm);
            return this;
        }

        public Builder setAlgorithmValue(int i) {
            copyOnWrite();
            ((JwtEcdsaKeyFormat) this.instance).setAlgorithmValue(i);
            return this;
        }

        public Builder setVersion(int i) {
            copyOnWrite();
            ((JwtEcdsaKeyFormat) this.instance).setVersion(i);
            return this;
        }
    }

    static {
        JwtEcdsaKeyFormat jwtEcdsaKeyFormat = new JwtEcdsaKeyFormat();
        DEFAULT_INSTANCE = jwtEcdsaKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(JwtEcdsaKeyFormat.class, jwtEcdsaKeyFormat);
    }

    private JwtEcdsaKeyFormat() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlgorithm() {
        this.algorithm_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public static JwtEcdsaKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(JwtEcdsaKeyFormat jwtEcdsaKeyFormat) {
        return DEFAULT_INSTANCE.createBuilder(jwtEcdsaKeyFormat);
    }

    public static JwtEcdsaKeyFormat parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (JwtEcdsaKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static JwtEcdsaKeyFormat parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtEcdsaKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static JwtEcdsaKeyFormat parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (JwtEcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static JwtEcdsaKeyFormat parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JwtEcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static JwtEcdsaKeyFormat parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (JwtEcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static JwtEcdsaKeyFormat parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtEcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static JwtEcdsaKeyFormat parseFrom(InputStream inputStream) throws IOException {
        return (JwtEcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static JwtEcdsaKeyFormat parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtEcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static JwtEcdsaKeyFormat parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (JwtEcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static JwtEcdsaKeyFormat parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JwtEcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static JwtEcdsaKeyFormat parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (JwtEcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static JwtEcdsaKeyFormat parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JwtEcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<JwtEcdsaKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlgorithm(JwtEcdsaAlgorithm jwtEcdsaAlgorithm) {
        this.algorithm_ = jwtEcdsaAlgorithm.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlgorithmValue(int i) {
        this.algorithm_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int i) {
        this.version_ = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i) {
            case 1:
                return new JwtEcdsaKeyFormat();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\f", new Object[]{"version_", "algorithm_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<JwtEcdsaKeyFormat> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (JwtEcdsaKeyFormat.class) {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.crypto.tink.proto.JwtEcdsaKeyFormatOrBuilder
    public JwtEcdsaAlgorithm getAlgorithm() {
        JwtEcdsaAlgorithm jwtEcdsaAlgorithmForNumber = JwtEcdsaAlgorithm.forNumber(this.algorithm_);
        return jwtEcdsaAlgorithmForNumber == null ? JwtEcdsaAlgorithm.UNRECOGNIZED : jwtEcdsaAlgorithmForNumber;
    }

    @Override // com.google.crypto.tink.proto.JwtEcdsaKeyFormatOrBuilder
    public int getAlgorithmValue() {
        return this.algorithm_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return super.getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.JwtEcdsaKeyFormatOrBuilder
    public int getVersion() {
        return this.version_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return super.newBuilderForType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return super.toBuilder();
    }
}
