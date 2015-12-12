var window = new Object();
window.document = document;

window.location = {
	href:"https://www.google.com/"
};

window.addEventListener = function() {

};

Function.prototype.__noSuchProperty__=function(n) {
    print("No such property: " + n+" in object "+this.constructor.name);
};

Function.prototype.__noSuchMethod__=function() {
    for (i in arguments) {
       print(arguments[i]);
    }
};


var origSlice = Array.prototype.slice;
Array.prototype.slice = function () {
    if(arguments.length==0) {
    	return this;
    }
    return origSlice.apply(this, arguments);
}