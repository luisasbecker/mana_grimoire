package com.segment.analytics.kotlin.core.utilities;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.segment.analytics.kotlin.core.utilities.KVS;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PropertiesFile.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001c\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fJ\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\u0017\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/segment/analytics/kotlin/core/utilities/PropertiesFile;", "Lcom/segment/analytics/kotlin/core/utilities/KVS;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", DiagnosticsEntry.PROPERTIES_KEY, "Ljava/util/Properties;", "contains", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "get", "", "defaultVal", "getString", "load", "", "put", "value", "putString", "remove", "save", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PropertiesFile implements KVS {
    private final File file;
    private final Properties properties;

    public PropertiesFile(File file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
        this.properties = new Properties();
        load();
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public boolean contains(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.properties.containsKey(key);
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public int get(String key, int defaultVal) {
        Intrinsics.checkNotNullParameter(key, "key");
        String property = this.properties.getProperty(key, "");
        Intrinsics.checkNotNullExpressionValue(property, "properties.getProperty(key, \"\")");
        Integer intOrNull = StringsKt.toIntOrNull(property);
        return intOrNull != null ? intOrNull.intValue() : defaultVal;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public String get(String key, String defaultVal) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.properties.getProperty(key, defaultVal);
    }

    public final File getFile() {
        return this.file;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    @Deprecated(message = "Deprecated in favor of `get`", replaceWith = @ReplaceWith(expression = "get(key, defaultVal)", imports = {}))
    public int getInt(String str, int i) {
        return KVS.DefaultImpls.getInt(this, str, i);
    }

    public final String getString(String key, String defaultVal) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.properties.getProperty(key, defaultVal);
    }

    public final void load() throws IOException {
        if (!this.file.exists()) {
            this.file.getParentFile().mkdirs();
            this.file.createNewFile();
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(this.file);
        try {
            this.properties.load(fileInputStream);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileInputStream, null);
        } finally {
        }
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public boolean put(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.properties.setProperty(key, String.valueOf(value));
        save();
        return true;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public boolean put(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.properties.setProperty(key, value);
        save();
        return true;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    @Deprecated(message = "Deprecated in favor of `put`", replaceWith = @ReplaceWith(expression = "put(key, value)", imports = {}))
    public boolean putInt(String str, int i) {
        return KVS.DefaultImpls.putInt(this, str, i);
    }

    public final boolean putString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.properties.setProperty(key, value);
        save();
        return true;
    }

    @Override // com.segment.analytics.kotlin.core.utilities.KVS
    public boolean remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.properties.remove(key);
        save();
        return true;
    }

    public final void save() {
        FileOutputStream fileOutputStream = new FileOutputStream(this.file);
        try {
            this.properties.store(fileOutputStream, (String) null);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }
}
