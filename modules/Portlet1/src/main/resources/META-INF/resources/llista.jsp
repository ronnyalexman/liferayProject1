<%@ include file="/init.jsp"%>

<portlet:actionURL var="homeUrl" name="homeRedirect" />
<portlet:actionURL var="perfilUrl" name="actionRedirect" />

<aui:button-row>
	<h2>
		<aui:button cssClass="btn btn-info" type="button"
			icon="icon-chevron-left" href="${homeUrl}" />

		<liferay-ui:message key="portletvass.llista.title" />
	</h2>
</aui:button-row>

<c:choose>
	<c:when test="${fn:length(clientes) > 0}">
		<table class="table">
			<thead>
				<tr>
					<th><liferay-ui:message
							key="portletvass.llista.table.fullName" /></th>
					<th><liferay-ui:message key="portletvass.llista.table.nif" /></th>
					<th><liferay-ui:message key="portletvass.llista.table.email" /></th>
					<th><liferay-ui:message key="portletvass.llista.table.tools" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clientes}" var="c">
					<tr>
						<td>${c.nombre}${c.apellidos}</td>
						<td>${c.nif}</td>
						<td>${c.email}</td>
						<td><aui:button-row>
								<aui:form action="${perfilUrl}" name="perfilUrl">
									<aui:input name="email" type="hidden" value="${c.email}" />
									<aui:input name="update" type="hidden" value="1" />

									<aui:button cssClass="btn btn-primary update" type="submit"
										icon="icon-pencil" value="" />
									<aui:button cssClass="btn btn-danger delete" type="submit"
										icon="icon-trash" value="" />
								</aui:form>
							</aui:button-row></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>

	</c:otherwise>
</c:choose>
