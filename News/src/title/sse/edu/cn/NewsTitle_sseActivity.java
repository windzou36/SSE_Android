package title.sse.edu.cn;

import java.util.Vector;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class NewsTitle_sseActivity {
	/** Called when the activity is first created. */
	private static final String serviceNameSpace = "http://sseNews";
	private static final String GetNewsTitleList = "GetNewsTitleList";
	private static final String serviceURL = "http://192.168.1.89:8080/axis2/services/NewsTitle_sse";

	public static Vector<String> GetNewsTitleList() {
		// String[] titles=new String[20];
		Vector<String> result = null;
		SoapObject request = new SoapObject(serviceNameSpace, GetNewsTitleList);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.bodyOut = request;
		envelope.setOutputSoapObject(request);
		HttpTransportSE ht = new HttpTransportSE(serviceURL);
		ht.debug = true;
		try {
			ht.call(serviceNameSpace + "/" + GetNewsTitleList, envelope);
			result = (Vector<String>) envelope.getResponse();
			// int counter = result.size();
			// titles = new String[counter];
			// for (int index = 0; index < counter; index++) {
			// titles[index] = result.get(index).toString();
			// }
		} catch (Exception e) {
			System.out.println(("从webservice获取信息出错！"));
		}
		return result;
	}
	// public static void main(String args[]){
	// String[] news=null;
	// news=GetNewsTitleList();
	//
	// for(String list:news){
	// if(!(list == null))
	// System.out.println(list);
	// }
	// }
}
