package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.HpkeParams;
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
public final class HpkeKeyFormat extends GeneratedMessageLite<HpkeKeyFormat, Builder> implements HpkeKeyFormatOrBuilder {
    private static final HpkeKeyFormat DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<HpkeKeyFormat> PARSER;
    private HpkeParams params_;

    /* JADX INFO: renamed from: com.google.crypto.tink.proto.HpkeKeyFormat$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HpkeKeyFormat, Builder> implements HpkeKeyFormatOrBuilder {
        private Builder() {
            super(HpkeKeyFormat.DEFAULT_INSTANCE);
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

        public Builder clearParams() {
            copyOnWrite();
            ((HpkeKeyFormat) this.instance).clearParams();
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

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.crypto.tink.proto.HpkeKeyFormatOrBuilder
        public HpkeParams getParams() {
            return ((HpkeKeyFormat) this.instance).getParams();
        }

        @Override // com.google.crypto.tink.proto.HpkeKeyFormatOrBuilder
        public boolean hasParams() {
            return ((HpkeKeyFormat) this.instance).hasParams();
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

        public Builder mergeParams(HpkeParams hpkeParams) {
            copyOnWrite();
            ((HpkeKeyFormat) this.instance).mergeParams(hpkeParams);
            return this;
        }

        public Builder setParams(HpkeParams.Builder builder) {
            copyOnWrite();
            ((HpkeKeyFormat) this.instance).setParams((HpkeParams) builder.build());
            return this;
        }

        public Builder setParams(HpkeParams hpkeParams) {
            copyOnWrite();
            ((HpkeKeyFormat) this.instance).setParams(hpkeParams);
            return this;
        }
    }

    static {
        HpkeKeyFormat hpkeKeyFormat = new HpkeKeyFormat();
        DEFAULT_INSTANCE = hpkeKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(HpkeKeyFormat.class, hpkeKeyFormat);
    }

    private HpkeKeyFormat() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    public static HpkeKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(HpkeParams hpkeParams) {
        hpkeParams.getClass();
        HpkeParams hpkeParams2 = this.params_;
        if (hpkeParams2 == null || hpkeParams2 == HpkeParams.getDefaultInstance()) {
            this.params_ = hpkeParams;
        } else {
            this.params_ = (HpkeParams) HpkeParams.newBuilder(this.params_).mergeFrom(hpkeParams).buildPartial();
        }
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(HpkeKeyFormat hpkeKeyFormat) {
        return DEFAULT_INSTANCE.createBuilder(hpkeKeyFormat);
    }

    public static HpkeKeyFormat parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HpkeKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HpkeKeyFormat parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HpkeKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HpkeKeyFormat parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HpkeKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HpkeKeyFormat parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HpkeKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HpkeKeyFormat parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HpkeKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HpkeKeyFormat parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HpkeKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static HpkeKeyFormat parseFrom(InputStream inputStream) throws IOException {
        return (HpkeKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HpkeKeyFormat parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HpkeKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HpkeKeyFormat parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HpkeKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static HpkeKeyFormat parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HpkeKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HpkeKeyFormat parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HpkeKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HpkeKeyFormat parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HpkeKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<HpkeKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(HpkeParams hpkeParams) {
        hpkeParams.getClass();
        this.params_ = hpkeParams;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i) {
            case 1:
                return new HpkeKeyFormat();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"params_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HpkeKeyFormat> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HpkeKeyFormat.class) {
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

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return super.getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.HpkeKeyFormatOrBuilder
    public HpkeParams getParams() {
        HpkeParams hpkeParams = this.params_;
        return hpkeParams == null ? HpkeParams.getDefaultInstance() : hpkeParams;
    }

    @Override // com.google.crypto.tink.proto.HpkeKeyFormatOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
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
