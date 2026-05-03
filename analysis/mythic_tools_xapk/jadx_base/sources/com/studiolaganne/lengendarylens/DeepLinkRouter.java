package com.studiolaganne.lengendarylens;

import android.net.Uri;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.studiolaganne.lengendarylens.DeepLinkRoute;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: DeepLinkRouter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeepLinkRouter;", "", "<init>", "()V", "VALID_HOSTS", "", "", "parse", "Lcom/studiolaganne/lengendarylens/DeepLinkRoute;", "uri", "Landroid/net/Uri;", "isAuthCallback", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepLinkRouter {
    public static final DeepLinkRouter INSTANCE = new DeepLinkRouter();
    private static final Set<String> VALID_HOSTS = SetsKt.setOf((Object[]) new String[]{"artifact.mythic.tools", "mythic.tools"});
    public static final int $stable = 8;

    private DeepLinkRouter() {
    }

    public final boolean isAuthCallback(Uri uri) {
        String host;
        String path;
        if (uri == null || (host = uri.getHost()) == null || (path = uri.getPath()) == null || !VALID_HOSTS.contains(host)) {
            return false;
        }
        String str = path;
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "/mobile/auth/discord/callback", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "/mobile/auth/twitch/callback", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "/mobile/auth/email/verify", false, 2, (Object) null);
    }

    public final DeepLinkRoute parse(Uri uri) {
        String host;
        String path;
        if (uri != null && (host = uri.getHost()) != null && VALID_HOSTS.contains(host) && (path = uri.getPath()) != null) {
            String str = path;
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "/mobile/auth/discord/callback", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "/mobile/auth/twitch/callback", false, 2, (Object) null)) {
                String queryParameter = uri.getQueryParameter("code");
                if (queryParameter == null) {
                    return DeepLinkRoute.Unknown.INSTANCE;
                }
                String str2 = "discord";
                if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "discord", false, 2, (Object) null)) {
                    str2 = "twitch";
                    if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "twitch", false, 2, (Object) null)) {
                        return DeepLinkRoute.Unknown.INSTANCE;
                    }
                }
                return new DeepLinkRoute.OAuthCallback(uri, queryParameter, str2);
            }
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "/mobile/auth/email/verify", false, 2, (Object) null)) {
                return new DeepLinkRoute.EmailVerify(uri);
            }
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "/mobile/event", false, 2, (Object) null)) {
                String string = uri.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return new DeepLinkRoute.EventQR(string);
            }
            List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.trimStart(path, IOUtils.DIR_SEPARATOR_UNIX), new String[]{DomExceptionUtils.SEPARATOR}, false, 0, 6, (Object) null);
            if (!Intrinsics.areEqual(CollectionsKt.firstOrNull(listSplit$default), "user") || listSplit$default.size() < 2) {
                return DeepLinkRoute.Unknown.INSTANCE;
            }
            Integer numUnhashId = MythicLinkGenerator.INSTANCE.unhashId((String) listSplit$default.get(1));
            if (numUnhashId == null) {
                return DeepLinkRoute.Unknown.INSTANCE;
            }
            int iIntValue = numUnhashId.intValue();
            if (listSplit$default.size() >= 4 && Intrinsics.areEqual(listSplit$default.get(2), "deck")) {
                Integer numUnhashId2 = MythicLinkGenerator.INSTANCE.unhashId((String) listSplit$default.get(3));
                return numUnhashId2 != null ? new DeepLinkRoute.UserDeck(iIntValue, numUnhashId2.intValue()) : DeepLinkRoute.Unknown.INSTANCE;
            }
            if (listSplit$default.size() < 5 || !Intrinsics.areEqual(listSplit$default.get(2), "collection") || !Intrinsics.areEqual(listSplit$default.get(3), "list")) {
                return listSplit$default.size() == 2 ? new DeepLinkRoute.UserProfile(iIntValue) : DeepLinkRoute.Unknown.INSTANCE;
            }
            Integer numUnhashId3 = MythicLinkGenerator.INSTANCE.unhashId((String) listSplit$default.get(4));
            return numUnhashId3 != null ? new DeepLinkRoute.UserList(iIntValue, numUnhashId3.intValue()) : DeepLinkRoute.Unknown.INSTANCE;
        }
        return DeepLinkRoute.Unknown.INSTANCE;
    }
}
