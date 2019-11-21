<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="anonymous.company.form.label.name" path="name" />
	<acme:form-textbox code="anonymous.company.form.label.sector" path="sector" />
	<acme:form-textbox code="anonymous.company.form.label.ceo" path="ceo" />
	<acme:form-textarea code="anonymous.company.form.label.activities" path="activities" />
	<acme:form-url code="anonymous.company.form.label.web" path="web" />
	<acme:form-textbox code="anonymous.company.form.label.phone" path="phone" />
	<acme:form-textbox code="anonymous.company.form.label.email" path="email" />
	<acme:form-checkbox code="anonymous.company.form.label.incorporated" path="incorporated" />
	<acme:form-integer code="anonymous.company.form.label.stars" path="stars" />
	
	<acme:form-return code="anonymous.company.form.button.return" />
</acme:form>
