package mx.android.custom_toast;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 自定义Toast工具类
 * @MX2546140156
 * @version 创建时间：2018年10月22日  01:00
 */
public class 自定义Toast extends Toast {

	/** 上下文对象 */
	private static Context 文本对象;
	/**  Toast对象 */
	private static 自定义Toast Toast对象;
	/**  Toast中显示的文本 */
	private static TextView 显示文本;
	
	/**
	 * 获得toast的单例实例，在Application初始化的时候使用
	 * @param context
	 */
	public synchronized static void getNewInstance(Context context){
		if(Toast对象 == null){
			文本对象 = context;
			Toast对象 = new 自定义Toast(文本对象);
		}
	}
	
	/**
	 * 单例模式
	 * @param context
	 */
	private 自定义Toast(Context context) {
		super(context);
		initView();
	}
	
	/**
	 * 重新设置布局
	 * @param context
	 */
	private void initView(){
		DisplayMetrics displayMetrics = 文本对象.getResources().getDisplayMetrics();
		int padding = ((int)displayMetrics.density * 10);
		显示文本 = new TextView(文本对象);
		显示文本.setBackgroundResource(R.drawable.bg_toast);
		//设置最小宽度
		显示文本.setMinWidth((int)(displayMetrics.density * 100));
		//设置最大宽度
		显示文本.setMaxWidth((int)(displayMetrics.widthPixels - displayMetrics.density * 100));
		//设置内边距
		显示文本.setPadding(padding, padding, padding, padding);
		//设置对其方式
		显示文本.setGravity(Gravity.CENTER);
		//设置字体颜色
		显示文本.setTextColor(文本对象.getResources().getColor(android.R.color.black));
		//设置新展示样式
		setView(显示文本);
	}
	
	/**
	 * 显示toast
	 * @param message
	 * @param duruation 显示的时长
	 */
	public static void show(int messageId, int duruation){
		if(显示文本 == null){
			throw new NullPointerException("自定义Toast is Null");
		}
		显示文本.setText(messageId);
		Toast对象.setDuration(duruation);
		Toast对象.show();
	}
	
	/**
	 * 显示toast
	 * @param message
	 * @param duruation 显示的时长
	 */
	public static void show(String message, int duruation){
		if(显示文本 == null){
			throw new NullPointerException("自定义Toast is Null");
		}
		显示文本.setText(message);
		Toast对象.setDuration(duruation);
		Toast对象.show();
	}
}

