<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>User Profile Page - Ace Admin</title>

<meta name="description" content="3 styles with inline editable feature" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/jquery-ui.custom.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/jquery.gritter.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/select2.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/bootstrap-editable.min.css" />

<!-- text fonts -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/ace-skins.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/ace-rtl.min.css" />

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script
	src="${pageContext.request.contextPath }/assets/js/ace-extra.min.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
</head>

<body class="no-skin">
	<div id="navbar" class="navbar navbar-default          ace-save-state">
		<div class="navbar-container ace-save-state" id="navbar-container">
			<button type="button" class="navbar-toggle menu-toggler pull-left"
				id="menu-toggler" data-target="#sidebar">
				<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>

				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>

			<div class="navbar-header pull-left">
				<a href="/3rdteam01/admin/home.do" class="navbar-brand"> <small>
						<i class="fa fa-leaf"></i> Ace Admin
				</small>
				</a>
			</div>

			<div class="navbar-buttons navbar-header pull-right"
				role="navigation">
				<ul class="nav ace-nav">
					<li class="light-blue dropdown-modal"><a
						data-toggle="dropdown" href="#" class="dropdown-toggle"> <img
							class="nav-user-photo"
							src="${pageContext.request.contextPath }/assets/images/avatars/user.jpg"
							alt="Jason's Photo" /> <span class="user-info"> <small>Welcome,</small>
								${email }
						</span> <i class="ace-icon fa fa-caret-down"></i>
					</a>

						<ul
							class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a
								href="${pageContext.request.contextPath}/admin/user/detail.do?email=${email}">
									<i class="ace-icon fa fa-user"></i> Profile
							</a></li>

							<li class="divider"></li>

							<li><a
								href="${pageContext.request.contextPath }/user/logout.do"> <i
									class="ace-icon fa fa-power-off"></i> Logout
							</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<!-- /.navbar-container -->
	</div>

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.loadState('main-container')
			} catch (e) {
			}
		</script>

		<div id="sidebar"
			class="sidebar                  responsive                    ace-save-state">
			<script type="text/javascript">
				try {
					ace.settings.loadState('sidebar')
				} catch (e) {
				}
			</script>

			<div class="sidebar-shortcuts" id="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
					<button class="btn btn-success">
						<i class="ace-icon fa fa-signal"></i>
					</button>

					<button class="btn btn-info">
						<i class="ace-icon fa fa-pencil"></i>
					</button>

					<button class="btn btn-warning">
						<i class="ace-icon fa fa-users"></i>
					</button>

					<button class="btn btn-danger">
						<i class="ace-icon fa fa-cogs"></i>
					</button>
				</div>

				<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span> <span class="btn btn-info"></span>

					<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
				</div>
			</div>
			<!-- /.sidebar-shortcuts -->
			<ul class="nav nav-list">
				<li class=""><a
					href="${pageContext.request.contextPath }/admin/home.do"> <i
						class="menu-icon fa fa-tachometer"></i> <span class="menu-text">
							Dashboard </span>
				</a> <b class="arrow"></b></li>
				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-list"></i> <span class="menu-text">
							List </span> <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<li class=""><a
							href="${pageContext.request.contextPath }/admin/product/list.do">
								<i class="menu-icon fa fa-caret-right"></i> Product list
						</a> <b class="arrow"></b></li>
					</ul>
					<ul class="submenu">
						<li class=""><a
							href="${pageContext.request.contextPath }/admin/bill/list.do">
								<i class="menu-icon fa fa-caret-right"></i> Bill list
						</a> <b class="arrow"></b></li>
					</ul>
					<ul class="submenu">
						<li class=""><a
							href="${pageContext.request.contextPath }/admin/color/list.do">
								<i class="menu-icon fa fa-caret-right"></i> Color list
						</a> <b class="arrow"></b></li>
					</ul>
					<ul class="submenu">
						<li class=""><a
							href="${pageContext.request.contextPath }/admin/brand/list.do">
								<i class="menu-icon fa fa-caret-right"></i> Brand list
						</a> <b class="arrow"></b></li>
					</ul>
					<ul class="submenu">
						<li class=""><a
							href="${pageContext.request.contextPath }/admin/category/list.do">
								<i class="menu-icon fa fa-caret-right"></i> Category list
						</a> <b class="arrow"></b></li>
					</ul></li>

				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-pencil-square-o"></i> <span
						class="menu-text"> Forms </span> <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<li class=""><a
							href="${pageContext.request.contextPath }/admin/product/new.do">
								<i class="menu-icon fa fa-caret-right"></i> Form new product
						</a> <b class="arrow"></b></li>
					</ul>
					<ul class="submenu">
						<li class=""><a
							href="${pageContext.request.contextPath }/admin/bill/new.do">
								<i class="menu-icon fa fa-caret-right"></i> Form new Bill
						</a> <b class="arrow"></b></li>
					</ul>
					<ul class="submenu">
						<li class=""><a href="${pageContext.request.contextPath }/admin/brand/new.do"> <i
								class="menu-icon fa fa-caret-right"></i> Form new Brand
						</a> <b class="arrow"></b></li>
					</ul>
					<ul class="submenu">
						<li class=""><a href="${pageContext.request.contextPath }/admin/category/new.do"> <i
								class="menu-icon fa fa-caret-right"></i> Form new Category
						</a> <b class="arrow"></b></li>
					</ul>
					<ul class="submenu">
						<li class=""><a href="${pageContext.request.contextPath }/admin/color/new.do"> <i
								class="menu-icon fa fa-caret-right"></i> Form new Color
						</a> <b class="arrow"></b></li>
					</ul>
					</li>
			</ul>
			<!-- /.nav-list -->

			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i id="sidebar-toggle-icon"
					class="ace-icon fa fa-angle-double-left ace-save-state"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>
		</div>

		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
						</li>

						<li><a href="#">Product List</a></li>
						<li class="active">Product Detail</li>
					</ul>
					<!-- /.breadcrumb -->

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="Search ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- /.nav-search -->
				</div>

				<div class="page-content">
					<div class="ace-settings-container" id="ace-settings-container">
						<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
							id="ace-settings-btn">
							<i class="ace-icon fa fa-cog bigger-130"></i>
						</div>

						<div class="ace-settings-box clearfix" id="ace-settings-box">
							<div class="pull-left width-50">
								<div class="ace-settings-item">
									<div class="pull-left">
										<select id="skin-colorpicker" class="hide">
											<option data-skin="no-skin" value="#438EB9">#438EB9</option>
											<option data-skin="skin-1" value="#222A2D">#222A2D</option>
											<option data-skin="skin-2" value="#C6487E">#C6487E</option>
											<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
										</select>
									</div>
									<span>&nbsp; Choose Skin</span>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox"
										class="ace ace-checkbox-2 ace-save-state"
										id="ace-settings-navbar" autocomplete="off" /> <label
										class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox"
										class="ace ace-checkbox-2 ace-save-state"
										id="ace-settings-sidebar" autocomplete="off" /> <label
										class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox"
										class="ace ace-checkbox-2 ace-save-state"
										id="ace-settings-breadcrumbs" autocomplete="off" /> <label
										class="lbl" for="ace-settings-breadcrumbs"> Fixed
										Breadcrumbs</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2"
										id="ace-settings-rtl" autocomplete="off" /> <label
										class="lbl" for="ace-settings-rtl"> Right To Left
										(rtl)</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox"
										class="ace ace-checkbox-2 ace-save-state"
										id="ace-settings-add-container" autocomplete="off" /> <label
										class="lbl" for="ace-settings-add-container"> Inside <b>.container</b>
									</label>
								</div>
							</div>
							<!-- /.pull-left -->

							<div class="pull-left width-50">
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2"
										id="ace-settings-hover" autocomplete="off" /> <label
										class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2"
										id="ace-settings-compact" autocomplete="off" /> <label
										class="lbl" for="ace-settings-compact"> Compact
										Sidebar</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2"
										id="ace-settings-highlight" autocomplete="off" /> <label
										class="lbl" for="ace-settings-highlight"> Alt. Active
										Item</label>
								</div>
							</div>
							<!-- /.pull-left -->
						</div>
						<!-- /.ace-settings-box -->
					</div>
					<!-- /.ace-settings-container -->

					<div class="page-header">
						<h1>Product detail</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->

							<div>
								<div id="user-profile-1" class="user-profile row">
									<div class="col-xs-12 col-sm-3 center">
										<div>
											<span class="profile-picture"> <img id="avatar"
												class="editable img-responsive" alt="Alex's Avatar"
												src="${pageContext.request.contextPath }/${image}"
												width="400" height="400" />
											</span>
											<div class="space-4"></div>
										</div>


									</div>

									<div class="col-xs-12 col-sm-9">

										<div class="profile-user-info profile-user-info-striped">

											<div class="profile-info-row">
												<div class="profile-info-name">Id</div>

												<div class="profile-info-value">
													<span class="editable" id="id">${product.id }</span>
												</div>
											</div>
											<div class="profile-info-row">
												<div class="profile-info-name">Name</div>

												<div class="profile-info-value">
													<span class="editable" id="name">${product.name }</span>
												</div>
											</div>
											<div class="profile-info-row">
												<div class="profile-info-name">Price</div>

												<div class="profile-info-value">
													<span class="editable" id="price">${product.price }</span>
												</div>
											</div>
											<div class="profile-info-row">
												<div class="profile-info-name">Size</div>

												<div class="profile-info-value">
													<span class="editable" id="size">${product.size }</span>
												</div>
											</div>
											<div class="profile-info-row">
												<div class="profile-info-name">Color</div>

												<div class="profile-info-value">
													<span class="editable" id="color">${color.name }</span>
												</div>
											</div>
											<div class="profile-info-row">
												<div class="profile-info-name">Category</div>

												<div class="profile-info-value">
													<span class="editable" id="category">${category.name }</span>
												</div>
											</div>
											<div class="profile-info-row">
												<div class="profile-info-name">Brand</div>

												<div class="profile-info-value">
													<span class="editable" id="brand">${brand.name }</span>
												</div>
											</div>
											<div class="profile-info-row">
												<div class="profile-info-name">Amount</div>

												<div class="profile-info-value">
													<span class="editable" id="amount">${product.amount }</span>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- PAGE CONTENT ENDS -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->

		<div class="footer">
			<div class="footer-inner">
				<div class="footer-content">
					<span class="bigger-120"> <span class="blue bolder">Web</span>
						Application Team 1 &copy; 2021-2022
					</span> &nbsp; &nbsp;
				</div>
			</div>
		</div>

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script
		src="${pageContext.request.contextPath }/assets/js/jquery-2.1.4.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script
		src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
	<script
		src="${pageContext.request.contextPath }/assets/js/jquery-ui.custom.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/jquery.gritter.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bootbox.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/jquery.easypiechart.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/bootstrap-datepicker.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/jquery.hotkeys.index.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/bootstrap-wysiwyg.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/select2.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/spinbox.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/bootstrap-editable.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace-editable.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/jquery.maskedinput.min.js"></script>

	<!-- ace scripts -->
	<script
		src="${pageContext.request.contextPath }/assets/js/ace-elements.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/ace.min.js"></script>



</body>
</html>
