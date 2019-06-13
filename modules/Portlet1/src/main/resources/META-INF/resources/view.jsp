<%@ include file="/init.jsp"%>

<portlet:resourceURL var="exportUrl">
	<portlet:param name="action" value="exportJSON" />
</portlet:resourceURL>

<portlet:actionURL var="altaUrl" name="createRedirect" />
<portlet:actionURL var="llistaUrl" name="readRedirect" />

<portlet:actionURL var="emailUrl" name="emailTest" />

<aui:container>
	<aui:row>
		<aui:col lg="12" md="12" sm="12" xs="12">
			<h1>
				<liferay-ui:message key="portletvass.view.welcome" />${userName}
			</h1>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col lg="12" md="12" sm="12" xs="12">
			<h2>
				<liferay-ui:message key="portletvass.view.whatToDo" />
			</h2>
		</aui:col>
	</aui:row>

	<aui:row>
		<aui:col lg="12" md="12" sm="12" xs="12">
			<ul class="list-unstyled">
				<li><c:if test="${altaPermission}">
						<liferay-ui:icon image="add" />
						<a href="${altaUrl}"> <liferay-ui:message
								key="portletvass.view.alta" />
						</a>
					</c:if></li>
				<li><liferay-ui:icon image="view_articles" /> <a
					href="${llistaUrl}">Llista clientes</a></li>
				<li><liferay-ui:icon image="drive" /> <a download
					href="${exportUrl}">Exportar JSON de clientes</a></li>
			</ul>
		</aui:col>
	</aui:row>

	<p>${pie}</p>
	<p>
		<aui:form action="${emailUrl}" name="test">
			<aui:input name="email" type="text" />
			<aui:button-row>
				<aui:button type="submit" value="portletvass.alta.guardar"></aui:button>
			</aui:button-row>
		</aui:form>
	</p>
</aui:container>
<script>
	(function() {

	})();
</script>

