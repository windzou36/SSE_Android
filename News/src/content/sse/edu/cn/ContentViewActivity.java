package content.sse.edu.cn;

import title.sse.edu.cn.R;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContentViewActivity extends ListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.titles_sse,
				 NewsCon_sseActivity.GetNewsConList(3)));// 设置Adapter适配器
		// System.out.println(NewsCon_sseActivity.GetNewsConList(0)[0]);
		ListView contentUI = getListView();// 从文件xml文件中生成ListView
		contentUI.setTextFilterEnabled(true);
	}

//	public String[] GetContent(int titleId) {
//		String[] newContent = {""};// 新内容
//		String[] content = null;
//   
//		content = NewsCon_sseActivity.GetNewsConList(titleId);
//		System.out.println(content.length);
//		// 新内容，很可能包含null
//		int counter = 0;// 是个计数使得把content实际内容渠道newContent中
//		if (content.length == 0) {
//			newContent[0] = "糟糕,获取新闻出错啦!";
//		} else {
//			for (String str : content) {
//				if (!(str == null) || !(content[1].equals(""))) {// 过滤null值
//					newContent[counter] = str;
//					counter++;
//				} else {
//					break;
//				}
//
//			}
//		}
//		System.out.println(newContent.length);
//		return newContent;
//	}
}