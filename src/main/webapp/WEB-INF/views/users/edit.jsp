<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="/WEB-INF/views/_include/head-include.jsp" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- link href="resources\css\core.css" rel="stylesheet" /> -->

    <link rel="icon" href="resources/images/favicon.ico">

    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/dashboard.css" rel="stylesheet">

    <!-- jQuery -->
    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>

    <title>Budget Web Page</title>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="">Edit user</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="">Home</a></li>
				<li><a href="">Expenses</a></li>
				<li><a href="">Incomes</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Settings <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="categories?display">Categories</a></li>
						<li><a href="items?display">Items</a></li>
						<li><a href="users?display">Users</a></li>
						<li role="separator" class="divider"></li>
						<li class="dropdown-header">Nav header</li>
						<li><a href="#">Separated link</a></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
	</nav>

	<div class="container-fluid">
		<div class="row col-lg-4">
			<form:form class="form-horizontal" name="user" method="post" action="users/${user.id}" modelAttribute="user">
				<fieldset>

					<!-- Form Name -->
					<legend>Edit User ${user.id} / ${user.name} </legend>
					
					<form:input path="id" type="hidden"/>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="name">User Id</label>
						<div class="col-md-4">
							<form:input id="id" path="id" placeholder="User id" class="form-control input-md" required="" type="text" />
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="name">User name</label>
						<div class="col-md-4">
							<form:input id="name" path="name" placeholder="User name" class="form-control input-md" required="" type="text" />
							<form:errors path="name" />
						</div>
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="save">Save</label>
						<div class="col-md-4">
							<button id="save" name="save" class="btn btn-default">Save</button>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>

</body>
</html>