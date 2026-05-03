package com.google.mlkit.vision.vkp;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzld;
import com.google.mlkit.common.MlKitException;
import java.util.Set;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class VkpStatus {

    /* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
    public static abstract class VkpError {
        public abstract int getErrorCode();

        public abstract int getErrorSpaceNumber();
    }

    static VkpStatus zza(MlKitException mlKitException) {
        return new AutoValue_VkpStatus(false, mlKitException, zzld.zzj());
    }

    public static VkpStatus zzb() {
        return new AutoValue_VkpStatus(true, null, zzld.zzj());
    }

    public abstract Set<VkpError> getErrors();

    public abstract MlKitException getMlKitException();

    public abstract boolean isSuccess();

    public void throwsMlKitExceptionIfPresent() throws MlKitException {
        MlKitException mlKitException = getMlKitException();
        if (mlKitException != null) {
            throw mlKitException;
        }
    }
}
