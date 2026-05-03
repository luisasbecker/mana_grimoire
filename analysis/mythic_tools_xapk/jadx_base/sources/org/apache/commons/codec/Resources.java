package org.apache.commons.codec;

import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
public class Resources {
    @Deprecated
    public Resources() {
    }

    public static InputStream getInputStream(String str) {
        InputStream resourceAsStream = Resources.class.getResourceAsStream(str);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        throw new IllegalArgumentException("Unable to resolve required resource: " + str);
    }
}
