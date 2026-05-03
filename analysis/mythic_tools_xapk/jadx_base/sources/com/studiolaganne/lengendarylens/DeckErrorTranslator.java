package com.studiolaganne.lengendarylens;

import android.content.Context;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeckErrorTranslator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckErrorTranslator;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "translateError", "", "error", "Lcom/studiolaganne/lengendarylens/MTListError;", "getStringResourceId", "", "errorType", "getCardCountErrorResource", "getInvalidCopiesErrorResource", "translateErrorSmart", "formatValue", "value", "getCurrentLanguage", "isFrench", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckErrorTranslator {
    public static final int $stable = 8;
    private final Context context;

    public DeckErrorTranslator(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final String formatValue(Object value) {
        if (!(value instanceof Number)) {
            return String.valueOf(value);
        }
        Number number = (Number) value;
        return number.doubleValue() == ((double) number.longValue()) ? String.valueOf(number.longValue()) : number.toString();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final int getStringResourceId(String errorType) {
        switch (errorType.hashCode()) {
            case -1742249236:
                if (errorType.equals("wrong_color_identity")) {
                    return R.string.error_wrong_color_identity;
                }
                break;
            case -692583090:
                if (errorType.equals("too_many_cards")) {
                    return R.string.error_too_many_cards_exact;
                }
                break;
            case -629035493:
                if (errorType.equals("invalid_copies")) {
                    return R.string.error_invalid_copies_singleton;
                }
                break;
            case -307370287:
                if (errorType.equals("too_few_cards")) {
                    return R.string.error_too_few_cards_exact;
                }
                break;
            case -212467469:
                if (errorType.equals("invalid_rarity")) {
                    return R.string.error_invalid_rarity;
                }
                break;
            case 728420410:
                if (errorType.equals("no_commander")) {
                    return R.string.error_no_commander;
                }
                break;
            case 1088253274:
                if (errorType.equals("illegal_cards")) {
                    return R.string.error_illegal_cards;
                }
                break;
            case 1777969098:
                if (errorType.equals("multiple_commanders")) {
                    return R.string.error_multiple_commanders;
                }
                break;
        }
        return R.string.error_illegal_cards;
    }

    public final int getCardCountErrorResource(MTListError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        String type = error.getType();
        if (Intrinsics.areEqual(type, "too_few_cards")) {
            Map<String, Object> values = error.getValues();
            return (values == null || !values.containsKey("min")) ? R.string.error_too_few_cards_exact : R.string.error_too_few_cards_min;
        }
        if (!Intrinsics.areEqual(type, "too_many_cards")) {
            return getStringResourceId(error.getType());
        }
        Map<String, Object> values2 = error.getValues();
        return (values2 == null || !values2.containsKey("max")) ? R.string.error_too_many_cards_exact : R.string.error_too_many_cards_max;
    }

    public final String getCurrentLanguage() {
        return new PreferencesManager(this.context).getDeviceLanguage();
    }

    public final int getInvalidCopiesErrorResource(MTListError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (!Intrinsics.areEqual(error.getType(), "invalid_copies")) {
            return getStringResourceId(error.getType());
        }
        List<MTCardError> cards = error.getCards();
        if (cards != null) {
            List<MTCardError> list = cards;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    Integer max_allowed = ((MTCardError) it.next()).getMax_allowed();
                    if (max_allowed != null && max_allowed.intValue() == 1) {
                        return R.string.error_invalid_copies_singleton;
                    }
                }
            }
        }
        return R.string.error_invalid_copies_standard;
    }

    public final boolean isFrench() {
        return Intrinsics.areEqual(getCurrentLanguage(), "fr");
    }

    public final String translateError(MTListError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        String string = this.context.getString(getStringResourceId(error.getType()));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Map<String, Object> values = error.getValues();
        if (values == null) {
            return string;
        }
        String strReplace$default = string;
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            strReplace$default = StringsKt.replace$default(strReplace$default, "{" + entry.getKey() + "}", formatValue(entry.getValue()), false, 4, (Object) null);
        }
        return strReplace$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String translateErrorSmart(MTListError error) {
        int stringResourceId;
        Intrinsics.checkNotNullParameter(error, "error");
        String type = error.getType();
        int iHashCode = type.hashCode();
        if (iHashCode != -692583090) {
            if (iHashCode != -629035493) {
                if (iHashCode == -307370287 && type.equals("too_few_cards")) {
                    stringResourceId = getCardCountErrorResource(error);
                }
            } else if (type.equals("invalid_copies")) {
                stringResourceId = getInvalidCopiesErrorResource(error);
            }
            stringResourceId = getStringResourceId(error.getType());
        } else if (!type.equals("too_many_cards")) {
            stringResourceId = getStringResourceId(error.getType());
        }
        String string = this.context.getString(stringResourceId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Map<String, Object> values = error.getValues();
        if (values == null) {
            return string;
        }
        String strReplace$default = string;
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            strReplace$default = StringsKt.replace$default(strReplace$default, "{" + entry.getKey() + "}", formatValue(entry.getValue()), false, 4, (Object) null);
        }
        return strReplace$default;
    }
}
