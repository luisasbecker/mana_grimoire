package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public enum zzbeb {
    DOUBLE(0, 1, zzbex.DOUBLE),
    FLOAT(1, 1, zzbex.FLOAT),
    INT64(2, 1, zzbex.LONG),
    UINT64(3, 1, zzbex.LONG),
    INT32(4, 1, zzbex.INT),
    FIXED64(5, 1, zzbex.LONG),
    FIXED32(6, 1, zzbex.INT),
    BOOL(7, 1, zzbex.BOOLEAN),
    STRING(8, 1, zzbex.STRING),
    MESSAGE(9, 1, zzbex.MESSAGE),
    BYTES(10, 1, zzbex.BYTE_STRING),
    UINT32(11, 1, zzbex.INT),
    ENUM(12, 1, zzbex.ENUM),
    SFIXED32(13, 1, zzbex.INT),
    SFIXED64(14, 1, zzbex.LONG),
    SINT32(15, 1, zzbex.INT),
    SINT64(16, 1, zzbex.LONG),
    GROUP(17, 1, zzbex.MESSAGE),
    DOUBLE_LIST(18, 2, zzbex.DOUBLE),
    FLOAT_LIST(19, 2, zzbex.FLOAT),
    INT64_LIST(20, 2, zzbex.LONG),
    UINT64_LIST(21, 2, zzbex.LONG),
    INT32_LIST(22, 2, zzbex.INT),
    FIXED64_LIST(23, 2, zzbex.LONG),
    FIXED32_LIST(24, 2, zzbex.INT),
    BOOL_LIST(25, 2, zzbex.BOOLEAN),
    STRING_LIST(26, 2, zzbex.STRING),
    MESSAGE_LIST(27, 2, zzbex.MESSAGE),
    BYTES_LIST(28, 2, zzbex.BYTE_STRING),
    UINT32_LIST(29, 2, zzbex.INT),
    ENUM_LIST(30, 2, zzbex.ENUM),
    SFIXED32_LIST(31, 2, zzbex.INT),
    SFIXED64_LIST(32, 2, zzbex.LONG),
    SINT32_LIST(33, 2, zzbex.INT),
    SINT64_LIST(34, 2, zzbex.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzbex.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzbex.FLOAT),
    INT64_LIST_PACKED(37, 3, zzbex.LONG),
    UINT64_LIST_PACKED(38, 3, zzbex.LONG),
    INT32_LIST_PACKED(39, 3, zzbex.INT),
    FIXED64_LIST_PACKED(40, 3, zzbex.LONG),
    FIXED32_LIST_PACKED(41, 3, zzbex.INT),
    BOOL_LIST_PACKED(42, 3, zzbex.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzbex.INT),
    ENUM_LIST_PACKED(44, 3, zzbex.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzbex.INT),
    SFIXED64_LIST_PACKED(46, 3, zzbex.LONG),
    SINT32_LIST_PACKED(47, 3, zzbex.INT),
    SINT64_LIST_PACKED(48, 3, zzbex.LONG),
    GROUP_LIST(49, 2, zzbex.MESSAGE),
    MAP(50, 4, zzbex.VOID);

    private static final zzbeb[] zzZ;
    private final int zzab;

    static {
        zzbeb[] zzbebVarArrValues = values();
        zzZ = new zzbeb[zzbebVarArrValues.length];
        for (zzbeb zzbebVar : zzbebVarArrValues) {
            zzZ[zzbebVar.zzab] = zzbebVar;
        }
    }

    zzbeb(int i, int i2, zzbex zzbexVar) {
        this.zzab = i;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            zzbexVar.zza();
        }
        if (i2 == 1) {
            zzbex zzbexVar2 = zzbex.VOID;
            zzbexVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzab;
    }
}
