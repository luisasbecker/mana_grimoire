package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GenericFragmentActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a3\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"launchFragment", "", "Landroid/content/Context;", "fragmentClass", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "args", "Landroid/os/Bundle;", "launchBrowseListFragment", "context", "listId", "", "lang", "", "userId", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/Integer;)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GenericFragmentActivityKt {
    public static final void launchBrowseListFragment(Context context, int i, String str, Integer num) {
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = new Bundle();
        bundle.putInt("listId", i);
        if (str != null) {
            bundle.putString("lang", str);
        }
        if (num != null) {
            bundle.putInt("userId", num.intValue());
        }
        launchFragment(context, BrowseListFragment.class, bundle);
    }

    public static /* synthetic */ void launchBrowseListFragment$default(Context context, int i, String str, Integer num, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        if ((i2 & 8) != 0) {
            num = null;
        }
        launchBrowseListFragment(context, i, str, num);
    }

    public static final void launchFragment(Context context, Class<? extends Fragment> fragmentClass, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        Intent intent = new Intent(context, (Class<?>) GenericFragmentActivity.class);
        intent.putExtra("fragment_class", fragmentClass.getName());
        if (bundle != null) {
            intent.putExtra("fragment_args", bundle);
        }
        context.startActivity(intent);
    }

    public static /* synthetic */ void launchFragment$default(Context context, Class cls, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        launchFragment(context, cls, bundle);
    }
}
