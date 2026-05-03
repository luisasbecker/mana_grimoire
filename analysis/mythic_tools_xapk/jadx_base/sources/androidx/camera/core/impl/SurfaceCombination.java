package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SurfaceCombination {
    private final List<SurfaceConfig> mSurfaceConfigList;

    public SurfaceCombination() {
        this.mSurfaceConfigList = new ArrayList();
    }

    public SurfaceCombination(SurfaceConfig... surfaceConfigArr) {
        ArrayList arrayList = new ArrayList();
        this.mSurfaceConfigList = arrayList;
        Collections.addAll(arrayList, surfaceConfigArr);
    }

    private static void generateArrangements(List<int[]> list, int i, int[] iArr, int i2) {
        if (i2 >= iArr.length) {
            list.add((int[]) iArr.clone());
            return;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= i2) {
                    iArr[i2] = i3;
                    generateArrangements(list, i, iArr, i2 + 1);
                    break;
                } else if (i3 == iArr[i4]) {
                    break;
                } else {
                    i4++;
                }
            }
        }
    }

    private List<int[]> getElementsArrangements(int i) {
        ArrayList arrayList = new ArrayList();
        generateArrangements(arrayList, i, new int[i], 0);
        return arrayList;
    }

    public boolean addSurfaceConfig(SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.add(surfaceConfig);
    }

    public List<SurfaceConfig> getOrderedSupportedSurfaceConfigList(List<SurfaceConfig> list) {
        if (list.isEmpty()) {
            return new ArrayList();
        }
        if (list.size() != this.mSurfaceConfigList.size()) {
            return null;
        }
        List<int[]> elementsArrangements = getElementsArrangements(this.mSurfaceConfigList.size());
        SurfaceConfig[] surfaceConfigArr = new SurfaceConfig[list.size()];
        for (int[] iArr : elementsArrangements) {
            boolean zIsSupported = true;
            for (int i = 0; i < this.mSurfaceConfigList.size(); i++) {
                if (iArr[i] < list.size()) {
                    zIsSupported &= this.mSurfaceConfigList.get(i).isSupported(list.get(iArr[i]));
                    if (!zIsSupported) {
                        break;
                    }
                    surfaceConfigArr[iArr[i]] = this.mSurfaceConfigList.get(i);
                }
            }
            if (zIsSupported) {
                return Arrays.asList(surfaceConfigArr);
            }
        }
        return null;
    }

    public List<SurfaceConfig> getSurfaceConfigList() {
        return this.mSurfaceConfigList;
    }

    public boolean removeSurfaceConfig(SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.remove(surfaceConfig);
    }
}
