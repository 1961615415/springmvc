$.validator.setDefaults({
	onkeyup : false,
	ignore : ".ignore",
	errorPlacement : function(lable, element) {
		$(element).closest("tr").find(".err").html(lable.html());
	},
	success : function(lable) {

	},
	submitHandler : function(form) {
		form.submit();
	}
});