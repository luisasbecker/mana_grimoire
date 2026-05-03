package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcj;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbck;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzbck<MessageType extends zzbck<MessageType, BuilderType>, BuilderType extends zzbcj<MessageType, BuilderType>> implements zzbfs {
    protected int zza = 0;

    protected static void zzu(Iterable iterable, List list) {
        byte[] bArr = zzbeu.zzb;
        iterable.getClass();
        if (!(iterable instanceof zzbfd)) {
            if (iterable instanceof zzbga) {
                list.addAll((Collection) iterable);
                return;
            }
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (Object obj : iterable) {
                if (obj == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    int size2 = list.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            throw new NullPointerException(str);
                        }
                        list.remove(size2);
                    }
                } else {
                    list.add(obj);
                }
            }
            return;
        }
        List listZza = ((zzbfd) iterable).zza();
        zzbfd zzbfdVar = (zzbfd) list;
        int size3 = list.size();
        for (Object obj2 : listZza) {
            if (obj2 == null) {
                String str2 = "Element at index " + (zzbfdVar.size() - size3) + " is null.";
                int size4 = zzbfdVar.size();
                while (true) {
                    size4--;
                    if (size4 < size3) {
                        throw new NullPointerException(str2);
                    }
                    zzbfdVar.remove(size4);
                }
            } else if (obj2 instanceof zzbdd) {
                zzbfdVar.zzb();
            } else if (obj2 instanceof byte[]) {
                byte[] bArr2 = (byte[]) obj2;
                zzbdd.zzo(bArr2, 0, bArr2.length);
                zzbfdVar.zzb();
            } else {
                zzbfdVar.add((String) obj2);
            }
        }
    }

    int zzs(zzbgm zzbgmVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbfs
    public final zzbdd zzt() {
        try {
            int iZzz = zzz();
            zzbdd zzbddVar = zzbdd.zzb;
            byte[] bArr = new byte[iZzz];
            zzbdm zzbdmVar = new zzbdm(bArr, 0, iZzz);
            zzX(zzbdmVar);
            return zzbcz.zza(zzbdmVar, bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + this.getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final void zzv(OutputStream outputStream) throws IOException {
        int iZzz = zzz();
        int i = zzbdq.zzf;
        if (iZzz > 4096) {
            iZzz = 4096;
        }
        zzbdo zzbdoVar = new zzbdo(outputStream, iZzz);
        zzX(zzbdoVar);
        zzbdoVar.zzM();
    }

    public final byte[] zzw() {
        try {
            int iZzz = zzz();
            byte[] bArr = new byte[iZzz];
            zzbdm zzbdmVar = new zzbdm(bArr, 0, iZzz);
            zzX(zzbdmVar);
            zzbdmVar.zzH();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
