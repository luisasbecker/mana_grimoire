package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaer extends zzael {
    private final Object zza;

    public zzaer(Boolean bool) {
        this.zza = Objects.requireNonNull(bool);
    }

    public zzaer(Number number) {
        this.zza = Objects.requireNonNull(number);
    }

    public zzaer(String str) {
        this.zza = Objects.requireNonNull(str);
    }

    private static boolean zzk(zzaer zzaerVar) {
        Object obj = zzaerVar.zza;
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
        zzaer zzaerVar = (zzaer) obj;
        if (this.zza == null) {
            return zzaerVar.zza == null;
        }
        if (zzk(this) && zzk(zzaerVar)) {
            return ((this.zza instanceof BigInteger) || (zzaerVar.zza instanceof BigInteger)) ? zzg().equals(zzaerVar.zzg()) : zzd().longValue() == zzaerVar.zzd().longValue();
        }
        Object obj2 = this.zza;
        if (obj2 instanceof Number) {
            Object obj3 = zzaerVar.zza;
            if (obj3 instanceof Number) {
                if ((obj2 instanceof BigDecimal) && (obj3 instanceof BigDecimal)) {
                    return zzf().compareTo(zzaerVar.zzf()) == 0;
                }
                double dZza = zza();
                double dZza2 = zzaerVar.zza();
                if (dZza != dZza2) {
                    return Double.isNaN(dZza) && Double.isNaN(dZza2);
                }
                return true;
            }
        }
        return obj2.equals(zzaerVar.zza);
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
            return new zzaew((String) obj);
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
        return obj instanceof BigDecimal ? (BigDecimal) obj : zzaff.zza(zze());
    }

    public final BigInteger zzg() {
        Object obj = this.zza;
        return obj instanceof BigInteger ? (BigInteger) obj : zzk(this) ? BigInteger.valueOf(zzd().longValue()) : zzaff.zzb(zze());
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
