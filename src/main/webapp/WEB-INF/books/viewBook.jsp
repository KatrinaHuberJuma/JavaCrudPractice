<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container"><table class="table">
  <thead>
    <tr>
      <th scope="col">Title</th>
      <th scope="col">Language</th>
      <th scope="col">Number of pages</th>
      <th scope="col">Description</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th><c:out value="${book.title}"/></th>
      <td><c:out value="${book.description}"/></td>
      <td><c:out value="${book.language}"/></td>
      <td><c:out value="${book.numberOfPages}"/></td>
    </tr>
  </tbody>
</table>
</div>






</body>
</html>