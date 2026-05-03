package com.studiolaganne.lengendarylens;

import android.graphics.drawable.PictureDrawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.caverock.androidsvg.SVG;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SvgSoftwareLayerSetter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/studiolaganne/lengendarylens/SvgSoftwareLayerSetter;", "Lcom/bumptech/glide/request/target/ImageViewTarget;", "Landroid/graphics/drawable/PictureDrawable;", ViewHierarchyConstants.VIEW_KEY, "Landroid/widget/ImageView;", "<init>", "(Landroid/widget/ImageView;)V", "setResource", "", "resource", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SvgSoftwareLayerSetter extends ImageViewTarget<PictureDrawable> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: SvgSoftwareLayerSetter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/SvgSoftwareLayerSetter$Companion;", "", "<init>", "()V", "getSvgDrawable", "Landroid/graphics/drawable/PictureDrawable;", "svg", "Lcom/caverock/androidsvg/SVG;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PictureDrawable getSvgDrawable(SVG svg) {
            Intrinsics.checkNotNullParameter(svg, "svg");
            return new PictureDrawable(svg.renderToPicture());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SvgSoftwareLayerSetter(ImageView view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.ImageViewTarget
    public void setResource(PictureDrawable resource) {
        ((ImageView) this.view).setImageDrawable(resource);
    }
}
