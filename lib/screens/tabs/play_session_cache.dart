class PlaySessionCache {
  PlaySessionCache._();

  static final PlaySessionCache instance = PlaySessionCache._();

  bool hasSession = false;

  int players = 2;
  String mode = 'Commander';

  int lifeA = 20;
  int lifeB = 20;

  void startNew({
    required int players,
    required String mode,
  }) {
    hasSession = true;
    this.players = players;
    this.mode = mode;
    lifeA = 20;
    lifeB = 20;
  }

  void clear() {
    hasSession = false;
    players = 2;
    mode = 'Commander';
    lifeA = 20;
    lifeB = 20;
  }
}

