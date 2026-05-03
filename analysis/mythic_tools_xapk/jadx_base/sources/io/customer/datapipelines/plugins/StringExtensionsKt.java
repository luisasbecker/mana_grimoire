package io.customer.datapipelines.plugins;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

/* JADX INFO: compiled from: StringExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, d2 = {"getScreenNameFromActivity", "", "datapipelines_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class StringExtensionsKt {
    public static final String getScreenNameFromActivity(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex("Activity|ListActivity|FragmentActivity|DialogActivity", RegexOption.IGNORE_CASE).replace(str, "");
    }
}
