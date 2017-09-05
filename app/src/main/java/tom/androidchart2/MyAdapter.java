package tom.androidchart2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nex3z.flowlayout.FlowLayout;

import java.util.ArrayList;

import im.dacer.androidcharts.LineView;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;

    private String[] items;
    private ArrayList<int[]> colorList = new ArrayList<>();
    private ArrayList<GraphList> graphItemArrayList;

    private int grayColor;
    private int whiteColor;

    ArrayList<ArrayList<String>> listNames;

    private static ArrayList<String> strList = new ArrayList<>();
    ArrayList<ArrayList<ArrayList<Float>>> dataLists = new ArrayList<>();

    ArrayList<ArrayList<Float>> filteredList;

    class GraphList {
        ArrayList<GraphItem> graphItems;
        int count;
    }

    class GraphItem {
        ArrayList<Float> chart;
        boolean checked;
        int color;
    }

    public MyAdapter(Context context, ArrayList<String> strList, ArrayList<ArrayList<ArrayList<Float>>> items) {
        this.mInflater = LayoutInflater.from(context);
        initHeaders(context);
        initColors(context);
        initLegendNames(context);

        initGraphItemArrayList(items);

        this.strList = strList;
        if (this.strList.size() < 8) {
            int count = 8 - strList.size();
            for (int i = 0; i < count; i++) {
                this.strList.add("");
            }
        }

        dataLists = items;
    }

    private void initGraphItemArrayList(ArrayList<ArrayList<ArrayList<Float>>> items) {
        if (graphItemArrayList == null)
            graphItemArrayList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            GraphList list = new GraphList();
            list.graphItems = new ArrayList<>();
            for (int j = 0; j < items.get(i).size(); j++) {
                GraphItem item = new GraphItem();
                item.chart = items.get(i).get(j);
                item.color = colorList.get(i)[j];
                list.graphItems.add(item);
            }
            graphItemArrayList.add(list);
        }
    }

    private void initColors(Context context) {
        grayColor = context.getResources().getColor(android.R.color.darker_gray);
        whiteColor = context.getResources().getColor(android.R.color.white);

        int[] colors1 = new int[7];
        colors1[0] = context.getResources().getColor(R.color.myred);
        colors1[1] = context.getResources().getColor(R.color.myblue);
        colors1[2] = context.getResources().getColor(R.color.mylime);
        colors1[3] = context.getResources().getColor(R.color.mypink);
        colors1[4] = context.getResources().getColor(R.color.mygreen);
        colors1[5] = context.getResources().getColor(R.color.myteal);
        colors1[6] = context.getResources().getColor(R.color.mycyan);

        colorList.add(colors1);

        int[] colors2 = new int[3];
        colors2[0] = context.getResources().getColor(R.color.myred);
        colors2[1] = context.getResources().getColor(R.color.myblue);
        colors2[2] = context.getResources().getColor(R.color.mylime);

        colorList.add(colors2);

        int[] colors3 = new int[2];
        colors3[0] = context.getResources().getColor(R.color.myred);
        colors3[1] = context.getResources().getColor(R.color.myblue);

        colorList.add(colors3);

        int[] colors4 = new int[1];
        colors4[0] = context.getResources().getColor(R.color.myred);

        colorList.add(colors4);

        int[] colors5 = new int[1];
        colors5[0] = context.getResources().getColor(R.color.myred);

        colorList.add(colors5);
    }

    private void initHeaders(Context context) {
        this.items = new String[5];
        this.items[0] = context.getResources().getString(R.string.graph_header1);
        this.items[1] = context.getResources().getString(R.string.graph_header2);
        this.items[2] = context.getResources().getString(R.string.graph_header3);
        this.items[3] = context.getResources().getString(R.string.graph_header4);
        this.items[4] = context.getResources().getString(R.string.graph_header5);
    }

    private void initLegendNames(Context context) {
        listNames = new ArrayList<>();

        ArrayList<String> first = new ArrayList<>();
        first.add(context.getResources().getString(R.string.graph_legend_bust));
        first.add(context.getResources().getString(R.string.graph_legend_waist));
        first.add(context.getResources().getString(R.string.graph_legend_hips));
        first.add(context.getResources().getString(R.string.graph_legend_right_bitseps));
        first.add(context.getResources().getString(R.string.graph_legend_left_bitseps));
        first.add(context.getResources().getString(R.string.graph_legend_right_hip));
        first.add(context.getResources().getString(R.string.graph_legend_left_hip));

        ArrayList<String> second = new ArrayList<>();
        second.add(context.getResources().getString(R.string.graph_legend_weight));
        second.add(context.getResources().getString(R.string.graph_legend_sm));
        second.add(context.getResources().getString(R.string.graph_legend_sj));

        ArrayList<String> third = new ArrayList<>();
        third.add(context.getResources().getString(R.string.graph_legend_sm));
        third.add(context.getResources().getString(R.string.graph_legend_sj));

        listNames.add(first);
        listNames.add(second);
        listNames.add(third);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null, true);

        return new CellStatisticViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        final CellStatisticViewHolder holder = (CellStatisticViewHolder) viewHolder;

        holder.tvHeader.setText(items[position]);
        holder.lineView.setBottomTextList(strList);
        holder.lineView.setFloatDataList(dataLists.get(position), false);
        holder.lineView.setTag(position);
        holder.lineView.setColorArray(colorList.get(position));

        // Нарисовать легенду для графика в position
        if (dataLists != null && dataLists.size() > 1) {
            if (dataLists.get(position).size() > 1) {
                if (holder.flowLayout.getChildCount() < 1) {
                    for (int j = 0; j < dataLists.get(position).size(); j++) {
                        final RelativeLayout layout = (RelativeLayout) mInflater.inflate(R.layout.item_legend_view, null, true);
                        layout.setTag(j);

                        layout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (filteredList == null)
                                    filteredList = new ArrayList<>();

                                int ind = (int)layout.getTag();

                                if (!graphItemArrayList.get(position).graphItems.get(ind).checked) {
                                    graphItemArrayList.get(position).graphItems.get(ind).checked = true;
                                    int count = ++graphItemArrayList.get(position).count;
                                    filteredList.removeAll(filteredList);
                                    int[] c = new int[count];
                                    int index = 0;
                                    int size = graphItemArrayList.get(position).graphItems.size();
                                    for (int i = 0; i < size; i++) {
                                        if (graphItemArrayList.get(position).graphItems.get(i).checked) {
                                            filteredList.add(graphItemArrayList.get(position).graphItems.get(i).chart);
                                            c[index++] = graphItemArrayList.get(position).graphItems.get(i).color;
                                        }
                                    }
                                    holder.lineView.setFloatDataList(filteredList, false);
                                    holder.lineView.setColorArray(c);
                                    (holder.flowLayout.getChildAt((Integer)layout.getTag())).setBackgroundColor(grayColor);
                                } else {
                                    graphItemArrayList.get(position).graphItems.get(ind).checked = false;
                                    int count = --graphItemArrayList.get(position).count;
                                    if (count > 0) {
                                        int[] c = new int[count];
                                        filteredList.removeAll(filteredList);
                                        int index = 0;
                                        int size = graphItemArrayList.get(position).graphItems.size();
                                        for (int i = 0; i < size; i++) {
                                            if (graphItemArrayList.get(position).graphItems.get(i).checked) {
                                                filteredList.add(graphItemArrayList.get(position).graphItems.get(i).chart);
                                                c[index++] = graphItemArrayList.get(position).graphItems.get(i).color;
                                            }
                                        }

                                        holder.lineView.setFloatDataList(filteredList, false);
                                        holder.lineView.setColorArray(c);
                                        (holder.flowLayout.getChildAt((Integer)layout.getTag())).setBackgroundColor(whiteColor);
                                    } else {
                                        filteredList.removeAll(filteredList);
                                        holder.lineView.setFloatDataList(dataLists.get(position), false);
                                        holder.lineView.setColorArray(colorList.get(position));
                                        (holder.flowLayout.getChildAt((Integer)layout.getTag())).setBackgroundColor(whiteColor);
                                    }
                                }
                            }
                        });

                        ImageView imageView = layout.findViewById(R.id.legend_img);
                        imageView.setBackgroundColor(colorList.get(position)[j]);

                        TextView textView = layout.findViewById(R.id.legend_text);
                        textView.setText(listNames.get(position).get(j));

                        holder.flowLayout.addView(layout);
                    }
                }
            }
        }
    }


    @Override
    public int getItemCount() {
        return items.length;
    }

    private static class CellStatisticViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeader;
        MyLineView lineView;
        FlowLayout flowLayout;

        CellStatisticViewHolder(View view) {
            super(view);

            tvHeader = view.findViewById(R.id.tvHeader);

            lineView = view.findViewById(R.id.line_view);
            lineView.setShowPopup(LineView.SHOW_POPUPS_NONE);
            lineView.setDrawDotLine(false);

            flowLayout = view.findViewById(R.id.flow_layout);
        }
    }

}
