package org.apache.commons.csv;

import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public class CSVException extends IOException {
    private static final long serialVersionUID = 1;

    public CSVException(String str, Object... objArr) {
        super(String.format(str, objArr));
    }
}
