package tom.androidchart2;

import android.content.Context;
import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Utils {

    public static String DateToString(Date strDate, String format) {

        if (strDate != null) {
            DateFormat f = new SimpleDateFormat(format);
            return f.format(strDate);
        }
        else
            return "";
    }

    public static String TrimDateTime(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy");
        Date str = null;
        try {
            str = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return DateToString(str, "dd.MM.yy");
//        String res = date.substring(0, date.indexOf(" "));
//        return res;
    }

    public static String readTextFromRaw(Context context, int resourceId) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = null;
            try {
                InputStream inputStream = context.getResources().openRawResource(resourceId);
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append("\r\n");
                }
            } finally {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } catch (Resources.NotFoundException nfex) {
            nfex.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
