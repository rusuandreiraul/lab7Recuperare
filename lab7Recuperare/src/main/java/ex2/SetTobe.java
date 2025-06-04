package ex2;


import java.util.Objects;

public class SetTobe extends InstrumentMuzical{
    private TipTobe tipTobe;
    private int nr_tobe;
    private int nr_cinele;

    public SetTobe(String producator, double pret, TipTobe tipTobe, int nr_tobe, int nr_cinele) {
        super(producator, pret);
        this.tipTobe = tipTobe;
        this.nr_tobe = nr_tobe;
        this.nr_cinele = nr_cinele;
    }

    public SetTobe(){}

    public TipTobe getTipTobe() {
        return tipTobe;
    }

    public void setTipTobe(TipTobe tipTobe) {
        this.tipTobe = tipTobe;
    }

    public int getNr_tobe() {
        return nr_tobe;
    }

    public void setNr_tobe(int nr_tobe) {
        this.nr_tobe = nr_tobe;
    }

    public int getNr_cinele() {
        return nr_cinele;
    }

    public void setNr_cinele(int nr_cinele) {
        this.nr_cinele = nr_cinele;
    }

    @Override
    public String toString() {
        return "SetTobe{" +
                "tipTobe=" + tipTobe +
                ", nr_tobe=" + nr_tobe +
                ", nr_cinele=" + nr_cinele +
                ", producator='" + producator + '\'' +
                ", pret=" + pret +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetTobe setTobe = (SetTobe) o;
        return nr_tobe == setTobe.nr_tobe && nr_cinele == setTobe.nr_cinele && tipTobe == setTobe.tipTobe && getProducator().equals(setTobe.getProducator()) && getPret()==setTobe.getPret();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProducator(), getPret(), getTipTobe(), getNr_tobe(), getNr_cinele());
    }
}
