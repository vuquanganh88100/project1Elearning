<%@page pageEncoding="utf-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="nav.jsp"></jsp:include>
<div class="container">
    <div class="row mt-5">
        <h1>Create New Album</h1>
    </div>
    <div class="container mt-4">
        <%--@elvariable id="categoryDto" type=""--%>
        <f:form action="/study/admin/backend/save" method="post" enctype="multipart/form-data" modelAttribute="categoryDto">
            <div class="row">
                <div class="col">
                    <div class="form-floating mb-4">
                        <input type="text" class="form-control" id="courseName" name="courseName" placeholder="Album Name" required>
                        <label for="courseName">Tên khóa học</label>
                    </div>
                </div>

                <div class="col">
                    <div class="form-floating mb-4">
                        <input type="file" class="form-control" id="imageFile" name="imageFile">
                        <label for="imageFile">File</label>
                    </div>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-12 text-center">
                    <button type="submit" class="btn btn-primary">Create</button>
                </div>
            </div>
        </f:form>
    </div>
</div>