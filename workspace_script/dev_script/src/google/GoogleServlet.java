package google;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.util.DBConnectionMgr;
import com.vo.RestaurantVO;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

@WebServlet(urlPatterns="/google/googleMap.do")
public class GoogleServlet extends HttpServlet {
	Logger logger = Logger.getLogger(GoogleServlet.class);
	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		logger.info("doService 호출 성공");
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
	    List<Map<String,Object>> resList = new ArrayList<>();
	    res.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = res.getWriter();
		try{
			con = DBConnectionMgr.getConnection();
			cstmt = con.prepareCall("{call proc_restaurant(?)}");
	        cstmt.registerOutParameter(1,OracleTypes.CURSOR);
	        cstmt.execute();
			OracleCallableStatement ocstmt = null;
	        ocstmt = (OracleCallableStatement)cstmt;
	        rs =  ocstmt.getCursor(1);
	        //RestaurantVO resVO = null;
	        Map<String,Object> rMap = null;
	        while(rs.next()){
	        	rMap = new HashMap<String,Object>();
	        	rMap.put("res_name", rs.getString("res_name"));
	        	rMap.put("lat", rs.getDouble("lat"));
	        	rMap.put("lng", rs.getDouble("lng"));
	        	resList.add(rMap);
	        }
	        Gson g = new Gson();
	        String str = g.toJson(resList);
	        //out.print(str);
	        req.setAttribute("resList", resList);
	        RequestDispatcher view = req.getRequestDispatcher("googleMapResult.jsp");
	        view.forward(req, res);
	        //session.setAttribute("recList", recList);
	        //res.sendRedirect("./googleMapResult.jsp");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public String generateState()
	{
	    SecureRandom random = new SecureRandom();
	    return new BigInteger(130, random).toString(32);
	}


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		doService(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		doService(req,res);
	}
}
