package com.google.crypto.tink;

import com.google.crypto.tink.internal.JsonParser;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;

/* JADX INFO: loaded from: classes5.dex */
public final class JsonKeysetReader implements KeysetReader {
    private static final long MAX_KEY_ID = 4294967295L;
    private static final long MIN_KEY_ID = -2147483648L;
    private static final Charset UTF_8 = Charset.forName(com.bumptech.glide.load.Key.STRING_CHARSET_NAME);
    private final InputStream inputStream;
    private boolean urlSafeBase64 = false;

    private JsonKeysetReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private EncryptedKeyset encryptedKeysetFromJson(JsonObject jsonObject) throws IOException {
        validateEncryptedKeyset(jsonObject);
        byte[] bArrUrlSafeDecode = this.urlSafeBase64 ? Base64.urlSafeDecode(jsonObject.get("encryptedKeyset").getAsString()) : Base64.decode(jsonObject.get("encryptedKeyset").getAsString());
        return jsonObject.has("keysetInfo") ? (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(bArrUrlSafeDecode)).setKeysetInfo(keysetInfoFromJson(jsonObject.getAsJsonObject("keysetInfo"))).build() : (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(bArrUrlSafeDecode)).build();
    }

    private static int getKeyId(JsonElement jsonElement) throws IOException {
        try {
            long parsedNumberAsLongOrThrow = JsonParser.getParsedNumberAsLongOrThrow(jsonElement);
            if (parsedNumberAsLongOrThrow > 4294967295L || parsedNumberAsLongOrThrow < -2147483648L) {
                throw new IOException("invalid key id");
            }
            return (int) jsonElement.getAsLong();
        } catch (NumberFormatException e) {
            throw new IOException(e);
        }
    }

    private static KeyData.KeyMaterialType getKeyMaterialType(String str) {
        str.hashCode();
        switch (str) {
            case "REMOTE":
                return KeyData.KeyMaterialType.REMOTE;
            case "SYMMETRIC":
                return KeyData.KeyMaterialType.SYMMETRIC;
            case "ASYMMETRIC_PRIVATE":
                return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
            case "ASYMMETRIC_PUBLIC":
                return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
            default:
                throw new JsonParseException("unknown key material type: " + str);
        }
    }

    private static OutputPrefixType getOutputPrefixType(String str) {
        str.hashCode();
        switch (str) {
            case "LEGACY":
                return OutputPrefixType.LEGACY;
            case "RAW":
                return OutputPrefixType.RAW;
            case "TINK":
                return OutputPrefixType.TINK;
            case "CRUNCHY":
                return OutputPrefixType.CRUNCHY;
            default:
                throw new JsonParseException("unknown output prefix type: " + str);
        }
    }

    private static KeyStatusType getStatus(String str) {
        str.hashCode();
        switch (str) {
            case "ENABLED":
                return KeyStatusType.ENABLED;
            case "DESTROYED":
                return KeyStatusType.DESTROYED;
            case "DISABLED":
                return KeyStatusType.DISABLED;
            default:
                throw new JsonParseException("unknown status: " + str);
        }
    }

    private KeyData keyDataFromJson(JsonObject jsonObject) {
        validateKeyData(jsonObject);
        return (KeyData) KeyData.newBuilder().setTypeUrl(jsonObject.get("typeUrl").getAsString()).setValue(ByteString.copyFrom(this.urlSafeBase64 ? Base64.urlSafeDecode(jsonObject.get("value").getAsString()) : Base64.decode(jsonObject.get("value").getAsString()))).setKeyMaterialType(getKeyMaterialType(jsonObject.get("keyMaterialType").getAsString())).build();
    }

    private Keyset.Key keyFromJson(JsonObject jsonObject) throws IOException {
        validateKey(jsonObject);
        return (Keyset.Key) Keyset.Key.newBuilder().setStatus(getStatus(jsonObject.get("status").getAsString())).setKeyId(getKeyId(jsonObject.get("keyId"))).setOutputPrefixType(getOutputPrefixType(jsonObject.get("outputPrefixType").getAsString())).setKeyData(keyDataFromJson(jsonObject.getAsJsonObject("keyData"))).build();
    }

    private static KeysetInfo.KeyInfo keyInfoFromJson(JsonObject jsonObject) throws IOException {
        return (KeysetInfo.KeyInfo) KeysetInfo.KeyInfo.newBuilder().setStatus(getStatus(jsonObject.get("status").getAsString())).setKeyId(getKeyId(jsonObject.get("keyId"))).setOutputPrefixType(getOutputPrefixType(jsonObject.get("outputPrefixType").getAsString())).setTypeUrl(jsonObject.get("typeUrl").getAsString()).build();
    }

