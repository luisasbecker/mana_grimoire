package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransparentBottomSheet.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/studiolaganne/lengendarylens/TransparentBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class TransparentBottomSheet extends BottomSheetDialogFragment {
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0$0(Dialog dialog, DialogInterface dialogInterface) {
        View viewFindViewById = dialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        FrameLayout frameLayout = viewFindViewById instanceof FrameLayout ? (FrameLayout) viewFindViewById : null;
        if (frameLayout != null) {
            frameLayout.setBackgroundResource(android.R.color.transparent);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "onCreateDialog(...)");
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.setDimAmount(0.8f);
        }
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.studiolaganne.lengendarylens.TransparentBottomSheet$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                TransparentBottomSheet.onCreateDialog$lambda$0$0(dialogOnCreateDialog, dialogInterface);
            }
        });
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        BottomSheetBehavior<FrameLayout> behavior;
        super.onResume();
        Dialog dialog = getDialog();
        BottomSheetDialog bottomSheetDialog = dialog instanceof BottomSheetDialog ? (BottomSheetDialog) dialog : null;
        if (bottomSheetDialog == null || (behavior = bottomSheetDialog.getBehavior()) == null) {
            return;
        }
        behavior.setState(3);
    }
}
