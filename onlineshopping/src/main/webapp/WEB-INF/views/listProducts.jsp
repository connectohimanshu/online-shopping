<div class="container">

	<div class="row">

		<!-- would like to display sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- would like to display actual products -->
		<div class="col-md-9">

			<!-- Added beadcrumb component -->
			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true}">
						<ol class="breadcrumb" style="margin-top: 30px">
							<li><a href="${contextRoot}/home/">Home</a></li>
							<li class="active" style="margin-left: 15px">All Products</li>
						</ol>
					</c:if>


					<c:if test="${userClickCategoryProducts==true}">
						<ol class="breadcrumb" style="margin-top: 30px">

							<li><a href="${contextRoot}/home/">Home</a></li>
							<li class="active" style="margin-left: 15px">Category</li>
							<li class="active" style="margin-left: 15px">${category.name}</li>

						</ol>
					</c:if>
				</div>


			</div>
		</div>

	</div>

</div>