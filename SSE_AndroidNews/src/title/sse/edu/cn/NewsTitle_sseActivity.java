package title.sse.edu.cn;
import java.util.Vector;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
public class NewsTitle_sseActivity {
	/** Called when the activity is first created. */
	private static final String serviceNameSpace = "http://sseNews";//设置命名空间
	private static final String GetNewsTitleList = "GetNewsTitleList";//设置远程方法
	private static final String serviceURL = "http://192.168.1.89:8080/axis2/services/NewsTitle_sse";//设置服务的地址
	public static Vector<String> GetNewsTitleList() {
		Vector<String> result = null;//声明返回的结果
		SoapObject request = new SoapObject(serviceNameSpace, GetNewsTitleList);//新建request
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(//设置soap信封的版本
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.bodyOut = request;
		envelope.setOutputSoapObject(request);
		HttpTransportSE ht = new HttpTransportSE(serviceURL);//绑定服务地址
		ht.debug = true;
		try {
			ht.call(serviceNameSpace + "/" + GetNewsTitleList, envelope);//调用远程方法
			result = (Vector<String>) envelope.getResponse();//把返回的结果赋值给result
		} catch (Exception e) {
			System.out.println(("从webservice获取信息出错！"));//捕捉异常
		}
		return result;
	}
}
