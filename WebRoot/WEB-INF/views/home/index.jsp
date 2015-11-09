<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/includes/include.jsp"%>
<script type="text/javascript"
	src="${ctx}/static/js/demo.formelements.js"></script>
<title>职业卫生监测管理平台</title>
</head>

<body>

	<div id="mws-themer">
		<div id="mws-themer-hide"></div>
		<div id="mws-themer-content">
			<div class="mws-themer-section">
				<label for="mws-theme-presets">Presets</label> <select
					id="mws-theme-presets"></select>
			</div>
			<div class="mws-themer-separator"></div>
			<div class="mws-themer-section">
				<ul>
					<li><span>Base Color</span>
						<div id="mws-base-cp" class="mws-cp-trigger"></div></li>
					<li><span>Text Color</span>
						<div id="mws-text-cp" class="mws-cp-trigger"></div></li>
					<li><span>Text Glow Color</span>
						<div id="mws-textglow-cp" class="mws-cp-trigger"></div></li>
				</ul>
			</div>
			<div class="mws-themer-separator"></div>
			<div class="mws-themer-section">
				<ul>
					<li><span>Text Glow Opacity</span>
						<div id="mws-textglow-op"></div></li>
				</ul>
			</div>
			<div class="mws-themer-separator"></div>
			<div class="mws-themer-section">
				<button class="mws-button red small" id="mws-themer-getcss">Get
					CSS</button>
			</div>
		</div>
		<div id="mws-themer-css-dialog">
			<div class="mws-form">
				<div class="mws-form-row" style="padding: 0;">
					<div class="mws-form-item">
						<textarea cols="auto" rows="auto" readonly="readonly"></textarea>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 页面顶部 -->
	<%@ include file="/WEB-INF/includes/header.jsp"%>



	<div id="mws-wrapper">

		<!-- 页面左侧菜单 -->
		<%@ include file="/WEB-INF/includes/menu.jsp"%>

		<!-- 页面主体  -->
		<div id="mws-container" class="clearfix">
			<div class="container">

				<div class="mws-report-container clearfix">
					<a class="mws-report" href="#"> <span
						class="mws-report-icon mws-ic ic-building"></span> <span
						class="mws-report-content"> <span class="mws-report-title">Floors
								Climbed</span> <span class="mws-report-value">324</span>
					</span>
					</a> <a class="mws-report" href="#"> <span
						class="mws-report-icon mws-ic ic-sport"></span> <span
						class="mws-report-content"> <span class="mws-report-title">Calories
								Burned</span> <span class="mws-report-value down">74%</span>
					</span>
					</a> <a class="mws-report" href="#"> <span
						class="mws-report-icon mws-ic ic-walk"></span> <span
						class="mws-report-content"> <span class="mws-report-title">Kilometers
								Walked</span> <span class="mws-report-value">14</span>
					</span>
					</a> <a class="mws-report" href="#"> <span
						class="mws-report-icon mws-ic ic-bug"></span> <span
						class="mws-report-content"> <span class="mws-report-title">Bugs
								Fixed</span> <span class="mws-report-value up">22%</span>
					</span>
					</a> <a class="mws-report" href="#"> <span
						class="mws-report-icon mws-ic ic-car"></span> <span
						class="mws-report-content"> <span class="mws-report-title">Cars
								Repaired</span> <span class="mws-report-value">77</span>
					</span>
					</a>
				</div>

				<div class="mws-panel grid_4">
					<div class="mws-panel-header">
						<span class="mws-i-24 i-pencil">Text Inputs</span>
					</div>
					<div class="mws-panel-body">
						<form class="mws-form"
							action="http://www.malijuwebshop.com/themes/mws-admin/form_elements.html">
							<div class="mws-form-inline">
								<div class="mws-form-row">
									<label>Text Field</label>
									<div class="mws-form-item large">
										<input type="text" class="mws-textinput" />
									</div>
								</div>

								<div class="mws-form-row">
									<label>Password Field</label>
									<div class="mws-form-item large">
										<input type="password" class="mws-textinput" />
									</div>
								</div>

								<div class="mws-form-row">
									<label>Disabled Field</label>
									<div class="mws-form-item large">
										<input type="text" class="mws-textinput" disabled="disabled" />
									</div>
								</div>

								<div class="mws-form-row">
									<label>Read only Field</label>
									<div class="mws-form-item large">
										<input type="text" class="mws-textinput"
											value="this is a readonly field" readonly="readonly" />
									</div>
								</div>

								<div class="mws-form-row">
									<label>With Placeholder</label>
									<div class="mws-form-item large">
										<input type="text" class="mws-textinput"
											placeholder="your placeholder text" />
									</div>
								</div>

								<div class="mws-form-row">
									<label>Input with Tooltip</label>
									<div class="mws-form-item large">
										<input type="text" class="mws-textinput"
											title="input your email" />
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>

				<div class="mws-panel grid_4">
					<div class="mws-panel-header">
						<span class="mws-i-24 i-eyedropper">Custom Inputs</span>
					</div>
					<div class="mws-panel-body">
						<form class="mws-form"
							action="http://www.malijuwebshop.com/themes/mws-admin/form_elements.html">
							<div class="mws-form-inline">
								<div class="mws-form-row">
									<label>Basic Spinner</label>
									<div class="mws-form-item">
										<input type="text" id="s1" class="mws-textinput" value="10" />
									</div>
								</div>
								<div class="mws-form-row">
									<label>Decimal Spinner</label>
									<div class="mws-form-item">
										<input type="text" id="s2" class="mws-textinput" value="10" />
									</div>
								</div>
								<div class="mws-form-row">
									<label>Currency Spinner</label>
									<div class="mws-form-item">
										<input type="text" id="s3" class="mws-textinput" value="10" />
									</div>
								</div>
								<div class="mws-form-row">
									<label>Colorpicker</label>
									<div class="mws-form-item small">
										<input type="text" class="mws-textinput mws-colorpicker" />
									</div>
								</div>
								<div class="mws-form-row">
									<label>File Input</label>
									<div class="mws-form-item large">
										<input type="file" class="mws-textinput" />
									</div>
								</div>
								<div class="mws-form-row">
									<label>Autocomplete</label>
									<div class="mws-form-item large">
										<input type="text" class="mws-autocomplete mws-textinput" />
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>

				<div class="mws-panel grid_8">
					<div class="mws-panel-header">
						<span class="mws-i-24 i-list">Select Inputs</span>
					</div>
					<div class="mws-panel-body">
						<form class="mws-form"
							action="http://www.malijuwebshop.com/themes/mws-admin/form_elements.html">
							<div class="mws-form-inline">
								<div class="mws-form-row">
									<label>Select Input</label>
									<div class="mws-form-item small">
										<select>
											<option>Option 1</option>
											<option>Option 3</option>
											<option>Option 4</option>
											<option>Option 5</option>
										</select>
									</div>
								</div>

								<div class="mws-form-row">
									<label>Multiple Selects</label>
									<div class="mws-form-item small">
										<select multiple="multiple" size="10">
											<option selected="selected">Option 1</option>
											<option>Option 2</option>
											<option>Option 3</option>
											<option>Option 4</option>
											<option>Option 5</option>
											<option>Option 6</option>
											<option selected="selected">Option 7</option>
											<option selected="selected">Option 8</option>
											<option>Option 9</option>
											<option>Option 10</option>
										</select>
									</div>
								</div>

								<div class="mws-form-row">
									<label>Dual List Box</label>
									<div class="mws-form-item large">
										<div class="mws-dualbox clearfix">
											<div class="mws-dualbox-col1">
												<div class="mws-dualbox-filter clearfix">
													<label for="box1Filter">Filter</label> <input type="text"
														id="box1Filter" class="mws-textinput" />
													<button type="button" id="box1Clear">X</button>
												</div>

												<select id="box1View" multiple="multiple" size="15">
													<option value="501649">2008-2009 "Mini" Baja</option>
													<option value="501497">AAPA - Asian American
														Psychological Association</option>
													<option value="501053">Academy of Film Geeks</option>
													<option value="500001">Accounting Association</option>
													<option value="501227">ACLU</option>
													<option value="501610">Active Minds</option>
													<option value="501514">Activism with A Reel Edge
														(A.W.A.R.E.)</option>
													<option value="501656">Adopt a Grandparent Program</option>
													<option value="501050">Africa Awareness Student
														Organization</option>
													<option value="501075">African Diasporic Cultural
														RC Interns</option>
													<option value="501493">Agape</option>
													<option value="501562">AGE-Alliance for Graduate
														Excellence</option>
													<option value="500676">AICHE (American Inst of
														Chemical Engineers)</option>
													<option value="501460">AIDS Sensitivity Awareness
														Project ASAP</option>
													<option value="500004">Aikido Club</option>
													<option value="500336">Akanke</option>
												</select> <span id="box1Counter" class="countLabel"></span> <select
													id="box1Storage"></select>
											</div>
											<div class="mws-dualbox-col2">
												<button id="to2" type="button">&gt;</button>
												<button id="allTo2" type="button">&gt;&gt;</button>
												<div class="clear"></div>
												<button id="allTo1" type="button">&lt;&lt;</button>
												<button id="to1" type="button">&lt;</button>
											</div>
											<div class="mws-dualbox-col3">
												<div class="mws-dualbox-filter clearfix">
													<label for="box2Filter">Filter</label> <input type="text"
														id="box2Filter" class="mws-textinput" />
													<button type="button" id="box2Clear">X</button>
												</div>

												<select id="box2View" multiple="multiple" size="15"></select>
												<span id="box2Counter" class="countLabel"></span> <select
													id="box2Storage"></select>
											</div>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>

				<div class="mws-panel grid_8">
					<div class="mws-panel-header">
						<span class="mws-i-24 i-text-styling-3">WYSIWYG + File
							Manager (Try Inserting an Image)</span>
					</div>
					<div class="mws-panel-body">
						<form class="mws-form"
							action="http://www.malijuwebshop.com/themes/mws-admin/form_elements.html">
							<div class="mws-form-row">
								<label>WYSIWYG</label>
								<div class="mws-form-item">
									<textarea id="elrte" cols="auto" rows="auto"></textarea>
								</div>
							</div>
							<div class="mws-button-row">
								<input type="submit" value="Submit" class="mws-button red" />
							</div>
						</form>
					</div>
				</div>

				<div class="mws-panel grid_8">
					<div class="mws-panel-header">
						<span class="mws-i-24 i-check">Validation</span>
					</div>
					<div class="mws-panel-body">
						<form id="mws-validate" class="mws-form"
							action="http://www.malijuwebshop.com/themes/mws-admin/form_elements.html">
							<div id="mws-validate-error" class="mws-form-message error"
								style="display: none;"></div>
							<div class="mws-form-inline">
								<div class="mws-form-row">
									<label>Required Validation</label>
									<div class="mws-form-item large">
										<input type="text" name="reqField"
											class="mws-textinput required" />
									</div>
								</div>
								<div class="mws-form-row">
									<label>Email Validation</label>
									<div class="mws-form-item large">
										<input type="text" name="emailField"
											class="mws-textinput required email" />
									</div>
								</div>
								<div class="mws-form-row">
									<label>URL Validation</label>
									<div class="mws-form-item large">
										<input type="text" name="urlField"
											class="mws-textinput required url" />
									</div>
								</div>
								<div class="mws-form-row">
									<label>Digit Validation</label>
									<div class="mws-form-item large">
										<input type="text" name="ageField"
											class="mws-textinput required digits" />
									</div>
								</div>
								<div class="mws-form-row">
									<label>Select Box Validation</label>
									<div class="mws-form-item large">
										<select class="required" name="selectBox">
											<option></option>
											<option>Option 1</option>
											<option>Option 3</option>
											<option>Option 4</option>
											<option>Option 5</option>
										</select>
									</div>
								</div>
							</div>
							<div class="mws-button-row">
								<input type="submit" class="mws-button red" />
							</div>
						</form>
					</div>
				</div>
			</div>

			<!-- 页面底部 -->
			<%@ include file="/WEB-INF/includes/footer.jsp"%>

		</div>
	</div>

</body>
</html>
