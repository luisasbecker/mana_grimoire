import 'dart:math' as math;
import 'dart:typed_data';

enum LiveScanPixelFormat { nv21, bgra8888 }

enum LiveScanRoiKind { nameBand, collectorBand, card }

class LiveScanRoiRequest {
  const LiveScanRoiRequest({
    required this.kind,
    required this.left,
    required this.top,
    required this.width,
    required this.height,
  });

  final LiveScanRoiKind kind;
  final int left;
  final int top;
  final int width;
  final int height;
}

class LiveScanCrop {
  const LiveScanCrop({
    required this.kind,
    required this.bytes,
    required this.width,
    required this.height,
    required this.bytesPerRow,
  });

  final LiveScanRoiKind kind;
  final Uint8List bytes;
  final int width;
  final int height;
  final int bytesPerRow;
}

class LiveScanFrameCropper {
  const LiveScanFrameCropper();

  static const double _cardAspectRatio = 0.716;

  List<LiveScanRoiRequest> roiRequests({
    required int imageWidth,
    required int imageHeight,
    required int rotationDegrees,
  }) {
    final normalizedRotation = _normalizeRotation(rotationDegrees);
    final uprightWidth = normalizedRotation == 90 || normalizedRotation == 270
        ? imageHeight
        : imageWidth;
    final uprightHeight = normalizedRotation == 90 || normalizedRotation == 270
        ? imageWidth
        : imageHeight;

    var cardWidth = uprightWidth * 0.72;
    var cardHeight = cardWidth / _cardAspectRatio;
    final maxHeight = uprightHeight * 0.72;
    if (cardHeight > maxHeight) {
      cardHeight = maxHeight;
      cardWidth = cardHeight * _cardAspectRatio;
    }

    final cardLeft = (uprightWidth - cardWidth) / 2;
    final cardTop = ((uprightHeight * 0.43) - (cardHeight / 2)).clamp(
      uprightHeight * 0.05,
      uprightHeight - cardHeight - (uprightHeight * 0.05),
    );

    final uprightCard = _DoubleRect(
      left: cardLeft,
      top: cardTop.toDouble(),
      width: cardWidth,
      height: cardHeight,
    );
    final nameBand =
        uprightCard.inflateHorizontal(-0.06).relative(top: 0.07, height: 0.17);
    final collectorBand =
        uprightCard.inflateHorizontal(-0.06).relative(top: 0.80, height: 0.15);

    return [
      _mapUprightRect(
        kind: LiveScanRoiKind.nameBand,
        rect: nameBand,
        imageWidth: imageWidth,
        imageHeight: imageHeight,
        rotationDegrees: normalizedRotation,
        alignEven: true,
      ),
      _mapUprightRect(
        kind: LiveScanRoiKind.collectorBand,
        rect: collectorBand,
        imageWidth: imageWidth,
        imageHeight: imageHeight,
        rotationDegrees: normalizedRotation,
        alignEven: true,
      ),
      _mapUprightRect(
        kind: LiveScanRoiKind.card,
        rect: uprightCard,
        imageWidth: imageWidth,
        imageHeight: imageHeight,
        rotationDegrees: normalizedRotation,
        alignEven: true,
      ),
    ];
  }

  LiveScanCrop? crop({
    required Uint8List bytes,
    required int imageWidth,
    required int imageHeight,
    required int sourceBytesPerRow,
    required LiveScanPixelFormat format,
    required LiveScanRoiRequest roi,
  }) {
    return switch (format) {
      LiveScanPixelFormat.nv21 => _cropNv21(
          bytes: bytes,
          imageWidth: imageWidth,
          imageHeight: imageHeight,
          sourceBytesPerRow: sourceBytesPerRow,
          roi: roi,
        ),
      LiveScanPixelFormat.bgra8888 => _cropBgra8888(
          bytes: bytes,
          sourceBytesPerRow: sourceBytesPerRow,
          roi: roi,
        ),
    };
  }

  LiveScanCrop? _cropNv21({
    required Uint8List bytes,
    required int imageWidth,
    required int imageHeight,
    required int sourceBytesPerRow,
    required LiveScanRoiRequest roi,
  }) {
    final stride = sourceBytesPerRow <= 0 ? imageWidth : sourceBytesPerRow;
    if (bytes.length < stride * imageHeight) return null;
    final left = roi.left.isEven ? roi.left : roi.left - 1;
    final top = roi.top.isEven ? roi.top : roi.top - 1;
    final width = roi.width.isEven ? roi.width : roi.width - 1;
    final height = roi.height.isEven ? roi.height : roi.height - 1;
    if (left < 0 ||
        top < 0 ||
        width < 2 ||
        height < 2 ||
        left + width > imageWidth ||
        top + height > imageHeight) {
      return null;
    }

    final yPlaneSize = stride * imageHeight;
    final requiredSize = yPlaneSize + (stride * (imageHeight ~/ 2));
    if (bytes.length < requiredSize) return null;

    final output = Uint8List(width * height + width * (height ~/ 2));
    var outputOffset = 0;
    for (var row = 0; row < height; row++) {
      final sourceOffset = ((top + row) * stride) + left;
      output.setRange(outputOffset, outputOffset + width, bytes, sourceOffset);
      outputOffset += width;
    }

    final uvStart = yPlaneSize;
    for (var row = 0; row < height ~/ 2; row++) {
      final sourceOffset = uvStart + (((top ~/ 2) + row) * stride) + left;
      output.setRange(outputOffset, outputOffset + width, bytes, sourceOffset);
      outputOffset += width;
    }

    return LiveScanCrop(
      kind: roi.kind,
      bytes: output,
      width: width,
      height: height,
      bytesPerRow: width,
    );
  }

