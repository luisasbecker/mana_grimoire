package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.studiolaganne.lengendarylens.CollectionImportResult;
import java.io.InputStream;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ImportCsvDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 32\u00020\u0001:\u000223B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0012H\u0002J\b\u0010&\u001a\u00020\u001cH\u0002J\b\u0010'\u001a\u00020\u001cH\u0002J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0012H\u0002J\b\u0010)\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\b\u0010+\u001a\u00020\u001cH\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\tH\u0002J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\tH\u0002J\u0010\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/studiolaganne/lengendarylens/ImportCsvDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/ImportCsvDialogListener;", "customTitle", "", "selectedFileUri", "Landroid/net/Uri;", "selectedFileName", "txtParser", "Lcom/studiolaganne/lengendarylens/DeckListTxtParser;", "tabLayout", "Landroid/widget/TabHost;", "txtInput", "Landroid/widget/EditText;", "importButtonLayout", "Landroid/view/View;", "importButtonText", "Landroid/widget/TextView;", "fileSelectionArea", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getContent", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onStart", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initializeViews", ViewHierarchyConstants.VIEW_KEY, "setupTabs", "setupFileSelection", "setupButtons", "setupTextInput", "updateImportButtonState", "handleImport", "openFilePicker", "updateSelectedFileUI", "uri", "getFileNameFromUri", "showError", "errorMessage", "Builder", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImportCsvDialogFragment extends DialogFragment {
    public static final String TAG = "ImportCsvDialogFragment";
    private String customTitle;
    private ConstraintLayout fileSelectionArea;
    private final ActivityResultLauncher<Intent> getContent;
    private View importButtonLayout;
    private TextView importButtonText;
    private ImportCsvDialogListener listener;
    private String selectedFileName;
    private Uri selectedFileUri;
    private TabHost tabLayout;
    private EditText txtInput;
    private final DeckListTxtParser txtParser = new DeckListTxtParser();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: ImportCsvDialogFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/ImportCsvDialogFragment$Builder;", "", "<init>", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/ImportCsvDialogListener;", "customTitle", "", InAppPurchaseConstants.METHOD_SET_LISTENER, "setCustomTitle", Constants.GP_IAP_TITLE, "build", "Lcom/studiolaganne/lengendarylens/ImportCsvDialogFragment;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private String customTitle;
        private ImportCsvDialogListener listener;

        public final ImportCsvDialogFragment build() {
            ImportCsvDialogFragment importCsvDialogFragment = new ImportCsvDialogFragment();
            importCsvDialogFragment.listener = this.listener;
            importCsvDialogFragment.customTitle = this.customTitle;
            return importCsvDialogFragment;
        }

        public final Builder setCustomTitle(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            this.customTitle = title;
            return this;
        }

        public final Builder setListener(ImportCsvDialogListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    public ImportCsvDialogFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.ImportCsvDialogFragment$$ExternalSyntheticLambda3
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ImportCsvDialogFragment.getContent$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.getContent = activityResultLauncherRegisterForActivityResult;
    }

    static final void getContent$lambda$0(ImportCsvDialogFragment importCsvDialogFragment, ActivityResult result) {
        Intent data;
        Uri data2;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() != -1 || (data = result.getData()) == null || (data2 = data.getData()) == null) {
            return;
        }
        importCsvDialogFragment.selectedFileUri = data2;
        importCsvDialogFragment.updateSelectedFileUI(data2);
        importCsvDialogFragment.updateImportButtonState();
    }

    private final String getFileNameFromUri(Uri uri) {
        int columnIndex;
        Cursor cursorQuery = requireContext().getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery != null) {
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst() && (columnIndex = cursor2.getColumnIndex("_display_name")) != -1) {
                    String string = cursor2.getString(columnIndex);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    CloseableKt.closeFinally(cursor, null);
                    return string;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursor, th);
                    throw th2;
                }
            }
        }
        String lastPathSegment = uri.getLastPathSegment();
        return lastPathSegment == null ? "unknown.csv" : lastPathSegment;
    }

    private final void handleImport() {
        TabHost tabHost = this.tabLayout;
        EditText editText = null;
        if (tabHost == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabHost = null;
        }
        int currentTab = tabHost.getCurrentTab();
        if (currentTab != 0) {
            if (currentTab != 1) {
                return;
            }
            EditText editText2 = this.txtInput;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("txtInput");
            } else {
                editText = editText2;
            }
            String string = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
            if (string.length() > 0) {
                ParsedDeckList text = this.txtParser.parseText(string);
                CollectionImportResult.TxtImport txtImport = new CollectionImportResult.TxtImport(CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) text.getMainDeckCards(), (Iterable) text.getSideboardCards()), (Iterable) text.getMaybeboardCards()));
                ImportCsvDialogListener importCsvDialogListener = this.listener;
                if (importCsvDialogListener != null) {
                    importCsvDialogListener.onImportCollection(txtImport);
                }
                dismiss();
                return;
            }
            return;
        }
        Uri uri = this.selectedFileUri;
        if (uri != null) {
            try {
                InputStream inputStreamOpenInputStream = requireContext().getContentResolver().openInputStream(uri);
                if (inputStreamOpenInputStream == null) {
                    String string2 = getString(R.string.error_reading_file);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    showError(string2);
                    return;
                }
                String str = this.selectedFileName;
                if (str == null) {
                    str = "unknown.csv";
                }
                CollectionImportResult.CsvImport csvImport = new CollectionImportResult.CsvImport(inputStreamOpenInputStream, str);
                ImportCsvDialogListener importCsvDialogListener2 = this.listener;
                if (importCsvDialogListener2 != null) {
                    importCsvDialogListener2.onImportCollection(csvImport);
                }
                dismiss();
            } catch (Exception e) {
                showError(getString(R.string.error_reading_file) + ": " + e.getMessage());
            }
        }
    }

    private final void initializeViews(View view) {
        TextView textView;
        View viewFindViewById = view.findViewById(R.id.tabHost);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.tabLayout = (TabHost) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.txtInput);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.txtInput = (EditText) viewFindViewById2;
        this.fileSelectionArea = (ConstraintLayout) view.findViewById(R.id.fileSelectionArea);
        this.importButtonLayout = view.findViewById(R.id.importButtonLayout);
        this.importButtonText = (TextView) view.findViewById(R.id.importButtonText);
        String str = this.customTitle;
        if (str == null || (textView = (TextView) view.findViewById(R.id.dialogTitleTextView)) == null) {
            return;
        }
        textView.setText(str);
    }

    private final void openFilePicker() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"text/csv", "text/comma-separated-values", "application/csv", "application/vnd.ms-excel"});
        this.getContent.launch(intent);
    }

    private final void setupButtons(View view) {
        View viewFindViewById = view.findViewById(R.id.cancelButtonLayout);
        Intrinsics.checkNotNull(viewFindViewById);
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.ImportCsvDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImportCsvDialogFragment.setupButtons$lambda$0(this.f$0);
            }
        });
        updateImportButtonState();
        View view2 = this.importButtonLayout;
        if (view2 != null) {
            ViewExtensionsKt.setOnClickWithFade(view2, new Function0() { // from class: com.studiolaganne.lengendarylens.ImportCsvDialogFragment$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImportCsvDialogFragment.setupButtons$lambda$1(this.f$0);
                }
            });
        }
    }

    static final Unit setupButtons$lambda$0(ImportCsvDialogFragment importCsvDialogFragment) {
        importCsvDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit setupButtons$lambda$1(ImportCsvDialogFragment importCsvDialogFragment) {
        importCsvDialogFragment.handleImport();
        return Unit.INSTANCE;
    }

    private final void setupFileSelection() {
        ConstraintLayout constraintLayout = this.fileSelectionArea;
        if (constraintLayout != null) {
            ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ImportCsvDialogFragment$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImportCsvDialogFragment.setupFileSelection$lambda$0(this.f$0);
                }
            });
        }
    }

    static final Unit setupFileSelection$lambda$0(ImportCsvDialogFragment importCsvDialogFragment) {
        importCsvDialogFragment.openFilePicker();
        return Unit.INSTANCE;
    }

    private final void setupTabs() {
        TabHost tabHost = this.tabLayout;
        TabHost tabHost2 = null;
        if (tabHost == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabHost = null;
        }
        tabHost.setup();
        TabHost tabHost3 = this.tabLayout;
        if (tabHost3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabHost3 = null;
        }
        TabHost.TabSpec tabSpecNewTabSpec = tabHost3.newTabSpec("csv");
        Intrinsics.checkNotNullExpressionValue(tabSpecNewTabSpec, "newTabSpec(...)");
        tabSpecNewTabSpec.setContent(R.id.csvTabContent);
        tabSpecNewTabSpec.setIndicator(getString(R.string.csv_file_tab));
        TabHost tabHost4 = this.tabLayout;
        if (tabHost4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabHost4 = null;
        }
        tabHost4.addTab(tabSpecNewTabSpec);
        TabHost tabHost5 = this.tabLayout;
        if (tabHost5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabHost5 = null;
        }
        TabHost.TabSpec tabSpecNewTabSpec2 = tabHost5.newTabSpec("txt");
        Intrinsics.checkNotNullExpressionValue(tabSpecNewTabSpec2, "newTabSpec(...)");
        tabSpecNewTabSpec2.setContent(R.id.txtTabContent);
        tabSpecNewTabSpec2.setIndicator(getString(R.string.txt_input_tab));
        TabHost tabHost6 = this.tabLayout;
        if (tabHost6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabHost6 = null;
        }
        tabHost6.addTab(tabSpecNewTabSpec2);
        TabHost tabHost7 = this.tabLayout;
        if (tabHost7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabHost7 = null;
        }
        tabHost7.setCurrentTab(0);
        TabHost tabHost8 = this.tabLayout;
        if (tabHost8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        } else {
            tabHost2 = tabHost8;
        }
        tabHost2.setOnTabChangedListener(new TabHost.OnTabChangeListener() { // from class: com.studiolaganne.lengendarylens.ImportCsvDialogFragment$$ExternalSyntheticLambda0
            @Override // android.widget.TabHost.OnTabChangeListener
            public final void onTabChanged(String str) {
                this.f$0.updateImportButtonState();
            }
        });
    }

    private final void setupTextInput() {
        EditText editText = this.txtInput;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("txtInput");
            editText = null;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: com.studiolaganne.lengendarylens.ImportCsvDialogFragment.setupTextInput.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ImportCsvDialogFragment.this.updateImportButtonState();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    private final void showError(String errorMessage) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateImportButtonState() {
        EditText editText = this.txtInput;
        TabHost tabHost = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("txtInput");
            editText = null;
        }
        boolean z = false;
        boolean z2 = StringsKt.trim((CharSequence) editText.getText().toString()).toString().length() > 0;
        boolean z3 = this.selectedFileUri != null;
        TabHost tabHost2 = this.tabLayout;
        if (tabHost2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        } else {
            tabHost = tabHost2;
        }
        int currentTab = tabHost.getCurrentTab();
        if (currentTab == 0) {
            z = z3;
        } else if (currentTab == 1) {
            z = z2;
        }
        View view = this.importButtonLayout;
        if (view != null) {
            view.setEnabled(z);
            view.setAlpha(z ? 1.0f : 0.4f);
        }
    }

    private final void updateSelectedFileUI(Uri uri) {
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.selectedFileNameTextView) : null;
        View view2 = getView();
        TextView textView2 = view2 != null ? (TextView) view2.findViewById(R.id.selectFilePrompt) : null;
        View view3 = getView();
        TextView textView3 = view3 != null ? (TextView) view3.findViewById(R.id.selectFileIcon) : null;
        String fileNameFromUri = getFileNameFromUri(uri);
        this.selectedFileName = fileNameFromUri;
        if (textView != null) {
            textView.setText(fileNameFromUri);
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.selected_color_new, null));
        }
        if (textView2 != null) {
            textView2.setText(getString(R.string.tap_to_change_file));
        }
        if (textView3 != null) {
            textView3.setTextColor(getResources().getColor(R.color.selected_color_new, null));
        }
        ConstraintLayout constraintLayout = this.fileSelectionArea;
        if (constraintLayout != null) {
            constraintLayout.setBackgroundResource(R.drawable.dashed_border_background_selected);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.import_csv_dialog, container, false);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Intrinsics.checkNotNull(viewInflate);
        initializeViews(viewInflate);
        setupTabs();
        setupFileSelection();
        setupButtons(viewInflate);
        setupTextInput();
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
    }
}
