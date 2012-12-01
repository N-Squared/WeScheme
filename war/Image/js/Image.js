/*//Image JavaScript File

var	initImage = (function () {
	alert("itachi");
	var blargh = function () { alert("blaserkhglkasdjfd"); }

	return initializeImage;
});*/

var	initImage = function(editor) {

	var testFn = function () { alert("hai"); }

	var showFn = function() {
		pos = editor.getCursor(true);		// get the current cursor location
		pos.ch = 0;							// force the character to 0
		var node = document.getElementById('picker-form');
		editor.addWidget(pos, node, true);	// display the DR widget just below the line, and scroll so it's visible
    };

	var hideFn = function() {
		clearForm(); //flush
		document.getElementById('picker-form').style.left = '-1000px';
		editor.setLineClass(hlLine, ""); //herp?
		editor.focus();
	}

	var addFn = function() {
		//gets filename, sends it to database for processing
		//var result = document.getElementById('picker-browser-result').value;
		//don't use value - only gives last part of link; use ajax stuff instead
		/*var url= "http://localhost:80/....";
		$(document).ready(function(){
			document.getElementById('upload').addEventListener('change', function(e) {
			var file = this.files[0];
			var xhr = new XMLHttpRequest();
			var formData = new FormData();
formData.append("thefile", file);
xhr.send(formData);
    xhr.addEventListener('progress', function(e) {
    var done = e.position || e.loaded, total = e.totalSize || e.total;
    console.log('xhr progress: ' + (Math.floor(done/total*1000)/10) + '%');
}, false);*/
		//then send result to database
		//console.log(result); //for debugging
		//herp derp ajax.
	}

	var clearForm = function () {
		//clears the value of picker-browser-result
		document.getElementById('picker-browser-result').value = "";
	}

	/*var iterateFn = function(var array) {
		for(var i = 0; i < array.length; i++) {
			displayFn(array[i]);
		}
	}

	var displayFn = function(var src) {
		var image = document.createElement("img");
		image.src = src;
		
    	document.body.appendChild(image);
	}*/

	document.getElementById('picker-close').onclick = hideFn;
	document.getElementById('picker-browser-add').onclick = addFn;
	
	return {showPicker: showFn,
			hidePicker: hideFn,
			pickerAdd: addFn/*,
			test: testFn*/ };
}  

