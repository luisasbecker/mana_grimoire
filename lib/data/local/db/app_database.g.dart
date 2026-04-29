// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'app_database.dart';

// ignore_for_file: type=lint
class $ScryfallPrintingsTable extends ScryfallPrintings
    with TableInfo<$ScryfallPrintingsTable, ScryfallPrinting> {
  @override
  final GeneratedDatabase attachedDatabase;
  final String? _alias;
  $ScryfallPrintingsTable(this.attachedDatabase, [this._alias]);
  static const VerificationMeta _printingIdMeta =
      const VerificationMeta('printingId');
  @override
  late final GeneratedColumn<String> printingId = GeneratedColumn<String>(
      'printing_id', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _oracleIdMeta =
      const VerificationMeta('oracleId');
  @override
  late final GeneratedColumn<String> oracleId = GeneratedColumn<String>(
      'oracle_id', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _nameMeta = const VerificationMeta('name');
  @override
  late final GeneratedColumn<String> name = GeneratedColumn<String>(
      'name', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _typeLineMeta =
      const VerificationMeta('typeLine');
  @override
  late final GeneratedColumn<String> typeLine = GeneratedColumn<String>(
      'type_line', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _setCodeMeta =
      const VerificationMeta('setCode');
  @override
  late final GeneratedColumn<String> setCode = GeneratedColumn<String>(
      'set_code', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _setNameMeta =
      const VerificationMeta('setName');
  @override
  late final GeneratedColumn<String> setName = GeneratedColumn<String>(
      'set_name', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _collectorNumberMeta =
      const VerificationMeta('collectorNumber');
  @override
  late final GeneratedColumn<String> collectorNumber = GeneratedColumn<String>(
      'collector_number', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _releasedAtMeta =
      const VerificationMeta('releasedAt');
  @override
  late final GeneratedColumn<DateTime> releasedAt = GeneratedColumn<DateTime>(
      'released_at', aliasedName, true,
      type: DriftSqlType.dateTime, requiredDuringInsert: false);
  static const VerificationMeta _manaCostMeta =
      const VerificationMeta('manaCost');
  @override
  late final GeneratedColumn<String> manaCost = GeneratedColumn<String>(
      'mana_cost', aliasedName, true,
      type: DriftSqlType.string, requiredDuringInsert: false);
  static const VerificationMeta _manaValueMeta =
      const VerificationMeta('manaValue');
  @override
  late final GeneratedColumn<double> manaValue = GeneratedColumn<double>(
      'mana_value', aliasedName, true,
      type: DriftSqlType.double, requiredDuringInsert: false);
  static const VerificationMeta _rarityMeta = const VerificationMeta('rarity');
  @override
  late final GeneratedColumn<String> rarity = GeneratedColumn<String>(
      'rarity', aliasedName, true,
      type: DriftSqlType.string, requiredDuringInsert: false);
  static const VerificationMeta _imageSmallMeta =
      const VerificationMeta('imageSmall');
  @override
  late final GeneratedColumn<String> imageSmall = GeneratedColumn<String>(
      'image_small', aliasedName, true,
      type: DriftSqlType.string, requiredDuringInsert: false);
  static const VerificationMeta _imageNormalMeta =
      const VerificationMeta('imageNormal');
  @override
  late final GeneratedColumn<String> imageNormal = GeneratedColumn<String>(
      'image_normal', aliasedName, true,
      type: DriftSqlType.string, requiredDuringInsert: false);
  static const VerificationMeta _imagePngMeta =
      const VerificationMeta('imagePng');
  @override
  late final GeneratedColumn<String> imagePng = GeneratedColumn<String>(
      'image_png', aliasedName, true,
      type: DriftSqlType.string, requiredDuringInsert: false);
  static const VerificationMeta _legalitiesJsonMeta =
      const VerificationMeta('legalitiesJson');
  @override
  late final GeneratedColumn<String> legalitiesJson = GeneratedColumn<String>(
      'legalities_json', aliasedName, true,
      type: DriftSqlType.string, requiredDuringInsert: false);
  static const VerificationMeta _updatedAtCacheMeta =
      const VerificationMeta('updatedAtCache');
  @override
  late final GeneratedColumn<DateTime> updatedAtCache =
      GeneratedColumn<DateTime>('updated_at_cache', aliasedName, false,
          type: DriftSqlType.dateTime, requiredDuringInsert: true);
  @override
  List<GeneratedColumn> get $columns => [
        printingId,
        oracleId,
        name,
        typeLine,
        setCode,
        setName,
        collectorNumber,
        releasedAt,
        manaCost,
        manaValue,
        rarity,
        imageSmall,
        imageNormal,
        imagePng,
        legalitiesJson,
        updatedAtCache
      ];
  @override
  String get aliasedName => _alias ?? actualTableName;
  @override
  String get actualTableName => $name;
  static const String $name = 'scryfall_printings';
  @override
  VerificationContext validateIntegrity(Insertable<ScryfallPrinting> instance,
      {bool isInserting = false}) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('printing_id')) {
      context.handle(
          _printingIdMeta,
          printingId.isAcceptableOrUnknown(
              data['printing_id']!, _printingIdMeta));
    } else if (isInserting) {
      context.missing(_printingIdMeta);
    }
    if (data.containsKey('oracle_id')) {
      context.handle(_oracleIdMeta,
          oracleId.isAcceptableOrUnknown(data['oracle_id']!, _oracleIdMeta));
    } else if (isInserting) {
      context.missing(_oracleIdMeta);
    }
    if (data.containsKey('name')) {
      context.handle(
          _nameMeta, name.isAcceptableOrUnknown(data['name']!, _nameMeta));
    } else if (isInserting) {
      context.missing(_nameMeta);
    }
    if (data.containsKey('type_line')) {
      context.handle(_typeLineMeta,
          typeLine.isAcceptableOrUnknown(data['type_line']!, _typeLineMeta));
    } else if (isInserting) {
      context.missing(_typeLineMeta);
    }
    if (data.containsKey('set_code')) {
      context.handle(_setCodeMeta,
          setCode.isAcceptableOrUnknown(data['set_code']!, _setCodeMeta));
    } else if (isInserting) {
      context.missing(_setCodeMeta);
    }
    if (data.containsKey('set_name')) {
      context.handle(_setNameMeta,
          setName.isAcceptableOrUnknown(data['set_name']!, _setNameMeta));
    } else if (isInserting) {
      context.missing(_setNameMeta);
    }
    if (data.containsKey('collector_number')) {
      context.handle(
          _collectorNumberMeta,
          collectorNumber.isAcceptableOrUnknown(
              data['collector_number']!, _collectorNumberMeta));
    } else if (isInserting) {
      context.missing(_collectorNumberMeta);
    }
    if (data.containsKey('released_at')) {
      context.handle(
          _releasedAtMeta,
          releasedAt.isAcceptableOrUnknown(
              data['released_at']!, _releasedAtMeta));
    }
    if (data.containsKey('mana_cost')) {
      context.handle(_manaCostMeta,
          manaCost.isAcceptableOrUnknown(data['mana_cost']!, _manaCostMeta));
    }
    if (data.containsKey('mana_value')) {
      context.handle(_manaValueMeta,
          manaValue.isAcceptableOrUnknown(data['mana_value']!, _manaValueMeta));
    }
    if (data.containsKey('rarity')) {
      context.handle(_rarityMeta,
          rarity.isAcceptableOrUnknown(data['rarity']!, _rarityMeta));
    }
    if (data.containsKey('image_small')) {
      context.handle(
          _imageSmallMeta,
          imageSmall.isAcceptableOrUnknown(
              data['image_small']!, _imageSmallMeta));
    }
    if (data.containsKey('image_normal')) {
      context.handle(
          _imageNormalMeta,
          imageNormal.isAcceptableOrUnknown(
              data['image_normal']!, _imageNormalMeta));
    }
    if (data.containsKey('image_png')) {
      context.handle(_imagePngMeta,
          imagePng.isAcceptableOrUnknown(data['image_png']!, _imagePngMeta));
    }
    if (data.containsKey('legalities_json')) {
      context.handle(
          _legalitiesJsonMeta,
          legalitiesJson.isAcceptableOrUnknown(
              data['legalities_json']!, _legalitiesJsonMeta));
    }
    if (data.containsKey('updated_at_cache')) {
      context.handle(
          _updatedAtCacheMeta,
          updatedAtCache.isAcceptableOrUnknown(
              data['updated_at_cache']!, _updatedAtCacheMeta));
    } else if (isInserting) {
      context.missing(_updatedAtCacheMeta);
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {printingId};
  @override
  ScryfallPrinting map(Map<String, dynamic> data, {String? tablePrefix}) {
    final effectivePrefix = tablePrefix != null ? '$tablePrefix.' : '';
    return ScryfallPrinting(
      printingId: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}printing_id'])!,
      oracleId: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}oracle_id'])!,
      name: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}name'])!,
      typeLine: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}type_line'])!,
      setCode: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}set_code'])!,
      setName: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}set_name'])!,
      collectorNumber: attachedDatabase.typeMapping.read(
          DriftSqlType.string, data['${effectivePrefix}collector_number'])!,
      releasedAt: attachedDatabase.typeMapping
          .read(DriftSqlType.dateTime, data['${effectivePrefix}released_at']),
      manaCost: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}mana_cost']),
      manaValue: attachedDatabase.typeMapping
          .read(DriftSqlType.double, data['${effectivePrefix}mana_value']),
      rarity: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}rarity']),
      imageSmall: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}image_small']),
      imageNormal: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}image_normal']),
      imagePng: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}image_png']),
      legalitiesJson: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}legalities_json']),
      updatedAtCache: attachedDatabase.typeMapping.read(
          DriftSqlType.dateTime, data['${effectivePrefix}updated_at_cache'])!,
    );
  }

  @override
  $ScryfallPrintingsTable createAlias(String alias) {
    return $ScryfallPrintingsTable(attachedDatabase, alias);
  }
}

