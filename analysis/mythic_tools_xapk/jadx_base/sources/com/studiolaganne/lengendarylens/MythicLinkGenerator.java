package com.studiolaganne.lengendarylens;

import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0016\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007J\u0016\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0007J\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\u0005¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicLinkGenerator;", "", "<init>", "()V", "ALPHABET", "", "BASE", "", "PRIME", "Ljava/math/BigInteger;", "kotlin.jvm.PlatformType", "MULT", "scramble", "", "id", "hashId", "num", "getWebHost", "getUserListUrl", "userId", "listId", "getUserDeckUrl", "deckId", "getUserProfileUrl", "MULT_INV", "unhashId", "encoded", "(Ljava/lang/String;)Ljava/lang/Integer;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MythicLinkGenerator {
    public static final int $stable = 0;
    private static final String ALPHABET = "23456789abcdefghijkmnpqrstuvwyzABCDEFGHJKLMNPQRSTUVWYZ";
    private static final BigInteger MULT;
    private static final BigInteger MULT_INV;
    private static final BigInteger PRIME;
    public static final MythicLinkGenerator INSTANCE = new MythicLinkGenerator();
    private static final int BASE = 54;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(SieveCacheKt.NodeLinkMask);
        PRIME = bigIntegerValueOf;
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(1580030173L);
        MULT = bigIntegerValueOf2;
        MULT_INV = bigIntegerValueOf2.modInverse(bigIntegerValueOf);
    }

    private MythicLinkGenerator() {
    }

    private final String getWebHost() {
        return (new PreferencesManager(LegendaryLensApplication.INSTANCE.applicationContext()).getBoolean(PreferencesManager.FORCE_PREPROD_API, false) || StringsKt.contains$default((CharSequence) "https://api.mythic.tools/", (CharSequence) "preprod", false, 2, (Object) null)) ? "artifact.mythic.tools" : "mythic.tools";
    }

    private final long scramble(int id) {
        if (id == 0) {
            return 0L;
        }
        BigInteger bigIntegerValueOf = BigInteger.valueOf(id);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        BigInteger MULT2 = MULT;
        Intrinsics.checkNotNullExpressionValue(MULT2, "MULT");
        BigInteger bigIntegerMultiply = bigIntegerValueOf.multiply(MULT2);
        Intrinsics.checkNotNullExpressionValue(bigIntegerMultiply, "multiply(...)");
        return bigIntegerMultiply.mod(PRIME).longValue();
    }

    public final String getUserDeckUrl(int userId, int deckId) {
        return "https://" + getWebHost() + "/user/" + hashId(userId) + "/deck/" + hashId(deckId);
    }

    public final String getUserListUrl(int userId, int listId) {
        return "https://" + getWebHost() + "/user/" + hashId(userId) + "/collection/list/" + hashId(listId);
    }

    public final String getUserProfileUrl(int userId) {
        return "https://" + getWebHost() + "/user/" + hashId(userId);
    }

    public final String hashId(int num) {
        long jScramble = scramble(Math.abs(num));
        if (jScramble == 0) {
            return ExifInterface.GPS_MEASUREMENT_2D;
        }
        String str = "";
        while (jScramble > 0) {
            int i = BASE;
            str = ALPHABET.charAt((int) (jScramble % ((long) i))) + str;
            jScramble /= (long) i;
        }
        return str;
    }

    public final Integer unhashId(String encoded) {
        Intrinsics.checkNotNullParameter(encoded, "encoded");
        if (encoded.length() == 0) {
            return null;
        }
        int length = encoded.length();
        long j = 0;
        for (int i = 0; i < length; i++) {
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) ALPHABET, encoded.charAt(i), 0, false, 6, (Object) null);
            if (iIndexOf$default < 0) {
                return null;
            }
            j = (j * ((long) BASE)) + ((long) iIndexOf$default);
        }
        if (j == 0) {
            return 0;
        }
        BigInteger bigIntegerValueOf = BigInteger.valueOf(j);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        BigInteger MULT_INV2 = MULT_INV;
        Intrinsics.checkNotNullExpressionValue(MULT_INV2, "MULT_INV");
        BigInteger bigIntegerMultiply = bigIntegerValueOf.multiply(MULT_INV2);
        Intrinsics.checkNotNullExpressionValue(bigIntegerMultiply, "multiply(...)");
        return Integer.valueOf(bigIntegerMultiply.mod(PRIME).intValue());
    }
}
