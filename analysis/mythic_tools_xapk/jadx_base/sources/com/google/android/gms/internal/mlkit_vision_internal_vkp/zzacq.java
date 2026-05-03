package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzacq implements zzbep {
    static final zzbep zza = new zzacq();

    private zzacq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbep
    public final boolean zza(int i) {
        if (i == 400 || i == 401 || i == 403 || i == 404 || i == 408 || i == 409 || i == 429 || i == 511 || i == 503 || i == 504) {
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
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                return true;
            default:
                switch (i) {
                    case Videoio.CAP_PROP_XI_ACQ_FRAME_BURST_COUNT /* 499 */:
                    case 500:
                    case TypedValues.PositionType.TYPE_TRANSITION_EASING /* 501 */:
                        return true;
                    default:
                        return false;
                }
        }
    }
}
