package title.sse.edu.cn;
import content.sse.edu.cn.NewsCon_sseActivity;
import title.sse.edu.cn.R;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
public class TitlesViewActivity extends ListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//继承父类方法
		setListAdapter(new ArrayAdapter<String>(this, R.layout.titles_sse,
				NewsTitle_sseActivity.GetNewsTitleList()));// 设置Adapter适配器
		ListView titlesUI = getListView();// 从文件xml文件中生成ListView
		titlesUI.setTextFilterEnabled(true);
		titlesUI.setOnItemClickListener(new OnItemClickListener() {//添加监听器
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				setListAdapter(new ArrayAdapter<String>(//若item被点击，则会触发事件，使得跳转到重新生成的ListView
						TitlesViewActivity.this, R.layout.titles_sse,
						NewsCon_sseActivity.GetNewsConList((int)id)));
				ListView contentUI = getListView();// 从文件xml文件中生成ListView
				contentUI.setTextFilterEnabled(true);
			}
		});
	}
}
