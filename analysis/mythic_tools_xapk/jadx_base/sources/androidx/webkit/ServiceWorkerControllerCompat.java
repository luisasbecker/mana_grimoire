package androidx.webkit;

import androidx.webkit.internal.ServiceWorkerControllerImpl;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ServiceWorkerControllerCompat {

    private static class LAZY_HOLDER {
        static final ServiceWorkerControllerCompat INSTANCE = new ServiceWorkerControllerImpl();

        private LAZY_HOLDER() {
        }
    }

    public static ServiceWorkerControllerCompat getInstance() {
        return LAZY_HOLDER.INSTANCE;
    }

    public abstract ServiceWorkerWebSettingsCompat getServiceWorkerWebSettings();

    public abstract void setServiceWorkerClient(ServiceWorkerClientCompat serviceWorkerClientCompat);
}
