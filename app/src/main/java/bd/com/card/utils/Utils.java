package bd.com.card.utils;

import android.content.Context;

/**
 * Description : <Content><br>
 * CreateTime : 2016/7/30 15:55
 *
 * @author KevinLiu
 * @version <v1.0>
 * @Editor : KevinLiu
 * @ModifyTime : 2016/7/30 15:55
 * @ModifyDescription : <Content>
 */
public class Utils {

    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int screenWidth(Context context){
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int screenHeight(Context context){
        return context.getResources().getDisplayMetrics().heightPixels;
    }

}
