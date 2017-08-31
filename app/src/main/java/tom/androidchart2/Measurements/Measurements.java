package tom.androidchart2.Measurements;

import java.util.ArrayList;

/**
 * Created by 3dium on 13.06.2017.
 */

public class Measurements {

    private int id;
//    private RealmList<RealmMap> items;
    private ArrayList<Measurement> items;
    private boolean error;
    private String description;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ArrayList<Measurement> getItems() {
        return items;
    }
    public void setItems(ArrayList<Measurement> items) {
        this.items = items;
    }
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
}