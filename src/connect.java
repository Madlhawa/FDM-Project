import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.*;

public class connect {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		OkHttpClient client = new OkHttpClient();

		String graduateTerm = "FALL";
		String reportedPost = "Seeking Employment (Accepted Offer)";
		String reportedIntern = "Unreported";
		String offerType = "JOB";
		String Offer_Status = "true";
		String lawRelated = "0";
		String totalOnCamputRecruit = "0";
		String totalInformationSession = "0";
		String totalConsutlingSession = "1";
		

		MediaType mediaType = MediaType.parse("text/plain");
		RequestBody body = RequestBody.create(mediaType,
				"{\r\n        \"Inputs\": {\r\n\"input1\":\r\n[\r\n{\r\n'graduateTerm': \"'" + graduateTerm
						+ "'\",\r\n'reportedPost': \"'"+reportedPost+"'\","
						+ "\r\n'reportedIntern': \"'"+reportedIntern+"'\",\r\n'offerType': \"'"+offerType+"'\",\r\n'Offer_Status': \""+Offer_Status+"\",\r\n'lawRelated': \""+lawRelated+"\",\r\n'totalOnCamputRecruit': \""+totalOnCamputRecruit+"\","
						+ "\r\n'totalInformationSession': \""+totalInformationSession+"\",\r\n'totalConsutlingSession': \""+totalConsutlingSession+"\",\r\n}\r\n],\r\n},\r\n\"GlobalParameters\":{\r\n}\r\n}\r\n");
		Request request = new Request.Builder().url(
				"https://ussouthcentral.services.azureml.net/workspaces/b9e651a6dc9749abba5b2582d59de45e/services/575aafe9836c4056b80bd541a5ed428a/execute?api-version=2.0&format=swagger")
				.post(body).addHeader("Content-Type", "application/json")
				.addHeader("Authorization",
						"Bearer V9OOVO2dIUtc+sy/oLYFdIAgbKKqICEz/RilvPHwgB9rH3eDEVq0D1PGQwHKP7WCvApVZV9rYLRaC40axlslkQ==")
				.addHeader("Cache-Control", "no-cache")
				.addHeader("Postman-Token", "724a2f9e-c02c-4351-86a4-aa97d0014a08").build();

		Response response = client.newCall(request).execute();
		
		String ss = response.body().string().toString();
		JSONObject obj1 = new JSONObject(ss);
		
		JSONObject obj2 = new JSONObject(obj1.get("Results").toString());
		String output1 = obj2.get("output1").toString();
		JSONObject obj3 = new JSONObject(output1.substring(1, output1.length()-1));
		
		String scoredLabels = (String) obj3.get("Scored Labels"); 
		String Probabilities = (String) obj3.get("Scored Probabilities");
		
		System.out.println(scoredLabels+" | "+Probabilities);
	}

}
