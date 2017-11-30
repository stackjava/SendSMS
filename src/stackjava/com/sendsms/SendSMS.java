package stackjava.com.sendsms;

import org.smslib.Library;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;

public class SendSMS {
	public static void main(String[] args) throws Exception {

		System.out.println("stackjava.com: send sms by Java.");
		System.out.println(Library.getLibraryDescription());
		System.out.println("Version: " + Library.getLibraryVersion());
		// SerialModemGateway gateway = new SerialModemGateway(id, comPort,
		// baudRate, manufacturer, model)
		SerialModemGateway gateway = new SerialModemGateway("model.com5", "COM5", 115200, null, null);
		gateway.setInbound(true);
		gateway.setOutbound(true);
		Service.getInstance().addGateway(gateway);
		Service.getInstance().startService();
		System.out.println();
		System.out.println("Thong tin modem:");
		System.out.println("Nha san xuat: " + gateway.getManufacturer());
		System.out.println("Model: " + gateway.getModel());
		System.out.println("Serial No: " + gateway.getSerialNo());
		System.out.println("SIM IMSI: " + gateway.getImsi());
		System.out.println("Signal Level: " + gateway.getSignalLevel() + " dBm");
		System.out.println();

		String message = "stackjava.com \n demo send sms trong Java voi smslib";

		// bạn thay xxx bằng số điện thoại người nhận
		// lưu ý: số điện thoại có định dạng +mã quốc gia + sdt
		// Ví dụ: số điện thoại của mình là 01644444444 thì mình sẽ để là
		// +841644444444
		String sdt = "xxx";

		OutboundMessage msg = new OutboundMessage(sdt, message);
		Service.getInstance().sendMessage(msg);
		System.out.println(msg);
		Service.getInstance().stopService();
		System.out.println("Finish!");

	}

}
