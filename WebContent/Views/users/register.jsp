<jsp:include page="../layout/header.jsp" />

<div class="row">
	<div class="col-xs-12">
		<h1>Register</h1>
	</div>
</div>
<div class="row">
	<div class="col-xs-4">
		<form role="form" action="../user/register" method="post">
			<div class="form-group">
				<label>First name</label> <input type="text" class="form-control"
					name="firstName" placeholder="Enter first name">
			</div>
			<div class="form-group">
				<label>Last name</label> <input type="text" class="form-control"
					name="lastName" placeholder="Enter last name">
			</div>
			<div class="form-group">
				<label>Email address</label> <input type="email"
					class="form-control" name="email" placeholder="Enter email">
			</div>
	</div>
	<div class="col-xs-4 col-xs-offset-1">
		<div class="form-group">
			<label>Password</label> <input type="password" class="form-control"
				name="password1" placeholder="Enter password">
		</div>
		<div class="form-group">
			<label>Password Again</label> <input type="password"
				class="form-control" name="password2"
				placeholder="Re enter password">
		</div>
		<button type="submit" class="btn btn-sm btn-primary"
			style="margin-top: 27px; width: 100px;">Submit</button>
		</form>
	</div>
</div>

<jsp:include page="../layout/footer.jsp" />