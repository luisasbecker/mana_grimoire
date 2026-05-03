package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import androidx.core.view.PointerIconCompat;
import androidx.media3.common.PlaybackException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbnc implements zzbep {
    static final zzbep zza = new zzbnc();

    private zzbnc() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbep
    public final boolean zza(int i) {
        if (i == 3000 || i == 4000 || i == 5000 || i == 6000 || i == 6001 || i == 7000 || i == 7001) {
            return true;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                switch (i) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                        return true;
                    default:
                        switch (i) {
                            case 40:
                            case 41:
                            case 42:
                                return true;
                            default:
                                switch (i) {
                                    case 1000:
                                    case 1001:
                                    case 1002:
                                    case 1003:
                                    case 1004:
                                    case 1005:
                                    case PointerIconCompat.TYPE_CELL /* 1006 */:
                                    case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                                    case PointerIconCompat.TYPE_TEXT /* 1008 */:
                                    case PointerIconCompat.TYPE_VERTICAL_TEXT /* 1009 */:
                                    case PointerIconCompat.TYPE_ALIAS /* 1010 */:
                                    case PointerIconCompat.TYPE_COPY /* 1011 */:
                                    case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                                    case PointerIconCompat.TYPE_ALL_SCROLL /* 1013 */:
                                    case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                                    case PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW /* 1015 */:
                                    case PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW /* 1016 */:
                                        return true;
                                    default:
                                        switch (i) {
                                            case 2000:
                                            case PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED /* 2001 */:
                                            case PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT /* 2002 */:
                                            case PlaybackException.ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE /* 2003 */:
                                                return true;
                                            default:
                                                return false;
                                        }
                                }
                        }
                }
        }
    }
}
