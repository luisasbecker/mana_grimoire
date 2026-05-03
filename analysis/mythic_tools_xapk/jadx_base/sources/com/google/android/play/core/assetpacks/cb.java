package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import androidx.work.Data;
import com.caverock.androidsvg.BuildConfig;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class cb {
    static Bundle a(Data data) {
        bz bzVar = new bz("notification_bundle:", data, null);
        d(bzVar);
        return bzVar.c;
    }

    static Bundle b(Data data) {
        bz bzVar = new bz("session_bundle:", data, null);
        e(bzVar);
        return bzVar.c;
    }

    static Data c(Bundle bundle, Bundle bundle2) {
        Data.Builder builder = new Data.Builder();
        builder.putString("BUNDLE_DATA_CONVERTER_VERSION", BuildConfig.VERSION_NAME);
        e(new bw("session_bundle:", bundle, builder, null));
        d(new bw("notification_bundle:", bundle2, builder, null));
        return builder.build();
    }

    private static void d(by byVar) {
        byVar.g("notification_channel_name");
        byVar.g("notification_title");
        byVar.g("notification_subtext");
        byVar.c("notification_color");
        byVar.f("notification_timeout", 600000L);
        byVar.b("notification_intent_reconstruct_from_data");
        byVar.g("notification_intent_component_class_name");
        byVar.g("notification_intent_component_package_name");
        byVar.g("notification_intent_package");
        byVar.g("notification_intent_action");
        byVar.g("notification_intent_data");
        byVar.c("notification_intent_flags");
        byVar.g("notification_intent_extra_error_dialog_document_id");
    }

    private static void e(by byVar) {
        byVar.c("session_id");
        byVar.c("app_version_code");
        for (String str : byVar.a("pack_names")) {
            byVar.e(com.google.android.play.core.assetpacks.model.b.a("pack_version", str));
            byVar.g(com.google.android.play.core.assetpacks.model.b.a("pack_version_tag", str));
            byVar.c(com.google.android.play.core.assetpacks.model.b.a("status", str));
            byVar.e(com.google.android.play.core.assetpacks.model.b.a("total_bytes_to_download", str));
            for (String str2 : byVar.a(com.google.android.play.core.assetpacks.model.b.a("slice_ids", str))) {
                byVar.d(com.google.android.play.core.assetpacks.model.b.b("chunk_intents", str, str2));
                byVar.g(com.google.android.play.core.assetpacks.model.b.b("uncompressed_hash_sha256", str, str2));
                byVar.e(com.google.android.play.core.assetpacks.model.b.b("uncompressed_size", str, str2));
                byVar.c(com.google.android.play.core.assetpacks.model.b.b("patch_format", str, str2));
                byVar.c(com.google.android.play.core.assetpacks.model.b.b("compression_format", str, str2));
            }
        }
    }
}
