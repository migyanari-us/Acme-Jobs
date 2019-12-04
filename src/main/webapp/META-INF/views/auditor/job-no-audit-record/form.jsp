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

<acme:form>

	<acme:form-textbox code="auditor.job-audit-record.form.label.reference" path="reference" />
	<acme:form-textbox code="auditor.job-audit-record.form.label.status" path="status" />
	<acme:form-textbox code="auditor.job-audit-record.form.label.title" path="title" />
	<acme:form-moment code="auditor.job-audit-record.form.label.deadline" path="deadline" />
	<acme:form-textbox code="auditor.job-audit-record.form.label.salary" path="salary" />
	<acme:form-url code="auditor.job-audit-record.form.label.moreInfo" path="moreInfo" />

	<acme:form-return code="auditor.job-audit-record.form.button.return" />
</acme:form>
