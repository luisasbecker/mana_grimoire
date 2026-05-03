package com.studiolaganne.lengendarylens;

import android.content.Context;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: PreferencesManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b<\b\u0086\u0081\u0002\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001BB)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bA¨\u0006C"}, d2 = {"Lcom/studiolaganne/lengendarylens/CurrencyInfo;", "", "code", "", "symbol", "emoji", "nameResId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getCode", "()Ljava/lang/String;", "getSymbol", "getEmoji", "getNameResId", "()I", "USD", "EUR", "JPY", "GBP", "CAD", "AUD", "CHF", "CNY", "SEK", "NOK", "DKK", "PLN", "CZK", "HUF", "RON", "BGN", "TRY", "RUB", "MXN", "BRL", "ARS", "CLP", "COP", "ZAR", "INR", "IDR", "MYR", "SGD", "THB", "PHP", "VND", "KRW", "TWD", "HKD", "ILS", "AED", "SAR", "QAR", "KWD", "BHD", "NZD", "MAD", "EGP", "NGN", "KES", "UAH", "GEL", "PEN", "UYU", "BDT", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CurrencyInfo {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CurrencyInfo[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String code;
    private final String emoji;
    private final int nameResId;
    private final String symbol;
    public static final CurrencyInfo USD = new CurrencyInfo("USD", 0, "USD", "$", "🇺🇸", R.string.currency_usd);
    public static final CurrencyInfo EUR = new CurrencyInfo("EUR", 1, "EUR", "€", "🇪🇺", R.string.currency_eur);
    public static final CurrencyInfo JPY = new CurrencyInfo("JPY", 2, "JPY", "¥", "🇯🇵", R.string.currency_jpy);
    public static final CurrencyInfo GBP = new CurrencyInfo("GBP", 3, "GBP", "£", "🇬🇧", R.string.currency_gbp);
    public static final CurrencyInfo CAD = new CurrencyInfo("CAD", 4, "CAD", "$", "🇨🇦", R.string.currency_cad);
    public static final CurrencyInfo AUD = new CurrencyInfo("AUD", 5, "AUD", "$", "🇦🇺", R.string.currency_aud);
    public static final CurrencyInfo CHF = new CurrencyInfo("CHF", 6, "CHF", "CHF", "🇨🇭", R.string.currency_chf);
    public static final CurrencyInfo CNY = new CurrencyInfo("CNY", 7, "CNY", "¥", "🇨🇳", R.string.currency_cny);
    public static final CurrencyInfo SEK = new CurrencyInfo("SEK", 8, "SEK", "kr", "🇸🇪", R.string.currency_sek);
    public static final CurrencyInfo NOK = new CurrencyInfo("NOK", 9, "NOK", "kr", "🇳🇴", R.string.currency_nok);
    public static final CurrencyInfo DKK = new CurrencyInfo("DKK", 10, "DKK", "kr", "🇩🇰", R.string.currency_dkk);
    public static final CurrencyInfo PLN = new CurrencyInfo("PLN", 11, "PLN", "zł", "🇵🇱", R.string.currency_pln);
    public static final CurrencyInfo CZK = new CurrencyInfo("CZK", 12, "CZK", "Kč", "🇨🇿", R.string.currency_czk);
    public static final CurrencyInfo HUF = new CurrencyInfo("HUF", 13, "HUF", "Ft", "🇭🇺", R.string.currency_huf);
    public static final CurrencyInfo RON = new CurrencyInfo("RON", 14, "RON", "lei", "🇷🇴", R.string.currency_ron);
    public static final CurrencyInfo BGN = new CurrencyInfo("BGN", 15, "BGN", "лв", "🇧🇬", R.string.currency_bgn);
    public static final CurrencyInfo TRY = new CurrencyInfo("TRY", 16, "TRY", "₺", "🇹🇷", R.string.currency_try);
    public static final CurrencyInfo RUB = new CurrencyInfo("RUB", 17, "RUB", "₽", "🇷🇺", R.string.currency_rub);
    public static final CurrencyInfo MXN = new CurrencyInfo("MXN", 18, "MXN", "$", "🇲🇽", R.string.currency_mxn);
    public static final CurrencyInfo BRL = new CurrencyInfo("BRL", 19, "BRL", "R$", "🇧🇷", R.string.currency_brl);
    public static final CurrencyInfo ARS = new CurrencyInfo("ARS", 20, "ARS", "$", "🇦🇷", R.string.currency_ars);
    public static final CurrencyInfo CLP = new CurrencyInfo("CLP", 21, "CLP", "$", "🇨🇱", R.string.currency_clp);
    public static final CurrencyInfo COP = new CurrencyInfo("COP", 22, "COP", "$", "🇨🇴", R.string.currency_cop);
    public static final CurrencyInfo ZAR = new CurrencyInfo("ZAR", 23, "ZAR", "R", "🇿🇦", R.string.currency_zar);
    public static final CurrencyInfo INR = new CurrencyInfo("INR", 24, "INR", "₹", "🇮🇳", R.string.currency_inr);
    public static final CurrencyInfo IDR = new CurrencyInfo("IDR", 25, "IDR", "Rp", "🇮🇩", R.string.currency_idr);
    public static final CurrencyInfo MYR = new CurrencyInfo("MYR", 26, "MYR", "RM", "🇲🇾", R.string.currency_myr);
    public static final CurrencyInfo SGD = new CurrencyInfo("SGD", 27, "SGD", "$", "🇸🇬", R.string.currency_sgd);
    public static final CurrencyInfo THB = new CurrencyInfo("THB", 28, "THB", "฿", "🇹🇭", R.string.currency_thb);
    public static final CurrencyInfo PHP = new CurrencyInfo("PHP", 29, "PHP", "₱", "🇵🇭", R.string.currency_php);
    public static final CurrencyInfo VND = new CurrencyInfo("VND", 30, "VND", "₫", "🇻🇳", R.string.currency_vnd);
    public static final CurrencyInfo KRW = new CurrencyInfo("KRW", 31, "KRW", "₩", "🇰🇷", R.string.currency_krw);
    public static final CurrencyInfo TWD = new CurrencyInfo("TWD", 32, "TWD", "NT$", "🇹🇼", R.string.currency_twd);
    public static final CurrencyInfo HKD = new CurrencyInfo("HKD", 33, "HKD", "HK$", "🇭🇰", R.string.currency_hkd);
    public static final CurrencyInfo ILS = new CurrencyInfo("ILS", 34, "ILS", "₪", "🇮🇱", R.string.currency_ils);
    public static final CurrencyInfo AED = new CurrencyInfo("AED", 35, "AED", "د.إ", "🇦🇪", R.string.currency_aed);
    public static final CurrencyInfo SAR = new CurrencyInfo("SAR", 36, "SAR", "﷼", "🇸🇦", R.string.currency_sar);
    public static final CurrencyInfo QAR = new CurrencyInfo("QAR", 37, "QAR", "﷼", "🇶🇦", R.string.currency_qar);
    public static final CurrencyInfo KWD = new CurrencyInfo("KWD", 38, "KWD", "KD", "🇰🇼", R.string.currency_kwd);
    public static final CurrencyInfo BHD = new CurrencyInfo("BHD", 39, "BHD", "BD", "🇧🇭", R.string.currency_bhd);
    public static final CurrencyInfo NZD = new CurrencyInfo("NZD", 40, "NZD", "$", "🇳🇿", R.string.currency_nzd);
    public static final CurrencyInfo MAD = new CurrencyInfo("MAD", 41, "MAD", "DH", "🇲🇦", R.string.currency_mad);
    public static final CurrencyInfo EGP = new CurrencyInfo("EGP", 42, "EGP", "£", "🇪🇬", R.string.currency_egp);
    public static final CurrencyInfo NGN = new CurrencyInfo("NGN", 43, "NGN", "₦", "🇳🇬", R.string.currency_ngn);
    public static final CurrencyInfo KES = new CurrencyInfo("KES", 44, "KES", "KSh", "🇰🇪", R.string.currency_kes);
    public static final CurrencyInfo UAH = new CurrencyInfo("UAH", 45, "UAH", "₴", "🇺🇦", R.string.currency_uah);
    public static final CurrencyInfo GEL = new CurrencyInfo("GEL", 46, "GEL", "₾", "🇬🇪", R.string.currency_gel);
    public static final CurrencyInfo PEN = new CurrencyInfo("PEN", 47, "PEN", "S/.", "🇵🇪", R.string.currency_pen);
    public static final CurrencyInfo UYU = new CurrencyInfo("UYU", 48, "UYU", "$U", "🇺🇾", R.string.currency_uyu);
    public static final CurrencyInfo BDT = new CurrencyInfo("BDT", 49, "BDT", "৳", "🇧🇩", R.string.currency_bdt);

    /* JADX INFO: compiled from: PreferencesManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000b"}, d2 = {"Lcom/studiolaganne/lengendarylens/CurrencyInfo$Companion;", "", "<init>", "()V", "fromCode", "Lcom/studiolaganne/lengendarylens/CurrencyInfo;", "code", "", "getDisplayName", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CurrencyInfo fromCode(String code) {
            Intrinsics.checkNotNullParameter(code, "code");
            for (CurrencyInfo currencyInfo : CurrencyInfo.values()) {
                if (StringsKt.equals(currencyInfo.getCode(), code, true)) {
                    return currencyInfo;
                }
            }
            return null;
        }

        public final String getDisplayName(Context context, String code) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(code, "code");
            CurrencyInfo currencyInfoFromCode = fromCode(code);
            if (currencyInfoFromCode == null) {
                return code;
            }
            String string = context.getString(currencyInfoFromCode.getNameResId());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string + " (" + currencyInfoFromCode.getCode() + ") " + currencyInfoFromCode.getSymbol();
        }
    }

    private static final /* synthetic */ CurrencyInfo[] $values() {
        return new CurrencyInfo[]{USD, EUR, JPY, GBP, CAD, AUD, CHF, CNY, SEK, NOK, DKK, PLN, CZK, HUF, RON, BGN, TRY, RUB, MXN, BRL, ARS, CLP, COP, ZAR, INR, IDR, MYR, SGD, THB, PHP, VND, KRW, TWD, HKD, ILS, AED, SAR, QAR, KWD, BHD, NZD, MAD, EGP, NGN, KES, UAH, GEL, PEN, UYU, BDT};
    }

    static {
        CurrencyInfo[] currencyInfoArr$values = $values();
        $VALUES = currencyInfoArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(currencyInfoArr$values);
        INSTANCE = new Companion(null);
    }

    private CurrencyInfo(String str, int i, String str2, String str3, String str4, int i2) {
        this.code = str2;
        this.symbol = str3;
        this.emoji = str4;
        this.nameResId = i2;
    }

    public static EnumEntries<CurrencyInfo> getEntries() {
        return $ENTRIES;
    }

    public static CurrencyInfo valueOf(String str) {
        return (CurrencyInfo) Enum.valueOf(CurrencyInfo.class, str);
    }

    public static CurrencyInfo[] values() {
        return (CurrencyInfo[]) $VALUES.clone();
    }

    public final String getCode() {
        return this.code;
    }

    public final String getEmoji() {
        return this.emoji;
    }

    public final int getNameResId() {
        return this.nameResId;
    }

    public final String getSymbol() {
        return this.symbol;
    }
}
