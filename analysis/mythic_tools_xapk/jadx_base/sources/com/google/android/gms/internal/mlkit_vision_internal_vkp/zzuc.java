package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.mlkit.common.MlKitException;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzuc implements zzbep {
    static final zzbep zza = new zzuc();

    private zzuc() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbep
    public final boolean zza(int i) {
        if (i == 500 || i == 501 || i == 9999) {
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
                return true;
            default:
                switch (i) {
                    case 100:
                    case 101:
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                    case Videoio.CAP_PROP_OPENNI2_SYNC /* 110 */:
                    case 111:
                    case 112:
                    case 113:
                    case 114:
                    case 115:
                    case 116:
                        return true;
                    default:
                        switch (i) {
                            case 201:
                            case 202:
                            case 203:
                            case 204:
                            case MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR /* 205 */:
                            case 206:
                            case 207:
                                return true;
                            default:
                                switch (i) {
                                    case 301:
                                    case 302:
                                    case 303:
                                    case 304:
                                    case 305:
                                        return true;
                                    default:
                                        switch (i) {
                                            case 400:
                                            case 401:
                                            case 402:
                                            case 403:
                                            case 404:
                                            case Videoio.CAP_PROP_XI_TRG_SOFTWARE /* 405 */:
                                            case Videoio.CAP_PROP_XI_GPI_SELECTOR /* 406 */:
                                            case Videoio.CAP_PROP_XI_GPI_MODE /* 407 */:
                                                return true;
                                            default:
                                                switch (i) {
                                                    case 600:
                                                    case 601:
                                                    case TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE /* 602 */:
                                                    case TypedValues.MotionType.TYPE_EASING /* 603 */:
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
}
