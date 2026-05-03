package io.customer.tracking.migration.extensions;

import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000\u001a\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0010\n\u001a&\u0010\u000b\u001a\u0002H\f\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\r*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\b¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"toList", "", "Lorg/json/JSONObject;", "Lorg/json/JSONArray;", "jsonObjectOrNull", SubscriberAttributeKt.JSON_NAME_KEY, "", "stringOrNull", "longOrNull", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Long;", "requireField", ExifInterface.GPS_DIRECTION_TRUE, "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Object;", "tracking-migration_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class JsonExtensionsKt {
    public static final JSONObject jsonObjectOrNull(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (jSONObject.isNull(key)) {
            return null;
        }
        return jSONObject.optJSONObject(key);
    }

    public static final Long longOrNull(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (jSONObject.isNull(key)) {
            return null;
        }
        return Long.valueOf(jSONObject.optLong(key));
    }

    public static final /* synthetic */ <T> T requireField(JSONObject jSONObject, String key) {
        T t;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (jSONObject.isNull(key)) {
            t = null;
        } else {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                CharSequence charSequenceOptString = jSONObject.optString(key);
                Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
                t = (T) charSequenceOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                Object objValueOf = Long.valueOf(jSONObject.optLong(key));
                Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
                t = (T) objValueOf;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                Object objOptJSONObject = jSONObject.optJSONObject(key);
                Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
                t = (T) objOptJSONObject;
            } else {
                Object objOpt = jSONObject.opt(key);
                Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
                if (objOpt == null) {
                    Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                    throw new IllegalArgumentException("Type: " + Reflection.getOrCreateKotlinClass(Object.class) + " is not supported by migration JSON parser for key: " + key + " in " + jSONObject + ". Could not parse task.");
                }
                t = (T) objOpt;
            }
        }
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(("Required key '" + key + "' is missing or null in " + jSONObject + ". Could not parse task.").toString());
    }

    public static final String stringOrNull(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (jSONObject.isNull(key)) {
            return null;
        }
        return jSONObject.optString(key);
    }

    public static final List<JSONObject> toList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        IntRange intRangeUntil = RangesKt.until(0, jSONArray.length());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(((IntIterator) it).nextInt());
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(jSONObjectOptJSONObject);
            }
        }
        return arrayList;
    }
}
