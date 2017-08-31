package tom.androidchart2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;

import im.dacer.androidcharts.LineView;
import tom.androidchart2.Measurements.Measurement;
import tom.androidchart2.Measurements.Model;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Measurement> m = getMeasure();

        makeListCharts(m);
    }

    private ArrayList<Measurement> getMeasure() {
        JsonParser p = new JsonParser();
        String json = Utils.readTextFromRaw(this, R.raw.measure);
        JsonElement t = p.parse(json);
        JsonArray a = t.getAsJsonArray();
        ArrayList<Measurement> list = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            Measurement m = Factory.getGson().fromJson(a.get(i), Measurement.class);
            list.add(m);
        }

        return list;
    }

    private void makeListCharts(ArrayList<Measurement> m) {
//        ArrayList<Measurement> m = Facade.getInstance().getTestMeasure();

        ArrayList<String> strList = new ArrayList<>();

        // Динамика изменения размеров тела в см
        ArrayList<ArrayList<Float>> sizesLists = new ArrayList<>();

        ArrayList<Float> bust = new ArrayList<>();
        ArrayList<Float> waist = new ArrayList<>();
        ArrayList<Float> hips = new ArrayList<>();
        ArrayList<Float> rightShoulder = new ArrayList<>();
        ArrayList<Float> leftShoulder = new ArrayList<>();
        ArrayList<Float> rightHip = new ArrayList<>();
        ArrayList<Float> leftHip = new ArrayList<>();

        // Динамика изменения состава тела в КГ
        ArrayList<ArrayList<Float>> smKgLists = new ArrayList<>();

        ArrayList<Float> weight = new ArrayList<>();
        ArrayList<Float> smKG = new ArrayList<>();
        ArrayList<Float> sjKG = new ArrayList<>();

        // Динамика изменения состава тела в КГ
        ArrayList<ArrayList<Float>> smPeLists = new ArrayList<>();

        ArrayList<Float> smPE = new ArrayList<>();
        ArrayList<Float> sjPE = new ArrayList<>();

        // Динамика изменения ИМТ
        ArrayList<ArrayList<Float>> bmiLists = new ArrayList<>();

        ArrayList<Float> bmi = new ArrayList<>();

        // Динамика изменения соотношения талии к ростсу
        ArrayList<ArrayList<Float>> tkrLists = new ArrayList<>();

        ArrayList<Float> tkr = new ArrayList<>();

        ArrayList<ArrayList<ArrayList<Float>>> listChartLists = new ArrayList();
        for (int i = 0; i < m.size(); i++) {
            // ось x
            strList.add(Utils.DateToString(m.get(i).getCdate(), "dd.MM.yy"));

            // Динамика изменения размеров тела в см
            if (m.get(i).getSizes() != null) {
                bust.add(m.get(i).getSizes().getBust());
                waist.add(m.get(i).getSizes().getWaist());
                hips.add(m.get(i).getSizes().getHips());
                rightShoulder.add(m.get(i).getSizes().getRightshoulder());
                leftShoulder.add(m.get(i).getSizes().getLeftshoulder());
                rightHip.add(m.get(i).getSizes().getRighthip());
                leftHip.add(m.get(i).getSizes().getLefthip());
            }

            // Динамика изменения состава тела в КГ
            if (m.get(i).getSummary().getWeightKG() != null) {
                weight.add(m.get(i).getSummary().getWeightKG().getVal());
                smKG.add(m.get(i).getSummary().getSmKG().getVal());
                sjKG.add(m.get(i).getSummary().getSjKG().getVal());
            }

            // Динамика изменения состава тела в %
            if (m.get(i).getSummary().getSmPe() != null) {
                smPE.add(m.get(i).getSummary().getSmPe().getVal());
                sjPE.add(m.get(i).getSummary().getSjPe().getVal());
            }

            // Динамика изменения ИМТ
            if (m.get(i).getSummary().getBmi() != null) {
                bmi.add(m.get(i).getSummary().getBmi().getVal());
            }

            // Динамика изменения соотношения талии к ростсу
            if (m.get(i).getSummary().getTkr() != null) {
                tkr.add(m.get(i).getSummary().getTkr().getVal());
            }
        }
        sizesLists.add(bust);
        sizesLists.add(waist);
        sizesLists.add(hips);
        sizesLists.add(rightShoulder);
        sizesLists.add(leftShoulder);
        sizesLists.add(rightHip);
        sizesLists.add(leftHip);

        smKgLists.add(weight);
        smKgLists.add(smKG);
        smKgLists.add(sjKG);

        smPeLists.add(smPE);
        smPeLists.add(sjPE);

        bmiLists.add(bmi);

        tkrLists.add(tkr);

        listChartLists.add(sizesLists);
        listChartLists.add(smKgLists);
        listChartLists.add(smPeLists);
        listChartLists.add(bmiLists);
        listChartLists.add(tkrLists);

//        setupTestStatistic(strList, listChartLists);
        setupStatistic(strList, listChartLists);
    }

    private void setupStatistic(ArrayList<String> strList, ArrayList<ArrayList<ArrayList<Float>>> items) {
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        MyAdapter adapter = new MyAdapter(this ,strList, items);
        recyclerView.setAdapter(adapter);
    }

    private void test() {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("1");
        strList.add("2");
        strList.add("3");
        strList.add("4");
        strList.add("5");

        ArrayList<ArrayList<Integer>> datalists = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>();
        first.add(2);
        first.add(3);
        first.add(5);
        first.add(7);
        first.add(5);

        ArrayList<Integer> second = new ArrayList<>();
        second.add(5);
        second.add(6);
        second.add(2);
        second.add(1);
        second.add(4);

        datalists.add(first);
        datalists.add(second);

        LineView lineView = (LineView) findViewById(R.id.line_view);
        lineView.setDrawDotLine(false);
        lineView.setShowPopup(LineView.SHOW_POPUPS_NONE);
        lineView.setBottomTextList(strList);
        lineView.setColorArray(new int[]{getResources().getColor(R.color.myred), getResources().getColor(R.color.myblue), Color.CYAN});
        lineView.setDataList(datalists);
    }

    static class Factory {
        public static Gson getGson() {
            return GSON;
        }

        private static final Gson GSON = new GsonBuilder()
                .setDateFormat("dd.MM.yyyy HH:mm:ss")
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return false;
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();

    }

}
