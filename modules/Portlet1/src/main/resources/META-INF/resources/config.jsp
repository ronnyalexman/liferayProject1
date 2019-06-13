<%@ include file="/init.jsp"%>
<liferay-portlet:actionURL var='url' portletConfiguration="true" />

<div style='background-color: #fff; padding: 30px;'>

	<aui:form action="${url}" name="contactProfile">
		<aui:fieldset label="portletvass.config.title">

			<aui:input name="pie" type="text" label="portletvass.config.pie"
				value="${pie}" />

			<aui:input name="folderDescription" type="text"
				label="portletvass.config.folderDescription"
				value="${folderDescription}" />

			<aui:input name="subject" type="text"
				label="portletvass.config.subject" value="${subject}" />

			<aui:button-row>
				<aui:button type="submit" value="portletvass.config.guardar"></aui:button>
			</aui:button-row>

		</aui:fieldset>
	</aui:form>
</div>