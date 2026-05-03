package com.google.gson;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface FieldNamingStrategy {
    default List<String> alternateNames(Field field) {
        return Collections.emptyList();
    }

    String translateName(Field field);
}
