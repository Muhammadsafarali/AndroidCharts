package tom.androidchart2.Measurements;

/**
 * Created by 3dium on 20.06.2017.
 */

public class Summary {

    private int id;
    private Summary1 weightKG;
    private Summary1 smKG;
    private Summary1 sjKG;
    private Summary1 smPe;
    private Summary1 sjPe;
    private Summary1 bmi;
    private Summary1 tkr;
    private Weight weight;
    private Bju bju;
    private Danger danger;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Summary1 getWeightKG() {
        return weightKG;
    }

    public void setWeightKG(Summary1 weightKG) {
        this.weightKG = weightKG;
    }

    public Summary1 getSmKG() {
        return smKG;
    }

    public void setSmKG(Summary1 smKG) {
        this.smKG = smKG;
    }

    public Summary1 getSjKG() {
        return sjKG;
    }

    public void setSjKG(Summary1 sjKG) {
        this.sjKG = sjKG;
    }

    public Summary1 getSmPe() {
        return smPe;
    }

    public void setSmPe(Summary1 smPe) {
        this.smPe = smPe;
    }

    public Summary1 getSjPe() {
        return sjPe;
    }

    public void setSjPe(Summary1 sjPe) {
        this.sjPe = sjPe;
    }

    public Summary1 getBmi() {
        return bmi;
    }

    public void setBmi(Summary1 bmi) {
        this.bmi = bmi;
    }

    public Summary1 getTkr() {
        return tkr;
    }

    public void setTkr(Summary1 tkr) {
        this.tkr = tkr;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public Bju getBju() {
        return bju;
    }

    public void setBju(Bju bju) {
        this.bju = bju;
    }

    public Danger getDanger() {
        return danger;
    }

    public void setDanger(Danger danger) {
        this.danger = danger;
    }
}
