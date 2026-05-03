package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcn extends zzch {
    private final Object zza;

    public zzcn(Boolean bool) {
        this.zza = Objects.requireNonNull(bool);
    }

    public zzcn(Number number) {
        this.zza = Objects.requireNonNull(number);
    }

    public zzcn(String str) {
        this.zza = Objects.requireNonNull(str);
    }

    private static boolean zzk(zzcn zzcnVar) {
        Object obj = zzcnVar.zza;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzcn zzcnVar = (zzcn) obj;
        if (this.zza == null) {
            return zzcnVar.zza == null;
        }
        if (zzk(this) && zzk(zzcnVar)) {
            return ((this.zza instanceof BigInteger) || (zzcnVar.zza instanceof BigInteger)) ? zzg().equals(zzcnVar.zzg()) : zzd().longValue() == zzcnVar.zzd().longValue();
        }
        Object obj2 = this.zza;
        if (obj2 instanceof Number) {
            Object obj3 = zzcnVar.zza;
            if (obj3 instanceof Number) {
                if ((obj2 instanceof BigDecimal) && (obj3 instanceof BigDecimal)) {
                    return zzf().compareTo(zzcnVar.zzf()) == 0;
                }
                double dZza = zza();
                double dZza2 = zzcnVar.zza();
                if (dZza != dZza2) {
                    return Double.isNaN(dZza) && Double.isNaN(dZza2);
                }
                return true;
            }
        }
        return obj2.equals(zzcnVar.zza);
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        if (this.zza == null) {
            return 31;
        }
        if (zzk(this)) {
            jDoubleToLongBits = zzd().longValue();
        } else {
            Object obj = this.zza;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(zzd().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public final double zza() {
        return this.zza instanceof Number ? zzd().doubleValue() : Double.parseDouble(zze());
    }

    public final long zzc() {
        return this.zza instanceof Number ? zzd().longValue() : Long.parseLong(zze());
    }

    public final Number zzd() {
        Object obj = this.zza;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new zzcs((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public final String zze() {
        Object obj = this.zza;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Number) {
            return zzd().toString();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        throw new AssertionError("Unexpected value type: ".concat(String.valueOf(String.valueOf(obj.getClass()))));
    }

    public final BigDecimal zzf() {
        Object obj = this.zza;
        return obj instanceof BigDecimal ? (BigDecimal) obj : zzdb.zza(zze());
    }

    public final BigInteger zzg() {
        Object obj = this.zza;
        return obj instanceof BigInteger ? (BigInteger) obj : zzk(this) ? BigInteger.valueOf(zzd().longValue()) : zzdb.zzb(zze());
    }

    public final boolean zzh() {
        Object obj = this.zza;
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(zze());
    }

    public final boolean zzi() {
        return this.zza instanceof Boolean;
    }

    public final boolean zzj() {
        return this.zza instanceof Number;
    }
}
