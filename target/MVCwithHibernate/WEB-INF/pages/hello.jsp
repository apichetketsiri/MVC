<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<meta charset="utf-8">
	<title>Spring MVC Application</title>

	<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link href="http://twitter.github.io/bootstrap/assets/css/bootstrap.css" rel="stylesheet">
	<link href="http://twitter.github.io/bootstrap/assets/css/bootstrap-responsive.css" rel="stylesheet">
</head>

<body>

<div class="container">
	<div class="row">
		<div class="span8 offset2">
			<h1>Users</h1>
			<form action="#" th:action="@{/}" th:object="${user}" method="post">
				<table>
					<tr>
						<td>Name:</td>
						<td><input type="text" th:field="*{name}" /></td>

					</tr>
					<tr>
						<td>last name:</td>
						<td><input type="text" th:field="*{lastname}" /></td>

					</tr>
					<tr>
						<td>email:</td>
						<td><input type="text" th:field="*{email}" /></td>

					</tr>
					<tr>
						<td><button type="submit">Submit</button></td>
					</tr>
				</table>
			</form>
				</div>
			</div>

			<c:if test="${!empty users}">
				<h3>Users</h3>
				<table class="table table-bordered table-striped">
					<thead>
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>&nbsp;</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.lastName}, ${user.firstName}</td>
							<td>${user.email}</td>
							<td>
								<form action="delete/${user.id}" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Delete"/></form>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</div>

</body>
</html>