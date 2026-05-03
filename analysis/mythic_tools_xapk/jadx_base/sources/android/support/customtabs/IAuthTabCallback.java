package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import kotlin.text.Typography;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes.dex */
public interface IAuthTabCallback extends IInterface {
    public static final String DESCRIPTOR = "android$support$customtabs$IAuthTabCallback".replace(Typography.dollar, FilenameUtils.EXTENSION_SEPARATOR);
    public static final int VERSION = 1;

    public static class Default implements IAuthTabCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.customtabs.IAuthTabCallback
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.support.customtabs.IAuthTabCallback
        public void onExtraCallback(String str, Bundle bundle) throws RemoteException {
        }

        @Override // android.support.customtabs.IAuthTabCallback
        public Bundle onExtraCallbackWithResult(String str, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // android.support.customtabs.IAuthTabCallback
        public void onNavigationEvent(int i, Bundle bundle) throws RemoteException {
        }

        @Override // android.support.customtabs.IAuthTabCallback
        public void onWarmupCompleted(Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAuthTabCallback {
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_onExtraCallback = 3;
        static final int TRANSACTION_onExtraCallbackWithResult = 4;
        static final int TRANSACTION_onNavigationEvent = 2;
        static final int TRANSACTION_onWarmupCompleted = 5;

        private static class Proxy implements IAuthTabCallback {
            private int mCachedVersion = -1;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override // android.support.customtabs.IAuthTabCallback
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion == -1) {
                    Parcel parcelObtain = Parcel.obtain();
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain.writeInterfaceToken(DESCRIPTOR);
                        this.mRemote.transact(16777215, parcelObtain, parcelObtain2, 0);
                        parcelObtain2.readException();
                        this.mCachedVersion = parcelObtain2.readInt();
                    } finally {
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                }
                return this.mCachedVersion;
            }

            @Override // android.support.customtabs.IAuthTabCallback
            public void onExtraCallback(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeTypedObject(bundle, 0);
                    if (this.mRemote.transact(3, parcelObtain, null, 1)) {
                    } else {
                        throw new RemoteException("Method onExtraCallback is unimplemented.");
                    }
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.IAuthTabCallback
            public Bundle onExtraCallbackWithResult(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeTypedObject(bundle, 0);
                    if (!this.mRemote.transact(4, parcelObtain, parcelObtain2, 0)) {
                        throw new RemoteException("Method onExtraCallbackWithResult is unimplemented.");
                    }
                    parcelObtain2.readException();
                    return (Bundle) parcelObtain2.readTypedObject(Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.IAuthTabCallback
            public void onNavigationEvent(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeTypedObject(bundle, 0);
                    if (this.mRemote.transact(2, parcelObtain, null, 1)) {
                    } else {
                        throw new RemoteException("Method onNavigationEvent is unimplemented.");
                    }
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.IAuthTabCallback
            public void onWarmupCompleted(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DESCRIPTOR);
                    parcelObtain.writeTypedObject(bundle, 0);
                    if (this.mRemote.transact(5, parcelObtain, null, 1)) {
                    } else {
                        throw new RemoteException("Method onWarmupCompleted is unimplemented.");
                    }
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAuthTabCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAuthTabCallback)) ? new Proxy(iBinder) : (IAuthTabCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = DESCRIPTOR;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i == 16777215) {
                parcel2.writeNoException();
                parcel2.writeInt(getInterfaceVersion());
                return true;
            }
            if (i == 2) {
                onNavigationEvent(parcel.readInt(), (Bundle) parcel.readTypedObject(Bundle.CREATOR));
            } else if (i == 3) {
                onExtraCallback(parcel.readString(), (Bundle) parcel.readTypedObject(Bundle.CREATOR));
            } else if (i == 4) {
                Bundle bundleOnExtraCallbackWithResult = onExtraCallbackWithResult(parcel.readString(), (Bundle) parcel.readTypedObject(Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedObject(bundleOnExtraCallbackWithResult, 1);
            } else {
                if (i != 5) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                onWarmupCompleted((Bundle) parcel.readTypedObject(Bundle.CREATOR));
            }
            return true;
        }
    }

    int getInterfaceVersion() throws RemoteException;

    void onExtraCallback(String str, Bundle bundle) throws RemoteException;

    Bundle onExtraCallbackWithResult(String str, Bundle bundle) throws RemoteException;

    void onNavigationEvent(int i, Bundle bundle) throws RemoteException;

    void onWarmupCompleted(Bundle bundle) throws RemoteException;
}
