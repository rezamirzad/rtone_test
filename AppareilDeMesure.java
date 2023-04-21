import java.util.Random;

public class AppareilDeMesure {

  public static void main(String[] args) {
    Logger.setLevel(Logger.Level.DEBUG);

    System.out.println("Logger Level is set to : " + Logger.getLevel());

    System.out.println("Initialisation de l'appareil de mesure...");

    // Simulation de la prise de mesures
    for (int i = 0; i < 10; i++) {
      Mesure mesure = prendreMesure();

      if (Logger.getLevel() == Logger.Level.DEBUG) {
        switch (mesure.getType()) {
          case TEMPERATURE:
            if (mesure.getValeur() < 60) {
              Logger.info("Température : " + mesure.getValeur());
            } else if (mesure.getValeur() >= 60 && mesure.getValeur() <= 100) {
              Logger.warn("Température : " + mesure.getValeur());
            } else {
              Logger.error("Température : " + mesure.getValeur());
            }
            break;
          case PRESSION:
            if (mesure.getValeur() < 20) {
              Logger.info("Préssion : " + mesure.getValeur());
            } else if (mesure.getValeur() >= 20 && mesure.getValeur() <= 50) {
              Logger.warn("Préssion : " + mesure.getValeur());
            } else {
              Logger.error("Préssion : " + mesure.getValeur());
            }
            break;
          case NIVEAU_SONORE:
            if (mesure.getValeur() < 55) {
              Logger.info("Niveau sonore : " + mesure.getValeur());
            } else if (mesure.getValeur() >= 55 && mesure.getValeur() <= 80) {
              Logger.warn("Niveau sonore : " + mesure.getValeur());
            } else {
              Logger.error("Niveau sonore : " + mesure.getValeur());
            }
            break;
          case QUANTITE_ENERGIE:
            if (mesure.getValeur() < 100) {
              Logger.info("Quantité d'énergie : " + mesure.getValeur());
            } else if (mesure.getValeur() >= 100 && mesure.getValeur() <= 125) {
              Logger.warn("Quantité d'énergie : " + mesure.getValeur());
            } else {
              Logger.error("Quantité d'énergie : " + mesure.getValeur());
            }
            break;
          default:
            break;
        }
      }
    }

    System.out.println("Arrêt de l'appareil de mesure.");
  }

  private static Mesure prendreMesure() {
    Random random = new Random();
    int type = random.nextInt(4);
    int valeur = random.nextInt(150);
    switch (type) {
      case 0:
        return new Mesure(TypeMesure.TEMPERATURE, valeur);
      case 1:
        return new Mesure(TypeMesure.PRESSION, valeur);
      case 2:
        return new Mesure(TypeMesure.NIVEAU_SONORE, valeur);
      case 3:
        return new Mesure(TypeMesure.QUANTITE_ENERGIE, valeur);
      default:
        return null;
    }
  }
}

class Mesure {
  private TypeMesure type;
  private int valeur;

  public Mesure(TypeMesure type, int valeur) {
    this.type = type;
    this.valeur = valeur;
  }

  public TypeMesure getType() {
    return type;
  }

  public void setType(TypeMesure type) {
    this.type = type;
  }

  public int getValeur() {
    return valeur;
  }

  public void setValeur(int valeur) {
    this.valeur = valeur;
  }
}

enum TypeMesure {
  TEMPERATURE,
  PRESSION,
  NIVEAU_SONORE,
  QUANTITE_ENERGIE,
}
