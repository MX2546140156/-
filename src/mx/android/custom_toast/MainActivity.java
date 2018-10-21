package mx.android.custom_toast;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button 测试按钮;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		测试按钮 = (Button)findViewById(R.id.按钮);
		测试按钮.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				自定义Toast.getNewInstance(getApplicationContext());
				自定义Toast.show(R.string.hello_world, Toast.LENGTH_SHORT);
			}
		});
		
		测试按钮.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {

				自定义Toast.show("非字符串", Toast.LENGTH_LONG);
				return true;
			}
		});

	}
}
