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
	<acme:form-textbox code="anonymous.investor-record.form.label.investor" path="investor" />
	<acme:form-moment code="anonymous.investor-record.form.label.sector" path="sector" />
	<acme:form-url code="anonymous.investor-record.form.label.investingStatement" path="investingStatement" />
	<acme:form-textarea code="anonymous.investor-record.form.label.stars" path="stars" />
	
	<acme:form-return code="anonymous.investor-record.form.button.return" />
</acme:form>
