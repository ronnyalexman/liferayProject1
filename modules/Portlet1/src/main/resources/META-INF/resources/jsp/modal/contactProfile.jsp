<jsp:useBean id="contactProfile" class="java.util.HashMap" scope="request" />
<c:set target="${contactProfile}" property="dismiss" value="modal" />

<portlet:actionURL var="sendEmail" name="sendEmail" />

<div class="modal fade" id="contactProfile" tabindex="-1" role="dialog"
	style="position: relative" aria-labelledby="contactProfileLabel"
	aria-hidden="true">
	<div class="modal-dialog contactProfile" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="contactProfileLabel">
					<liferay-ui:message key="portletvass.contactProfile.title" />
					${cliente.nombre} ${cliente.apellidos}
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<aui:form action="${sendEmail}" name="contactProfile"
					enctype="multipart/form-data">

					<aui:input name="fromEmail" type="text"
						label="portletvass.contactProfile.from" />

					<aui:input name="toEmailReadOnly" type="text" disabled="true"
						label="portletvass.contactProfile.to" value="${cliente.email}" />

					<aui:input name="toEmail" type="hidden" value="${cliente.email}" />
					<aui:input name="nombreEmail" type="hidden"
						value="${cliente.nombre} ${cliente.apellidos}" />

					<aui:input name="ccEmail" type="text"
						label="portletvass.contactProfile.cc" />

					<aui:row cssClass="ccRow" />
					<aui:input name="fileEmail" type="file"
						label="portletvass.contactProfile.adjuntar" />

					<aui:input name="messageEmail" type="textarea"
						label="portletvass.contactProfile.mensaje" />

					<aui:button-row>
						<aui:button type="button" value="portletvass.contactProfile.send"
							data="${contactProfile}" cssClass="btn btn-primary enviar"></aui:button>
						<aui:button type="button" cssClass="btn btn-danger"
							value="portletvass.contactProfile.cancel" data="${contactProfile}"></aui:button>
						<aui:button type="button" cssClass="btn btn-light clearForm"
							value="portletvass.contactProfile.clear"></aui:button>
					</aui:button-row>
				</aui:form>
			</div>
		</div>
	</div>
</div>