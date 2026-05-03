package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbfu {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zzbfs zzbfsVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzbfsVar, sb, 0);
        return sb.toString();
    }

    static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzc(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzbgy.zza(new zzbdc(((String) obj).getBytes(zzbeu.zza))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzbdd) {
            sb.append(": \"");
            sb.append(zzbgy.zza((zzbdd) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzbel) {
            sb.append(" {");
            zzd((zzbel) obj, sb, i + 2);
            sb.append("\n");
            zzc(i, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i3 = i + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        zzb(sb, i3, SubscriberAttributeKt.JSON_NAME_KEY, entry.getKey());
        zzb(sb, i3, "value", entry.getValue());
        sb.append("\n");
        zzc(i, sb);
        sb.append("}");
    }

    private static void zzc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0203  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zzd(zzbfs zzbfsVar, StringBuilder sb, int i) {
        int i2;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzbfsVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method3 = declaredMethods[i3];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        map.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strSubstring = ((String) entry.getKey()).substring(i2);
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 4), zzbel.zzN(method2, zzbfsVar, new Object[0]));
            } else if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 3), zzbel.zzN(method, zzbfsVar, new Object[0]));
            } else if (hashSet.contains("set".concat(String.valueOf(strSubstring))) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(String.valueOf(strSubstring)));
                if (method4 != null) {
                    Object objZzN = zzbel.zzN(method4, zzbfsVar, new Object[0]);
                    if (method5 == null) {
                        if (objZzN instanceof Boolean) {
                            if (((Boolean) objZzN).booleanValue()) {
                                zzb(sb, i, strSubstring, objZzN);
                            }
                        } else if (objZzN instanceof Integer) {
                            if (((Integer) objZzN).intValue() != 0) {
                            }
                        } else if (objZzN instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objZzN).floatValue()) != 0) {
                            }
                        } else if (!(objZzN instanceof Double)) {
                            if (objZzN instanceof String) {
                                zEquals = objZzN.equals("");
                            } else if (objZzN instanceof zzbdd) {
                                zEquals = objZzN.equals(zzbdd.zzb);
                            } else if (objZzN instanceof zzbfs) {
                                if (objZzN != ((zzbfs) objZzN).zzx()) {
                                }
                            } else if (!(objZzN instanceof Enum) || ((Enum) objZzN).ordinal() != 0) {
                            }
                            if (!zEquals) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objZzN).doubleValue()) != 0) {
                        }
                    } else if (((Boolean) zzbel.zzN(method5, zzbfsVar, new Object[0])).booleanValue()) {
                    }
                }
            }
            i2 = 3;
        }
        if (zzbfsVar instanceof zzbeh) {
            Iterator itZzg = ((zzbeh) zzbfsVar).zzb.zzg();
            while (itZzg.hasNext()) {
                Map.Entry entry2 = (Map.Entry) itZzg.next();
                zzb(sb, i, "[32149011]", entry2.getValue());
            }
        }
        zzbhe zzbheVar = ((zzbel) zzbfsVar).zzc;
        if (zzbheVar != null) {
            zzbheVar.zzi(sb, i);
        }
    }
}
