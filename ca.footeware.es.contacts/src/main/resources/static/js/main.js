function cancelAddContact() {
	window.location.href = "/";
}

function saveContact() {
	document.getElementById("contactForm").submit();
}

function deleteContact(id) {
	if (confirm("Are you sure?")) {
		var url = "http://localhost:8080/contacts/" + id;
		var xhr = new XMLHttpRequest();
		xhr.open("DELETE", url, true);
		xhr.onload = function() {
			if (xhr.readyState == 4 && xhr.status == "200") {
				window.location.href = "/";
			} else {
				alert(xhr.responseText);
			}
		}
		xhr.send();
	}
}

function editContact(id) {
	var url = "http://localhost:8080/contacts/" + id;
	var xhr = new XMLHttpRequest();
	xhr.open("PUT", url, true);
	xhr.onload = function() {
		if (xhr.readyState == 4 && xhr.status == "200") {
			var doc = xhr.responseText;
			window.document.write(doc);
		} else {
			alert(xhr.responseText);
		}
	}
	xhr.send();
}
