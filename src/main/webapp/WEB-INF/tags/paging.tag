<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ tag body-content="empty"%>
<%@ attribute name="totalPageCount" type="java.lang.Integer" required="true"%>
<%@ attribute name="nowPage" type="java.lang.Integer" required="true"%>
<%
	int totalPageBlock = (int)(Math.ceil(totalPageCount/5.0));
	int nowPageBlock = (int)Math.ceil(nowPage/5.0);
	int startPage = (nowPageBlock-1)*5+1;
	int endPage = 0;
	String contextPath = application.getContextPath();
	if(contextPath == null || contextPath.trim().equals("")){
		contextPath="";
	}
	if(totalPageCount > nowPageBlock*10){
		endPage = totalPageCount;
	} else{
		endPage = totalPageCount;
	}
	out.println("<nav aria-label=\"Page navigation\">");
	out.println("<ul class=\"pagination\">");
	if(nowPageBlock>1){
		out.print("<li>");
		out.print("<a href=\""+contextPath + "/cause/list/"+(startPage-1)+"\" aria-label=\"Previous\">");
		out.print("◀</a>");
		out.print("</li>");
	}
	for(int i=startPage; i<=endPage; i++){
		out.print(" ");
		if(i==nowPage){
			out.print("<li class=\"active\">");
			
		} else{
			out.print("<li>");
		}
		out.print("<a href=\""+contextPath+"/cause/list/"+(i)+"\">");
		out.print(i);
		out.print("</a>");
		out.print("</li>");
	}
	if(nowPageBlock<totalPageBlock){
		out.print("<li>");
		out.print("<a href=\""+contextPath+"/cause/list/"+(endPage+1)+"\" aria-label=\"Next\">");
		out.print("▶</a>");
		out.println("</li>");
	}
	out.println("</ul>");
	out.println("</nav>");
%>