class ScryfallPrinting extends DataClass
    implements Insertable<ScryfallPrinting> {
  final String printingId;
  final String oracleId;
  final String name;
  final String typeLine;
  final String setCode;
  final String setName;
  final String collectorNumber;
  final DateTime? releasedAt;
  final String? manaCost;
  final double? manaValue;
  final String? rarity;
  final String? imageSmall;
  final String? imageNormal;
  final String? imagePng;

  /// JSON string do map de legalities.
  final String? legalitiesJson;
  final DateTime updatedAtCache;
  const ScryfallPrinting(
      {required this.printingId,
      required this.oracleId,
      required this.name,
      required this.typeLine,
      required this.setCode,
      required this.setName,
      required this.collectorNumber,
      this.releasedAt,
      this.manaCost,
      this.manaValue,
      this.rarity,
      this.imageSmall,
      this.imageNormal,
      this.imagePng,
      this.legalitiesJson,
      required this.updatedAtCache});
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    map['printing_id'] = Variable<String>(printingId);
    map['oracle_id'] = Variable<String>(oracleId);
    map['name'] = Variable<String>(name);
    map['type_line'] = Variable<String>(typeLine);
    map['set_code'] = Variable<String>(setCode);
    map['set_name'] = Variable<String>(setName);
    map['collector_number'] = Variable<String>(collectorNumber);
    if (!nullToAbsent || releasedAt != null) {
      map['released_at'] = Variable<DateTime>(releasedAt);
    }
    if (!nullToAbsent || manaCost != null) {
      map['mana_cost'] = Variable<String>(manaCost);
    }
    if (!nullToAbsent || manaValue != null) {
      map['mana_value'] = Variable<double>(manaValue);
    }
    if (!nullToAbsent || rarity != null) {
      map['rarity'] = Variable<String>(rarity);
    }
    if (!nullToAbsent || imageSmall != null) {
      map['image_small'] = Variable<String>(imageSmall);
    }
    if (!nullToAbsent || imageNormal != null) {
      map['image_normal'] = Variable<String>(imageNormal);
    }
    if (!nullToAbsent || imagePng != null) {
      map['image_png'] = Variable<String>(imagePng);
    }
    if (!nullToAbsent || legalitiesJson != null) {
      map['legalities_json'] = Variable<String>(legalitiesJson);
    }
    map['updated_at_cache'] = Variable<DateTime>(updatedAtCache);
    return map;
  }

  ScryfallPrintingsCompanion toCompanion(bool nullToAbsent) {
    return ScryfallPrintingsCompanion(
      printingId: Value(printingId),
      oracleId: Value(oracleId),
      name: Value(name),
      typeLine: Value(typeLine),
      setCode: Value(setCode),
      setName: Value(setName),
      collectorNumber: Value(collectorNumber),
      releasedAt: releasedAt == null && nullToAbsent
          ? const Value.absent()
          : Value(releasedAt),
      manaCost: manaCost == null && nullToAbsent
          ? const Value.absent()
          : Value(manaCost),
      manaValue: manaValue == null && nullToAbsent
          ? const Value.absent()
          : Value(manaValue),
      rarity:
          rarity == null && nullToAbsent ? const Value.absent() : Value(rarity),
      imageSmall: imageSmall == null && nullToAbsent
          ? const Value.absent()
          : Value(imageSmall),
      imageNormal: imageNormal == null && nullToAbsent
          ? const Value.absent()
          : Value(imageNormal),
      imagePng: imagePng == null && nullToAbsent
          ? const Value.absent()
          : Value(imagePng),
      legalitiesJson: legalitiesJson == null && nullToAbsent
          ? const Value.absent()
          : Value(legalitiesJson),
      updatedAtCache: Value(updatedAtCache),
    );
  }

  factory ScryfallPrinting.fromJson(Map<String, dynamic> json,
      {ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return ScryfallPrinting(
      printingId: serializer.fromJson<String>(json['printingId']),
      oracleId: serializer.fromJson<String>(json['oracleId']),
      name: serializer.fromJson<String>(json['name']),
      typeLine: serializer.fromJson<String>(json['typeLine']),
      setCode: serializer.fromJson<String>(json['setCode']),
      setName: serializer.fromJson<String>(json['setName']),
      collectorNumber: serializer.fromJson<String>(json['collectorNumber']),
      releasedAt: serializer.fromJson<DateTime?>(json['releasedAt']),
      manaCost: serializer.fromJson<String?>(json['manaCost']),
      manaValue: serializer.fromJson<double?>(json['manaValue']),
      rarity: serializer.fromJson<String?>(json['rarity']),
      imageSmall: serializer.fromJson<String?>(json['imageSmall']),
      imageNormal: serializer.fromJson<String?>(json['imageNormal']),
      imagePng: serializer.fromJson<String?>(json['imagePng']),
      legalitiesJson: serializer.fromJson<String?>(json['legalitiesJson']),
      updatedAtCache: serializer.fromJson<DateTime>(json['updatedAtCache']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'printingId': serializer.toJson<String>(printingId),
      'oracleId': serializer.toJson<String>(oracleId),
      'name': serializer.toJson<String>(name),
      'typeLine': serializer.toJson<String>(typeLine),
      'setCode': serializer.toJson<String>(setCode),
      'setName': serializer.toJson<String>(setName),
      'collectorNumber': serializer.toJson<String>(collectorNumber),
      'releasedAt': serializer.toJson<DateTime?>(releasedAt),
      'manaCost': serializer.toJson<String?>(manaCost),
      'manaValue': serializer.toJson<double?>(manaValue),
      'rarity': serializer.toJson<String?>(rarity),
      'imageSmall': serializer.toJson<String?>(imageSmall),
      'imageNormal': serializer.toJson<String?>(imageNormal),
      'imagePng': serializer.toJson<String?>(imagePng),
      'legalitiesJson': serializer.toJson<String?>(legalitiesJson),
      'updatedAtCache': serializer.toJson<DateTime>(updatedAtCache),
    };
  }

  ScryfallPrinting copyWith(
          {String? printingId,
          String? oracleId,
          String? name,
          String? typeLine,
          String? setCode,
          String? setName,
          String? collectorNumber,
          Value<DateTime?> releasedAt = const Value.absent(),
          Value<String?> manaCost = const Value.absent(),
          Value<double?> manaValue = const Value.absent(),
          Value<String?> rarity = const Value.absent(),
          Value<String?> imageSmall = const Value.absent(),
          Value<String?> imageNormal = const Value.absent(),
          Value<String?> imagePng = const Value.absent(),
          Value<String?> legalitiesJson = const Value.absent(),
          DateTime? updatedAtCache}) =>
      ScryfallPrinting(
        printingId: printingId ?? this.printingId,
        oracleId: oracleId ?? this.oracleId,
        name: name ?? this.name,
        typeLine: typeLine ?? this.typeLine,
        setCode: setCode ?? this.setCode,
        setName: setName ?? this.setName,
        collectorNumber: collectorNumber ?? this.collectorNumber,
        releasedAt: releasedAt.present ? releasedAt.value : this.releasedAt,
        manaCost: manaCost.present ? manaCost.value : this.manaCost,
        manaValue: manaValue.present ? manaValue.value : this.manaValue,
        rarity: rarity.present ? rarity.value : this.rarity,
        imageSmall: imageSmall.present ? imageSmall.value : this.imageSmall,
        imageNormal: imageNormal.present ? imageNormal.value : this.imageNormal,
        imagePng: imagePng.present ? imagePng.value : this.imagePng,
        legalitiesJson:
            legalitiesJson.present ? legalitiesJson.value : this.legalitiesJson,
        updatedAtCache: updatedAtCache ?? this.updatedAtCache,
      );
  ScryfallPrinting copyWithCompanion(ScryfallPrintingsCompanion data) {
    return ScryfallPrinting(
      printingId:
          data.printingId.present ? data.printingId.value : this.printingId,
      oracleId: data.oracleId.present ? data.oracleId.value : this.oracleId,
      name: data.name.present ? data.name.value : this.name,
      typeLine: data.typeLine.present ? data.typeLine.value : this.typeLine,
      setCode: data.setCode.present ? data.setCode.value : this.setCode,
      setName: data.setName.present ? data.setName.value : this.setName,
      collectorNumber: data.collectorNumber.present
          ? data.collectorNumber.value
          : this.collectorNumber,
      releasedAt:
          data.releasedAt.present ? data.releasedAt.value : this.releasedAt,
      manaCost: data.manaCost.present ? data.manaCost.value : this.manaCost,
      manaValue: data.manaValue.present ? data.manaValue.value : this.manaValue,
      rarity: data.rarity.present ? data.rarity.value : this.rarity,
      imageSmall:
          data.imageSmall.present ? data.imageSmall.value : this.imageSmall,
      imageNormal:
          data.imageNormal.present ? data.imageNormal.value : this.imageNormal,
      imagePng: data.imagePng.present ? data.imagePng.value : this.imagePng,
      legalitiesJson: data.legalitiesJson.present
          ? data.legalitiesJson.value
          : this.legalitiesJson,
      updatedAtCache: data.updatedAtCache.present
          ? data.updatedAtCache.value
          : this.updatedAtCache,
    );
  }

  @override
  String toString() {
    return (StringBuffer('ScryfallPrinting(')
          ..write('printingId: $printingId, ')
          ..write('oracleId: $oracleId, ')
          ..write('name: $name, ')
          ..write('typeLine: $typeLine, ')
          ..write('setCode: $setCode, ')
          ..write('setName: $setName, ')
          ..write('collectorNumber: $collectorNumber, ')
          ..write('releasedAt: $releasedAt, ')
          ..write('manaCost: $manaCost, ')
          ..write('manaValue: $manaValue, ')
          ..write('rarity: $rarity, ')
          ..write('imageSmall: $imageSmall, ')
          ..write('imageNormal: $imageNormal, ')
          ..write('imagePng: $imagePng, ')
          ..write('legalitiesJson: $legalitiesJson, ')
          ..write('updatedAtCache: $updatedAtCache')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode => Object.hash(
      printingId,
      oracleId,
      name,
      typeLine,
      setCode,
      setName,
      collectorNumber,
      releasedAt,
      manaCost,
      manaValue,
      rarity,
      imageSmall,
      imageNormal,
      imagePng,
      legalitiesJson,
      updatedAtCache);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is ScryfallPrinting &&
          other.printingId == this.printingId &&
          other.oracleId == this.oracleId &&
          other.name == this.name &&
          other.typeLine == this.typeLine &&
          other.setCode == this.setCode &&
          other.setName == this.setName &&
          other.collectorNumber == this.collectorNumber &&
          other.releasedAt == this.releasedAt &&
          other.manaCost == this.manaCost &&
          other.manaValue == this.manaValue &&
          other.rarity == this.rarity &&
          other.imageSmall == this.imageSmall &&
          other.imageNormal == this.imageNormal &&
          other.imagePng == this.imagePng &&
          other.legalitiesJson == this.legalitiesJson &&
          other.updatedAtCache == this.updatedAtCache);
}

class ScryfallPrintingsCompanion extends UpdateCompanion<ScryfallPrinting> {
  final Value<String> printingId;
  final Value<String> oracleId;
  final Value<String> name;
  final Value<String> typeLine;
  final Value<String> setCode;
  final Value<String> setName;
  final Value<String> collectorNumber;
  final Value<DateTime?> releasedAt;
  final Value<String?> manaCost;
  final Value<double?> manaValue;
  final Value<String?> rarity;
  final Value<String?> imageSmall;
  final Value<String?> imageNormal;
  final Value<String?> imagePng;
  final Value<String?> legalitiesJson;
  final Value<DateTime> updatedAtCache;
  final Value<int> rowid;
  const ScryfallPrintingsCompanion({
    this.printingId = const Value.absent(),
    this.oracleId = const Value.absent(),
    this.name = const Value.absent(),
    this.typeLine = const Value.absent(),
    this.setCode = const Value.absent(),
    this.setName = const Value.absent(),
    this.collectorNumber = const Value.absent(),
    this.releasedAt = const Value.absent(),
    this.manaCost = const Value.absent(),
    this.manaValue = const Value.absent(),
    this.rarity = const Value.absent(),
    this.imageSmall = const Value.absent(),
    this.imageNormal = const Value.absent(),
    this.imagePng = const Value.absent(),
    this.legalitiesJson = const Value.absent(),
    this.updatedAtCache = const Value.absent(),
    this.rowid = const Value.absent(),
  });
  ScryfallPrintingsCompanion.insert({
    required String printingId,
    required String oracleId,
    required String name,
    required String typeLine,
    required String setCode,
    required String setName,
    required String collectorNumber,
    this.releasedAt = const Value.absent(),
    this.manaCost = const Value.absent(),
    this.manaValue = const Value.absent(),
    this.rarity = const Value.absent(),
    this.imageSmall = const Value.absent(),
    this.imageNormal = const Value.absent(),
    this.imagePng = const Value.absent(),
    this.legalitiesJson = const Value.absent(),
    required DateTime updatedAtCache,
    this.rowid = const Value.absent(),
  })  : printingId = Value(printingId),
        oracleId = Value(oracleId),
        name = Value(name),
        typeLine = Value(typeLine),
        setCode = Value(setCode),
        setName = Value(setName),
        collectorNumber = Value(collectorNumber),
        updatedAtCache = Value(updatedAtCache);
  static Insertable<ScryfallPrinting> custom({
    Expression<String>? printingId,
    Expression<String>? oracleId,
    Expression<String>? name,
    Expression<String>? typeLine,
    Expression<String>? setCode,
    Expression<String>? setName,
    Expression<String>? collectorNumber,
    Expression<DateTime>? releasedAt,
    Expression<String>? manaCost,
    Expression<double>? manaValue,
    Expression<String>? rarity,
    Expression<String>? imageSmall,
    Expression<String>? imageNormal,
    Expression<String>? imagePng,
    Expression<String>? legalitiesJson,
    Expression<DateTime>? updatedAtCache,
    Expression<int>? rowid,
  }) {
    return RawValuesInsertable({
      if (printingId != null) 'printing_id': printingId,
      if (oracleId != null) 'oracle_id': oracleId,
      if (name != null) 'name': name,
      if (typeLine != null) 'type_line': typeLine,
      if (setCode != null) 'set_code': setCode,
      if (setName != null) 'set_name': setName,
      if (collectorNumber != null) 'collector_number': collectorNumber,
      if (releasedAt != null) 'released_at': releasedAt,
      if (manaCost != null) 'mana_cost': manaCost,
      if (manaValue != null) 'mana_value': manaValue,
      if (rarity != null) 'rarity': rarity,
      if (imageSmall != null) 'image_small': imageSmall,
      if (imageNormal != null) 'image_normal': imageNormal,
      if (imagePng != null) 'image_png': imagePng,
      if (legalitiesJson != null) 'legalities_json': legalitiesJson,
      if (updatedAtCache != null) 'updated_at_cache': updatedAtCache,
      if (rowid != null) 'rowid': rowid,
    });
  }

  ScryfallPrintingsCompanion copyWith(
      {Value<String>? printingId,
      Value<String>? oracleId,
      Value<String>? name,
      Value<String>? typeLine,
      Value<String>? setCode,
      Value<String>? setName,
      Value<String>? collectorNumber,
      Value<DateTime?>? releasedAt,
      Value<String?>? manaCost,
      Value<double?>? manaValue,
      Value<String?>? rarity,
      Value<String?>? imageSmall,
      Value<String?>? imageNormal,
      Value<String?>? imagePng,
      Value<String?>? legalitiesJson,
      Value<DateTime>? updatedAtCache,
      Value<int>? rowid}) {
    return ScryfallPrintingsCompanion(
      printingId: printingId ?? this.printingId,
      oracleId: oracleId ?? this.oracleId,
      name: name ?? this.name,
      typeLine: typeLine ?? this.typeLine,
      setCode: setCode ?? this.setCode,
      setName: setName ?? this.setName,
      collectorNumber: collectorNumber ?? this.collectorNumber,
      releasedAt: releasedAt ?? this.releasedAt,
      manaCost: manaCost ?? this.manaCost,
      manaValue: manaValue ?? this.manaValue,
      rarity: rarity ?? this.rarity,
      imageSmall: imageSmall ?? this.imageSmall,
      imageNormal: imageNormal ?? this.imageNormal,
      imagePng: imagePng ?? this.imagePng,
      legalitiesJson: legalitiesJson ?? this.legalitiesJson,
      updatedAtCache: updatedAtCache ?? this.updatedAtCache,
      rowid: rowid ?? this.rowid,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (printingId.present) {
      map['printing_id'] = Variable<String>(printingId.value);
    }
    if (oracleId.present) {
      map['oracle_id'] = Variable<String>(oracleId.value);
    }
    if (name.present) {
      map['name'] = Variable<String>(name.value);
    }
    if (typeLine.present) {
      map['type_line'] = Variable<String>(typeLine.value);
    }
    if (setCode.present) {
      map['set_code'] = Variable<String>(setCode.value);
    }
    if (setName.present) {
      map['set_name'] = Variable<String>(setName.value);
    }
    if (collectorNumber.present) {
      map['collector_number'] = Variable<String>(collectorNumber.value);
    }
    if (releasedAt.present) {
      map['released_at'] = Variable<DateTime>(releasedAt.value);
    }
    if (manaCost.present) {
      map['mana_cost'] = Variable<String>(manaCost.value);
    }
    if (manaValue.present) {
      map['mana_value'] = Variable<double>(manaValue.value);
    }
    if (rarity.present) {
      map['rarity'] = Variable<String>(rarity.value);
    }
    if (imageSmall.present) {
      map['image_small'] = Variable<String>(imageSmall.value);
    }
    if (imageNormal.present) {
      map['image_normal'] = Variable<String>(imageNormal.value);
    }
    if (imagePng.present) {
      map['image_png'] = Variable<String>(imagePng.value);
    }
    if (legalitiesJson.present) {
      map['legalities_json'] = Variable<String>(legalitiesJson.value);
    }
    if (updatedAtCache.present) {
      map['updated_at_cache'] = Variable<DateTime>(updatedAtCache.value);
    }
    if (rowid.present) {
      map['rowid'] = Variable<int>(rowid.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('ScryfallPrintingsCompanion(')
          ..write('printingId: $printingId, ')
          ..write('oracleId: $oracleId, ')
          ..write('name: $name, ')
          ..write('typeLine: $typeLine, ')
          ..write('setCode: $setCode, ')
          ..write('setName: $setName, ')
          ..write('collectorNumber: $collectorNumber, ')
          ..write('releasedAt: $releasedAt, ')
          ..write('manaCost: $manaCost, ')
          ..write('manaValue: $manaValue, ')
          ..write('rarity: $rarity, ')
          ..write('imageSmall: $imageSmall, ')
          ..write('imageNormal: $imageNormal, ')
          ..write('imagePng: $imagePng, ')
          ..write('legalitiesJson: $legalitiesJson, ')
          ..write('updatedAtCache: $updatedAtCache, ')
          ..write('rowid: $rowid')
          ..write(')'))
        .toString();
  }
}

class $PriceSnapshotsTable extends PriceSnapshots
    with TableInfo<$PriceSnapshotsTable, PriceSnapshot> {
  @override
  final GeneratedDatabase attachedDatabase;
  final String? _alias;
  $PriceSnapshotsTable(this.attachedDatabase, [this._alias]);
  static const VerificationMeta _idMeta = const VerificationMeta('id');
  @override
  late final GeneratedColumn<String> id = GeneratedColumn<String>(
      'id', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _printingIdMeta =
      const VerificationMeta('printingId');
  @override
  late final GeneratedColumn<String> printingId = GeneratedColumn<String>(
      'printing_id', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _sourceMeta = const VerificationMeta('source');
  @override
  late final GeneratedColumn<String> source = GeneratedColumn<String>(
      'source', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _currencyMeta =
      const VerificationMeta('currency');
  @override
  late final GeneratedColumn<String> currency = GeneratedColumn<String>(
      'currency', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _valueMinorMeta =
      const VerificationMeta('valueMinor');
  @override
  late final GeneratedColumn<int> valueMinor = GeneratedColumn<int>(
      'value_minor', aliasedName, false,
      type: DriftSqlType.int, requiredDuringInsert: true);
  static const VerificationMeta _retrievedAtMeta =
      const VerificationMeta('retrievedAt');
  @override
  late final GeneratedColumn<DateTime> retrievedAt = GeneratedColumn<DateTime>(
      'retrieved_at', aliasedName, false,
      type: DriftSqlType.dateTime, requiredDuringInsert: true);
  @override
  List<GeneratedColumn> get $columns =>
      [id, printingId, source, currency, valueMinor, retrievedAt];
  @override
  String get aliasedName => _alias ?? actualTableName;
  @override
  String get actualTableName => $name;
  static const String $name = 'price_snapshots';
  @override
  VerificationContext validateIntegrity(Insertable<PriceSnapshot> instance,
      {bool isInserting = false}) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id')) {
      context.handle(_idMeta, id.isAcceptableOrUnknown(data['id']!, _idMeta));
    } else if (isInserting) {
      context.missing(_idMeta);
    }
    if (data.containsKey('printing_id')) {
      context.handle(
          _printingIdMeta,
          printingId.isAcceptableOrUnknown(
              data['printing_id']!, _printingIdMeta));
    } else if (isInserting) {
      context.missing(_printingIdMeta);
    }
    if (data.containsKey('source')) {
      context.handle(_sourceMeta,
          source.isAcceptableOrUnknown(data['source']!, _sourceMeta));
    } else if (isInserting) {
      context.missing(_sourceMeta);
    }
    if (data.containsKey('currency')) {
      context.handle(_currencyMeta,
          currency.isAcceptableOrUnknown(data['currency']!, _currencyMeta));
    } else if (isInserting) {
      context.missing(_currencyMeta);
    }
    if (data.containsKey('value_minor')) {
      context.handle(
          _valueMinorMeta,
          valueMinor.isAcceptableOrUnknown(
              data['value_minor']!, _valueMinorMeta));
    } else if (isInserting) {
      context.missing(_valueMinorMeta);
    }
    if (data.containsKey('retrieved_at')) {
      context.handle(
          _retrievedAtMeta,
          retrievedAt.isAcceptableOrUnknown(
              data['retrieved_at']!, _retrievedAtMeta));
    } else if (isInserting) {
      context.missing(_retrievedAtMeta);
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {id};
  @override
  PriceSnapshot map(Map<String, dynamic> data, {String? tablePrefix}) {
    final effectivePrefix = tablePrefix != null ? '$tablePrefix.' : '';
    return PriceSnapshot(
      id: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}id'])!,
      printingId: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}printing_id'])!,
      source: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}source'])!,
      currency: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}currency'])!,
      valueMinor: attachedDatabase.typeMapping
          .read(DriftSqlType.int, data['${effectivePrefix}value_minor'])!,
      retrievedAt: attachedDatabase.typeMapping
          .read(DriftSqlType.dateTime, data['${effectivePrefix}retrieved_at'])!,
    );
  }

  @override
  $PriceSnapshotsTable createAlias(String alias) {
    return $PriceSnapshotsTable(attachedDatabase, alias);
  }
}

class PriceSnapshot extends DataClass implements Insertable<PriceSnapshot> {
  final String id;
  final String printingId;

  /// Ex.: "scryfall_usd" (futuro: "ligamagic_brl")
  final String source;

  /// "USD", "BRL"
  final String currency;

  /// Valor em unidades menores: centavos (USD cents / BRL centavos)
  final int valueMinor;
  final DateTime retrievedAt;
  const PriceSnapshot(
      {required this.id,
      required this.printingId,
      required this.source,
      required this.currency,
      required this.valueMinor,
      required this.retrievedAt});
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    map['id'] = Variable<String>(id);
    map['printing_id'] = Variable<String>(printingId);
    map['source'] = Variable<String>(source);
    map['currency'] = Variable<String>(currency);
    map['value_minor'] = Variable<int>(valueMinor);
    map['retrieved_at'] = Variable<DateTime>(retrievedAt);
    return map;
  }

  PriceSnapshotsCompanion toCompanion(bool nullToAbsent) {
    return PriceSnapshotsCompanion(
      id: Value(id),
      printingId: Value(printingId),
      source: Value(source),
      currency: Value(currency),
      valueMinor: Value(valueMinor),
      retrievedAt: Value(retrievedAt),
    );
  }

  factory PriceSnapshot.fromJson(Map<String, dynamic> json,
      {ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return PriceSnapshot(
      id: serializer.fromJson<String>(json['id']),
      printingId: serializer.fromJson<String>(json['printingId']),
      source: serializer.fromJson<String>(json['source']),
      currency: serializer.fromJson<String>(json['currency']),
      valueMinor: serializer.fromJson<int>(json['valueMinor']),
      retrievedAt: serializer.fromJson<DateTime>(json['retrievedAt']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'id': serializer.toJson<String>(id),
      'printingId': serializer.toJson<String>(printingId),
      'source': serializer.toJson<String>(source),
      'currency': serializer.toJson<String>(currency),
      'valueMinor': serializer.toJson<int>(valueMinor),
      'retrievedAt': serializer.toJson<DateTime>(retrievedAt),
    };
  }

  PriceSnapshot copyWith(
          {String? id,
          String? printingId,
          String? source,
          String? currency,
          int? valueMinor,
          DateTime? retrievedAt}) =>
      PriceSnapshot(
        id: id ?? this.id,
        printingId: printingId ?? this.printingId,
        source: source ?? this.source,
        currency: currency ?? this.currency,
        valueMinor: valueMinor ?? this.valueMinor,
        retrievedAt: retrievedAt ?? this.retrievedAt,
      );
  PriceSnapshot copyWithCompanion(PriceSnapshotsCompanion data) {
    return PriceSnapshot(
      id: data.id.present ? data.id.value : this.id,
      printingId:
          data.printingId.present ? data.printingId.value : this.printingId,
      source: data.source.present ? data.source.value : this.source,
      currency: data.currency.present ? data.currency.value : this.currency,
      valueMinor:
          data.valueMinor.present ? data.valueMinor.value : this.valueMinor,
      retrievedAt:
          data.retrievedAt.present ? data.retrievedAt.value : this.retrievedAt,
    );
  }

  @override
  String toString() {
    return (StringBuffer('PriceSnapshot(')
          ..write('id: $id, ')
          ..write('printingId: $printingId, ')
          ..write('source: $source, ')
          ..write('currency: $currency, ')
          ..write('valueMinor: $valueMinor, ')
          ..write('retrievedAt: $retrievedAt')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode =>
      Object.hash(id, printingId, source, currency, valueMinor, retrievedAt);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is PriceSnapshot &&
          other.id == this.id &&
          other.printingId == this.printingId &&
          other.source == this.source &&
          other.currency == this.currency &&
          other.valueMinor == this.valueMinor &&
          other.retrievedAt == this.retrievedAt);
}

class PriceSnapshotsCompanion extends UpdateCompanion<PriceSnapshot> {
  final Value<String> id;
  final Value<String> printingId;
  final Value<String> source;
  final Value<String> currency;
  final Value<int> valueMinor;
  final Value<DateTime> retrievedAt;
  final Value<int> rowid;
  const PriceSnapshotsCompanion({
    this.id = const Value.absent(),
    this.printingId = const Value.absent(),
    this.source = const Value.absent(),
    this.currency = const Value.absent(),
    this.valueMinor = const Value.absent(),
    this.retrievedAt = const Value.absent(),
    this.rowid = const Value.absent(),
  });
  PriceSnapshotsCompanion.insert({
    required String id,
    required String printingId,
    required String source,
    required String currency,
    required int valueMinor,
    required DateTime retrievedAt,
    this.rowid = const Value.absent(),
  })  : id = Value(id),
        printingId = Value(printingId),
        source = Value(source),
        currency = Value(currency),
        valueMinor = Value(valueMinor),
        retrievedAt = Value(retrievedAt);
  static Insertable<PriceSnapshot> custom({
    Expression<String>? id,
    Expression<String>? printingId,
    Expression<String>? source,
    Expression<String>? currency,
    Expression<int>? valueMinor,
    Expression<DateTime>? retrievedAt,
    Expression<int>? rowid,
  }) {
    return RawValuesInsertable({
      if (id != null) 'id': id,
      if (printingId != null) 'printing_id': printingId,
      if (source != null) 'source': source,
      if (currency != null) 'currency': currency,
      if (valueMinor != null) 'value_minor': valueMinor,
      if (retrievedAt != null) 'retrieved_at': retrievedAt,
      if (rowid != null) 'rowid': rowid,
    });
  }

  PriceSnapshotsCompanion copyWith(
      {Value<String>? id,
      Value<String>? printingId,
      Value<String>? source,
      Value<String>? currency,
      Value<int>? valueMinor,
      Value<DateTime>? retrievedAt,
      Value<int>? rowid}) {
    return PriceSnapshotsCompanion(
      id: id ?? this.id,
      printingId: printingId ?? this.printingId,
      source: source ?? this.source,
      currency: currency ?? this.currency,
      valueMinor: valueMinor ?? this.valueMinor,
      retrievedAt: retrievedAt ?? this.retrievedAt,
      rowid: rowid ?? this.rowid,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (id.present) {
      map['id'] = Variable<String>(id.value);
    }
    if (printingId.present) {
      map['printing_id'] = Variable<String>(printingId.value);
    }
    if (source.present) {
      map['source'] = Variable<String>(source.value);
    }
    if (currency.present) {
      map['currency'] = Variable<String>(currency.value);
    }
    if (valueMinor.present) {
      map['value_minor'] = Variable<int>(valueMinor.value);
    }
    if (retrievedAt.present) {
      map['retrieved_at'] = Variable<DateTime>(retrievedAt.value);
    }
    if (rowid.present) {
      map['rowid'] = Variable<int>(rowid.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('PriceSnapshotsCompanion(')
          ..write('id: $id, ')
          ..write('printingId: $printingId, ')
          ..write('source: $source, ')
          ..write('currency: $currency, ')
          ..write('valueMinor: $valueMinor, ')
          ..write('retrievedAt: $retrievedAt, ')
          ..write('rowid: $rowid')
          ..write(')'))
        .toString();
  }
}

class $CollectionsTable extends Collections
    with TableInfo<$CollectionsTable, Collection> {
  @override
  final GeneratedDatabase attachedDatabase;
  final String? _alias;
  $CollectionsTable(this.attachedDatabase, [this._alias]);
  static const VerificationMeta _idMeta = const VerificationMeta('id');
  @override
  late final GeneratedColumn<String> id = GeneratedColumn<String>(
      'id', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _nameMeta = const VerificationMeta('name');
  @override
  late final GeneratedColumn<String> name = GeneratedColumn<String>(
      'name', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _createdAtMeta =
      const VerificationMeta('createdAt');
  @override
  late final GeneratedColumn<DateTime> createdAt = GeneratedColumn<DateTime>(
      'created_at', aliasedName, false,
      type: DriftSqlType.dateTime, requiredDuringInsert: true);
  static const VerificationMeta _updatedAtMeta =
      const VerificationMeta('updatedAt');
  @override
  late final GeneratedColumn<DateTime> updatedAt = GeneratedColumn<DateTime>(
      'updated_at', aliasedName, false,
      type: DriftSqlType.dateTime, requiredDuringInsert: true);
  @override
  List<GeneratedColumn> get $columns => [id, name, createdAt, updatedAt];
  @override
  String get aliasedName => _alias ?? actualTableName;
  @override
  String get actualTableName => $name;
  static const String $name = 'collections';
  @override
  VerificationContext validateIntegrity(Insertable<Collection> instance,
      {bool isInserting = false}) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id')) {
      context.handle(_idMeta, id.isAcceptableOrUnknown(data['id']!, _idMeta));
    } else if (isInserting) {
      context.missing(_idMeta);
    }
    if (data.containsKey('name')) {
      context.handle(
          _nameMeta, name.isAcceptableOrUnknown(data['name']!, _nameMeta));
    } else if (isInserting) {
      context.missing(_nameMeta);
    }
    if (data.containsKey('created_at')) {
      context.handle(_createdAtMeta,
          createdAt.isAcceptableOrUnknown(data['created_at']!, _createdAtMeta));
    } else if (isInserting) {
      context.missing(_createdAtMeta);
    }
    if (data.containsKey('updated_at')) {
      context.handle(_updatedAtMeta,
          updatedAt.isAcceptableOrUnknown(data['updated_at']!, _updatedAtMeta));
    } else if (isInserting) {
      context.missing(_updatedAtMeta);
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {id};
  @override
  Collection map(Map<String, dynamic> data, {String? tablePrefix}) {
    final effectivePrefix = tablePrefix != null ? '$tablePrefix.' : '';
    return Collection(
      id: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}id'])!,
      name: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}name'])!,
      createdAt: attachedDatabase.typeMapping
          .read(DriftSqlType.dateTime, data['${effectivePrefix}created_at'])!,
      updatedAt: attachedDatabase.typeMapping
          .read(DriftSqlType.dateTime, data['${effectivePrefix}updated_at'])!,
    );
  }

  @override
  $CollectionsTable createAlias(String alias) {
    return $CollectionsTable(attachedDatabase, alias);
  }
}

class Collection extends DataClass implements Insertable<Collection> {
  final String id;
  final String name;
  final DateTime createdAt;
  final DateTime updatedAt;
  const Collection(
      {required this.id,
      required this.name,
      required this.createdAt,
      required this.updatedAt});
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    map['id'] = Variable<String>(id);
    map['name'] = Variable<String>(name);
    map['created_at'] = Variable<DateTime>(createdAt);
    map['updated_at'] = Variable<DateTime>(updatedAt);
    return map;
  }

  CollectionsCompanion toCompanion(bool nullToAbsent) {
    return CollectionsCompanion(
      id: Value(id),
      name: Value(name),
      createdAt: Value(createdAt),
      updatedAt: Value(updatedAt),
    );
  }

  factory Collection.fromJson(Map<String, dynamic> json,
      {ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return Collection(
      id: serializer.fromJson<String>(json['id']),
      name: serializer.fromJson<String>(json['name']),
      createdAt: serializer.fromJson<DateTime>(json['createdAt']),
      updatedAt: serializer.fromJson<DateTime>(json['updatedAt']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'id': serializer.toJson<String>(id),
      'name': serializer.toJson<String>(name),
      'createdAt': serializer.toJson<DateTime>(createdAt),
      'updatedAt': serializer.toJson<DateTime>(updatedAt),
    };
  }

  Collection copyWith(
          {String? id,
          String? name,
          DateTime? createdAt,
          DateTime? updatedAt}) =>
      Collection(
        id: id ?? this.id,
        name: name ?? this.name,
        createdAt: createdAt ?? this.createdAt,
        updatedAt: updatedAt ?? this.updatedAt,
      );
  Collection copyWithCompanion(CollectionsCompanion data) {
    return Collection(
      id: data.id.present ? data.id.value : this.id,
      name: data.name.present ? data.name.value : this.name,
      createdAt: data.createdAt.present ? data.createdAt.value : this.createdAt,
      updatedAt: data.updatedAt.present ? data.updatedAt.value : this.updatedAt,
    );
  }

  @override
  String toString() {
    return (StringBuffer('Collection(')
          ..write('id: $id, ')
          ..write('name: $name, ')
          ..write('createdAt: $createdAt, ')
          ..write('updatedAt: $updatedAt')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode => Object.hash(id, name, createdAt, updatedAt);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is Collection &&
          other.id == this.id &&
          other.name == this.name &&
          other.createdAt == this.createdAt &&
          other.updatedAt == this.updatedAt);
}

class CollectionsCompanion extends UpdateCompanion<Collection> {
  final Value<String> id;
  final Value<String> name;
  final Value<DateTime> createdAt;
  final Value<DateTime> updatedAt;
  final Value<int> rowid;
  const CollectionsCompanion({
    this.id = const Value.absent(),
    this.name = const Value.absent(),
    this.createdAt = const Value.absent(),
    this.updatedAt = const Value.absent(),
    this.rowid = const Value.absent(),
  });
  CollectionsCompanion.insert({
    required String id,
    required String name,
    required DateTime createdAt,
    required DateTime updatedAt,
    this.rowid = const Value.absent(),
  })  : id = Value(id),
        name = Value(name),
        createdAt = Value(createdAt),
        updatedAt = Value(updatedAt);
  static Insertable<Collection> custom({
    Expression<String>? id,
    Expression<String>? name,
    Expression<DateTime>? createdAt,
    Expression<DateTime>? updatedAt,
    Expression<int>? rowid,
  }) {
    return RawValuesInsertable({
      if (id != null) 'id': id,
      if (name != null) 'name': name,
      if (createdAt != null) 'created_at': createdAt,
      if (updatedAt != null) 'updated_at': updatedAt,
      if (rowid != null) 'rowid': rowid,
    });
  }

  CollectionsCompanion copyWith(
      {Value<String>? id,
      Value<String>? name,
      Value<DateTime>? createdAt,
      Value<DateTime>? updatedAt,
      Value<int>? rowid}) {
    return CollectionsCompanion(
      id: id ?? this.id,
      name: name ?? this.name,
      createdAt: createdAt ?? this.createdAt,
      updatedAt: updatedAt ?? this.updatedAt,
      rowid: rowid ?? this.rowid,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (id.present) {
      map['id'] = Variable<String>(id.value);
    }
    if (name.present) {
      map['name'] = Variable<String>(name.value);
    }
    if (createdAt.present) {
      map['created_at'] = Variable<DateTime>(createdAt.value);
    }
    if (updatedAt.present) {
      map['updated_at'] = Variable<DateTime>(updatedAt.value);
    }
    if (rowid.present) {
      map['rowid'] = Variable<int>(rowid.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('CollectionsCompanion(')
          ..write('id: $id, ')
          ..write('name: $name, ')
          ..write('createdAt: $createdAt, ')
          ..write('updatedAt: $updatedAt, ')
          ..write('rowid: $rowid')
          ..write(')'))
        .toString();
  }
}

class $CollectionItemsTable extends CollectionItems
    with TableInfo<$CollectionItemsTable, CollectionItem> {
  @override
  final GeneratedDatabase attachedDatabase;
  final String? _alias;
  $CollectionItemsTable(this.attachedDatabase, [this._alias]);
  static const VerificationMeta _idMeta = const VerificationMeta('id');
  @override
  late final GeneratedColumn<String> id = GeneratedColumn<String>(
      'id', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _collectionIdMeta =
      const VerificationMeta('collectionId');
  @override
  late final GeneratedColumn<String> collectionId = GeneratedColumn<String>(
      'collection_id', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _printingIdMeta =
      const VerificationMeta('printingId');
  @override
  late final GeneratedColumn<String> printingId = GeneratedColumn<String>(
      'printing_id', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _quantityMeta =
      const VerificationMeta('quantity');
  @override
  late final GeneratedColumn<int> quantity = GeneratedColumn<int>(
      'quantity', aliasedName, false,
      type: DriftSqlType.int, requiredDuringInsert: true);
  static const VerificationMeta _isFoilMeta = const VerificationMeta('isFoil');
  @override
  late final GeneratedColumn<bool> isFoil = GeneratedColumn<bool>(
      'is_foil', aliasedName, false,
      type: DriftSqlType.bool,
      requiredDuringInsert: false,
      defaultConstraints:
          GeneratedColumn.constraintIsAlways('CHECK ("is_foil" IN (0, 1))'),
      defaultValue: const Constant(false));
  static const VerificationMeta _conditionMeta =
      const VerificationMeta('condition');
  @override
  late final GeneratedColumn<String> condition = GeneratedColumn<String>(
      'condition', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _languageMeta =
      const VerificationMeta('language');
  @override
  late final GeneratedColumn<String> language = GeneratedColumn<String>(
      'language', aliasedName, false,
      type: DriftSqlType.string,
      requiredDuringInsert: false,
      defaultValue: const Constant('EN'));
  static const VerificationMeta _notesMeta = const VerificationMeta('notes');
  @override
  late final GeneratedColumn<String> notes = GeneratedColumn<String>(
      'notes', aliasedName, true,
      type: DriftSqlType.string, requiredDuringInsert: false);
  static const VerificationMeta _createdAtMeta =
      const VerificationMeta('createdAt');
  @override
  late final GeneratedColumn<DateTime> createdAt = GeneratedColumn<DateTime>(
      'created_at', aliasedName, false,
      type: DriftSqlType.dateTime, requiredDuringInsert: true);
  static const VerificationMeta _updatedAtMeta =
      const VerificationMeta('updatedAt');
  @override
  late final GeneratedColumn<DateTime> updatedAt = GeneratedColumn<DateTime>(
      'updated_at', aliasedName, false,
      type: DriftSqlType.dateTime, requiredDuringInsert: true);
  @override
  List<GeneratedColumn> get $columns => [
        id,
        collectionId,
        printingId,
        quantity,
        isFoil,
        condition,
        language,
        notes,
        createdAt,
        updatedAt
      ];
  @override
  String get aliasedName => _alias ?? actualTableName;
  @override
  String get actualTableName => $name;
  static const String $name = 'collection_items';
  @override
  VerificationContext validateIntegrity(Insertable<CollectionItem> instance,
      {bool isInserting = false}) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id')) {
      context.handle(_idMeta, id.isAcceptableOrUnknown(data['id']!, _idMeta));
    } else if (isInserting) {
      context.missing(_idMeta);
    }
    if (data.containsKey('collection_id')) {
      context.handle(
          _collectionIdMeta,
          collectionId.isAcceptableOrUnknown(
              data['collection_id']!, _collectionIdMeta));
    } else if (isInserting) {
      context.missing(_collectionIdMeta);
    }
    if (data.containsKey('printing_id')) {
      context.handle(
          _printingIdMeta,
          printingId.isAcceptableOrUnknown(
              data['printing_id']!, _printingIdMeta));
    } else if (isInserting) {
      context.missing(_printingIdMeta);
    }
    if (data.containsKey('quantity')) {
      context.handle(_quantityMeta,
          quantity.isAcceptableOrUnknown(data['quantity']!, _quantityMeta));
    } else if (isInserting) {
      context.missing(_quantityMeta);
    }
    if (data.containsKey('is_foil')) {
      context.handle(_isFoilMeta,
          isFoil.isAcceptableOrUnknown(data['is_foil']!, _isFoilMeta));
    }
    if (data.containsKey('condition')) {
      context.handle(_conditionMeta,
          condition.isAcceptableOrUnknown(data['condition']!, _conditionMeta));
    } else if (isInserting) {
      context.missing(_conditionMeta);
    }
    if (data.containsKey('language')) {
      context.handle(_languageMeta,
          language.isAcceptableOrUnknown(data['language']!, _languageMeta));
    }
    if (data.containsKey('notes')) {
      context.handle(
          _notesMeta, notes.isAcceptableOrUnknown(data['notes']!, _notesMeta));
    }
    if (data.containsKey('created_at')) {
      context.handle(_createdAtMeta,
          createdAt.isAcceptableOrUnknown(data['created_at']!, _createdAtMeta));
    } else if (isInserting) {
      context.missing(_createdAtMeta);
    }
    if (data.containsKey('updated_at')) {
      context.handle(_updatedAtMeta,
          updatedAt.isAcceptableOrUnknown(data['updated_at']!, _updatedAtMeta));
    } else if (isInserting) {
      context.missing(_updatedAtMeta);
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {id};
  @override
  CollectionItem map(Map<String, dynamic> data, {String? tablePrefix}) {
    final effectivePrefix = tablePrefix != null ? '$tablePrefix.' : '';
    return CollectionItem(
      id: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}id'])!,
      collectionId: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}collection_id'])!,
      printingId: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}printing_id'])!,
      quantity: attachedDatabase.typeMapping
          .read(DriftSqlType.int, data['${effectivePrefix}quantity'])!,
      isFoil: attachedDatabase.typeMapping
          .read(DriftSqlType.bool, data['${effectivePrefix}is_foil'])!,
      condition: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}condition'])!,
      language: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}language'])!,
      notes: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}notes']),
      createdAt: attachedDatabase.typeMapping
          .read(DriftSqlType.dateTime, data['${effectivePrefix}created_at'])!,
      updatedAt: attachedDatabase.typeMapping
          .read(DriftSqlType.dateTime, data['${effectivePrefix}updated_at'])!,
    );
  }

  @override
  $CollectionItemsTable createAlias(String alias) {
    return $CollectionItemsTable(attachedDatabase, alias);
  }
}

class CollectionItem extends DataClass implements Insertable<CollectionItem> {
  final String id;
  final String collectionId;
  final String printingId;
  final int quantity;
  final bool isFoil;
  final String condition;
  final String language;
  final String? notes;
  final DateTime createdAt;
  final DateTime updatedAt;
  const CollectionItem(
      {required this.id,
      required this.collectionId,
      required this.printingId,
      required this.quantity,
      required this.isFoil,
      required this.condition,
      required this.language,
      this.notes,
      required this.createdAt,
      required this.updatedAt});
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    map['id'] = Variable<String>(id);
    map['collection_id'] = Variable<String>(collectionId);
    map['printing_id'] = Variable<String>(printingId);
    map['quantity'] = Variable<int>(quantity);
    map['is_foil'] = Variable<bool>(isFoil);
    map['condition'] = Variable<String>(condition);
    map['language'] = Variable<String>(language);
    if (!nullToAbsent || notes != null) {
      map['notes'] = Variable<String>(notes);
    }
    map['created_at'] = Variable<DateTime>(createdAt);
    map['updated_at'] = Variable<DateTime>(updatedAt);
    return map;
  }

  CollectionItemsCompanion toCompanion(bool nullToAbsent) {
    return CollectionItemsCompanion(
      id: Value(id),
      collectionId: Value(collectionId),
      printingId: Value(printingId),
      quantity: Value(quantity),
      isFoil: Value(isFoil),
      condition: Value(condition),
      language: Value(language),
      notes:
          notes == null && nullToAbsent ? const Value.absent() : Value(notes),
      createdAt: Value(createdAt),
      updatedAt: Value(updatedAt),
    );
  }

  factory CollectionItem.fromJson(Map<String, dynamic> json,
      {ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return CollectionItem(
      id: serializer.fromJson<String>(json['id']),
      collectionId: serializer.fromJson<String>(json['collectionId']),
      printingId: serializer.fromJson<String>(json['printingId']),
      quantity: serializer.fromJson<int>(json['quantity']),
      isFoil: serializer.fromJson<bool>(json['isFoil']),
      condition: serializer.fromJson<String>(json['condition']),
      language: serializer.fromJson<String>(json['language']),
      notes: serializer.fromJson<String?>(json['notes']),
      createdAt: serializer.fromJson<DateTime>(json['createdAt']),
      updatedAt: serializer.fromJson<DateTime>(json['updatedAt']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'id': serializer.toJson<String>(id),
      'collectionId': serializer.toJson<String>(collectionId),
      'printingId': serializer.toJson<String>(printingId),
      'quantity': serializer.toJson<int>(quantity),
      'isFoil': serializer.toJson<bool>(isFoil),
      'condition': serializer.toJson<String>(condition),
      'language': serializer.toJson<String>(language),
      'notes': serializer.toJson<String?>(notes),
      'createdAt': serializer.toJson<DateTime>(createdAt),
      'updatedAt': serializer.toJson<DateTime>(updatedAt),
    };
  }

  CollectionItem copyWith(
          {String? id,
          String? collectionId,
          String? printingId,
          int? quantity,
          bool? isFoil,
          String? condition,
          String? language,
          Value<String?> notes = const Value.absent(),
          DateTime? createdAt,
          DateTime? updatedAt}) =>
      CollectionItem(
        id: id ?? this.id,
        collectionId: collectionId ?? this.collectionId,
        printingId: printingId ?? this.printingId,
        quantity: quantity ?? this.quantity,
        isFoil: isFoil ?? this.isFoil,
        condition: condition ?? this.condition,
        language: language ?? this.language,
        notes: notes.present ? notes.value : this.notes,
        createdAt: createdAt ?? this.createdAt,
        updatedAt: updatedAt ?? this.updatedAt,
      );
  CollectionItem copyWithCompanion(CollectionItemsCompanion data) {
    return CollectionItem(
      id: data.id.present ? data.id.value : this.id,
      collectionId: data.collectionId.present
          ? data.collectionId.value
          : this.collectionId,
      printingId:
          data.printingId.present ? data.printingId.value : this.printingId,
      quantity: data.quantity.present ? data.quantity.value : this.quantity,
      isFoil: data.isFoil.present ? data.isFoil.value : this.isFoil,
      condition: data.condition.present ? data.condition.value : this.condition,
      language: data.language.present ? data.language.value : this.language,
      notes: data.notes.present ? data.notes.value : this.notes,
      createdAt: data.createdAt.present ? data.createdAt.value : this.createdAt,
      updatedAt: data.updatedAt.present ? data.updatedAt.value : this.updatedAt,
    );
  }

  @override
  String toString() {
    return (StringBuffer('CollectionItem(')
          ..write('id: $id, ')
          ..write('collectionId: $collectionId, ')
          ..write('printingId: $printingId, ')
          ..write('quantity: $quantity, ')
          ..write('isFoil: $isFoil, ')
          ..write('condition: $condition, ')
          ..write('language: $language, ')
          ..write('notes: $notes, ')
          ..write('createdAt: $createdAt, ')
          ..write('updatedAt: $updatedAt')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode => Object.hash(id, collectionId, printingId, quantity,
      isFoil, condition, language, notes, createdAt, updatedAt);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is CollectionItem &&
          other.id == this.id &&
          other.collectionId == this.collectionId &&
          other.printingId == this.printingId &&
          other.quantity == this.quantity &&
          other.isFoil == this.isFoil &&
          other.condition == this.condition &&
          other.language == this.language &&
          other.notes == this.notes &&
          other.createdAt == this.createdAt &&
          other.updatedAt == this.updatedAt);
}

class CollectionItemsCompanion extends UpdateCompanion<CollectionItem> {
  final Value<String> id;
  final Value<String> collectionId;
  final Value<String> printingId;
  final Value<int> quantity;
  final Value<bool> isFoil;
  final Value<String> condition;
  final Value<String> language;
  final Value<String?> notes;
  final Value<DateTime> createdAt;
  final Value<DateTime> updatedAt;
  final Value<int> rowid;
  const CollectionItemsCompanion({
    this.id = const Value.absent(),
    this.collectionId = const Value.absent(),
    this.printingId = const Value.absent(),
    this.quantity = const Value.absent(),
    this.isFoil = const Value.absent(),
    this.condition = const Value.absent(),
    this.language = const Value.absent(),
    this.notes = const Value.absent(),
    this.createdAt = const Value.absent(),
    this.updatedAt = const Value.absent(),
    this.rowid = const Value.absent(),
  });
  CollectionItemsCompanion.insert({
    required String id,
    required String collectionId,
    required String printingId,
    required int quantity,
    this.isFoil = const Value.absent(),
    required String condition,
    this.language = const Value.absent(),
    this.notes = const Value.absent(),
    required DateTime createdAt,
    required DateTime updatedAt,
    this.rowid = const Value.absent(),
  })  : id = Value(id),
        collectionId = Value(collectionId),
        printingId = Value(printingId),
        quantity = Value(quantity),
        condition = Value(condition),
        createdAt = Value(createdAt),
        updatedAt = Value(updatedAt);
  static Insertable<CollectionItem> custom({
    Expression<String>? id,
    Expression<String>? collectionId,
    Expression<String>? printingId,
    Expression<int>? quantity,
    Expression<bool>? isFoil,
    Expression<String>? condition,
    Expression<String>? language,
    Expression<String>? notes,
    Expression<DateTime>? createdAt,
    Expression<DateTime>? updatedAt,
    Expression<int>? rowid,
  }) {
    return RawValuesInsertable({
      if (id != null) 'id': id,
      if (collectionId != null) 'collection_id': collectionId,
      if (printingId != null) 'printing_id': printingId,
      if (quantity != null) 'quantity': quantity,
      if (isFoil != null) 'is_foil': isFoil,
      if (condition != null) 'condition': condition,
      if (language != null) 'language': language,
      if (notes != null) 'notes': notes,
      if (createdAt != null) 'created_at': createdAt,
      if (updatedAt != null) 'updated_at': updatedAt,
      if (rowid != null) 'rowid': rowid,
    });
  }

  CollectionItemsCompanion copyWith(
      {Value<String>? id,
      Value<String>? collectionId,
      Value<String>? printingId,
      Value<int>? quantity,
      Value<bool>? isFoil,
      Value<String>? condition,
      Value<String>? language,
      Value<String?>? notes,
      Value<DateTime>? createdAt,
      Value<DateTime>? updatedAt,
      Value<int>? rowid}) {
    return CollectionItemsCompanion(
      id: id ?? this.id,
      collectionId: collectionId ?? this.collectionId,
      printingId: printingId ?? this.printingId,
      quantity: quantity ?? this.quantity,
      isFoil: isFoil ?? this.isFoil,
      condition: condition ?? this.condition,
      language: language ?? this.language,
      notes: notes ?? this.notes,
      createdAt: createdAt ?? this.createdAt,
      updatedAt: updatedAt ?? this.updatedAt,
      rowid: rowid ?? this.rowid,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (id.present) {
      map['id'] = Variable<String>(id.value);
    }
    if (collectionId.present) {
      map['collection_id'] = Variable<String>(collectionId.value);
    }
    if (printingId.present) {
      map['printing_id'] = Variable<String>(printingId.value);
    }
    if (quantity.present) {
      map['quantity'] = Variable<int>(quantity.value);
    }
    if (isFoil.present) {
      map['is_foil'] = Variable<bool>(isFoil.value);
    }
    if (condition.present) {
      map['condition'] = Variable<String>(condition.value);
    }
    if (language.present) {
      map['language'] = Variable<String>(language.value);
    }
    if (notes.present) {
      map['notes'] = Variable<String>(notes.value);
    }
    if (createdAt.present) {
      map['created_at'] = Variable<DateTime>(createdAt.value);
    }
    if (updatedAt.present) {
      map['updated_at'] = Variable<DateTime>(updatedAt.value);
    }
    if (rowid.present) {
      map['rowid'] = Variable<int>(rowid.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('CollectionItemsCompanion(')
          ..write('id: $id, ')
          ..write('collectionId: $collectionId, ')
          ..write('printingId: $printingId, ')
          ..write('quantity: $quantity, ')
          ..write('isFoil: $isFoil, ')
          ..write('condition: $condition, ')
          ..write('language: $language, ')
          ..write('notes: $notes, ')
          ..write('createdAt: $createdAt, ')
          ..write('updatedAt: $updatedAt, ')
          ..write('rowid: $rowid')
          ..write(')'))
        .toString();
  }
}

class $DecksTable extends Decks with TableInfo<$DecksTable, Deck> {
  @override
  final GeneratedDatabase attachedDatabase;
  final String? _alias;
  $DecksTable(this.attachedDatabase, [this._alias]);
  static const VerificationMeta _idMeta = const VerificationMeta('id');
  @override
  late final GeneratedColumn<String> id = GeneratedColumn<String>(
      'id', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _nameMeta = const VerificationMeta('name');
  @override
  late final GeneratedColumn<String> name = GeneratedColumn<String>(
      'name', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _formatMeta = const VerificationMeta('format');
  @override
  late final GeneratedColumn<String> format = GeneratedColumn<String>(
      'format', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _isActiveMeta =
      const VerificationMeta('isActive');
  @override
  late final GeneratedColumn<bool> isActive = GeneratedColumn<bool>(
      'is_active', aliasedName, false,
      type: DriftSqlType.bool,
      requiredDuringInsert: false,
      defaultConstraints:
          GeneratedColumn.constraintIsAlways('CHECK ("is_active" IN (0, 1))'),
      defaultValue: const Constant(false));
  static const VerificationMeta _createdAtMeta =
      const VerificationMeta('createdAt');
  @override
  late final GeneratedColumn<DateTime> createdAt = GeneratedColumn<DateTime>(
      'created_at', aliasedName, false,
      type: DriftSqlType.dateTime, requiredDuringInsert: true);
  static const VerificationMeta _updatedAtMeta =
      const VerificationMeta('updatedAt');
  @override
  late final GeneratedColumn<DateTime> updatedAt = GeneratedColumn<DateTime>(
      'updated_at', aliasedName, false,
      type: DriftSqlType.dateTime, requiredDuringInsert: true);
  @override
  List<GeneratedColumn> get $columns =>
      [id, name, format, isActive, createdAt, updatedAt];
  @override
  String get aliasedName => _alias ?? actualTableName;
  @override
  String get actualTableName => $name;
  static const String $name = 'decks';
  @override
  VerificationContext validateIntegrity(Insertable<Deck> instance,
      {bool isInserting = false}) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id')) {
      context.handle(_idMeta, id.isAcceptableOrUnknown(data['id']!, _idMeta));
    } else if (isInserting) {
      context.missing(_idMeta);
    }
    if (data.containsKey('name')) {
      context.handle(
          _nameMeta, name.isAcceptableOrUnknown(data['name']!, _nameMeta));
    } else if (isInserting) {
      context.missing(_nameMeta);
    }
    if (data.containsKey('format')) {
      context.handle(_formatMeta,
          format.isAcceptableOrUnknown(data['format']!, _formatMeta));
    } else if (isInserting) {
      context.missing(_formatMeta);
    }
    if (data.containsKey('is_active')) {
      context.handle(_isActiveMeta,
          isActive.isAcceptableOrUnknown(data['is_active']!, _isActiveMeta));
    }
    if (data.containsKey('created_at')) {
      context.handle(_createdAtMeta,
          createdAt.isAcceptableOrUnknown(data['created_at']!, _createdAtMeta));
    } else if (isInserting) {
      context.missing(_createdAtMeta);
    }
    if (data.containsKey('updated_at')) {
      context.handle(_updatedAtMeta,
          updatedAt.isAcceptableOrUnknown(data['updated_at']!, _updatedAtMeta));
    } else if (isInserting) {
      context.missing(_updatedAtMeta);
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {id};
  @override
  Deck map(Map<String, dynamic> data, {String? tablePrefix}) {
    final effectivePrefix = tablePrefix != null ? '$tablePrefix.' : '';
    return Deck(
      id: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}id'])!,
      name: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}name'])!,
      format: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}format'])!,
      isActive: attachedDatabase.typeMapping
          .read(DriftSqlType.bool, data['${effectivePrefix}is_active'])!,
      createdAt: attachedDatabase.typeMapping
          .read(DriftSqlType.dateTime, data['${effectivePrefix}created_at'])!,
      updatedAt: attachedDatabase.typeMapping
          .read(DriftSqlType.dateTime, data['${effectivePrefix}updated_at'])!,
    );
  }

  @override
  $DecksTable createAlias(String alias) {
    return $DecksTable(attachedDatabase, alias);
  }
}

class Deck extends DataClass implements Insertable<Deck> {
  final String id;
  final String name;

  /// Commander | Standard | Pauper | Modern | Other
  final String format;

  /// Apenas 1 deck ativo por vez (reserva de cartas da coleção).
  final bool isActive;
  final DateTime createdAt;
  final DateTime updatedAt;
  const Deck(
      {required this.id,
      required this.name,
      required this.format,
      required this.isActive,
      required this.createdAt,
      required this.updatedAt});
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    map['id'] = Variable<String>(id);
    map['name'] = Variable<String>(name);
    map['format'] = Variable<String>(format);
    map['is_active'] = Variable<bool>(isActive);
    map['created_at'] = Variable<DateTime>(createdAt);
    map['updated_at'] = Variable<DateTime>(updatedAt);
    return map;
  }

  DecksCompanion toCompanion(bool nullToAbsent) {
    return DecksCompanion(
      id: Value(id),
      name: Value(name),
      format: Value(format),
      isActive: Value(isActive),
      createdAt: Value(createdAt),
      updatedAt: Value(updatedAt),
    );
  }

  factory Deck.fromJson(Map<String, dynamic> json,
      {ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return Deck(
      id: serializer.fromJson<String>(json['id']),
      name: serializer.fromJson<String>(json['name']),
      format: serializer.fromJson<String>(json['format']),
      isActive: serializer.fromJson<bool>(json['isActive']),
      createdAt: serializer.fromJson<DateTime>(json['createdAt']),
      updatedAt: serializer.fromJson<DateTime>(json['updatedAt']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'id': serializer.toJson<String>(id),
      'name': serializer.toJson<String>(name),
      'format': serializer.toJson<String>(format),
      'isActive': serializer.toJson<bool>(isActive),
      'createdAt': serializer.toJson<DateTime>(createdAt),
      'updatedAt': serializer.toJson<DateTime>(updatedAt),
    };
  }

  Deck copyWith(
          {String? id,
          String? name,
          String? format,
          bool? isActive,
          DateTime? createdAt,
          DateTime? updatedAt}) =>
      Deck(
        id: id ?? this.id,
        name: name ?? this.name,
        format: format ?? this.format,
        isActive: isActive ?? this.isActive,
        createdAt: createdAt ?? this.createdAt,
        updatedAt: updatedAt ?? this.updatedAt,
      );
  Deck copyWithCompanion(DecksCompanion data) {
    return Deck(
      id: data.id.present ? data.id.value : this.id,
      name: data.name.present ? data.name.value : this.name,
      format: data.format.present ? data.format.value : this.format,
      isActive: data.isActive.present ? data.isActive.value : this.isActive,
      createdAt: data.createdAt.present ? data.createdAt.value : this.createdAt,
      updatedAt: data.updatedAt.present ? data.updatedAt.value : this.updatedAt,
    );
  }

  @override
  String toString() {
    return (StringBuffer('Deck(')
          ..write('id: $id, ')
          ..write('name: $name, ')
          ..write('format: $format, ')
          ..write('isActive: $isActive, ')
          ..write('createdAt: $createdAt, ')
          ..write('updatedAt: $updatedAt')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode =>
      Object.hash(id, name, format, isActive, createdAt, updatedAt);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is Deck &&
          other.id == this.id &&
          other.name == this.name &&
          other.format == this.format &&
          other.isActive == this.isActive &&
          other.createdAt == this.createdAt &&
          other.updatedAt == this.updatedAt);
}

class DecksCompanion extends UpdateCompanion<Deck> {
  final Value<String> id;
  final Value<String> name;
  final Value<String> format;
  final Value<bool> isActive;
  final Value<DateTime> createdAt;
  final Value<DateTime> updatedAt;
  final Value<int> rowid;
  const DecksCompanion({
    this.id = const Value.absent(),
    this.name = const Value.absent(),
    this.format = const Value.absent(),
    this.isActive = const Value.absent(),
    this.createdAt = const Value.absent(),
    this.updatedAt = const Value.absent(),
    this.rowid = const Value.absent(),
  });
  DecksCompanion.insert({
    required String id,
    required String name,
    required String format,
    this.isActive = const Value.absent(),
    required DateTime createdAt,
    required DateTime updatedAt,
    this.rowid = const Value.absent(),
  })  : id = Value(id),
        name = Value(name),
        format = Value(format),
        createdAt = Value(createdAt),
        updatedAt = Value(updatedAt);
  static Insertable<Deck> custom({
    Expression<String>? id,
    Expression<String>? name,
    Expression<String>? format,
    Expression<bool>? isActive,
    Expression<DateTime>? createdAt,
    Expression<DateTime>? updatedAt,
    Expression<int>? rowid,
  }) {
    return RawValuesInsertable({
      if (id != null) 'id': id,
      if (name != null) 'name': name,
      if (format != null) 'format': format,
      if (isActive != null) 'is_active': isActive,
      if (createdAt != null) 'created_at': createdAt,
      if (updatedAt != null) 'updated_at': updatedAt,
      if (rowid != null) 'rowid': rowid,
    });
  }

  DecksCompanion copyWith(
      {Value<String>? id,
      Value<String>? name,
      Value<String>? format,
      Value<bool>? isActive,
      Value<DateTime>? createdAt,
      Value<DateTime>? updatedAt,
      Value<int>? rowid}) {
    return DecksCompanion(
      id: id ?? this.id,
      name: name ?? this.name,
      format: format ?? this.format,
      isActive: isActive ?? this.isActive,
      createdAt: createdAt ?? this.createdAt,
      updatedAt: updatedAt ?? this.updatedAt,
      rowid: rowid ?? this.rowid,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (id.present) {
      map['id'] = Variable<String>(id.value);
    }
    if (name.present) {
      map['name'] = Variable<String>(name.value);
    }
    if (format.present) {
      map['format'] = Variable<String>(format.value);
    }
    if (isActive.present) {
      map['is_active'] = Variable<bool>(isActive.value);
    }
    if (createdAt.present) {
      map['created_at'] = Variable<DateTime>(createdAt.value);
    }
    if (updatedAt.present) {
      map['updated_at'] = Variable<DateTime>(updatedAt.value);
    }
    if (rowid.present) {
      map['rowid'] = Variable<int>(rowid.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('DecksCompanion(')
          ..write('id: $id, ')
          ..write('name: $name, ')
          ..write('format: $format, ')
          ..write('isActive: $isActive, ')
          ..write('createdAt: $createdAt, ')
          ..write('updatedAt: $updatedAt, ')
          ..write('rowid: $rowid')
          ..write(')'))
        .toString();
  }
}

class $DeckEntriesTable extends DeckEntries
    with TableInfo<$DeckEntriesTable, DeckEntry> {
  @override
  final GeneratedDatabase attachedDatabase;
  final String? _alias;
  $DeckEntriesTable(this.attachedDatabase, [this._alias]);
  static const VerificationMeta _idMeta = const VerificationMeta('id');
  @override
  late final GeneratedColumn<String> id = GeneratedColumn<String>(
      'id', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _deckIdMeta = const VerificationMeta('deckId');
  @override
  late final GeneratedColumn<String> deckId = GeneratedColumn<String>(
      'deck_id', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _oracleIdMeta =
      const VerificationMeta('oracleId');
  @override
  late final GeneratedColumn<String> oracleId = GeneratedColumn<String>(
      'oracle_id', aliasedName, false,
      type: DriftSqlType.string, requiredDuringInsert: true);
  static const VerificationMeta _preferredPrintingIdMeta =
      const VerificationMeta('preferredPrintingId');
  @override
  late final GeneratedColumn<String> preferredPrintingId =
      GeneratedColumn<String>('preferred_printing_id', aliasedName, true,
          type: DriftSqlType.string, requiredDuringInsert: false);
  static const VerificationMeta _collectionItemIdMeta =
      const VerificationMeta('collectionItemId');
  @override
  late final GeneratedColumn<String> collectionItemId = GeneratedColumn<String>(
      'collection_item_id', aliasedName, true,
      type: DriftSqlType.string, requiredDuringInsert: false);
  static const VerificationMeta _quantityMeta =
      const VerificationMeta('quantity');
  @override
  late final GeneratedColumn<int> quantity = GeneratedColumn<int>(
      'quantity', aliasedName, false,
      type: DriftSqlType.int, requiredDuringInsert: true);
  static const VerificationMeta _sectionMeta =
      const VerificationMeta('section');
  @override
  late final GeneratedColumn<String> section = GeneratedColumn<String>(
      'section', aliasedName, false,
      type: DriftSqlType.string,
      requiredDuringInsert: false,
      defaultValue: const Constant('main'));
  static const VerificationMeta _ownedStatusMeta =
      const VerificationMeta('ownedStatus');
  @override
  late final GeneratedColumn<String> ownedStatus = GeneratedColumn<String>(
      'owned_status', aliasedName, false,
      type: DriftSqlType.string,
      requiredDuringInsert: false,
      defaultValue: const Constant('notOwned'));
  static const VerificationMeta _createdAtMeta =
      const VerificationMeta('createdAt');
  @override
  late final GeneratedColumn<DateTime> createdAt = GeneratedColumn<DateTime>(
      'created_at', aliasedName, false,
      type: DriftSqlType.dateTime, requiredDuringInsert: true);
  static const VerificationMeta _updatedAtMeta =
      const VerificationMeta('updatedAt');
  @override
  late final GeneratedColumn<DateTime> updatedAt = GeneratedColumn<DateTime>(
      'updated_at', aliasedName, false,
      type: DriftSqlType.dateTime, requiredDuringInsert: true);
  @override
  List<GeneratedColumn> get $columns => [
        id,
        deckId,
        oracleId,
        preferredPrintingId,
        collectionItemId,
        quantity,
        section,
        ownedStatus,
        createdAt,
        updatedAt
      ];
  @override
  String get aliasedName => _alias ?? actualTableName;
  @override
  String get actualTableName => $name;
  static const String $name = 'deck_entries';
  @override
  VerificationContext validateIntegrity(Insertable<DeckEntry> instance,
      {bool isInserting = false}) {
    final context = VerificationContext();
    final data = instance.toColumns(true);
    if (data.containsKey('id')) {
      context.handle(_idMeta, id.isAcceptableOrUnknown(data['id']!, _idMeta));
    } else if (isInserting) {
      context.missing(_idMeta);
    }
    if (data.containsKey('deck_id')) {
      context.handle(_deckIdMeta,
          deckId.isAcceptableOrUnknown(data['deck_id']!, _deckIdMeta));
    } else if (isInserting) {
      context.missing(_deckIdMeta);
    }
    if (data.containsKey('oracle_id')) {
      context.handle(_oracleIdMeta,
          oracleId.isAcceptableOrUnknown(data['oracle_id']!, _oracleIdMeta));
    } else if (isInserting) {
      context.missing(_oracleIdMeta);
    }
    if (data.containsKey('preferred_printing_id')) {
      context.handle(
          _preferredPrintingIdMeta,
          preferredPrintingId.isAcceptableOrUnknown(
              data['preferred_printing_id']!, _preferredPrintingIdMeta));
    }
    if (data.containsKey('collection_item_id')) {
      context.handle(
          _collectionItemIdMeta,
          collectionItemId.isAcceptableOrUnknown(
              data['collection_item_id']!, _collectionItemIdMeta));
    }
    if (data.containsKey('quantity')) {
      context.handle(_quantityMeta,
          quantity.isAcceptableOrUnknown(data['quantity']!, _quantityMeta));
    } else if (isInserting) {
      context.missing(_quantityMeta);
    }
    if (data.containsKey('section')) {
      context.handle(_sectionMeta,
          section.isAcceptableOrUnknown(data['section']!, _sectionMeta));
    }
    if (data.containsKey('owned_status')) {
      context.handle(
          _ownedStatusMeta,
          ownedStatus.isAcceptableOrUnknown(
              data['owned_status']!, _ownedStatusMeta));
    }
    if (data.containsKey('created_at')) {
      context.handle(_createdAtMeta,
          createdAt.isAcceptableOrUnknown(data['created_at']!, _createdAtMeta));
    } else if (isInserting) {
      context.missing(_createdAtMeta);
    }
    if (data.containsKey('updated_at')) {
      context.handle(_updatedAtMeta,
          updatedAt.isAcceptableOrUnknown(data['updated_at']!, _updatedAtMeta));
    } else if (isInserting) {
      context.missing(_updatedAtMeta);
    }
    return context;
  }

  @override
  Set<GeneratedColumn> get $primaryKey => {id};
  @override
  DeckEntry map(Map<String, dynamic> data, {String? tablePrefix}) {
    final effectivePrefix = tablePrefix != null ? '$tablePrefix.' : '';
    return DeckEntry(
      id: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}id'])!,
      deckId: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}deck_id'])!,
      oracleId: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}oracle_id'])!,
      preferredPrintingId: attachedDatabase.typeMapping.read(
          DriftSqlType.string, data['${effectivePrefix}preferred_printing_id']),
      collectionItemId: attachedDatabase.typeMapping.read(
          DriftSqlType.string, data['${effectivePrefix}collection_item_id']),
      quantity: attachedDatabase.typeMapping
          .read(DriftSqlType.int, data['${effectivePrefix}quantity'])!,
      section: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}section'])!,
      ownedStatus: attachedDatabase.typeMapping
          .read(DriftSqlType.string, data['${effectivePrefix}owned_status'])!,
      createdAt: attachedDatabase.typeMapping
          .read(DriftSqlType.dateTime, data['${effectivePrefix}created_at'])!,
      updatedAt: attachedDatabase.typeMapping
          .read(DriftSqlType.dateTime, data['${effectivePrefix}updated_at'])!,
    );
  }

  @override
  $DeckEntriesTable createAlias(String alias) {
    return $DeckEntriesTable(attachedDatabase, alias);
  }
}

class DeckEntry extends DataClass implements Insertable<DeckEntry> {
  final String id;
  final String deckId;
  final String oracleId;

  /// ScryfallPrintings.printingId (nullable)
  final String? preferredPrintingId;

  /// CollectionItems.id (nullable) — vínculo opcional no futuro
  final String? collectionItemId;
  final int quantity;

  /// main | sideboard | commander | maybeboard (por agora, default main)
  final String section;

  /// owned | notOwned | linkedToCollection
  final String ownedStatus;
  final DateTime createdAt;
  final DateTime updatedAt;
  const DeckEntry(
      {required this.id,
      required this.deckId,
      required this.oracleId,
      this.preferredPrintingId,
      this.collectionItemId,
      required this.quantity,
      required this.section,
      required this.ownedStatus,
      required this.createdAt,
      required this.updatedAt});
  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    map['id'] = Variable<String>(id);
    map['deck_id'] = Variable<String>(deckId);
    map['oracle_id'] = Variable<String>(oracleId);
    if (!nullToAbsent || preferredPrintingId != null) {
      map['preferred_printing_id'] = Variable<String>(preferredPrintingId);
    }
    if (!nullToAbsent || collectionItemId != null) {
      map['collection_item_id'] = Variable<String>(collectionItemId);
    }
    map['quantity'] = Variable<int>(quantity);
    map['section'] = Variable<String>(section);
    map['owned_status'] = Variable<String>(ownedStatus);
    map['created_at'] = Variable<DateTime>(createdAt);
    map['updated_at'] = Variable<DateTime>(updatedAt);
    return map;
  }

  DeckEntriesCompanion toCompanion(bool nullToAbsent) {
    return DeckEntriesCompanion(
      id: Value(id),
      deckId: Value(deckId),
      oracleId: Value(oracleId),
      preferredPrintingId: preferredPrintingId == null && nullToAbsent
          ? const Value.absent()
          : Value(preferredPrintingId),
      collectionItemId: collectionItemId == null && nullToAbsent
          ? const Value.absent()
          : Value(collectionItemId),
      quantity: Value(quantity),
      section: Value(section),
      ownedStatus: Value(ownedStatus),
      createdAt: Value(createdAt),
      updatedAt: Value(updatedAt),
    );
  }

  factory DeckEntry.fromJson(Map<String, dynamic> json,
      {ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return DeckEntry(
      id: serializer.fromJson<String>(json['id']),
      deckId: serializer.fromJson<String>(json['deckId']),
      oracleId: serializer.fromJson<String>(json['oracleId']),
      preferredPrintingId:
          serializer.fromJson<String?>(json['preferredPrintingId']),
      collectionItemId: serializer.fromJson<String?>(json['collectionItemId']),
      quantity: serializer.fromJson<int>(json['quantity']),
      section: serializer.fromJson<String>(json['section']),
      ownedStatus: serializer.fromJson<String>(json['ownedStatus']),
      createdAt: serializer.fromJson<DateTime>(json['createdAt']),
      updatedAt: serializer.fromJson<DateTime>(json['updatedAt']),
    );
  }
  @override
  Map<String, dynamic> toJson({ValueSerializer? serializer}) {
    serializer ??= driftRuntimeOptions.defaultSerializer;
    return <String, dynamic>{
      'id': serializer.toJson<String>(id),
      'deckId': serializer.toJson<String>(deckId),
      'oracleId': serializer.toJson<String>(oracleId),
      'preferredPrintingId': serializer.toJson<String?>(preferredPrintingId),
      'collectionItemId': serializer.toJson<String?>(collectionItemId),
      'quantity': serializer.toJson<int>(quantity),
      'section': serializer.toJson<String>(section),
      'ownedStatus': serializer.toJson<String>(ownedStatus),
      'createdAt': serializer.toJson<DateTime>(createdAt),
      'updatedAt': serializer.toJson<DateTime>(updatedAt),
    };
  }

  DeckEntry copyWith(
          {String? id,
          String? deckId,
          String? oracleId,
          Value<String?> preferredPrintingId = const Value.absent(),
          Value<String?> collectionItemId = const Value.absent(),
          int? quantity,
          String? section,
          String? ownedStatus,
          DateTime? createdAt,
          DateTime? updatedAt}) =>
      DeckEntry(
        id: id ?? this.id,
        deckId: deckId ?? this.deckId,
        oracleId: oracleId ?? this.oracleId,
        preferredPrintingId: preferredPrintingId.present
            ? preferredPrintingId.value
            : this.preferredPrintingId,
        collectionItemId: collectionItemId.present
            ? collectionItemId.value
            : this.collectionItemId,
        quantity: quantity ?? this.quantity,
        section: section ?? this.section,
        ownedStatus: ownedStatus ?? this.ownedStatus,
        createdAt: createdAt ?? this.createdAt,
        updatedAt: updatedAt ?? this.updatedAt,
      );
  DeckEntry copyWithCompanion(DeckEntriesCompanion data) {
    return DeckEntry(
      id: data.id.present ? data.id.value : this.id,
      deckId: data.deckId.present ? data.deckId.value : this.deckId,
      oracleId: data.oracleId.present ? data.oracleId.value : this.oracleId,
      preferredPrintingId: data.preferredPrintingId.present
          ? data.preferredPrintingId.value
          : this.preferredPrintingId,
      collectionItemId: data.collectionItemId.present
          ? data.collectionItemId.value
          : this.collectionItemId,
      quantity: data.quantity.present ? data.quantity.value : this.quantity,
      section: data.section.present ? data.section.value : this.section,
      ownedStatus:
          data.ownedStatus.present ? data.ownedStatus.value : this.ownedStatus,
      createdAt: data.createdAt.present ? data.createdAt.value : this.createdAt,
      updatedAt: data.updatedAt.present ? data.updatedAt.value : this.updatedAt,
    );
  }

  @override
  String toString() {
    return (StringBuffer('DeckEntry(')
          ..write('id: $id, ')
          ..write('deckId: $deckId, ')
          ..write('oracleId: $oracleId, ')
          ..write('preferredPrintingId: $preferredPrintingId, ')
          ..write('collectionItemId: $collectionItemId, ')
          ..write('quantity: $quantity, ')
          ..write('section: $section, ')
          ..write('ownedStatus: $ownedStatus, ')
          ..write('createdAt: $createdAt, ')
          ..write('updatedAt: $updatedAt')
          ..write(')'))
        .toString();
  }

  @override
  int get hashCode => Object.hash(id, deckId, oracleId, preferredPrintingId,
      collectionItemId, quantity, section, ownedStatus, createdAt, updatedAt);
  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      (other is DeckEntry &&
          other.id == this.id &&
          other.deckId == this.deckId &&
          other.oracleId == this.oracleId &&
          other.preferredPrintingId == this.preferredPrintingId &&
          other.collectionItemId == this.collectionItemId &&
          other.quantity == this.quantity &&
          other.section == this.section &&
          other.ownedStatus == this.ownedStatus &&
          other.createdAt == this.createdAt &&
          other.updatedAt == this.updatedAt);
}

class DeckEntriesCompanion extends UpdateCompanion<DeckEntry> {
  final Value<String> id;
  final Value<String> deckId;
  final Value<String> oracleId;
  final Value<String?> preferredPrintingId;
  final Value<String?> collectionItemId;
  final Value<int> quantity;
  final Value<String> section;
  final Value<String> ownedStatus;
  final Value<DateTime> createdAt;
  final Value<DateTime> updatedAt;
  final Value<int> rowid;
  const DeckEntriesCompanion({
    this.id = const Value.absent(),
    this.deckId = const Value.absent(),
    this.oracleId = const Value.absent(),
    this.preferredPrintingId = const Value.absent(),
    this.collectionItemId = const Value.absent(),
    this.quantity = const Value.absent(),
    this.section = const Value.absent(),
    this.ownedStatus = const Value.absent(),
    this.createdAt = const Value.absent(),
    this.updatedAt = const Value.absent(),
    this.rowid = const Value.absent(),
  });
  DeckEntriesCompanion.insert({
    required String id,
    required String deckId,
    required String oracleId,
    this.preferredPrintingId = const Value.absent(),
    this.collectionItemId = const Value.absent(),
    required int quantity,
    this.section = const Value.absent(),
    this.ownedStatus = const Value.absent(),
    required DateTime createdAt,
    required DateTime updatedAt,
    this.rowid = const Value.absent(),
  })  : id = Value(id),
        deckId = Value(deckId),
        oracleId = Value(oracleId),
        quantity = Value(quantity),
        createdAt = Value(createdAt),
        updatedAt = Value(updatedAt);
  static Insertable<DeckEntry> custom({
    Expression<String>? id,
    Expression<String>? deckId,
    Expression<String>? oracleId,
    Expression<String>? preferredPrintingId,
    Expression<String>? collectionItemId,
    Expression<int>? quantity,
    Expression<String>? section,
    Expression<String>? ownedStatus,
    Expression<DateTime>? createdAt,
    Expression<DateTime>? updatedAt,
    Expression<int>? rowid,
  }) {
    return RawValuesInsertable({
      if (id != null) 'id': id,
      if (deckId != null) 'deck_id': deckId,
      if (oracleId != null) 'oracle_id': oracleId,
      if (preferredPrintingId != null)
        'preferred_printing_id': preferredPrintingId,
      if (collectionItemId != null) 'collection_item_id': collectionItemId,
      if (quantity != null) 'quantity': quantity,
      if (section != null) 'section': section,
      if (ownedStatus != null) 'owned_status': ownedStatus,
      if (createdAt != null) 'created_at': createdAt,
      if (updatedAt != null) 'updated_at': updatedAt,
      if (rowid != null) 'rowid': rowid,
    });
  }

  DeckEntriesCompanion copyWith(
      {Value<String>? id,
      Value<String>? deckId,
      Value<String>? oracleId,
      Value<String?>? preferredPrintingId,
      Value<String?>? collectionItemId,
      Value<int>? quantity,
      Value<String>? section,
      Value<String>? ownedStatus,
      Value<DateTime>? createdAt,
      Value<DateTime>? updatedAt,
      Value<int>? rowid}) {
    return DeckEntriesCompanion(
      id: id ?? this.id,
      deckId: deckId ?? this.deckId,
      oracleId: oracleId ?? this.oracleId,
      preferredPrintingId: preferredPrintingId ?? this.preferredPrintingId,
      collectionItemId: collectionItemId ?? this.collectionItemId,
      quantity: quantity ?? this.quantity,
      section: section ?? this.section,
      ownedStatus: ownedStatus ?? this.ownedStatus,
      createdAt: createdAt ?? this.createdAt,
      updatedAt: updatedAt ?? this.updatedAt,
      rowid: rowid ?? this.rowid,
    );
  }

  @override
  Map<String, Expression> toColumns(bool nullToAbsent) {
    final map = <String, Expression>{};
    if (id.present) {
      map['id'] = Variable<String>(id.value);
    }
    if (deckId.present) {
      map['deck_id'] = Variable<String>(deckId.value);
    }
    if (oracleId.present) {
      map['oracle_id'] = Variable<String>(oracleId.value);
    }
    if (preferredPrintingId.present) {
      map['preferred_printing_id'] =
          Variable<String>(preferredPrintingId.value);
    }
    if (collectionItemId.present) {
      map['collection_item_id'] = Variable<String>(collectionItemId.value);
    }
    if (quantity.present) {
      map['quantity'] = Variable<int>(quantity.value);
    }
    if (section.present) {
      map['section'] = Variable<String>(section.value);
    }
    if (ownedStatus.present) {
      map['owned_status'] = Variable<String>(ownedStatus.value);
    }
    if (createdAt.present) {
      map['created_at'] = Variable<DateTime>(createdAt.value);
    }
    if (updatedAt.present) {
      map['updated_at'] = Variable<DateTime>(updatedAt.value);
    }
    if (rowid.present) {
      map['rowid'] = Variable<int>(rowid.value);
    }
    return map;
  }

  @override
  String toString() {
    return (StringBuffer('DeckEntriesCompanion(')
          ..write('id: $id, ')
          ..write('deckId: $deckId, ')
          ..write('oracleId: $oracleId, ')
          ..write('preferredPrintingId: $preferredPrintingId, ')
          ..write('collectionItemId: $collectionItemId, ')
          ..write('quantity: $quantity, ')
          ..write('section: $section, ')
          ..write('ownedStatus: $ownedStatus, ')
          ..write('createdAt: $createdAt, ')
          ..write('updatedAt: $updatedAt, ')
          ..write('rowid: $rowid')
          ..write(')'))
        .toString();
  }
}

abstract class _$AppDatabase extends GeneratedDatabase {
  _$AppDatabase(QueryExecutor e) : super(e);
  $AppDatabaseManager get managers => $AppDatabaseManager(this);
  late final $ScryfallPrintingsTable scryfallPrintings =
      $ScryfallPrintingsTable(this);
  late final $PriceSnapshotsTable priceSnapshots = $PriceSnapshotsTable(this);
  late final $CollectionsTable collections = $CollectionsTable(this);
  late final $CollectionItemsTable collectionItems =
      $CollectionItemsTable(this);
  late final $DecksTable decks = $DecksTable(this);
  late final $DeckEntriesTable deckEntries = $DeckEntriesTable(this);
  late final ScryfallCacheDao scryfallCacheDao =
      ScryfallCacheDao(this as AppDatabase);
  late final CollectionDao collectionDao = CollectionDao(this as AppDatabase);
  late final DecksDao decksDao = DecksDao(this as AppDatabase);
  late final DeckEntriesDao deckEntriesDao =
      DeckEntriesDao(this as AppDatabase);
  @override
  Iterable<TableInfo<Table, Object?>> get allTables =>
      allSchemaEntities.whereType<TableInfo<Table, Object?>>();
  @override
  List<DatabaseSchemaEntity> get allSchemaEntities => [
        scryfallPrintings,
        priceSnapshots,
        collections,
        collectionItems,
        decks,
        deckEntries
      ];
}

typedef $$ScryfallPrintingsTableCreateCompanionBuilder
    = ScryfallPrintingsCompanion Function({
  required String printingId,
  required String oracleId,
  required String name,
  required String typeLine,
  required String setCode,
  required String setName,
  required String collectorNumber,
  Value<DateTime?> releasedAt,
  Value<String?> manaCost,
  Value<double?> manaValue,
  Value<String?> rarity,
  Value<String?> imageSmall,
  Value<String?> imageNormal,
  Value<String?> imagePng,
  Value<String?> legalitiesJson,
  required DateTime updatedAtCache,
  Value<int> rowid,
});
typedef $$ScryfallPrintingsTableUpdateCompanionBuilder
    = ScryfallPrintingsCompanion Function({
  Value<String> printingId,
  Value<String> oracleId,
  Value<String> name,
  Value<String> typeLine,
  Value<String> setCode,
  Value<String> setName,
  Value<String> collectorNumber,
  Value<DateTime?> releasedAt,
  Value<String?> manaCost,
  Value<double?> manaValue,
  Value<String?> rarity,
  Value<String?> imageSmall,
  Value<String?> imageNormal,
  Value<String?> imagePng,
  Value<String?> legalitiesJson,
  Value<DateTime> updatedAtCache,
  Value<int> rowid,
});

class $$ScryfallPrintingsTableFilterComposer
    extends Composer<_$AppDatabase, $ScryfallPrintingsTable> {
  $$ScryfallPrintingsTableFilterComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnFilters<String> get printingId => $composableBuilder(
      column: $table.printingId, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get oracleId => $composableBuilder(
      column: $table.oracleId, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get name => $composableBuilder(
      column: $table.name, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get typeLine => $composableBuilder(
      column: $table.typeLine, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get setCode => $composableBuilder(
      column: $table.setCode, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get setName => $composableBuilder(
      column: $table.setName, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get collectorNumber => $composableBuilder(
      column: $table.collectorNumber,
      builder: (column) => ColumnFilters(column));

  ColumnFilters<DateTime> get releasedAt => $composableBuilder(
      column: $table.releasedAt, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get manaCost => $composableBuilder(
      column: $table.manaCost, builder: (column) => ColumnFilters(column));

  ColumnFilters<double> get manaValue => $composableBuilder(
      column: $table.manaValue, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get rarity => $composableBuilder(
      column: $table.rarity, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get imageSmall => $composableBuilder(
      column: $table.imageSmall, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get imageNormal => $composableBuilder(
      column: $table.imageNormal, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get imagePng => $composableBuilder(
      column: $table.imagePng, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get legalitiesJson => $composableBuilder(
      column: $table.legalitiesJson,
      builder: (column) => ColumnFilters(column));

  ColumnFilters<DateTime> get updatedAtCache => $composableBuilder(
      column: $table.updatedAtCache,
      builder: (column) => ColumnFilters(column));
}

class $$ScryfallPrintingsTableOrderingComposer
    extends Composer<_$AppDatabase, $ScryfallPrintingsTable> {
  $$ScryfallPrintingsTableOrderingComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnOrderings<String> get printingId => $composableBuilder(
      column: $table.printingId, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get oracleId => $composableBuilder(
      column: $table.oracleId, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get name => $composableBuilder(
      column: $table.name, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get typeLine => $composableBuilder(
      column: $table.typeLine, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get setCode => $composableBuilder(
      column: $table.setCode, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get setName => $composableBuilder(
      column: $table.setName, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get collectorNumber => $composableBuilder(
      column: $table.collectorNumber,
      builder: (column) => ColumnOrderings(column));

  ColumnOrderings<DateTime> get releasedAt => $composableBuilder(
      column: $table.releasedAt, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get manaCost => $composableBuilder(
      column: $table.manaCost, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<double> get manaValue => $composableBuilder(
      column: $table.manaValue, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get rarity => $composableBuilder(
      column: $table.rarity, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get imageSmall => $composableBuilder(
      column: $table.imageSmall, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get imageNormal => $composableBuilder(
      column: $table.imageNormal, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get imagePng => $composableBuilder(
      column: $table.imagePng, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get legalitiesJson => $composableBuilder(
      column: $table.legalitiesJson,
      builder: (column) => ColumnOrderings(column));

  ColumnOrderings<DateTime> get updatedAtCache => $composableBuilder(
      column: $table.updatedAtCache,
      builder: (column) => ColumnOrderings(column));
}

class $$ScryfallPrintingsTableAnnotationComposer
    extends Composer<_$AppDatabase, $ScryfallPrintingsTable> {
  $$ScryfallPrintingsTableAnnotationComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  GeneratedColumn<String> get printingId => $composableBuilder(
      column: $table.printingId, builder: (column) => column);

  GeneratedColumn<String> get oracleId =>
      $composableBuilder(column: $table.oracleId, builder: (column) => column);

  GeneratedColumn<String> get name =>
      $composableBuilder(column: $table.name, builder: (column) => column);

  GeneratedColumn<String> get typeLine =>
      $composableBuilder(column: $table.typeLine, builder: (column) => column);

  GeneratedColumn<String> get setCode =>
      $composableBuilder(column: $table.setCode, builder: (column) => column);

  GeneratedColumn<String> get setName =>
      $composableBuilder(column: $table.setName, builder: (column) => column);

  GeneratedColumn<String> get collectorNumber => $composableBuilder(
      column: $table.collectorNumber, builder: (column) => column);

  GeneratedColumn<DateTime> get releasedAt => $composableBuilder(
      column: $table.releasedAt, builder: (column) => column);

  GeneratedColumn<String> get manaCost =>
      $composableBuilder(column: $table.manaCost, builder: (column) => column);

  GeneratedColumn<double> get manaValue =>
      $composableBuilder(column: $table.manaValue, builder: (column) => column);

  GeneratedColumn<String> get rarity =>
      $composableBuilder(column: $table.rarity, builder: (column) => column);

  GeneratedColumn<String> get imageSmall => $composableBuilder(
      column: $table.imageSmall, builder: (column) => column);

  GeneratedColumn<String> get imageNormal => $composableBuilder(
      column: $table.imageNormal, builder: (column) => column);

  GeneratedColumn<String> get imagePng =>
      $composableBuilder(column: $table.imagePng, builder: (column) => column);

  GeneratedColumn<String> get legalitiesJson => $composableBuilder(
      column: $table.legalitiesJson, builder: (column) => column);

  GeneratedColumn<DateTime> get updatedAtCache => $composableBuilder(
      column: $table.updatedAtCache, builder: (column) => column);
}

class $$ScryfallPrintingsTableTableManager extends RootTableManager<
    _$AppDatabase,
    $ScryfallPrintingsTable,
    ScryfallPrinting,
    $$ScryfallPrintingsTableFilterComposer,
    $$ScryfallPrintingsTableOrderingComposer,
    $$ScryfallPrintingsTableAnnotationComposer,
    $$ScryfallPrintingsTableCreateCompanionBuilder,
    $$ScryfallPrintingsTableUpdateCompanionBuilder,
    (
      ScryfallPrinting,
      BaseReferences<_$AppDatabase, $ScryfallPrintingsTable, ScryfallPrinting>
    ),
    ScryfallPrinting,
    PrefetchHooks Function()> {
  $$ScryfallPrintingsTableTableManager(
      _$AppDatabase db, $ScryfallPrintingsTable table)
      : super(TableManagerState(
          db: db,
          table: table,
          createFilteringComposer: () =>
              $$ScryfallPrintingsTableFilterComposer($db: db, $table: table),
          createOrderingComposer: () =>
              $$ScryfallPrintingsTableOrderingComposer($db: db, $table: table),
          createComputedFieldComposer: () =>
              $$ScryfallPrintingsTableAnnotationComposer(
                  $db: db, $table: table),
          updateCompanionCallback: ({
            Value<String> printingId = const Value.absent(),
            Value<String> oracleId = const Value.absent(),
            Value<String> name = const Value.absent(),
            Value<String> typeLine = const Value.absent(),
            Value<String> setCode = const Value.absent(),
            Value<String> setName = const Value.absent(),
            Value<String> collectorNumber = const Value.absent(),
            Value<DateTime?> releasedAt = const Value.absent(),
            Value<String?> manaCost = const Value.absent(),
            Value<double?> manaValue = const Value.absent(),
            Value<String?> rarity = const Value.absent(),
            Value<String?> imageSmall = const Value.absent(),
            Value<String?> imageNormal = const Value.absent(),
            Value<String?> imagePng = const Value.absent(),
            Value<String?> legalitiesJson = const Value.absent(),
            Value<DateTime> updatedAtCache = const Value.absent(),
            Value<int> rowid = const Value.absent(),
          }) =>
              ScryfallPrintingsCompanion(
            printingId: printingId,
            oracleId: oracleId,
            name: name,
            typeLine: typeLine,
            setCode: setCode,
            setName: setName,
            collectorNumber: collectorNumber,
            releasedAt: releasedAt,
            manaCost: manaCost,
            manaValue: manaValue,
            rarity: rarity,
            imageSmall: imageSmall,
            imageNormal: imageNormal,
            imagePng: imagePng,
            legalitiesJson: legalitiesJson,
            updatedAtCache: updatedAtCache,
            rowid: rowid,
          ),
          createCompanionCallback: ({
            required String printingId,
            required String oracleId,
            required String name,
            required String typeLine,
            required String setCode,
            required String setName,
            required String collectorNumber,
            Value<DateTime?> releasedAt = const Value.absent(),
            Value<String?> manaCost = const Value.absent(),
            Value<double?> manaValue = const Value.absent(),
            Value<String?> rarity = const Value.absent(),
            Value<String?> imageSmall = const Value.absent(),
            Value<String?> imageNormal = const Value.absent(),
            Value<String?> imagePng = const Value.absent(),
            Value<String?> legalitiesJson = const Value.absent(),
            required DateTime updatedAtCache,
            Value<int> rowid = const Value.absent(),
          }) =>
              ScryfallPrintingsCompanion.insert(
            printingId: printingId,
            oracleId: oracleId,
            name: name,
            typeLine: typeLine,
            setCode: setCode,
            setName: setName,
            collectorNumber: collectorNumber,
            releasedAt: releasedAt,
            manaCost: manaCost,
            manaValue: manaValue,
            rarity: rarity,
            imageSmall: imageSmall,
            imageNormal: imageNormal,
            imagePng: imagePng,
            legalitiesJson: legalitiesJson,
            updatedAtCache: updatedAtCache,
            rowid: rowid,
          ),
          withReferenceMapper: (p0) => p0
              .map((e) => (e.readTable(table), BaseReferences(db, table, e)))
              .toList(),
          prefetchHooksCallback: null,
        ));
}

typedef $$ScryfallPrintingsTableProcessedTableManager = ProcessedTableManager<
    _$AppDatabase,
    $ScryfallPrintingsTable,
    ScryfallPrinting,
    $$ScryfallPrintingsTableFilterComposer,
    $$ScryfallPrintingsTableOrderingComposer,
    $$ScryfallPrintingsTableAnnotationComposer,
    $$ScryfallPrintingsTableCreateCompanionBuilder,
    $$ScryfallPrintingsTableUpdateCompanionBuilder,
    (
      ScryfallPrinting,
      BaseReferences<_$AppDatabase, $ScryfallPrintingsTable, ScryfallPrinting>
    ),
    ScryfallPrinting,
    PrefetchHooks Function()>;
typedef $$PriceSnapshotsTableCreateCompanionBuilder = PriceSnapshotsCompanion
    Function({
  required String id,
  required String printingId,
  required String source,
  required String currency,
  required int valueMinor,
  required DateTime retrievedAt,
  Value<int> rowid,
});
typedef $$PriceSnapshotsTableUpdateCompanionBuilder = PriceSnapshotsCompanion
    Function({
  Value<String> id,
  Value<String> printingId,
  Value<String> source,
  Value<String> currency,
  Value<int> valueMinor,
  Value<DateTime> retrievedAt,
  Value<int> rowid,
});

class $$PriceSnapshotsTableFilterComposer
    extends Composer<_$AppDatabase, $PriceSnapshotsTable> {
  $$PriceSnapshotsTableFilterComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnFilters<String> get id => $composableBuilder(
      column: $table.id, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get printingId => $composableBuilder(
      column: $table.printingId, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get source => $composableBuilder(
      column: $table.source, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get currency => $composableBuilder(
      column: $table.currency, builder: (column) => ColumnFilters(column));

  ColumnFilters<int> get valueMinor => $composableBuilder(
      column: $table.valueMinor, builder: (column) => ColumnFilters(column));

  ColumnFilters<DateTime> get retrievedAt => $composableBuilder(
      column: $table.retrievedAt, builder: (column) => ColumnFilters(column));
}

class $$PriceSnapshotsTableOrderingComposer
    extends Composer<_$AppDatabase, $PriceSnapshotsTable> {
  $$PriceSnapshotsTableOrderingComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnOrderings<String> get id => $composableBuilder(
      column: $table.id, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get printingId => $composableBuilder(
      column: $table.printingId, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get source => $composableBuilder(
      column: $table.source, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get currency => $composableBuilder(
      column: $table.currency, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<int> get valueMinor => $composableBuilder(
      column: $table.valueMinor, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<DateTime> get retrievedAt => $composableBuilder(
      column: $table.retrievedAt, builder: (column) => ColumnOrderings(column));
}

class $$PriceSnapshotsTableAnnotationComposer
    extends Composer<_$AppDatabase, $PriceSnapshotsTable> {
  $$PriceSnapshotsTableAnnotationComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  GeneratedColumn<String> get id =>
      $composableBuilder(column: $table.id, builder: (column) => column);

  GeneratedColumn<String> get printingId => $composableBuilder(
      column: $table.printingId, builder: (column) => column);

  GeneratedColumn<String> get source =>
      $composableBuilder(column: $table.source, builder: (column) => column);

  GeneratedColumn<String> get currency =>
      $composableBuilder(column: $table.currency, builder: (column) => column);

  GeneratedColumn<int> get valueMinor => $composableBuilder(
      column: $table.valueMinor, builder: (column) => column);

  GeneratedColumn<DateTime> get retrievedAt => $composableBuilder(
      column: $table.retrievedAt, builder: (column) => column);
}

class $$PriceSnapshotsTableTableManager extends RootTableManager<
    _$AppDatabase,
    $PriceSnapshotsTable,
    PriceSnapshot,
    $$PriceSnapshotsTableFilterComposer,
    $$PriceSnapshotsTableOrderingComposer,
    $$PriceSnapshotsTableAnnotationComposer,
    $$PriceSnapshotsTableCreateCompanionBuilder,
    $$PriceSnapshotsTableUpdateCompanionBuilder,
    (
      PriceSnapshot,
      BaseReferences<_$AppDatabase, $PriceSnapshotsTable, PriceSnapshot>
    ),
    PriceSnapshot,
    PrefetchHooks Function()> {
  $$PriceSnapshotsTableTableManager(
      _$AppDatabase db, $PriceSnapshotsTable table)
      : super(TableManagerState(
          db: db,
          table: table,
          createFilteringComposer: () =>
              $$PriceSnapshotsTableFilterComposer($db: db, $table: table),
          createOrderingComposer: () =>
              $$PriceSnapshotsTableOrderingComposer($db: db, $table: table),
          createComputedFieldComposer: () =>
              $$PriceSnapshotsTableAnnotationComposer($db: db, $table: table),
          updateCompanionCallback: ({
            Value<String> id = const Value.absent(),
            Value<String> printingId = const Value.absent(),
            Value<String> source = const Value.absent(),
            Value<String> currency = const Value.absent(),
            Value<int> valueMinor = const Value.absent(),
            Value<DateTime> retrievedAt = const Value.absent(),
            Value<int> rowid = const Value.absent(),
          }) =>
              PriceSnapshotsCompanion(
            id: id,
            printingId: printingId,
            source: source,
            currency: currency,
            valueMinor: valueMinor,
            retrievedAt: retrievedAt,
            rowid: rowid,
          ),
          createCompanionCallback: ({
            required String id,
            required String printingId,
            required String source,
            required String currency,
            required int valueMinor,
            required DateTime retrievedAt,
            Value<int> rowid = const Value.absent(),
          }) =>
              PriceSnapshotsCompanion.insert(
            id: id,
            printingId: printingId,
            source: source,
            currency: currency,
            valueMinor: valueMinor,
            retrievedAt: retrievedAt,
            rowid: rowid,
          ),
          withReferenceMapper: (p0) => p0
              .map((e) => (e.readTable(table), BaseReferences(db, table, e)))
              .toList(),
          prefetchHooksCallback: null,
        ));
}

typedef $$PriceSnapshotsTableProcessedTableManager = ProcessedTableManager<
    _$AppDatabase,
    $PriceSnapshotsTable,
    PriceSnapshot,
    $$PriceSnapshotsTableFilterComposer,
    $$PriceSnapshotsTableOrderingComposer,
    $$PriceSnapshotsTableAnnotationComposer,
    $$PriceSnapshotsTableCreateCompanionBuilder,
    $$PriceSnapshotsTableUpdateCompanionBuilder,
    (
      PriceSnapshot,
      BaseReferences<_$AppDatabase, $PriceSnapshotsTable, PriceSnapshot>
    ),
    PriceSnapshot,
    PrefetchHooks Function()>;
typedef $$CollectionsTableCreateCompanionBuilder = CollectionsCompanion
    Function({
  required String id,
  required String name,
  required DateTime createdAt,
  required DateTime updatedAt,
  Value<int> rowid,
});
typedef $$CollectionsTableUpdateCompanionBuilder = CollectionsCompanion
    Function({
  Value<String> id,
  Value<String> name,
  Value<DateTime> createdAt,
  Value<DateTime> updatedAt,
  Value<int> rowid,
});

class $$CollectionsTableFilterComposer
    extends Composer<_$AppDatabase, $CollectionsTable> {
  $$CollectionsTableFilterComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnFilters<String> get id => $composableBuilder(
      column: $table.id, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get name => $composableBuilder(
      column: $table.name, builder: (column) => ColumnFilters(column));

  ColumnFilters<DateTime> get createdAt => $composableBuilder(
      column: $table.createdAt, builder: (column) => ColumnFilters(column));

  ColumnFilters<DateTime> get updatedAt => $composableBuilder(
      column: $table.updatedAt, builder: (column) => ColumnFilters(column));
}

class $$CollectionsTableOrderingComposer
    extends Composer<_$AppDatabase, $CollectionsTable> {
  $$CollectionsTableOrderingComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnOrderings<String> get id => $composableBuilder(
      column: $table.id, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get name => $composableBuilder(
      column: $table.name, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<DateTime> get createdAt => $composableBuilder(
      column: $table.createdAt, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<DateTime> get updatedAt => $composableBuilder(
      column: $table.updatedAt, builder: (column) => ColumnOrderings(column));
}

class $$CollectionsTableAnnotationComposer
    extends Composer<_$AppDatabase, $CollectionsTable> {
  $$CollectionsTableAnnotationComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  GeneratedColumn<String> get id =>
      $composableBuilder(column: $table.id, builder: (column) => column);

  GeneratedColumn<String> get name =>
      $composableBuilder(column: $table.name, builder: (column) => column);

  GeneratedColumn<DateTime> get createdAt =>
      $composableBuilder(column: $table.createdAt, builder: (column) => column);

  GeneratedColumn<DateTime> get updatedAt =>
      $composableBuilder(column: $table.updatedAt, builder: (column) => column);
}

class $$CollectionsTableTableManager extends RootTableManager<
    _$AppDatabase,
    $CollectionsTable,
    Collection,
    $$CollectionsTableFilterComposer,
    $$CollectionsTableOrderingComposer,
    $$CollectionsTableAnnotationComposer,
    $$CollectionsTableCreateCompanionBuilder,
    $$CollectionsTableUpdateCompanionBuilder,
    (Collection, BaseReferences<_$AppDatabase, $CollectionsTable, Collection>),
    Collection,
    PrefetchHooks Function()> {
  $$CollectionsTableTableManager(_$AppDatabase db, $CollectionsTable table)
      : super(TableManagerState(
          db: db,
          table: table,
          createFilteringComposer: () =>
              $$CollectionsTableFilterComposer($db: db, $table: table),
          createOrderingComposer: () =>
              $$CollectionsTableOrderingComposer($db: db, $table: table),
          createComputedFieldComposer: () =>
              $$CollectionsTableAnnotationComposer($db: db, $table: table),
          updateCompanionCallback: ({
            Value<String> id = const Value.absent(),
            Value<String> name = const Value.absent(),
            Value<DateTime> createdAt = const Value.absent(),
            Value<DateTime> updatedAt = const Value.absent(),
            Value<int> rowid = const Value.absent(),
          }) =>
              CollectionsCompanion(
            id: id,
            name: name,
            createdAt: createdAt,
            updatedAt: updatedAt,
            rowid: rowid,
          ),
          createCompanionCallback: ({
            required String id,
            required String name,
            required DateTime createdAt,
            required DateTime updatedAt,
            Value<int> rowid = const Value.absent(),
          }) =>
              CollectionsCompanion.insert(
            id: id,
            name: name,
            createdAt: createdAt,
            updatedAt: updatedAt,
            rowid: rowid,
          ),
          withReferenceMapper: (p0) => p0
              .map((e) => (e.readTable(table), BaseReferences(db, table, e)))
              .toList(),
          prefetchHooksCallback: null,
        ));
}

typedef $$CollectionsTableProcessedTableManager = ProcessedTableManager<
    _$AppDatabase,
    $CollectionsTable,
    Collection,
    $$CollectionsTableFilterComposer,
    $$CollectionsTableOrderingComposer,
    $$CollectionsTableAnnotationComposer,
    $$CollectionsTableCreateCompanionBuilder,
    $$CollectionsTableUpdateCompanionBuilder,
    (Collection, BaseReferences<_$AppDatabase, $CollectionsTable, Collection>),
    Collection,
    PrefetchHooks Function()>;
typedef $$CollectionItemsTableCreateCompanionBuilder = CollectionItemsCompanion
    Function({
  required String id,
  required String collectionId,
  required String printingId,
  required int quantity,
  Value<bool> isFoil,
  required String condition,
  Value<String> language,
  Value<String?> notes,
  required DateTime createdAt,
  required DateTime updatedAt,
  Value<int> rowid,
});
typedef $$CollectionItemsTableUpdateCompanionBuilder = CollectionItemsCompanion
    Function({
  Value<String> id,
  Value<String> collectionId,
  Value<String> printingId,
  Value<int> quantity,
  Value<bool> isFoil,
  Value<String> condition,
  Value<String> language,
  Value<String?> notes,
  Value<DateTime> createdAt,
  Value<DateTime> updatedAt,
  Value<int> rowid,
});

class $$CollectionItemsTableFilterComposer
    extends Composer<_$AppDatabase, $CollectionItemsTable> {
  $$CollectionItemsTableFilterComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnFilters<String> get id => $composableBuilder(
      column: $table.id, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get collectionId => $composableBuilder(
      column: $table.collectionId, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get printingId => $composableBuilder(
      column: $table.printingId, builder: (column) => ColumnFilters(column));

  ColumnFilters<int> get quantity => $composableBuilder(
      column: $table.quantity, builder: (column) => ColumnFilters(column));

  ColumnFilters<bool> get isFoil => $composableBuilder(
      column: $table.isFoil, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get condition => $composableBuilder(
      column: $table.condition, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get language => $composableBuilder(
      column: $table.language, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get notes => $composableBuilder(
      column: $table.notes, builder: (column) => ColumnFilters(column));

  ColumnFilters<DateTime> get createdAt => $composableBuilder(
      column: $table.createdAt, builder: (column) => ColumnFilters(column));

  ColumnFilters<DateTime> get updatedAt => $composableBuilder(
      column: $table.updatedAt, builder: (column) => ColumnFilters(column));
}

class $$CollectionItemsTableOrderingComposer
    extends Composer<_$AppDatabase, $CollectionItemsTable> {
  $$CollectionItemsTableOrderingComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnOrderings<String> get id => $composableBuilder(
      column: $table.id, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get collectionId => $composableBuilder(
      column: $table.collectionId,
      builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get printingId => $composableBuilder(
      column: $table.printingId, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<int> get quantity => $composableBuilder(
      column: $table.quantity, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<bool> get isFoil => $composableBuilder(
      column: $table.isFoil, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get condition => $composableBuilder(
      column: $table.condition, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get language => $composableBuilder(
      column: $table.language, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get notes => $composableBuilder(
      column: $table.notes, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<DateTime> get createdAt => $composableBuilder(
      column: $table.createdAt, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<DateTime> get updatedAt => $composableBuilder(
      column: $table.updatedAt, builder: (column) => ColumnOrderings(column));
}

class $$CollectionItemsTableAnnotationComposer
    extends Composer<_$AppDatabase, $CollectionItemsTable> {
  $$CollectionItemsTableAnnotationComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  GeneratedColumn<String> get id =>
      $composableBuilder(column: $table.id, builder: (column) => column);

  GeneratedColumn<String> get collectionId => $composableBuilder(
      column: $table.collectionId, builder: (column) => column);

  GeneratedColumn<String> get printingId => $composableBuilder(
      column: $table.printingId, builder: (column) => column);

  GeneratedColumn<int> get quantity =>
      $composableBuilder(column: $table.quantity, builder: (column) => column);

  GeneratedColumn<bool> get isFoil =>
      $composableBuilder(column: $table.isFoil, builder: (column) => column);

  GeneratedColumn<String> get condition =>
      $composableBuilder(column: $table.condition, builder: (column) => column);

  GeneratedColumn<String> get language =>
      $composableBuilder(column: $table.language, builder: (column) => column);

  GeneratedColumn<String> get notes =>
      $composableBuilder(column: $table.notes, builder: (column) => column);

  GeneratedColumn<DateTime> get createdAt =>
      $composableBuilder(column: $table.createdAt, builder: (column) => column);

  GeneratedColumn<DateTime> get updatedAt =>
      $composableBuilder(column: $table.updatedAt, builder: (column) => column);
}

class $$CollectionItemsTableTableManager extends RootTableManager<
    _$AppDatabase,
    $CollectionItemsTable,
    CollectionItem,
    $$CollectionItemsTableFilterComposer,
    $$CollectionItemsTableOrderingComposer,
    $$CollectionItemsTableAnnotationComposer,
    $$CollectionItemsTableCreateCompanionBuilder,
    $$CollectionItemsTableUpdateCompanionBuilder,
    (
      CollectionItem,
      BaseReferences<_$AppDatabase, $CollectionItemsTable, CollectionItem>
    ),
    CollectionItem,
    PrefetchHooks Function()> {
  $$CollectionItemsTableTableManager(
      _$AppDatabase db, $CollectionItemsTable table)
      : super(TableManagerState(
          db: db,
          table: table,
          createFilteringComposer: () =>
              $$CollectionItemsTableFilterComposer($db: db, $table: table),
          createOrderingComposer: () =>
              $$CollectionItemsTableOrderingComposer($db: db, $table: table),
          createComputedFieldComposer: () =>
              $$CollectionItemsTableAnnotationComposer($db: db, $table: table),
          updateCompanionCallback: ({
            Value<String> id = const Value.absent(),
            Value<String> collectionId = const Value.absent(),
            Value<String> printingId = const Value.absent(),
            Value<int> quantity = const Value.absent(),
            Value<bool> isFoil = const Value.absent(),
            Value<String> condition = const Value.absent(),
            Value<String> language = const Value.absent(),
            Value<String?> notes = const Value.absent(),
            Value<DateTime> createdAt = const Value.absent(),
            Value<DateTime> updatedAt = const Value.absent(),
            Value<int> rowid = const Value.absent(),
          }) =>
              CollectionItemsCompanion(
            id: id,
            collectionId: collectionId,
            printingId: printingId,
            quantity: quantity,
            isFoil: isFoil,
            condition: condition,
            language: language,
            notes: notes,
            createdAt: createdAt,
            updatedAt: updatedAt,
            rowid: rowid,
          ),
          createCompanionCallback: ({
            required String id,
            required String collectionId,
            required String printingId,
            required int quantity,
            Value<bool> isFoil = const Value.absent(),
            required String condition,
            Value<String> language = const Value.absent(),
            Value<String?> notes = const Value.absent(),
            required DateTime createdAt,
            required DateTime updatedAt,
            Value<int> rowid = const Value.absent(),
          }) =>
              CollectionItemsCompanion.insert(
            id: id,
            collectionId: collectionId,
            printingId: printingId,
            quantity: quantity,
            isFoil: isFoil,
            condition: condition,
            language: language,
            notes: notes,
            createdAt: createdAt,
            updatedAt: updatedAt,
            rowid: rowid,
          ),
          withReferenceMapper: (p0) => p0
              .map((e) => (e.readTable(table), BaseReferences(db, table, e)))
              .toList(),
          prefetchHooksCallback: null,
        ));
}

typedef $$CollectionItemsTableProcessedTableManager = ProcessedTableManager<
    _$AppDatabase,
    $CollectionItemsTable,
    CollectionItem,
    $$CollectionItemsTableFilterComposer,
    $$CollectionItemsTableOrderingComposer,
    $$CollectionItemsTableAnnotationComposer,
    $$CollectionItemsTableCreateCompanionBuilder,
    $$CollectionItemsTableUpdateCompanionBuilder,
    (
      CollectionItem,
      BaseReferences<_$AppDatabase, $CollectionItemsTable, CollectionItem>
    ),
    CollectionItem,
    PrefetchHooks Function()>;
typedef $$DecksTableCreateCompanionBuilder = DecksCompanion Function({
  required String id,
  required String name,
  required String format,
  Value<bool> isActive,
  required DateTime createdAt,
  required DateTime updatedAt,
  Value<int> rowid,
});
typedef $$DecksTableUpdateCompanionBuilder = DecksCompanion Function({
  Value<String> id,
  Value<String> name,
  Value<String> format,
  Value<bool> isActive,
  Value<DateTime> createdAt,
  Value<DateTime> updatedAt,
  Value<int> rowid,
});

class $$DecksTableFilterComposer extends Composer<_$AppDatabase, $DecksTable> {
  $$DecksTableFilterComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnFilters<String> get id => $composableBuilder(
      column: $table.id, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get name => $composableBuilder(
      column: $table.name, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get format => $composableBuilder(
      column: $table.format, builder: (column) => ColumnFilters(column));

  ColumnFilters<bool> get isActive => $composableBuilder(
      column: $table.isActive, builder: (column) => ColumnFilters(column));

  ColumnFilters<DateTime> get createdAt => $composableBuilder(
      column: $table.createdAt, builder: (column) => ColumnFilters(column));

  ColumnFilters<DateTime> get updatedAt => $composableBuilder(
      column: $table.updatedAt, builder: (column) => ColumnFilters(column));
}

class $$DecksTableOrderingComposer
    extends Composer<_$AppDatabase, $DecksTable> {
  $$DecksTableOrderingComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnOrderings<String> get id => $composableBuilder(
      column: $table.id, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get name => $composableBuilder(
      column: $table.name, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get format => $composableBuilder(
      column: $table.format, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<bool> get isActive => $composableBuilder(
      column: $table.isActive, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<DateTime> get createdAt => $composableBuilder(
      column: $table.createdAt, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<DateTime> get updatedAt => $composableBuilder(
      column: $table.updatedAt, builder: (column) => ColumnOrderings(column));
}

class $$DecksTableAnnotationComposer
    extends Composer<_$AppDatabase, $DecksTable> {
  $$DecksTableAnnotationComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  GeneratedColumn<String> get id =>
      $composableBuilder(column: $table.id, builder: (column) => column);

  GeneratedColumn<String> get name =>
      $composableBuilder(column: $table.name, builder: (column) => column);

  GeneratedColumn<String> get format =>
      $composableBuilder(column: $table.format, builder: (column) => column);

  GeneratedColumn<bool> get isActive =>
      $composableBuilder(column: $table.isActive, builder: (column) => column);

  GeneratedColumn<DateTime> get createdAt =>
      $composableBuilder(column: $table.createdAt, builder: (column) => column);

  GeneratedColumn<DateTime> get updatedAt =>
      $composableBuilder(column: $table.updatedAt, builder: (column) => column);
}

class $$DecksTableTableManager extends RootTableManager<
    _$AppDatabase,
    $DecksTable,
    Deck,
    $$DecksTableFilterComposer,
    $$DecksTableOrderingComposer,
    $$DecksTableAnnotationComposer,
    $$DecksTableCreateCompanionBuilder,
    $$DecksTableUpdateCompanionBuilder,
    (Deck, BaseReferences<_$AppDatabase, $DecksTable, Deck>),
    Deck,
    PrefetchHooks Function()> {
  $$DecksTableTableManager(_$AppDatabase db, $DecksTable table)
      : super(TableManagerState(
          db: db,
          table: table,
          createFilteringComposer: () =>
              $$DecksTableFilterComposer($db: db, $table: table),
          createOrderingComposer: () =>
              $$DecksTableOrderingComposer($db: db, $table: table),
          createComputedFieldComposer: () =>
              $$DecksTableAnnotationComposer($db: db, $table: table),
          updateCompanionCallback: ({
            Value<String> id = const Value.absent(),
            Value<String> name = const Value.absent(),
            Value<String> format = const Value.absent(),
            Value<bool> isActive = const Value.absent(),
            Value<DateTime> createdAt = const Value.absent(),
            Value<DateTime> updatedAt = const Value.absent(),
            Value<int> rowid = const Value.absent(),
          }) =>
              DecksCompanion(
            id: id,
            name: name,
            format: format,
            isActive: isActive,
            createdAt: createdAt,
            updatedAt: updatedAt,
            rowid: rowid,
          ),
          createCompanionCallback: ({
            required String id,
            required String name,
            required String format,
            Value<bool> isActive = const Value.absent(),
            required DateTime createdAt,
            required DateTime updatedAt,
            Value<int> rowid = const Value.absent(),
          }) =>
              DecksCompanion.insert(
            id: id,
            name: name,
            format: format,
            isActive: isActive,
            createdAt: createdAt,
            updatedAt: updatedAt,
            rowid: rowid,
          ),
          withReferenceMapper: (p0) => p0
              .map((e) => (e.readTable(table), BaseReferences(db, table, e)))
              .toList(),
          prefetchHooksCallback: null,
        ));
}

typedef $$DecksTableProcessedTableManager = ProcessedTableManager<
    _$AppDatabase,
    $DecksTable,
    Deck,
    $$DecksTableFilterComposer,
    $$DecksTableOrderingComposer,
    $$DecksTableAnnotationComposer,
    $$DecksTableCreateCompanionBuilder,
    $$DecksTableUpdateCompanionBuilder,
    (Deck, BaseReferences<_$AppDatabase, $DecksTable, Deck>),
    Deck,
    PrefetchHooks Function()>;
typedef $$DeckEntriesTableCreateCompanionBuilder = DeckEntriesCompanion
    Function({
  required String id,
  required String deckId,
  required String oracleId,
  Value<String?> preferredPrintingId,
  Value<String?> collectionItemId,
  required int quantity,
  Value<String> section,
  Value<String> ownedStatus,
  required DateTime createdAt,
  required DateTime updatedAt,
  Value<int> rowid,
});
typedef $$DeckEntriesTableUpdateCompanionBuilder = DeckEntriesCompanion
    Function({
  Value<String> id,
  Value<String> deckId,
  Value<String> oracleId,
  Value<String?> preferredPrintingId,
  Value<String?> collectionItemId,
  Value<int> quantity,
  Value<String> section,
  Value<String> ownedStatus,
  Value<DateTime> createdAt,
  Value<DateTime> updatedAt,
  Value<int> rowid,
});

class $$DeckEntriesTableFilterComposer
    extends Composer<_$AppDatabase, $DeckEntriesTable> {
  $$DeckEntriesTableFilterComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnFilters<String> get id => $composableBuilder(
      column: $table.id, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get deckId => $composableBuilder(
      column: $table.deckId, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get oracleId => $composableBuilder(
      column: $table.oracleId, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get preferredPrintingId => $composableBuilder(
      column: $table.preferredPrintingId,
      builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get collectionItemId => $composableBuilder(
      column: $table.collectionItemId,
      builder: (column) => ColumnFilters(column));

  ColumnFilters<int> get quantity => $composableBuilder(
      column: $table.quantity, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get section => $composableBuilder(
      column: $table.section, builder: (column) => ColumnFilters(column));

  ColumnFilters<String> get ownedStatus => $composableBuilder(
      column: $table.ownedStatus, builder: (column) => ColumnFilters(column));

  ColumnFilters<DateTime> get createdAt => $composableBuilder(
      column: $table.createdAt, builder: (column) => ColumnFilters(column));

  ColumnFilters<DateTime> get updatedAt => $composableBuilder(
      column: $table.updatedAt, builder: (column) => ColumnFilters(column));
}

class $$DeckEntriesTableOrderingComposer
    extends Composer<_$AppDatabase, $DeckEntriesTable> {
  $$DeckEntriesTableOrderingComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  ColumnOrderings<String> get id => $composableBuilder(
      column: $table.id, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get deckId => $composableBuilder(
      column: $table.deckId, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get oracleId => $composableBuilder(
      column: $table.oracleId, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get preferredPrintingId => $composableBuilder(
      column: $table.preferredPrintingId,
      builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get collectionItemId => $composableBuilder(
      column: $table.collectionItemId,
      builder: (column) => ColumnOrderings(column));

  ColumnOrderings<int> get quantity => $composableBuilder(
      column: $table.quantity, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get section => $composableBuilder(
      column: $table.section, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<String> get ownedStatus => $composableBuilder(
      column: $table.ownedStatus, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<DateTime> get createdAt => $composableBuilder(
      column: $table.createdAt, builder: (column) => ColumnOrderings(column));

  ColumnOrderings<DateTime> get updatedAt => $composableBuilder(
      column: $table.updatedAt, builder: (column) => ColumnOrderings(column));
}

class $$DeckEntriesTableAnnotationComposer
    extends Composer<_$AppDatabase, $DeckEntriesTable> {
  $$DeckEntriesTableAnnotationComposer({
    required super.$db,
    required super.$table,
    super.joinBuilder,
    super.$addJoinBuilderToRootComposer,
    super.$removeJoinBuilderFromRootComposer,
  });
  GeneratedColumn<String> get id =>
      $composableBuilder(column: $table.id, builder: (column) => column);

  GeneratedColumn<String> get deckId =>
      $composableBuilder(column: $table.deckId, builder: (column) => column);

  GeneratedColumn<String> get oracleId =>
      $composableBuilder(column: $table.oracleId, builder: (column) => column);

  GeneratedColumn<String> get preferredPrintingId => $composableBuilder(
      column: $table.preferredPrintingId, builder: (column) => column);

  GeneratedColumn<String> get collectionItemId => $composableBuilder(
      column: $table.collectionItemId, builder: (column) => column);

  GeneratedColumn<int> get quantity =>
      $composableBuilder(column: $table.quantity, builder: (column) => column);

  GeneratedColumn<String> get section =>
      $composableBuilder(column: $table.section, builder: (column) => column);

  GeneratedColumn<String> get ownedStatus => $composableBuilder(
      column: $table.ownedStatus, builder: (column) => column);

  GeneratedColumn<DateTime> get createdAt =>
      $composableBuilder(column: $table.createdAt, builder: (column) => column);

  GeneratedColumn<DateTime> get updatedAt =>
      $composableBuilder(column: $table.updatedAt, builder: (column) => column);
}

class $$DeckEntriesTableTableManager extends RootTableManager<
    _$AppDatabase,
    $DeckEntriesTable,
    DeckEntry,
    $$DeckEntriesTableFilterComposer,
    $$DeckEntriesTableOrderingComposer,
    $$DeckEntriesTableAnnotationComposer,
    $$DeckEntriesTableCreateCompanionBuilder,
    $$DeckEntriesTableUpdateCompanionBuilder,
    (DeckEntry, BaseReferences<_$AppDatabase, $DeckEntriesTable, DeckEntry>),
    DeckEntry,
    PrefetchHooks Function()> {
  $$DeckEntriesTableTableManager(_$AppDatabase db, $DeckEntriesTable table)
      : super(TableManagerState(
          db: db,
          table: table,
          createFilteringComposer: () =>
              $$DeckEntriesTableFilterComposer($db: db, $table: table),
          createOrderingComposer: () =>
              $$DeckEntriesTableOrderingComposer($db: db, $table: table),
          createComputedFieldComposer: () =>
              $$DeckEntriesTableAnnotationComposer($db: db, $table: table),
          updateCompanionCallback: ({
            Value<String> id = const Value.absent(),
            Value<String> deckId = const Value.absent(),
            Value<String> oracleId = const Value.absent(),
            Value<String?> preferredPrintingId = const Value.absent(),
            Value<String?> collectionItemId = const Value.absent(),
            Value<int> quantity = const Value.absent(),
            Value<String> section = const Value.absent(),
            Value<String> ownedStatus = const Value.absent(),
            Value<DateTime> createdAt = const Value.absent(),
            Value<DateTime> updatedAt = const Value.absent(),
            Value<int> rowid = const Value.absent(),
          }) =>
              DeckEntriesCompanion(
            id: id,
            deckId: deckId,
            oracleId: oracleId,
            preferredPrintingId: preferredPrintingId,
            collectionItemId: collectionItemId,
            quantity: quantity,
            section: section,
            ownedStatus: ownedStatus,
            createdAt: createdAt,
            updatedAt: updatedAt,
            rowid: rowid,
          ),
          createCompanionCallback: ({
            required String id,
            required String deckId,
            required String oracleId,
            Value<String?> preferredPrintingId = const Value.absent(),
            Value<String?> collectionItemId = const Value.absent(),
            required int quantity,
            Value<String> section = const Value.absent(),
            Value<String> ownedStatus = const Value.absent(),
            required DateTime createdAt,
            required DateTime updatedAt,
            Value<int> rowid = const Value.absent(),
          }) =>
              DeckEntriesCompanion.insert(
            id: id,
            deckId: deckId,
            oracleId: oracleId,
            preferredPrintingId: preferredPrintingId,
            collectionItemId: collectionItemId,
            quantity: quantity,
            section: section,
            ownedStatus: ownedStatus,
            createdAt: createdAt,
            updatedAt: updatedAt,
            rowid: rowid,
          ),
          withReferenceMapper: (p0) => p0
              .map((e) => (e.readTable(table), BaseReferences(db, table, e)))
              .toList(),
          prefetchHooksCallback: null,
        ));
}

typedef $$DeckEntriesTableProcessedTableManager = ProcessedTableManager<
    _$AppDatabase,
    $DeckEntriesTable,
    DeckEntry,
    $$DeckEntriesTableFilterComposer,
    $$DeckEntriesTableOrderingComposer,
    $$DeckEntriesTableAnnotationComposer,
    $$DeckEntriesTableCreateCompanionBuilder,
    $$DeckEntriesTableUpdateCompanionBuilder,
    (DeckEntry, BaseReferences<_$AppDatabase, $DeckEntriesTable, DeckEntry>),
    DeckEntry,
    PrefetchHooks Function()>;

class $AppDatabaseManager {
  final _$AppDatabase _db;
  $AppDatabaseManager(this._db);
  $$ScryfallPrintingsTableTableManager get scryfallPrintings =>
      $$ScryfallPrintingsTableTableManager(_db, _db.scryfallPrintings);
  $$PriceSnapshotsTableTableManager get priceSnapshots =>
      $$PriceSnapshotsTableTableManager(_db, _db.priceSnapshots);
  $$CollectionsTableTableManager get collections =>
      $$CollectionsTableTableManager(_db, _db.collections);
  $$CollectionItemsTableTableManager get collectionItems =>
      $$CollectionItemsTableTableManager(_db, _db.collectionItems);
  $$DecksTableTableManager get decks =>
      $$DecksTableTableManager(_db, _db.decks);
  $$DeckEntriesTableTableManager get deckEntries =>
      $$DeckEntriesTableTableManager(_db, _db.deckEntries);
}