  LiveScanCrop? _cropBgra8888({
    required Uint8List bytes,
    required int sourceBytesPerRow,
    required LiveScanRoiRequest roi,
  }) {
    if (sourceBytesPerRow <= 0) return null;
    const bytesPerPixel = 4;
    final sourceHeight = bytes.length ~/ sourceBytesPerRow;
    if (roi.left < 0 ||
        roi.top < 0 ||
        roi.width < 1 ||
        roi.height < 1 ||
        roi.top + roi.height > sourceHeight ||
        ((roi.left + roi.width) * bytesPerPixel) > sourceBytesPerRow) {
      return null;
    }

    final outputBytesPerRow = roi.width * bytesPerPixel;
    final output = Uint8List(outputBytesPerRow * roi.height);
    var outputOffset = 0;
    for (var row = 0; row < roi.height; row++) {
      final sourceOffset =
          ((roi.top + row) * sourceBytesPerRow) + (roi.left * bytesPerPixel);
      output.setRange(
        outputOffset,
        outputOffset + outputBytesPerRow,
        bytes,
        sourceOffset,
      );
      outputOffset += outputBytesPerRow;
    }

    return LiveScanCrop(
      kind: roi.kind,
      bytes: output,
      width: roi.width,
      height: roi.height,
      bytesPerRow: outputBytesPerRow,
    );
  }

  LiveScanRoiRequest _mapUprightRect({
    required LiveScanRoiKind kind,
    required _DoubleRect rect,
    required int imageWidth,
    required int imageHeight,
    required int rotationDegrees,
    required bool alignEven,
  }) {
    final mapped = switch (rotationDegrees) {
      0 => _DoubleRect(
          left: rect.left,
          top: rect.top,
          width: rect.width,
          height: rect.height,
        ),
      90 => _DoubleRect(
          left: rect.top,
          top: imageHeight - rect.right,
          width: rect.height,
          height: rect.width,
        ),
      180 => _DoubleRect(
          left: imageWidth - rect.right,
          top: imageHeight - rect.bottom,
          width: rect.width,
          height: rect.height,
        ),
      270 => _DoubleRect(
          left: imageWidth - rect.bottom,
          top: rect.left,
          width: rect.height,
          height: rect.width,
        ),
      _ => rect,
    };

    var left = mapped.left.floor().clamp(0, imageWidth - 1);
    var top = mapped.top.floor().clamp(0, imageHeight - 1);
    var right = mapped.right.ceil().clamp(left + 1, imageWidth);
    var bottom = mapped.bottom.ceil().clamp(top + 1, imageHeight);

    if (alignEven) {
      left = _floorEven(left);
      top = _floorEven(top);
      right = _ceilEven(right).clamp(left + 2, imageWidth);
      bottom = _ceilEven(bottom).clamp(top + 2, imageHeight);
      if ((right - left).isOdd) right = math.max(left + 2, right - 1);
      if ((bottom - top).isOdd) bottom = math.max(top + 2, bottom - 1);
    }

    return LiveScanRoiRequest(
      kind: kind,
      left: left,
      top: top,
      width: right - left,
      height: bottom - top,
    );
  }

  int _normalizeRotation(int rotationDegrees) {
    final normalized = rotationDegrees % 360;
    return normalized < 0 ? normalized + 360 : normalized;
  }

  int _floorEven(int value) => value.isEven ? value : value - 1;
  int _ceilEven(int value) => value.isEven ? value : value + 1;
}

class _DoubleRect {
  const _DoubleRect({
    required this.left,
    required this.top,
    required this.width,
    required this.height,
  });

  final double left;
  final double top;
  final double width;
  final double height;

  double get right => left + width;
  double get bottom => top + height;

  _DoubleRect inflateHorizontal(double fraction) {
    final inset = width * fraction;
    return _DoubleRect(
      left: left - inset,
      top: top,
      width: width + (inset * 2),
      height: height,
    );
  }

  _DoubleRect relative({required double top, required double height}) {
    return _DoubleRect(
      left: left,
      top: this.top + (this.height * top),
      width: width,
      height: this.height * height,
    );
  }
}
