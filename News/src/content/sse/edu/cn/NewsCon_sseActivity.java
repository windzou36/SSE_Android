package content.sse.edu.cn;


import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;

public class NewsCon_sseActivity extends Activity  {
	/** Called when the activity is first created. */
	private static final String serviceNameSpace = "http://sseNews";
	private static final String GetNewsTitleList = "GetNewsContList";
	private static final String serviceURL = "http://192.168.1.89:8080/axis2/services/NewsContent_sse";

	public static List<String> GetNewsConList(int titleId) {
		//String[] Content=null;
		Vector<String> result = null;
		SoapObject request = new SoapObject(serviceNameSpace, GetNewsTitleList);
	    request.addProperty("titleId", titleId);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.bodyOut = request;
		envelope.setOutputSoapObject(request);
		HttpTransportSE ht = new HttpTransportSE(serviceURL);
		ht.debug = true;
	try{
			ht.call(serviceNameSpace  +"/"+ GetNewsTitleList, envelope);
			 result = (Vector<String>) envelope.getResponse();
		//	 result.get(0).
//		//	int counter = result.size();
//			//int arrayCount=0;//方便把result结果赋给Content
//			 Content = new String[counter];
//			for (int index = 0; index < counter; index++) {
//				if(!(result.get(index)== null)){
//					if(!(result.get(index).toString().equals(""))){
//				 Content[index-arrayCount] = result.get(index).toString();
//					}
//					else{
//						arrayCount++;
//					}
//				}
//				else{
//					arrayCount++;
//				}
//			}
//			  Collection<String> c=new Vector(2);
//			    c.add(null);
//			    c.add("");
//			    result.removeAll(c);
	} catch (Exception e) {
		System.out.println(("从webservice获取信息出错！"));
	}
		return  result;
	}
//	 public static void main(String args[]){
//		List<String> news=null;
//		 news=GetNewsConList(3);
//		
//		 for(String list:news){
//			
//			 System.out.println(list);
//		 }
//	 }
}
