package com.journeyapps.barcodescanner;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.HybridBinarizer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Decoder implements ResultPointCallback {
    private List<ResultPoint> possibleResultPoints = new ArrayList();
    private Reader reader;

    public Decoder(Reader reader) {
        this.reader = reader;
    }

    protected Result decode(BinaryBitmap binaryBitmap) {
        this.possibleResultPoints.clear();
        try {
            Reader reader = this.reader;
            Result resultDecodeWithState = reader instanceof MultiFormatReader ? ((MultiFormatReader) reader).decodeWithState(binaryBitmap) : reader.decode(binaryBitmap);
            this.reader.reset();
            return resultDecodeWithState;
        } catch (Exception unused) {
            this.reader.reset();
            return null;
        } catch (Throwable th) {
            this.reader.reset();
            throw th;
        }
    }

    public Result decode(LuminanceSource luminanceSource) {
        return decode(toBitmap(luminanceSource));
    }

    @Override // com.google.zxing.ResultPointCallback
    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.possibleResultPoints.add(resultPoint);
    }

    public List<ResultPoint> getPossibleResultPoints() {
        return new ArrayList(this.possibleResultPoints);
    }

    protected Reader getReader() {
        return this.reader;
    }

    protected BinaryBitmap toBitmap(LuminanceSource luminanceSource) {
        return new BinaryBitmap(new HybridBinarizer(luminanceSource));
    }
}
