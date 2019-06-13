function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			jQuery('#imagePreview').css('background-image',
				'url(' + e.target.result + ')');
			jQuery('#imagePreview').hide();
			jQuery('#imagePreview').fadeIn(650);
			jQuery("input[name$='update_img']").val(true);
		}
		reader.readAsDataURL(input.files[0]);
	}
}
jQuery("#imageUpload").change(function() {
	readURL(this);
});
jQuery("form[name$='perfilUrl'] button[type='submit']").click(
	function() {
		$(this).parent("form").find("input[name$='action']").val(
			$(this).hasClass("update"))
	});

jQuery('#popUp').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	var recipient = button.data('whatever');
	var modal = $(this);
	modal.find('.modal-title').text('New message to ' + recipient);
	modal.find('.modal-body input').val(recipient);
});

jQuery("button[data-toggle='modal']").click(function() {
	jQuery(this.dataset.target).css("position", "fixed").css("z-index", "1050");
});

var ccList = [];
jQuery("input[name$='ccEmail'").keypress(
	function(e) {
		var coma = e.keyCode ? e.keyCode : e.which;
		if (validateEmail(this.value) && coma == 44
			&& !ccList.includes(this.value)) {
			var div = '<div class="emailContainer"><span><div>'
		+ this.value + '</div><div></div></span><input name="'
		+ this.name + '" type="hidden" value="' + this.value
		+ '"/></div>';

		ccList.push(this.value);
		this.value = "";
		jQuery(".ccRow").append(div);
		return false
	}
});

jQuery(document).on("click", ".emailContainer span div:last-child", function() {
	jQuery(this).parents(".emailContainer").remove();
});

jQuery(".enviar").click(function () {
	jQuery("form[name$='contactProfile']").submit();
});

jQuery(".clearForm").click(function () {
	jQuery(".ccRow").empty();
	jQuery("form[name$='contactProfile']").tigger("reset");
});

jQuery("form[name$='contactProfile']").submit(function(e) {
	var data, xhr;
	data = new FormData();
	jQuery.each(this.elements, function(e, i) {
		if ((i.type == "text" || i.type == "textarea" || i.type == "hidden") && i.value != "") {
			data.append(i.name, i.value);
		} else if (i.type == "file" && i.files.length > 0) {
			data.append(i.name, i.files[0]);
		}
	});

	xhr = new XMLHttpRequest();

	xhr.open('POST', this.action, true);
	xhr.onreadystatechange = function(response) {
		if(this.status){
			
		}
	};
	xhr.send(data);
	e.preventDefault();
	return false;
});

function validateEmail(email) {
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(String(email).toLowerCase());
}