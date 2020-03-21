<%@ taglib prefix="cc" uri="http://java.sun.com/jstl/core_rt"%>
<header class="top_panel_wrap bg_tint_dark">
	<div class="menu_user_wrap">
		<div class="content_wrap clearfix">
			<div class="menu_user_area menu_user_right menu_user_nav_area">

				<ul id="menu_user" class="menu_user_nav">
					<cc:if test="${empty sessionScope.usertype }">

						<li class="menu_user_bookmarks"><a href="#" class=""
							title="Show bookmarks">Sign Up</a>
							<ul class="bookmarks_list">
								<li><a href="teacherRegistration.jsp" class="">Teacher<span
										class="bookmarks_delete icon-cancel-1"
										title="Delete this bookmark"></span></a></li>
								<li><a href="studentRegistration.jsp" class="">Student<span
										class="bookmarks_delete icon-cancel-1"
										title="Delete this bookmark"></span></a></li>
							</ul></li>
					</cc:if>








					<cc:if test="${not empty sessionScope.usertype }">
						<li class="menu_user_login"><a href="LoginFilter?flag=logout"
							class="popup_link popup_login_link">Logout</a></li>
					</cc:if>


					<cc:if test="${empty sessionScope.usertype }">
						<li class="menu_user_login"><a href="admin/login.jsp"
							class="popup_link popup_login_link">Login</a></li>
					</cc:if>

					<cc:if test="${not empty sessionScope.usertype}">
						<li class="menu_user_login"><a href='#'
							class="popup_link popup_login_link"><span class="username">
									<%
										out.print((String) session.getAttribute("userName"));
									%>
							</span></a></li>
					</cc:if>

					<cc:if test="${not empty sessionScope.usertype }">

						<cc:if test="${sessionScope.usertype eq 'Student'}">
							<li class="menu_user_login"><a
								href="${pageContext.request.contextPath}/StudentRegistration?flag=editStudentRegistration"
								class="popup_link popup_login_link">Edit Profile</a></li>
						</cc:if>
					</cc:if>

					<cc:if test="${not empty sessionScope.usertype }">

						<cc:if test="${sessionScope.usertype eq 'Teacher'}">
							<li class="menu_user_login"><a
								href="${pageContext.request.contextPath}/TeacherRegistration?flag=editTeacherRegistration"
								class="popup_link popup_login_link">Edit Profile</a></li>
						</cc:if>
					</cc:if>



				</ul>
				<!-- <div id="popup_login" class="popup_wrap popup_login bg_tint_light">
							<a href="#" class="popup_close"></a>
							<div class="form_wrap">
								<div class="form_left">
									<form action="http://education.themerex.net/wp-login.php"
										method="post" name="login_form" class="popup_form login_form">
										<input type="hidden" name="redirect_to"
											value="http://education.themerex.net">
										<div
											class="popup_form_field login_field iconed_field icon-user-2">
											<input type="text" id="log" name="log" value=""
												placeholder="Login or Email">
										</div>
										<div
											class="popup_form_field password_field iconed_field icon-lock-1">
											<input type="password" id="password" name="pwd" value=""
												placeholder="Password">
										</div>
										<div class="popup_form_field remember_field">
											<a
												href="http://education.themerex.net/my-account/lost-password/"
												class="forgot_password">Forgot password?</a> <input
												type="checkbox" value="forever" id="rememberme"
												name="rememberme"> <label for="rememberme">Remember
												me</label>
										</div>
										<div class="popup_form_field submit_field">
											<input type="submit" class="submit_button" value="Login">
										</div>
									</form>
								</div>
								<div class="form_right">
									<div class="login_socials_title">You can login using your
										social profile</div>
									<div class="login_socials_list sc_socials sc_socials_size_tiny">
										<div class="sc_socials_item">
											<a href="#" target="_blank"
												class="social_icons social_facebook"
												style="background-image: url(img/facebook.png);"><span
												class="sc_socials_hover"
												style="background-image: url(img/facebook.png);"></span></a>
										</div>
										<div class="sc_socials_item">
											<a href="#" target="_blank"
												class="social_icons social_twitter"
												style="background-image: url(img/twitter.png);"><span
												class="sc_socials_hover"
												style="background-image: url(img/twitter.png);"></span></a>
										</div>
										<div class="sc_socials_item">
											<a href="#" target="_blank" class="social_icons social_gplus"
												style="background-image: url(img/gplus.png);"><span
												class="sc_socials_hover"
												style="background-image: url(img/gplus.png);"></span></a>
										</div>
									</div>
									<div class="login_socials_problem">
										<a href="#">Problem with login?</a>
									</div>
									<div class="result message_block"></div>
								</div>
							</div>
							/.login_wrap
						</div> /.popup_login</li> -->


			</div>
			<div class="menu_user_area menu_user_left menu_user_contact_area">
				Contact me on +91 999 808 14 80 <a
					href="/cdn-cgi/l/email-protection#b9caccc9c9d6cbcdf9cdd1dcd4dccbdcc197d7dccd"><span
					class="__cf_email__"
					data-cfemail="196a6c6969766b6d596d717c747c6b7c6137777c6d"> <!-- [email&#160;dhruvpatel25895@gmail.com] -->
				</span> <script data-cfhash='f9e31' type="text/javascript">
					/* <![CDATA[ */!function() {
						try {
							var t = "currentScript" in document ? document.currentScript
									: function() {
										for (var t = document
												.getElementsByTagName("script"), e = t.length; e--;)
											if (t[e]
													.getAttribute("data-cfhash"))
												return t[e]
									}();
							if (t && t.previousSibling) {
								var e, r, n, i, c = t.previousSibling, a = c
										.getAttribute("data-cfemail");
								if (a) {
									for (e = "", r = parseInt(a.substr(0, 2),
											16), n = 2; a.length - n; n += 2)
										i = parseInt(a.substr(n, 2), 16) ^ r,
												e += String.fromCharCode(i);
									e = document.createTextNode(e),
											c.parentNode.replaceChild(e, c)
								}
								t.parentNode.removeChild(t);
							}
						} catch (u) {
						}
					}()/* ]]> */
				</script></a>
			</div>
		</div>
	</div>

	<div class="menu_main_wrap logo_left">
		<div class="content_wrap clearfix">
			<div class="logo">
				<a href="http://education.themerex.net"><img src="img/logo1.png"
					class="logo_main" alt=""><img src="img/logo1.png"
					class="logo_fixed" alt=""></a>
			</div>

			<!-- <div class="search_wrap search_style_regular search_ajax"
				title="Open/close search form">
				<a href="#" class="search_icon icon-search-2"></a>
				<div class="search_form_wrap">
					<form role="search" method="get" class="search_form"
						action="http://education.themerex.net/">
						<button type="submit" class="search_submit icon-zoom-1"
							title="Start search"></button>
						<input type="text" class="search_field" placeholder="" value=""
							name="s" title="" />
					</form>
				</div>
				<div class="search_results widget_area bg_tint_light">
					<a class="search_results_close icon-delete-2"></a>
					<div class="search_results_content"></div>
				</div>
			</div>
			<a href="#" class="menu_main_responsive_button icon-menu-1"></a> -->

			<nav role="navigation" class="menu_main_nav_area">
				<ul id="menu_main" class="menu_main_nav">
					<li id="menu-item-860"
						class="menu-item menu-item-type-post_type menu-item-object-page current-menu-item page_item page-item-5 current_page_item current-menu-ancestor current-menu-parent current_page_parent current_page_ancestor menu-item-has-children menu-item-860"><a
						href="index.jsp">Homepage</a></li>
					<li id="menu-item-179"
						class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-179"><a
						href="#">Features</a>
						<ul class="sub-menu">

							<li id="menu-item-791"
								class="menu-item menu-item-type-post_type menu-item-object-page menu-item-791"><a
								href="aboutMe.jsp">About Me</a></li>
							<li id="menu-item-54"
								class="menu-item menu-item-type-post_type menu-item-object-page menu-item-54"><a
								href="contactMe.jsp">Contact Me</a></li>
							<!-- <li id="menu-item-536"
								class="menu-item menu-item-type-post_type menu-item-object-page menu-item-536"><a
								href="typography.htm">FAQ</a></li> -->
							<li id="menu-item-829"
								class="menu-item menu-item-type-post_type menu-item-object-page menu-item-536"><a
								href="${pageContext.request.contextPath}/Complain?flag=searchAdmin">Complain</a></li>
							<cc:if test="${sessionScope.usertype eq 'Student'}">
								<li id="menu-item-829"
									class="menu-item menu-item-type-post_type menu-item-object-page menu-item-536"><a
									href="${pageContext.request.contextPath}/Feedback?flag=searchTeacherForFeedback">Feedback</a></li>
							</cc:if>
							<cc:if test="${sessionScope.usertype eq 'Teacher'}">
								<li id="menu-item-829"
									class="menu-item menu-item-type-post_type menu-item-object-page menu-item-536"><a
									href="${pageContext.request.contextPath}/Feedback?flag=searchRatingFromStudent">Feedback</a></li>
							</cc:if>
						</ul></li>
					<%-- <li id="menu-item-641"
						class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-641"><a
						href="courses-streampage.htm">Courses</a>
						<ul class="sub-menu">
							<cc:forEach items="${sessionScope.menuList }" var="i">
								<cc:choose>
									<cc:when test="${not empty i.value }">
										<li id="menu-item-1398"
											class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-1398"><a
											href="#">${i.key }</a>
											<ul class="sub-menu">
												<cc:forEach items="${i.value }" var="j">
													<li id="menu-item-1399"
														class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1399"><a
														href="all-learndash-courses.htm">${j.subCategoryName }</a></li>
												</cc:forEach>
											</ul></li>
									</cc:when>
									<cc:otherwise>
										<li id="menu-item-536"
											class="menu-item menu-item-type-post_type menu-item-object-page menu-item-536"><a
											href="typography.htm">${i.key }</a></li>
									</cc:otherwise>
								</cc:choose>
							</cc:forEach>
						</ul></li>
 --%>
					<cc:if test="${sessionScope.usertype eq 'Student'}">
						<li id="menu-item-179"
							class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-179"><a
							href="${pageContext.request.contextPath}/StudentRegistration?flag=searchStudentProfile">PROFILE</a></li>
					</cc:if>


					<cc:if test="${sessionScope.usertype eq 'Teacher'}">
						<li id="menu-item-179"
							class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-179"><a
							href="${pageContext.request.contextPath}/TeacherRegistration?flag=searchTeacherProfile">PROFILE</a></li>
					</cc:if>

					<cc:if test="${sessionScope.usertype eq 'Student'}">
						<li id="menu-item-829"
							class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-829">
							<a href="#">Requirement</a>
							<ul class="sub-menu">
								<li id="menu-item-1214"
									class="menu-item menu-item-type-post_type menu-item-object-lesson menu-item-1214"><a
									href="${pageContext.request.contextPath}/StudentRequirement?flag=search">Add
										Requirement</a></li>
								<li id="menu-item-1214"
									class="menu-item menu-item-type-post_type menu-item-object-lesson menu-item-1214"><a
									href="${pageContext.request.contextPath}/StudentRequirement?flag=searchStudentRequirement">View
										Requirement</a></li>
							</ul>
						</li>
					</cc:if>
					<cc:if test="${sessionScope.usertype eq 'Teacher'}">
						<li id="menu-item-829"
							class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-829">
							<a href="#">Requirement</a>
							<ul class="sub-menu">

								<li id="menu-item-1214"
									class="menu-item menu-item-type-post_type menu-item-object-lesson menu-item-1214"><a
									href="${pageContext.request.contextPath}/TeacherRequirement?flag=search">Add
										Requirement</a></li>
								<li id="menu-item-1214"
									class="menu-item menu-item-type-post_type menu-item-object-lesson menu-item-1214"><a
									href="${pageContext.request.contextPath}/TeacherRequirement?flag=searchTeacherRequirement">View
										Requirement</a></li>
								<li id="menu-item-1214"
									class="menu-item menu-item-type-post_type menu-item-object-lesson menu-item-1214"><a
									href="teacherQualification.jsp">Add Qualification</a></li>
								<li id="menu-item-1214"
									class="menu-item menu-item-type-post_type menu-item-object-lesson menu-item-1214"><a
									href="${pageContext.request.contextPath}/TeacherQualification?flag=searchTeacherQualification">View
										Qualification</a></li>



							</ul>
					</cc:if>
					<cc:if test="${sessionScope.usertype eq 'Teacher'}">
						<li id="menu-item-1214"
							class="menu-item menu-item-type-post_type menu-item-object-lesson menu-item-1214"><a
							href="${pageContext.request.contextPath}/TeacherRequirement?flag=appliedStudent">Applied
								Student </a></li>
					</cc:if>



					<cc:if test="${sessionScope.usertype eq 'Student'}">


						<li id="menu-item-829"
							class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-829"><a
							href="${pageContext.request.contextPath}/StudentRequirement?flag=searchDemoDetailsForStudent">Demo
								List</a></li>

					</cc:if>




					<%--  <cc:if test="${sessionScope.usertype eq 'Student'}">


					<li id="menu-item-829"
						class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-829"><a
						href="${pageContext.request.contextPath}/TeacherRegistration?flag=searchTeacher">Teacher</a></li>
						
						</cc:if> --%>


				</ul>
			</nav>


		</div>
	</div>

</header>
