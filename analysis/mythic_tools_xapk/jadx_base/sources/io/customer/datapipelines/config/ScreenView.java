package io.customer.datapipelines.config;

import com.caverock.androidsvg.SVGParser;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.segment.analytics.kotlin.core.BaseEvent;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ScreenView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b2\u00020\u0001:\u0003\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lio/customer/datapipelines/config/ScreenView;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", InAppPurchaseConstants.METHOD_TO_STRING, BaseEvent.ALL_INTEGRATIONS_KEY, "InApp", "Companion", "Lio/customer/datapipelines/config/ScreenView$All;", "Lio/customer/datapipelines/config/ScreenView$InApp;", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ScreenView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String name;

    /* JADX INFO: compiled from: ScreenView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/customer/datapipelines/config/ScreenView$All;", "Lio/customer/datapipelines/config/ScreenView;", "<init>", "()V", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class All extends ScreenView {
        public static final All INSTANCE = new All();

        private All() {
            super(SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL, null);
        }
    }

    /* JADX INFO: compiled from: ScreenView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H\u0007¨\u0006\t"}, d2 = {"Lio/customer/datapipelines/config/ScreenView$Companion;", "", "<init>", "()V", "getScreenView", "Lio/customer/datapipelines/config/ScreenView;", "screenView", "", "fallback", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ScreenView getScreenView$default(Companion companion, String str, ScreenView screenView, int i, Object obj) {
            if ((i & 2) != 0) {
                screenView = All.INSTANCE;
            }
            return companion.getScreenView(str, screenView);
        }

        public final ScreenView getScreenView(String str) {
            return getScreenView$default(this, str, null, 2, null);
        }

        public final ScreenView getScreenView(String screenView, ScreenView fallback) {
            Object next;
            Intrinsics.checkNotNullParameter(fallback, "fallback");
            String str = screenView;
            if (str == null || StringsKt.isBlank(str)) {
                return fallback;
            }
            Iterator it = CollectionsKt.listOf((Object[]) new ScreenView[]{All.INSTANCE, InApp.INSTANCE}).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (StringsKt.equals(((ScreenView) next).getName(), screenView, true)) {
                    break;
                }
            }
            ScreenView screenView2 = (ScreenView) next;
            return screenView2 == null ? fallback : screenView2;
        }
    }

    /* JADX INFO: compiled from: ScreenView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/customer/datapipelines/config/ScreenView$InApp;", "Lio/customer/datapipelines/config/ScreenView;", "<init>", "()V", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InApp extends ScreenView {
        public static final InApp INSTANCE = new InApp();

        private InApp() {
            super("inapp", null);
        }
    }

    private ScreenView(String str) {
        this.name = str;
    }

    public /* synthetic */ ScreenView(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String getName() {
        return this.name;
    }

    public String toString() {
        return "ScreenView('" + this.name + "')";
    }
}
