<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="i18n/board"/>
<%@ include file="/WEB-INF/views/fragment/head.jsp" %>
<%@ include file="/WEB-INF/views/fragment/nav.jsp" %>
<div class="container">
   <div class="pg-opt">
        <div class="row">
            <div class="col-md-6 pc">
                <h2><fmt:message key="WRITE_NEW_ARTICLE"/></h2>
            </div>
            <div class="col-md-6">
                <ol class="breadcrumb">
                    <li><fmt:message key="BOARD"/></li>
                    <li class="active"><fmt:message key="WRITE_NEW_ARTICLE"/></li>
                </ol>
            </div>
        </div>
    </div>
   <div class="content">
   <form action="<c:url value='/board/write'/>" method="post" enctype="multipart/form-data" class="form-horizontal">
   
   <div class="form-group">
      <label class="control-label col-sm-2" for="name"><fmt:message key="WRITER"/></label>
      <div class="col-sm-2">
        <input type="text" name="memberId" id="memberId" value="${sessionScope.name}" ${!empty sessionScope.name ? "readonly" : "" } class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="title"><fmt:message key="SUBJECT"/></label>
      <div class="col-sm-8">
        <input type="text" name="title" id="title" class="form-control" required>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="content"><fmt:message key="CONTENT"/></label>
      <div class="col-sm-8">
        <textarea name="content" rows="10" cols="100" class="form-control"></textarea>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="photo"><fmt:message key="FILE"/></label>
      <div class="col-sm-8">
        <input type="file" id="i_file" name="file"><span id="droparea" class="help-block"><fmt:message key="FILESIZE_ERROR"/></span>
      </div>
    </div>
    <div class="form-group">
       <div class="col-sm-offset-2 col-sm-8">
         <input type="hidden" name="boardType" value="community">
         <input type="submit" id="i_submit" class="btn btn-info" value="<fmt:message key="SAVE"/>"> <input type="reset" class="btn btn-info" value="<fmt:message key="CANCEL"/>">
      </div>
   </div>
   </form>
   </div>
</div>
<%@ include file="/WEB-INF/views/fragment/footer.jsp" %>