package com.google.crypto.tink.jwt;

import androidx.camera.video.AudioStats;
import com.facebook.AuthenticationTokenClaims;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.errorprone.annotations.Immutable;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
@Immutable
public final class RawJwt {
    private static final long MAX_TIMESTAMP_VALUE = 253402300799L;
    private final JsonObject payload;
    private final Optional<String> typeHeader;

    public static final class Builder {
        private final JsonObject payload;
        private Optional<String> typeHeader;
        private boolean withoutExpiration;

        private Builder() {
            this.typeHeader = Optional.empty();
            this.withoutExpiration = false;
            this.payload = new JsonObject();
        }

        private void setTimestampClaim(String str, Instant instant) {
            long epochSecond = instant.getEpochSecond();
            if (epochSecond > RawJwt.MAX_TIMESTAMP_VALUE || epochSecond < 0) {
                throw new IllegalArgumentException("timestamp of claim " + str + " is out of range");
            }
            this.payload.add(str, new JsonPrimitive(Long.valueOf(epochSecond)));
        }

        public Builder addAudience(String str) {
            JsonArray jsonArray;
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException("invalid string");
            }
            if (this.payload.has(AuthenticationTokenClaims.JSON_KEY_AUD)) {
                JsonElement jsonElement = this.payload.get(AuthenticationTokenClaims.JSON_KEY_AUD);
                if (!jsonElement.isJsonArray()) {
                    throw new IllegalArgumentException("addAudience can't be used together with setAudience");
                }
                jsonArray = jsonElement.getAsJsonArray();
            } else {
                jsonArray = new JsonArray();
            }
            jsonArray.add(str);
            this.payload.add(AuthenticationTokenClaims.JSON_KEY_AUD, jsonArray);
            return this;
        }

        public Builder addBooleanClaim(String str, boolean z) {
            JwtNames.validate(str);
            this.payload.add(str, new JsonPrimitive(Boolean.valueOf(z)));
            return this;
        }

        public Builder addJsonArrayClaim(String str, String str2) throws JwtInvalidException {
            JwtNames.validate(str);
            this.payload.add(str, JsonUtil.parseJsonArray(str2));
            return this;
        }

        public Builder addJsonObjectClaim(String str, String str2) throws JwtInvalidException {
            JwtNames.validate(str);
            this.payload.add(str, JsonUtil.parseJson(str2));
            return this;
        }

        public Builder addNullClaim(String str) {
            JwtNames.validate(str);
            this.payload.add(str, JsonNull.INSTANCE);
            return this;
        }

        public Builder addNumberClaim(String str, double d) {
            JwtNames.validate(str);
            this.payload.add(str, new JsonPrimitive(Double.valueOf(d)));
            return this;
        }

        public Builder addStringClaim(String str, String str2) {
            if (!JsonUtil.isValidString(str2)) {
                throw new IllegalArgumentException();
            }
            JwtNames.validate(str);
            this.payload.add(str, new JsonPrimitive(str2));
            return this;
        }

        public RawJwt build() {
            return new RawJwt(this);
        }

