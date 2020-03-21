
<aside>
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">
			<li><a class="active" href="index.jsp"> <i
					class="fa fa-dashboard"></i> <span>Dashboard</span>
			</a></li>



			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>User</span>
			</a>
				<ul class="sub">
					
					<li><a href="${pageContext.request.contextPath}/StudentRegistration?flag=searchUserForAdmin">Search User</a></li>
				</ul></li>

			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Category</span>
			</a>
				<ul class="sub">
					<li><a href="addCategory.jsp">Add Category</a></li>
					<li><a
						href="${pageContext.request.contextPath}/Category?flag=searchCategory">Search
							Category</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Sub Category</span>
			</a>
				<ul class="sub">
					<li><a
						href="${pageContext.request.contextPath}/SubCategory?flag=searchCategory">Add
							Sub Category</a></li>
					<li><a
						href="${pageContext.request.contextPath}/SubCategory?flag=searchSubCategory">Search
							Sub Category</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Medium</span>
			</a>
				<ul class="sub">
					<li><a
						href="${pageContext.request.contextPath}/Medium?flag=searchAcademicCategory">Add
							Medium</a></li>
					<li><a
						href="${pageContext.request.contextPath}/Medium?flag=searchMedium">Search
							Medium</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Standard</span>
			</a>
				<ul class="sub">
					<li><a
						href="${pageContext.request.contextPath}/Standard?flag=searchAcademicCategory">Add
							Standard</a></li>
					<li><a
						href="${pageContext.request.contextPath}/Standard?flag=searchStandard">Search
							Standard</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Academic Subject</span>
			</a>
				<ul class="sub">
					<li><a
						href="${pageContext.request.contextPath}/AcademicSubject?flag=searchAcademicCategory">Add
							Academic Subject</a></li>
					<li><a
						href="${pageContext.request.contextPath}/AcademicSubject?flag=searchAcademicSubject">Search
							Academic Subject</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Non Academic Subject</span>
			</a>
				<ul class="sub">
					<li><a
						href="${pageContext.request.contextPath}/NonAcademicSubject?flag=searchNonAcademicCategory">Add
							Non Academic Subject</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NonAcademicSubject?flag=searchNonAcademicSubject">Search
							Non Aca. Subject</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>City</span>
			</a>
				<ul class="sub">
					<li><a href="addCity.jsp">Add City</a></li>
					<li><a
						href="${pageContext.request.contextPath}/City?flag=searchCity">Search
							City</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Area</span>
			</a>
				<ul class="sub">
					<li><a
						href="${pageContext.request.contextPath}/Area?flag=searchCity">Add
							Area</a></li>
					<li><a
						href="${pageContext.request.contextPath}/Area?flag=searchArea">Search
							Area</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Complain</span>
			</a>
				<ul class="sub">
					<li><a
						href="${pageContext.request.contextPath}/Complain?flag=searchComplain">Search
							Complain</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Feedback</span>
			</a>
				<ul class="sub">
					<li><a
						href="${pageContext.request.contextPath}/Feedback?flag=searchFeedback">Search
							Feedback</a></li>
				</ul></li>



		</ul>
		<!-- sidebar menu end-->
	</div>
</aside>