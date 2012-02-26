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
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.titles_sse,
				NewsTitle_sseActivity.GetNewsTitleList()));// 设置Adapter适配器
		ListView titlesUI = getListView();// 从文件xml文件中生成ListView
		titlesUI.setTextFilterEnabled(true);
		titlesUI.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//long newsId = getSelectedItemId();
				//System.out.println(id);
				setListAdapter(new ArrayAdapter<String>(
						TitlesViewActivity.this, R.layout.titles_sse,
						NewsCon_sseActivity.GetNewsConList((int)id)));
				ListView contentUI = getListView();// 从文件xml文件中生成ListView
				contentUI.setTextFilterEnabled(true);
				// ContentViewActivity.ACTIVITY_SERVICE;
			}
		});
	}
}
