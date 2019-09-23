print('Hello from JS file');

function calculate(number1, number2) {
	return number1 + number2;
}

var threadImpl = {
	run : function() {
		for (var i = 0; i < 20; i++) {
			print("printing " + i);
		}
	}
}