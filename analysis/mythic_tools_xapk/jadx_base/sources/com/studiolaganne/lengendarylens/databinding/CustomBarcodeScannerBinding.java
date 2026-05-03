package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomBarcodeScannerBinding implements ViewBinding {
    public final DecoratedBarcodeView barcodeScanner;
    private final DecoratedBarcodeView rootView;

    private CustomBarcodeScannerBinding(DecoratedBarcodeView decoratedBarcodeView, DecoratedBarcodeView decoratedBarcodeView2) {
        this.rootView = decoratedBarcodeView;
        this.barcodeScanner = decoratedBarcodeView2;
    }

    public static CustomBarcodeScannerBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        DecoratedBarcodeView decoratedBarcodeView = (DecoratedBarcodeView) view;
        return new CustomBarcodeScannerBinding(decoratedBarcodeView, decoratedBarcodeView);
    }

    public static CustomBarcodeScannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CustomBarcodeScannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.custom_barcode_scanner, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public DecoratedBarcodeView getRoot() {
        return this.rootView;
    }
}