    private Keyset keysetFromJson(JsonObject jsonObject) throws IOException {
        validateKeyset(jsonObject);
        Keyset.Builder builderNewBuilder = Keyset.newBuilder();
        if (jsonObject.has("primaryKeyId")) {
            builderNewBuilder.setPrimaryKeyId(getKeyId(jsonObject.get("primaryKeyId")));
        }
        JsonArray asJsonArray = jsonObject.getAsJsonArray(SubscriberAttributeKt.JSON_NAME_KEY);
        for (int i = 0; i < asJsonArray.size(); i++) {
            builderNewBuilder.addKey(keyFromJson(asJsonArray.get(i).getAsJsonObject()));
        }
        return (Keyset) builderNewBuilder.build();
    }

    private static KeysetInfo keysetInfoFromJson(JsonObject jsonObject) throws IOException {
        KeysetInfo.Builder builderNewBuilder = KeysetInfo.newBuilder();
        if (jsonObject.has("primaryKeyId")) {
            builderNewBuilder.setPrimaryKeyId(getKeyId(jsonObject.get("primaryKeyId")));
        }
        if (jsonObject.has("keyInfo")) {
            JsonArray asJsonArray = jsonObject.getAsJsonArray("keyInfo");
            for (int i = 0; i < asJsonArray.size(); i++) {
                builderNewBuilder.addKeyInfo(keyInfoFromJson(asJsonArray.get(i).getAsJsonObject()));
            }
        }
        return (KeysetInfo) builderNewBuilder.build();
    }

    private static void validateEncryptedKeyset(JsonObject jsonObject) {
        if (!jsonObject.has("encryptedKeyset")) {
            throw new JsonParseException("invalid encrypted keyset");
        }
    }

    private static void validateKey(JsonObject jsonObject) {
        if (!jsonObject.has("keyData") || !jsonObject.has("status") || !jsonObject.has("keyId") || !jsonObject.has("outputPrefixType")) {
            throw new JsonParseException("invalid key");
        }
    }

    private static void validateKeyData(JsonObject jsonObject) {
        if (!jsonObject.has("typeUrl") || !jsonObject.has("value") || !jsonObject.has("keyMaterialType")) {
            throw new JsonParseException("invalid keyData");
        }
    }

    private static void validateKeyset(JsonObject jsonObject) {
        if (!jsonObject.has(SubscriberAttributeKt.JSON_NAME_KEY) || jsonObject.getAsJsonArray(SubscriberAttributeKt.JSON_NAME_KEY).size() == 0) {
            throw new JsonParseException("invalid keyset");
        }
    }

    public static JsonKeysetReader withBytes(byte[] bArr) {
        return new JsonKeysetReader(new ByteArrayInputStream(bArr));
    }

    @Deprecated
    public static JsonKeysetReader withFile(File file) throws IOException {
        return withInputStream(new FileInputStream(file));
    }

    public static JsonKeysetReader withInputStream(InputStream inputStream) throws IOException {
        return new JsonKeysetReader(inputStream);
    }

    @Deprecated
    public static JsonKeysetReader withJsonObject(Object obj) {
        return withString(obj.toString());
    }

    @Deprecated
    public static JsonKeysetReader withPath(String str) throws IOException {
        return withInputStream(new FileInputStream(new File(str)));
    }

    @Deprecated
    public static JsonKeysetReader withPath(Path path) throws IOException {
        return withInputStream(new FileInputStream(path.toFile()));
    }

    public static JsonKeysetReader withString(String str) {
        return new JsonKeysetReader(new ByteArrayInputStream(str.getBytes(UTF_8)));
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() throws IOException {
        try {
            try {
                return keysetFromJson(JsonParser.parse(new String(Util.readAll(this.inputStream), UTF_8)).getAsJsonObject());
            } finally {
                InputStream inputStream = this.inputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (JsonParseException | IllegalStateException e) {
            throw new IOException(e);
        }
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset readEncrypted() throws IOException {
        try {
            try {
                return encryptedKeysetFromJson(JsonParser.parse(new String(Util.readAll(this.inputStream), UTF_8)).getAsJsonObject());
            } finally {
                InputStream inputStream = this.inputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (JsonParseException | IllegalStateException e) {
            throw new IOException(e);
        }
    }

    public JsonKeysetReader withUrlSafeBase64() {
        this.urlSafeBase64 = true;
        return this;
    }
}
