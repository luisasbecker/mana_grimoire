package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentController {
    private final FragmentHostCallback<?> mHost;

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.mHost = fragmentHostCallback;
    }

    public static FragmentController createController(FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController((FragmentHostCallback) Preconditions.checkNotNull(fragmentHostCallback, "callbacks == null"));
    }

    public void attachHost(Fragment fragment) {
        FragmentManager fragmentManager = this.mHost.getFragmentManager();
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        fragmentManager.attachController(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void dispatchActivityCreated() {
        this.mHost.getFragmentManager().dispatchActivityCreated();
    }

    @Deprecated
    public void dispatchConfigurationChanged(Configuration configuration) {
        this.mHost.getFragmentManager().dispatchConfigurationChanged(configuration, true);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.mHost.getFragmentManager().dispatchContextItemSelected(menuItem);
    }

    public void dispatchCreate() {
        this.mHost.getFragmentManager().dispatchCreate();
    }

    @Deprecated
    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.mHost.getFragmentManager().dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public void dispatchDestroy() {
        this.mHost.getFragmentManager().dispatchDestroy();
    }

    public void dispatchDestroyView() {
        this.mHost.getFragmentManager().dispatchDestroyView();
    }

    @Deprecated
    public void dispatchLowMemory() {
        this.mHost.getFragmentManager().dispatchLowMemory(true);
    }

    @Deprecated
    public void dispatchMultiWindowModeChanged(boolean z) {
        this.mHost.getFragmentManager().dispatchMultiWindowModeChanged(z, true);
    }

    @Deprecated
    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.mHost.getFragmentManager().dispatchOptionsItemSelected(menuItem);
    }

    @Deprecated
    public void dispatchOptionsMenuClosed(Menu menu) {
        this.mHost.getFragmentManager().dispatchOptionsMenuClosed(menu);
    }

    public void dispatchPause() {
        this.mHost.getFragmentManager().dispatchPause();
    }

    @Deprecated
    public void dispatchPictureInPictureModeChanged(boolean z) {
        this.mHost.getFragmentManager().dispatchPictureInPictureModeChanged(z, true);
    }

    @Deprecated
    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.mHost.getFragmentManager().dispatchPrepareOptionsMenu(menu);
    }

    @Deprecated
    public void dispatchReallyStop() {
    }

    public void dispatchResume() {
        this.mHost.getFragmentManager().dispatchResume();
    }

    public void dispatchStart() {
        this.mHost.getFragmentManager().dispatchStart();
    }

    public void dispatchStop() {
        this.mHost.getFragmentManager().dispatchStop();
    }

    @Deprecated
    public void doLoaderDestroy() {
    }

    @Deprecated
    public void doLoaderRetain() {
    }

    @Deprecated
    public void doLoaderStart() {
    }

    @Deprecated
    public void doLoaderStop(boolean z) {
    }

    @Deprecated
    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean execPendingActions() {
        return this.mHost.getFragmentManager().execPendingActions(true);
    }

    public Fragment findFragmentByWho(String str) {
        return this.mHost.getFragmentManager().findFragmentByWho(str);
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        return this.mHost.getFragmentManager().getActiveFragments();
    }

    public int getActiveFragmentsCount() {
        return this.mHost.getFragmentManager().getActiveFragmentCount();
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mHost.getFragmentManager();
    }

    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void noteStateNotSaved() {
        this.mHost.getFragmentManager().noteStateNotSaved();
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mHost.getFragmentManager().getLayoutInflaterFactory().onCreateView(view, str, context, attributeSet);
    }

    @Deprecated
    public void reportLoaderStart() {
    }

    @Deprecated
    public void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.mHost.getFragmentManager().restoreAllState(parcelable, fragmentManagerNonConfig);
    }

    @Deprecated
    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.mHost.getFragmentManager().restoreAllState(parcelable, new FragmentManagerNonConfig(list, null, null));
    }

    @Deprecated
    public void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
    }

    @Deprecated
    public void restoreSaveState(Parcelable parcelable) {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (!(fragmentHostCallback instanceof ViewModelStoreOwner)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        fragmentHostCallback.getFragmentManager().restoreSaveState(parcelable);
    }

    @Deprecated
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return null;
    }

    @Deprecated
    public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.mHost.getFragmentManager().retainNonConfig();
    }

    @Deprecated
    public List<Fragment> retainNonConfig() {
        FragmentManagerNonConfig fragmentManagerNonConfigRetainNonConfig = this.mHost.getFragmentManager().retainNonConfig();
        if (fragmentManagerNonConfigRetainNonConfig == null || fragmentManagerNonConfigRetainNonConfig.getFragments() == null) {
            return null;
        }
        return new ArrayList(fragmentManagerNonConfigRetainNonConfig.getFragments());
    }

    @Deprecated
    public Parcelable saveAllState() {
        return this.mHost.getFragmentManager().saveAllState();
    }
}
