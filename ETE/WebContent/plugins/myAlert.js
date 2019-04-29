function alert(e) {

	$("body")
			.append(
					'<div id="msg"><div id="msg_top">提示<span class="msg_close">×</span></div><div id="msg_cont">'
							+ e
							+ '</div><div class="msg_close" id="msg_clear">确定</div></div>');
	$(".msg_close").click(function() {
		$("#msg").remove();
	});
}
