package rpc;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;

import entity.Item;
/**
 * Servlet implementation class RecommendItem
 */
@WebServlet("/recommendation")
public class RecommendItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
//		JSONArray array = new JSONArray();
//		JSONObject obj1 = new JSONObject();
//		JSONObject obj2 = new JSONObject();
//		try {
//			obj1.put("name", "abcd");
//			obj1.put("address", "san francisco");
//			obj1.put("time", "011/01/2017");
//			
//			obj2.put("name", "1234");
//			obj2.put("address", "san jose");
//			obj2.put("time", "011/02/2017");
//			
//			array.put(obj1);
//			array.put(obj2);
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		
//		RpcHelper.writeJsonArray(response, array);
//		
		String userId = request.getParameter("user_id");
		double lat = Double.parseDouble(request.getParameter("lat"));
		double lon = Double.parseDouble(request.getParameter("lon"));
		
		algorithm.GeoRecommendation recommendation = new algorithm.GeoRecommendation();
		List<Item> items = recommendation.recommendItems(userId, lat, lon);
		
		JSONArray result = new JSONArray();
		try {
			for (Item item : items) {
				result.put(item.toJSONObject());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RpcHelper.writeJsonArray(response, result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
