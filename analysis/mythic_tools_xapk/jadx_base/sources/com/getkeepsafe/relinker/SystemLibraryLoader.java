package com.getkeepsafe.relinker;

import android.os.Build;
import com.getkeepsafe.relinker.ReLinker;

/* JADX INFO: loaded from: classes3.dex */
final class SystemLibraryLoader implements ReLinker.LibraryLoader {
    SystemLibraryLoader() {
    }

    @Override // com.getkeepsafe.relinker.ReLinker.LibraryLoader
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }

    @Override // com.getkeepsafe.relinker.ReLinker.LibraryLoader
    public void loadPath(String str) {
        System.load(str);
    }

    @Override // com.getkeepsafe.relinker.ReLinker.LibraryLoader
    public String mapLibraryName(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // com.getkeepsafe.relinker.ReLinker.LibraryLoader
    public String[] supportedAbis() {
        return Build.SUPPORTED_ABIS.length > 0 ? Build.SUPPORTED_ABIS : !TextUtils.isEmpty(Build.CPU_ABI2) ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : new String[]{Build.CPU_ABI};
    }

    @Override // com.getkeepsafe.relinker.ReLinker.LibraryLoader
    public String unmapLibraryName(String str) {
        return str.substring(3, str.length() - 3);
    }
}
