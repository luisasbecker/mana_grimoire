package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.WebmConstants;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbpi implements zzbep {
    static final zzbep zza = new zzbpi();

    private zzbpi() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbep
    public final boolean zza(int i) {
        if (i == 200 || i == 300 || i == 302 || i == 312 || i == 15000 || i == 304 || i == 305) {
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
                return true;
            default:
                switch (i) {
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        return true;
                    default:
                        switch (i) {
                            case 43:
                            case 44:
                            case 45:
                                return true;
                            default:
                                switch (i) {
                                    case 220:
                                    case 221:
                                    case 222:
                                    case 223:
                                    case WebmConstants.MkvEbmlElement.VIDEO /* 224 */:
                                    case WebmConstants.MkvEbmlElement.AUDIO /* 225 */:
                                    case 226:
                                    case 227:
                                        return true;
                                    default:
                                        switch (i) {
                                            case WebmConstants.MkvEbmlElement.BLOCK_ADD_ID /* 238 */:
                                            case 239:
                                            case 240:
                                            case WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION /* 241 */:
                                            case 242:
                                            case 243:
                                                return true;
                                            default:
                                                switch (i) {
                                                    case 314:
                                                    case 315:
                                                    case TypedValues.AttributesType.TYPE_PATH_ROTATE /* 316 */:
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
