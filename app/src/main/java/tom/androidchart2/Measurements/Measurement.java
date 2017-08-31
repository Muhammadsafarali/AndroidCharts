package tom.androidchart2.Measurements;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 3dium on 21.06.2017.
 */

public class Measurement {

    private int id;
//    private String date;
    private Date cdate; // Date 2017-03-21
    private Sizes sizes;
    private String weight;// float weight;
    private String age;// Integer age;
    private String gender;
    private Summary summary;
    // private Mix
    private String usermessage;
    private String managermessage;
    private ArrayList<Model> models;
    private boolean error;
    private String description;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public String getUsermessage() {
        return usermessage;
    }

    public void setUsermessage(String usermessage) {
        this.usermessage = usermessage;
    }

    public String getManagermessage() {
        return managermessage;
    }

    public void setManagermessage(String managermessage) {
        this.managermessage = managermessage;
    }

    public ArrayList<Model> getModels() {
        return models;
    }

    public void setModels(ArrayList<Model> models) {
        this.models = models;
    }
}
