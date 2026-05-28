public class Bruchzahl {
    private int zaehler;
    private int nenner;

    public Bruchzahl(int zaehler, int nenner) {
        if (nenner == 0) {
            throw new IllegalArgumentException("Der Nenner darf nicht 0 sein.");
        }

        this.zaehler = zaehler;
        this.nenner = nenner;

        normalisiereVorzeichen();
        kuerzen();
    }

    private void normalisiereVorzeichen() {
        if (nenner < 0) {
            zaehler = -zaehler;
            nenner = -nenner;
        }
    }

    public Bruchzahl addieren(Bruchzahl andererBruch) {
        int gemeinsamerNenner = kgv(this.nenner, andererBruch.nenner);

        int neuerZaehler =
                this.zaehler * (gemeinsamerNenner / this.nenner)
                        + andererBruch.zaehler * (gemeinsamerNenner / andererBruch.nenner);

        return new Bruchzahl(neuerZaehler, gemeinsamerNenner);
    }

    public Bruchzahl subtrahieren(Bruchzahl andererBruch) {
        int gemeinsamerNenner = kgv(this.nenner, andererBruch.nenner);

        int neuerZaehler =
                this.zaehler * (gemeinsamerNenner / this.nenner)
                        - andererBruch.zaehler * (gemeinsamerNenner / andererBruch.nenner);

        return new Bruchzahl(neuerZaehler, gemeinsamerNenner);
    }

    public Bruchzahl multiplizieren(Bruchzahl andererBruch) {
        int neuerZaehler = this.zaehler * andererBruch.zaehler;
        int neuerNenner = this.nenner * andererBruch.nenner;

        return new Bruchzahl(neuerZaehler, neuerNenner);
    }

    public Bruchzahl dividieren(Bruchzahl andererBruch) {
        if (andererBruch.zaehler == 0) {
            throw new ArithmeticException("Division durch 0 ist nicht erlaubt.");
        }

        int neuerZaehler = this.zaehler * andererBruch.nenner;
        int neuerNenner = this.nenner * andererBruch.zaehler;

        return new Bruchzahl(neuerZaehler, neuerNenner);
    }

    public void kuerzen() {
        int teiler = ggt(Math.abs(zaehler), Math.abs(nenner));

        zaehler = zaehler / teiler;
        nenner = nenner / teiler;
    }

    public int ggt(int a, int b) {
        while (b != 0) {
            int rest = a % b;
            a = b;
            b = rest;
        }

        return a;
    }

    public int kgv(int a, int b) {
        return Math.abs(a * b) / ggt(Math.abs(a), Math.abs(b));
    }

    @Override
    public String toString() {
        if (nenner == 1) {
            return String.valueOf(zaehler);
        }

        return zaehler + "/" + nenner;
    }
}