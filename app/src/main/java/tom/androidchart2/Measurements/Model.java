package tom.androidchart2.Measurements;

/**
 * Created by 3dium on 20.06.2017.
 */

public class Model {

    private String id;// Integer id;
    private String iuser;// Integer iuser;
    private String path;
    private String name;
    private String cdate;  // Date 2017-03-21 09:44:12
    private String defmodel;// Integer defmodel;
    private String scanner;
    private String accuracy;// Double accuracy;
    private String weight;// float weight;
    private String height;// float height;
    private String orderprint;
    private String localPath;

    public Model() {}

    public Model(Model model) {

    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIuser() {
        return iuser;
    }

    public void setIuser(String iuser) {
        this.iuser = iuser;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getDefmodel() {
        return defmodel;
    }

    public void setDefmodel(String defmodel) {
        this.defmodel = defmodel;
    }

    public String getScanner() {
        return scanner;
    }

    public void setScanner(String scanner) {
        this.scanner = scanner;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getOrderprint() {
        return orderprint;
    }

    public void setOrderprint(String orderprint) {
        this.orderprint = orderprint;
    }
}