        public Builder setAudience(String str) {
            if (this.payload.has(AuthenticationTokenClaims.JSON_KEY_AUD) && this.payload.get(AuthenticationTokenClaims.JSON_KEY_AUD).isJsonArray()) {
                throw new IllegalArgumentException("setAudience can't be used together with setAudiences or addAudience");
            }
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException("invalid string");
            }
            this.payload.add(AuthenticationTokenClaims.JSON_KEY_AUD, new JsonPrimitive(str));
            return this;
        }

        public Builder setAudiences(List<String> list) {
            if (this.payload.has(AuthenticationTokenClaims.JSON_KEY_AUD) && !this.payload.get(AuthenticationTokenClaims.JSON_KEY_AUD).isJsonArray()) {
                throw new IllegalArgumentException("setAudiences can't be used together with setAudience");
            }
            if (list.isEmpty()) {
                throw new IllegalArgumentException("audiences must not be empty");
            }
            JsonArray jsonArray = new JsonArray();
            for (String str : list) {
                if (!JsonUtil.isValidString(str)) {
                    throw new IllegalArgumentException("invalid string");
                }
                jsonArray.add(str);
            }
            this.payload.add(AuthenticationTokenClaims.JSON_KEY_AUD, jsonArray);
            return this;
        }

        public Builder setExpiration(Instant instant) {
            setTimestampClaim(AuthenticationTokenClaims.JSON_KEY_EXP, instant);
            return this;
        }

        public Builder setIssuedAt(Instant instant) {
            setTimestampClaim(AuthenticationTokenClaims.JSON_KEY_IAT, instant);
            return this;
        }

        public Builder setIssuer(String str) {
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException();
            }
            this.payload.add(AuthenticationTokenClaims.JSON_KEY_ISS, new JsonPrimitive(str));
            return this;
        }

        public Builder setJwtId(String str) {
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException();
            }
            this.payload.add(AuthenticationTokenClaims.JSON_KEY_JIT, new JsonPrimitive(str));
            return this;
        }

        public Builder setNotBefore(Instant instant) {
            setTimestampClaim("nbf", instant);
            return this;
        }

        public Builder setSubject(String str) {
            if (!JsonUtil.isValidString(str)) {
                throw new IllegalArgumentException();
            }
            this.payload.add(AuthenticationTokenClaims.JSON_KEY_SUB, new JsonPrimitive(str));
            return this;
        }

        public Builder setTypeHeader(String str) {
            this.typeHeader = Optional.of(str);
            return this;
        }

        public Builder withoutExpiration() {
            this.withoutExpiration = true;
            return this;
        }
    }

    private RawJwt(Builder builder) {
        if (!builder.payload.has(AuthenticationTokenClaims.JSON_KEY_EXP) && !builder.withoutExpiration) {
            throw new IllegalArgumentException("neither setExpiration() nor withoutExpiration() was called");
        }
        if (builder.payload.has(AuthenticationTokenClaims.JSON_KEY_EXP) && builder.withoutExpiration) {
            throw new IllegalArgumentException("setExpiration() and withoutExpiration() must not be called together");
        }
        this.typeHeader = builder.typeHeader;
        this.payload = builder.payload.deepCopy();
    }

    private RawJwt(Optional<String> optional, String str) throws JwtInvalidException {
        this.typeHeader = optional;
        this.payload = JsonUtil.parseJson(str);
        validateStringClaim(AuthenticationTokenClaims.JSON_KEY_ISS);
        validateStringClaim(AuthenticationTokenClaims.JSON_KEY_SUB);
        validateStringClaim(AuthenticationTokenClaims.JSON_KEY_JIT);
        validateTimestampClaim(AuthenticationTokenClaims.JSON_KEY_EXP);
        validateTimestampClaim("nbf");
        validateTimestampClaim(AuthenticationTokenClaims.JSON_KEY_IAT);
        validateAudienceClaim();
    }

    static RawJwt fromJsonPayload(Optional<String> optional, String str) throws JwtInvalidException {
        return new RawJwt(optional, str);
    }

    private Instant getInstant(String str) throws JwtInvalidException {
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (!this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isNumber()) {
            throw new JwtInvalidException("claim " + str + " is not a timestamp");
        }
        try {
            return Instant.ofEpochMilli((long) (this.payload.get(str).getAsJsonPrimitive().getAsDouble() * 1000.0d));
        } catch (NumberFormatException e) {
            throw new JwtInvalidException("claim " + str + " is not a timestamp: " + e);
        }
    }

    private String getStringClaimInternal(String str) throws JwtInvalidException {
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isString()) {
            return this.payload.get(str).getAsString();
        }
        throw new JwtInvalidException("claim " + str + " is not a string");
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private void validateAudienceClaim() throws JwtInvalidException {
        if (this.payload.has(AuthenticationTokenClaims.JSON_KEY_AUD)) {
            if (!(this.payload.get(AuthenticationTokenClaims.JSON_KEY_AUD).isJsonPrimitive() && this.payload.get(AuthenticationTokenClaims.JSON_KEY_AUD).getAsJsonPrimitive().isString()) && getAudiences().size() < 1) {
                throw new JwtInvalidException("invalid JWT payload: claim aud is present but empty.");
            }
        }
    }

    private void validateStringClaim(String str) throws JwtInvalidException {
        if (this.payload.has(str)) {
            if (!this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isString()) {
                throw new JwtInvalidException("invalid JWT payload: claim " + str + " is not a string.");
            }
        }
    }

    private void validateTimestampClaim(String str) throws JwtInvalidException {
        if (this.payload.has(str)) {
            if (!this.payload.get(str).isJsonPrimitive() || !this.payload.get(str).getAsJsonPrimitive().isNumber()) {
                throw new JwtInvalidException("invalid JWT payload: claim " + str + " is not a number.");
            }
            double asDouble = this.payload.get(str).getAsJsonPrimitive().getAsDouble();
            if (asDouble > 2.53402300799E11d || asDouble < AudioStats.AUDIO_AMPLITUDE_NONE) {
                throw new JwtInvalidException("invalid JWT payload: claim " + str + " has an invalid timestamp");
            }
        }
    }

    Set<String> customClaimNames() {
        HashSet hashSet = new HashSet();
        for (String str : this.payload.keySet()) {
            if (!JwtNames.isRegisteredName(str)) {
                hashSet.add(str);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    List<String> getAudiences() throws JwtInvalidException {
        if (!hasAudiences()) {
            throw new JwtInvalidException("claim aud does not exist");
        }
        JsonElement jsonElement = this.payload.get(AuthenticationTokenClaims.JSON_KEY_AUD);
        if (jsonElement.isJsonPrimitive()) {
            if (jsonElement.getAsJsonPrimitive().isString()) {
                return Collections.unmodifiableList(Arrays.asList(jsonElement.getAsString()));
            }
            throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", jsonElement));
        }
        if (!jsonElement.isJsonArray()) {
            throw new JwtInvalidException("claim aud is not a string or a JSON array");
        }
        JsonArray asJsonArray = jsonElement.getAsJsonArray();
        ArrayList arrayList = new ArrayList(asJsonArray.size());
        for (int i = 0; i < asJsonArray.size(); i++) {
            if (!asJsonArray.get(i).isJsonPrimitive() || !asJsonArray.get(i).getAsJsonPrimitive().isString()) {
                throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", asJsonArray.get(i)));
            }
            arrayList.add(asJsonArray.get(i).getAsString());
        }
        return Collections.unmodifiableList(arrayList);
    }

    Boolean getBooleanClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isBoolean()) {
            return Boolean.valueOf(this.payload.get(str).getAsBoolean());
        }
        throw new JwtInvalidException("claim " + str + " is not a boolean");
    }

    Instant getExpiration() throws JwtInvalidException {
        return getInstant(AuthenticationTokenClaims.JSON_KEY_EXP);
    }

    Instant getIssuedAt() throws JwtInvalidException {
        return getInstant(AuthenticationTokenClaims.JSON_KEY_IAT);
    }

    String getIssuer() throws JwtInvalidException {
        return getStringClaimInternal(AuthenticationTokenClaims.JSON_KEY_ISS);
    }

    String getJsonArrayClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (this.payload.get(str).isJsonArray()) {
            return this.payload.get(str).getAsJsonArray().toString();
        }
        throw new JwtInvalidException("claim " + str + " is not a JSON array");
    }

    String getJsonObjectClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (this.payload.get(str).isJsonObject()) {
            return this.payload.get(str).getAsJsonObject().toString();
        }
        throw new JwtInvalidException("claim " + str + " is not a JSON object");
    }

    String getJsonPayload() {
        return this.payload.toString();
    }

    String getJwtId() throws JwtInvalidException {
        return getStringClaimInternal(AuthenticationTokenClaims.JSON_KEY_JIT);
    }

    Instant getNotBefore() throws JwtInvalidException {
        return getInstant("nbf");
    }

    Double getNumberClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.has(str)) {
            throw new JwtInvalidException("claim " + str + " does not exist");
        }
        if (this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isNumber()) {
            return Double.valueOf(this.payload.get(str).getAsDouble());
        }
        throw new JwtInvalidException("claim " + str + " is not a number");
    }

    String getStringClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        return getStringClaimInternal(str);
    }

    String getSubject() throws JwtInvalidException {
        return getStringClaimInternal(AuthenticationTokenClaims.JSON_KEY_SUB);
    }

    String getTypeHeader() throws JwtInvalidException {
        if (this.typeHeader.isPresent()) {
            return this.typeHeader.get();
        }
        throw new JwtInvalidException("type header is not set");
    }

    boolean hasAudiences() {
        return this.payload.has(AuthenticationTokenClaims.JSON_KEY_AUD);
    }

    boolean hasBooleanClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isBoolean();
    }

    boolean hasExpiration() {
        return this.payload.has(AuthenticationTokenClaims.JSON_KEY_EXP);
    }

    boolean hasIssuedAt() {
        return this.payload.has(AuthenticationTokenClaims.JSON_KEY_IAT);
    }

    boolean hasIssuer() {
        return this.payload.has(AuthenticationTokenClaims.JSON_KEY_ISS);
    }

    boolean hasJsonArrayClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonArray();
    }

    boolean hasJsonObjectClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonObject();
    }

    boolean hasJwtId() {
        return this.payload.has(AuthenticationTokenClaims.JSON_KEY_JIT);
    }

    boolean hasNotBefore() {
        return this.payload.has("nbf");
    }

    boolean hasNumberClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isNumber();
    }

    boolean hasStringClaim(String str) {
        JwtNames.validate(str);
        return this.payload.has(str) && this.payload.get(str).isJsonPrimitive() && this.payload.get(str).getAsJsonPrimitive().isString();
    }

    boolean hasSubject() {
        return this.payload.has(AuthenticationTokenClaims.JSON_KEY_SUB);
    }

    boolean hasTypeHeader() {
        return this.typeHeader.isPresent();
    }

    boolean isNullClaim(String str) {
        JwtNames.validate(str);
        try {
            return JsonNull.INSTANCE.equals(this.payload.get(str));
        } catch (JsonParseException unused) {
            return false;
        }
    }

    public String toString() {
        JsonObject jsonObject = new JsonObject();
        if (this.typeHeader.isPresent()) {
            jsonObject.add(ClientData.KEY_TYPE, new JsonPrimitive(this.typeHeader.get()));
        }
        return jsonObject + "." + this.payload;
    }
}
