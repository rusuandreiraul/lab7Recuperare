package ex2;


import java.util.Objects;

public class Chitara extends InstrumentMuzical{
    private Tip tipChitara;
    private int nr_corzi;

    public Chitara(String producator, double pret, Tip tipChitara, int nr_corzi) {
        super(producator, pret);
        this.tipChitara = tipChitara;
        this.nr_corzi = nr_corzi;
    }

    public Chitara(){}

    public Tip getTipChitara() {
        return tipChitara;
    }

    public void setTipChitara(Tip tipChitara) {
        this.tipChitara = tipChitara;
    }

    public int getNr_corzi() {
        return nr_corzi;
    }

    public void setNr_corzi(int nr_corzi) {
        this.nr_corzi = nr_corzi;
    }

    @Override
    public String toString() {
        return "Chitara{" +
                "tipChitara=" + tipChitara +
                ", nr_corzi=" + nr_corzi +
                ", producator='" + producator + '\'' +
                ", pret=" + pret +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chitara chitara = (Chitara) o;
        return nr_corzi == chitara.nr_corzi && tipChitara == chitara.tipChitara && getProducator().equals(chitara.getProducator()) && getPret()==chitara.getPret() && getTipChitara()==chitara.getTipChitara();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProducator(), getPret(), getTipChitara(), getNr_corzi());
    }
}

