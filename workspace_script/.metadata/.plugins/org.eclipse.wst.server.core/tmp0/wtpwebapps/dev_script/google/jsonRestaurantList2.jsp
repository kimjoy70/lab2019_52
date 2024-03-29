<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.google.gson.*, com.vo.RestaurantVO" %>    
<%@ page import="com.util.DBConnectionMgr, java.sql.*" %>    
<%@ page import="oracle.jdbc.OracleCallableStatement,oracle.jdbc.internal.OracleTypes" %>    
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
    List<Map<String,Object>> resList = new ArrayList<>();
    StringBuilder sql = new StringBuilder();
	try{
		con = DBConnectionMgr.getConnection();
		sql.append("SELECT res_name, lat, lng FROM restaurant");
		pstmt = con.prepareStatement(sql.toString());
        rs = pstmt.executeQuery(sql.toString());
        Map<String,Object> rMap = null;
        while(rs.next()){
        	rMap = new HashMap<String,Object>();
        	rMap.put("res_name", rs.getString("res_name"));
        	rMap.put("lat", rs.getDouble("lat"));
        	rMap.put("lng", rs.getDouble("lng"));
        	resList.add(rMap);
        }
	}catch(Exception e){
		e.printStackTrace();
	}
	//out.clear();
	Gson g = new Gson();
	String res = g.toJson(resList);
	//JsonParser parser = new JsonParser();
	//JsonArray array = parser.parse(rec).getAsJsonArray();
/* 	for(JsonElement element : array)
	{
	  out.print(element);
	} */
	out.print(res);
%>