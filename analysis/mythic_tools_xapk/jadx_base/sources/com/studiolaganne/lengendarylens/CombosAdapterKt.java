package com.studiolaganne.lengendarylens;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CombosAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0004\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¨\u0006\b"}, d2 = {"zoneToIconChar", "", "zone", "", "(Ljava/lang/String;)Ljava/lang/Character;", "produceNameToTagDrawable", "", "name", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CombosAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int produceNameToTagDrawable(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str2 = lowerCase;
        return StringsKt.contains$default((CharSequence) str2, (CharSequence) "destroy", false, 2, (Object) null) ? R.drawable.tag_red : (StringsKt.contains$default((CharSequence) str2, (CharSequence) "infinite", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str2, (CharSequence) "mana", false, 2, (Object) null)) ? R.drawable.tag_green : StringsKt.contains$default((CharSequence) str2, (CharSequence) "infinite", false, 2, (Object) null) ? R.drawable.tag_blue : StringsKt.contains$default((CharSequence) str2, (CharSequence) "lock", false, 2, (Object) null) ? R.drawable.tag_purple : (StringsKt.contains$default((CharSequence) str2, (CharSequence) "mass", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str2, (CharSequence) "land", false, 2, (Object) null)) ? R.drawable.tag_orange : R.drawable.tag_brown;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Character zoneToIconChar(String str) {
        int iHashCode = str.hashCode();
        return iHashCode != 66 ? iHashCode != 71 ? (iHashCode == 72 && str.equals("H")) ? (char) 62038 : null : !str.equals(GameUtils.CONDITION_GOOD) ? null : (char) 63060 : !str.equals("B") ? null : (char) 62445;
    }
}
